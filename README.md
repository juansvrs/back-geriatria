# Aplicación de Geriatría

Esta es una aplicación de Spring Boot 3 construida con Java 17. La aplicación está diseñada para gestionar datos y 
operaciones relacionadas con la aplicacion mobile del programa VIDA del HPTU.

## Requisitos Previos

Antes de comenzar, asegúrate de tener los siguientes requisitos:
- Java 17 instalado en tu máquina
- Maven 3. 6 o posterior instalado
- Base de datos MySQL instalada y en funcionamiento

## Configuración

Actualiza el archivo `application.properties` ubicado en `src/main/resources` con los detalles de tu base de datos MySQL:
En caso que se levante la aplicacion con Docker, realizar la configuracion en `application.properties` y en docker-compose
si quiere credenciales diferentes para la base de datos. Si se levanta solo con "docker compose up -d" se crea una imagen de mysql adicional
con credenciales usuario: root  | contraseña: 1234

## properties a modificar segun conveniencia
``` 
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:${MYSQL_PORT:3306}/geriatria?createDatabaseIfNotExists=true
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

# Otras propiedades
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

```
## Creaciones de tablas
El componente cuenta con la dependencia lombok y JPA que permite la creacion automatica e inserciones sin necesidad de codigo adicional, es decir, al iniciar la aplicacion
el framework las crea segun las etiquetas que presenten las entidades, no es necesario ejecutar ningun script de MySql en ningun momento.

## Levantamiento y Docker
Ejecuta el comando de construcción Gradle (importante Java 17 en el entorno de ejecucion, de otra manera no puede ejecutar comandos ./gradlew para spring 3)
RUN gradle clean build : ./gradlew clean build bootRun

En caso de utilizar solo es necesario utilizar "docker compose up -d" y docker crea la imagen de springboot y la imagen de MySql. Expone en dllo el puerto 8080 pero docker lo hace exponiendo el 8082
Para acceder al la app de sprinBoot la ruta seria http://localhost:8082/api en el caso de docker y  http://localhost:8080/api en ambiente local.

## Estructura del proyecto
```
back-geriatria
   ├─ main
   │  ├─ java
   │  │  └─ com
   │  │     └─ geriatria
   │  │        └─ app
   │  │           ├─ controller
   │  │           │  ├─ ActividadController.java
   │  │           │  ├─ PacienteActividadController.java
   │  │           │  ├─ PacienteController.java
   │  │           │  ├─ RegistroController.java
   │  │           │  └─ TipoActividadController.java
   │  │           ├─ GeriatriaVidaApplication.java
   │  │           ├─ persistence
   │  │           │  ├─ entity
   │  │           │  │  ├─ ActividadEntity.java
   │  │           │  │  ├─ PacienteActividadEntity.java
   │  │           │  │  ├─ PacienteActividadId.java
   │  │           │  │  ├─ PacienteEntity.java
   │  │           │  │  ├─ RegistroEntity.java
   │  │           │  │  └─ TipoActividadEntity.java
   │  │           │  └─ repository
   │  │           │     ├─ ActividadRepository.java
   │  │           │     ├─ PacienteActividadRepository.java
   │  │           │     ├─ PacienteRepository.java
   │  │           │     ├─ RegistroRepository.java
   │  │           │     └─ TipoActividadRepository.java
   │  │           └─ service
   │  │              ├─ ActividadService.java
   │  │              ├─ PacienteActividadService.java
   │  │              ├─ PacienteService.java
   │  │              ├─ RegistroService.java
   │  │              └─ TipoActividadService.java
   │  └─ resources
   │     └─ application.properties
   └─ test
      └─ java
         └─ com
            └─ geriatria
               └─ app
                  └─ GeriatriaVidaApplicationTests.java

```


