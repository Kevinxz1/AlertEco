package test;
import Dominio.PuntoReciclaje;

public class TestPuntoReciclaje {
    public void probarPuntoReciclaje() {
        System.out.println("TEST CLASE: PuntoReciclaje");
        PuntoReciclaje testPunto = new PuntoReciclaje("Lat:-0.19, Lng:-78.49", "Contenedor Parque Bicentenario", "Activo - Medio Lleno");
        System.out.println("Estado inicial: " + testPunto.toString());

        testPunto.setEstadoContenedor("Activo - Lleno");
        System.out.println("Estado de contenedor actualizado : " + testPunto.getEstadoContenedor());
        System.out.println("--------------------------------------------------");
    }
}