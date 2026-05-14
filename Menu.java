import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<Producto> productos = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("╔════════════════════════╗");
        System.out.println("║           MENÚ         ║");
        System.out.println("╠═══════════════════════╣");
        System.out.println("║ 1.  Agregar Producto  ║");
        System.out.println("║ 2.  Editar Producto   ║");
        System.out.println("║ 3.  Eliminar Producto ║");
        System.out.println("║ 4.  Buscar Producto   ║");
        System.out.println("║ 5.  Mostrar Todos    ║");
        System.out.println("║ 6.  Salir            ║");
        System.out.println("╚════════════════════════╝");
        System.out.print(" Elija una opción: ");
    }

    public void agregarProducto() {
        try {
            System.out.print(" Ingrese ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            
            // Verificar si el ID ya existe
            if (buscarPorId(id) != null) {
                System.out.println(" Ya existe un producto con ese ID.");
                return;
            }
            
            System.out.print(" Ingrese nombre: ");
            String nombre = sc.nextLine();
            Validacion.validarTexto(nombre);
            
            System.out.print(" Ingrese cantidad: ");
            int cantidad = sc.nextInt();
            sc.nextLine();
            Validacion.validarEntero(cantidad);
            
            System.out.print(" Ingrese categoría: ");
            String categoria = sc.nextLine();
            Validacion.validarTexto(categoria);
            
            Producto p = new Producto(id, nombre, cantidad, categoria);
            productos.add(p);
            System.out.println(" Producto agregado correctamente.");
            System.out.println(p);
        } 
        catch (IllegalArgumentException e) {
            System.out.println(" Error de validación: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println(" Error inesperado: " + e.getMessage());
            sc.nextLine(); // Limpiar buffer
        }
    }

    public void editarProducto() {
        System.out.print(" Ingrese ID del producto a editar: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        Producto producto = buscarPorId(id);
        
        if (producto != null) {
            try {
                System.out.println(" Producto actual: " + producto);
                System.out.println(" Deje vacío para mantener el valor actual");
                
                System.out.print("Nuevo nombre (" + producto.getNombre() + "): ");
                String nombre = sc.nextLine();
                if (!nombre.isEmpty()) {
                    Validacion.validarTexto(nombre);
                    producto.setNombre(nombre);
                }
                
                System.out.print("Nueva cantidad (" + producto.getCantidad() + "): ");
                String cantidadStr = sc.nextLine();
                if (!cantidadStr.isEmpty()) {
                    int cantidad = Integer.parseInt(cantidadStr);
                    Validacion.validarEntero(cantidad);
                    producto.setCantidad(cantidad);
                }
                
                System.out.print("Nueva categoría (" + producto.getCategoria() + "): ");
                String categoria = sc.nextLine();
                if (!categoria.isEmpty()) {
                    Validacion.validarTexto(categoria);
                    producto.setCategoria(categoria);
                }
                
                System.out.println(" Producto editado correctamente.");
                System.out.println(" Producto actualizado: " + producto);
            } 
            catch (IllegalArgumentException e) {
                System.out.println(" Error de validación: " + e.getMessage());
            }
        } else {
            System.out.println(" Producto no encontrado.");
        }
    }

    public void eliminarProducto() {
        System.out.print(" Ingrese ID del producto a eliminar: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        Producto producto = buscarPorId(id);
        if (producto != null) {
            System.out.println(" Producto a eliminar: " + producto);
            System.out.print("¿Está seguro? (s/n): ");
            String confirmacion = sc.nextLine();
            if (confirmacion.equalsIgnoreCase("s")) {
                productos.removeIf(p -> p.getId() == id);
                System.out.println(" Producto eliminado correctamente.");
            } else {
                System.out.println(" Eliminación cancelada.");
            }
        } else {
            System.out.println(" Producto no encontrado.");
        }
    }

    public void buscarProducto() {
        System.out.print(" Ingrese ID del producto a buscar: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        Producto producto = buscarPorId(id);
        if (producto != null) {
            System.out.println("  Producto encontrado:");
            System.out.println("┌─────────────────────────────────┐");
            System.out.println(producto);
            System.out.println("└─────────────────────────────────┘");
        } else {
            System.out.println(" Producto no encontrado.");
        }
    }
    
    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("📭 No hay productos en la lista.");
        } else {
            System.out.println(" LISTA DE PRODUCTOS (" + productos.size() + " productos)");
            System.out.println("┌────┬────────────────────────┬──────────┬─────────────────┐");
            System.out.println("│ ID │ Nombre                 │ Cantidad │ Categoría       │");
            System.out.println("├────┼────────────────────────┼──────────┼─────────────────┤");
            for (Producto p : productos) {
                System.out.printf("│ %-2d │ %-22s │ %-8d │ %-15s │\n", 
                    p.getId(), 
                    p.getNombre().length() > 22 ? p.getNombre().substring(0, 19) + "..." : p.getNombre(),
                    p.getCantidad(),
                    p.getCategoria().length() > 15 ? p.getCategoria().substring(0, 12) + "..." : p.getCategoria()
                );
            }
            System.out.println("└────┴────────────────────────┴──────────┴─────────────────┘");
        }
    }
    
    // Método auxiliar para buscar producto por ID
    private Producto buscarPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}