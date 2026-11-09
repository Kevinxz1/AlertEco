package Dominio;

public abstract class Usuario {
    private String usuario;
    private String nombre;
    private String correo;
    private String contrasenia;

    public Usuario(){
        this.usuario = "Sin Usuario";
        this.nombre = "sin nombre";
        this.correo = "sin correo";
        this.contrasenia = "sin constraseña";
    }
    public Usuario(String usuario, String nombre, String correo, String contrasenia){
        this.usuario = usuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    //GETS
    public String getUsuario(){
        return usuario;
    }
    public String getNombre(){
        return nombre;
    }
    public String getCorreo(){
        return correo;
    }
    public String getContrasenia(){
        return contrasenia;
    }

    //SET

    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    public void setNombre (String nombre){
        this.nombre = nombre;
    }
    public void setCorreo (String correo){
        this.correo = correo;
    }
    public void setContrasenia(String contrasenia){
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString(){
            return "Datos del usuario: \n" + "Nombre: " + nombre + "\n" + "Usuarionombre " + usuario + "\n" + "Correo: " + correo;
    }

}
