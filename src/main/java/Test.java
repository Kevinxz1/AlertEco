import Dominio.PuntoReciclaje;
import Dominio.Recordatorio;
import Dominio.RutaRecoleccion;
import Dominio.UsuarioHogar;
import java.time.LocalDateTime;

public class Test {

    public void ejecutarPruebas() {
        System.out.println("--------------------------------------------------");
        System.out.println("   TEST DE INSTANCIACIÓN DE POJOS (DOMINIO)       ");
        System.out.println("--------------------------------------------------");


        UsuarioHogar testUsuario = new UsuarioHogar("kevin_galeas1", "Kevin Galeas", "kgaleas@uce.edu.ec", "clavesitaindesifrable123");
        System.out.println(testUsuario.toString());
        System.out.println("--------------------------------------------------");


        Recordatorio testRecordatorio = new Recordatorio(1, "Separar plásticos", "Reciclaje", LocalDateTime.now(), "Semanal");
        System.out.println(testRecordatorio.toString());
        System.out.println("--------------------------------------------------");


        RutaRecoleccion testRuta = new RutaRecoleccion(101, "Sector Norte", "Lat:-0.18, Lng:-78.48", "Lunes y Jueves", "08:00 AM");
        System.out.println(testRuta.toString());
        System.out.println("--------------------------------------------------");

        // Prueba: Módulo Reciclaje
        PuntoReciclaje testPunto = new PuntoReciclaje("Lat:-0.19, Lng:-78.49", "Contenedor Parque Bicentenario", "Activo - Medio Lleno");
        System.out.println(testPunto.toString());

        System.out.println("--------------------------------------------------");
        System.out.println("       FIN DEL TEST - INICIANDO SISTEMA         ");
        System.out.println("--------------------------------------------------");
    }
}