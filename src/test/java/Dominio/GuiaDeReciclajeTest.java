package Dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GuiaDeReciclajeTest {

    private GuiaDeReciclaje guiaTest;

    @BeforeEach
    public void setUp() {
        guiaTest = new GuiaDeReciclaje(
                1,
                "Plástico",
                "Enjuagar y aplastar botellas PET antes de depositar."
        );
    }

    @Test
    @Order(1)
    public void testConstructorYGetters() {
        assertNotNull(guiaTest);
        assertEquals(1, guiaTest.getIdDeGuia());
        assertEquals("Plástico", guiaTest.getCategoria());
        assertEquals("Enjuagar y aplastar botellas PET antes de depositar.", guiaTest.getTituloEInstrucciones());
        assertTrue(guiaTest.getIdDeGuia() > 0);
        assertFalse(guiaTest.getCategoria().equals("Sin clasificar"));
    }

    @Test
    @Order(2)
    public void testLogicaDeSettersYValidaciones() {
        guiaTest.setIdDeGuia(4);
        guiaTest.setCategoria("Vidrio");
        guiaTest.setTituloEInstrucciones("Separar botellas de vidrio limpias y sin tapas metálicas.");

        assertEquals(4, guiaTest.getIdDeGuia());
        assertEquals("Vidrio", guiaTest.getCategoria());
        assertEquals("Separar botellas de vidrio limpias y sin tapas metálicas.", guiaTest.getTituloEInstrucciones());
        assertTrue(guiaTest.toString().contains("Categoría: Vidrio"));
        assertFalse(guiaTest.getCategoria().equals("Plástico"));

        // Verificación de las otras categorías permitidas por la regla de negocio
        guiaTest.setCategoria("Papel");
        assertEquals("Papel", guiaTest.getCategoria());

        guiaTest.setCategoria("Orgánico");
        assertEquals("Orgánico", guiaTest.getCategoria());
    }

    @Test
    @Order(3)
    public void testSettersConDatosInvalidos() {
        guiaTest.setIdDeGuia(-2);
        guiaTest.setTituloEInstrucciones("   ");
        guiaTest.setCategoria("Metal");

        // ID y título conservan los valores válidos previos
        assertEquals(1, guiaTest.getIdDeGuia());
        assertEquals("Enjuagar y aplastar botellas PET antes de depositar.", guiaTest.getTituloEInstrucciones());
        assertTrue(guiaTest.getIdDeGuia() > 0);
        assertNotNull(guiaTest.getTituloEInstrucciones());

        // Según la regla de negocio en setCategoria(), una categoría no permitida asigna "Sin clasificar"
        assertEquals("Sin clasificar", guiaTest.getCategoria());
        assertFalse(guiaTest.getCategoria().equals("Metal"));

        guiaTest.setCategoria(null);
        assertEquals("Sin clasificar", guiaTest.getCategoria());
    }
}