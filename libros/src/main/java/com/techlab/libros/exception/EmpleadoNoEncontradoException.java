package com.techlab.libros.exception;

public class EmpleadoNoEncontradoException extends RuntimeException {
    public EmpleadoNoEncontradoException (String mensaje){
        super(mensaje);
    }
}
