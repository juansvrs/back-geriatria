# Usa una imagen base de OpenJDK 17
FROM amazoncorretto:17-alpine

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el archivo JAR construido en la fase de construcción
COPY build/libs/*.jar app.jar

# Expone el puerto 8080 para que se pueda acceder a la aplicación desde fuera del contenedor
EXPOSE 8080

# Comando para ejecutar la aplicación cuando se inicie el contenedor
CMD ["java", "-jar", "app.jar"]