package test;
import Dominio.RutaRecoleccion;

public class TestRutaRecoleccion {
    public void probarRutaRecoleccion() {
        System.out.println("TEST CLASE: RutaRecoleccion");
        RutaRecoleccion testRuta = new RutaRecoleccion(101, "Sector Norte", "Lat:-0.18, Lng:-78.48", "Lunes y Jueves", "08:00 AM");
        System.out.println("Estado inicial: " + testRuta.toString());

        testRuta.setHoraEstimada("10:30 AM");
        System.out.println("Hora actualizada: " + testRuta.getHoraEstimada());
        System.out.println("--------------------------------------------------");
    }
}