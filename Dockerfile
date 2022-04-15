#define base docker image
FROM openjdk:11
LABEL maintainer="ggomarighetti"
ADD build/libs/tracing-0.0.1-SNAPSHOT.jar tracing-docker.jar
ENTRYPOINT ["java", "-jar", "tracing-docker.jar"]