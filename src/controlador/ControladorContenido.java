package controlador;

import modelo.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControladorContenido {
    // Lista para almacenar los contenidos audiovisuales
    private ArrayList<ContenidoAudiovisual> contenidos;

    // Objeto encargado de la gestión de archivos
    private GestorArchivos gestorArchivos;

    public ControladorContenido() {
        contenidos = new ArrayList<>();
        gestorArchivos = new GestorArchivos();
    }

    /** Agrega un contenido audiovisual a la lista*/
    public void agregarContenido(ContenidoAudiovisual contenido) {
        contenidos.add(contenido);
        System.out.println("Contenido agregado: " + contenido.getTitulo());
    }

    /**
     * Muestra todos los contenidos audiovisuales almacenados.
     * Si no hay contenidos, muestra un mensaje indicándolo.
     */
    public void mostrarContenidos() {
        if (contenidos.isEmpty()) {
            System.out.println("No hay contenidos registrados.");
            return;
        }
        for (ContenidoAudiovisual contenido : contenidos) {
            contenido.mostrarDetalles();
        }
    }

    // Agrega un elemento específico (actor, investigador, temporada) a un contenido existente.
     
    public void agregarElementoAContenido(String titulo, Object elemento) {
        ContenidoAudiovisual contenido = buscarContenido(titulo);

        if (contenido == null) {
            System.out.println("El contenido no fue encontrado.");
            return;
        }

        // Determina el tipo de contenido y el elemento a agregar
        if (contenido instanceof Documental && elemento instanceof Investigador) {
            ((Documental) contenido).agregarInvestigador((Investigador) elemento);
            System.out.println("Investigador agregado al documental: " + titulo);
        } else if (contenido instanceof Pelicula && elemento instanceof Actor) {
            ((Pelicula) contenido).agregarActor((Actor) elemento);
            System.out.println("Actor agregado a la película: " + titulo);
        } else if (contenido instanceof SerieDeTV && elemento instanceof Temporada) {
            ((SerieDeTV) contenido).agregarTemporada((Temporada) elemento);
            System.out.println("Temporada agregada a la serie: " + titulo);
        } else if (contenido instanceof RealityShow && elemento instanceof Temporada) {
            ((RealityShow) contenido).agregarTemporada((Temporada) elemento);
            System.out.println("Temporada agregada al reality show: " + titulo);
        } else {
            System.out.println("El tipo de contenido o el elemento no es compatible.");
        }
    }

    // Lee contenidos desde un archivo de texto.
    public void leerDesdeArchivo(String rutaArchivo) {
        try {
            List<String> lineas = gestorArchivos.leerArchivo(rutaArchivo);
            for (String linea : lineas) {
                procesarLineaArchivo(linea);
            }
            System.out.println("Archivo cargado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Procesa una línea de texto del archivo para crear un contenido audiovisual.
    private void procesarLineaArchivo(String linea) {
        String[] datos = linea.split(",");
        String tipoContenido = datos[0].toLowerCase();

        // Determina el tipo de contenido basado en la primera palabra de la línea
        switch (tipoContenido) {
            case "pelicula" -> agregarPeliculaDesdeDatos(datos);
            case "serie" -> agregarSerieDesdeDatos(datos);
            case "documental" -> agregarDocumentalDesdeDatos(datos);
            case "reality" -> agregarRealityShowDesdeDatos(datos);
            default -> System.out.println("Tipo de contenido desconocido: " + tipoContenido);
        }
    }

    /**
     * Agrega una película a la lista de contenidos desde datos.
     */
    private void agregarPeliculaDesdeDatos(String[] datos) {
        Pelicula pelicula = new Pelicula(datos[1], Integer.parseInt(datos[2]), datos[3], datos[4]);
        agregarContenido(pelicula);
    }

    /**
     * Agrega una serie de TV a la lista de contenidos desde datos.
     */
    private void agregarSerieDesdeDatos(String[] datos) {
        SerieDeTV serie = new SerieDeTV(datos[1], Integer.parseInt(datos[2]), datos[3]);
        agregarContenido(serie);
    }

    /**
     * Agrega un documental a la lista de contenidos desde datos.
     */
    private void agregarDocumentalDesdeDatos(String[] datos) {
        Documental documental = new Documental(datos[1], Integer.parseInt(datos[2]), datos[3], datos[4]);
        agregarContenido(documental);
    }

    /**
     * Agrega un reality show a la lista de contenidos desde datos.
     */
    private void agregarRealityShowDesdeDatos(String[] datos) {
        RealityShow reality = new RealityShow(datos[1], Integer.parseInt(datos[2]), datos[3], datos[4]);
        agregarContenido(reality);
    }

    /**
     * Escribe los contenidos actuales en un archivo de texto.
     */
    public void escribirAArchivo(String rutaArchivo) {
        List<String> datos = new ArrayList<>();
        for (ContenidoAudiovisual contenido : contenidos) {
            if (contenido instanceof Pelicula) {
                Pelicula pelicula = (Pelicula) contenido;
                datos.add("pelicula," + pelicula.getTitulo() + "," + pelicula.getDuracionEnMinutos() + ","
                        + pelicula.getGenero() + "," + pelicula.getEstudio());
            } else if (contenido instanceof SerieDeTV) {
                SerieDeTV serie = (SerieDeTV) contenido;
                datos.add("serie," + serie.getTitulo() + "," + serie.getDuracionEnMinutos() + "," + serie.getGenero());
            } else if (contenido instanceof Documental) {
                Documental documental = (Documental) contenido;
                datos.add("documental," + documental.getTitulo() + "," + documental.getDuracionEnMinutos() + ","
                        + documental.getGenero() + "," + documental.getTema());
            } else if (contenido instanceof RealityShow) {
                RealityShow reality = (RealityShow) contenido;
                datos.add("reality," + reality.getTitulo() + "," + reality.getDuracionEnMinutos() + ","
                        + reality.getGenero() + "," + reality.getCanal());
            }
        }
        try {
            gestorArchivos.escribirArchivo(rutaArchivo, datos);
            System.out.println("Archivo guardado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    /**
     * Busca un contenido en la lista por su título.
     */
    private ContenidoAudiovisual buscarContenido(String titulo) {
        for (ContenidoAudiovisual contenido : contenidos) {
            if (contenido.getTitulo().equalsIgnoreCase(titulo)) {
                return contenido;
            }
        }
        return null;
    }
}
