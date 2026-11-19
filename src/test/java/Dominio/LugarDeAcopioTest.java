package Dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LugarDeAcopioTest {

    private LugarDeAcopio lugarTest;

    @BeforeEach
    public void setUp() {
        lugarTest = new LugarDeAcopio(
                "-0.180653, -78.467834",
                "Punto Eco Norte",
                "Disponible"
        );
    }

    @Test
    @Order(1)
    public void testConstructorYGetters() {
        assertNotNull(lugarTest);
        assertEquals("-0.180653, -78.467834", lugarTest.getUbicacionGPS());
        assertEquals("Punto Eco Norte", lugarTest.getNombrePunto());
        assertEquals("Disponible", lugarTest.getEstadoContenedor());
        assertTrue(lugarTest.getNombrePunto().contains("Eco"));
        assertFalse(lugarTest.getEstadoContenedor().equals("Lleno"));
    }

    @Test
    @Order(2)
    public void testLogicaDeSettersYValidaciones() {
        lugarTest.setUbicacionGPS("-0.175200, -78.485100");
        lugarTest.setNombrePunto("Punto Parque La Carolina");
        lugarTest.setEstadoContenedor("Lleno");

        assertEquals("-0.175200, -78.485100", lugarTest.getUbicacionGPS());
        assertEquals("Punto Parque La Carolina", lugarTest.getNombrePunto());
        assertEquals("Lleno", lugarTest.getEstadoContenedor());
        assertTrue(lugarTest.toString().contains("Punto Parque La Carolina"));
        assertFalse(lugarTest.getEstadoContenedor().equals("Disponible"));
    }

    @Test
    @Order(3)
    public void testSettersConDatosInvalidos() {
        lugarTest.setUbicacionGPS("   ");
        lugarTest.setNombrePunto("");
        lugarTest.setEstadoContenedor(null);

        assertNotNull(lugarTest.getUbicacionGPS());
        assertNotNull(lugarTest.getNombrePunto());
        assertNotNull(lugarTest.getEstadoContenedor());
        assertEquals("-0.180653, -78.467834", lugarTest.getUbicacionGPS());
        assertEquals("Punto Eco Norte", lugarTest.getNombrePunto());
        assertEquals("Disponible", lugarTest.getEstadoContenedor());
        assertFalse(lugarTest.getNombrePunto().isEmpty());
    }
}