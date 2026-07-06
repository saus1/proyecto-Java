package com.techlab.libros.service;

import com.techlab.libros.exception.EmpleadoNoEncontradoException;
import com.techlab.libros.exception.AnioInvalidoException;
import com.techlab.libros.exception.NombreInvalidoException;
import com.techlab.libros.model.Empleado;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoService {

    private final List<Empleado> empleados = new ArrayList<>();
    private int contadorId = 1;

    public EmpleadoService() {
        empleados.add(new Empleado(contadorId++,"Jorge Sanchez","Of Tecnica",25));
        empleados.add(new Empleado(contadorId++, "Mario Colombo","Produccion",56));
        empleados.add(new Empleado(contadorId++, "Lorenzo Diaz", "Logistica",32));
    }

    public List<Empleado> listarTodos() {
        return empleados;
    }

    public Empleado obtenerPorId(int id) {
        // stream() recorre la lista. filter() filtra por condición.
        // findFirst() toma el primero que cumple. orElseThrow() lanza la excepción si no hay ninguno.
        return empleados.stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EmpleadoNoEncontradoException("No se encontró un Empleado con id " + id));
    }

    public Empleado guardar(Empleado empleado) {
        if (empleado.getNombre() == null || empleado.getNombre().isBlank()) {
            // throw detiene el flujo del método y propaga la excepción hacia el controller.
            throw new NombreInvalidoException("El Nombre no puede estar vacío.");
        }

        if (empleado.getSector() == null || empleado.getSector().isBlank()) {
            // throw detiene el flujo del método y propaga la excepción hacia el controller.
            throw new NombreInvalidoException("El nombre del Sector no puede estar vacío.");
        }
        if (empleado.getAnio() <= 0) {
            throw new AnioInvalidoException("El Anio debe ser mayor a 0.");
        }
        empleado.setId(contadorId++);
        empleados.add(empleado);
        return empleado;
    }

    public void eliminar(int id) {
        Empleado empleado = obtenerPorId(id);
        empleados.remove(empleado);
    }
}
