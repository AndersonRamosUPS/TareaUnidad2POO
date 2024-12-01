## Proyecto de Programación Orientada a Objetos - Gestión de Contenidos Audiovisuales

### 1. Descripción del Proyecto
Este proyecto es una aplicación de gestión de contenidos audiovisuales que permite organizar y visualizar información sobre diferentes tipos de producciones, como películas, series, documentales, reality shows y programas científicos. Utiliza conceptos avanzados de Programación Orientada a Objetos (POO) y diseño orientado a principios SOLID y MVC, facilitando la organización y manipulación de datos en el sistema.

### 2. Objetivos y Propósito del Proyecto
#### Objetivo General:
Aplicar los principios de POO en un sistema de gestión de contenidos audiovisuales, con un enfoque práctico en diseño estructurado, reutilización de código y pruebas unitarias.

#### Objetivos Específicos:
- Diseñar e implementar una estructura jerárquica de clases que represente diferentes tipos de contenido.
- Incorporar funcionalidades específicas para cada clase, como agregar actores, gestionar temporadas y manejar investigadores.
- Implementar una arquitectura Modelo-Vista-Controlador (MVC) para separar la lógica de negocio de la presentación.
- Realizar pruebas unitarias para asegurar la calidad y fiabilidad del sistema.

### 3. Clases y Funcionalidades
#### Principales Clases:
- **ContenidoAudiovisual:** Clase base que contiene atributos y métodos comunes para todas las subclases.
- **Subclases:**
  - **Película:** Manejo de elenco de actores.
  - **SerieDeTV:** Gestión de temporadas.
  - **Documental:** Relación con investigadores.
  - **RealityShow:** Gestión de temporadas y canal de emisión.
  - **ProgramaCientífico:** Relación con investigadores y manejo de episodios.
  - **ObraTeatral:** Gestión de elenco y escenografía.

#### Funciones Principales:
- **Agregar Contenidos:** Permite añadir nuevos contenidos audiovisuales al sistema.
- **Gestión de Actores:** Métodos para agregar y mostrar actores en películas y obras teatrales.
- **Gestión de Temporadas:** Agregar y mostrar temporadas en series y reality shows.
- **Relación con Investigadores:** Vincula investigadores a documentales y programas científicos.
- **Lectura y Escritura de Archivos:** Importar y exportar datos de contenido a archivos CSV.

### 4. Instrucciones de Instalación y Uso

### Clonación del Repositorio
1. Dirígete al directorio donde deseas clonar el repositorio.
2. Descarga el archivo JAR de JUnit desde el siguiente enlace: [junit-jupiter-engine-5.11.0.jar](https://repo.maven.apache.org/maven2/org/junit/jupiter/junit-jupiter-engine/5.11.0/junit-jupiter-engine-5.11.0.jar).
3. Una vez descargado, sigue estos pasos para integrarlo en Eclipse:
   1. Haz clic derecho en el proyecto desde el explorador de proyectos de Eclipse.
   2. Selecciona **Properties > Java Build Path**.
   3. Ve a la pestaña **Libraries** y haz clic en **Add External JARs**.
   4. Navega hasta la ubicación donde descargaste el archivo `junit-jupiter-engine-5.11.0.jar` y selecciónalo.
   5. Haz clic en **Apply and Close** para guardar los cambios.
4. Ahora puedes ejecutar las pruebas unitarias incluidas en el proyecto.

#### **Ejecución de la Aplicación**
1. Abre el proyecto en tu IDE preferido (Eclipse, IntelliJ, VS Code, etc.).
2. Asegúrate de compilar correctamente las dependencias y el código fuente.
3. Ejecuta la clase principal VistaContenido para iniciar la aplicación.
4. Interactúa con la consola para realizar operaciones como agregar actores, buscar contenido y gestionar temporadas.


###Ejemplo de Uso
- **Agregar una Película:**
  - Selecciona la opción correspondiente en el menú.
  - Ingresa el título, duración, género y estudio de la película.
  - Verifica que la película haya sido agregada correctamente.

- **Agregar un Actor a una Película:**
  - Selecciona una película existente.
  - Proporciona los datos del actor: nombre, nacionalidad, edad y país de origen.

- **Exportar Contenidos a Archivo:**
  - Selecciona la opción de guardar en archivo.
  - Especifica el nombre del archivo CSV a exportar y confirma la operación.
  - Verifica que los datos se hayan guardado correctamente.
