package Dominio;

import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RecolectorTest {

    private Recolector recolectorTest;
    private EntregaDeReciclaje[] entregasIniciales;

    @BeforeEach
    public void setUp() {
        entregasIniciales = new EntregaDeReciclaje[]{
                new EntregaDeReciclaje(1, "Plástico", 5.0, new Date(), "Ruta Norte")
        };
        recolectorTest = new Recolector(
                100,
                "Lewis Hamilton",
                "hamilton@recolector.com",
                "0994445566",
                "Ruta Norte",
                "Rec12345!",
                "Activo",
                entregasIniciales
        );
    }

    @Test
    @Order(1)
    public void testConstructorYGetters() {
        assertNotNull(recolectorTest);
        assertEquals(100, recolectorTest.getIdUsuario());
        assertEquals("Lewis Hamilton", recolectorTest.getNombresYApellidos());
        assertEquals("hamilton@recolector.com", recolectorTest.getCorreoElectronico());
        assertTrue(recolectorTest.getCorreoElectronico().matches("^[A-Za-z0-9+_.-]+@(.+)$"));
        assertEquals("0994445566", recolectorTest.getTelefonoDeContacto());
        assertEquals("Ruta Norte", recolectorTest.getSectorDireccion());
        assertEquals("Rec12345!", recolectorTest.getContrasena());
        assertEquals("Activo", recolectorTest.getEstadoDeLaCuenta());
        assertNotNull(recolectorTest.getEntregasValidadas());
        assertEquals(1, recolectorTest.getEntregasValidadas().length);
        assertFalse(recolectorTest.getEstadoDeLaCuenta().equals("Inactivo"));
    }

    @Test
    @Order(2)
    public void testLogicaDeSettersYValidaciones() {
        EntregaDeReciclaje[] nuevasEntregas = new EntregaDeReciclaje[]{
                new EntregaDeReciclaje(2, "Cartón", 12.0, new Date(), "Sector Sur"),
                new EntregaDeReciclaje(3, "Vidrio", 4.5, new Date(), "Sector Sur")
        };

        recolectorTest.setSectorDireccion("Ruta Sur");
        recolectorTest.setContrasena("NuevaClave88!");
        recolectorTest.setEntregasValidadas(nuevasEntregas);

        assertEquals("Ruta Sur", recolectorTest.getSectorDireccion());
        assertEquals("NuevaClave88!", recolectorTest.getContrasena());
        assertEquals(2, recolectorTest.getEntregasValidadas().length);
        assertTrue(recolectorTest.validarCredenciales("hamilton@recolector.com", "NuevaClave88!"));
        assertFalse(recolectorTest.validarCredenciales("hamilton@recolector.com", "incorrecta"));

        recolectorTest.eliminarCuenta();
        assertEquals("Inactivo", recolectorTest.getEstadoDeLaCuenta());
    }

    @Test
    @Order(3)
    public void testSettersConDatosInvalidos() {
        recolectorTest.setIdUsuario(0);
        recolectorTest.setNombresYApellidos("");
        recolectorTest.setCorreoElectronico("   ");
        recolectorTest.setContrasena("1234");
        recolectorTest.setEntregasValidadas(null);

        assertEquals(100, recolectorTest.getIdUsuario());
        assertEquals("Lewis Hamilton", recolectorTest.getNombresYApellidos());
        assertEquals("hamilton@recolector.com", recolectorTest.getCorreoElectronico());
        assertEquals("Rec12345!", recolectorTest.getContrasena());
        assertNotNull(recolectorTest.getEntregasValidadas());
        assertFalse(recolectorTest.getContrasena().equals("1234"));
    }
}