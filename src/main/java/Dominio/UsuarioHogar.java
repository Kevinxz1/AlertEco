package Dominio;

public class UsuarioHogar extends Usuario {
    public UsuarioHogar(){
        super();
    }
    //CON PARAMETROS
    public UsuarioHogar (String usuario, String nombre, String correo, String contrasenia){
        super(usuario, nombre, correo, contrasenia);
    }

    @Override
    public String toString() {
        return "Perfil del Usuario del Hogar" + super.toString();
    }
}
