package uni1a;

// Agregación de temporada en SerieDeTV
public class Temporada {
	private int numero;
	private int episodios;
	private int anioLanzamiento;
    private String descripcion;
	
    public Temporada(int numero, String titulo, int añoLanzamiento, String descripcion) {
        this.numero = numero;
        this.descripcion = descripcion;
    }

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getEpisodios() {
		return episodios;
	}

	public void setEpisodios(int episodios) {
		this.episodios = episodios;
	}

	public int getAnioLanzamiento() {
		return anioLanzamiento;
	}

	public void setAnioLanzamiento(int anioLanzamiento) {
		this.anioLanzamiento = anioLanzamiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
