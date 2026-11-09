package Dominio;

public class Recolector extends Usuario{
    //SIN PARAMETROS
    public Recolector (){
        super();
    }
    //CON PARAMETROS
    public Recolector(String usuario, String nombre, String correo, String contrasenia){
        super(usuario, nombre, correo, contrasenia);
    }

    @Override
    public String toString() {
        return "Recolector" + super.toString();
    }
}
