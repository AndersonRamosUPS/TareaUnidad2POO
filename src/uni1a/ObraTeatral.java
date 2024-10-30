package uni1a;

import java.util.ArrayList;

public class ObraTeatral extends ContenidoAudiovisual{
	
	private String director;
	private ArrayList<Actor> elenco;  // Asociación con Actor
	private String escenografia;
	private ArrayList<String> opiniones = new ArrayList<>();
	
	public ObraTeatral(String titulo, int duracionEnMinutos, String genero, String director, String escenografia) {
        super(titulo, duracionEnMinutos, genero);
        this.director = director;
        this.escenografia = escenografia;
        this.elenco = new ArrayList<>();
    }

	public void agregarActor(Actor actor) {
        elenco.add(actor);
    }
	
	public Actor buscarActor(String nombre) {
	    for (Actor actor : elenco) {
	        if (actor.getNombre().equalsIgnoreCase(nombre)) {
	            return actor;
	        }
	    }
	    return null; // Retorna null si no se encuentra el actor
	}
	
	public boolean eliminarActor(String nombre) {
	    return elenco.removeIf(actor -> actor.getNombre().equalsIgnoreCase(nombre));
	}
	
	public void agregarOpinion(String opinion) {
	    opiniones.add(opinion);
	}

	public void mostrarOpiniones() {
	    System.out.println("Opiniones del público:");
	    for (String opinion : opiniones) {
	        System.out.println("- " + opinion);
	    }
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
        mostrarOpiniones();
        System.out.println();
    }

}
