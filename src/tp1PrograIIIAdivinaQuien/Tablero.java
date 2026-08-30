package tp1PrograIIIAdivinaQuien;

import java.util.ArrayList;
import java.util.List;

// La idea es que cada jugador tenga su tablero propio.
// El objetivo de la clase es manejar el estado de cada jugador, los personajes que quedan vivos, los candidatos, hacerse preguntas, etc, sobre lo que tiene el enemigo.
public class Tablero {

	private List<Personaje> candidatos;

	public Tablero(List<Personaje> personajes) {
		this.candidatos = personajes;
	}

	// Este metodo descarta a todos los personajes que cumplen con la condicion de
	// una pregunta (es el filtro mismo)
	public void descartar(Pregunta pregunta, boolean respuesta) {
		List<Personaje> sobrevivientes = new ArrayList<>();
		for (Personaje personaje : candidatos) {
			if (pregunta.cumple(personaje) == respuesta) {
				sobrevivientes.add(personaje);
			}
		}
		candidatos = sobrevivientes;
	}

	public List<Personaje> getCandidatos() {
		return candidatos;
	}

	@Override
	public String toString() {
		StringBuilder texto = new StringBuilder();
		texto.append("Candidatos vivos: ").append(candidatos.size()).append("\n");
		for (Personaje personaje : candidatos) {
			texto.append(personaje).append("\n");
		}
		return texto.toString();
	}
}
