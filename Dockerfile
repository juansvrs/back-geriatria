# Usa una imagen base de OpenJDK 17

FROM gradle:7.4.0-jdk17 AS build
COPY . .
RUN gradle clean build -x test

# Etapa de producción
FROM openjdk:17.0.1-jdk-slim
#COPY --from=build /build/libs/geriatria-vida-0.0.1-SNAPSHOT.jar demo.jar

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]