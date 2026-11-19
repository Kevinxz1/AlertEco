package Dominio;

import java.time.LocalDateTime;

public class Recordatorio {

    private int numero;
    private String tituloRecordatorio;
    private String categoria;
    private LocalDateTime fechaHora;
    private String frecuencia;

    //sin parametros
    public Recordatorio() {
        this.numero = 1;
        this.tituloRecordatorio = "Sacar residuos reciclables";
        this.categoria = "Reciclaje";
        this.fechaHora = LocalDateTime.now();
        this.frecuencia = "Semanal";
    }

    //constructor parametrizado
    public Recordatorio(int numero, String tituloRecordatorio, String categoria,
                        LocalDateTime fechaHora, String frecuencia) {
        setNumero(numero);
        setTituloRecordatorio(tituloRecordatorio);
        setCategoria(categoria);
        setFechaHora(fechaHora);
        setFrecuencia(frecuencia);
    }

    //Get
    public int getNumero() {
        return numero;
    }
    public String getTituloRecordatorio() {
        return tituloRecordatorio;
    }
    public String getCategoria() {
        return categoria;
    }
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
    public String getFrecuencia() {
        return frecuencia;
    }

    //Set
    public void setNumero(int numero) {
        //Validación interna
        if (numero > 0) {
            this.numero = numero;
        } else {
            System.out.println("Error: El número de recordatorio debe ser mayor a 0.");
        }
    }
    public void setTituloRecordatorio(String tituloRecordatorio) {
        if (tituloRecordatorio != null && !tituloRecordatorio.trim().isEmpty()) {
            this.tituloRecordatorio = tituloRecordatorio;
        } else {
            System.out.println("Error: El título del recordatorio no puede estar vacío.");
        }
    }
    public void setCategoria(String categoria) {
        if (categoria != null && !categoria.trim().isEmpty()) {
            this.categoria = categoria;
        } else {
            System.out.println("Error: La categoría no puede estar vacía.");
        }
    }
    public void setFechaHora(LocalDateTime fechaHora) {
        if (fechaHora != null) {
            this.fechaHora = fechaHora;
        } else {
            System.out.println("Error: La fecha y hora no pueden ser nulas.");
        }
    }
    public void setFrecuencia(String frecuencia) {
        if (frecuencia != null && !frecuencia.trim().isEmpty()) {
            this.frecuencia = frecuencia;
        } else {
            System.out.println("Error: La frecuencia no puede estar vacía.");
        }
    }

    @Override
    public String toString() {
        return "Datos del Recordatorio: " +
                "\n- Número: " + numero +
                "\n- Título: " + tituloRecordatorio +
                "\n- Categoría: " + categoria +
                "\n- Fecha y Hora: " + fechaHora +
                "\n- Frecuencia: " + frecuencia;
    }
}