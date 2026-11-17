package Dominio;

public abstract class Usuario {

    private int idUsuario;
    private String nombresYApellidos;
    private String correoElectronico;
    private String telefonoDeContacto;
    private String sectorDireccion;
    private String contrasena;
    private String estadoDeLaCuenta;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombresYApellidos, String correoElectronico,
                   String telefonoDeContacto, String sectorDireccion, String contrasena,
                   String estadoDeLaCuenta) {
        this.idUsuario = idUsuario;
        this.nombresYApellidos = nombresYApellidos;
        this.correoElectronico = correoElectronico;
        this.telefonoDeContacto = telefonoDeContacto;
        this.sectorDireccion = sectorDireccion;
        setContrasena(contrasena);
        this.estadoDeLaCuenta = estadoDeLaCuenta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombresYApellidos() {
        return nombresYApellidos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getTelefonoDeContacto() {
        return telefonoDeContacto;
    }

    public String getSectorDireccion() {
        return sectorDireccion;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getEstadoDeLaCuenta() {
        return estadoDeLaCuenta;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombresYApellidos(String nombresYApellidos) {
        this.nombresYApellidos = nombresYApellidos;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setTelefonoDeContacto(String telefonoDeContacto) {
        this.telefonoDeContacto = telefonoDeContacto;
    }

    public void setSectorDireccion(String sectorDireccion) {
        this.sectorDireccion = sectorDireccion;
    }

    public void setContrasena(String contrasena) {
        if (contrasena != null && contrasena.length() >= 8) {
            this.contrasena = contrasena;
        } else {
            System.out.println("Error: La contrasena debe tener al menos 8 caracteres.");
        }
    }

    public void setEstadoDeLaCuenta(String estadoDeLaCuenta) {
        this.estadoDeLaCuenta = estadoDeLaCuenta;
    }

    public boolean validarCredenciales(String correo, String contrasena) {
        return this.correoElectronico != null && this.correoElectronico.equals(correo) &&
                this.contrasena != null && this.contrasena.equals(contrasena);
    }

    public void registrarCuenta() {
    }

    public void actualizarCuenta() {
    }

    public Usuario consultarCuenta() {
        return this;
    }

    public void eliminarCuenta() {
        this.estadoDeLaCuenta = "Inactivo";
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombresYApellidos='" + nombresYApellidos + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", telefonoDeContacto='" + telefonoDeContacto + '\'' +
                ", sectorDireccion='" + sectorDireccion + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", estadoDeLaCuenta='" + estadoDeLaCuenta + '\'' +
                '}';
    }
}