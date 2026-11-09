package test;

import Dominio.Recordatorio;
import java.time.LocalDateTime;

public class TestRecordatorio {
    public void probarRecordatorio() {
        System.out.println("TEST CLASE: Recordatorio");
        Recordatorio testRecordatorio = new Recordatorio(1, "Separar plásticos", "Reciclaje", LocalDateTime.now(), "Semanal");
        System.out.println("Estado inicial: " + testRecordatorio.toString());

        testRecordatorio.setFrecuencia("Diaria");
        System.out.println("Frecuencia actualizada  " + testRecordatorio.getFrecuencia());
        System.out.println("--------------------------------------------------");
    }
}