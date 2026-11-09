package Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {

    //1ero. VALIDACION DE USUARIO, solo letras, numeros, y guiones :)
    public boolean validarUsuario(String usuario){
        String regex = "^[a-zA-Z0-9]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(usuario);

        if(matcher.matches()){
            return true;
        }else{
            System.out.println("[Error!, El usuario que intentas crear no puede contener caracteres especiales ni espacios, elíge otro.");
            return false;
        }

    }

    //2do. Validacion del "Nombre y Apellido"
    public boolean validarNombre(String nombre){
        String regex = "^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+\\s[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nombre);

        if(matcher.matches()){
            return true;
        }else {
            System.out.println("Error!, Ambos deben empezar con mayuscula y separados por un espacio (Ejm. Kevin Galeas");
            return false;
        }
    }

    //3ro. VALIDAR CORReo
    public boolean validarCorreo (String correo){
        String regex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);

        if (matcher.matches()) {
            return true;
        } else {
            System.out.println("Erroor!, El correo debe tener un formato válido (Ej: usuario@gmail.com o usuario@uce.edu.ec).");
            return false;
        }
    }

    //4to. Validar contraseña
    public boolean validarContrasenia(String contrasenia){
        String regex ="^.{8,16}$";

        Pattern pattern = Pattern.compile(contrasenia);
        Matcher matcher = pattern.matcher(contrasenia);

        if(matcher.matches()){
            return true;
        }else{
            System.out.println("Error!!!!, la contraseña no tiene de 8 a 16 caracteres");
            return false;
        }
    }

    //5to Valdacion de numeros
    public boolean validarSoloNumeros(String numero) {
        String regex = "^[0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numero);

        if (matcher.matches()) {
            return true;
        } else {
            System.out.println("Error!; Solo se permiten números.");
            return false;
        }
    }


}
