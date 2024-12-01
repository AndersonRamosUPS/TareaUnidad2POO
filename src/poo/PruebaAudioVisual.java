package poo;

import controlador.ControladorContenido;
import modelo.Investigador;
import modelo.ProgramaCientifico;
import vista.VistaContenido;

public class PruebaAudioVisual {
	public static void main(String[] args) {
		 // Crear el controlador
        ControladorContenido controlador = new ControladorContenido();

        // Crear la vista y pasarle el controlador
        VistaContenido vista = new VistaContenido(controlador);

        // Iniciar el sistema
        vista.iniciar();
    }
}
