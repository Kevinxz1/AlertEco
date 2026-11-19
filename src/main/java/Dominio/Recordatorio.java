package Dominio;

import java.time.LocalDateTime;
import java.util.Objects;

public class Recordatorio {

    private int numero;
    private String tituloRecordatorio;
    private String categoria;
    private LocalDateTime fechaHora;
    private String frecuencia;

    //sin parametros
    public Recordatorio() {
        this(1, "Sacar residuos reciclables", "Reciclaje", LocalDateTime.now(), "Semanal");
    }

    //constructor parametrizado
    public Recordatorio(int numero, String tituloRecordatorio, String categoria,
                        LocalDateTime fechaHora, String frecuencia) {
        this.numero = 1;
        this.tituloRecordatorio = "Sacar residuos reciclables";
        this.categoria = "Reciclaje";
        this.fechaHora = LocalDateTime.now();
        this.frecuencia = "Semanal";

        setNumero(numero);
        setTituloRecordatorio(tituloRecordatorio);
        setCategoria(categoria);
        setFechaHora(fechaHora);
        setFrecuencia(frecuencia);
    }

    //Constructor copia (sobrecarga con parámetro referencia y this)
    public Recordatorio(Recordatorio otro) {
        this(otro != null ? otro.numero : 1,
                otro != null ? otro.tituloRecordatorio : "Sacar residuos reciclables",
                otro != null ? otro.categoria : "Reciclaje",
                otro != null && otro.fechaHora != null ? otro.fechaHora : LocalDateTime.now(),
                otro != null ? otro.frecuencia : "Semanal");
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

    //Métodos de negocio
    public boolean actualizarRecordatorio(String tituloRecordatorio, String categoria, String frecuencia) {
        if (tituloRecordatorio == null || tituloRecordatorio.trim().isEmpty()
                || categoria == null || categoria.trim().isEmpty()
                || frecuencia == null || frecuencia.trim().isEmpty()) {
            return false;
        }
        setTituloRecordatorio(tituloRecordatorio);
        setCategoria(categoria);
        setFrecuencia(frecuencia);
        return true;
    }

    //Sobrecarga con parámetro referencia de objeto
    public boolean actualizarRecordatorio(Recordatorio nuevoRecordatorio) {
        if (nuevoRecordatorio == null) {
            return false;
        }
        setTituloRecordatorio(nuevoRecordatorio.getTituloRecordatorio());
        setCategoria(nuevoRecordatorio.getCategoria());
        setFechaHora(nuevoRecordatorio.getFechaHora());
        setFrecuencia(nuevoRecordatorio.getFrecuencia());
        return true;
    }

    public boolean tieneMismaFrecuencia(String frecuencia) {
        return this.frecuencia != null && frecuencia != null
                && this.frecuencia.equalsIgnoreCase(frecuencia.trim());
    }

    //Sobrecarga con parámetro referencia de objeto
    public boolean tieneMismaFrecuencia(Recordatorio otroRecordatorio) {
        if (otroRecordatorio == null) {
            return false;
        }
        return tieneMismaFrecuencia(otroRecordatorio.getFrecuencia());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Recordatorio)) {
            return false;
        }
        Recordatorio otro = (Recordatorio) obj;
        return this.numero == otro.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
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