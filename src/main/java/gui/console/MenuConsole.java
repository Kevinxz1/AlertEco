import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuConsole {
    private Scanner scanner;

    public MenuConsole() {
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion = 0;
        do {
            System.out.println(" SISTEMA Alert-Eco");
            System.out.print("Seleccione su rol: ");
            System.out.println("1. Entrar como Usuario del Hogar");
            System.out.println("2. Entrar como Administrador");
            System.out.println("3. Entrar como Recolector");
            System.out.println("4. Salir");


            opcion = leerOpcionValida();

            switch (opcion) {
                case 1:
                    menuUsuarioHogar();
                    break;
                case 2:
                    menuAdministrador();
                    break;
                case 3:
                    menuRecolector();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción incorrecta. Intente de nuevo.");
            }
        } while (opcion != 4);
    }

    private void menuUsuarioHogar() {
        int opcion = 0;
        do {
            System.out.println("\n--- MENÚ USUARIO DEL HOGAR ---");
            System.out.println("1. Gestionar cuenta");
            System.out.println("2. Configurar recordatorios");
            System.out.println("3. Consultar guía de reciclaje");
            System.out.println("4. Ver historial de reciclaje");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una acción: ");

            opcion = leerOpcionValida();

            switch (opcion) {
                case 2:
                    System.out.println("Ejecutando: Configurar recordatorios...");
                    // AQUI CUMPLES EL CRITERIO "TEST": Instancias tu POJO
                    // Recordatorio rec = new Recordatorio(1, "Sacar basura", "Orgánica", ...);
                    break;
                // Implementar los demás casos...
                case 5:
                    System.out.println("Regresando...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    // Métodos para menuAdministrador() y menuRecolector() irían aquí...

    //validaciones
    private int leerOpcionValida() {
        try {
            int valor = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            return valor;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Limpiar el buffer con el error
            System.out.println("[Error de Validación] Debe ingresar un número entero.");
            return -1;
        }
    }
}