import java.util.ArrayList;
import java.util.Scanner;

// Clase Menu
public class Menu {
    private ArrayList<Producto> productos = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("===== MENÚ =====");
        System.out.println("1. Agregar Producto");
        System.out.println("2. Editar Producto");
        System.out.println("3. Eliminar Producto");
        System.out.println("4. Buscar Producto");
        System.out.println("5. Mostrar todos los productos");
        System.out.println("6. Salir");
        System.out.print("Elija una opción: ");
    }

    public void agregarProducto() {
        System.out.print("Ingrese ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // limpiar buffer
        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese cantidad: ");
        int cantidad = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese categoría: ");
        String categoria = sc.nextLine();

        Producto p = new Producto(id, nombre, cantidad, categoria);
        productos.add(p);
        System.out.println("Producto agregado correctamente.");
    }

    public void editarProducto() {
        System.out.print("Ingrese ID del producto a editar: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Producto p : productos) {
            if (p.getId() == id) {
                System.out.print("Nuevo nombre: ");
                p.setNombre(sc.nextLine());
                System.out.print("Nueva cantidad: ");
                p.setCantidad(sc.nextInt());
                sc.nextLine();
                System.out.print("Nueva categoría: ");
                p.setCategoria(sc.nextLine());
                System.out.println("Producto editado correctamente.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void eliminarProducto() {
        System.out.print("Ingrese ID del producto a eliminar: ");
        int id = sc.nextInt();
        sc.nextLine();

        productos.removeIf(p -> p.getId() == id);
        System.out.println("Producto eliminado (si existía).");
    }

    public void buscarProducto() {
        System.out.print("Ingrese ID del producto a buscar: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Producto p : productos) {
            if (p.getId() == id) {
                System.out.println("Producto encontrado: " + p);
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en la lista.");
        } else {
            System.out.println("Lista de productos:");
            for (Producto p : productos) {
                System.out.println(p);
            }
        }
    }
}
