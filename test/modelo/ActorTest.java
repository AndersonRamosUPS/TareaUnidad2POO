package modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ActorTest {

    @Test
    void testCrearActor() {
        Actor actor = new Actor("Leonardo DiCaprio", "Estadounidense", 48, "EE.UU.");
        assertEquals("Leonardo DiCaprio", actor.getNombre(), "El nombre del actor debería ser 'Leonardo DiCaprio'.");
        assertEquals("Estadounidense", actor.getNacionalidad(), "La nacionalidad debería ser 'Estadounidense'.");
        assertEquals(48, actor.getEdad(), "La edad debería ser 48.");
        assertEquals("EE.UU.", actor.getPaisOrigen(), "El país de origen debería ser 'EE.UU.'.");
    }

    @Test
    void testSetNombre() {
        Actor actor = new Actor("Leonardo DiCaprio", "Estadounidense", 48, "EE.UU.");
        actor.setNombre("Brad Pitt");
        assertEquals("Brad Pitt", actor.getNombre(), "El nombre del actor debería haberse actualizado a 'Brad Pitt'.");
    }

    @Test
    void testSetNacionalidad() {
        Actor actor = new Actor("Leonardo DiCaprio", "Estadounidense", 48, "EE.UU.");
        actor.setNacionalidad("Británica");
        assertEquals("Británica", actor.getNacionalidad(), "La nacionalidad debería haberse actualizado a 'Británica'.");
    }

    @Test
    void testSetEdad() {
        Actor actor = new Actor("Leonardo DiCaprio", "Estadounidense", 48, "EE.UU.");
        actor.setEdad(50);
        assertEquals(50, actor.getEdad(), "La edad debería haberse actualizado a 50.");
    }

    @Test
    void testSetPaisOrigen() {
        Actor actor = new Actor("Leonardo DiCaprio", "Estadounidense", 48, "EE.UU.");
        actor.setPaisOrigen("Reino Unido");
        assertEquals("Reino Unido", actor.getPaisOrigen(), "El país de origen debería haberse actualizado a 'Reino Unido'.");
    }

    // Casos límite y excepcionales
    @Test
    void testCrearActorConNombreVacio() {
        Exception exception = assertThrows(IllegalArgumentException.class, 
            () -> new Actor("", "Estadounidense", 48, "EE.UU."));
        assertEquals("El nombre no puede estar vacío.", exception.getMessage(), "El mensaje de excepción no coincide.");
    }

    @Test
    void testCrearActorConEdadNegativa() {
        Exception exception = assertThrows(IllegalArgumentException.class, 
            () -> new Actor("Leonardo DiCaprio", "Estadounidense", -5, "EE.UU."));
        assertEquals("La edad no puede ser negativa.", exception.getMessage(), "El mensaje de excepción no coincide.");
    }
}
