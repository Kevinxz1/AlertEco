package Gui.Console;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SubMenuAdministrador {
    private Scanner scanner;

    public SubMenuAdministrador(Scanner scanner) {
        this.scanner = scanner;
    }

    public void menuAdministrador() {
        int opcion = 0;
        do {
            System.out.println("Menu del Administrador");
            System.out.println("1. Gestionar cuentas");
            System.out.println("2. Gestionar puntos de recolección en el mapa");
            System.out.println("3. Registrar rutas");
            System.out.println("4. Gestionar reportes");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una acción: ");

            opcion = leerOpcionValida();

            switch (opcion) {
                case 1:
                    System.out.println("Ejecutando: Gestionar cuentas...");
                    break;
                case 2:
                    System.out.println("Ejecutando: Gestionar puntos de recolección...");
                    break;
                case 3:
                    System.out.println("Ejecutando: Registrar rutas...");
                    break;
                case 4:
                    System.out.println("Ejecutando: Gestionar reportes...");
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