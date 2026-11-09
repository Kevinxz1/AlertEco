import Dominio.PuntoReciclaje;
import Dominio.Recordatorio;
import Dominio.RutaRecoleccion;
import Dominio.UsuarioHogar;
import java.time.LocalDateTime;

public class Test {

    public void ejecutarPruebas() {
        System.out.println("==================================================");
        System.out.println("   TEST DE MÉTODOS Y POJOS (DOMINIO)              ");
        System.out.println("==================================================");

        // 1. PRUEBA: Módulo Autenticación y Roles
        System.out.println("TEST CLASE: UsuarioHogar");
        UsuarioHogar testUsuario = new UsuarioHogar("kevin_galeas", "Kevin Galeas", "kgaleas@uce.edu.ec", "Secreta123");
        System.out.println("Estado inicial: \n" + testUsuario.toString());

        // Llamada a Setters
        System.out.println("Ejecutando Setters...");
        testUsuario.setNombre("Kevin Adrian Galeas");
        testUsuario.setContrasenia("NuevaClave456");

        // Llamada a Getters
        System.out.println("Resultados de Getters tras la modificación:");
        System.out.println("- Nuevo Nombre obtenido: " + testUsuario.getNombre());
        System.out.println("- Nueva Contraseña obtenida: " + testUsuario.getContrasenia());
        System.out.println("--------------------------------------------------");

        // 2. PRUEBA: Módulo Hogar y Alertas
        System.out.println("TEST CLASE: Recordatorio");
        Recordatorio testRecordatorio = new Recordatorio(1, "Separar plásticos", "Reciclaje", LocalDateTime.now(), "Semanal");
        System.out.println("Estado inicial: " + testRecordatorio.toString());

        testRecordatorio.setFrecuencia("Diaria"); // Setter
        System.out.println("Frecuencia actualizada (Getter): " + testRecordatorio.getFrecuencia());
        System.out.println("--------------------------------------------------");

        // 3. PRUEBA: Módulo Operativo Recolector
        System.out.println("TEST CLASE: RutaRecoleccion");
        RutaRecoleccion testRuta = new RutaRecoleccion(101, "Sector Norte", "Lat:-0.18, Lng:-78.48", "Lunes y Jueves", "08:00 AM");
        System.out.println("Estado inicial: " + testRuta.toString());

        testRuta.setHoraEstimada("10:30 AM"); // Setter
        System.out.println("Hora actualizada (Getter): " + testRuta.getHoraEstimada());
        System.out.println("--------------------------------------------------");

        // 4. PRUEBA: Módulo Reciclaje
        System.out.println("TEST CLASE: PuntoReciclaje");
        PuntoReciclaje testPunto = new PuntoReciclaje("Lat:-0.19, Lng:-78.49", "Contenedor Parque Bicentenario", "Activo - Medio Lleno");
        System.out.println("Estado inicial: " + testPunto.toString());

        testPunto.setEstadoContenedor("Activo - Lleno"); // Setter
        System.out.println("Estado de contenedor actualizado (Getter): " + testPunto.getEstadoContenedor());

        System.out.println("==================================================");
        System.out.println("       FIN DE PRUEBAS - INICIANDO SISTEMA         ");
        System.out.println("==================================================");
    }
}