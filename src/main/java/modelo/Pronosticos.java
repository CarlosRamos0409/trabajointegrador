package modelo;

import com.opencsv.bean.CsvBindByPosition;

public class Pronosticos {

	@CsvBindByPosition(position = 0)
	private int id;
	
	@CsvBindByPosition(position = 1)
	private String equipo1;
	
	@CsvBindByPosition(position = 2)
	private String ganaEquipo1;
	
	@CsvBindByPosition(position = 3)
	private String empate;
	
	@CsvBindByPosition(position = 4)
	private String ganaEquipo2;
			
	@CsvBindByPosition(position = 5)
	private String equipo2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(String equipo1) {
		this.equipo1 = equipo1;
	}

	public String getGanaEquipo1() {
		return ganaEquipo1;
	}

	public void setGanaEquipo1(String ganaEquipo1) {
		this.ganaEquipo1 = ganaEquipo1;
	}

	public String getEmpate() {
		return empate;
	}

	public void setEmpate(String empate) {
		this.empate = empate;
	}

	public String getGanaEquipo2() {
		return ganaEquipo2;
	}

	public void setGanaEquipo2(String ganaEquipo2) {
		this.ganaEquipo2 = ganaEquipo2;
	}

	public String getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(String equipo2) {
		this.equipo2 = equipo2;
	}

	
	
}
