package Dominio;

import java.util.Arrays;
import java.util.Objects;

public class Recolector extends Usuario {

    private EntregaDeReciclaje[] entregasValidadas;

    //sin parametros
    public Recolector() {
        this(new EntregaDeReciclaje[0]);
    }

    //constructor parametrizado
    public Recolector(EntregaDeReciclaje[] entregasValidadas) {
        super();
        this.entregasValidadas = new EntregaDeReciclaje[0];
        setEntregasValidadas(entregasValidadas);
    }

    //Constructor con los datos heredados de Usuario (sobrecarga con this)
    public Recolector(int idUsuario, String nombresYApellidos, String correoElectronico,
                      String telefonoDeContacto, String sectorDireccion, String contrasena,
                      String estadoDeLaCuenta) {
        this(idUsuario, nombresYApellidos, correoElectronico, telefonoDeContacto,
                sectorDireccion, contrasena, estadoDeLaCuenta, new EntregaDeReciclaje[0]);
    }

    public Recolector(int idUsuario, String nombresYApellidos, String correoElectronico,
                      String telefonoDeContacto, String sectorDireccion, String contrasena,
                      String estadoDeLaCuenta, EntregaDeReciclaje[] entregasValidadas) {
        super(idUsuario, nombresYApellidos, correoElectronico, telefonoDeContacto,
                sectorDireccion, contrasena, estadoDeLaCuenta);
        this.entregasValidadas = new EntregaDeReciclaje[0];
        setEntregasValidadas(entregasValidadas);
    }

    //Constructor copia (sobrecarga con parámetro referencia y this)
    public Recolector(Recolector otro) {
        this(otro != null ? otro.getIdUsuario() : 1,
                otro != null ? otro.getNombresYApellidos() : "Kevin Galeas",
                otro != null ? otro.getCorreoElectronico() : "kevin@gmail.com",
                otro != null ? otro.getTelefonoDeContacto() : "0999999999",
                otro != null ? otro.getSectorDireccion() : "Centro Norte",
                otro != null ? otro.getContrasena() : "12345678",
                otro != null ? otro.getEstadoDeLaCuenta() : "Activo",
                otro != null ? Arrays.copyOf(otro.entregasValidadas, otro.entregasValidadas.length) : new EntregaDeReciclaje[0]);
    }

    //Get
    public EntregaDeReciclaje[] getEntregasValidadas() {
        return entregasValidadas;
    }

    //Set
    public void setEntregasValidadas(EntregaDeReciclaje[] entregasValidadas) {
        //Validación interna
        if (entregasValidadas != null) {
            this.entregasValidadas = entregasValidadas;
        } else {
            System.out.println("Error: La lista de entregas validadas no puede ser nula.");
        }
    }

    //Métodos de negocio

    //CRUD, entregas Validadas (Relación de Agregación)
    public boolean crearEntregaValidada(EntregaDeReciclaje entrega) {
        if (entrega == null || buscarEntregaValidada(entrega) != null) {
            return false;
        }
        EntregaDeReciclaje[] nuevoArreglo = Arrays.copyOf(entregasValidadas, entregasValidadas.length + 1);
        nuevoArreglo[entregasValidadas.length] = entrega;
        this.entregasValidadas = nuevoArreglo;
        return true;
    }

    public String consultarEntregasValidadas() {
        if (entregasValidadas.length == 0) {
            return "No existen entregas validadas registradas.";
        }
        StringBuilder sb = new StringBuilder("Entregas validadas:");
        for (int i = 0; i < entregasValidadas.length; i++) {
            sb.append("\n[").append(i).append("] ").append(entregasValidadas[i]);
        }
        return sb.toString();
    }

    public EntregaDeReciclaje buscarEntregaValidada(EntregaDeReciclaje entrega) {
        if (entrega == null) {
            return null;
        }
        for (EntregaDeReciclaje actual : entregasValidadas) {
            if (actual != null && actual.equals(entrega)) {
                return actual;
            }
        }
        return null;
    }

    public EntregaDeReciclaje buscarEntregaValidada(int indice) {
        if (indice < 0 || indice >= entregasValidadas.length) {
            return null;
        }
        return entregasValidadas[indice];
    }

    public boolean editarEntregaValidada(int indice, EntregaDeReciclaje nuevaEntrega) {
        if (indice < 0 || indice >= entregasValidadas.length || nuevaEntrega == null) {
            return false;
        }
        for (int i = 0; i < entregasValidadas.length; i++) {
            if (i != indice && entregasValidadas[i] != null && entregasValidadas[i].equals(nuevaEntrega)) {
                return false;
            }
        }
        entregasValidadas[indice] = nuevaEntrega;
        return true;
    }

    public boolean editarEntregaValidada(EntregaDeReciclaje actual, EntregaDeReciclaje nuevaEntrega) {
        if (actual == null || nuevaEntrega == null) {
            return false;
        }
        for (int i = 0; i < entregasValidadas.length; i++) {
            if (entregasValidadas[i] != null && entregasValidadas[i].equals(actual)) {
                return editarEntregaValidada(i, nuevaEntrega);
            }
        }
        return false;
    }

    public boolean eliminarEntregaValidada(int indice) {
        if (indice < 0 || indice >= entregasValidadas.length) {
            return false;
        }
        EntregaDeReciclaje[] nuevoArreglo = new EntregaDeReciclaje[entregasValidadas.length - 1];
        for (int i = 0, j = 0; i < entregasValidadas.length; i++) {
            if (i != indice) {
                nuevoArreglo[j++] = entregasValidadas[i];
            }
        }
        this.entregasValidadas = nuevoArreglo;
        return true;
    }

    public boolean eliminarEntregaValidada(EntregaDeReciclaje entrega) {
        if (entrega == null) {
            return false;
        }
        for (int i = 0; i < entregasValidadas.length; i++) {
            if (entregasValidadas[i] != null && entregasValidadas[i].equals(entrega)) {
                return eliminarEntregaValidada(i);
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Recolector)) {
            return false;
        }
        Recolector otro = (Recolector) obj;
        return super.equals(otro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Recolector.class);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n- Rol: Recolector" +
                "\n- Entregas Validadas: " + Arrays.toString(entregasValidadas);
    }
}