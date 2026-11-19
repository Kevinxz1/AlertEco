package test;

import Dominio.Administrador;
import Dominio.GuiaDeReciclaje;
import Dominio.LugarDeAcopio;
import Dominio.ReporteDePuntoCritico;

import java.time.LocalDateTime;

public class TestAdministrador {

    public void probarAdministrador() {
        //Instancia original + Constructores sobrecargados sin parámetros
        Administrador admin = new Administrador(
                999,
                "Admin",
                "admin@mail.com",
                "0999999999",
                "Centro",
                "adminpass",
                "Activo"
        );
        Administrador adminDefecto = new Administrador();
        Administrador adminCopia = new Administrador(admin);

        System.out.println("tEST Admin");
        System.out.println("ID: " + admin.getIdUsuario());
        System.out.println("Nombre: " + admin.getNombresYApellidos());
        System.out.println("Correo: " + admin.getCorreoElectronico());
        System.out.println("Estado: " + admin.getEstadoDeLaCuenta());

        //Herencia y sobreescritura de toString()
        System.out.println("HERENCIA Y toString() SOBREESCRITO]");
        System.out.println(admin);
        System.out.println("\nAdmin por defecto:\n" + adminDefecto);

        //equals(), hashCode() y sobrecarga con parámetro referencia
        System.out.println("[EQUALS, HASHCODE Y SOBRECARGA POR REFERENCIA");
        System.out.println("¿admin.equals(adminCopia)? (esperado true): " + admin.equals(adminCopia));
        System.out.println("¿admin.equals(adminDefecto)? (esperado false): " + admin.equals(adminDefecto));
        System.out.println("hashCode admin: " + admin.hashCode() + " | hashCode adminCopia: " + adminCopia.hashCode());
        System.out.println("Validar credenciales por referencia (esperado true): " + admin.validarCredenciales(adminCopia));

        //CRUD  ñlugares de Acopio (Relación 1 a muchos - Arreglo de objetos)
        System.out.println("\n--- [CRUD CREAR + VALIDACIÓN DE DUPLICADOS: LUGARES DE ACOPIO] ---");
        LugarDeAcopio lugar1 = new LugarDeAcopio("-0.180653, -78.467834", "Punto Eco Norte", "Disponible");
        LugarDeAcopio lugar2 = new LugarDeAcopio("-0.220164, -78.512327", "Punto Eco Centro", "Lleno");
        LugarDeAcopio lugarDuplicado = new LugarDeAcopio("-0.180653, -78.467834", "Punto Eco Norte", "Disponible");

        System.out.println("Crear lugar1 (true): " + admin.crearLugarDeAcopio(lugar1));
        System.out.println("Crear lugar2 (true): " + admin.crearLugarDeAcopio(lugar2));
        System.out.println("Crear lugarDuplicado (false): " + admin.crearLugarDeAcopio(lugarDuplicado));

        System.out.println("CRUD CONSULTAR / LISTAR");
        System.out.println(admin.consultarLugaresDeAcopio());

        System.out.println("CRUD BUSCAR (POR REFERENCIA Y POR ÍNDICE");
        System.out.println("Buscar por referencia (lugarDuplicado):\n" + admin.buscarLugarDeAcopio(lugarDuplicado));
        System.out.println("Buscar por índice (1):\n" + admin.buscarLugarDeAcopio(1));

        System.out.println("CRUD EDITAR (CON VALIDACIÓN DE DUPLICADOS");
        LugarDeAcopio lugarEditado = new LugarDeAcopio("-0.250000, -78.530000", "Punto Eco Sur", "Disponible");
        System.out.println("Editar lugar2 con duplicado lugar1 (false): " + admin.editarLugarDeAcopio(lugar2, lugar1));
        System.out.println("Editar lugar2 por referencia a lugarEditado (true): " + admin.editarLugarDeAcopio(lugar2, lugarEditado));
        System.out.println(admin.consultarLugaresDeAcopio());

        System.out.println("[CRUD ELIMINAR (POR REFERENCIA-");
        System.out.println("Eliminar lugar1 (true): " + admin.eliminarLugarDeAcopio(lugar1));
        System.out.println(admin.consultarLugaresDeAcopio());

        //CRUD rápido en Guías y Reportes
        System.out.println("CRUD GUÍAS Y REPORTES");
        GuiaDeReciclaje guia1 = new GuiaDeReciclaje(101, "Plástico", "Enjuagar y aplastar botellas PET.");
        System.out.println("Crear guia1 (true): " + admin.crearGuiaPublicada(guia1));
        System.out.println("Crear guia1 duplicada (false): " + admin.crearGuiaPublicada(new GuiaDeReciclaje(guia1)));
        System.out.println(admin.consultarGuiasPublicadas());

        ReporteDePuntoCritico reporte1 = new ReporteDePuntoCritico(
                "Acumulación de residuos en esquina", "Resuelto", LocalDateTime.now(), lugarEditado);
        System.out.println("\nCrear reporte1 con relación 1 a 1 a LugarDeAcopio (true): " + admin.crearReporteResuelto(reporte1));
        System.out.println(admin.consultarReportesResueltos());
        System.out.println("----------------------------------------------------");
    }
}