package Dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsuarioDelHogarTest {

    private UsuarioDelHogar usuarioTest;

    @BeforeEach
    public void setUp() {
        usuarioTest = new UsuarioDelHogar(
                101,
                "Kevin Galeas",
                "kgaleas@uce.edu.ec",
                "0987654321",
                "Quito Norte",
                "Clave123",
                "Activo"
        );
    }

    @Test
    @Order(1)
    public void testConstructorYGetters() {
        assertNotNull(usuarioTest);
        assertEquals(101, usuarioTest.getIdUsuario());
        assertEquals("Kevin Galeas", usuarioTest.getNombresYApellidos());
        assertEquals("kgaleas@uce.edu.ec", usuarioTest.getCorreoElectronico());
        assertTrue(usuarioTest.getCorreoElectronico().matches("^[A-Za-z0-9+_.-]+@(.+)$"));
        assertEquals("0987654321", usuarioTest.getTelefonoDeContacto());
        assertEquals("Quito Norte", usuarioTest.getSectorDireccion());
        assertEquals("Clave123", usuarioTest.getContrasena());
        assertEquals("Activo", usuarioTest.getEstadoDeLaCuenta());
        assertNotNull(usuarioTest.getEntregasRegistradas());
        assertFalse(usuarioTest.getEstadoDeLaCuenta().equals("Inactivo"));
    }

    @Test
    @Order(2)
    public void testLogicaDeSettersYValidaciones() {
        usuarioTest.setNombresYApellidos("Kevin Adrian Galeas");
        usuarioTest.setSectorDireccion("Quito Centro Norte");
        usuarioTest.setContrasena("NuevaClave2026");

        assertEquals("Kevin Adrian Galeas", usuarioTest.getNombresYApellidos());
        assertEquals("Quito Centro Norte", usuarioTest.getSectorDireccion());
        assertEquals("NuevaClave2026", usuarioTest.getContrasena());
        assertTrue(usuarioTest.validarCredenciales("kgaleas@uce.edu.ec", "NuevaClave2026"));
        assertFalse(usuarioTest.validarCredenciales("kgaleas@uce.edu.ec", "Clave123"));

        // Relaciones de agregación
        EntregaDeReciclaje[] entregas = new EntregaDeReciclaje[]{new EntregaDeReciclaje(), new EntregaDeReciclaje()};
        ReporteDePuntoCritico[] reportes = new ReporteDePuntoCritico[]{new ReporteDePuntoCritico()};
        Recordatorio[] recordatorios = new Recordatorio[]{new Recordatorio(), new Recordatorio(), new Recordatorio()};

        usuarioTest.setEntregasRegistradas(entregas);
        usuarioTest.setReportesCreados(reportes);
        usuarioTest.setRecordatorios(recordatorios);

        assertNotNull(usuarioTest.getEntregasRegistradas());
        assertNotNull(usuarioTest.getReportesCreados());
        assertNotNull(usuarioTest.getRecordatorios());
        assertEquals(2, usuarioTest.getEntregasRegistradas().length);
        assertEquals(1, usuarioTest.getReportesCreados().length);
        assertEquals(3, usuarioTest.getRecordatorios().length);

        usuarioTest.eliminarCuenta();
        assertEquals("Inactivo", usuarioTest.getEstadoDeLaCuenta());
    }

    @Test
    @Order(3)
    public void testSettersConDatosInvalidos() {
        usuarioTest.setIdUsuario(-5);
        usuarioTest.setNombresYApellidos("");
        usuarioTest.setCorreoElectronico("   ");
        usuarioTest.setContrasena("12345");
        usuarioTest.setEntregasRegistradas(null);
        usuarioTest.setReportesCreados(null);
        usuarioTest.setRecordatorios(null);

        assertEquals(101, usuarioTest.getIdUsuario());
        assertEquals("Kevin Galeas", usuarioTest.getNombresYApellidos());
        assertEquals("kgaleas@uce.edu.ec", usuarioTest.getCorreoElectronico());
        assertEquals("Clave123", usuarioTest.getContrasena());
        assertNotNull(usuarioTest.getEntregasRegistradas());
        assertNotNull(usuarioTest.getReportesCreados());
        assertNotNull(usuarioTest.getRecordatorios());
        assertFalse(usuarioTest.getContrasena().equals("12345"));
    }
}