package tp1PrograIIIAdivinaQuien;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Esto la verdad que es lo que se me ocurrio. Si se agregara un atributo al Personaje, habria que agregarlo aca.
// TODO: Mejorar
enum Atributo {
	GENERO, COLOR_PELO, RELIGION, LENTES, PELADO
}


// El objetivo de esta clase es convertir un atributo de Personaje en una pregunta concreta booleana
// Todas las preguntas posibles tienen que ser instanciadas, y es lo que el usuario va a invocar.
public class Pregunta {

	private final Atributo atributo;
	private final Object valor;
	private final String texto;

	public Pregunta(Atributo atributo, Object valorEsperado, String texto) {
		this.atributo = atributo;
		this.valor = valorEsperado;
		this.texto = texto;
	}

	public boolean cumple(Personaje personaje) {
		switch (atributo) {
		case GENERO:
			return personaje.getGenero() == valor;
		case COLOR_PELO:
			return personaje.getColorDePelo() == valor;
		case RELIGION:
			return personaje.getReligion() == valor;
		case LENTES:
			return personaje.tieneLentes() == (Boolean) valor;
		case PELADO: // TODO: Sacar el atributo pelado pq se parece mucho al de COLOR_PELO
			return personaje.esPelado() == (Boolean) valor;
		default:
			return false;
		}
	}

	public static List<Pregunta> todasLasPreguntas() {
		List<Pregunta> preguntas = new ArrayList<>();
 
		preguntas.add(new Pregunta(Atributo.GENERO, Genero.HOMBRE, "Es hombre?"));
		preguntas.add(new Pregunta(Atributo.GENERO, Genero.MUJER, "Es mujer?"));
		preguntas.add(new Pregunta(Atributo.GENERO, Genero.OTRO, "Es otro genero?"));
 
		preguntas.add(new Pregunta(Atributo.COLOR_PELO, ColorDePelo.RUBIO, "Es rubio?"));
		preguntas.add(new Pregunta(Atributo.COLOR_PELO, ColorDePelo.MOROCHO, "Es morocho?"));
		preguntas.add(new Pregunta(Atributo.COLOR_PELO, ColorDePelo.OTRO_PELO, "Tiene otro color de pelo?"));
 
		preguntas.add(new Pregunta(Atributo.RELIGION, Religion.CRISTIANO, "Es cristiano?"));
		preguntas.add(new Pregunta(Atributo.RELIGION, Religion.JUDIO, "Es judio?"));
		preguntas.add(new Pregunta(Atributo.RELIGION, Religion.ATEO, "Es ateo?"));
 
		preguntas.add(new Pregunta(Atributo.LENTES, true, "Tiene lentes?"));
		preguntas.add(new Pregunta(Atributo.PELADO, true, "Es pelado?"));
 
		return preguntas;
	}
	

}
