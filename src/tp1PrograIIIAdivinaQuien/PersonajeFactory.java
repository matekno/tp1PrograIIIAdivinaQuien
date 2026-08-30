package tp1PrograIIIAdivinaQuien;

import java.util.ArrayList;
import java.util.List;

public class PersonajeFactory {

	private static List<Personaje> crearPersonajes() {
		List<Personaje> personajes = new ArrayList<>();

		// Arrancan todos con el ID 0, despues se actualizan. Esto es asi para cumplir
		// con la consigna.

		personajes.add(new Personaje(0, "Homero Simpson", ColorDePelo.RUBIO, false, true, Genero.HOMBRE, Religion.CRISTIANO));
		personajes.add(new Personaje(0, "Marge Simpson", ColorDePelo.MOROCHO, false, false, Genero.MUJER, Religion.CRISTIANO));
		personajes.add(new Personaje(0, "Ayudante de Santa", ColorDePelo.OTRO_PELO, false, false, Genero.OTRO, Religion.CRISTIANO));
		personajes.add(new Personaje(0, "Senor Burns", ColorDePelo.RUBIO, true, true, Genero.HOMBRE, Religion.ATEO));
		personajes.add(new Personaje(0, "Lisa Simpson", ColorDePelo.RUBIO, false, false, Genero.MUJER, Religion.ATEO));
		personajes.add(new Personaje(0, "Ned Flanders", ColorDePelo.MOROCHO, true, false, Genero.HOMBRE, Religion.CRISTIANO));
		personajes.add(new Personaje(0, "Pez de 3 ojos", ColorDePelo.RUBIO, false, true, Genero.OTRO, Religion.ATEO));
		personajes.add(new Personaje(0, "Castulo Smithers", ColorDePelo.MOROCHO, true, true, Genero.HOMBRE, Religion.JUDIO));
		personajes.add(new Personaje(0, "Edna Krabappel", ColorDePelo.OTRO_PELO, true, false, Genero.MUJER, Religion.ATEO));
		personajes.add(new Personaje(0, "Bola de Nieve III", ColorDePelo.MOROCHO, false, false, Genero.OTRO, Religion.ATEO));
		personajes.add(new Personaje(0, "Bart Simpson", ColorDePelo.RUBIO, false, false, Genero.HOMBRE, Religion.ATEO));
		personajes.add(new Personaje(0, "Patty Bouvier", ColorDePelo.MOROCHO, true, false, Genero.MUJER, Religion.ATEO));
		personajes.add(new Personaje(0, "Abraham Simpson", ColorDePelo.MOROCHO, true, true, Genero.HOMBRE, Religion.CRISTIANO));
		personajes.add(new Personaje(0, "Selma Bouvier", ColorDePelo.MOROCHO, true, false, Genero.MUJER, Religion.ATEO));
		personajes.add(new Personaje(0, "Moe Szyslak", ColorDePelo.MOROCHO, false, false, Genero.HOMBRE, Religion.JUDIO));
		personajes.add(new Personaje(0, "Maggie Simpson", ColorDePelo.RUBIO, false, false, Genero.MUJER, Religion.CRISTIANO));
		personajes.add(new Personaje(0, "Krusty el Payaso", ColorDePelo.OTRO_PELO, false, true, Genero.HOMBRE, Religion.JUDIO));
		personajes.add(new Personaje(0, "Maude Flanders", ColorDePelo.OTRO_PELO, false, false, Genero.MUJER, Religion.CRISTIANO));
		personajes.add(new Personaje(0, "Director Skinner", ColorDePelo.MOROCHO, false, true, Genero.HOMBRE, Religion.CRISTIANO));
		personajes.add(new Personaje(0, "Agnes Skinner", ColorDePelo.MOROCHO, true, false, Genero.MUJER, Religion.CRISTIANO));
		personajes.add(new Personaje(0, "Milhouse Van Houten", ColorDePelo.MOROCHO, true, false, Genero.HOMBRE, Religion.JUDIO));
		personajes.add(new Personaje(0, "Bob Patino", ColorDePelo.OTRO_PELO, false, false, Genero.HOMBRE, Religion.ATEO));
		personajes.add(new Personaje(0, "Jardinero Willie", ColorDePelo.OTRO_PELO, false, false, Genero.HOMBRE, Religion.ATEO));
		return personajes;

	}
	
	public static List<Personaje> crearTableroInicial() {
		List<Personaje> personajes = crearPersonajes();
		// TODO: ordenar por genero. Aca podria meter Divide y conquer...
		asignarIds(personajes);
		return personajes;
	}
	
	private static void asignarIds(List<Personaje> personajes) {
		for (int i = 0; i < personajes.size(); i++) {
			personajes.get(i).setId(i + 1);
		}
	}

}
