package modelo;

import java.util.ArrayList;

public class SerieDeTV extends ContenidoAudiovisual {
    private ArrayList<Temporada> temporadas; // Lista de temporadas
    private int totalTemporadas; // Número total de temporadas

    public SerieDeTV(String titulo, int duracionEnMinutos, String genero) {
        super(titulo, duracionEnMinutos, genero);
        this.temporadas = new ArrayList<>();
        this.totalTemporadas = 0;
    }

    public int getTotalTemporadas() {
        return totalTemporadas;
    }

    // Agregar una temporada
    public void agregarTemporada(Temporada temporada) {
        temporadas.add(temporada);
        totalTemporadas++;
    }

    // Mostrar todas las temporadas
    public void mostrarTemporadas() {
        System.out.println("Temporadas de la serie '" + getTitulo() + "':");
        for (Temporada temporada : temporadas) {
            System.out.println("- Temporada " + temporada.getNumero() + ": " + temporada.getDescripcion());
        }
    }

    // Obtener lista de temporadas
    public ArrayList<Temporada> getTemporadas() {
        return temporadas;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la Serie de TV:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración promedio por episodio: " + getDuracionEnMinutos() + " minutos");
        System.out.println("Género: " + getGenero());
        System.out.println("Número de Temporadas: " + totalTemporadas);
        mostrarTemporadas();
    }
}
