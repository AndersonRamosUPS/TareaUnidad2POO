package modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PeliculaTest {

	@Test
	void testAgregarActor() {
		Pelicula pelicula = new Pelicula("Inception", 148, "Ciencia Ficción", "Warner Bros");
		Actor actor = new Actor("Leonardo DiCaprio", "Estadounidense", 48, "EE.UU.");

		pelicula.agregarActor(actor);

		// Verificamos que el actor se haya agregado
		assertEquals(1, pelicula.getElenco().size(), "El actor debería haberse agregado.");
		assertEquals("Leonardo DiCaprio", pelicula.getElenco().get(0).getNombre(), "El nombre del actor no coincide.");
	}

	@Test
	void testGetTitulo() {
		Pelicula pelicula = new Pelicula("Inception", 148, "Ciencia Ficción", "Warner Bros");
		assertEquals("Inception", pelicula.getTitulo(), "El título debería ser 'Inception'.");
	}

	@Test
	void testGetEstudio() {
		Pelicula pelicula = new Pelicula("Inception", 148, "Ciencia Ficción", "Warner Bros");
		assertEquals("Warner Bros", pelicula.getEstudio(), "El estudio debería ser 'Warner Bros'.");
	}

	@Test
	void testSetEstudio() {
		Pelicula pelicula = new Pelicula("Inception", 148, "Ciencia Ficción", "Warner Bros");
		pelicula.setEstudio("Universal Studios");
		assertEquals("Universal Studios", pelicula.getEstudio(), "El estudio debería haberse actualizado.");
	}

	@Test
	void testMostrarActores() {
		Pelicula pelicula = new Pelicula("Inception", 148, "Ciencia Ficción", "Warner Bros");
		Actor actor = new Actor("Leonardo DiCaprio", "Estadounidense", 48, "EE.UU.");
		pelicula.agregarActor(actor);

		// Validamos que no haya excepciones al mostrar los actores
		pelicula.mostrarActores();
		assertEquals(1, pelicula.getElenco().size(), "Debería haber 1 actor en la lista.");
	}

	@Test
	void testAgregarActorNulo() {
		Pelicula pelicula = new Pelicula("Inception", 148, "Ciencia Ficción", "Warner Bros");

		// Verificamos que agregar un actor nulo lanza una excepción
		Exception exception = assertThrows(NullPointerException.class, () -> pelicula.agregarActor(null));
		assertEquals("Actor no puede ser nulo", exception.getMessage(), "El mensaje de excepción no coincide.");
	}

	@Test
	void testCrearPeliculaConDuracionNegativa() {
		// Verificamos que crear una película con duración negativa lanza una excepción
		Exception exception = assertThrows(IllegalArgumentException.class,
				() -> new Pelicula("Inception", -10, "Ciencia Ficción", "Warner Bros"));
		assertEquals("La duración no puede ser negativa o cero", exception.getMessage(),
				"El mensaje de excepción no coincide.");
	}

	@Test
	void testCrearPeliculaSinTitulo() {
		// Verificamos que crear una película sin título lanza una excepción
		Exception exception = assertThrows(IllegalArgumentException.class,
				() -> new Pelicula("", 148, "Ciencia Ficción", "Warner Bros"));
		assertEquals("El título no puede estar vacío", exception.getMessage(), "El mensaje de excepción no coincide.");
	}

	@Test
	void testElencoVacio() {
		Pelicula pelicula = new Pelicula("Inception", 148, "Ciencia Ficción", "Warner Bros");

		// Validamos que inicialmente el elenco esté vacío
		assertTrue(pelicula.getElenco().isEmpty(), "El elenco debería estar vacío inicialmente.");
	}
}
