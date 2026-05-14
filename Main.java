import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            limpiarPantalla();
            menu.mostrarMenu();
            
            // Validar que la entrada sea un número
            while (!sc.hasNextInt()) {
                System.out.println("❌ Por favor, ingrese un número válido.");
                sc.next(); // Limpiar entrada incorrecta
            }
            
            opcion = sc.nextInt();
            sc.nextLine();
            
            switch (opcion) {
                case 1: menu.agregarProducto(); break;
                case 2: menu.editarProducto(); break;
                case 3: menu.eliminarProducto(); break;
                case 4: menu.buscarProducto(); break;
                case 5: menu.mostrarProductos(); break;
                case 6: System.out.println(" Saliendo del programa..."); break;
                default: System.out.println(" Opción inválida.");
            }
            
            if (opcion != 6) {
                System.out.println("\n🔹 Presione Enter para continuar...");
                sc.nextLine();
            }
        } while (opcion != 6);
        
        sc.close();
    }
    
    public static void limpiarPantalla() {
        try {
            // Para Windows
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } 
            // Para Linux/Mac
            else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Si falla, imprimir varias líneas vacías como alternativa
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
}