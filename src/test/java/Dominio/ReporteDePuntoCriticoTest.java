package Dominio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReporteDePuntoCriticoTest {

    @Test
    @Order(1)
    public void testCreacionReporte() {
        ReporteDePuntoCritico reporte = new ReporteDePuntoCritico("Desbordamiento de plástico", "Parque Central", "Pendiente");
        assertEquals("Pendiente", reporte.getEstado());
        assertNotNull(reporte.getDescripcion());
    }

    @Test
    @Order(2)
    public void testActualizacionEstado() {
        ReporteDePuntoCritico reporte = new ReporteDePuntoCritico("Desbordamiento de plástico", "Parque Central", "Pendiente");
        reporte.setEstado("Atendido");
        assertEquals("Atendido", reporte.getEstado());
    }
}