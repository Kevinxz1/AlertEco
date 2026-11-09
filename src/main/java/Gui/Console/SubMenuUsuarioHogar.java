package Gui.Console;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SubMenuUsuarioHogar {
    private Scanner scanner;
    private RegistroDatos registroDatos;

    public SubMenuUsuarioHogar(Scanner scanner) {
        this.scanner = scanner;
        this.registroDatos = new RegistroDatos(scanner);
    }


    public void menuUsuarioHogar() {
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
                    registroDatos.registrarUsuarioHogar();
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