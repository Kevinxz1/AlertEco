package Dominio;

public class PerfilHogar {
    private String direccionDomiciliaria;
    private String telefono;

    public PerfilHogar(){

    }

    public PerfilHogar(String direccionDomiciliaria, String telefono){
        this.direccionDomiciliaria = direccionDomiciliaria;
        this.telefono = telefono;
    }

    // Getters
    public String getDireccionDomiciliaria(){
        return direccionDomiciliaria;
    }
    public String getTelefono(){
        return telefono;
    }
    //Setters
    public void setDireccionDomiciliaria(String direccionDomiciliaria){
        this.direccionDomiciliaria = direccionDomiciliaria;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "PerfilHogar: Dirección=" + direccionDomiciliaria + ", Teléfono=" + telefono;
    }
}