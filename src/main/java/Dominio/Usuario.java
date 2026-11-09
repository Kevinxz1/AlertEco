package Dominio;

public abstract class Usuario {
    private String usuario;
    private String nombre;
    private String correo;
    private String contrasenia;

    //sin parametros
    public Usuario(){

    }

    public Usuario(String usuario, String nombre, String correo, String contrasenia) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    //Get
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

    //Set
    public void setUsuario(String usuario){
        if (usuario != null && !usuario.trim().isEmpty()) {
            this.usuario = usuario;
        } else {
            System.out.println("Error: El usuario no puede estar vacío.");
        }
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }
    public void setContrasenia(String contrasenia){
        //Validación interna
        if (contrasenia.length() >= 8) {
            this.contrasenia = contrasenia;
        } else {
            System.out.println("Error: La contraseña debe tener al menos 8 caracteres.");
        }
    }

    @Override
    public String toString() {
        return "Datos del Usuario: \n- Nombre: " + nombre + "\n- Username: " + usuario + "\n- Correo: " + correo;
    }
}