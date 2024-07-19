# CRUD de Usuarios con Arquitectura Hexagonal
Este proyecto es una aplicación de ejemplo que implementa un sistema CRUD (Crear, Leer, Actualizar, Eliminar) para usuarios utilizando la arquitectura hexagonal con Spring Boot. La aplicación almacena los usuarios en memoria.

### Estructura del Proyecto
La estructura del proyecto sigue los principios de la arquitectura hexagonal, separando la lógica de negocio del acceso a datos y la exposición de la API. A continuación se describen los paquetes principales:

- domain: Contiene las entidades y objetos de dominio.
- application: Contiene los puertos y casos de uso.
    - port.in: Interfaces para los casos de uso de entrada.
    - port.out: Interfaces para los adaptadores de salida (repositorios).
    - service: Implementaciones de los casos de uso.
- infrastructure: Contiene los adaptadores de entrada y salida, así como la configuración.
    - adapter.in: Adaptadores de entrada (controladores REST).
    - adapter.out: Adaptadores de salida (repositorios en memoria).
    - config: Configuraciones de Spring.

### Endpoints
La aplicación expone los siguientes endpoints a través de una API REST:

### Crear Usuario
- URL: /users
- Método: POST
- Parámetros: name, email
- Descripción: Crea un nuevo usuario.
#### Ejemplo de uso:

    curl -X POST "http://localhost:8080/users?name=JohnDoe&email=johndoe@example.com"    

### Obtener Todos los Usuarios
- URL: /users
- Método: GET
- Descripción: Devuelve una lista de todos los usuarios.
#### Ejemplo de uso:

    curl -X GET "http://localhost:8080/users"

### Obtener Usuario por ID
- URL: /users/{id}
- Método: GET
- Parámetros de ruta: id
- Descripción: Devuelve el usuario con el ID especificado.
#### Ejemplo de uso:

    curl -X GET "http://localhost:8080/users/1"

### Actualizar Usuario
- URL: /users/{id}
- Método: PUT
- Parámetros de ruta: id
- Parámetros: name, email
- Descripción: Actualiza los datos del usuario con el ID especificado.
#### Ejemplo de uso:

    curl -X PUT "http://localhost:8080/users/1?name=JaneDoe&email=janedoe@example.com"

### Eliminar Usuario
- URL: /users/{id}
- Método: DELETE
- Parámetros de ruta: id
- Descripción: Elimina el usuario con el ID especificado.
#### Ejemplo de uso:

    curl -X DELETE "http://localhost:8080/users/1"

### Excepciones
La aplicación maneja la excepción UserNotFoundException para devolver un error 404 cuando un usuario no es encontrado.

### Ejecución
1. Requisitos Previos
- Java 17 o superior
- Maven 3.6 o superior
2. Construir y Ejecutar
   Clona el repositorio:

git clone https://github.com/tu-usuario/tu-repositorio.git
cd tu-repositorio

3. Compila el proyecto:
- mvn clean install

4. Ejecuta la aplicación:
- mvn spring-boot:run

5. La aplicación estará disponible en http://localhost:8080.

### Contribuciones
Las contribuciones son bienvenidas. Por favor, abre un issue o envía un pull request con tus mejoras.
