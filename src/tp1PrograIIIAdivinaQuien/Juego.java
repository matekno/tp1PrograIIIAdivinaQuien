package tp1PrograIIIAdivinaQuien;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Juego {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		RepositorioPuntajes repositorio = new RepositorioPuntajes("puntajes.txt");
 
		int opcion = -1;
		while (opcion != 0) {
			System.out.println();
			System.out.println("1 - Humano vs maquina");
			System.out.println("2 - Maquina vs maquina");
			System.out.println("3 - Ver puntajes");
			System.out.println("0 - Salir");
			opcion = Integer.parseInt(scanner.nextLine());
 
			if (opcion == 1 || opcion == 2) {
				Jugador ganador = jugarPartida(opcion, scanner, random);
				System.out.println("Gano " + ganador.getNombre());
				registrarVictoria(repositorio, ganador.getNombre());
			} else if (opcion == 3) {
				mostrarPuntajes(repositorio);
			}
		}
	}
 
	private static Jugador jugarPartida(int modo, Scanner scanner, Random random) {
		List<Personaje> elencoA = PersonajeFactory.crearTableroInicial();
		List<Personaje> elencoB = PersonajeFactory.crearTableroInicial();
 
		Jugador jugadorA;
		Jugador jugadorB;
		Personaje secretoB = elencoB.get(random.nextInt(elencoB.size()));
 
		if (modo == 1) {
			System.out.println("Ingresa tu nombre:");
			String nombre = scanner.nextLine();
 
			for (Personaje personaje : elencoA) {
				System.out.println(personaje);
			}
			System.out.println("Id de tu personaje:");
			int idElegido = Integer.parseInt(scanner.nextLine());
			Personaje secretoA = elencoA.get(idElegido - 1);
 
			jugadorA = new JugadorHumano(nombre, secretoA, new Tablero(elencoB), scanner);
			jugadorB = crearMaquina("Maquina", secretoB, elencoA, scanner);
		} else {
			Personaje secretoA = elencoA.get(random.nextInt(elencoA.size()));
 
			jugadorA = crearMaquina("ALPHA", secretoA, elencoB, scanner);
			jugadorB = crearMaquina("BETA", secretoB, elencoA, scanner);
 
			System.out.println("Secreto de ALPHA: " + secretoA);
			System.out.println("Secreto de BETA: " + secretoB);
		}
 
		Partida partida;
		if (random.nextBoolean()) {
			partida = new Partida(jugadorA, jugadorB);
		} else {
			partida = new Partida(jugadorB, jugadorA);
		}
		return partida.jugar();
	}
 
	private static Jugador crearMaquina(String nombre, Personaje secreto, List<Personaje> elencoRival, Scanner scanner) {
		System.out.println("Estrategia de " + nombre + ":");
		System.out.println("1 - Acertiva");
		System.out.println("2 - Random");
		int opcion = Integer.parseInt(scanner.nextLine());
 
		System.out.println("Umbral de " + nombre + ":");
		int umbral = Integer.parseInt(scanner.nextLine());
 
		Estrategia estrategia;
		if (opcion == 1) {
			estrategia = new EstrategiaAcertiva(umbral);
		} else {
			estrategia = new EstrategiaRandom(umbral);
		}
		return new JugadorMaquina(nombre, secreto, new Tablero(elencoRival), estrategia);
	}
 
	private static void registrarVictoria(RepositorioPuntajes repositorio, String nombre) {
		List<Puntaje> puntajes = repositorio.cargar();
		Puntaje puntajeDelGanador = null;
		for (Puntaje puntaje : puntajes) {
			if (puntaje.getNombre().equals(nombre)) {
				puntajeDelGanador = puntaje;
			}
		}
		if (puntajeDelGanador == null) {
			puntajeDelGanador = new Puntaje(nombre, 0);
			puntajes.add(puntajeDelGanador);
		}
		puntajeDelGanador.sumarVictoria();
		repositorio.guardar(puntajes);
	}
 
	private static void mostrarPuntajes(RepositorioPuntajes repositorio) {
		List<Puntaje> puntajes = repositorio.cargar();
		if (puntajes.isEmpty()) {
			System.out.println("Todavia no hay puntajes.");
		}
		for (Puntaje puntaje : puntajes) {
			System.out.println(puntaje);
		}
	}
 
}