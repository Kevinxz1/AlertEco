package Dominio;
import java.time.LocalDateTime;

public class Recordatorio {
    private int numero;
    private String tituloRecordatorio;
    private String categoria;
    private LocalDateTime fechaHora;
    private String frecuencia;

    //sin parametros
    public Recordatorio(){

    }

    public Recordatorio(int numero, String tituloRecordatorio, String categoria, LocalDateTime fechaHora, String frecuencia) {
        this.numero = numero;
        this.tituloRecordatorio = tituloRecordatorio;
        this.categoria = categoria;
        this.fechaHora = fechaHora;
        this.frecuencia = frecuencia;
    }

    //Get
    public int getNumero(){
        return numero;
    }
    public String getTituloRecordatorio(){
        return tituloRecordatorio;
    }
    public String getCategoria(){
        return categoria;
    }
    public LocalDateTime getFechaHora(){
        return fechaHora;
    }
    public String getFrecuencia(){
        return frecuencia;
    }

    //Set
    public void setNumero(int numero){
        // Validación interna
        if (numero > 0) {
            this.numero = numero;
        } else {
            System.out.println("Error: El número de recordatorio debe ser mayor a 0.");
        }
    }
    public void setTituloRecordatorio(String tituloRecordatorio){
        this.tituloRecordatorio = tituloRecordatorio;
    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    public void setFechaHora(LocalDateTime fechaHora){
        this.fechaHora = fechaHora;
    }
    public void setFrecuencia(String frecuencia){
        this.frecuencia = frecuencia;
    }

    @Override
    public String toString() {
        return "Recordatorio [" + numero + "]: " + tituloRecordatorio + " (" + categoria + ") - Frecuencia: " + frecuencia;
    }
}