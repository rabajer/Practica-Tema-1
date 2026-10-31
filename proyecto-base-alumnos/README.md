# almacen-papeleria-api

API REST del almacén de una papelería, hecha con Spring Boot (Java 21), Spring Data JPA y PostgreSQL.
Permite consultar el catálogo de artículos y los datos básicos de cada uno, indicando si está agotado.

## Funcionalidades

- Listar todos los artículos del almacén.
- Consultar id, nombre y stock de un artículo; si no quedan unidades, la respuesta incluye `"mensaje": "Agotado"`.
- Respuesta 404 si el artículo no existe.

## Endpoints

| Método | Ruta | Descripción | Códigos |
|--------|------|-------------|---------|
| GET | `/api/articulos` | Todos los artículos con todos sus campos | 200 |
| GET | `/api/articulos/{id}/basico` | Id, nombre y stock de un artículo | 200, 404 |

### `GET /api/articulos`

```json
[
  { "id": 1, "nombre": "Bolígrafo azul", "precio": 0.45, "stock": 500, "categoria": "papelería" },
  { "id": 3, "nombre": "Grapadora metálica", "precio": 8.95, "stock": 0, "categoria": "oficina" }
]
```

### `GET /api/articulos/1/basico` (con stock)

```json
{ "id": 1, "nombre": "Bolígrafo azul", "stock": 500 }
```

### `GET /api/articulos/3/basico` (agotado)

```json
{ "id": 3, "nombre": "Grapadora metálica", "stock": 0, "mensaje": "Agotado" }
```

### `GET /api/articulos/99/basico` (no existe)

Respuesta `404 Not Found` sin cuerpo.

## Requisitos

- JDK 21
- Maven (se incluye el wrapper `mvnw`)
- PostgreSQL 17 (o Docker). Opcionalmente, sin PostgreSQL con el perfil `h2`.
- Git

## Instalación y ejecución en local

1. Clona el repositorio y entra en la carpeta:
   ```bash
   git clone <url-del-repositorio>
   cd almacen-papeleria-api
   ```
2. Si falta `pom.xml`/`mvnw`, genera el esqueleto en https://start.spring.io (Maven, Java 21,
   group `com.hellin`, artifact `almacen`, dependencias Spring Web, Spring Data JPA, PostgreSQL Driver
   y H2) y copia encima el contenido de este proyecto.
3. Arranca PostgreSQL con **una** de estas opciones:
   - **Docker:**
     ```bash
     docker run --name pg-almacen -e POSTGRES_USER=almacen -e POSTGRES_PASSWORD=cambiame -e POSTGRES_DB=almacen -p 5432:5432 -d postgres:17
     ```
   - **PostgreSQL instalado** (https://www.postgresql.org/download/): crea el usuario `almacen` y la base de datos `almacen`.
4. Define la contraseña como variable de entorno (nunca se guarda en el código) y ejecuta:
   ```bash
   # Linux / macOS / Git Bash
   export DB_PASSWORD=cambiame
   ./mvnw spring-boot:run
   ```
   ```powershell
   # Windows PowerShell
   $env:DB_PASSWORD="cambiame"
   .\mvnw spring-boot:run
   ```
   Variables opcionales: `DB_HOST` (por defecto `localhost`), `DB_NAME` y `DB_USER` (por defecto `almacen`).
5. Prueba la API:
   ```bash
   curl http://localhost:8080/api/articulos
   curl http://localhost:8080/api/articulos/3/basico
   ```

Al arrancar se crean la tabla y los datos de ejemplo (`schema.sql` y `data.sql`).

### Sin PostgreSQL (base de datos en memoria)

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=h2
```

### Pruebas automáticas

```bash
SPRING_PROFILES_ACTIVE=h2 ./mvnw verify          # Linux / macOS / Git Bash
$env:SPRING_PROFILES_ACTIVE="h2"; .\mvnw verify  # Windows PowerShell
```

## Documentación del código (Javadoc)

```bash
./mvnw javadoc:javadoc
```

Se genera en `target/reports/apidocs/index.html` (en `target/site/apidocs` según la versión del plugin).

## Estructura

```
src/main/java/com/hellin/almacen/
  controller/  ArticuloController   (endpoints REST)
  service/     ArticuloService      (lógica: mensaje "Agotado")
  repository/  ArticuloRepository   (acceso a datos con JPA)
  model/       Articulo             (entidad)
src/main/resources/  application*.properties, schema.sql, data.sql
```

## Equipo y flujo de trabajo

| Integrante | Nombre | Usuario de GitHub | Rol |
|------------|--------|-------------------|-----|
| A | Julio Villagaray | @gabrielvillagarau9-lgtm | Desarrollo del servicio listarTodos() |
| B | Anthony Tapia | @TApIA-beep | Controlador REST y documentación |
| C | Manuel Llamas | @rabajer | Búsqueda básica de artículos e integración |

- Cada tarea es una **Issue** y se planifica en **Projects**.
- Una rama por tarea (`feature/...`, `docs/...`) y Pull Request revisado por otro integrante antes de fusionar a `main`.
- Los commits siguen el formato convencional y referencian la Issue correspondiente.
- Los roles se distribuyen entre los integrantes del equipo.

## Uso de IA

Se ha utilizado ChatGPT como herramienta de apoyo durante el desarrollo de la práctica para:

- Resolver dudas sobre Maven, Java 21 y Spring Boot.
- Solucionar problemas de configuración de PostgreSQL y Docker.
- Diagnosticar errores durante la compilación y ejecución.
- Consultar comandos de Git y GitHub.
- Revisar y mejorar la documentación del proyecto.

Las soluciones propuestas se han comprobado mediante la ejecución del proyecto y sus comandos correspondientes.