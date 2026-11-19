package Dominio;

import java.util.Date;

public class EntregaDeReciclaje {

    private int idEntrega;
    private String tipoDeMaterial;
    private double pesoOCantidadAproximada;
    private Date fechaDeEntrega;
    private String estado;
    private String observaciones;

    //sin parametros
    public EntregaDeReciclaje() {
        this.idEntrega = 1;
        this.tipoDeMaterial = "Plástico";
        this.pesoOCantidadAproximada = 1.5;
        this.fechaDeEntrega = new Date();
        this.estado = "Pendiente";
        this.observaciones = "Sin observaciones";
    }

    //constructor parametrizado
    public EntregaDeReciclaje(int idEntrega, String tipoDeMaterial, double pesoOCantidadAproximada,
                              Date fechaDeEntrega, String observaciones) {
        setIdEntrega(idEntrega);
        setTipoDeMaterial(tipoDeMaterial);
        setPesoOCantidadAproximada(pesoOCantidadAproximada);
        setFechaDeEntrega(fechaDeEntrega);
        this.estado = "Pendiente"; // Se inicializa como Pendiente segun caso H3.1
        this.observaciones = observaciones;
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
        this.observaciones = observaciones;
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