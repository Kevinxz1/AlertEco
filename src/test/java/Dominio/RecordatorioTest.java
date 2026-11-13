package Dominio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.time.LocalDateTime;


import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RecordatorioTest {

    private Recordatorio recordatorioTest;
    private LocalDateTime fechaPrueba;

    @BeforeEach
    public void setUp(){
        fechaPrueba = LocalDateTime.of(2026, 11, 15, 8, 30);
        recordatorioTest = new Recordatorio(1, "Separar plasticos", "Reciclaje", fechaPrueba, "Semanal");
    }

    @Test//
    @Order(1)
    public void testConstructorYGetters(){
        assertNotNull(recordatorioTest);
        assertEquals(1, recordatorioTest.getNumero());
        assertEquals("Separar plasticos", recordatorioTest.getTituloRecordatorio());
        assertEquals("Reciclaje", recordatorioTest.getCategoria());
        assertEquals(fechaPrueba, recordatorioTest.getFechaHora());
        assertEquals("Semanal", recordatorioTest.getFrecuencia());
    }

    @Test
    @Order(2)
    public void testSettersValidos(){
        recordatorioTest.setNumero(5);
        recordatorioTest.setTituloRecordatorio("Sacar vidrio");
        recordatorioTest.setFrecuencia("Diaria");

        assertEquals(5, recordatorioTest.getNumero());
        assertEquals("Sacar vidrio", recordatorioTest.getTituloRecordatorio());
        assertEquals("Diaria", recordatorioTest.getFrecuencia());
    }

    @Test
    @Order(3)
    public void testSetterNumeroInvalido(){
        recordatorioTest.setNumero(-3);
        assertEquals(1,recordatorioTest.getNumero());
    }



}
