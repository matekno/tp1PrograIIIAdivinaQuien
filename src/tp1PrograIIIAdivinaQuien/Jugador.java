package tp1PrograIIIAdivinaQuien;

public abstract class Jugador {
	private final String nombre;
	private Personaje personajeSecreto;
	private Tablero tableroRival; // Es el tablero de los candidatos que puede tener el rival
	
	public Jugador(String nombre, Personaje personajeSecreto, Tablero tablero) {
		this.nombre = nombre;
		this.personajeSecreto = personajeSecreto;
		this.tableroRival = tablero;
	}
	
	public boolean responder(Pregunta pregunta) {
		return pregunta.cumple(personajeSecreto);
	}
	
	public boolean esMiPersonajeSecreto(Personaje personaje) {
		return personajeSecreto.getId() == personaje.getId();
	}
	
	public String getNombre() {
		return nombre;
	}
 
	public Tablero getTableroRival() {
		return tableroRival;
	}
	
	public abstract boolean quiereArriesgar(); // En un turno, devuelve true si arriesga, false si pregunta
	 
	public abstract Pregunta elegirPregunta();
 
	public abstract Personaje arriesgar(); 

}
