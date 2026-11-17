package test;

import Dominio.Administrador;

public class TestAdministrador {
    public void probarAdministrador() {
        Administrador admin = new Administrador("Admin", "admin@mail.com", "adminpass", "ADM-999");
        System.out.println("TEST ADMINISTRADOR");
        System.out.println(admin.getNombre());
        System.out.println(admin.getCorreo());
        System.out.println(admin.getIdAdmin());
        System.out.println("--------------------------");
    }
}