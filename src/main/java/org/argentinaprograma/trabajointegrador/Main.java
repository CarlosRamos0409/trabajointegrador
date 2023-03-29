package org.argentinaprograma.trabajointegrador;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.opencsv.bean.CsvToBeanBuilder;
import modelo.Pronosticos;
import modelo.ResultadoEnum;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	if (args.length ==0) {
		System.out.println("ERROR: No ingresaste ningún archivo como argumento.");
		System.exit(88);
	}
	
List <ResultadoEnum> listaDeResultados;
List <Pronosticos> listaDePronosticos;
int puntos=0;
try {
	
	
	listaDeResultados = new CsvToBeanBuilder(new FileReader(args[0]))
	.withType(ResultadoEnum.class)
	.build()
	.parse();
	
	listaDePronosticos = new CsvToBeanBuilder(new FileReader(args[1]))
	.withType(Pronosticos.class)
	.build()
	.parse();

	for (ResultadoEnum resultado : listaDeResultados) {
		String equipoGanador;
		
		
		
			if (resultado.getGolesEquipo1() > resultado.getGolesEquipo2()) {
			equipoGanador= resultado.getEquipo1();
			System.out.println("El ganador del partido entre " + resultado.getEquipo1() + " y " +resultado.getEquipo2()  +" fue "  + equipoGanador);
		
			for (Pronosticos pronostico : listaDePronosticos) {
								
				if (!(pronostico.getGanaEquipo1().equals(""))) {
					System.out.println("El apostador acertó el pronóstico.");
					puntos++;
					break;
				}else {
					System.out.println("El apostador NO acertó el pronóstico.");
					break;
				}
				
			}
	
	
		}else if (resultado.getGolesEquipo1() < resultado.getGolesEquipo2()){
			equipoGanador= resultado.getEquipo2();
			System.out.println("El ganador del partido entre " + resultado.getEquipo1() + " y " +resultado.getEquipo2()  +" fue " + equipoGanador);
		
			for (Pronosticos pronostico : listaDePronosticos) {
								
				if (!(pronostico.getGanaEquipo2().equals(""))) {
					System.out.println("El apostador acertó el pronóstico.");
					puntos++;
					break;
				} else {
					System.out.println("El apostador NO acertó el pronóstico.");
					break;
				}
			}
		
		}else{
			System.out.println("El partido entre " + resultado.getEquipo1() + " y " +resultado.getEquipo2() +" fue empate");
		
			for (Pronosticos pronostico : listaDePronosticos) {
								
				if (!(pronostico.getEmpate().equals(""))) {
					System.out.println("El apostador acertó el pronóstico.");
					puntos++;
					break;
				}else {
					System.out.println("El apostador NO acertó el pronóstico.");
					break;
				}
				
			}
		
		}
		
	}
	
	System.out.println("En total el apostador obtuvo " + (puntos) + " aciertos.");
	
}catch (IOException e) {
	e.printStackTrace();
}



	}

}
