package test;

import Dominio.EntregaDeReciclaje;
import Dominio.Recordatorio;
import Dominio.ReporteDePuntoCritico;
import Dominio.UsuarioDelHogar;
import java.time.LocalDateTime;
import java.util.Date;

public class TestUsuarioDelHogar {
    public void probarUsuarioHogar() {
        UsuarioDelHogar usuario = new UsuarioDelHogar(
                1,
                "Kevin Galeas",
                "kevin@mail.com",
                "0991234567",
                "Quito Norte",
                "pass1234",
                "Activo"
        );

        // Asignación de arreglos asociados al usuario del hogar
        EntregaDeReciclaje[] entregas = {
                new EntregaDeReciclaje(1, "Plástico", 3.5, new Date(), "Botellas PET")
        };
        ReporteDePuntoCritico[] reportes = {
                new ReporteDePuntoCritico("Contenedor lleno en parque", "Pendiente", LocalDateTime.now())
        };
        Recordatorio[] recordatorios = {
                new Recordatorio(1, "Sacar cartón", "Papel", LocalDateTime.of(2026, 11, 21, 7, 0), "Semanal")
        };

        usuario.setEntregasRegistradas(entregas);
        usuario.setReportesCreados(reportes);
        usuario.setRecordatorios(recordatorios);

        System.out.println("TEST USUARIO DEL HOGAR");
        System.out.println("ID: " + usuario.getIdUsuario());
        System.out.println("Nombre: " + usuario.getNombresYApellidos());
        System.out.println("Correo: " + usuario.getCorreoElectronico());
        System.out.println("Teléfono: " + usuario.getTelefonoDeContacto());
        System.out.println("Sector/Dirección: " + usuario.getSectorDireccion());
        System.out.println("Estado de cuenta: " + usuario.getEstadoDeLaCuenta());
        System.out.println("Credenciales válidas: " + usuario.validarCredenciales("kevin@mail.com", "pass1234"));

        usuario.setSectorDireccion("Quito Centro Norte");
        System.out.println("Nueva dirección: " + usuario.getSectorDireccion());

        usuario.eliminarCuenta();
        System.out.println("Estado tras eliminarCuenta(): " + usuario.getEstadoDeLaCuenta());

        System.out.println("\nDetalle completo:\n" + usuario.toString());
        System.out.println("------------------------------");
    }
}