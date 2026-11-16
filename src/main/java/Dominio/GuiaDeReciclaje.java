package Dominio;


public class GuiaDeReciclaje {

    private int idDeGuia;
    private String categoria;
    private String tituloEInstrucciones;


    public GuiaDeReciclaje() {
    }

    public GuiaDeReciclaje(int idDeGuia, String categoria, String tituloEInstrucciones) {
        this.idDeGuia = idDeGuia;
        setCategoria(categoria); /* Utiliza el setter para validar la regla de negocio */
        this.tituloEInstrucciones = tituloEInstrucciones;
    }

    public int getIdDeGuia() {
        return idDeGuia;
    }

    public void setIdDeGuia(int idDeGuia) {
        this.idDeGuia = idDeGuia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (categoria != null && (categoria.equals("Plástico") || categoria.equals("Vidrio") ||
                categoria.equals("Papel") || categoria.equals("Orgánico"))) {
            this.categoria = categoria;
        } else {
            this.categoria = "Sin clasificar";
        }
    }

    public String getTituloEInstrucciones() {
        return tituloEInstrucciones;
    }

    public void setTituloEInstrucciones(String tituloEInstrucciones) {
        this.tituloEInstrucciones = tituloEInstrucciones;
    }

    @Override
    public String toString() {
        return "GuiaDeReciclaje{" +
                "idDeGuia=" + idDeGuia +
                ", categoria='" + categoria + '\'' +
                ", tituloEInstrucciones='" + tituloEInstrucciones + '\'' +
                '}';
    }
}