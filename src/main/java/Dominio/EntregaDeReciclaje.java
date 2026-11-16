package Dominio;

import java.util.Date;
public class EntregaDeReciclaje {

    private int idEntrega;
    private String tipoDeMaterial;
    private double pesoOCantidadAproximada;
    private Date fechaDeEntrega;
    private String estado;
    private String observaciones;


    public EntregaDeReciclaje() {
        this.estado = "Pendiente";
    }


    public EntregaDeReciclaje(int idEntrega, String tipoDeMaterial, double pesoOCantidadAproximada,
                              Date fechaDeEntrega, String observaciones) {
        this.idEntrega = idEntrega;
        this.tipoDeMaterial = tipoDeMaterial;
        this.pesoOCantidadAproximada = pesoOCantidadAproximada;
        this.fechaDeEntrega = fechaDeEntrega;
        this.estado = "Pendiente"; /* Se inicializa como Pendiente segun caso H3.1 */
        this.observaciones = observaciones;
    }

    public int getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(int idEntrega) {
        this.idEntrega = idEntrega;
    }

    public String getTipoDeMaterial() {
        return tipoDeMaterial;
    }

    public void setTipoDeMaterial(String tipoDeMaterial) {
        this.tipoDeMaterial = tipoDeMaterial;
    }

    public double getPesoOCantidadAproximada() {
        return pesoOCantidadAproximada;
    }

    public void setPesoOCantidadAproximada(double pesoOCantidadAproximada) {
        this.pesoOCantidadAproximada = pesoOCantidadAproximada;
    }

    public Date getFechaDeEntrega() {
        return fechaDeEntrega;
    }

    public void setFechaDeEntrega(Date fechaDeEntrega) {
        this.fechaDeEntrega = fechaDeEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "EntregaDeReciclaje{" +
                "idEntrega=" + idEntrega +
                ", tipoDeMaterial='" + tipoDeMaterial + '\'' +
                ", pesoOCantidadAproximada=" + pesoOCantidadAproximada +
                ", fechaDeEntrega=" + fechaDeEntrega +
                ", estado='" + estado + '\'' +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
}