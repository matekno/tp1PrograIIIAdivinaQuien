package tp1PrograIIIAdivinaQuien;

import java.util.List;

public class JugadorMaquina extends Jugador {
	private Estrategia estrategia; // Se usa la misma clase JugadorMaquina ya sea que use una u otra estrategia
	private final List<Pregunta> disponibles;

	public JugadorMaquina(String nombre, Personaje personajeSecreto, Tablero tablero, Estrategia estrategia) {
		super(nombre, personajeSecreto, tablero);
		this.disponibles = Pregunta.todasLasPreguntas();
		this.estrategia = estrategia;
	}

	@Override
	public boolean quiereArriesgar() {
		boolean toReturn = false;
		if (estrategia.debeArriesgar(getTableroRival()) == true) {
			toReturn = true;
		} else if (disponibles.isEmpty()) {
			toReturn = true;
		}
		return toReturn;
	}

	@Override
	public Pregunta elegirPregunta() {
		Pregunta pregunta = estrategia.elegirPregunta(getTableroRival(), disponibles);
		disponibles.remove(pregunta);
		return pregunta;
	}

	@Override
	public Personaje arriesgar() {
		return estrategia.elegirApuesta(getTableroRival());

	}

	
}
