package Dominio;

import java.time.LocalDateTime;
import java.util.Objects;

public class ReporteDePuntoCritico {

    private String descripcion;
    private String estadoRuta;
    private LocalDateTime fechaReporte;
    // Relación 1 a 1 (Asociación con un objeto)
    private LugarDeAcopio lugarDeAcopio;

    //sin parametros
    public ReporteDePuntoCritico() {
        this("Acumulación de residuos en esquina principal", "Pendiente",
                LocalDateTime.now(), new LugarDeAcopio());
    }

    //constructor parametrizado (mantiene firma original usando this)
    public ReporteDePuntoCritico(String descripcion, String estadoRuta, LocalDateTime fechaReporte) {
        this(descripcion, estadoRuta, fechaReporte, new LugarDeAcopio());
    }

    //Sobrecarga de constructor completo (incluye relación 1 a 1 con LugarDeAcopio)
    public ReporteDePuntoCritico(String descripcion, String estadoRuta, LocalDateTime fechaReporte,
                                 LugarDeAcopio lugarDeAcopio) {
        this.descripcion = "Acumulación de residuos en esquina principal";
        this.estadoRuta = "Pendiente";
        this.fechaReporte = LocalDateTime.now();
        this.lugarDeAcopio = new LugarDeAcopio();

        setDescripcion(descripcion);
        setEstadoRuta(estadoRuta);
        setFechaReporte(fechaReporte);
        setLugarDeAcopio(lugarDeAcopio);
    }

    //Constructor copia (sobrecarga con parámetro referencia y this)
    public ReporteDePuntoCritico(ReporteDePuntoCritico otro) {
        this(otro != null ? otro.descripcion : "Acumulación de residuos en esquina principal",
                otro != null ? otro.estadoRuta : "Pendiente",
                otro != null && otro.fechaReporte != null ? otro.fechaReporte : LocalDateTime.now(),
                otro != null && otro.lugarDeAcopio != null ? new LugarDeAcopio(otro.lugarDeAcopio) : new LugarDeAcopio());
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

    public LugarDeAcopio getLugarDeAcopio() {
        return lugarDeAcopio;
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

    public void setLugarDeAcopio(LugarDeAcopio lugarDeAcopio) {
        if (lugarDeAcopio != null) {
            this.lugarDeAcopio = lugarDeAcopio;
        } else {
            System.out.println("Error: El lugar de acopio asociado no puede ser nulo.");
        }
    }

    //Métodos de negocio
    public boolean actualizarReporte(String descripcion, String estadoRuta) {
        if (descripcion == null || descripcion.trim().isEmpty()
                || estadoRuta == null || estadoRuta.trim().isEmpty()) {
            return false;
        }
        setDescripcion(descripcion);
        setEstadoRuta(estadoRuta);
        return true;
    }

    //Sobrecarga con parámetro referencia de objeto
    public boolean actualizarReporte(ReporteDePuntoCritico nuevoReporte) {
        if (nuevoReporte == null) {
            return false;
        }
        setDescripcion(nuevoReporte.getDescripcion());
        setEstadoRuta(nuevoReporte.getEstadoRuta());
        setFechaReporte(nuevoReporte.getFechaReporte());
        setLugarDeAcopio(nuevoReporte.getLugarDeAcopio());
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReporteDePuntoCritico)) {
            return false;
        }
        ReporteDePuntoCritico otro = (ReporteDePuntoCritico) obj;
        return Objects.equals(this.descripcion, otro.descripcion)
                && Objects.equals(this.fechaReporte, otro.fechaReporte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descripcion, fechaReporte);
    }

    @Override
    public String toString() {
        return "Datos del Reporte de Punto Crítico: " +
                "\n- Descripción: " + descripcion +
                "\n- Estado de Ruta: " + estadoRuta +
                "\n- Fecha de Reporte: " + fechaReporte +
                "\n- Lugar de Acopio Asociado: " + lugarDeAcopio.getNombrePunto() +
                " (" + lugarDeAcopio.getUbicacionGPS() + ")";
    }
}