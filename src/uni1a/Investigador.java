package uni1a;

import java.util.ArrayList;

//Clase Investigador como composición en Documental
public class Investigador {
	private String nombre;
	private int aniosExperiencia;
    private String institucion;
    private ArrayList<String> publicaciones;
    private ArrayList<String> proyectos;

    public Investigador(String nombre, String especialidad, int añosExperiencia, String institucion) {
        this.nombre = nombre;
        this.aniosExperiencia = añosExperiencia;
        this.institucion = institucion;
        this.publicaciones = new ArrayList<>();
        this.proyectos = new ArrayList<>();
    }
	
	public void agregarPublicacion(String publicacion) {
        publicaciones.add(publicacion);
    }

    public void mostrarPublicaciones() {
        System.out.println("Publicaciones de " + nombre + ":");
        for (String publicacion : publicaciones) {
            System.out.println(publicacion);
        }
    }

    public void agregarProyecto(String proyecto) {
        proyectos.add(proyecto);
    }

    public void mostrarProyectos() {
        System.out.println("Proyectos de " + nombre + ":");
        for (String proyecto : proyectos) {
            System.out.println(proyecto);
        }
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAñosExperiencia() {
		return aniosExperiencia;
	}

	public void setAñosExperiencia(int añosExperiencia) {
		this.aniosExperiencia = añosExperiencia;
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}
	
	
	
}
