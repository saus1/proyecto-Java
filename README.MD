# 📘 Sistema de Gestión de Empleados - Documentación Técnica

## 📌 Resumen del Proyecto
Sistema de gestión de empleados desarrollado con **Spring Boot** que implementa una **API REST** completa con operaciones CRUD, persistencia en **MySQL con JPA**, y un **frontend web** para interactuar con la API.

---

## 🎯 Requerimientos Cumplidos

| Requerimiento               | Implementación |
|-----------------------------|----------------|
| API REST                    | ✅ Endpoints GET, POST, PUT, DELETE |
| Persistencia MySQL + JPA    | ✅ Entidad JPA, repositorio, configuración MySQL |
| Organización en paquetes    | ✅ controller, service, repository, model, exception |
| Frontend                    | ✅ HTML + CSS + JS que consume la API |
| Manejo de errores           | ✅ GlobalExceptionHandler con respuestas HTTP |
| Validaciones                | ✅ Nombre, sector y año validados |

---

## 🏗️ Arquitectura del Sistema

### 1. Backend - Spring Boot

| Paquete     | Clase                        | Responsabilidad |
|-------------|------------------------------|-----------------|
| controller  | EmpleadoController           | Expone endpoints REST (GET, POST, PUT, DELETE) |
| controller  | GlobalExceptionHandler       | Maneja excepciones globalmente |
| model       | Empleado                     | Entidad JPA (mapeo a tabla MySQL) |
| repository  | EmpleadoRepository           | Interfaz JPA para operaciones de base de datos |
| service     | EmpleadoService              | Lógica de negocio y validaciones |
| exception   | EmpleadoNoEncontradoException| Excepción personalizada |
| exception   | NombreInvalidoException      | Excepción personalizada |
| exception   | SectorInvalidoException      | Excepción personalizada |
| exception   | AnioInvalidoException        | Excepción personalizada |

---

### 2. Frontend - Funcionalidades

- ✅ Listar todos los empleados  
- ✅ Crear nuevos empleados  
- ✅ Editar empleados existentes  
- ✅ Eliminar empleados  
- ✅ Validación de campos  
- ✅ Mensajes de éxito/error  
- ✅ Interfaz responsive  

---

## 📡 Endpoints de la API

| Método | Endpoint           | Descripción          | Códigos de Respuesta |
|--------|-------------------|----------------------|----------------------|
| GET    | /empleados        | Listar todos         | 200 OK |
| GET    | /empleados/{id}   | Obtener por ID       | 200 OK, 404 Not Found |
| POST   | /empleados        | Crear empleado       | 201 Created, 400 Bad Request |
| PUT    | /empleados/{id}   | Actualizar empleado  | 200 OK, 404 Not Found, 400 Bad Request |
| DELETE | /empleados/{id}   | Eliminar empleado    | 200 OK, 404 Not Found |

---

## ✅ Validaciones Implementadas

| Validación       | Excepción                   | Mensaje de Error |
|------------------|-----------------------------|------------------|
| Nombre vacío     | NombreInvalidoException     | "El Nombre no puede estar vacío." |
| Sector vacío     | SectorInvalidoException     | "El nombre del Sector no puede estar vacío." |
| Año ≤ 0          | AnioInvalidoException       | "El Año debe ser mayor a 0." |
| ID no existe     | EmpleadoNoEncontradoException | "No se encontró un Empleado con id X" |

---

## 🛠️ Flujo de Trabajo

**Ejemplo: Crear un empleado**

1. **Frontend** → Envía `POST /empleados` con JSON  
2. **Controller** → Recibe petición y llama al Service  
3. **Service** → Valida los datos (nombre, sector, año)  
4. **Service** → Guarda usando el Repository  
5. **Repository** → Ejecuta `INSERT` en MySQL  
6. **Controller** → Retorna `201 Created` con el empleado creado  
7. **Frontend** → Muestra mensaje de éxito y actualiza tabla  

---
**Abrir el proyecto**

http://localhost:8080/index.html
---

## 🎯 Conclusión

El proyecto implementa una aplicación web completa con:  

- ✅ Backend robusto con Spring Boot  
- ✅ Persistencia real en MySQL  
- ✅ Frontend funcional para usuarios  
- ✅ Manejo de errores profesional  
- ✅ Código organizado y mantenible  

Todo funcionando con **XAMPP + MySQL sin contraseña**, facilitando la ejecución en cualquier entorno de desarrollo.
