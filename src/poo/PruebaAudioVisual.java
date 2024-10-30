package poo;
import java.util.Scanner;

import uni1a.*;

public class PruebaAudioVisual {
	public static void main(String[] args) {
		
		// Crear una instancia de ObraTeatral
        ObraTeatral obraTeatral = new ObraTeatral("Hamlet", 120, "Tragedia", "Kenneth Branagh", "El Castillo de Elsinor");

        // Crear actores y añadirlos a la obra
        obraTeatral.agregarActor(new Actor("Emma Watson", "Británica", 32, "Reino Unido"));
        obraTeatral.agregarActor(new Actor("Gael García Bernal", "Mexicano", 44, "México"));
        obraTeatral.agregarActor(new Actor("Lupita Nyong'o", "Keniana", 39, "Kenia"));
        obraTeatral.agregarActor(new Actor("Daniel Brühl", "Alemán-Español", 43, "Alemania - España"));
		
		ejecutarMenu(obraTeatral);
    }
	
	public static void ejecutarMenu(ObraTeatral obraTeatral) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú Obra Teatral ---");
            System.out.println("1. Mostrar detalles de la obra");
            System.out.println("2. Agregar actor");
            System.out.println("3. Buscar actor");
            System.out.println("4. Eliminar actor");
            System.out.println("5. Agregar opinión");
            System.out.println("6. Mostrar opiniones");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    obraTeatral.mostrarDetalles();
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del actor: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la nacionalidad del actor: ");
                    String nacionalidad = scanner.nextLine();
                    System.out.print("Ingrese la edad del actor: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Ingrese el país de origen del actor: ");
                    String paisOrigen = scanner.nextLine();
                    obraTeatral.agregarActor(new Actor(nombre, nacionalidad, edad, paisOrigen));
                    System.out.println("Actor agregado.");
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del actor a buscar: ");
                    nombre = scanner.nextLine();
                    Actor encontrado = obraTeatral.buscarActor(nombre);
                    if (encontrado != null) {
                        System.out.println("Actor encontrado: " + encontrado.getNombre());
                    } else {
                        System.out.println("Actor no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del actor a eliminar: ");
                    nombre = scanner.nextLine();
                    boolean eliminado = obraTeatral.eliminarActor(nombre);
                    System.out.println(eliminado ? "Actor eliminado." : "Actor no encontrado.");
                    break;
                case 5:
                    System.out.print("Ingrese su opinión: ");
                    String opinion = scanner.nextLine();
                    obraTeatral.agregarOpinion(opinion);
                    System.out.println("Opinión agregada.");
                    break;
                case 6:
                    obraTeatral.mostrarOpiniones();
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}