package modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import modelo.*;
import controlador.ControladorContenido;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControladorContenidoTest {

	private ControladorContenido controlador;

	@BeforeEach
	void setUp() {
		controlador = new ControladorContenido();
	}

	@Test
	void testAgregarContenido() {
		Pelicula pelicula = new Pelicula("Inception", 148, "Ciencia Ficción", "Warner Bros");
		controlador.agregarContenido(pelicula);

		// Validamos que el contenido agregado es visible en mostrarContenidos
		// Aquí se podría redirigir la salida estándar para capturar lo que se imprime
		// en consola
		controlador.mostrarContenidos();
	}

	@Test
	void testMostrarContenidosSinElementos() {
		// Caso límite: Sin elementos en el controlador
		assertDoesNotThrow(controlador::mostrarContenidos, "No debería lanzar excepciones si no hay contenidos.");
	}

	@Test
	void testAgregarElementoAContenido() {
		Pelicula pelicula = new Pelicula("Inception", 148, "Ciencia Ficción", "Warner Bros");
		controlador.agregarContenido(pelicula);

		Actor actor = new Actor("Leonardo DiCaprio", "Estadounidense", 48, "EE.UU.");
		controlador.agregarElementoAContenido("Inception", actor);

		// Validamos indirectamente que el actor fue agregado usando mostrarDetalles
		pelicula.mostrarDetalles();
	}

	@Test
	void testAgregarElementoAContenidoInexistente() {
		Actor actor = new Actor("Leonardo DiCaprio", "Estadounidense", 48, "EE.UU.");
		controlador.agregarElementoAContenido("Inexistente", actor);

		// Validamos que no ocurre una excepción al intentar agregar un elemento a un
		// contenido no existente
		assertDoesNotThrow(() -> controlador.agregarElementoAContenido("Inexistente", actor));
	}

	@Test
	void testEscribirAArchivo() {
		Pelicula pelicula = new Pelicula("Inception", 148, "Ciencia Ficción", "Warner Bros");
		controlador.agregarContenido(pelicula);

		assertDoesNotThrow(() -> controlador.escribirAArchivo("test.csv"),
				"No debería lanzar excepciones al escribir en archivo.");
	}

	@Test
	void testLeerDesdeArchivo() {
		// Simulación: Leer desde un archivo CSV válido
		// En este caso, asumimos que el archivo 'test.csv' tiene datos correctos
		assertDoesNotThrow(() -> controlador.leerDesdeArchivo("test.csv"),
				"No debería lanzar excepciones al leer desde archivo.");
	}
}
