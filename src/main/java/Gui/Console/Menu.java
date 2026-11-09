package Gui.Console;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private SubMenuUsuarioHogar menuHogar;
    private SubMenuAdministrador menuAdministrador;
    private SubMenuRecolector menuRecolector;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.menuHogar = new SubMenuUsuarioHogar(scanner);
        this.menuAdministrador = new SubMenuAdministrador(scanner);
        this.menuRecolector = new SubMenuRecolector(scanner); // Asumiendo que la tienes creada
    }

    public void iniciar() {
        int opcion = 0;
        do {
            System.out.println("Sistema Alert Eco");
            System.out.println("Seleccione su rol:");
            System.out.println("Opcion : ");
            System.out.println("1. Entrar como Usuario del Hogar");
            System.out.println("2. Entrar como Administrador");
            System.out.println("3. Entrar como Recolector");
            System.out.println("4. Salir");


            opcion = leerOpcionValida();

            switch (opcion) {
                case 1:
                    menuHogar.menuUsuarioHogar();
                    break;
                case 2:
                    menuAdministrador.menuAdministrador();
                    break;
                case 3:
                    menuRecolector.menuRecolector();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción incorrecta. Intente de nuevo.");
            }
        } while (opcion != 4);
    }

    private int leerOpcionValida() {
        try {
            int valor = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            return valor;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Limpiar el buffer
            System.out.println("[Error] Debe ingresar un número entero.");
            return -1;
        }
    }
}