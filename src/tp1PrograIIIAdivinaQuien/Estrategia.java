package tp1PrograIIIAdivinaQuien;

import java.util.List;

public interface Estrategia {
	boolean debeArriesgar(Tablero tablero);
	Pregunta elegirPregunta(Tablero tablero, List<Pregunta> disponibles);
	Personaje elegirApuesta(Tablero tablero);

}
