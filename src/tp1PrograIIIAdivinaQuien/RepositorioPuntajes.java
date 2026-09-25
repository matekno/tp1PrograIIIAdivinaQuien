package tp1PrograIIIAdivinaQuien;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// Cada linea del archivo es "nombre;partidasGanadas"
// Este codigo fue hecho con IA.

public class RepositorioPuntajes {
	private final Path archivo;

	public RepositorioPuntajes(String ruta) {
		this.archivo = Paths.get(ruta);
	}

	public List<Puntaje> cargar() {
		List<Puntaje> puntajes = new ArrayList<>();
		if (!Files.exists(archivo)) {
			return puntajes;
		}
		try {
			for (String linea : Files.readAllLines(archivo)) {
				String[] partes = linea.split(";");
				puntajes.add(new Puntaje(partes[0], Integer.parseInt(partes[1])));
			}
		} catch (IOException e) {
			System.out.println("No se pudieron leer los puntajes.");
		}
		return puntajes;
	}

	public void guardar(List<Puntaje> puntajes) {
		List<String> lineas = new ArrayList<>();
		for (Puntaje puntaje : puntajes) {
			lineas.add(puntaje.getNombre() + ";" + puntaje.getPartidasGanadas());
		}
		try {
			Files.write(archivo, lineas);
		} catch (IOException e) {
			System.out.println("No se pudieron guardar los puntajes.");
		}
	}

}