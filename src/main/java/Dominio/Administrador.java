package Dominio;

import java.util.Arrays;
public class Administrador extends Usuario {

    private LugarDeAcopio[] lugaresDeAcopioGestionados;
    private GuiaDeReciclaje[] guiasPublicadas;
    private ReporteDePuntoCritico[] reportesResueltos;


    public Administrador() {
        super();
    }

    public Administrador(LugarDeAcopio[] lugaresDeAcopioGestionados, GuiaDeReciclaje[] guiasPublicadas,
                         ReporteDePuntoCritico[] reportesResueltos) {
        super();
        this.lugaresDeAcopioGestionados = lugaresDeAcopioGestionados;
        this.guiasPublicadas = guiasPublicadas;
        this.reportesResueltos = reportesResueltos;
    }

    public LugarDeAcopio[] getLugaresDeAcopioGestionados() {
        return lugaresDeAcopioGestionados;
    }

    public void setLugaresDeAcopioGestionados(LugarDeAcopio[] lugaresDeAcopioGestionados) {
        this.lugaresDeAcopioGestionados = lugaresDeAcopioGestionados;
    }

    public GuiaDeReciclaje[] getGuiasPublicadas() {
        return guiasPublicadas;
    }

    public void setGuiasPublicadas(GuiaDeReciclaje[] guiasPublicadas) {
        this.guiasPublicadas = guiasPublicadas;
    }

    public ReporteDePuntoCritico[] getReportesResueltos() {
        return reportesResueltos;
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