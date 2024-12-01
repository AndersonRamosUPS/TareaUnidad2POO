package modelo;

import java.util.ArrayList;

public class ProgramaCientifico extends ContenidoAudiovisual {
    private String temaPrincipal;
    private int episodios;
    private String frecuenciaEmision;
    private ArrayList<Investigador> investigadores; // Lista de investigadores asociados al programa científico

    public ProgramaCientifico(String titulo, int duracionEnMinutos, String genero, String temaPrincipal, int episodios, String frecuenciaEmision) {
        super(titulo, duracionEnMinutos, genero);
        this.temaPrincipal = temaPrincipal;
        this.episodios = episodios;
        this.frecuenciaEmision = frecuenciaEmision;
        this.investigadores = new ArrayList<>();
    }

    public String getTemaPrincipal() {
        return temaPrincipal;
    }

    public void setTemaPrincipal(String temaPrincipal) {
        this.temaPrincipal = temaPrincipal;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    public String getFrecuenciaEmision() {
        return frecuenciaEmision;
    }

    public void setFrecuenciaEmision(String frecuenciaEmision) {
        this.frecuenciaEmision = frecuenciaEmision;
    }

    // Agregar un investigador al programa científico
    public void agregarInvestigador(Investigador investigador) {
        investigadores.add(investigador);
    }

    // Mostrar todos los investigadores del programa científico
    public void mostrarInvestigadores() {
        System.out.println("Investigadores del programa científico '" + getTitulo() + "':");
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
        System.out.println("Detalles del Programa Científico:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración por episodio: " + getDuracionEnMinutos() + " minutos");
        System.out.println("Género: " + getGenero());
        System.out.println("Tema Principal: " + temaPrincipal);
        System.out.println("Episodios: " + episodios);
        System.out.println("Frecuencia de Emisión: " + frecuenciaEmision);
        mostrarInvestigadores();
    }
}
