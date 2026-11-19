package Dominio;

import java.util.Arrays;
import java.util.Objects;

public class UsuarioDelHogar extends Usuario {

    private EntregaDeReciclaje[] entregasRegistradas;
    private ReporteDePuntoCritico[] reportesCreados;
    private Recordatorio[] recordatorios;

    //sin parametros
    public UsuarioDelHogar() {
        this(new EntregaDeReciclaje[0], new ReporteDePuntoCritico[0], new Recordatorio[0]);
    }

    //constructor parametrizado
    public UsuarioDelHogar(int idUsuario, String nombresYApellidos, String correoElectronico,
                           String telefonoDeContacto, String sectorDireccion, String contrasena,
                           String estadoDeLaCuenta) {
        this(idUsuario, nombresYApellidos, correoElectronico, telefonoDeContacto,
                sectorDireccion, contrasena, estadoDeLaCuenta,
                new EntregaDeReciclaje[0], new ReporteDePuntoCritico[0], new Recordatorio[0]);
    }

    public UsuarioDelHogar(EntregaDeReciclaje[] entregasRegistradas, ReporteDePuntoCritico[] reportesCreados,
                           Recordatorio[] recordatorios) {
        super();
        this.entregasRegistradas = new EntregaDeReciclaje[0];
        this.reportesCreados = new ReporteDePuntoCritico[0];
        this.recordatorios = new Recordatorio[0];
        setEntregasRegistradas(entregasRegistradas);
        setReportesCreados(reportesCreados);
        setRecordatorios(recordatorios);
    }

    //Constructor completo (Usuario + UsuarioDelHogar)
    public UsuarioDelHogar(int idUsuario, String nombresYApellidos, String correoElectronico,
                           String telefonoDeContacto, String sectorDireccion, String contrasena,
                           String estadoDeLaCuenta, EntregaDeReciclaje[] entregasRegistradas,
                           ReporteDePuntoCritico[] reportesCreados, Recordatorio[] recordatorios) {
        super(idUsuario, nombresYApellidos, correoElectronico, telefonoDeContacto,
                sectorDireccion, contrasena, estadoDeLaCuenta);
        this.entregasRegistradas = new EntregaDeReciclaje[0];
        this.reportesCreados = new ReporteDePuntoCritico[0];
        this.recordatorios = new Recordatorio[0];
        setEntregasRegistradas(entregasRegistradas);
        setReportesCreados(reportesCreados);
        setRecordatorios(recordatorios);
    }

    //Constructor copia (sobrecarga con parámetro referencia y this)
    public UsuarioDelHogar(UsuarioDelHogar otro) {
        this(otro != null ? otro.getIdUsuario() : 1,
                otro != null ? otro.getNombresYApellidos() : "Kevin Galeas",
                otro != null ? otro.getCorreoElectronico() : "kevin@gmail.com",
                otro != null ? otro.getTelefonoDeContacto() : "0999999999",
                otro != null ? otro.getSectorDireccion() : "Centro Norte",
                otro != null ? otro.getContrasena() : "12345678",
                otro != null ? otro.getEstadoDeLaCuenta() : "Activo",
                otro != null ? Arrays.copyOf(otro.entregasRegistradas, otro.entregasRegistradas.length) : new EntregaDeReciclaje[0],
                otro != null ? Arrays.copyOf(otro.reportesCreados, otro.reportesCreados.length) : new ReporteDePuntoCritico[0],
                otro != null ? Arrays.copyOf(otro.recordatorios, otro.recordatorios.length) : new Recordatorio[0]);
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

    //Métodos de negocio

    //crud-
    public boolean crearEntregaRegistrada(EntregaDeReciclaje entrega) {
        if (entrega == null || buscarEntregaRegistrada(entrega) != null) {
            return false;
        }
        EntregaDeReciclaje[] nuevoArreglo = Arrays.copyOf(entregasRegistradas, entregasRegistradas.length + 1);
        nuevoArreglo[entregasRegistradas.length] = entrega;
        this.entregasRegistradas = nuevoArreglo;
        return true;
    }

    public String consultarEntregasRegistradas() {
        if (entregasRegistradas.length == 0) {
            return "No existen entregas registradas.";
        }
        StringBuilder sb = new StringBuilder("Entregas registradas:");
        for (int i = 0; i < entregasRegistradas.length; i++) {
            sb.append("\n[").append(i).append("] ").append(entregasRegistradas[i]);
        }
        return sb.toString();
    }

    public EntregaDeReciclaje buscarEntregaRegistrada(EntregaDeReciclaje entrega) {
        if (entrega == null) {
            return null;
        }
        for (EntregaDeReciclaje actual : entregasRegistradas) {
            if (actual != null && actual.equals(entrega)) {
                return actual;
            }
        }
        return null;
    }

    public EntregaDeReciclaje buscarEntregaRegistrada(int indice) {
        if (indice < 0 || indice >= entregasRegistradas.length) {
            return null;
        }
        return entregasRegistradas[indice];
    }

    public boolean editarEntregaRegistrada(int indice, EntregaDeReciclaje nuevaEntrega) {
        if (indice < 0 || indice >= entregasRegistradas.length || nuevaEntrega == null) {
            return false;
        }
        for (int i = 0; i < entregasRegistradas.length; i++) {
            if (i != indice && entregasRegistradas[i] != null && entregasRegistradas[i].equals(nuevaEntrega)) {
                return false;
            }
        }
        entregasRegistradas[indice] = nuevaEntrega;
        return true;
    }

    public boolean editarEntregaRegistrada(EntregaDeReciclaje actual, EntregaDeReciclaje nuevaEntrega) {
        if (actual == null || nuevaEntrega == null) {
            return false;
        }
        for (int i = 0; i < entregasRegistradas.length; i++) {
            if (entregasRegistradas[i] != null && entregasRegistradas[i].equals(actual)) {
                return editarEntregaRegistrada(i, nuevaEntrega);
            }
        }
        return false;
    }

    public boolean eliminarEntregaRegistrada(int indice) {
        if (indice < 0 || indice >= entregasRegistradas.length) {
            return false;
        }
        EntregaDeReciclaje[] nuevoArreglo = new EntregaDeReciclaje[entregasRegistradas.length - 1];
        for (int i = 0, j = 0; i < entregasRegistradas.length; i++) {
            if (i != indice) {
                nuevoArreglo[j++] = entregasRegistradas[i];
            }
        }
        this.entregasRegistradas = nuevoArreglo;
        return true;
    }

    public boolean eliminarEntregaRegistrada(EntregaDeReciclaje entrega) {
        if (entrega == null) {
            return false;
        }
        for (int i = 0; i < entregasRegistradas.length; i++) {
            if (entregasRegistradas[i] != null && entregasRegistradas[i].equals(entrega)) {
                return eliminarEntregaRegistrada(i);
            }
        }
        return false;
    }

    //CRUD: Reportes Creados
    public boolean crearReporteCreado(ReporteDePuntoCritico reporte) {
        if (reporte == null || buscarReporteCreado(reporte) != null) {
            return false;
        }
        ReporteDePuntoCritico[] nuevoArreglo = Arrays.copyOf(reportesCreados, reportesCreados.length + 1);
        nuevoArreglo[reportesCreados.length] = reporte;
        this.reportesCreados = nuevoArreglo;
        return true;
    }

    public String consultarReportesCreados() {
        if (reportesCreados.length == 0) {
            return "No existen reportes creados.";
        }
        StringBuilder sb = new StringBuilder("Reportes creados:");
        for (int i = 0; i < reportesCreados.length; i++) {
            sb.append("\n[").append(i).append("] ").append(reportesCreados[i]);
        }
        return sb.toString();
    }

    public ReporteDePuntoCritico buscarReporteCreado(ReporteDePuntoCritico reporte) {
        if (reporte == null) {
            return null;
        }
        for (ReporteDePuntoCritico actual : reportesCreados) {
            if (actual != null && actual.equals(reporte)) {
                return actual;
            }
        }
        return null;
    }

    public ReporteDePuntoCritico buscarReporteCreado(int indice) {
        if (indice < 0 || indice >= reportesCreados.length) {
            return null;
        }
        return reportesCreados[indice];
    }

    public boolean editarReporteCreado(int indice, ReporteDePuntoCritico nuevoReporte) {
        if (indice < 0 || indice >= reportesCreados.length || nuevoReporte == null) {
            return false;
        }
        for (int i = 0; i < reportesCreados.length; i++) {
            if (i != indice && reportesCreados[i] != null && reportesCreados[i].equals(nuevoReporte)) {
                return false;
            }
        }
        reportesCreados[indice] = nuevoReporte;
        return true;
    }

    public boolean editarReporteCreado(ReporteDePuntoCritico actual, ReporteDePuntoCritico nuevoReporte) {
        if (actual == null || nuevoReporte == null) {
            return false;
        }
        for (int i = 0; i < reportesCreados.length; i++) {
            if (reportesCreados[i] != null && reportesCreados[i].equals(actual)) {
                return editarReporteCreado(i, nuevoReporte);
            }
        }
        return false;
    }

    public boolean eliminarReporteCreado(int indice) {
        if (indice < 0 || indice >= reportesCreados.length) {
            return false;
        }
        ReporteDePuntoCritico[] nuevoArreglo = new ReporteDePuntoCritico[reportesCreados.length - 1];
        for (int i = 0, j = 0; i < reportesCreados.length; i++) {
            if (i != indice) {
                nuevoArreglo[j++] = reportesCreados[i];
            }
        }
        this.reportesCreados = nuevoArreglo;
        return true;
    }

    public boolean eliminarReporteCreado(ReporteDePuntoCritico reporte) {
        if (reporte == null) {
            return false;
        }
        for (int i = 0; i < reportesCreados.length; i++) {
            if (reportesCreados[i] != null && reportesCreados[i].equals(reporte)) {
                return eliminarReporteCreado(i);
            }
        }
        return false;
    }

    //CRUD: Recordatorios (Relación 1 a muchos - Composición) ---
    public boolean crearRecordatorio(Recordatorio recordatorio) {
        if (recordatorio == null || buscarRecordatorio(recordatorio) != null) {
            return false;
        }
        Recordatorio[] nuevoArreglo = Arrays.copyOf(recordatorios, recordatorios.length + 1);
        nuevoArreglo[recordatorios.length] = recordatorio;
        this.recordatorios = nuevoArreglo;
        return true;
    }

    public String consultarRecordatorios() {
        if (recordatorios.length == 0) {
            return "No existen recordatorios registrados.";
        }
        StringBuilder sb = new StringBuilder("Recordatorios:");
        for (int i = 0; i < recordatorios.length; i++) {
            sb.append("\n[").append(i).append("] ").append(recordatorios[i]);
        }
        return sb.toString();
    }

    public Recordatorio buscarRecordatorio(Recordatorio recordatorio) {
        if (recordatorio == null) {
            return null;
        }
        for (Recordatorio actual : recordatorios) {
            if (actual != null && actual.equals(recordatorio)) {
                return actual;
            }
        }
        return null;
    }

    public Recordatorio buscarRecordatorio(int indice) {
        if (indice < 0 || indice >= recordatorios.length) {
            return null;
        }
        return recordatorios[indice];
    }

    public boolean editarRecordatorio(int indice, Recordatorio nuevoRecordatorio) {
        if (indice < 0 || indice >= recordatorios.length || nuevoRecordatorio == null) {
            return false;
        }
        for (int i = 0; i < recordatorios.length; i++) {
            if (i != indice && recordatorios[i] != null && recordatorios[i].equals(nuevoRecordatorio)) {
                return false;
            }
        }
        recordatorios[indice] = nuevoRecordatorio;
        return true;
    }

    public boolean editarRecordatorio(Recordatorio actual, Recordatorio nuevoRecordatorio) {
        if (actual == null || nuevoRecordatorio == null) {
            return false;
        }
        for (int i = 0; i < recordatorios.length; i++) {
            if (recordatorios[i] != null && recordatorios[i].equals(actual)) {
                return editarRecordatorio(i, nuevoRecordatorio);
            }
        }
        return false;
    }

    public boolean eliminarRecordatorio(int indice) {
        if (indice < 0 || indice >= recordatorios.length) {
            return false;
        }
        Recordatorio[] nuevoArreglo = new Recordatorio[recordatorios.length - 1];
        for (int i = 0, j = 0; i < recordatorios.length; i++) {
            if (i != indice) {
                nuevoArreglo[j++] = recordatorios[i];
            }
        }
        this.recordatorios = nuevoArreglo;
        return true;
    }

    public boolean eliminarRecordatorio(Recordatorio recordatorio) {
        if (recordatorio == null) {
            return false;
        }
        for (int i = 0; i < recordatorios.length; i++) {
            if (recordatorios[i] != null && recordatorios[i].equals(recordatorio)) {
                return eliminarRecordatorio(i);
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UsuarioDelHogar)) {
            return false;
        }
        UsuarioDelHogar otro = (UsuarioDelHogar) obj;
        return super.equals(otro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), UsuarioDelHogar.class);
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