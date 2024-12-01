package modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class RealityShowTest {

	@Test
	void testAgregarTemporada() {
		RealityShow reality = new RealityShow("Survivor", 60, "Aventura", "CBS");
		Temporada temporada = new Temporada(1, "Primera temporada", 2000, 13);

		reality.agregarTemporada(temporada);

		assertEquals(1, reality.getTotalTemporadas(), "El reality show debería tener 1 temporada.");
		assertEquals(1, reality.getTemporadas().size(), "Debería haber 1 temporada en la lista.");
		assertEquals(1, reality.getTemporadas().get(0).getNumero(), "El número de la temporada debería ser 1.");
	}

	@Test
	void testGetTitulo() {
		RealityShow reality = new RealityShow("Survivor", 60, "Aventura", "CBS");
		assertEquals("Survivor", reality.getTitulo(), "El título debería ser 'Survivor'.");
	}

	@Test
	void testGetCanal() {
		RealityShow reality = new RealityShow("Survivor", 60, "Aventura", "CBS");
		assertEquals("CBS", reality.getCanal(), "El canal debería ser 'CBS'.");
	}

	@Test
	void testSetCanal() {
		RealityShow reality = new RealityShow("Survivor", 60, "Aventura", "CBS");
		reality.setCanal("NBC");

		assertEquals("NBC", reality.getCanal(), "El canal debería haberse actualizado a 'NBC'.");
	}

	@Test
	void testGetTotalTemporadas() {
		RealityShow reality = new RealityShow("Survivor", 60, "Aventura", "CBS");

		assertEquals(0, reality.getTotalTemporadas(), "El reality show no debería tener temporadas inicialmente.");

		Temporada temporada = new Temporada(1, "Primera temporada", 2000, 13);
		reality.agregarTemporada(temporada);

		assertEquals(1, reality.getTotalTemporadas(),
				"El reality show debería tener 1 temporada después de agregar una.");
	}

	@Test
	void testGetTemporadas() {
		RealityShow reality = new RealityShow("Survivor", 60, "Aventura", "CBS");
		Temporada temporada1 = new Temporada(1, "Primera temporada", 2000, 13);
		Temporada temporada2 = new Temporada(2, "Segunda temporada", 2001, 15);

		reality.agregarTemporada(temporada1);
		reality.agregarTemporada(temporada2);

		ArrayList<Temporada> temporadas = reality.getTemporadas();

		assertEquals(2, temporadas.size(), "La lista de temporadas debería contener 2 elementos.");
		assertEquals("Primera temporada", temporadas.get(0).getDescripcion(),
				"La descripción de la primera temporada no coincide.");
		assertEquals("Segunda temporada", temporadas.get(1).getDescripcion(),
				"La descripción de la segunda temporada no coincide.");
	}

	// Casos límite y excepcionales
	@Test
	void testAgregarTemporadaNula() {
		RealityShow reality = new RealityShow("Survivor", 60, "Aventura", "CBS");

		Exception exception = assertThrows(NullPointerException.class, () -> reality.agregarTemporada(null));
		assertEquals("La temporada no puede ser nula.", exception.getMessage(),
				"El mensaje de la excepción no coincide.");
	}

	@Test
	void testCrearRealitySinTitulo() {
		Exception exception = assertThrows(IllegalArgumentException.class,
				() -> new RealityShow("", 60, "Aventura", "CBS"));
		assertEquals("El título no puede estar vacío.", exception.getMessage(),
				"El mensaje de la excepción no coincide.");
	}

	@Test
	void testCrearRealityConDuracionNegativa() {
		Exception exception = assertThrows(IllegalArgumentException.class,
				() -> new RealityShow("Survivor", -60, "Aventura", "CBS"));
		assertEquals("La duración no puede ser negativa o cero.", exception.getMessage(),
				"El mensaje de la excepción no coincide.");
	}

	@Test
	void testListaTemporadasVacia() {
		RealityShow reality = new RealityShow("Survivor", 60, "Aventura", "CBS");
		assertTrue(reality.getTemporadas().isEmpty(), "La lista de temporadas debería estar vacía inicialmente.");
	}
}
