package Dominio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PuntoReciclajeTest {

    private PuntoReciclaje puntoTest;

    @BeforeEach
    public void setUp(){
        puntoTest = new PuntoReciclaje("Lat:-19, Lng:-78.49", "Contenedor Parque Bicentenario", "Activo - Medio Lleno");
    }
    @Test
    @Order(1)
    public void testConstructoresYGetters(){
        assertNotNull(puntoTest);
        assertEquals("Lat:-19, Lng:-78.49", puntoTest.getUbicacionGPS());
        assertEquals("Contenedor Parque Bicentenario", puntoTest.getNombrePunto());
        assertEquals("Activo - Medio Lleno", puntoTest.getEstadoContenedor());

    }

    @Test
    @Order(2)
    public void testSettersValidos(){
        puntoTest.setNombrePunto("Cotenedor Cumbaya");
        puntoTest.setEstadoContenedor("Activo - Lleno");

        assertEquals("Cotenedor Cumbaya", puntoTest.getNombrePunto());
        assertEquals("Activo - Lleno", puntoTest.getEstadoContenedor());
    }

    @Test
    @Order(3)
    public void testSetterEstadoInvalido(){
        puntoTest.setEstadoContenedor("");
        assertEquals("Activo - Medio Lleno" , puntoTest.getEstadoContenedor());
    }
}
