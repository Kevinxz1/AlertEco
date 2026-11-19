package Dominio;

public class GuiaDeReciclaje {

    private int idDeGuia;
    private String categoria;
    private String tituloEInstrucciones;

    //sin parametros
    public GuiaDeReciclaje() {
        this.idDeGuia = 1;
        this.categoria = "Plástico";
        this.tituloEInstrucciones = "Reciclaje de botellas PET: Enjuagar, aplastar y retirar la tapa.";
    }

    //constructor parametrizado
    public GuiaDeReciclaje(int idDeGuia, String categoria, String tituloEInstrucciones) {
        setIdDeGuia(idDeGuia);
        setCategoria(categoria); // Utiliza el setter para validar la regla de negocio
        setTituloEInstrucciones(tituloEInstrucciones);
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

    @Override
    public String toString() {
        return "Datos de la Guía de Reciclaje: " +
                "\n- ID Guía: " + idDeGuia +
                "\n- Categoría: " + categoria +
                "\n- Título e Instrucciones: " + tituloEInstrucciones;
    }
}