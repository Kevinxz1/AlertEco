package Dominio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EntregaDeReciclajeTest {

    @Test
    @Order(1)
    public void testRegistroEntrega() {
        EntregaDeReciclaje entrega = new EntregaDeReciclaje("2026-11-16", 15.5, "Cartón");
        assertEquals("Cartón", entrega.getTipoDeMaterial());
        assertTrue(entrega.getCantidadReciclada() > 0);
    }
}