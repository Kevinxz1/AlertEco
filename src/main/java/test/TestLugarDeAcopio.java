package test;

import Dominio.LugarDeAcopio;

public class TestLugarDeAcopio {
    public void probarLugarDeAcopio() {
        LugarDeAcopio lugar = new LugarDeAcopio("Centro Norte", "Av. America", "08:00 - 17:00", "Activo");
        System.out.println("TEST LUGAR DE ACOPIO");
        System.out.println(lugar.getNombre());
        System.out.println(lugar.getDireccion());
        System.out.println(lugar.getHorario());
        System.out.println(lugar.getEstado());
        System.out.println("----------------------------");
    }
}