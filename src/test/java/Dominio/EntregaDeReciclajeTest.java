package Dominio;

import java.util.Date;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EntregaDeReciclajeTest {

    @Test
    @Order(1)
    public void testRegistroEntrega() {
        Date fechaActual = new Date();
        EntregaDeReciclaje entrega = new EntregaDeReciclaje(
                10,
                "Cartón",
                15.5,
                fechaActual,
                "Cajas limpias y dobladas"
        );

        assertEquals(10, entrega.getIdEntrega());
        assertEquals("Cartón", entrega.getTipoDeMaterial());
        assertEquals(15.5, entrega.getPesoOCantidadAproximada());
        assertEquals(fechaActual, entrega.getFechaDeEntrega());
        assertEquals("Pendiente", entrega.getEstado());
        assertEquals("Cajas limpias y dobladas", entrega.getObservaciones());
        assertTrue(entrega.getPesoOCantidadAproximada() > 0);
    }

    @Test
    @Order(2)
    public void testConstructorSinParametros() {
        EntregaDeReciclaje entrega = new EntregaDeReciclaje();

        assertEquals(1, entrega.getIdEntrega());
        assertEquals("Plástico", entrega.getTipoDeMaterial());
        assertEquals(1.5, entrega.getPesoOCantidadAproximada());
        assertNotNull(entrega.getFechaDeEntrega());
        assertEquals("Pendiente", entrega.getEstado());
        assertEquals("Sin observaciones", entrega.getObservaciones());
    }

    @Test
    @Order(3)
    public void testValidacionesSetters() {
        EntregaDeReciclaje entrega = new EntregaDeReciclaje();

        // Valores inválidos no deben modificar el estado actual del objeto
        entrega.setIdEntrega(-1);
        entrega.setTipoDeMaterial("   ");
        entrega.setPesoOCantidadAproximada(-5.0);
        entrega.setFechaDeEntrega(null);
        entrega.setEstado("");

        assertEquals(1, entrega.getIdEntrega());
        assertEquals("Plástico", entrega.getTipoDeMaterial());
        assertEquals(1.5, entrega.getPesoOCantidadAproximada());
        assertNotNull(entrega.getFechaDeEntrega());
        assertEquals("Pendiente", entrega.getEstado());
    }

    @Test
    @Order(4)
    public void testToString() {
        EntregaDeReciclaje entrega = new EntregaDeReciclaje(
                2,
                "Vidrio",
                4.0,
                new Date(),
                "Botellas verdes"
        );

        String salida = entrega.toString();
        assertTrue(salida.contains("ID Entrega: 2"));
        assertTrue(salida.contains("Tipo de Material: Vidrio"));
        assertTrue(salida.contains("Peso / Cantidad Aproximada: 4.0"));
        assertTrue(salida.contains("Estado: Pendiente"));
    }
}