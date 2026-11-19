package Dominio;

import java.util.Arrays;
import java.util.Objects;

public class Administrador extends Usuario {

    private LugarDeAcopio[] lugaresDeAcopioGestionados;
    private GuiaDeReciclaje[] guiasPublicadas;
    private ReporteDePuntoCritico[] reportesResueltos;

    //sin parametros
    public Administrador() {
        this(new LugarDeAcopio[0], new GuiaDeReciclaje[0], new ReporteDePuntoCritico[0]);
    }

    //constructor parametrizado
    //Constructor con los datos heredados de Usuario (sobrecarga con this)
    public Administrador(int idUsuario, String nombresYApellidos, String correoElectronico,
                         String telefonoDeContacto, String sectorDireccion, String contrasena,
                         String estadoDeLaCuenta) {
        this(idUsuario, nombresYApellidos, correoElectronico, telefonoDeContacto,
                sectorDireccion, contrasena, estadoDeLaCuenta,
                new LugarDeAcopio[0], new GuiaDeReciclaje[0], new ReporteDePuntoCritico[0]);
    }

    //Constructor solo con los arreglos de Administrador (sobrecarga con super)
    public Administrador(LugarDeAcopio[] lugaresDeAcopioGestionados, GuiaDeReciclaje[] guiasPublicadas,
                         ReporteDePuntoCritico[] reportesResueltos) {
        super();
        this.lugaresDeAcopioGestionados = new LugarDeAcopio[0];
        this.guiasPublicadas = new GuiaDeReciclaje[0];
        this.reportesResueltos = new ReporteDePuntoCritico[0];
        setLugaresDeAcopioGestionados(lugaresDeAcopioGestionados);
        setGuiasPublicadas(guiasPublicadas);
        setReportesResueltos(reportesResueltos);
    }

    //Constructor completo (Usuario + Administrador)
    public Administrador(int idUsuario, String nombresYApellidos, String correoElectronico,
                         String telefonoDeContacto, String sectorDireccion, String contrasena,
                         String estadoDeLaCuenta, LugarDeAcopio[] lugaresDeAcopioGestionados,
                         GuiaDeReciclaje[] guiasPublicadas, ReporteDePuntoCritico[] reportesResueltos) {
        super(idUsuario, nombresYApellidos, correoElectronico, telefonoDeContacto,
                sectorDireccion, contrasena, estadoDeLaCuenta);
        this.lugaresDeAcopioGestionados = new LugarDeAcopio[0];
        this.guiasPublicadas = new GuiaDeReciclaje[0];
        this.reportesResueltos = new ReporteDePuntoCritico[0];
        setLugaresDeAcopioGestionados(lugaresDeAcopioGestionados);
        setGuiasPublicadas(guiasPublicadas);
        setReportesResueltos(reportesResueltos);
    }

    //Constructor copia (sobrecarga con parámetro referencia y this)
    public Administrador(Administrador otro) {
        this(otro != null ? otro.getIdUsuario() : 1,
                otro != null ? otro.getNombresYApellidos() : "Sin nombre",
                otro != null ? otro.getCorreoElectronico() : "correo@alerteco.com",
                otro != null ? otro.getTelefonoDeContacto() : "0999999999",
                otro != null ? otro.getSectorDireccion() : "Sin sector",
                otro != null ? otro.getContrasena() : "Admin1234",
                otro != null ? otro.getEstadoDeLaCuenta() : "Activo",
                otro != null ? Arrays.copyOf(otro.lugaresDeAcopioGestionados, otro.lugaresDeAcopioGestionados.length) : new LugarDeAcopio[0],
                otro != null ? Arrays.copyOf(otro.guiasPublicadas, otro.guiasPublicadas.length) : new GuiaDeReciclaje[0],
                otro != null ? Arrays.copyOf(otro.reportesResueltos, otro.reportesResueltos.length) : new ReporteDePuntoCritico[0]);
    }

    //Get
    public LugarDeAcopio[] getLugaresDeAcopioGestionados() {
        return lugaresDeAcopioGestionados;
    }

    public GuiaDeReciclaje[] getGuiasPublicadas() {
        return guiasPublicadas;
    }

    public ReporteDePuntoCritico[] getReportesResueltos() {
        return reportesResueltos;
    }

    //Set
    public void setLugaresDeAcopioGestionados(LugarDeAcopio[] lugaresDeAcopioGestionados) {
        if (lugaresDeAcopioGestionados != null) {
            this.lugaresDeAcopioGestionados = lugaresDeAcopioGestionados;
        }
    }

    public void setGuiasPublicadas(GuiaDeReciclaje[] guiasPublicadas) {
        if (guiasPublicadas != null) {
            this.guiasPublicadas = guiasPublicadas;
        }
    }

    public void setReportesResueltos(ReporteDePuntoCritico[] reportesResueltos) {
        if (reportesResueltos != null) {
            this.reportesResueltos = reportesResueltos;
        }
    }

    //Métodos de negocio

    // --- CRUD: Lugares de Acopio (Relación 1 a muchos - Agregación) ---
    public boolean crearLugarDeAcopio(LugarDeAcopio lugar) {
        if (lugar == null || buscarLugarDeAcopio(lugar) != null) {
            return false;
        }
        LugarDeAcopio[] nuevoArreglo = Arrays.copyOf(lugaresDeAcopioGestionados, lugaresDeAcopioGestionados.length + 1);
        nuevoArreglo[lugaresDeAcopioGestionados.length] = lugar;
        this.lugaresDeAcopioGestionados = nuevoArreglo;
        return true;
    }

    public String consultarLugaresDeAcopio() {
        if (lugaresDeAcopioGestionados.length == 0) {
            return "No existen lugares de acopio gestionados registrados.";
        }
        StringBuilder sb = new StringBuilder("Lugares de acopio gestionados:");
        for (int i = 0; i < lugaresDeAcopioGestionados.length; i++) {
            sb.append("\n[").append(i).append("] ").append(lugaresDeAcopioGestionados[i]);
        }
        return sb.toString();
    }

    public LugarDeAcopio buscarLugarDeAcopio(LugarDeAcopio lugar) {
        if (lugar == null) {
            return null;
        }
        for (LugarDeAcopio actual : lugaresDeAcopioGestionados) {
            if (actual != null && actual.equals(lugar)) {
                return actual;
            }
        }
        return null;
    }

    public LugarDeAcopio buscarLugarDeAcopio(int indice) {
        if (indice < 0 || indice >= lugaresDeAcopioGestionados.length) {
            return null;
        }
        return lugaresDeAcopioGestionados[indice];
    }

    public boolean editarLugarDeAcopio(int indice, LugarDeAcopio nuevoLugar) {
        if (indice < 0 || indice >= lugaresDeAcopioGestionados.length || nuevoLugar == null) {
            return false;
        }
        for (int i = 0; i < lugaresDeAcopioGestionados.length; i++) {
            if (i != indice && lugaresDeAcopioGestionados[i] != null && lugaresDeAcopioGestionados[i].equals(nuevoLugar)) {
                return false;
            }
        }
        lugaresDeAcopioGestionados[indice] = nuevoLugar;
        return true;
    }

    public boolean editarLugarDeAcopio(LugarDeAcopio actual, LugarDeAcopio nuevoLugar) {
        if (actual == null || nuevoLugar == null) {
            return false;
        }
        for (int i = 0; i < lugaresDeAcopioGestionados.length; i++) {
            if (lugaresDeAcopioGestionados[i] != null && lugaresDeAcopioGestionados[i].equals(actual)) {
                return editarLugarDeAcopio(i, nuevoLugar);
            }
        }
        return false;
    }

    public boolean eliminarLugarDeAcopio(int indice) {
        if (indice < 0 || indice >= lugaresDeAcopioGestionados.length) {
            return false;
        }
        LugarDeAcopio[] nuevoArreglo = new LugarDeAcopio[lugaresDeAcopioGestionados.length - 1];
        for (int i = 0, j = 0; i < lugaresDeAcopioGestionados.length; i++) {
            if (i != indice) {
                nuevoArreglo[j++] = lugaresDeAcopioGestionados[i];
            }
        }
        this.lugaresDeAcopioGestionados = nuevoArreglo;
        return true;
    }

    public boolean eliminarLugarDeAcopio(LugarDeAcopio lugar) {
        if (lugar == null) {
            return false;
        }
        for (int i = 0; i < lugaresDeAcopioGestionados.length; i++) {
            if (lugaresDeAcopioGestionados[i] != null && lugaresDeAcopioGestionados[i].equals(lugar)) {
                return eliminarLugarDeAcopio(i);
            }
        }
        return false;
    }

    // --- CRUD: Guías de Reciclaje (Relación 1 a muchos - Agregación) ---
    public boolean crearGuiaPublicada(GuiaDeReciclaje guia) {
        if (guia == null || buscarGuiaPublicada(guia) != null) {
            return false;
        }
        GuiaDeReciclaje[] nuevoArreglo = Arrays.copyOf(guiasPublicadas, guiasPublicadas.length + 1);
        nuevoArreglo[guiasPublicadas.length] = guia;
        this.guiasPublicadas = nuevoArreglo;
        return true;
    }

    public String consultarGuiasPublicadas() {
        if (guiasPublicadas.length == 0) {
            return "No existen guías publicadas registradas.";
        }
        StringBuilder sb = new StringBuilder("Guías de reciclaje publicadas:");
        for (int i = 0; i < guiasPublicadas.length; i++) {
            sb.append("\n[").append(i).append("] ").append(guiasPublicadas[i]);
        }
        return sb.toString();
    }

    public GuiaDeReciclaje buscarGuiaPublicada(GuiaDeReciclaje guia) {
        if (guia == null) {
            return null;
        }
        for (GuiaDeReciclaje actual : guiasPublicadas) {
            if (actual != null && actual.equals(guia)) {
                return actual;
            }
        }
        return null;
    }

    public GuiaDeReciclaje buscarGuiaPublicada(int indice) {
        if (indice < 0 || indice >= guiasPublicadas.length) {
            return null;
        }
        return guiasPublicadas[indice];
    }

    public boolean editarGuiaPublicada(int indice, GuiaDeReciclaje nuevaGuia) {
        if (indice < 0 || indice >= guiasPublicadas.length || nuevaGuia == null) {
            return false;
        }
        for (int i = 0; i < guiasPublicadas.length; i++) {
            if (i != indice && guiasPublicadas[i] != null && guiasPublicadas[i].equals(nuevaGuia)) {
                return false;
            }
        }
        guiasPublicadas[indice] = nuevaGuia;
        return true;
    }

    public boolean editarGuiaPublicada(GuiaDeReciclaje actual, GuiaDeReciclaje nuevaGuia) {
        if (actual == null || nuevaGuia == null) {
            return false;
        }
        for (int i = 0; i < guiasPublicadas.length; i++) {
            if (guiasPublicadas[i] != null && guiasPublicadas[i].equals(actual)) {
                return editarGuiaPublicada(i, nuevaGuia);
            }
        }
        return false;
    }

    public boolean eliminarGuiaPublicada(int indice) {
        if (indice < 0 || indice >= guiasPublicadas.length) {
            return false;
        }
        GuiaDeReciclaje[] nuevoArreglo = new GuiaDeReciclaje[guiasPublicadas.length - 1];
        for (int i = 0, j = 0; i < guiasPublicadas.length; i++) {
            if (i != indice) {
                nuevoArreglo[j++] = guiasPublicadas[i];
            }
        }
        this.guiasPublicadas = nuevoArreglo;
        return true;
    }

    public boolean eliminarGuiaPublicada(GuiaDeReciclaje guia) {
        if (guia == null) {
            return false;
        }
        for (int i = 0; i < guiasPublicadas.length; i++) {
            if (guiasPublicadas[i] != null && guiasPublicadas[i].equals(guia)) {
                return eliminarGuiaPublicada(i);
            }
        }
        return false;
    }

    // --- CRUD: Reportes de Puntos Críticos Resueltos (Relación 1 a muchos - Agregación) ---
    public boolean crearReporteResuelto(ReporteDePuntoCritico reporte) {
        if (reporte == null || buscarReporteResuelto(reporte) != null) {
            return false;
        }
        ReporteDePuntoCritico[] nuevoArreglo = Arrays.copyOf(reportesResueltos, reportesResueltos.length + 1);
        nuevoArreglo[reportesResueltos.length] = reporte;
        this.reportesResueltos = nuevoArreglo;
        return true;
    }

    public String consultarReportesResueltos() {
        if (reportesResueltos.length == 0) {
            return "No existen reportes resueltos registrados.";
        }
        StringBuilder sb = new StringBuilder("Reportes de puntos críticos resueltos:");
        for (int i = 0; i < reportesResueltos.length; i++) {
            sb.append("\n[").append(i).append("] ").append(reportesResueltos[i]);
        }
        return sb.toString();
    }

    public ReporteDePuntoCritico buscarReporteResuelto(ReporteDePuntoCritico reporte) {
        if (reporte == null) {
            return null;
        }
        for (ReporteDePuntoCritico actual : reportesResueltos) {
            if (actual != null && actual.equals(reporte)) {
                return actual;
            }
        }
        return null;
    }

    public ReporteDePuntoCritico buscarReporteResuelto(int indice) {
        if (indice < 0 || indice >= reportesResueltos.length) {
            return null;
        }
        return reportesResueltos[indice];
    }

    public boolean editarReporteResuelto(int indice, ReporteDePuntoCritico nuevoReporte) {
        if (indice < 0 || indice >= reportesResueltos.length || nuevoReporte == null) {
            return false;
        }
        for (int i = 0; i < reportesResueltos.length; i++) {
            if (i != indice && reportesResueltos[i] != null && reportesResueltos[i].equals(nuevoReporte)) {
                return false;
            }
        }
        reportesResueltos[indice] = nuevoReporte;
        return true;
    }

    public boolean editarReporteResuelto(ReporteDePuntoCritico actual, ReporteDePuntoCritico nuevoReporte) {
        if (actual == null || nuevoReporte == null) {
            return false;
        }
        for (int i = 0; i < reportesResueltos.length; i++) {
            if (reportesResueltos[i] != null && reportesResueltos[i].equals(actual)) {
                return editarReporteResuelto(i, nuevoReporte);
            }
        }
        return false;
    }

    public boolean eliminarReporteResuelto(int indice) {
        if (indice < 0 || indice >= reportesResueltos.length) {
            return false;
        }
        ReporteDePuntoCritico[] nuevoArreglo = new ReporteDePuntoCritico[reportesResueltos.length - 1];
        for (int i = 0, j = 0; i < reportesResueltos.length; i++) {
            if (i != indice) {
                nuevoArreglo[j++] = reportesResueltos[i];
            }
        }
        this.reportesResueltos = nuevoArreglo;
        return true;
    }

    public boolean eliminarReporteResuelto(ReporteDePuntoCritico reporte) {
        if (reporte == null) {
            return false;
        }
        for (int i = 0; i < reportesResueltos.length; i++) {
            if (reportesResueltos[i] != null && reportesResueltos[i].equals(reporte)) {
                return eliminarReporteResuelto(i);
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Administrador)) {
            return false;
        }
        Administrador otro = (Administrador) obj;
        return super.equals(otro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Administrador.class);
    }

    @Override
    public String toString() {
        return "Administrador:" +
                "\n" + super.toString() +
                "\n- Lugares de acopio gestionados (" + lugaresDeAcopioGestionados.length + "): " + Arrays.toString(lugaresDeAcopioGestionados) +
                "\n- Guías publicadas (" + guiasPublicadas.length + "): " + Arrays.toString(guiasPublicadas) +
                "\n- Reportes resueltos (" + reportesResueltos.length + "): " + Arrays.toString(reportesResueltos);
    }
}