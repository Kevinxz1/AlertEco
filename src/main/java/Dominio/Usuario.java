package Dominio;

public abstract class Usuario {

    private int idUsuario;
    private String nombresYApellidos;
    private String correoElectronico;
    private String telefonoDeContacto;
    private String sectorDireccion;
    private String contrasena;
    private String estadoDeLaCuenta;

    //sin parametros
    public Usuario() {
        this.idUsuario = 1;
        this.nombresYApellidos = "Kevin Galeas";
        this.correoElectronico = "kevin@gmail.com";
        this.telefonoDeContacto = "0999999999";
        this.sectorDireccion = "Centro Norte";
        this.contrasena = "12345678";
        this.estadoDeLaCuenta = "Activo";
    }

    //constructor parametrizado
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

    //Get
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

    //Set
    public void setIdUsuario(int idUsuario) {
        if (idUsuario > 0) {
            this.idUsuario = idUsuario;
        } else {
            System.out.println("Error: El ID del usuario debe ser mayor a 0.");
        }
    }
    public void setNombresYApellidos(String nombresYApellidos) {
        if (nombresYApellidos != null && !nombresYApellidos.trim().isEmpty()) {
            this.nombresYApellidos = nombresYApellidos;
        } else {
            System.out.println("Error: Los nombres y apellidos no pueden estar vacíos.");
        }
    }
    public void setCorreoElectronico(String correoElectronico) {
        if (correoElectronico != null && !correoElectronico.trim().isEmpty()) {
            this.correoElectronico = correoElectronico;
        } else {
            System.out.println("Error: El correo electrónico no puede estar vacío.");
        }
    }
    public void setTelefonoDeContacto(String telefonoDeContacto) {
        this.telefonoDeContacto = telefonoDeContacto;
    }
    public void setSectorDireccion(String sectorDireccion) {
        this.sectorDireccion = sectorDireccion;
    }
    public void setContrasena(String contrasena) {
        //Validación interna
        if (contrasena != null && contrasena.length() >= 8) {
            this.contrasena = contrasena;
        } else {
            System.out.println("Error: La contraseña debe tener al menos 8 caracteres.");
        }
    }
    public void setEstadoDeLaCuenta(String estadoDeLaCuenta) {
        this.estadoDeLaCuenta = estadoDeLaCuenta;
    }

    //Métodos de negocio
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
        return "Datos del Usuario: " +
                "\n- ID: " + idUsuario +
                "\n- Nombres y Apellidos: " + nombresYApellidos +
                "\n- Correo Electrónico: " + correoElectronico +
                "\n- Teléfono: " + telefonoDeContacto +
                "\n- Sector / Dirección: " + sectorDireccion +
                "\n- Estado de la Cuenta: " + estadoDeLaCuenta;
    }
}