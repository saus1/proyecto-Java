
public class Validacion {
    
    // Validar cantidad > 0
    public static void validarEntero(int cantidad) throws IllegalArgumentException {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0.");
        }
    }

    // Validar que un string contenga solo letras y espacios
    public static void validarTexto(String texto) throws IllegalArgumentException {
        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor no puede estar vacío.");
        }
        if (!texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            throw new IllegalArgumentException("El valor debe contener solo letras.");
        }
    }
    
    // Validar ID positivo
    public static void validarId(int id) throws IllegalArgumentException {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor a 0.");
        }
    }
}