package com.techlab.libros.model;
import lombok.*;



@Data // generar getters,setters,toString,equals
@NoArgsConstructor // genera un constructores sin argumentos
@AllArgsConstructor // generar un constructor con todos los campos
public class Empleado {

    private Integer id;
    private String nombre;
    private String sector;
    private Integer anio;

}
