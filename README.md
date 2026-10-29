# API REST - Almacén de papelería

Proyecto desarrollado para la práctica de Despliegue de Aplicaciones Web (DAW).

API REST para consultar los artículos de un almacén de papelería.

## Tecnologías utilizadas

- Java 21
- Spring Boot 4.1.1
- Spring Data JPA
- Maven
- PostgreSQL
- H2 Database
- Git y GitHub

## Funcionalidades

- Listar todos los artículos.
- Consultar los datos básicos de un artículo.
- Identificar si un artículo está agotado.
- Devolver un error 404 cuando un artículo no existe.

## Endpoints

| Método | Ruta | Descripción |
|---|---|---|
| GET | /api/articulos | Lista todos los artículos |
| GET | /api/articulos/{id}/basico | Consulta los datos básicos |

## Requisitos

- JDK 21
- Maven
- PostgreSQL 17 o H2
- Git

## Instalación y ejecución

1. Clonar el repositorio:

   git clone https://github.com/rabajer/Practica-Tema-1.git

2. Entrar en la carpeta:

   cd Practica-Tema-1/proyecto-base-alumnos

3. Configurar la base de datos siguiendo INSTRUCCIONES_PROYECTO_BASE.md.

4. Ejecutar la aplicación:

   ./mvnw spring-boot:run

5. Abrir en el navegador:

   http://localhost:8080/api/articulos

## Pruebas

Para ejecutar las pruebas con H2:

   SPRING_PROFILES_ACTIVE=h2 ./mvnw verify

## Documentación Javadoc

   ./mvnw javadoc:javadoc

## Documentación adicional

- proyecto-base-alumnos/README.md
- proyecto-base-alumnos/INSTRUCCIONES_PROYECTO_BASE.md
- Wiki del repositorio.

## Organización del trabajo

- Issues para organizar las tareas.
- Ramas feature para desarrollar los cambios.
- Pull Requests para revisar e integrar el código.
- GitHub Projects para organizar el trabajo.
- Wiki para documentar el proyecto.

## Uso de inteligencia artificial

Se ha utilizado inteligencia artificial como apoyo para resolver dudas, comprender errores y mejorar la documentación del proyecto.