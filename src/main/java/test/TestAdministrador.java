package test;

import Dominio.Administrador;

public class TestAdministrador {
    public void probarAdministrador() {
        Administrador admin = new Administrador(
                999,
                "Admin",
                "admin@mail.com",
                "0999999999",
                "Centro",
                "adminpass",
                "Activo"
        );

        System.out.println("TEST ADMINISTRADOR");
        System.out.println("ID: " + admin.getIdUsuario());
        System.out.println("Nombre: " + admin.getNombresYApellidos());
        System.out.println("Correo: " + admin.getCorreoElectronico());
        System.out.println("Estado: " + admin.getEstadoDeLaCuenta());
        System.out.println("--------------------------");
    }
}