import Gui.Console.Menu;
import test.TestAdministrador;
import test.TestEntregaDeReciclaje;
import test.TestLugarDeAcopio;
import test.TestRecolector;
import test.TestRecordatorio;
import test.TestReporteDePuntoCritico;
import test.TestUsuarioDelHogar;

public class main {
    public static void main(String[] args) {
        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
        System.out.println("               TEST DE MÉTODOS Y POJOS            ");
        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");

        TestUsuarioDelHogar pruebaUsuario = new TestUsuarioDelHogar();
        pruebaUsuario.probarUsuarioHogar();

        TestRecordatorio pruebaRecordatorio = new TestRecordatorio();
        pruebaRecordatorio.probarRecordatorio();

        TestLugarDeAcopio pruebaLugar = new TestLugarDeAcopio();
        pruebaLugar.probarLugarDeAcopio();

        TestRecolector pruebaRecolector = new TestRecolector();
        pruebaRecolector.probarRecolector();

        TestAdministrador pruebaAdministrador = new TestAdministrador();
        pruebaAdministrador.probarAdministrador();

        TestReporteDePuntoCritico pruebaReporte = new TestReporteDePuntoCritico();
        pruebaReporte.probarReporte();

        TestEntregaDeReciclaje pruebaEntrega = new TestEntregaDeReciclaje();
        pruebaEntrega.probarEntrega();

        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
        System.out.println("       FIN DE TEST - Ojala y corra :(             ");
        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");

        Menu menu = new Menu();
        menu.iniciar();
    }
}