package Dominio;

import java.util.Objects;

public class GuiaDeReciclaje {

    private int idDeGuia;
    private String categoria;
    private String tituloEInstrucciones;

    //sin parametros
    public GuiaDeReciclaje() {
        this(1, "Plástico", "Reciclaje de botellas PET: Enjuagar, aplastar y retirar la tapa.");
    }

    //constructor parametrizado
    public GuiaDeReciclaje(int idDeGuia, String categoria, String tituloEInstrucciones) {
        this.idDeGuia = 1;
        this.categoria = "Plástico";
        this.tituloEInstrucciones = "Reciclaje de botellas PET: Enjuagar, aplastar y retirar la tapa.";

        setIdDeGuia(idDeGuia);
        setCategoria(categoria); // Utiliza el setter para validar la regla de negocio
        setTituloEInstrucciones(tituloEInstrucciones);
    }

    //Constructor copia (sobrecarga con parámetro referencia y this)
    public GuiaDeReciclaje(GuiaDeReciclaje otra) {
        this(otra != null ? otra.idDeGuia : 1,
                otra != null ? otra.categoria : "Plástico",
                otra != null ? otra.tituloEInstrucciones : "Reciclaje de botellas PET: Enjuagar, aplastar y retirar la tapa.");
    }

    //Get
    public int getIdDeGuia() {
        return idDeGuia;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getTituloEInstrucciones() {
        return tituloEInstrucciones;
    }

    //Set
    public void setIdDeGuia(int idDeGuia) {
        if (idDeGuia > 0) {
            this.idDeGuia = idDeGuia;
        } else {
            System.out.println("Error: El ID de la guía debe ser mayor a 0.");
        }
    }

    public void setCategoria(String categoria) {
        //Validación interna
        if (categoria != null && (categoria.equals("Plástico") || categoria.equals("Vidrio") ||
                categoria.equals("Papel") || categoria.equals("Orgánico"))) {
            this.categoria = categoria;
        } else {
            System.out.println("Error: Categoría no válida. Se asignó 'Sin clasificar'.");
            this.categoria = "Sin clasificar";
        }
    }

    public void setTituloEInstrucciones(String tituloEInstrucciones) {
        if (tituloEInstrucciones != null && !tituloEInstrucciones.trim().isEmpty()) {
            this.tituloEInstrucciones = tituloEInstrucciones;
        } else {
            System.out.println("Error: El título e instrucciones no pueden estar vacíos.");
        }
    }

    //Métodos de negocio
    public boolean actualizarGuia(String categoria, String tituloEInstrucciones) {
        if (tituloEInstrucciones == null || tituloEInstrucciones.trim().isEmpty()) {
            return false;
        }
        setCategoria(categoria);
        setTituloEInstrucciones(tituloEInstrucciones);
        return true;
    }

    //Sobrecarga con parámetro referencia de objeto
    public boolean actualizarGuia(GuiaDeReciclaje nuevaGuia) {
        if (nuevaGuia == null) {
            return false;
        }
        setCategoria(nuevaGuia.getCategoria());
        setTituloEInstrucciones(nuevaGuia.getTituloEInstrucciones());
        return true;
    }

    public boolean perteneceACategoria(String categoria) {
        return this.categoria != null && categoria != null
                && this.categoria.equalsIgnoreCase(categoria.trim());
    }

    //Sobrecarga con parámetro referencia de objeto
    public boolean perteneceACategoria(GuiaDeReciclaje otraGuia) {
        if (otraGuia == null) {
            return false;
        }
        return perteneceACategoria(otraGuia.getCategoria());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GuiaDeReciclaje)) {
            return false;
        }
        GuiaDeReciclaje otra = (GuiaDeReciclaje) obj;
        return this.idDeGuia == otra.idDeGuia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDeGuia);
    }

    @Override
    public String toString() {
        return "Datos de la Guía de Reciclaje: " +
                "\n- ID Guía: " + idDeGuia +
                "\n- Categoría: " + categoria +
                "\n- Título e Instrucciones: " + tituloEInstrucciones;
    }
}