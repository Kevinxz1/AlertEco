package Dominio;

import java.util.Objects;

public abstract class Usuario {

    protected int idUsuario;
    protected String nombresYApellidos;
    protected String correoElectronico;
    protected String telefonoDeContacto;
    protected String sectorDireccion;
    protected String contrasena;
    protected String estadoDeLaCuenta;

    //sin parametros
    public Usuario() {
        this(1, "Kevin Galeas", "kevin@gmail.com", "0999999999",
                "Centro Norte", "12345678", "Activo");
    }

    //constructor parametrizado
    public Usuario(int idUsuario, String nombresYApellidos, String correoElectronico,
                   String telefonoDeContacto, String sectorDireccion, String contrasena,
                   String estadoDeLaCuenta) {
        // Valores seguros por defecto en caso de recibir algún dato inválido
        this.idUsuario = 1;
        this.nombresYApellidos = "Kevin Galeas";
        this.correoElectronico = "kevin@gmail.com";
        this.telefonoDeContacto = "0999999999";
        this.sectorDireccion = "Centro Norte";
        this.contrasena = "12345678";
        this.estadoDeLaCuenta = "Activo";

        setIdUsuario(idUsuario);
        setNombresYApellidos(nombresYApellidos);
        setCorreoElectronico(correoElectronico);
        setTelefonoDeContacto(telefonoDeContacto);
        setSectorDireccion(sectorDireccion);
        setContrasena(contrasena);
        setEstadoDeLaCuenta(estadoDeLaCuenta);
    }

    //Constructor copia (sobrecarga con parámetro referencia y this)
    public Usuario(Usuario otro) {
        this(otro != null ? otro.idUsuario : 1,
                otro != null ? otro.nombresYApellidos : "Kevin Galeas",
                otro != null ? otro.correoElectronico : "kevin@gmail.com",
                otro != null ? otro.telefonoDeContacto : "0999999999",
                otro != null ? otro.sectorDireccion : "Centro Norte",
                otro != null ? otro.contrasena : "12345678",
                otro != null ? otro.estadoDeLaCuenta : "Activo");
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
        if (telefonoDeContacto != null && !telefonoDeContacto.trim().isEmpty()) {
            this.telefonoDeContacto = telefonoDeContacto;
        } else {
            System.out.println("Error: El teléfono de contacto no puede estar vacío.");
        }
    }

    public void setSectorDireccion(String sectorDireccion) {
        if (sectorDireccion != null && !sectorDireccion.trim().isEmpty()) {
            this.sectorDireccion = sectorDireccion;
        } else {
            System.out.println("Error: El sector o dirección no puede estar vacío.");
        }
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
        if (estadoDeLaCuenta != null && !estadoDeLaCuenta.trim().isEmpty()) {
            this.estadoDeLaCuenta = estadoDeLaCuenta;
        } else {
            System.out.println("Error: El estado de la cuenta no puede estar vacío.");
        }
    }

    //Métodos de negocio
    public boolean validarCredenciales(String correo, String contrasena) {
        return this.correoElectronico != null && this.correoElectronico.equals(correo) &&
                this.contrasena != null && this.contrasena.equals(contrasena);
    }

    //Sobrecarga con parámetro referencia de objeto
    public boolean validarCredenciales(Usuario otroUsuario) {
        if (otroUsuario == null) {
            return false;
        }
        return validarCredenciales(otroUsuario.getCorreoElectronico(), otroUsuario.getContrasena());
    }

    public void registrarCuenta() {
        this.estadoDeLaCuenta = "Activo";
    }

    public void actualizarCuenta() {
    }

    //Sobrecarga con parámetro referencia de objeto
    public boolean actualizarCuenta(Usuario nuevosDatos) {
        if (nuevosDatos == null) {
            return false;
        }
        setNombresYApellidos(nuevosDatos.getNombresYApellidos());
        setCorreoElectronico(nuevosDatos.getCorreoElectronico());
        setTelefonoDeContacto(nuevosDatos.getTelefonoDeContacto());
        setSectorDireccion(nuevosDatos.getSectorDireccion());
        setContrasena(nuevosDatos.getContrasena());
        setEstadoDeLaCuenta(nuevosDatos.getEstadoDeLaCuenta());
        return true;
    }

    public Usuario consultarCuenta() {
        return this;
    }

    public void eliminarCuenta() {
        this.estadoDeLaCuenta = "Inactivo";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Usuario)) {
            return false;
        }
        Usuario otro = (Usuario) obj;
        return this.idUsuario == otro.idUsuario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario);
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