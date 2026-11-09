package Dominio;

public class PuntoReciclaje {
    private String ubicacionGPS;
    private String nombrePunto;
    private String estadoContenedor;

    //sin parametros
    public PuntoReciclaje(){

    }

    public PuntoReciclaje(String ubicacionGPS, String nombrePunto, String estadoContenedor) {
        this.ubicacionGPS = ubicacionGPS;
        this.nombrePunto = nombrePunto;
        this.estadoContenedor = estadoContenedor;
    }

    //Get
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
        //Validación interna
        if (estadoContenedor != null && !estadoContenedor.trim().isEmpty()) {
            this.estadoContenedor = estadoContenedor;
        } else {
            System.out.println("Error: El estado del contenedor no puede estar vacío.");
        }
    }

    @Override
    public String toString() {
        return "Punto: " + nombrePunto + " | Estado: " + estadoContenedor;
    }
}