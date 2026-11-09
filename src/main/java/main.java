import Gui.Console.Menu;
import test.TestPuntoReciclaje;
import test.TestRecordatorio;
import test.TestRutaRecoleccion;
import test.TestUsuarioHogar;

public class main {
    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println("   TEST DE MÉTODOS Y POJOS (DOMINIO)              ");
        System.out.println("==================================================");

        TestUsuarioHogar pruebaUsuario = new TestUsuarioHogar();
        pruebaUsuario.probarUsuarioHogar();

        TestRecordatorio pruebaRecordatorio = new TestRecordatorio();
        pruebaRecordatorio.probarRecordatorio();

        TestRutaRecoleccion pruebaRuta = new TestRutaRecoleccion();
        pruebaRuta.probarRutaRecoleccion();

        TestPuntoReciclaje pruebaPunto = new TestPuntoReciclaje();
        pruebaPunto.probarPuntoReciclaje();

        System.out.println("==================================================");
        System.out.println("       FIN DE TEST - INICIANDO SISTEMA         ");
        System.out.println("==================================================");
    //AQUI INICIA EL MENU
        Menu menu = new Menu();
        menu.iniciar();
    }
}