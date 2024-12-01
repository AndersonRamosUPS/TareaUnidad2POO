package modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class SerieDeTVTest {

    @Test
    void testAgregarTemporada() {
        SerieDeTV serie = new SerieDeTV("Breaking Bad", 45, "Drama");
        Temporada temporada = new Temporada(1, "La primera temporada", 2008, 7);

        serie.agregarTemporada(temporada);

        assertEquals(1, serie.getTotalTemporadas(), "La serie debería tener 1 temporada.");
        assertEquals(1, serie.getTemporadas().size(), "Debería haber 1 temporada en la lista.");
        assertEquals(1, serie.getTemporadas().get(0).getNumero(), "El número de la temporada debería ser 1.");
    }

    @Test
    void testGetTitulo() {
        SerieDeTV serie = new SerieDeTV("Breaking Bad", 45, "Drama");
        assertEquals("Breaking Bad", serie.getTitulo(), "El título debería ser 'Breaking Bad'.");
    }

    @Test
    void testGetTotalTemporadas() {
        SerieDeTV serie = new SerieDeTV("Breaking Bad", 45, "Drama");

        assertEquals(0, serie.getTotalTemporadas(), "La serie no debería tener temporadas al principio.");

        Temporada temporada = new Temporada(1, "La primera temporada", 2008, 7);
        serie.agregarTemporada(temporada);

        assertEquals(1, serie.getTotalTemporadas(), "La serie debería tener 1 temporada después de agregar una.");
    }

    @Test
    void testGetTemporadas() {
        SerieDeTV serie = new SerieDeTV("Breaking Bad", 45, "Drama");
        Temporada temporada1 = new Temporada(1, "La primera temporada", 2008, 7);
        Temporada temporada2 = new Temporada(2, "La segunda temporada", 2009, 13);

        serie.agregarTemporada(temporada1);
        serie.agregarTemporada(temporada2);

        ArrayList<Temporada> temporadas = serie.getTemporadas();

        assertEquals(2, temporadas.size(), "La lista de temporadas debería contener 2 elementos.");
        assertEquals("La primera temporada", temporadas.get(0).getDescripcion(), "La descripción de la primera temporada no coincide.");
        assertEquals("La segunda temporada", temporadas.get(1).getDescripcion(), "La descripción de la segunda temporada no coincide.");
    }

    // Casos límite y excepcionales
    @Test
    void testAgregarTemporadaNula() {
        SerieDeTV serie = new SerieDeTV("Breaking Bad", 45, "Drama");

        Exception exception = assertThrows(NullPointerException.class, () -> serie.agregarTemporada(null));
        assertEquals("La temporada no puede ser nula.", exception.getMessage(), "El mensaje de la excepción no coincide.");
    }

    @Test
    void testCrearSerieSinTitulo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new SerieDeTV("", 45, "Drama"));
        assertEquals("El título no puede estar vacío.", exception.getMessage(), "El mensaje de la excepción no coincide.");
    }

    @Test
    void testCrearSerieConDuracionNegativa() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new SerieDeTV("Breaking Bad", -45, "Drama"));
        assertEquals("La duración no puede ser negativa o cero.", exception.getMessage(), "El mensaje de la excepción no coincide.");
    }

    @Test
    void testListaTemporadasVacia() {
        SerieDeTV serie = new SerieDeTV("Breaking Bad", 45, "Drama");
        assertTrue(serie.getTemporadas().isEmpty(), "La lista de temporadas debería estar vacía inicialmente.");
    }
}
