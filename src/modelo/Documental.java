package modelo;

import java.util.ArrayList;

public class Documental extends ContenidoAudiovisual {
    private String tema;
    private ArrayList<Investigador> investigadores; // Lista de investigadores asociados al documental

    public Documental(String titulo, int duracionEnMinutos, String genero, String tema) {
        super(titulo, duracionEnMinutos, genero);
        this.tema = tema;
        this.investigadores = new ArrayList<>();
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    // Agregar un investigador al documental
    public void agregarInvestigador(Investigador investigador) {
        investigadores.add(investigador);
    }

    // Mostrar todos los investigadores del documental
    public void mostrarInvestigadores() {
        System.out.println("Investigadores del documental '" + getTitulo() + "':");
        for (Investigador investigador : investigadores) {
            System.out.println("- " + investigador.getNombre() + " (" + investigador.getEspecialidad() + ")");
        }
    }

    // Obtener la lista completa de investigadores
    public ArrayList<Investigador> getInvestigadores() {
        return investigadores;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del Documental:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración: " + getDuracionEnMinutos() + " minutos");
        System.out.println("Género: " + getGenero());
        System.out.println("Tema: " + tema);
        mostrarInvestigadores();
    }
}
