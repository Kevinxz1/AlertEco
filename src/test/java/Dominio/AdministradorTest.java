package Dominio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdministradorTest {

    @Test
    @Order(1)
    public void testRegistroAdministradorValido() {
        // Instancia usando los 7 atributos reales heredados de Usuario
        Administrador admin = new Administrador(
                1,
                "Max Verstappen",
                "MV1@admin.com",
                "0991112233",
                "Sector RedBull",
                "Admin123!",
                "Activo"
        );

        assertNotNull(admin);
        assertEquals(1, admin.getIdUsuario());
        assertEquals("Max Verstappen", admin.getNombresYApellidos());
        assertTrue(admin.getCorreoElectronico().matches("^[A-Za-z0-9+_.-]+@(.+)$"));
        assertEquals("0991112233", admin.getTelefonoDeContacto());
        assertEquals("Sector RedBull", admin.getSectorDireccion());
        assertEquals("Admin123!", admin.getContrasena());
        assertEquals("Activo", admin.getEstadoDeLaCuenta());
    }

    @Test
    @Order(2)
    public void testSettersYValidaciones() {
        Administrador admin = new Administrador();

        admin.setIdUsuario(33);
        admin.setNombresYApellidos("Max Emilian Verstappen");
        admin.setCorreoElectronico("max.verstappen@redbull.com");
        admin.setTelefonoDeContacto("0987654321");
        admin.setSectorDireccion("Zandvoort");
        admin.setEstadoDeLaCuenta("Activo");

        //1. Prueba de contraseña válida (>= 8 caracteres)
        admin.setContrasena("SuperMax33!");
        assertEquals("SuperMax33!", admin.getContrasena());

        //2. Prueba de contraseña inválida (< 8 caracteres): no debe sobrescribir la contraseña válida
        admin.setContrasena("rb19");
        assertEquals("SuperMax33!", admin.getContrasena());

        //3. Verificación de los demás setters y métodos heredados de Usuario
        assertEquals(33, admin.getIdUsuario());
        assertEquals("Max Emilian Verstappen", admin.getNombresYApellidos());
        assertEquals("max.verstappen@redbull.com", admin.getCorreoElectronico());
        assertTrue(admin.validarCredenciales("max.verstappen@redbull.com", "SuperMax33!"));

        admin.eliminarCuenta();
        assertEquals("Inactivo", admin.getEstadoDeLaCuenta());
    }

    @Test
    @Order(3)
    public void testRelacionesAgregacion() {
        Administrador admin = new Administrador(
                1,
                "Max Verstappen",
                "MV1@admin.com",
                "0991112233",
                "Sector Quito",
                "Admin123!",
                "Activo"
        );

        //Creación de los arreglos de agregación con sus objetos del paquete Dominio
        LugarDeAcopio[] lugares = new LugarDeAcopio[]{
                new LugarDeAcopio(),
                new LugarDeAcopio()
        };

        GuiaDeReciclaje[] guias = new GuiaDeReciclaje[]{
                new GuiaDeReciclaje()
        };

        ReporteDePuntoCritico[] reportes = new ReporteDePuntoCritico[]{
                new ReporteDePuntoCritico(),
                new ReporteDePuntoCritico()
        };

        //Asignación mediante setters de Administrador
        admin.setLugaresDeAcopioGestionados(lugares);
        admin.setGuiasPublicadas(guias);
        admin.setReportesResueltos(reportes);

        //verificamos que las agregaciones se guarden y relacionen bien
        assertNotNull(admin.getLugaresDeAcopioGestionados());
        assertEquals(2, admin.getLugaresDeAcopioGestionados().length);
        assertSame(lugares[0], admin.getLugaresDeAcopioGestionados()[0]);

        assertNotNull(admin.getGuiasPublicadas());
        assertEquals(1, admin.getGuiasPublicadas().length);
        assertSame(guias[0], admin.getGuiasPublicadas()[0]);

        assertNotNull(admin.getReportesResueltos());
        assertEquals(2, admin.getReportesResueltos().length);
        assertSame(reportes[0], admin.getReportesResueltos()[0]);
    }
}