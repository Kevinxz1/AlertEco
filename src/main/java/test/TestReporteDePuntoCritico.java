package test;

import Dominio.ReporteDePuntoCritico;

public class TestReporteDePuntoCritico {
    public void probarReporte() {
        ReporteDePuntoCritico reporte = new ReporteDePuntoCritico("Acumulacion de carton", "Parque La Carolina", "Pendiente");
        System.out.println("TEST REPORTE PUNTO CRITICO");
        System.out.println(reporte.getDescripcion());
        System.out.println(reporte.getUbicacion());
        System.out.println(reporte.getEstado());
        System.out.println("----------------------------------");
    }
}