
import java.util.ArrayList;

/**
 * Servicio que contiene la lógica de negocio.
 * Gestiona la lista de productos en memoria.
 *
 * En Spring Boot:
 *   - Esta clase lleva @Service
 *   - El ArrayList se reemplaza por un JpaRepository
 *   - La lógica interna queda casi igual
 */
public class ProductoService {

    // Lista en memoria — en Spring Boot esto va a ser una tabla MySQL
    private ArrayList<Producto> productos = new ArrayList<>();

    /**
     * Agrega un nuevo producto. La validación de datos se hace en Main.
     */
    public void agregar(String nombre, double precio, int stock) {
        Producto nuevo = new Producto(nombre, precio, stock);
        productos.add(nuevo);
        System.out.println("Producto agregado: " + nuevo);
    }

    /**
     * Lista todos los productos. Si no hay ninguno, avisa.
     */
    public void listar() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos cargados.");
            return;
        }
        System.out.println("\n--- Listado de productos ---");
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    /**
     * Busca un producto por ID.
     * Si no existe, lanza ProductoNoEncontrado — nunca devuelve null.
     */
    public Producto buscarPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        // Si llegamos acá es porque no lo encontramos
        throw new ProductoNoEncontrado(id);
    }

    /**
     * Elimina un producto por ID.
     * Usa buscarPorId — si no existe, la excepción se propaga sola.
     */
    public void eliminar(int id) {
        Producto p = buscarPorId(id);
        productos.remove(p);
        System.out.println("Producto eliminado: " + p.getNombre());
    }
}
