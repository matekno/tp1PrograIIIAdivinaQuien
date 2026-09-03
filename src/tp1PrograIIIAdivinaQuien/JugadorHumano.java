package tp1PrograIIIAdivinaQuien;

import java.util.List;
import java.util.Scanner;

public class JugadorHumano extends Jugador {
	private final Scanner scanner;
	private final List<Pregunta> preguntas;

	public JugadorHumano(String nombre, Personaje personajeSecreto, Tablero tablero, Scanner scanner) {
		super(nombre, personajeSecreto, tablero);
		this.scanner = scanner;
		this.preguntas = Pregunta.todasLasPreguntas();
	}

	private int leerInt() {
		return Integer.parseInt(scanner.nextLine());
	}
	
	@Override
	public boolean quiereArriesgar() {
		System.out.println(getTableroRival());
		System.out.println("1 - Preguntar");
		System.out.println("2 - Arriesgar");

		boolean toReturn = false;
		if (leerInt() == 2) {
			toReturn = true;
		}
		return toReturn;
	}

	@Override
	public Pregunta elegirPregunta() {
		for (int i = 0; i < preguntas.size(); i++) {
			System.out.println(i + " - " + preguntas.get(i));
		}
		System.out.println("Numero de pregunta:");
		return preguntas.get(leerInt());
	}


	private Personaje buscarPorId(int id) {
		for (Personaje personaje : getTableroRival().getCandidatos()) {
			if (personaje.getId() == id) {
				return personaje;
			}
		}
		return null;
	}
	
	@Override
	public Personaje arriesgar() {
		System.out.println("Id del personaje:");
		return buscarPorId(leerInt());
	}

}
