package test;

import Dominio.EntregaDeReciclaje;
import Dominio.Recolector;
import java.util.Date;

public class TestRecolector {
    public void probarRecolector() {
        EntregaDeReciclaje[] entregas = {
                new EntregaDeReciclaje(1, "Cartón", 10.0, new Date(), "Entregado en Ruta Sur")
        };

        Recolector recolector = new Recolector(
                101,
                "Luis Hamilton",
                "luis@recolector.com",
                "0987654321",
                "Ruta Sur",
                "rec12345",
                "Activo",
                entregas
        );

        System.out.println("TET RECOLECTOR");
        System.out.println("ID: " + recolector.getIdUsuario());
        System.out.println("Nombre: " + recolector.getNombresYApellidos());
        System.out.println("Correo: " + recolector.getCorreoElectronico());
        System.out.println("Teléfono: " + recolector.getTelefonoDeContacto());
        System.out.println("Sector/Ruta: " + recolector.getSectorDireccion());
        System.out.println("Estado cuenta: " + recolector.getEstadoDeLaCuenta());
        System.out.println("Total entregas validadas: " + recolector.getEntregasValidadas().length);
        System.out.println("Credenciales válidas: " + recolector.validarCredenciales("luis@recolector.com", "rec12345"));

        System.out.println("\nDetalle completo: " + recolector.toString());
        System.out.println("-----------------------");
    }
}