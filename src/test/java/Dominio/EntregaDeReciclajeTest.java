package Dominio;

import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EntregaDeReciclajeTest {

    private EntregaDeReciclaje entregaTest;
    private Date fechaPrueba;

    @BeforeEach
    public void setUp() {
        fechaPrueba = new Date();
        entregaTest = new EntregaDeReciclaje(
                10,
                "Cartón",
                15.5,
                fechaPrueba,
                "Cajas limpias y dobladas"
        );
    }

    @Test
    @Order(1)
    public void testConstructorYGetters() {
        assertNotNull(entregaTest);
        assertEquals(10, entregaTest.getIdEntrega());
        assertEquals("Cartón", entregaTest.getTipoDeMaterial());
        assertEquals(15.5, entregaTest.getPesoOCantidadAproximada());
        assertEquals(fechaPrueba, entregaTest.getFechaDeEntrega());
        assertEquals("Pendiente", entregaTest.getEstado());
        assertEquals("Cajas limpias y dobladas", entregaTest.getObservaciones());
        assertTrue(entregaTest.getPesoOCantidadAproximada() > 0);
        assertFalse(entregaTest.getEstado().equals("Validada"));
    }

    @Test
    @Order(2)
    public void testLogicaDeSettersYValidaciones() {
        Date nuevaFecha = new Date();
        entregaTest.setIdEntrega(25);
        entregaTest.setTipoDeMaterial("Vidrio");
        entregaTest.setPesoOCantidadAproximada(8.25);
        entregaTest.setFechaDeEntrega(nuevaFecha);
        entregaTest.setEstado("Validada");
        entregaTest.setObservaciones("Botellas verdes separadas");

        assertEquals(25, entregaTest.getIdEntrega());
        assertEquals("Vidrio", entregaTest.getTipoDeMaterial());
        assertEquals(8.25, entregaTest.getPesoOCantidadAproximada());
        assertEquals(nuevaFecha, entregaTest.getFechaDeEntrega());
        assertEquals("Validada", entregaTest.getEstado());
        assertEquals("Botellas verdes separadas", entregaTest.getObservaciones());
        assertTrue(entregaTest.toString().contains("Tipo de Material: Vidrio"));
    }

    @Test
    @Order(3)
    public void testSettersConDatosInvalidos() {
        entregaTest.setIdEntrega(-1);
        entregaTest.setTipoDeMaterial("   ");
        entregaTest.setPesoOCantidadAproximada(-5.0);
        entregaTest.setFechaDeEntrega(null);
        entregaTest.setEstado("");

        assertEquals(10, entregaTest.getIdEntrega());
        assertEquals("Cartón", entregaTest.getTipoDeMaterial());
        assertEquals(15.5, entregaTest.getPesoOCantidadAproximada());
        assertNotNull(entregaTest.getFechaDeEntrega());
        assertEquals("Pendiente", entregaTest.getEstado());
        assertFalse(entregaTest.getPesoOCantidadAproximada() <= 0);
    }
}