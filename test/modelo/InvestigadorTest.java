package modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class InvestigadorTest {

    @Test
    void testCrearInvestigador() {
        Investigador investigador = new Investigador("Jane Goodall", "Primatóloga", 50, "Instituto de Investigación");

        assertEquals("Jane Goodall", investigador.getNombre(), "El nombre debería ser 'Jane Goodall'.");
        assertEquals("Primatóloga", investigador.getEspecialidad(), "La especialidad debería ser 'Primatóloga'.");
        assertEquals(50, investigador.getAniosExperiencia(), "Los años de experiencia deberían ser 50.");
        assertEquals("Instituto de Investigación", investigador.getInstitucion(), "La institución debería ser 'Instituto de Investigación'.");
    }

    @Test
    void testSetNombre() {
        Investigador investigador = new Investigador("Jane Goodall", "Primatóloga", 50, "Instituto de Investigación");

        investigador.setNombre("Dian Fossey");
        assertEquals("Dian Fossey", investigador.getNombre(), "El nombre debería haberse actualizado a 'Dian Fossey'.");
    }

    @Test
    void testSetEspecialidad() {
        Investigador investigador = new Investigador("Jane Goodall", "Primatóloga", 50, "Instituto de Investigación");

        investigador.setEspecialidad("Zoología");
        assertEquals("Zoología", investigador.getEspecialidad(), "La especialidad debería haberse actualizado a 'Zoología'.");
    }

    @Test
    void testSetAniosExperiencia() {
        Investigador investigador = new Investigador("Jane Goodall", "Primatóloga", 50, "Instituto de Investigación");

        investigador.setAniosExperiencia(55);
        assertEquals(55, investigador.getAniosExperiencia(), "Los años de experiencia deberían haberse actualizado a 55.");
    }

    @Test
    void testSetInstitucion() {
        Investigador investigador = new Investigador("Jane Goodall", "Primatóloga", 50, "Instituto de Investigación");

        investigador.setInstitucion("Centro de Estudios Ambientales");
        assertEquals("Centro de Estudios Ambientales", investigador.getInstitucion(), "La institución debería haberse actualizado a 'Centro de Estudios Ambientales'.");
    }

    // Casos límite y excepcionales
    @Test
    void testCrearInvestigadorSinNombre() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new Investigador("", "Primatóloga", 50, "Instituto de Investigación"));
        assertEquals("El nombre no puede estar vacío.", exception.getMessage(), "El mensaje de la excepción no coincide.");
    }

    @Test
    void testCrearInvestigadorConExperienciaNegativa() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new Investigador("Jane Goodall", "Primatóloga", -5, "Instituto de Investigación"));
        assertEquals("Los años de experiencia no pueden ser negativos.", exception.getMessage(), "El mensaje de la excepción no coincide.");
    }

    @Test
    void testSetNombreNulo() {
        Investigador investigador = new Investigador("Jane Goodall", "Primatóloga", 50, "Instituto de Investigación");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            investigador.setNombre(null));
        assertEquals("El nombre no puede ser nulo.", exception.getMessage(), "El mensaje de la excepción no coincide.");
    }

    @Test
    void testSetInstitucionVacia() {
        Investigador investigador = new Investigador("Jane Goodall", "Primatóloga", 50, "Instituto de Investigación");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            investigador.setInstitucion(""));
        assertEquals("La institución no puede estar vacía.", exception.getMessage(), "El mensaje de la excepción no coincide.");
    }
}
