## Proyecto de Programación Orientada a Objetos - Gestión de Contenidos Audiovisuales
###1. Descripción del Proyecto
Este proyecto es una aplicación de gestión de contenidos audiovisuales que permite organizar y visualizar información sobre diferentes tipos de producciones, como películas, series, obras teatrales, reality shows, y programas científicos. Utiliza conceptos de Programación Orientada a Objetos (POO) para modelar las relaciones entre clases y facilitar la organización y manipulación de datos en el sistema.
### 2. Objetivos y Propósito del Proyecto
- Objetivo General: Aplicar los principios de POO en un sistema de gestión de contenidos audiovisuales, enfocándose en la implementación de clases, herencia, y relaciones entre entidades.
- Objetivos Específicos:
	- Crear una estructura jerárquica de clases para representar diferentes tipos de contenido.
	- Implementar funcionalidades específicas para cada clase, como agregar y buscar actores, eliminar temporadas, y calificar episodios.
	- Facilitar la visualización de los datos mediante métodos personalizados en cada clase.

### 3. Clases y Funcionalidades
- **ContenidoAudiovisual:** Clase padre que contiene atributos y métodos comunes a todas las subclases.
- **Película, SerieDeTV, Documental, ObraTeatral, RealityShow, ProgramaCientifico:** Subclases que heredan de `ContenidoAudiovisual` y personalizan funcionalidades específicas.
- **Funciones principales:**
	- **Buscar y Eliminar Actores:** Métodos para buscar y eliminar actores en `ObraTeatral`.
	- **Agregar Calificación y Calcular Promedio:** Métodos en `ProgramaCientifico` que permiten a los usuarios agregar calificaciones y calcular el promedio.
	-** Mostrar Opiniones y Elenco:** Métodos para mostrar opiniones y el elenco en `ObraTeatral`.
	- **Agregar y Mostrar Temporadas:** Métodos en `RealityShow` para gestionar temporadas.
	
###4. Instrucciones de Instalación y Uso
**Clonación del Repositorio**
1. Crea una carpeta o dirígete al directorio donde deseas clonar el repositorio.
	`cd nombre_del_repositorio`
2. Clona el repositorio en tu máquina local con el siguiente comando utilizando git:
	`git clone https://github.com/AndersonRamosUPS/TareaUnidad2POO.git`

**Ejecución de la Aplicación**
1. Abre el proyecto en tu IDE preferido (Eclipse, IntelliJ, etc.).
2. Compila y ejecuta la clase `PruebaAudioVisual` para iniciar la aplicación. 
3. Sigue las instrucciones en la consola para interactuar con la aplicación (por ejemplo, agregar actores, buscar actores, y mostrar detalles de cada obra).

**Ejemplo de Uso**
- **Agregar un Actor:** Sigue las instrucciones en la consola para ingresar el nombre, nacionalidad, edad y país de origen.
- **Buscar un Actor:** Ingresa el nombre del actor para verificar si está en el elenco de una obra.
- **Calificar un Episodio:** Ingresa una calificación entre 1 y 5 para cada episodio y calcula el promedio.

###5. Mejoras Adicionales
- **Pruebas Unitarias:** Se han implementado pruebas unitarias para verificar la funcionalidad de métodos clave, como buscarActor, eliminarActor, agregarCalificacion, y calcularCalificacionPromedio.
- **Optimización del Código:** Se han optimizado algunos métodos para mejorar la eficiencia y claridad del código.

###6. Contribuciones y Agradecimientos
Este proyecto fue desarrollado en el contexto de la Universidad Politécnica Salesiana como parte de un curso sobre Programación Orientada a Objetos. Agradecemos a todos los compañeros y profesores que apoyaron en el desarrollo de esta aplicación.