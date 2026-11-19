package test;

import Dominio.GuiaDeReciclaje;

public class TestGuiaDeReciclaje {

    public void probarGuiaDeReciclaje() {
        System.out.println("TEST GUÍA DE RECICLAJE");

        //sin parámetros, parametrizado y copia por referencia
        GuiaDeReciclaje guiaDefecto = new GuiaDeReciclaje();
        GuiaDeReciclaje guiaVidrio = new GuiaDeReciclaje(2, "Vidrio", "Separar botellas sin tapa.");
        GuiaDeReciclaje guiaCopia = new GuiaDeReciclaje(guiaVidrio);

        System.out.println("Guía por defecto:\n" + guiaDefecto);
        System.out.println("\nGuía parametrizada:\n" + guiaVidrio);
        System.out.println("\nGuía copia:\n" + guiaCopia);

        //alidación de regla de negocio en categoría
        System.out.println("VALIDACIÓN DE CATEGORÍA INVÁLIDA");
        guiaDefecto.setCategoria("Metal");
        System.out.println("Categoría tras dato inválido (esperado 'Sin clasificar'): " + guiaDefecto.getCategoria());

        //Sobrecarga de métodos con parámetro referencia
        System.out.println("SOBRECARGA DE MÉTODOS CON REFERENCIA");
        System.out.println("¿Pertenece a 'Vidrio' (String)?: " + guiaVidrio.perteneceACategoria("Vidrio"));
        System.out.println("¿Misma categoría que guiaCopia (referencia)?: " + guiaVidrio.perteneceACategoria(guiaCopia));
        guiaDefecto.actualizarGuia(guiaVidrio);
        System.out.println("guiaDefecto actualizada por referencia:\n" + guiaDefecto);

        //equals() y hashCode()
        System.out.println("EQUALS Y HASHCODE");
        System.out.println("¿guiaVidrio.equals(guiaCopia)? (esperado true): " + guiaVidrio.equals(guiaCopia));
        System.out.println("¿guiaDefecto.equals(guiaVidrio)? (esperado false): " + guiaDefecto.equals(guiaVidrio));
        System.out.println("hashCode guiaVidrio: " + guiaVidrio.hashCode() + " | hashCode guiaCopia: " + guiaCopia.hashCode());
    }
}