package org.argentinaprograma.trabajointegrador;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.opencsv.bean.CsvToBeanBuilder;
import modelo.Pronosticos;
import modelo.ResultadoEnum;
import modelo.Resultados;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	if (args.length ==0) {
		System.out.println("ERROR: No ingresaste ningún archivo como argumento.");
		System.exit(88);
	}
	
List <Resultados> listaDeResultados;
List <Pronosticos> listaDePronosticos;
int puntos=0;
try {
	
	
	listaDeResultados = new CsvToBeanBuilder(new FileReader(args[0], StandardCharsets.UTF_8))
	.withSkipLines(1)
	.withType(Resultados.class)
	.build()
	.parse();
	
	listaDePronosticos = new CsvToBeanBuilder(new FileReader(args[1], StandardCharsets.UTF_8))
	.withSkipLines(1)
	.withType(Pronosticos.class)
	.build()
	.parse();


    //Creo un tipo de dato hash set, así voy sumando puntos de los participantes.
    Map<String,Integer> puntosParticipantes = new HashMap<String, Integer>();
    
    //Recorro todos los pronosticos
    for(Pronosticos pronostico : listaDePronosticos) {
    	
    	//Primero me fijo si ya tengo agregado al participante
    	if(!puntosParticipantes.containsKey(pronostico.getParticipante())){
    		//si NO esta, lo agrego con 0 puntos
    		puntosParticipantes.put(pronostico.getParticipante(),0);
    	}
    
    	//Busco el partido dentro de resultados
    	for(Resultados resultado : listaDeResultados) {
    		//Busco hasta que los equipos del pronostico sean el mismo del resultado
    		//Osea, busco el partido
    		if(resultado.getEquipo1().equalsIgnoreCase(pronostico.getEquipo1())	&& resultado.getEquipo2().equalsIgnoreCase(pronostico.getEquipo2())) {
    			
    			//Una vez que encuentro el partido, me fijo si pusieron el mismo resultado
    			if(resultado.resultadoEquipo1() == pronostico.resultadoEquipo1()) {
    				//si el pronostico es el mismo, sumo puntos
    				puntosParticipantes.put(pronostico.getParticipante(),
    						//busco los puntos del participante y le sumo 1
    						puntosParticipantes.get(pronostico.getParticipante())+1);   				
    			}
    		}
    	}
    }
    
    //Imprimo en pantalla los puntos calculados
    for(String participante : puntosParticipantes.keySet()) {
    	System.out.println(participante+": "+puntosParticipantes.get(participante));
    }

		
			}catch (IOException e) {
			e.printStackTrace();
		}
	}
}

