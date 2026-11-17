package Dominio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RecolectorTest {

    @Test
    @Order(1)
    public void testAsignacionRuta() {
        Recolector recolector = new Recolector("Hamilton", "Hamilton@recolector.com", "Rec123!", "REC-100", "Ruta Norte");
        assertEquals("Ruta Norte", recolector.getRutaAsignada());
        assertTrue(recolector.getCorreo().matches("^[A-Za-z0-9+_.-]+@(.+)$"));
    }
}