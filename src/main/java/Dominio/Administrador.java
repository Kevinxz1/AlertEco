package Dominio;

public class Administrador extends Usuario{
    //SIN PARAMETROS
    public Administrador(){
        super();
    }

    public Administrador(String usuario, String nombre, String correo, String contrasenia){
        super(usuario, nombre,correo,contrasenia);
    }

    @Override
    public String toString() {
        return "-Administrador" + super.toString();
    }
}
