package Dominio;

import java.util.Arrays;

public class Recolector extends Usuario {

    private EntregaDeReciclaje[] entregasValidadas;

    //sin parametros
    public Recolector() {
        super();
        this.entregasValidadas = new EntregaDeReciclaje[0];
    }

    //constructor parametrizado
    public Recolector(EntregaDeReciclaje[] entregasValidadas) {
        super();
        setEntregasValidadas(entregasValidadas);
    }

    public Recolector(int idUsuario, String nombresYApellidos, String correoElectronico,
                      String telefonoDeContacto, String sectorDireccion, String contrasena,
                      String estadoDeLaCuenta, EntregaDeReciclaje[] entregasValidadas) {
        super(idUsuario, nombresYApellidos, correoElectronico, telefonoDeContacto,
                sectorDireccion, contrasena, estadoDeLaCuenta);
        setEntregasValidadas(entregasValidadas);
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

    @Override
    public String toString() {
        return super.toString() +
                "\n- Rol: Recolector" +
                "\n- Entregas Validadas: " + Arrays.toString(entregasValidadas);
    }
}