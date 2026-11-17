package test;

import Dominio.EntregaDeReciclaje;

public class TestEntregaDeReciclaje {
    public void probarEntrega() {
        EntregaDeReciclaje entrega = new EntregaDeReciclaje("2026-11-16", 15.5, "Vidrio");
        System.out.println("EST ENTREGA DE RECICLAJE");
        System.out.println(entrega.getFecha());
        System.out.println(entrega.getCantidadReciclada());
        System.out.println(entrega.getTipoDeMaterial());
        System.out.println("---------------------------------");
    }
}