package Dominio;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RecordatorioTest {

    private Recordatorio recordatorioTest;
    private LocalDateTime fechaPrueba;

    @BeforeEach
    public void setUp() {
        fechaPrueba = LocalDateTime.of(2026, 11, 15, 8, 30);
        recordatorioTest = new Recordatorio(1, "Separar plasticos", "Reciclaje", fechaPrueba, "Semanal");
    }

    @Test
    @Order(1)
    public void testConstructorYGetters() {
        assertNotNull(recordatorioTest);
        assertEquals(1, recordatorioTest.getNumero());
        assertEquals("Separar plasticos", recordatorioTest.getTituloRecordatorio());
        assertEquals("Reciclaje", recordatorioTest.getCategoria());
        assertEquals(fechaPrueba, recordatorioTest.getFechaHora());
        assertEquals("Semanal", recordatorioTest.getFrecuencia());
        assertTrue(recordatorioTest.getNumero() > 0);
        assertFalse(recordatorioTest.getTituloRecordatorio().isEmpty());
    }

    @Test
    @Order(2)
    public void testLogicaDeSettersYValidaciones() {
        LocalDateTime nuevaFecha = LocalDateTime.of(2026, 11, 20, 7, 0);
        recordatorioTest.setNumero(5);
        recordatorioTest.setTituloRecordatorio("Sacar vidrio");
        recordatorioTest.setCategoria("Vidrio");
        recordatorioTest.setFechaHora(nuevaFecha);
        recordatorioTest.setFrecuencia("Diaria");

        assertEquals(5, recordatorioTest.getNumero());
        assertEquals("Sacar vidrio", recordatorioTest.getTituloRecordatorio());
        assertEquals("Vidrio", recordatorioTest.getCategoria());
        assertEquals(nuevaFecha, recordatorioTest.getFechaHora());
        assertEquals("Diaria", recordatorioTest.getFrecuencia());
        assertTrue(recordatorioTest.toString().contains("Sacar vidrio"));
    }

    @Test
    @Order(3)
    public void testSettersConDatosInvalidos() {
        recordatorioTest.setNumero(-3);
        recordatorioTest.setTituloRecordatorio("   ");
        recordatorioTest.setCategoria("");
        recordatorioTest.setFechaHora(null);
        recordatorioTest.setFrecuencia(null);

        assertEquals(1, recordatorioTest.getNumero());
        assertEquals("Separar plasticos", recordatorioTest.getTituloRecordatorio());
        assertEquals("Reciclaje", recordatorioTest.getCategoria());
        assertNotNull(recordatorioTest.getFechaHora());
        assertEquals("Semanal", recordatorioTest.getFrecuencia());
        assertFalse(recordatorioTest.getNumero() <= 0);
    }
}