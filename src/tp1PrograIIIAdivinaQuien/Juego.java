package tp1PrograIIIAdivinaQuien;

import java.util.List;

public class Juego {

	public static void main(String[] args) {
		Tablero tablero = new Tablero(PersonajeFactory.crearTableroInicial());
		List<Pregunta> preguntas = Pregunta.todasLasPreguntas();

		System.out.println(tablero);

		tablero.descartar(preguntas.get(0), false); // Es hombre? -> no
		System.out.println(tablero);

		tablero.descartar(preguntas.get(9), false); // Tiene lentes? -> no
		System.out.println(tablero);

		tablero.descartar(preguntas.get(3), true); // Es rubio? -> si
		System.out.println(tablero);
		
	}

}
