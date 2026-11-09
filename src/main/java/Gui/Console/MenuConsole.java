package Gui.Console;

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
            System.out.println("Sistema Alert Eco");
            System.out.println("Seleccione su rol:");
            System.out.print("Opcion: ");
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
            System.out.println("Menú del Usuario del Hogar");
            System.out.println("1. Gestionar cuenta");
            System.out.println("2. Configurar recordatorios");
            System.out.println("3. Consultar guía de reciclaje");
            System.out.println("4. Ver historial de reciclaje");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una acción: ");

            opcion = leerOpcionValida();

            switch (opcion) {
                case 1:
                    System.out.println("Ejecutando: Gestionar cuenta...");
                    break;
                case 2:
                    System.out.println("Ejecutando: Configurar recordatorios...");
                    break;
                case 3:
                    System.out.println("Ejecutando: Consultar guía de reciclaje...");
                    break;
                case 4:
                    System.out.println("Ejecutando: Ver historial de reciclaje...");
                    break;
                case 5:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    private void menuAdministrador() {
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

    private void menuRecolector() {
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