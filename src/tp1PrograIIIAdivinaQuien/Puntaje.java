package tp1PrograIIIAdivinaQuien;

public class Puntaje {
	private final String nombre;
	private int partidasGanadas;

	public Puntaje(String nombre, int partidasGanadas) {
		this.nombre = nombre;
		this.partidasGanadas = partidasGanadas;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPartidasGanadas() {
		return partidasGanadas;
	}

	public void sumarVictoria() {
		partidasGanadas++;
	}

	@Override
	public String toString() {
		return nombre + " - " + partidasGanadas + " ganadas";
	}

}