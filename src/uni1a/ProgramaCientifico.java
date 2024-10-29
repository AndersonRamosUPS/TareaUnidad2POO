package uni1a;

import java.util.ArrayList;

public class ProgramaCientifico extends ContenidoAudiovisual{
	private String temaPrincipal;
    private ArrayList<Investigador> investigadores; //Composición con Investigador
    private int episodios;
    private String frecuenciaEmision;
    
    public ProgramaCientifico(String titulo, int duracionEnMinutos, String genero, String temaPrincipal, int episodios, String frecuenciaEmision) {
        super(titulo, duracionEnMinutos, genero);
        this.temaPrincipal = temaPrincipal;
        this.episodios = episodios;
        this.frecuenciaEmision = frecuenciaEmision;
        this.investigadores = new ArrayList<>();
    }

    public void agregarInvestigador(Investigador investigador) {
        investigadores.add(investigador);
    }

    public void mostrarInvestigadores() {
        System.out.println("Investigadores del programa:");
        for (Investigador investigador : investigadores) {
            System.out.println(investigador.getNombre());
        }
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

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del Programa Científico:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración total en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Tema Principal: " + temaPrincipal);
        System.out.println("Episodios: " + episodios);
        System.out.println("Frecuencia de Emisión: " + frecuenciaEmision);
        mostrarInvestigadores();
        System.out.println();
    }
}
