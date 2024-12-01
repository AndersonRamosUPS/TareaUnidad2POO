package modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TemporadaTest {

	@Test
	void testCrearTemporada() {
		Temporada temporada = new Temporada(1, "Primera temporada emocionante", 2023, 10);

		assertEquals(1, temporada.getNumero(), "El número de la temporada debería ser 1.");
		assertEquals("Primera temporada emocionante", temporada.getDescripcion(), "La descripción no coincide.");
		assertEquals(2023, temporada.getAnioLanzamiento(), "El año de lanzamiento debería ser 2023.");
		assertEquals(10, temporada.getEpisodios(), "El número de episodios debería ser 10.");
	}

	@Test
	void testSetNumero() {
		Temporada temporada = new Temporada(1, "Primera temporada", 2023, 10);
		temporada.setNumero(2);

		assertEquals(2, temporada.getNumero(), "El número de la temporada debería haberse actualizado a 2.");
	}

	@Test
	void testSetDescripcion() {
		Temporada temporada = new Temporada(1, "Primera temporada", 2023, 10);
		temporada.setDescripcion("Segunda temporada llena de acción");

		assertEquals("Segunda temporada llena de acción", temporada.getDescripcion(),
				"La descripción debería haberse actualizado.");
	}

	@Test
	void testSetAnioLanzamiento() {
		Temporada temporada = new Temporada(1, "Primera temporada", 2023, 10);
		temporada.setAnioLanzamiento(2024);

		assertEquals(2024, temporada.getAnioLanzamiento(), "El año de lanzamiento debería haberse actualizado a 2024.");
	}

	@Test
	void testSetEpisodios() {
		Temporada temporada = new Temporada(1, "Primera temporada", 2023, 10);
		temporada.setEpisodios(12);

		assertEquals(12, temporada.getEpisodios(), "El número de episodios debería haberse actualizado a 12.");
	}

	// Casos límite y excepcionales
	@Test
	void testNumeroTemporadaNegativo() {
		Exception exception = assertThrows(IllegalArgumentException.class,
				() -> new Temporada(-1, "Temporada negativa", 2023, 10));
		assertEquals("El número de temporada no puede ser negativo.", exception.getMessage(),
				"El mensaje de la excepción no coincide.");
	}

	@Test
	void testAnioLanzamientoFuturo() {
		Exception exception = assertThrows(IllegalArgumentException.class,
				() -> new Temporada(1, "Temporada futura", 2050, 10));
		assertEquals("El año de lanzamiento no puede ser en el futuro.", exception.getMessage(),
				"El mensaje de la excepción no coincide.");
	}

	@Test
	void testDescripcionVacia() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Temporada(1, "", 2023, 10));
		assertEquals("La descripción no puede estar vacía.", exception.getMessage(),
				"El mensaje de la excepción no coincide.");
	}

	@Test
	void testEpisodiosNegativos() {
		Exception exception = assertThrows(IllegalArgumentException.class,
				() -> new Temporada(1, "Temporada con episodios negativos", 2023, -5));
		assertEquals("El número de episodios no puede ser negativo o cero.", exception.getMessage(),
				"El mensaje de la excepción no coincide.");
	}

	@Test
	void testTemporadaSinEpisodios() {
		Temporada temporada = new Temporada(1, "Primera temporada", 2023, 0);
		assertEquals(0, temporada.getEpisodios(), "El número de episodios debería ser 0 inicialmente.");
	}
}
