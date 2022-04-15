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
