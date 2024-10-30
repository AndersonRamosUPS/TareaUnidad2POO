package uni1a;

import java.util.ArrayList;

public class ProgramaCientifico extends ContenidoAudiovisual{
	private String temaPrincipal;
    private ArrayList<Investigador> investigadores; //Composición con Investigador
    private int episodios;
    private String frecuenciaEmision;
    private ArrayList<Integer> calificaciones = new ArrayList<>();
    
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
    
    public Investigador buscarInvestigador(String nombre) {
        for (Investigador investigador : investigadores) {
            if (investigador.getNombre().equalsIgnoreCase(nombre)) {
                return investigador;
            }
        }
        return null; // Retorna null si no se encuentra el investigador
    }
    
    public boolean eliminarInvestigador(String nombre) {
        return investigadores.removeIf(investigador -> investigador.getNombre().equalsIgnoreCase(nombre));
    }
    
    public void agregarCalificacion(int calificacion) {
        if (calificacion >= 1 && calificacion <= 5) {
            calificaciones.add(calificacion);
        } else {
            System.out.println("Calificación inválida. Debe ser entre 1 y 5.");
        }
    }

    public double calcularCalificacionPromedio() {
        int suma = 0;
        for (int calificacion : calificaciones) {
            suma += calificacion;
        }
        return calificaciones.isEmpty() ? 0 : (double) suma / calificaciones.size();
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
        System.out.println("Calificación Promedio: " + calcularCalificacionPromedio());
        System.out.println("Frecuencia de Emisión: " + frecuenciaEmision);
        mostrarInvestigadores();
        System.out.println();
    }
}
