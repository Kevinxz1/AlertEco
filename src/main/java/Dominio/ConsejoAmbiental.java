package Dominio;

public class ConsejoAmbiental {
    private String titulo;
    private String descripcion;
    private String categoria;

    public ConsejoAmbiental()
    {

    }

    public ConsejoAmbiental(String titulo, String descripcion, String categoria) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    //Getters
    public String getTitulo(){
        return titulo;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public String getCategoria(){
        return categoria;
    }
    //Setters
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Consejo [" + categoria + "]: " + titulo;
    }
}