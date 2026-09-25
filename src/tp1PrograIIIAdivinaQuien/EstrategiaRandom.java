package tp1PrograIIIAdivinaQuien;

import java.util.List;
import java.util.Random;

public class EstrategiaRandom implements Estrategia {

	private final Random random = new Random();
	private final int umbral; // Cuando los candidatos llegan al umbral, arriesga directo.

	public EstrategiaRandom(int umbral) {
		this.umbral = umbral;
	}

	@Override
	public boolean debeArriesgar(Tablero tablero) {
		if (tablero.getCandidatos().size() <= umbral) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Pregunta elegirPregunta(Tablero tablero, List<Pregunta> preguntasDisponibles) {
		int i = random.nextInt(preguntasDisponibles.size());
	    Pregunta pregunta = preguntasDisponibles.get(i);
	    reflexionar("Pregunto '" + pregunta + "', elegida al azar entre " + preguntasDisponibles.size() + " preguntas.");
	    return pregunta;
	}

	@Override
	public Personaje elegirApuesta(Tablero tablero) {
		List<Personaje> candidatos = tablero.getCandidatos();
	    int indice = random.nextInt(candidatos.size());
	    return candidatos.get(indice);
	}

}
