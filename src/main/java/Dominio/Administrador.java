package Dominio;

import java.util.Arrays;

public class Administrador extends Usuario {

    private LugarDeAcopio[] lugaresDeAcopioGestionados;
    private GuiaDeReciclaje[] guiasPublicadas;
    private ReporteDePuntoCritico[] reportesResueltos;

    public Administrador() {
        super();
    }

    // Constructor con los datos heredados de Usuario
    public Administrador(int idUsuario, String nombresYApellidos, String correoElectronico,
                         String telefonoDeContacto, String sectorDireccion, String contrasena,
                         String estadoDeLaCuenta) {
        super(idUsuario, nombresYApellidos, correoElectronico, telefonoDeContacto, sectorDireccion, contrasena, estadoDeLaCuenta);
    }

    // Constructor solo con los arreglos de Administrador
    public Administrador(LugarDeAcopio[] lugaresDeAcopioGestionados, GuiaDeReciclaje[] guiasPublicadas,
                         ReporteDePuntoCritico[] reportesResueltos) {
        super();
        this.lugaresDeAcopioGestionados = lugaresDeAcopioGestionados;
        this.guiasPublicadas = guiasPublicadas;
        this.reportesResueltos = reportesResueltos;
    }

    // Constructor completo (Usuario + Administrador)
    public Administrador(int idUsuario, String nombresYApellidos, String correoElectronico,
                         String telefonoDeContacto, String sectorDireccion, String contrasena,
                         String estadoDeLaCuenta, LugarDeAcopio[] lugaresDeAcopioGestionados,
                         GuiaDeReciclaje[] guiasPublicadas, ReporteDePuntoCritico[] reportesResueltos) {
        super(idUsuario, nombresYApellidos, correoElectronico, telefonoDeContacto, sectorDireccion, contrasena, estadoDeLaCuenta);
        this.lugaresDeAcopioGestionados = lugaresDeAcopioGestionados;
        this.guiasPublicadas = guiasPublicadas;
        this.reportesResueltos = reportesResueltos;
    }

    //get

    public LugarDeAcopio[] getLugaresDeAcopioGestionados() {
        return lugaresDeAcopioGestionados;
    }

    public GuiaDeReciclaje[] getGuiasPublicadas() {
        return guiasPublicadas;
    }

    public ReporteDePuntoCritico[] getReportesResueltos() {
        return reportesResueltos;
    }


    //set

    public void setLugaresDeAcopioGestionados(LugarDeAcopio[] lugaresDeAcopioGestionados) {
        this.lugaresDeAcopioGestionados = lugaresDeAcopioGestionados;
    }

    public void setGuiasPublicadas(GuiaDeReciclaje[] guiasPublicadas) {
        this.guiasPublicadas = guiasPublicadas;
    }

    public void setReportesResueltos(ReporteDePuntoCritico[] reportesResueltos) {
        this.reportesResueltos = reportesResueltos;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "lugaresDeAcopioGestionados=" + Arrays.toString(lugaresDeAcopioGestionados) +
                ", guiasPublicadas=" + Arrays.toString(guiasPublicadas) +
                ", reportesResueltos=" + Arrays.toString(reportesResueltos) +
                "} " + super.toString();
    }
}