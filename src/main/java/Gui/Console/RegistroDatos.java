package Gui.Console;

import Dominio.UsuarioDelHogar;
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

        String nombreCompleto = "";
        String correo = "";
        String telefono = "";
        String sector = "";
        String contrasenia = "";

        boolean nombreValido = false;
        do {
            System.out.println("Ingrese sus Nombres y Apellidos (Ej: Kevin Galeas): ");
            nombreCompleto = scanner.nextLine();
            nombreValido = validador.validarNombre(nombreCompleto);
        } while (!nombreValido);

        boolean correoValido = false;
        do {
            System.out.println("Ingrese su correo electronico: ");
            correo = scanner.nextLine();
            correoValido = validador.validarCorreo(correo);
        } while (!correoValido);

        boolean telefonoValido = false;
        do {
            System.out.println("Ingrese su telefono de contacto: ");
            telefono = scanner.nextLine();
            telefonoValido = validador.validarSoloNumeros(telefono);
        } while (!telefonoValido);

        System.out.println("Ingrese su sector o direccion: ");
        sector = scanner.nextLine();

        boolean contraValida = false;
        do {
            System.out.println("Ingrese una contrasena (de 8 a 16 caracteres): ");
            contrasenia = scanner.nextLine();
            contraValida = validador.validarContrasenia(contrasenia);
        } while (!contraValida);

        UsuarioDelHogar nuevoUsuario = new UsuarioDelHogar(0, nombreCompleto, correo, telefono, sector, contrasenia, "Activo");

        System.out.println("Registro completado con exito :)");
        System.out.println("Bienvenido, " + nuevoUsuario.getNombresYApellidos() + ". Su cuenta (" + nuevoUsuario.getCorreoElectronico() + ") se ha creado con exito.");
    }
}