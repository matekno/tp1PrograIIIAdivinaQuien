package tp1PrograIIIAdivinaQuien;

import java.util.List;

public class Juego {

	public static void main(String[] args) {
		List<Personaje> personajes = PersonajeFactory.crearTableroInicial();
		
		personajes.forEach(p -> System.out.println(p.toString()));
		
	}

}
