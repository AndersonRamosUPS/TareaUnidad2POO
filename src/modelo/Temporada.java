package modelo;

public class Temporada {
	private int numero;
	private int episodios;
	private int anioLanzamiento;
	private String descripcion;

	public Temporada(int numero, String descripcion, int anioLanzamiento, int episodios) {
		this.numero = numero;
		this.descripcion = descripcion;
		this.anioLanzamiento = anioLanzamiento;
		this.episodios = episodios;
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
