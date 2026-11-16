package Dominio;

import java.util.Arrays;

public class UsuarioDelHogar extends Usuario {

    private EntregaDeReciclaje[] entregasRegistradas;
    private ReporteDePuntoCritico[] reportesCreados;
    private Recordatorio[] recordatorios;

    public UsuarioDelHogar() {
        super();
    }

    public UsuarioDelHogar(int idUsuario, String nombresYApellidos, String correoElectronico,
                           String telefonoDeContacto, String sectorDireccion, String contrasena,
                           String estadoDeLaCuenta) {
        super();
        this.setIdUsuario(idUsuario);
        this.setNombresYApellidos(nombresYApellidos);
        this.setCorreoElectronico(correoElectronico);
        this.setTelefonoDeContacto(telefonoDeContacto);
        this.setSectorDireccion(sectorDireccion);
        this.setContrasena(contrasena);
        this.setEstadoDeLaCuenta(estadoDeLaCuenta);
    }

    public UsuarioDelHogar(EntregaDeReciclaje[] entregasRegistradas, ReporteDePuntoCritico[] reportesCreados,
                           Recordatorio[] recordatorios) {
        super();
        this.entregasRegistradas = entregasRegistradas;
        this.reportesCreados = reportesCreados;
        this.recordatorios = recordatorios;
    }

    public EntregaDeReciclaje[] getEntregasRegistradas() {
        return entregasRegistradas;
    }

    public void setEntregasRegistradas(EntregaDeReciclaje[] entregasRegistradas) {
        this.entregasRegistradas = entregasRegistradas;
    }

    public ReporteDePuntoCritico[] getReportesCreados() {
        return reportesCreados;
    }

    public void setReportesCreados(ReporteDePuntoCritico[] reportesCreados) {
        this.reportesCreados = reportesCreados;
    }

    public Recordatorio[] getRecordatorios() {
        return recordatorios;
    }

    public void setRecordatorios(Recordatorio[] recordatorios) {
        this.recordatorios = recordatorios;
    }

    @Override
    public String toString() {
        return "UsuarioDelHogar{" +
                "entregasRegistradas=" + Arrays.toString(entregasRegistradas) +
                ", reportesCreados=" + Arrays.toString(reportesCreados) +
                ", recordatorios=" + Arrays.toString(recordatorios) +
                "} " + super.toString();
    }
}