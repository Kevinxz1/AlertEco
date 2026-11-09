package Dominio;
import java.time.LocalDateTime;

public class ReporteNovedad {
    private String descripcion;
    private String estadoRuta;
    private LocalDateTime fechaReporte;

    public ReporteNovedad(){

    }

    public ReporteNovedad(String descripcion, String estadoRuta, LocalDateTime fechaReporte) {
        this.descripcion = descripcion;
        this.estadoRuta = estadoRuta;
        this.fechaReporte = fechaReporte;
    }

    //Get
    public String getDescripcion(){
        return descripcion;
    }
    public String getEstadoRuta(){
        return estadoRuta;
    }
    public LocalDateTime getFechaReporte(){
        return fechaReporte;
    }
    //Setters
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public void setEstadoRuta(String estadoRuta){
        this.estadoRuta = estadoRuta;
    }

    public void setFechaReporte(LocalDateTime fechaReporte){
        this.fechaReporte = fechaReporte;
    }

    @Override
    public String toString() {
        return "Reporte Novedad: " + descripcion + " | Estado: " + estadoRuta;
    }
}