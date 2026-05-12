import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        

        do {
            menu.mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1: menu.agregarProducto(); break;
                case 2: menu.editarProducto(); break;
                case 3: menu.eliminarProducto(); break;
                case 4: menu.buscarProducto(); break;
                case 5: menu.mostrarProductos(); break;
                case 6: System.out.println("Saliendo del programa..."); break;
                default: System.out.println("Opción inválida.");
            }
            System.out.println();
        } while (opcion != 6);

        sc.close();
    }
}
