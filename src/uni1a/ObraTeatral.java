package uni1a;

import java.util.ArrayList;

public class ObraTeatral extends ContenidoAudiovisual{
	
	private String director;
	private ArrayList<Actor> elenco;  // Asociación con Actor
	private String escenografia;
	
	public ObraTeatral(String titulo, int duracionEnMinutos, String genero, String director, String escenografia) {
        super(titulo, duracionEnMinutos, genero);
        this.director = director;
        this.escenografia = escenografia;
        this.elenco = new ArrayList<>();
    }

	public void agregarActor(Actor actor) {
        elenco.add(actor);
    }

    public void mostrarElenco() {
        System.out.println("Elenco de la obra:");
        for (Actor actor : elenco) {
            System.out.println(actor.getNombre());
        }
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


    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la Obra Teatral:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración total en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Director: " + director);
        System.out.println("Escenografía: " + escenografia);
        mostrarElenco();
        System.out.println();
    }

}
