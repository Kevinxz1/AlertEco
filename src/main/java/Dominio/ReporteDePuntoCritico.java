package Dominio;

import java.time.LocalDateTime;

public class ReporteDePuntoCritico {

    private String descripcion;
    private String estadoRuta;
    private LocalDateTime fechaReporte;

    //sin parametros
    public ReporteDePuntoCritico() {
        this.descripcion = "Acumulación de residuos en esquina principal";
        this.estadoRuta = "Pendiente";
        this.fechaReporte = LocalDateTime.now();
    }

    //constructor parametrizado
    public ReporteDePuntoCritico(String descripcion, String estadoRuta, LocalDateTime fechaReporte) {
        setDescripcion(descripcion);
        setEstadoRuta(estadoRuta);
        setFechaReporte(fechaReporte);
    }

    //Get
    public String getDescripcion() {
        return descripcion;
    }
    public String getEstadoRuta() {
        return estadoRuta;
    }
    public LocalDateTime getFechaReporte() {
        return fechaReporte;
    }

    //Set
    public void setDescripcion(String descripcion) {
        //Validación interna
        if (descripcion != null && !descripcion.trim().isEmpty()) {
            this.descripcion = descripcion;
        } else {
            System.out.println("Error: La descripción del reporte no puede estar vacía.");
        }
    }
    public void setEstadoRuta(String estadoRuta) {
        if (estadoRuta != null && !estadoRuta.trim().isEmpty()) {
            this.estadoRuta = estadoRuta;
        } else {
            System.out.println("Error: El estado de la ruta no puede estar vacío.");
        }
    }
    public void setFechaReporte(LocalDateTime fechaReporte) {
        if (fechaReporte != null) {
            this.fechaReporte = fechaReporte;
        } else {
            System.out.println("Error: La fecha del reporte no puede ser nula.");
        }
    }

    @Override
    public String toString() {
        return "Datos del Reporte de Punto Crítico: " +
                "\n- Descripción: " + descripcion +
                "\n- Estado de Ruta: " + estadoRuta +
                "\n- Fecha de Reporte: " + fechaReporte;
    }
}