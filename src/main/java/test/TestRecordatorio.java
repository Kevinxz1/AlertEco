package test;

import Dominio.Recordatorio;

public class TestRecordatorio {
    public void probarRecordatorio() {
        Recordatorio recordatorio = new Recordatorio("Recoleccion de Plasticos", "2026-11-20", "08:30");
        System.out.println("--- TEST RECORDATORIO ---");
        System.out.println(recordatorio.getMensaje());
        System.out.println(recordatorio.getFecha());
        System.out.println(recordatorio.getHora());
        System.out.println("-------------------------");
    }
}