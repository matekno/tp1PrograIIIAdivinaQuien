package tp1PrograIIIAdivinaQuien;

public class Partida {

	private final Jugador jugador1;
	private final Jugador jugador2;

	public Partida(Jugador jugador1, Jugador jugador2) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
	}

	public Jugador jugar() {
		Jugador turno = jugador1;
		Jugador rival = jugador2;

		while (!jugarTurno(turno, rival)) {
			Jugador aux = turno;
			turno = rival;
			rival = aux;
		}
		return turno;
	}

	private boolean jugarTurno(Jugador jugador, Jugador rival) {
		if (jugador.quiereArriesgar()) {
			Personaje apuesta = jugador.arriesgar();
			System.out.println(jugador.getNombre() + " arriesga: " + apuesta.getNombre());
			return rival.esMiPersonajeSecreto(apuesta);
		}

		Pregunta pregunta = jugador.elegirPregunta();
		boolean respuesta = rival.responder(pregunta);
		jugador.getTableroRival().descartar(pregunta, respuesta);
		mostrarPregunta(jugador, pregunta, respuesta);
		return false;
	}

	private void mostrarPregunta(Jugador jugador, Pregunta pregunta, boolean respuesta) {
		String respuestaTexto;
		if (respuesta == true) {
			respuestaTexto = "SI";
		} else {
			respuestaTexto = "NO";
		}

		System.out.println(jugador.getNombre() + " pregunta: " + pregunta + " -> " + respuestaTexto);
	}
}
