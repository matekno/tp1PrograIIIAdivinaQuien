package tp1PrograIIIAdivinaQuien;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Juego {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		List<Personaje> tableroDelHumano = PersonajeFactory.crearTableroInicial();
		List<Personaje> tableroDeLaMaquina = PersonajeFactory.crearTableroInicial();

		System.out.println("Ingresa tu nombre:");
		String nombre = scanner.nextLine();

		for (Personaje personaje : tableroDelHumano) {
			System.out.println(personaje);
		}
		System.out.println("Id de tu personaje:");
		int idElegido = Integer.parseInt(scanner.nextLine());

		Personaje personajeSecretoDelHumano = tableroDelHumano.get(idElegido - 1);
		Personaje personajeSecretoDeLaMaquina = tableroDeLaMaquina.get(random.nextInt(tableroDeLaMaquina.size()));

		Jugador humano = new JugadorHumano(nombre, personajeSecretoDelHumano, new Tablero(tableroDelHumano), scanner);
		Jugador maquina = new JugadorMaquina("Maquina", personajeSecretoDeLaMaquina, new Tablero(tableroDeLaMaquina),
				new EstrategiaRandom(3));

		Jugador ganador = new Partida(humano, maquina).jugar();
		System.out.println("Gano " + ganador.getNombre());
	}

	
	
}