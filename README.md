Desafio1
https://drive.google.com/file/d/1YyXBpHhBX6ugtHJqfPOK7GHYjnKHMWrp/view?usp=sharing
Desafio2
https://drive.google.com/file/d/1-1Vx_z9JhVSnts1ns2vIa5uDwhV0wuQD/view?usp=sharing

# Desafío 3 – Sistema Académico con JWT

## Descripción

Aplicación web desarrollada con Spring Boot, Spring Security, JWT y MySQL para la gestión académica de estudiantes, profesores, materias y notas.

Permite:

- Registro de usuarios
- Inicio de sesión mediante JWT
- Gestión de alumnos
- Gestión de profesores
- Gestión de materias
- Gestión de notas
- Protección de rutas privadas

---

# Tecnologías utilizadas

- Java
- Spring Boot
- Spring Security
- JWT
- MySQL
- Maven
- HTML
- CSS
- JavaScript

---

# Estructura del proyecto

```text
Desafio3/
│
├── src/main/java/sv/edu/udb
│   ├── config
│   ├── controller
│   ├── dto
│   ├── entity
│   ├── repository
│   ├── service
│   └── Desafio1Application.java
│
├── src/main/resources
│   ├── static
│   ├── application.properties
│   └── data.sql
│
└── pom.xml
```

---

# Código fuente principal

## Configuración de seguridad

Archivo:

```text
config/SecurityConfig.java
```

Responsable de:

- Configurar Spring Security
- Permitir rutas públicas
- Proteger rutas privadas
- Integrar JWT

Código principal:

```java
.authorizeHttpRequests(auth -> auth
.requestMatchers(
"/auth/**",
"/index.html",
"/register.html"
).permitAll()
.anyRequest().authenticated())
```

---

## Controlador de autenticación

Archivo:

```text
controller/AuthController.java
```

Responsable de:

- Registrar usuarios
- Iniciar sesión
- Generar token JWT

Métodos principales:

```java
@PostMapping("/register")
public ResponseEntity<?> register()

@PostMapping("/login")
public ResponseEntity<?> login()
```

---

## Servicio JWT

Archivo:

```text
service/JwtService.java
```

Responsable de:

- Crear tokens
- Validar tokens
- Obtener información del usuario

Ejemplo:

```java
public String generateToken(UserDetails userDetails)
```

---

## Gestión de alumnos

Archivo:

```text
controller/AlumnoController.java
```

Responsable de:

- Crear alumnos
- Consultar alumnos
- Modificar alumnos
- Eliminar alumnos

Endpoints:

```java
GET /alumnos

POST /alumnos

PUT /alumnos/{id}

DELETE /alumnos/{id}
```

---

## Frontend

Archivos:

```text
static/index.html
static/register.html
static/dashboard.html
static/dashboard.js
```

Responsable de:

- Inicio de sesión
- Registro
- Mostrar información
- CRUD dinámico


# Base de datos

Tablas implementadas:

- users
- alumno
- profesor
- materia
- alumno_materia

---

# Autor

Ricardo Salazar
