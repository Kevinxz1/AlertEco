package test;

import Dominio.Recolector;

public class TestRecolector {
    public void probarRecolector() {
        Recolector recolector = new Recolector("Luis Hamilton", "luis@recolector.com", "rec123", "REC-001", "Ruta Sur");
        System.out.println("TEST RECOLECTOR");
        System.out.println(recolector.getNombre());
        System.out.println(recolector.getCorreo());
        System.out.println(recolector.getIdRecolector());
        System.out.println(recolector.getRutaAsignada());
        System.out.println("-----------------------");
    }
}