package uni1a;

import java.util.ArrayList;

/*Clase actor asociado con Pelicula*/

public class Actor {
	private String nombre;
	private String nacionalidad;
	private int edad;
	private ArrayList<String> premios;
	private String paisOrigen;
	
	public Actor(String nombre, String nacionalidad, int edad, String paisOrigen) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.paisOrigen = paisOrigen;
        this.premios = new ArrayList<>();
    }
	
	public void agregarPremio(String premio) {
        premios.add(premio);
    }

    public void mostrarPremios() {
        System.out.println("Premios de " + nombre + ":");
        for (String premio : premios) {
            System.out.println("- " + premio);
        }
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public ArrayList<String> getPremios() {
		return premios;
	}

	public void setPremios(ArrayList<String> premios) {
		this.premios = premios;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	
	

}
