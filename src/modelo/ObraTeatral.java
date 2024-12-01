package modelo;

import java.util.ArrayList;

public class ObraTeatral extends ContenidoAudiovisual {
    private String director;
    private String escenografia;
    private ArrayList<Actor> elenco;

    public ObraTeatral(String titulo, int duracionEnMinutos, String genero, String director, String escenografia) {
        super(titulo, duracionEnMinutos, genero);
        this.director = director;
        this.escenografia = escenografia;
        this.elenco = new ArrayList<>();
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getEscenografia() {
        return escenografia;
    }

    public void setEscenografia(String escenografia) {
        this.escenografia = escenografia;
    }

    public void agregarActor(Actor actor) {
        elenco.add(actor);
    }

    public ArrayList<Actor> getElenco() {
        return elenco;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Obra Teatral: " + getTitulo());
        System.out.println("Duración: " + getDuracionEnMinutos() + " minutos");
        System.out.println("Género: " + getGenero());
        System.out.println("Director: " + director);
        System.out.println("Escenografía: " + escenografia);
        System.out.println("Elenco:");
        for (Actor actor : elenco) {
            System.out.println("- " + actor.getNombre());
        }
    }
}
