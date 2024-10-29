package uni1a;

import java.util.ArrayList;

public class RealityShow extends ContenidoAudiovisual{
	private String canal;
    private String paisProduccion;
    private ArrayList<Temporada> listaTemporadas; // Agregación con Temporada
    private String tipoReality;
    
    public RealityShow(String titulo, int duracionEnMinutos, String genero, String canal, String paisProduccion, String tipoReality) {
        super(titulo, duracionEnMinutos, genero);
        this.canal = canal;
        this.paisProduccion = paisProduccion;
        this.tipoReality = tipoReality;
        this.listaTemporadas = new ArrayList<>();
    }

    public void agregarTemporada(Temporada temporada) {
        listaTemporadas.add(temporada);
    }

    public void mostrarTemporadas() {
        System.out.println("Temporadas del reality show:");
        for (Temporada temporada : listaTemporadas) {
            System.out.println("Temporada " + temporada.getNumero() + " - Episodios: " + temporada.getEpisodios());
        }
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getPaisProduccion() {
        return paisProduccion;
    }

    public void setPaisProduccion(String paisProduccion) {
        this.paisProduccion = paisProduccion;
    }

    public String getTipoReality() {
        return tipoReality;
    }

    public void setTipoReality(String tipoReality) {
        this.tipoReality = tipoReality;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del Reality Show:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración total en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Canal: " + canal);
        System.out.println("País de Producción: " + paisProduccion);
        System.out.println("Tipo de Reality: " + tipoReality);
        mostrarTemporadas();
        System.out.println();
    }
}
