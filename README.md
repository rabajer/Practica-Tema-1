# API REST del almacén de papelería

Proyecto de la práctica de Despliegue de Aplicaciones Web (DAW). Expone una API REST para consultar artículos de un almacén de papelería.

## Funcionalidades

- Listar todos los artículos.
- Consultar los datos básicos de un artículo.
- Indicar si un artículo está agotado.
- Responder con HTTP 404 cuando el artículo solicitado no existe.

## Tecnologías

- Java 21
- Spring Boot y Spring Data JPA
- Maven
- PostgreSQL (base de datos principal) y H2 (pruebas)

## Endpoints

| Método | Ruta | Descripción |
| --- | --- | --- |
| GET | `/api/articulos` | Lista todos los artículos. |
| GET | `/api/articulos/{id}/basico` | Consulta los datos básicos de un artículo. |

## Requisitos

- JDK 21
- Maven (o el wrapper incluido en el proyecto)
- PostgreSQL, si se utiliza la configuración principal

## Instalación y ejecución

1. Clona el repositorio y entra en la carpeta de la aplicación:

   ```bash
   git clone https://github.com/rabajer/Practica-Tema-1.git
   cd Practica-Tema-1/proyecto-base-alumnos
   ```

2. Configura la base de datos siguiendo INSTRUCCIONES_PROYECTO_BASE.md desde la raíz del repositorio, o usa la configuración H2 para las pruebas.
3. Inicia la aplicación:

   ```bash
   ./mvnw spring-boot:run
   ```

La API quedará disponible en http://localhost:8080. Por ejemplo, consulta http://localhost:8080/api/articulos para listar los artículos.

## Pruebas

Las pruebas usan H2 para no depender de una instancia local de PostgreSQL:

```bash
SPRING_PROFILES_ACTIVE=h2 ./mvnw verify
```

En Windows PowerShell:

```powershell
$env:SPRING_PROFILES_ACTIVE = "h2"
./mvnw.cmd verify
```

El workflow de GitHub Actions ejecuta Maven con Java 21 y este mismo perfil H2 en cada cambio de `main` o `develop`.

## Documentación adicional

- [README de la aplicación](proyecto-base-alumnos/README.md)
- [Instrucciones del proyecto base](proyecto-base-alumnos/INSTRUCCIONES_PROYECTO_BASE.md)
- [Wiki del repositorio](https://github.com/rabajer/Practica-Tema-1/wiki)

## Organización del trabajo

El repositorio utiliza Issues para planificar tareas, ramas feature y Pull Requests para revisar cambios, GitHub Projects para seguir el trabajo y la Wiki para documentar el proyecto.

## Uso de inteligencia artificial

Se ha utilizado inteligencia artificial como apoyo para resolver dudas, comprender errores y mejorar la documentación del proyecto.
