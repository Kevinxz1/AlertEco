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
        Administrador admin = new Administrador("MaxVerstappen", "MV1@admin.com", "Admin123!", "ADM-001");
        assertNotNull(admin);
        assertTrue(admin.getCorreo().matches("^[A-Za-z0-9+_.-]+@(.+)$"));
        assertEquals("ADM-001", admin.getIdAdmin());
    }
}