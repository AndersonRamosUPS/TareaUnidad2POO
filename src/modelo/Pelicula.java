package modelo;

import java.util.ArrayList;

public class Pelicula extends ContenidoAudiovisual {
    private String estudio;
    private ArrayList<Actor> elenco; // Lista de actores asociados a la película

    public Pelicula(String titulo, int duracionEnMinutos, String genero, String estudio) {
        super(titulo, duracionEnMinutos, genero);

        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }
        if (duracionEnMinutos <= 0) {
            throw new IllegalArgumentException("La duración no puede ser negativa o cero");
        }
        this.estudio = estudio;
        this.elenco = new ArrayList<>();
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    // Agregar un actor al elenco
    public void agregarActor(Actor actor) {
        if (actor == null) {
            throw new NullPointerException("Actor no puede ser nulo");
        }
        elenco.add(actor);
    }

    // Mostrar todos los actores de la película
    public void mostrarActores() {
        System.out.println("Actores de la película '" + getTitulo() + "':");
        for (Actor actor : elenco) {
            System.out.println("- " + actor.getNombre());
        }
    }

    // Obtener la lista completa de actores
    public ArrayList<Actor> getElenco() {
        return elenco;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la película:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración: " + getDuracionEnMinutos() + " minutos");
        System.out.println("Género: " + getGenero());
        System.out.println("Estudio: " + estudio);
        mostrarActores();
    }
}
