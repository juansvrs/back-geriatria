# Usa una imagen base de OpenJDK 17
FROM gradle:7.4.0-jdk17 AS build

# Define la ubicación del directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo build.gradle y settings.gradle si es necesario
COPY build.gradle .
COPY settings.gradle .

# Copia el resto de tu código fuente
COPY src src

# Ejecuta el comando de construcción Gradle
RUN gradle clean build -x test

# Etapa de producción
FROM openjdk:17.0.1-jdk-slim

# Define la ubicación del directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR compilado desde la etapa de construcción
COPY --from=build /app/build/libs/*.jar app.jar

# Expone el puerto 8080 (puedes modificarlo si tu aplicación usa otro puerto)
EXPOSE 8080

# Comando de entrada para ejecutar la aplicación Spring Boota
ENTRYPOINT ["java","-jar","app.jar"]
