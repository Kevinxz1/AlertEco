package Dominio;

import java.util.Arrays;

public class UsuarioDelHogar extends Usuario {

    private EntregaDeReciclaje[] entregasRegistradas;
    private ReporteDePuntoCritico[] reportesCreados;
    private Recordatorio[] recordatorios;

    //sin parametros
    public UsuarioDelHogar() {
        super();
        this.entregasRegistradas = new EntregaDeReciclaje[0];
        this.reportesCreados = new ReporteDePuntoCritico[0];
        this.recordatorios = new Recordatorio[0];
    }

    //constructor parametrizado
    public UsuarioDelHogar(int idUsuario, String nombresYApellidos, String correoElectronico,
                           String telefonoDeContacto, String sectorDireccion, String contrasena,
                           String estadoDeLaCuenta) {
        super(idUsuario, nombresYApellidos, correoElectronico, telefonoDeContacto,
                sectorDireccion, contrasena, estadoDeLaCuenta);
        this.entregasRegistradas = new EntregaDeReciclaje[0];
        this.reportesCreados = new ReporteDePuntoCritico[0];
        this.recordatorios = new Recordatorio[0];
    }

    public UsuarioDelHogar(EntregaDeReciclaje[] entregasRegistradas, ReporteDePuntoCritico[] reportesCreados,
                           Recordatorio[] recordatorios) {
        super();
        setEntregasRegistradas(entregasRegistradas);
        setReportesCreados(reportesCreados);
        setRecordatorios(recordatorios);
    }

    //Get
    public EntregaDeReciclaje[] getEntregasRegistradas() {
        return entregasRegistradas;
    }
    public ReporteDePuntoCritico[] getReportesCreados() {
        return reportesCreados;
    }
    public Recordatorio[] getRecordatorios() {
        return recordatorios;
    }

    //Set
    public void setEntregasRegistradas(EntregaDeReciclaje[] entregasRegistradas) {
        //Validación interna
        if (entregasRegistradas != null) {
            this.entregasRegistradas = entregasRegistradas;
        } else {
            System.out.println("Error: Las entregas registradas no pueden ser nulas.");
        }
    }
    public void setReportesCreados(ReporteDePuntoCritico[] reportesCreados) {
        if (reportesCreados != null) {
            this.reportesCreados = reportesCreados;
        } else {
            System.out.println("Error: Los reportes creados no pueden ser nulos.");
        }
    }
    public void setRecordatorios(Recordatorio[] recordatorios) {
        if (recordatorios != null) {
            this.recordatorios = recordatorios;
        } else {
            System.out.println("Error: Los recordatorios no pueden ser nulos.");
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n- Rol: Usuario del Hogar" +
                "\n- Entregas Registradas: " + Arrays.toString(entregasRegistradas) +
                "\n- Reportes Creados: " + Arrays.toString(reportesCreados) +
                "\n- Recordatorios: " + Arrays.toString(recordatorios);
    }
}