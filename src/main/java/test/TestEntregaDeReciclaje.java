package test;

import Dominio.EntregaDeReciclaje;
import java.util.Date;

public class TestEntregaDeReciclaje {
    public void probarEntrega() {
        EntregaDeReciclaje entrega = new EntregaDeReciclaje(
                1,
                "Vidrio",
                15.5,
                new Date(),
                "Botellas limpias y separadas"
        );

        System.out.println(" TEST ENTREGA DE RECICLAJE");
        System.out.println("ID: " + entrega.getIdEntrega());
        System.out.println("Material: " + entrega.getTipoDeMaterial());
        System.out.println("Peso/Cantidad: " + entrega.getPesoOCantidadAproximada());
        System.out.println("Fecha: " + entrega.getFechaDeEntrega());
        System.out.println("Estado inicial: " + entrega.getEstado());
        System.out.println("Observaciones: " + entrega.getObservaciones());

        entrega.setEstado("Validada");
        System.out.println("\nEstado actualizado:\n" + entrega.toString());
        System.out.println("---------------------------------");
    }
}