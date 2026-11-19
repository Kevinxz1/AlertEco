package Dominio;

import java.util.Objects;

public class LugarDeAcopio {

    private String ubicacionGPS;
    private String nombrePunto;
    private String estadoContenedor;

    //sin parametros
    public LugarDeAcopio() {
        this("-0.180653, -78.467834", "Punto Eco Norte", "Disponible");
    }

    //constructor parametrizado
    public LugarDeAcopio(String ubicacionGPS, String nombrePunto, String estadoContenedor) {
        this.ubicacionGPS = "-0.180653, -78.467834";
        this.nombrePunto = "Punto Eco Norte";
        this.estadoContenedor = "Disponible";

        setUbicacionGPS(ubicacionGPS);
        setNombrePunto(nombrePunto);
        setEstadoContenedor(estadoContenedor);
    }

    //Constructor copia (sobrecarga con parámetro referencia y this)
    public LugarDeAcopio(LugarDeAcopio otro) {
        this(otro != null ? otro.ubicacionGPS : "-0.180653, -78.467834",
                otro != null ? otro.nombrePunto : "Punto Eco Norte",
                otro != null ? otro.estadoContenedor : "Disponible");
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

    //Métodos de negocio
    public boolean actualizarLugar(String ubicacionGPS, String nombrePunto, String estadoContenedor) {
        if (ubicacionGPS == null || ubicacionGPS.trim().isEmpty()
                || nombrePunto == null || nombrePunto.trim().isEmpty()
                || estadoContenedor == null || estadoContenedor.trim().isEmpty()) {
            return false;
        }
        setUbicacionGPS(ubicacionGPS);
        setNombrePunto(nombrePunto);
        setEstadoContenedor(estadoContenedor);
        return true;
    }

    //Sobrecarga con parámetro referencia de objeto
    public boolean actualizarLugar(LugarDeAcopio nuevoLugar) {
        if (nuevoLugar == null) {
            return false;
        }
        return actualizarLugar(nuevoLugar.getUbicacionGPS(), nuevoLugar.getNombrePunto(),
                nuevoLugar.getEstadoContenedor());
    }

    public boolean tieneMismoEstado(String estado) {
        return this.estadoContenedor != null && estado != null
                && this.estadoContenedor.equalsIgnoreCase(estado.trim());
    }

    //Sobrecarga con parámetro referencia de objeto
    public boolean tieneMismoEstado(LugarDeAcopio otroLugar) {
        if (otroLugar == null) {
            return false;
        }
        return tieneMismoEstado(otroLugar.getEstadoContenedor());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LugarDeAcopio)) {
            return false;
        }
        LugarDeAcopio otro = (LugarDeAcopio) obj;
        return Objects.equals(this.ubicacionGPS, otro.ubicacionGPS)
                && Objects.equals(this.nombrePunto, otro.nombrePunto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ubicacionGPS, nombrePunto);
    }

    @Override
    public String toString() {
        return "Datos del Lugar de Acopio: " +
                "\n- Nombre del Punto: " + nombrePunto +
                "\n- Ubicación GPS: " + ubicacionGPS +
                "\n- Estado del Contenedor: " + estadoContenedor;
    }
}