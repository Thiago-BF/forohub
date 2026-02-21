# 📌 ForoHub API

Proyecto backend desarrollado con Spring Boot para la gestión de tópicos en un foro.

Permite:
- Autenticación de usuarios mediante JWT
- Crear, listar, actualizar y eliminar tópicos
- Seguridad con Spring Security
- Migraciones automáticas con Flyway
- Persistencia en MySQL

---

## 🚀 Tecnologías utilizadas

- Java 17+
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA
- MySQL
- Flyway
- Maven

---

## ⚙️ Configuración del proyecto

Antes de ejecutar la aplicación, se deben configurar las siguientes variables de entorno:

DB_PASSWORD=tu_password_mysql  
JWT_SECRET=tu_clave_secreta  
API_SECRET=tu_clave_api  

En el archivo `application.properties` se utilizan variables de entorno para mayor seguridad.

---

## 🗄️ Base de datos

La aplicación utiliza MySQL.

Crear una base de datos llamada:

forohub

Las tablas se crean automáticamente mediante Flyway al iniciar la aplicación.

---

## ▶️ Cómo ejecutar el proyecto

Desde la raíz del proyecto:

### En Windows:
mvnw spring-boot:run

### O usando Maven instalado:
mvn spring-boot:run

La API se ejecutará en:

http://localhost:8080

---

## 🔐 Autenticación

Para autenticarse, realizar una petición POST a:

POST /login

Ejemplo en Postman:

{
  "login": "admin",
  "clave": "123456"
}

La respuesta devolverá un token JWT.

Para acceder a endpoints protegidos, agregar en Headers:

Authorization: Bearer TU_TOKEN

---

## 📌 Endpoints principales

- POST /topicos
- GET /topicos
- PUT /topicos/{id}
- DELETE /topicos/{id}

Todos requieren autenticación JWT.

---

## 📂 Estructura del proyecto

- controller → Controladores REST
- domain → Entidades y repositorios
- infra → Seguridad, filtros y configuración
- db/migration → Scripts de Flyway

---

## 👨‍💻 Autor

Thiago Beber Feil  
Programmer.
