package Dominio;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReporteDePuntoCriticoTest {

    private ReporteDePuntoCritico reporteTest;
    private LocalDateTime fechaPrueba;

    @BeforeEach
    public void setUp() {
        fechaPrueba = LocalDateTime.of(2026, 11, 18, 10, 15);
        reporteTest = new ReporteDePuntoCritico(
                "Desbordamiento de plástico en Parque Central",
                "Pendiente",
                fechaPrueba
        );
    }

    @Test
    @Order(1)
    public void testConstructorYGetters() {
        assertNotNull(reporteTest);
        assertEquals("Desbordamiento de plástico en Parque Central", reporteTest.getDescripcion());
        assertEquals("Pendiente", reporteTest.getEstadoRuta());
        assertEquals(fechaPrueba, reporteTest.getFechaReporte());
        assertTrue(reporteTest.getDescripcion().contains("Parque Central"));
        assertFalse(reporteTest.getEstadoRuta().equals("Atendido"));
    }

    @Test
    @Order(2)
    public void testLogicaDeSettersYValidaciones() {
        LocalDateTime nuevaFecha = LocalDateTime.of(2026, 11, 19, 14, 0);
        reporteTest.setDescripcion("Contenedor reparado en Parque Central");
        reporteTest.setEstadoRuta("Atendido");
        reporteTest.setFechaReporte(nuevaFecha);

        assertEquals("Contenedor reparado en Parque Central", reporteTest.getDescripcion());
        assertEquals("Atendido", reporteTest.getEstadoRuta());
        assertEquals(nuevaFecha, reporteTest.getFechaReporte());
        assertTrue(reporteTest.toString().contains("Atendido"));
    }

    @Test
    @Order(3)
    public void testSettersConDatosInvalidos() {
        reporteTest.setDescripcion("   ");
        reporteTest.setEstadoRuta("");
        reporteTest.setFechaReporte(null);

        assertEquals("Desbordamiento de plástico en Parque Central", reporteTest.getDescripcion());
        assertEquals("Pendiente", reporteTest.getEstadoRuta());
        assertNotNull(reporteTest.getFechaReporte());
        assertFalse(reporteTest.getEstadoRuta().isEmpty());
    }
}