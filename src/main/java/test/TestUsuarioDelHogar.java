package test;

import Dominio.UsuarioDelHogar;

public class TestUsuarioHogar {

    public void probarUsuarioHogar() {
        System.out.println("TEST CLASE: UsuarioDelHogar");

        UsuarioDelHogar testUsuario = new UsuarioDelHogar(1, "Kevin Galeas", "kgaleas@uce.edu.ec",
                "0991234567", "Tumbaco", "Secreta123", "Activo");

        System.out.println("Estado inicial: " + testUsuario.toString());

        System.out.println("Ejecutando Set...");
        testUsuario.setNombresYApellidos("Kevin Adrian Galeas");
        testUsuario.setContrasena("clavisitaa22");

        System.out.println("Resultados de Getters tras la modificacion:");
        System.out.println("- Nuevo Nombre obtenido: " + testUsuario.getNombresYApellidos());
        System.out.println("- Nueva Contrasena obtenida: " + testUsuario.getContrasena());
        System.out.println("--------------------------------------------------");
    }
}