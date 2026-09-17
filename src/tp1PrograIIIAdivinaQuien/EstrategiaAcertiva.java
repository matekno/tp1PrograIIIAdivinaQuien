package tp1PrograIIIAdivinaQuien;

import java.util.List;

public class EstrategiaAcertiva implements Estrategia {
	private final int umbral;
	
	public EstrategiaAcertiva(int umbral) {
		this.umbral = umbral;
	}
	
	@Override
	public boolean debeArriesgar(Tablero tablero) { // Funcion Solucion. Cuando quedan n candidatos posibles.
		return tablero.getCandidatos().size() <= umbral;
	}

	@Override
	public Pregunta elegirPregunta(Tablero tablero, List<Pregunta> disponibles) {
		int cantVivos = tablero.getCandidatos().size();
		Pregunta mejorPregunta = null;
		int menorCantDeVivosEnElPeorCaso = cantVivos;
		for (Pregunta pregunta : disponibles) {
			int siCumplen = cuantosCandidatosCumplenLaPregunta(tablero, pregunta);
			int noCumplen = cantVivos - siCumplen;
			
			if(siCumplen > 0 && noCumplen > 0) { // Funcion de factibilidad. la pregunta parte al conjunto de candidatos en dos grupos no vacíos.

				int cantVivosEnPeorCaso = Math.max(siCumplen, noCumplen); // Funcion de seleccion
				if(cantVivosEnPeorCaso < menorCantDeVivosEnElPeorCaso) {
					menorCantDeVivosEnElPeorCaso = cantVivosEnPeorCaso;
					mejorPregunta = pregunta;
				}
			}
		}
		return mejorPregunta;
		
	}
	
	private int cuantosCandidatosCumplenLaPregunta(Tablero tablero, Pregunta pregunta) {
		int cuenta = 0;
		for (Personaje personaje : tablero.getCandidatos()) {
			if (pregunta.cumple(personaje)) {
				cuenta++;
			}
		}
		return cuenta;
	}

	@Override
	public Personaje elegirApuesta(Tablero tablero) {
		return tablero.getCandidatos().get(0);
	}

}
