package com.techlab.libros.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.techlab.libros.model.Empleado;
import com.techlab.libros.service.EmpleadoService;

@RestController
@RequestMapping("/empleados")
@CrossOrigin(origins = "http://localhost:5500") // Permite solicitudes desde el puerto 5500 (donde se sirve el front-end).
public class EmpleadoController {

    private final EmpleadoService service;

    public EmpleadoController(EmpleadoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Empleado>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    // GET /Empleado/{id} — 200 OK si existe, 404 si no.
    @GetMapping("/{id}")
    public ResponseEntity<Empleado> obtenerLibro(@PathVariable int id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    // POST /empleado — 201 Created si es válido, 400 si el título está vacío o el
    // precio es inválido.
    @PostMapping
    public ResponseEntity<Empleado> crearLibro(@RequestBody Empleado nuevoEmpleado) {
        Empleado creado = service.guardar(nuevoEmpleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    // PUT /empleado/{id} — 200 OK si existe, 404 si no, 400 si datos inválidos.
    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizar(@PathVariable int id, @RequestBody Empleado datos) {
            Empleado existente = service.obtenerPorId(id);
            existente.setNombre(datos.getNombre());
            existente.setSector(datos.getSector());
            existente.setAnio(datos.getAnio());
            return ResponseEntity.ok(existente);
        
    }

    // DELETE /empleado/{id} — 200 OK si existe, 404 si no.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
            service.eliminar(id);
            return ResponseEntity.ok().build();
    }

}
