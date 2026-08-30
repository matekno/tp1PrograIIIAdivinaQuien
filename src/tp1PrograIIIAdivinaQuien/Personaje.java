package tp1PrograIIIAdivinaQuien;

enum ColorDePelo {
	RUBIO, MOROCHO, OTRO_PELO;
}

enum Genero {
	HOMBRE, MUJER, OTRO
}

enum Religion {
	CRISTIANO, JUDIO, ATEO
}


public class Personaje {
	private int id;
	private String nombre;
	private ColorDePelo colorDePelo;
	private boolean tieneLentes;
	private boolean esPelado;
	private Genero genero;
	private Religion religion;

	public Personaje(int id, String nombre, ColorDePelo colorDePelo, boolean tieneLentes, boolean esPelado,
			Genero genero, Religion religion) {
		this.id = id;
		this.nombre = nombre;
		this.colorDePelo = colorDePelo;
		this.tieneLentes = tieneLentes;
		this.esPelado = esPelado;
		this.genero = genero;
		this.religion = religion;
	}
	
	@Override
	public String toString() {
		return id + " - " + nombre
				+ " | " + genero
				+ " | " + (esPelado ? "PELADO" : colorDePelo)
				+ " | " + (tieneLentes ? "con lentes" : "sin lentes")
				+ " | " + religion;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public ColorDePelo getColorDePelo() {
		return colorDePelo;
	}

	public boolean tieneLentes() {
		return tieneLentes;
	}

	public boolean esPelado() {
		return esPelado;
	}

	public Genero getGenero() {
		return genero;
	}

	public Religion getReligion() {
		return religion;
	}
	
	
	

}
