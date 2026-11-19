package Dominio;

public class LugarDeAcopio {

    private String ubicacionGPS;
    private String nombrePunto;
    private String estadoContenedor;

    //sin parametros
    public LugarDeAcopio() {
        this.ubicacionGPS = "-0.180653, -78.467834";
        this.nombrePunto = "Punto Eco Norte";
        this.estadoContenedor = "Disponible";
    }

    //constructor parametrizado
    public LugarDeAcopio(String ubicacionGPS, String nombrePunto, String estadoContenedor) {
        setUbicacionGPS(ubicacionGPS);
        setNombrePunto(nombrePunto);
        setEstadoContenedor(estadoContenedor);
    }

    //Get
    public String getUbicacionGPS() {
        return ubicacionGPS;
    }
    public String getNombrePunto() {
        return nombrePunto;
    }
    public String getEstadoContenedor() {
        return estadoContenedor;
    }

    //Set
    public void setUbicacionGPS(String ubicacionGPS) {
        if (ubicacionGPS != null && !ubicacionGPS.trim().isEmpty()) {
            this.ubicacionGPS = ubicacionGPS;
        } else {
            System.out.println("Error: La ubicación GPS no puede estar vacía.");
        }
    }
    public void setNombrePunto(String nombrePunto) {
        if (nombrePunto != null && !nombrePunto.trim().isEmpty()) {
            this.nombrePunto = nombrePunto;
        } else {
            System.out.println("Error: El nombre del punto no puede estar vacío.");
        }
    }
    public void setEstadoContenedor(String estadoContenedor) {
        //Validación interna
        if (estadoContenedor != null && !estadoContenedor.trim().isEmpty()) {
            this.estadoContenedor = estadoContenedor;
        } else {
            System.out.println("Error: El estado del contenedor no puede estar vacío.");
        }
    }

    @Override
    public String toString() {
        return "Datos del Lugar de Acopio: " +
                "\n- Nombre del Punto: " + nombrePunto +
                "\n- Ubicación GPS: " + ubicacionGPS +
                "\n- Estado del Contenedor: " + estadoContenedor;
    }
}