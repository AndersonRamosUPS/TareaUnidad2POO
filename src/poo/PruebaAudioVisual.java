package poo;
import uni1a.*;

public class PruebaAudioVisual {
	public static void main(String[] args) {
        System.out.println("Hello from Eclipse!");

        // Crear instancias de las subclases
        /*ContenidoAudiovisual[] contenidos = new ContenidoAudiovisual[3];
        contenidos[0] = new Pelicula("Avatar", 125, "Accion", "20th Century Studios");
        contenidos[1] = new SerieDeTV("Game of Thrones", 60, "Fantasy", 8);
        contenidos[2] = new Documental("Cosmos", 45, "Science", "Astronomy");*/
        
        Investigador investigador = new Investigador("Anderson");
        Investigador investigador2 =  new Investigador("Andres");
        Investigador investigador3 =  new Investigador("Alejandro");
    
        Documental docu = new Documental("Cosmos2", 55, "Ciencia", "Astronomia");
        docu.agregarInvestigador(investigador);
        docu.agregarInvestigador(investigador2);
        docu.agregarInvestigador(investigador3);
        
        docu.mostrarDetalles();
     

        // Mostrar los detalles de cada contenido audiovisual
        /*for (ContenidoAudiovisual contenido : contenidos) {
            contenido.mostrarDetalles();
        }*/
        
        
    }
}