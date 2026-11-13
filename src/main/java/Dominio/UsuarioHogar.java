package Dominio;

public class UsuarioHogar extends Usuario {

    private double metaReciclajeKg;
    private double cantidadRecicladaKg;
    private boolean metaCumplida;

    public UsuarioHogar() {
        super();
    }

    public UsuarioHogar(String usuario, String nombre, String correo, String contrasenia) {
        super(usuario, nombre, correo, contrasenia);
        this.metaReciclajeKg = 10.0;
        this.cantidadRecicladaKg = 0.0;
        this.metaCumplida = false;
    }

    public UsuarioHogar(String usuario, String nombre, String correo, String contrasenia, double metaReciclajeKg) {
        super(usuario, nombre, correo, contrasenia);
        this.metaReciclajeKg = metaReciclajeKg;
        this.cantidadRecicladaKg = 0.0;
        this.metaCumplida = false;
    }

    public double getMetaReciclajeKg() {
        return metaReciclajeKg;
    }

    public double getCantidadRecicladaKg() {
        return cantidadRecicladaKg;
    }

    public boolean isMetaCumplida() {
        return metaCumplida;
    }

    public void setMetaReciclajeKg(double metaReciclajeKg) {
        if (metaReciclajeKg > 0) {
            this.metaReciclajeKg = metaReciclajeKg;
            verificarMeta();
        }
    }

    public void setCantidadRecicladaKg(double cantidadIngresada) {
        if (cantidadIngresada >= 0) {
            this.cantidadRecicladaKg = cantidadIngresada;
            verificarMeta();
        } else {
            System.out.println("Error: La cantidad reciclada no puede ser negativa.");
        }
    }
    //
    private void verificarMeta() {
        if (this.cantidadRecicladaKg >= this.metaReciclajeKg) {
            this.metaCumplida = true;
        } else {
            this.metaCumplida = false;
        }
    }
}