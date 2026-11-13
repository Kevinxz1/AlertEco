package Dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsuarioHogarTest {

    private UsuarioHogar usuarioTest;

    @BeforeEach
    public void setUp() {
        usuarioTest = new UsuarioHogar("kgaleas", "Kevin Galeas", "kgaleas@uce.edu.ec", "Clave123", 10.0);
    }

    @Test
    @Order(1)
    public void testConstructorYGetters() {
        assertEquals("kgaleas", usuarioTest.getUsuario());
        assertEquals("Kevin Galeas", usuarioTest.getNombre());
        assertEquals("kgaleas@uce.edu.ec", usuarioTest.getCorreo());
        assertEquals("Clave123", usuarioTest.getContrasenia());
        assertEquals(10.0, usuarioTest.getMetaReciclajeKg());
        assertFalse(usuarioTest.isMetaCumplida());
    }

    @Test
    @Order(2)
    public void testLogicaDeSettersYMetaCumplida() {
        usuarioTest.setCantidadRecicladaKg(5.0);
        assertEquals(5.0, usuarioTest.getCantidadRecicladaKg());
        assertFalse(usuarioTest.isMetaCumplida());

        usuarioTest.setCantidadRecicladaKg(12.0);
        assertTrue(usuarioTest.isMetaCumplida());
    }

    @Test
    @Order(3)
    public void testSettersConDatosInvalidos() {
        usuarioTest.setCantidadRecicladaKg(-5.0);
        assertEquals(0.0, usuarioTest.getCantidadRecicladaKg());
    }
}