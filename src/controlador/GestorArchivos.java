package controlador;

import modelo.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorArchivos {

    /**
     * Lee el contenido de un archivo de texto línea por línea.
	*/
    public List<String> leerArchivo(String rutaArchivo) throws IOException {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            // Lee línea por línea hasta que no haya más contenido
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        }
        return lineas;
    }

    /**
     * Escribe una lista de cadenas en un archivo de texto.
     */
    public void escribirArchivo(String rutaArchivo, List<String> datos) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            // Escribe cada línea de la lista en el archivo
            for (String linea : datos) {
                bw.write(linea);
                bw.newLine(); // Agrega un salto de línea después de cada dato
            }
        }
    }
}
