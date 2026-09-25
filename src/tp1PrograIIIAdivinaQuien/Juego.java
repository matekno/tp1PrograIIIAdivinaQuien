package tp1PrograIIIAdivinaQuien;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Juego {

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		Random random = new Random();
//
//		List<Personaje> elencoDelHumano = PersonajeFactory.crearTableroInicial();
//		List<Personaje> elencoDeLaMaquina = PersonajeFactory.crearTableroInicial();
//
//		System.out.println("Ingresa tu nombre:");
//		String nombre = scanner.nextLine();
//
//		for (Personaje personaje : elencoDelHumano) {
//			System.out.println(personaje);
//		}
//		System.out.println("Id de tu personaje:");
//		int idElegido = Integer.parseInt(scanner.nextLine());
//
//		Personaje personajeSecretoDelHumano = elencoDelHumano.get(idElegido - 1);
//		Personaje personajeSecretoDeLaMaquina = elencoDeLaMaquina.get(random.nextInt(elencoDeLaMaquina.size()));
//
//		Jugador humano = new JugadorHumano(nombre, personajeSecretoDelHumano, new Tablero(elencoDeLaMaquina), scanner);
//		// Jugador maquina = new JugadorMaquina("Maquina", personajeSecretoDeLaMaquina,
//		// new Tablero(elencoDelHumano), new EstrategiaRandom(3));
//		Jugador maquina = new JugadorMaquina("Maquina", personajeSecretoDeLaMaquina, new Tablero(elencoDelHumano),
//				new EstrategiaAcertiva(3));
//
//		Jugador ganador = new Partida(humano, maquina).jugar();
//		System.out.println("Gano " + ganador.getNombre());
		
		Random random = new Random();
		 
		List<Personaje> elencoAcertiva = PersonajeFactory.crearTableroInicial();
		List<Personaje> elencoRandom = PersonajeFactory.crearTableroInicial();
 
		Personaje secretoAcertiva = elencoAcertiva.get(random.nextInt(elencoAcertiva.size()));
		Personaje secretoRandom = elencoRandom.get(random.nextInt(elencoRandom.size()));
 
		Jugador acertiva = new JugadorMaquina("Acertiva", secretoAcertiva, new Tablero(elencoRandom),
				new EstrategiaAcertiva(3));
		Jugador aleatoria = new JugadorMaquina("Random", secretoRandom, new Tablero(elencoAcertiva),
				new EstrategiaRandom(3));
 
		System.out.println("Secreto de Acertiva: " + secretoAcertiva);
		System.out.println("Secreto de Random: " + secretoRandom);
 
		Partida partida;
		if (random.nextBoolean()) {
			partida = new Partida(acertiva, aleatoria);
		} else {
			partida = new Partida(aleatoria, acertiva);
		}
 
		Jugador ganador = partida.jugar();
		System.out.println("Gano " + ganador.getNombre());
	
	}

}