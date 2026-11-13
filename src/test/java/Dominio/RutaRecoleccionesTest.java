package Dominio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RutaRecoleccionesTest {

    private RutaRecoleccion rutaTest;

    @BeforeEach
    public void setUp(){
        rutaTest = new RutaRecoleccion(101, "Sector Norte", "Lat:-0.18, Lang:-78.48", "Lunes y Jueves", "8:00 AM");

    }

    @Test
    @Order(1)
    public void testConstructorYGetters(){
        assertNotNull(rutaTest);
        assertEquals(101, rutaTest.getIdRuta());
        assertEquals("Sector Norte", rutaTest.getSector());
        assertEquals("Lat:-0.18, Lang:-78.48", rutaTest.getCoordenadasMapa());
        assertEquals("Lunes y Jueves", rutaTest.getFrecuenciaSemanal());
        assertEquals("8:00 AM", rutaTest.getHoraEstimada());

    }

    @Test
    @Order(2)
    public void testSettersValidos(){
        rutaTest.setIdRuta(202);
        rutaTest.setSector("Sector Sur");
        rutaTest.setHoraEstimada("11:30 AM");

        assertEquals(202, rutaTest.getIdRuta());
        assertEquals("Sector Sur", rutaTest.getSector());
        assertEquals("11:30 AM", rutaTest.getHoraEstimada());
    }

    @Test
    @Order(3)
    public void testSetterIdRutaInvalido(){
        rutaTest.setIdRuta(0);
        assertEquals(101, rutaTest.getIdRuta());
    }
}
