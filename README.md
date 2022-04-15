# Requerimientos
- Intellij Idea (2021.2)
- Docker (versión mas reciente)

# Paso a paso (Windows)
1. Clonar el repositorio.
2. Abrir el proyecto en el IDE.
3. Ir a View -> Tool Windows -> Gradle.
4. Ubicar la opcion tracing -> build -> *build*.
5. Doble click en la opcion *build*.
6. Abrir la carpeta donde clonamos el proyecto.
7. Dar click en la barra de direccion del explorador, escribir "cmd" y dar Enter.
8. Ejecutar los siguientes comandos "docker build -t tracing-docker:latest ."
9. Una vez finalizado el anterior, "docker run -p 8080:8080 tracing-docker"
10. Abrir el navegador y dirijirse a "http://localhost:8080/swagger-ui.html" 

# Consigna
#### Construir una aplicación que dada una dirección IP, encuentre el país al que pertenece, y muestre:
- El nombre y código ISO del país
- Los idiomas oficiales del país
- Hora(s) actual(es) en el país (si el país cubre más de una zona horaria, mostrar todas)
- Distancia estimada entre Buenos Aires y el país, en km.
- Moneda local, y su cotización actual en dólares (si está disponible)

#### Basado en la información anterior, es necesario contar con un mecanismo para poder consultar las siguientes estadísticas de utilización del servicio con los siguientes agregados
- Distancia más lejana a Buenos Aires desde la cual se haya consultado el servicio
- Distancia más cercana a Buenos Aires desde la cual se haya consultado el servicio
- Distancia promedio de todas las ejecuciones que se hayan hecho del servicio.

#### Otras consideraciones
- La aplicación puede ser en línea de comandos o web. En el primer caso se espera que el IP sea un parámetro, y en el segundo que exista un form donde escribir la dirección.
- La aplicación deberá hacer un uso racional de las APIs, evitando hacer llamadas innecesarias.
- La aplicación puede tener estado persistente entre invocaciones.
- Además de funcionamiento, prestar atención al estilo y calidad del código fuente.
- La aplicación deberá poder correr ser construida y ejecutada dentro de un
contenedor Docker (incluir un Dockerfile e instrucciones para ejecutarlo).
