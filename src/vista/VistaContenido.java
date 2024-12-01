package vista;

import controlador.ControladorContenido;
import modelo.*;

import java.util.Scanner;

public class VistaContenido {
    private ControladorContenido controlador;
    private Scanner scanner;

    public VistaContenido(ControladorContenido controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Método principal que gestiona el flujo del menú de la aplicación.
     */
    public void iniciar() {
        int opcion;
        do {
            mostrarMenuGeneral();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1 -> manejarContenido("pelicula");
                case 2 -> manejarContenido("serie");
                case 3 -> manejarContenido("documental");
                case 4 -> manejarContenido("reality");
                case 5 -> cargarDesdeArchivo();
                case 6 -> guardarEnArchivo();
                case 7 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 7);
    }

    /**
     * Muestra el menú general de opciones.
     */
    private void mostrarMenuGeneral() {
        System.out.println("\n--- Menú General ---");
        System.out.println("1. Manejar Películas");
        System.out.println("2. Manejar Series de TV");
        System.out.println("3. Manejar Documentales");
        System.out.println("4. Manejar Reality Shows");
        System.out.println("5. Cargar Contenidos desde Archivo");
        System.out.println("6. Guardar Contenidos en Archivo");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Maneja el contenido según el tipo seleccionado por el usuario.
     */
    private void manejarContenido(String tipo) {
        int opcion;
        do {
            mostrarSubmenu(tipo);
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> agregarContenido(tipo);
                case 2 -> controlador.mostrarContenidos();
                case 3 -> agregarElemento(tipo);
                case 4 -> System.out.println("Volviendo al Menú General...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    /**
     * Muestra el submenú correspondiente al tipo de contenido.
     */
    private void mostrarSubmenu(String tipo) {
        String titulo = switch (tipo) {
            case "pelicula" -> "Películas";
            case "serie" -> "Series de TV";
            case "documental" -> "Documentales";
            case "reality" -> "Reality Shows";
            default -> "Contenido";
        };

        System.out.println("\n--- Menú " + titulo + " ---");
        System.out.println("1. Agregar " + titulo);
        System.out.println("2. Mostrar " + titulo);
        System.out.println("3. Agregar elemento relacionado");
        System.out.println("4. Volver al Menú General");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Permite agregar un contenido del tipo especificado.
     */
    private void agregarContenido(String tipo) {
        System.out.print("Ingrese el título: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese la duración (en minutos): ");
        int duracion = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el género: ");
        String genero = scanner.nextLine();

        switch (tipo) {
            case "pelicula" -> {
                System.out.print("Ingrese el estudio: ");
                String estudio = scanner.nextLine();
                controlador.agregarContenido(new Pelicula(titulo, duracion, genero, estudio));
            }
            case "serie" -> {
                System.out.print("Ingrese la duración promedio por episodio: ");
                controlador.agregarContenido(new SerieDeTV(titulo, duracion, genero));
            }
            case "documental" -> {
                System.out.print("Ingrese el tema: ");
                String tema = scanner.nextLine();
                controlador.agregarContenido(new Documental(titulo, duracion, genero, tema));
            }
            case "reality" -> {
                System.out.print("Ingrese el canal: ");
                String canal = scanner.nextLine();
                controlador.agregarContenido(new RealityShow(titulo, duracion, genero, canal));
            }
            default -> System.out.println("Tipo de contenido no reconocido.");
        }
        System.out.println(tipo.substring(0, 1).toUpperCase() + tipo.substring(1) + " agregado exitosamente.");
    }

    /**
     * Permite agregar un elemento relacionado a un contenido existente.
     */
    private void agregarElemento(String tipo) {
        System.out.print("Ingrese el título del contenido: ");
        String titulo = scanner.nextLine();

        switch (tipo) {
            case "pelicula" -> agregarActor(titulo);
            case "serie", "reality" -> agregarTemporada(titulo);
            case "documental" -> agregarInvestigador(titulo);
            default -> System.out.println("Tipo de contenido no reconocido.");
        }
    }

    /**
     * Agrega un actor a una película.
     */
    private void agregarActor(String titulo) {
        System.out.print("Ingrese el nombre del actor: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la nacionalidad del actor: ");
        String nacionalidad = scanner.nextLine();
        System.out.print("Ingrese la edad del actor: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el país de origen del actor: ");
        String pais = scanner.nextLine();

        Actor actor = new Actor(nombre, nacionalidad, edad, pais);
        controlador.agregarElementoAContenido(titulo, actor);
    }

    /**
     * Agrega un investigador a un documental.
     */
    private void agregarInvestigador(String titulo) {
        System.out.print("Ingrese el nombre del investigador: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la especialidad: ");
        String especialidad = scanner.nextLine();
        System.out.print("Ingrese los años de experiencia: ");
        int anios = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la institución: ");
        String institucion = scanner.nextLine();

        Investigador investigador = new Investigador(nombre, especialidad, anios, institucion);
        controlador.agregarElementoAContenido(titulo, investigador);
    }

    /**
     * Agrega una temporada a una serie o reality show.
     */
    private void agregarTemporada(String titulo) {
        System.out.print("Ingrese el número de la temporada: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese el año de lanzamiento: ");
        int anio = scanner.nextInt();
        System.out.print("Ingrese el número de episodios: ");
        int episodios = scanner.nextInt();
        scanner.nextLine();

        Temporada temporada = new Temporada(numero, descripcion, anio, episodios);
        controlador.agregarElementoAContenido(titulo, temporada);
    }

    /**
     * Carga los contenidos desde un archivo CSV.
     */
    private void cargarDesdeArchivo() {
        System.out.print("Ingrese el nombre del archivo CSV a cargar: ");
        String ruta = scanner.nextLine();
        controlador.leerDesdeArchivo(ruta);
    }

    /**
     * Guarda los contenidos en un archivo CSV.
     */
    private void guardarEnArchivo() {
        System.out.print("Ingrese el nombre del archivo CSV para guardar: ");
        String ruta = scanner.nextLine();
        controlador.escribirAArchivo(ruta);
    }
}
