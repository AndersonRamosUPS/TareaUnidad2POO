package modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class DocumentalTest {

    @Test
    void testCrearDocumental() {
        Documental documental = new Documental("Planeta Tierra", 120, "Naturaleza", "Ecosistemas");
        assertEquals("Planeta Tierra", documental.getTitulo(), "El título debería ser 'Planeta Tierra'.");
        assertEquals(120, documental.getDuracionEnMinutos(), "La duración debería ser 120 minutos.");
        assertEquals("Naturaleza", documental.getGenero(), "El género debería ser 'Naturaleza'.");
        assertEquals("Ecosistemas", documental.getTema(), "El tema debería ser 'Ecosistemas'.");
        assertTrue(documental.getInvestigadores().isEmpty(), "La lista de investigadores debería estar vacía inicialmente.");
    }

    @Test
    void testSetTema() {
        Documental documental = new Documental("Planeta Tierra", 120, "Naturaleza", "Ecosistemas");
        documental.setTema("Cambio Climático");
        assertEquals("Cambio Climático", documental.getTema(), "El tema debería haberse actualizado a 'Cambio Climático'.");
    }

    @Test
    void testAgregarInvestigador() {
        Documental documental = new Documental("Planeta Tierra", 120, "Naturaleza", "Ecosistemas");
        Investigador investigador = new Investigador("Jane Goodall", "Primatóloga", 50, "Instituto de Investigación");

        documental.agregarInvestigador(investigador);

        ArrayList<Investigador> investigadores = documental.getInvestigadores();
        assertEquals(1, investigadores.size(), "Debería haber un investigador en la lista.");
        assertEquals("Jane Goodall", investigadores.get(0).getNombre(), "El nombre del investigador no coincide.");
        assertEquals("Primatóloga", investigadores.get(0).getEspecialidad(), "La especialidad del investigador no coincide.");
    }

    @Test
    void testMostrarInvestigadores() {
        Documental documental = new Documental("Planeta Tierra", 120, "Naturaleza", "Ecosistemas");
        Investigador investigador = new Investigador("Jane Goodall", "Primatóloga", 50, "Instituto de Investigación");

        documental.agregarInvestigador(investigador);

        // Aquí se verifica que no haya excepciones al llamar a este método
        documental.mostrarInvestigadores();
    }

    // Casos límite y excepcionales
    @Test
    void testAgregarInvestigadorNulo() {
        Documental documental = new Documental("Planeta Tierra", 120, "Naturaleza", "Ecosistemas");
        try {
            documental.agregarInvestigador(null);
        } catch (NullPointerException e) {
            assertEquals("El investigador no puede ser nulo.", e.getMessage(), "El mensaje de la excepción no coincide.");
        }
    }

    @Test
    void testCrearDocumentalConDuracionNegativa() {
        try {
            new Documental("Planeta Tierra", -10, "Naturaleza", "Ecosistemas");
        } catch (IllegalArgumentException e) {
            assertEquals("La duración no puede ser negativa o cero.", e.getMessage(), "El mensaje de la excepción no coincide.");
        }
    }

    @Test
    void testCrearDocumentalSinTitulo() {
        try {
            new Documental("", 120, "Naturaleza", "Ecosistemas");
        } catch (IllegalArgumentException e) {
            assertEquals("El título no puede estar vacío.", e.getMessage(), "El mensaje de la excepción no coincide.");
        }
    }
}
