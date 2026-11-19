package test;

import Dominio.Recordatorio;
import java.time.LocalDateTime;

public class TestRecordatorio {
    public void probarRecordatorio() {
        Recordatorio recordatorio = new Recordatorio(
                1,
                "Recoleccion de Plasticos",
                "Plástico",
                LocalDateTime.of(2026, 11, 20, 8, 30),
                "Semanal"
        );

        System.out.println("teest recordatorio");
        System.out.println("Número: " + recordatorio.getNumero());
        System.out.println("Título: " + recordatorio.getTituloRecordatorio());
        System.out.println("Categoría: " + recordatorio.getCategoria());
        System.out.println("Fecha y hora: " + recordatorio.getFechaHora());
        System.out.println("Frecuencia: " + recordatorio.getFrecuencia());

        recordatorio.setFrecuencia("Quincenal");
        System.out.println("\nRecordatorio actualizado:\n" + recordatorio.toString());
        System.out.println("-------------------------");
    }
}