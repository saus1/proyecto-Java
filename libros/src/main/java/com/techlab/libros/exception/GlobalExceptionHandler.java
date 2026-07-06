package com.techlab.libros.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// @ControllerAdvice: esta clase intercepta excepciones lanzadas desde
// cualquier controller de la aplicación.
@ControllerAdvice
public class GlobalExceptionHandler {

    // @ExceptionHandler: este método se ejecuta cuando se lanza
    // Nombre InvalidoException desde cualquier parte de la app.
    @ExceptionHandler(NombreInvalidoException.class)
    public ResponseEntity<String> handleNombreInvalido(NombreInvalidoException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    @ExceptionHandler(SectorInvalidoException.class)
    public ResponseEntity<String> handleSectorInvalido(SectorInvalidoException e){
         return ResponseEntity.badRequest().body(e.getMessage());
    }


    @ExceptionHandler(AnioInvalidoException.class)
    public ResponseEntity<String> handleAnioInvalido(AnioInvalidoException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(EmpleadoNoEncontradoException.class)
    public ResponseEntity<String> handleEmpleadoNoEncontrado(EmpleadoNoEncontradoException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }
}
