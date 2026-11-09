package Dominio;

public class PuntoReciclaje {
    private String ubicacionGPS;
    private String nombrePunto;
    private String estadoContenedor;

    public PuntoReciclaje(){

    }

    public PuntoReciclaje(String ubicacionGPS, String nombrePunto, String estadoContenedor) {
        this.ubicacionGPS = ubicacionGPS;
        this.nombrePunto = nombrePunto;
        this.estadoContenedor = estadoContenedor;
    }

    // Getters
    public String getUbicacionGPS(){
        return ubicacionGPS;
    }
    public String getNombrePunto(){
        return nombrePunto;
    }
    public String getEstadoContenedor(){
        return estadoContenedor;
    }
    //Setters
    public void setUbicacionGPS(String ubicacionGPS){
        this.ubicacionGPS = ubicacionGPS;
    }
    public void setNombrePunto(String nombrePunto){
        this.nombrePunto = nombrePunto;
    }
    public void setEstadoContenedor(String estadoContenedor){
        this.estadoContenedor = estadoContenedor;
    }

    @Override
    public String toString() {
        return "Punto: " + nombrePunto + " | estado: " + estadoContenedor;
    }
}