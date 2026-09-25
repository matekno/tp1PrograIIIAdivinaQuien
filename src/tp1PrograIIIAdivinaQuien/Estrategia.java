package tp1PrograIIIAdivinaQuien;

import java.util.List;

public interface Estrategia {
	boolean debeArriesgar(Tablero tablero);
	Pregunta elegirPregunta(Tablero tablero, List<Pregunta> disponibles);
	Personaje elegirApuesta(Tablero tablero);
	
	default void reflexionar(String texto) {
		System.out.println("    (" + texto + ")");
	}
}
