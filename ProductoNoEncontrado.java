
/**
 * Excepción propia: se lanza cuando se busca un producto que no existe.
 *
 * Extiende RuntimeException → no obliga a declarar throws en cada método.
 *
 * En Spring Boot: @ControllerAdvice va a capturar esta excepción
 * y devolver un error HTTP 404 automáticamente.
 */
public class ProductoNoEncontrado extends RuntimeException {

    public ProductoNoEncontrado(int id) {
        super("No se encontró ningún producto con ID: " + id);
    }
}
