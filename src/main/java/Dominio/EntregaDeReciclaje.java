package Dominio;

import java.util.Date;
import java.util.Objects;

public class EntregaDeReciclaje {

    private int idEntrega;
    private String tipoDeMaterial;
    private double pesoOCantidadAproximada;
    private Date fechaDeEntrega;
    private String estado;
    private String observaciones;

    //sin parametros
    public EntregaDeReciclaje() {
        this(1, "Plástico", 1.5, new Date(), "Pendiente", "Sin observaciones");
    }

    //constructor parametrizado
    public EntregaDeReciclaje(int idEntrega, String tipoDeMaterial, double pesoOCantidadAproximada,
                              Date fechaDeEntrega, String observaciones) {
        this(idEntrega, tipoDeMaterial, pesoOCantidadAproximada, fechaDeEntrega, "Pendiente", observaciones);
    }

    //Sobrecarga de constructor completo (incluye estado)
    public EntregaDeReciclaje(int idEntrega, String tipoDeMaterial, double pesoOCantidadAproximada,
                              Date fechaDeEntrega, String estado, String observaciones) {
        // Valores seguros por defecto en caso de recibir algún dato inválido
        this.idEntrega = 1;
        this.tipoDeMaterial = "Plástico";
        this.pesoOCantidadAproximada = 1.5;
        this.fechaDeEntrega = new Date();
        this.estado = "Pendiente";
        this.observaciones = "Sin observaciones";

        setIdEntrega(idEntrega);
        setTipoDeMaterial(tipoDeMaterial);
        setPesoOCantidadAproximada(pesoOCantidadAproximada);
        setFechaDeEntrega(fechaDeEntrega);
        setEstado(estado);
        setObservaciones(observaciones);
    }

    //Constructor copia (sobrecarga con parámetro referencia y this)
    public EntregaDeReciclaje(EntregaDeReciclaje otra) {
        this(otra != null ? otra.idEntrega : 1,
                otra != null ? otra.tipoDeMaterial : "Plástico",
                otra != null ? otra.pesoOCantidadAproximada : 1.5,
                otra != null && otra.fechaDeEntrega != null ? new Date(otra.fechaDeEntrega.getTime()) : new Date(),
                otra != null ? otra.estado : "Pendiente",
                otra != null ? otra.observaciones : "Sin observaciones");
    }

    //Get
    public int getIdEntrega() {
        return idEntrega;
    }

    public String getTipoDeMaterial() {
        return tipoDeMaterial;
    }

    public double getPesoOCantidadAproximada() {
        return pesoOCantidadAproximada;
    }

    public Date getFechaDeEntrega() {
        return fechaDeEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    //Set
    public void setIdEntrega(int idEntrega) {
        if (idEntrega > 0) {
            this.idEntrega = idEntrega;
        } else {
            System.out.println("Error: El ID de la entrega debe ser mayor a 0.");
        }
    }

    public void setTipoDeMaterial(String tipoDeMaterial) {
        if (tipoDeMaterial != null && !tipoDeMaterial.trim().isEmpty()) {
            this.tipoDeMaterial = tipoDeMaterial;
        } else {
            System.out.println("Error: El tipo de material no puede estar vacío.");
        }
    }

    public void setPesoOCantidadAproximada(double pesoOCantidadAproximada) {
        //Validación interna
        if (pesoOCantidadAproximada > 0) {
            this.pesoOCantidadAproximada = pesoOCantidadAproximada;
        } else {
            System.out.println("Error: El peso o cantidad aproximada debe ser mayor a 0.");
        }
    }

    public void setFechaDeEntrega(Date fechaDeEntrega) {
        if (fechaDeEntrega != null) {
            this.fechaDeEntrega = fechaDeEntrega;
        } else {
            System.out.println("Error: La fecha de entrega no puede ser nula.");
        }
    }

    public void setEstado(String estado) {
        if (estado != null && !estado.trim().isEmpty()) {
            this.estado = estado;
        } else {
            System.out.println("Error: El estado no puede estar vacío.");
        }
    }

    public void setObservaciones(String observaciones) {
        if (observaciones != null && !observaciones.trim().isEmpty()) {
            this.observaciones = observaciones;
        } else {
            System.out.println("Error: Las observaciones no pueden estar vacías.");
        }
    }

    //Métodos de negocio
    public boolean actualizarEntrega(String tipoDeMaterial, double pesoOCantidadAproximada, String observaciones) {
        if (tipoDeMaterial == null || tipoDeMaterial.trim().isEmpty() || pesoOCantidadAproximada <= 0) {
            return false;
        }
        setTipoDeMaterial(tipoDeMaterial);
        setPesoOCantidadAproximada(pesoOCantidadAproximada);
        setObservaciones(observaciones);
        return true;
    }

    //Sobrecarga con parámetro referencia de objeto
    public boolean actualizarEntrega(EntregaDeReciclaje nuevaEntrega) {
        if (nuevaEntrega == null) {
            return false;
        }
        setTipoDeMaterial(nuevaEntrega.getTipoDeMaterial());
        setPesoOCantidadAproximada(nuevaEntrega.getPesoOCantidadAproximada());
        setFechaDeEntrega(nuevaEntrega.getFechaDeEntrega());
        setEstado(nuevaEntrega.getEstado());
        setObservaciones(nuevaEntrega.getObservaciones());
        return true;
    }

    public boolean tieneMismoMaterial(String tipoDeMaterial) {
        return this.tipoDeMaterial != null && tipoDeMaterial != null
                && this.tipoDeMaterial.equalsIgnoreCase(tipoDeMaterial.trim());
    }

    //Sobrecarga con parámetro referencia de objeto
    public boolean tieneMismoMaterial(EntregaDeReciclaje otraEntrega) {
        if (otraEntrega == null) {
            return false;
        }
        return tieneMismoMaterial(otraEntrega.getTipoDeMaterial());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EntregaDeReciclaje)) {
            return false;
        }
        EntregaDeReciclaje otra = (EntregaDeReciclaje) obj;
        return this.idEntrega == otra.idEntrega;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEntrega);
    }

    @Override
    public String toString() {
        return "Datos de la Entrega de Reciclaje: " +
                "\n- ID Entrega: " + idEntrega +
                "\n- Tipo de Material: " + tipoDeMaterial +
                "\n- Peso / Cantidad Aproximada: " + pesoOCantidadAproximada +
                "\n- Fecha de Entrega: " + fechaDeEntrega +
                "\n- Estado: " + estado +
                "\n- Observaciones: " + observaciones;
    }
}