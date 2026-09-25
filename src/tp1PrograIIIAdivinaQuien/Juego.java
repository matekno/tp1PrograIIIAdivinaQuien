package tp1PrograIIIAdivinaQuien;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Juego {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		List<Personaje> elencoA = PersonajeFactory.crearTableroInicial();
		List<Personaje> elencoB = PersonajeFactory.crearTableroInicial();

		System.out.println("1 - Humano vs maquina");
		System.out.println("2 - Maquina vs maquina");
		int modo = Integer.parseInt(scanner.nextLine());

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

		Jugador ganador = partida.jugar();
		System.out.println("Gano " + ganador.getNombre());
	}

	private static Jugador crearMaquina(String nombre, Personaje secreto, List<Personaje> elencoRival,
			Scanner scanner) {
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

}