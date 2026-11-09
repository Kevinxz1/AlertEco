package Gui.Console;

import Dominio.UsuarioHogar;
import Util.Validador;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuConsole {
    private Scanner scanner;
    private Validador validador;

    public MenuConsole() {
        this.scanner = new Scanner(System.in);
        this.validador = new Validador();
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
                    registrarUsuarioHogar();
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

    //Met y Lógica de validacioon
    private void registrarUsuarioHogar(){
        System.out.println("------------------------------------");
        System.out.println("REGISTRO DEL NUEVO USUARIO DEL HOGAR");
        System.out.println("------------------------------------");

        String nombreUsuario = "";
        String nombreCompleto = "";
        String correo = "";
        String contrasenia = "";

        //1fst solicitar y valdiar usuario :)
        boolean usuarioValido = false;
        do {
            System.out.println("Ingrese un nombre de usuario, sin caracteres especiales.");
            nombreUsuario = scanner.nextLine();
            usuarioValido = validador.validarUsuario(nombreUsuario);
        }while(!usuarioValido);

        //2nd solicitar y validar nombre y apellido:
        boolean nombreValido = false;
        do {
            System.out.println("Ingrese un Nombre y Apelledio, (ambos deben empezar con mayuscula y estar separados por un espacio");
            nombreCompleto = scanner.nextLine();
            nombreValido = validador.validarNombre(nombreCompleto);
        }while(!nombreValido);

        //3rd solicitar y validar correo
        boolean correoValido = false;
        do{
            System.out.println("Ingrese su correo electronico");
            correo = scanner.nextLine();
            correoValido = validador.validarCorreo(correo);
        }while(!correoValido);


        //4th pedimos y validamos ontraseña
        boolean contraValidad = false;
        do{
            System.out.println("Ingrese una contraseña, de 8 a 16 caracteres ");
            contrasenia = scanner.nextLine();;
            contraValidad = validador.validarContrasenia(contrasenia);
        }while(!contraValidad);

        //Instanciamos el objeto con datos ya validados
        UsuarioHogar nuevoUsuario = new UsuarioHogar(nombreUsuario, nombreCompleto, correo, contrasenia);

        System.out.println("Registro completado con exito :)");
        System.out.println("Bienvenido, " + nuevoUsuario.getNombre()+ "Su Cuenta es: " + nuevoUsuario.getCorreo() + ") se ha creado con exito");
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