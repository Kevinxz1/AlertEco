import Gui.Console.Menu;
import test.TestRecordatorio;
import test.TestUsuarioDelHogar;

public class main {
    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println("   TEST DE MÉTODOS Y POJOS ( package DOMINIO)              ");
        System.out.println("==================================================");

        TestUsuarioDelHogar pruebaUsuario = new TestUsuarioDelHogar();
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

        Menu menu = new Menu();
        menu.iniciar();
    }
}