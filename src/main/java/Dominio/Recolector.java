package Dominio;

public class Recolector extends Usuario{

    public Recolector (){
        super();
    }

    public Recolector(String usuario, String nombre, String correo, String contrasenia){
        super(usuario, nombre, correo, contrasenia);
    }

    @Override
    public String toString() {
        return "Recolector" + super.toString();
    }
}
