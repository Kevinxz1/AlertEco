package Dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdministradorTest {

    private Administrador adminTest;

    @BeforeEach
    public void setUp() {
        adminTest = new Administrador(
                1,
                "Max Verstappen",
                "MV1@admin.com",
                "0991112233",
                "Sector RedBull",
                "Admin123!",
                "Activo"
        );
    }

    @Test
    @Order(1)
    public void testConstructorYGetters() {
        assertNotNull(adminTest);
        assertEquals(1, adminTest.getIdUsuario());
        assertEquals("Max Verstappen", adminTest.getNombresYApellidos());
        assertEquals("MV1@admin.com", adminTest.getCorreoElectronico());
        assertTrue(adminTest.getCorreoElectronico().matches("^[A-Za-z0-9+_.-]+@(.+)$"));
        assertEquals("0991112233", adminTest.getTelefonoDeContacto());
        assertEquals("Sector RedBull", adminTest.getSectorDireccion());
        assertEquals("Admin123!", adminTest.getContrasena());
        assertEquals("Activo", adminTest.getEstadoDeLaCuenta());
        assertFalse(adminTest.getEstadoDeLaCuenta().equals("Inactivo"));
    }

    @Test
    @Order(2)
    public void testLogicaDeSettersYValidaciones() {
        adminTest.setIdUsuario(33);
        adminTest.setNombresYApellidos("Max Emilian Verstappen");
        adminTest.setCorreoElectronico("max.verstappen@redbull.com");
        adminTest.setTelefonoDeContacto("0987654321");
        adminTest.setSectorDireccion("Zandvoort");
        adminTest.setContrasena("SuperMax33!");

        assertEquals(33, adminTest.getIdUsuario());
        assertEquals("Max Emilian Verstappen", adminTest.getNombresYApellidos());
        assertEquals("max.verstappen@redbull.com", adminTest.getCorreoElectronico());
        assertEquals("SuperMax33!", adminTest.getContrasena());
        assertTrue(adminTest.validarCredenciales("max.verstappen@redbull.com", "SuperMax33!"));
        assertFalse(adminTest.validarCredenciales("max.verstappen@redbull.com", "claveMala"));

        // Relaciones de agregación
        LugarDeAcopio[] lugares = new LugarDeAcopio[]{new LugarDeAcopio(), new LugarDeAcopio()};
        GuiaDeReciclaje[] guias = new GuiaDeReciclaje[]{new GuiaDeReciclaje()};
        ReporteDePuntoCritico[] reportes = new ReporteDePuntoCritico[]{new ReporteDePuntoCritico()};

        adminTest.setLugaresDeAcopioGestionados(lugares);
        adminTest.setGuiasPublicadas(guias);
        adminTest.setReportesResueltos(reportes);

        assertNotNull(adminTest.getLugaresDeAcopioGestionados());
        assertEquals(2, adminTest.getLugaresDeAcopioGestionados().length);
        assertSame(lugares[0], adminTest.getLugaresDeAcopioGestionados()[0]);

        assertNotNull(adminTest.getGuiasPublicadas());
        assertEquals(1, adminTest.getGuiasPublicadas().length);
        assertSame(guias[0], adminTest.getGuiasPublicadas()[0]);

        assertNotNull(adminTest.getReportesResueltos());
        assertEquals(1, adminTest.getReportesResueltos().length);
        assertSame(reportes[0], adminTest.getReportesResueltos()[0]);

        adminTest.eliminarCuenta();
        assertEquals("Inactivo", adminTest.getEstadoDeLaCuenta());
    }

    @Test
    @Order(3)
    public void testSettersConDatosInvalidos() {
        adminTest.setIdUsuario(-10);
        adminTest.setNombresYApellidos("   ");
        adminTest.setCorreoElectronico("");
        adminTest.setContrasena("rb19");

        // Los valores válidos previos deben mantenerse intactos
        assertEquals(1, adminTest.getIdUsuario());
        assertEquals("Max Verstappen", adminTest.getNombresYApellidos());
        assertEquals("MV1@admin.com", adminTest.getCorreoElectronico());
        assertEquals("Admin123!", adminTest.getContrasena());
        assertFalse(adminTest.getContrasena().equals("rb19"));
    }
}