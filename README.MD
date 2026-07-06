# 📌 Descripción General
API REST para gestión de empleados desarrollada con **Spring Boot**.  
Permite realizar operaciones **CRUD** (Crear, Leer, Actualizar, Eliminar) sobre una lista de empleados en memoria.

---

## 🚀 Funcionalidades Principales

### 1. Operaciones CRUD
- **GET /empleados** → Listar todos los empleados  
- **GET /empleados/{id}** → Obtener empleado por ID  
- **POST /empleados** → Crear nuevo empleado  
- **PUT /empleados/{id}** → Actualizar empleado existente  
- **DELETE /empleados/{id}** → Eliminar empleado  

### 2. Validaciones
- ✅ El nombre no puede estar vacío  
- ✅ El sector no puede estar vacío  
- ✅ El año debe ser mayor a 0  
- ✅ Validación de existencia del empleado por ID  

### 3. Manejo de Errores
El sistema cuenta con un **manejador global de excepciones** que devuelve respuestas HTTP adecuadas:  
- **400 Bad Request** → Datos inválidos  
- **404 Not Found** → Empleado no encontrado  
- **201 Created** → Creación exitosa  
- **200 OK** → Operaciones exitosas  

---

## 🛠️ Tecnologías Utilizadas
- **Spring Boot** → Framework principal  
- **Lombok** → Reducción de código boilerplate  
- **Maven/Gradle** → Gestión de dependencias  
- **Java** → Lenguaje de programación  

---

## 🏗️ Estructura del Proyecto

| Carpeta / Archivo | Descripción |
|-------------------|-------------|
| **controller/**   | Controladores REST |
| ├── EmpleadoController.java | Endpoints CRUD |
| └── GlobalExceptionHandler.java | Manejador global de errores |
| **model/**        | Entidades del dominio |
| └── Empleado.java | Clase Empleado |
| **service/**      | Lógica de negocio |
| └── EmpleadoService.java | Métodos de gestión de empleados |
| **exception/**    | Excepciones personalizadas |
| ├── EmpleadoNoEncontradoException.java | Error de búsqueda |
| ├── NombreInvalidoException.java | Validación de nombre |
| ├── SectorInvalidoException.java | Validación de sector |
| └── AnioInvalidoException.java | Validación de año |


---

## 🔧 Configuración
El servidor corre en:  
**http://localhost:8080** (por defecto)
