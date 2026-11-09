package Gui.Console;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SubMenuRecolector {
    private Scanner scanner;

    public SubMenuRecolector(Scanner scanner) {
        this.scanner = scanner;
    }

    public void menuRecolector() {
        int opcion = 0;
        do {
            System.out.println("Menu Recolector");
            System.out.println("1. Reportar tráfico");
            System.out.println("2. Marcar ruta finalizada");
            System.out.println("3. Enviar coordenadas GPS");
            System.out.println("4. Sincronizar estado del dispositivo móvil");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una acción: ");

            opcion = leerOpcionValida();

            switch (opcion) {
                case 1:
                    System.out.println("Ejecutando: Reportar tráfico...");
                    break;
                case 2:
                    System.out.println("Ejecutando: Marcar ruta finalizada...");
                    break;
                case 3:
                    System.out.println("Ejecutando: Enviar coordenadas GPS...");
                    break;
                case 4:
                    System.out.println("Ejecutando: Sincronizar estado...");
                    break;
                case 5:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    private int leerOpcionValida() {
        try {
            int valor = scanner.nextInt();
            scanner.nextLine();
            return valor;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("[Error] Debe ingresar un número entero.");
            return -1;
        }
    }
}