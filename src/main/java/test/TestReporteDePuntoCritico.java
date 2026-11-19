package test;

import Dominio.ReporteDePuntoCritico;
import java.time.LocalDateTime;

public class TestReporteDePuntoCritico {
    public void probarReporte() {
        ReporteDePuntoCritico reporte = new ReporteDePuntoCritico(
                "Acumulacion de carton en Parque La Carolina",
                "Pendiente",
                LocalDateTime.now()
        );

        System.out.println("Test Reporte del Punto Critico (Antes llamado Estado del Contenedor");
        System.out.println("Descripción: " + reporte.getDescripcion());
        System.out.println("Estado de ruta: " + reporte.getEstadoRuta());
        System.out.println("Fecha del reporte: " + reporte.getFechaReporte());

        reporte.setEstadoRuta("Atendido");
        System.out.println("\nReporte actualizado:\n" + reporte.toString());
        System.out.println("----------------------------------");
    }
}