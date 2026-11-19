package test;

import Dominio.LugarDeAcopio;

public class TestLugarDeAcopio {
    public void probarLugarDeAcopio() {
        LugarDeAcopio lugar = new LugarDeAcopio(
                "-0.180653, -78.467834",
                "Centro Norte - Av. America",
                "Activo"
        );

        System.out.println("EST LUGAR DE ACOPIO");
        System.out.println("Nombre del punto: " + lugar.getNombrePunto());
        System.out.println("Ubicación GPS: " + lugar.getUbicacionGPS());
        System.out.println("Estado del contenedor: " + lugar.getEstadoContenedor());

        lugar.setEstadoContenedor("Lleno");
        System.out.println("\n  Datos actualizados: " + lugar.toString());
        System.out.println("----------------------------");
    }
}