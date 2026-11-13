package Gui.Console;

import Dominio.UsuarioHogar;
import Util.Validador;
import java.util.Scanner;

public class RegistroDatos {
    private Scanner scanner;
    private Validador validador;

    public RegistroDatos(Scanner scanner) {
        this.scanner = scanner;
        this.validador = new Validador();
    }

    public void registrarUsuarioHogar() {
        System.out.println("------------------------------------");
        System.out.println("REGISTRO DEL NUEVO USUARIO DEL HOGAR");
        System.out.println("------------------------------------");

        String nombreUsuario = "";
        String nombreCompleto = "";
        String correo = "";
        String contrasenia = "";
        String metaTexto = "";

        boolean usuarioValido = false;
        do {
            System.out.println("Ingrese un nombre de usuario, sin caracteres especiales.");
            nombreUsuario = scanner.nextLine();
            usuarioValido = validador.validarUsuario(nombreUsuario);
        } while (!usuarioValido);

        boolean nombreValido = false;
        do {
            System.out.println("Ingrese un Nombre y Apelledio, (ambos deben empezar con mayuscula y estar separados por un espacio");
            nombreCompleto = scanner.nextLine();
            nombreValido = validador.validarNombre(nombreCompleto);
        } while (!nombreValido);

        boolean correoValido = false;
        do {
            System.out.println("Ingrese su correo electronico");
            correo = scanner.nextLine();
            correoValido = validador.validarCorreo(correo);
        } while (!correoValido);

        boolean contraValida = false;
        do {
            System.out.println("Ingrese una contraseña, de 8 a 16 caracteres ");
            contrasenia = scanner.nextLine();
            contraValida = validador.validarContrasenia(contrasenia);
        } while (!contraValida);

        boolean metaValida = false;
        do {
            System.out.println("Ingrese su meta de reciclaje en Kg (solo numeros enteros): ");
            metaTexto = scanner.nextLine();
            metaValida = validador.validarSoloNumeros(metaTexto);
        } while (!metaValida);

        double metaKg = Double.parseDouble(metaTexto);

        UsuarioHogar nuevoUsuario = new UsuarioHogar(nombreUsuario, nombreCompleto, correo, contrasenia, metaKg);

        System.out.println("Registro completado con exito :)");
        System.out.println("Bienvenido, " + nuevoUsuario.getNombre() + " Su Cuenta es: (" + nuevoUsuario.getCorreo() + ") con una meta de " + nuevoUsuario.getMetaReciclajeKg() + " Kg se ha creado con exito");
    }
}