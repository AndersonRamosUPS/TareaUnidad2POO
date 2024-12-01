package modelo;

import java.util.ArrayList;

public class RealityShow extends ContenidoAudiovisual {
	private String canal;
	private ArrayList<Temporada> temporadas; // Lista de temporadas
	private int totalTemporadas;

	public RealityShow(String titulo, int duracionEnMinutos, String genero, String canal) {
		super(titulo, duracionEnMinutos, genero);
		this.canal = canal;
		this.temporadas = new ArrayList<>();
		this.totalTemporadas = 0;
	}

	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
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
		System.out.println("Temporadas del Reality Show '" + getTitulo() + "':");
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
		System.out.println("Detalles del Reality Show:");
		System.out.println("ID: " + getId());
		System.out.println("Título: " + getTitulo());
		System.out.println("Duración promedio por episodio: " + getDuracionEnMinutos() + " minutos");
		System.out.println("Género: " + getGenero());
		System.out.println("Canal: " + canal);
		System.out.println("Número de Temporadas: " + totalTemporadas);
		mostrarTemporadas();
	}
}
