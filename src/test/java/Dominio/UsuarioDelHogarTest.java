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
        usuarioTest = new UsuarioDelHogar(101, "Kevin Galeas", "kgaleas@uce.edu.ec",
                "0987654321", "Quito Norte", "Clave123", "Activo");
    }

    @Test
    @Order(1)
    public void testConstructorYGettersHeredados() {
        assertEquals(101, usuarioTest.getIdUsuario());
        assertEquals("Kevin Galeas", usuarioTest.getNombresYApellidos());
        assertEquals("kgaleas@uce.edu.ec", usuarioTest.getCorreoElectronico());
        assertEquals("0987654321", usuarioTest.getTelefonoDeContacto());
        assertEquals("Quito Norte", usuarioTest.getSectorDireccion());
        assertEquals("Clave123", usuarioTest.getContrasena());
        assertEquals("Activo", usuarioTest.getEstadoDeLaCuenta());
    }

    @Test
    @Order(2)
    public void testSettersHeredados() {
        usuarioTest.setNombresYApellidos("Nuevo Nombre");
        usuarioTest.setEstadoDeLaCuenta("Inactivo");

        assertEquals("Nuevo Nombre", usuarioTest.getNombresYApellidos());
        assertEquals("Inactivo", usuarioTest.getEstadoDeLaCuenta());
    }

    @Test
    @Order(3)
    public void testRelacionesDeAgregacion() {
        EntregaDeReciclaje[] entregas = new EntregaDeReciclaje[2];
        ReporteDePuntoCritico[] reportes = new ReporteDePuntoCritico[1];
        Recordatorio[] recordatorios = new Recordatorio[3];

        usuarioTest.setEntregasRegistradas(entregas);
        usuarioTest.setReportesCreados(reportes);
        usuarioTest.setRecordatorios(recordatorios);

        assertNotNull(usuarioTest.getEntregasRegistradas());
        assertNotNull(usuarioTest.getReportesCreados());
        assertNotNull(usuarioTest.getRecordatorios());
        assertEquals(2, usuarioTest.getEntregasRegistradas().length);
    }
}