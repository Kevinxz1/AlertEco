package test;

import Dominio.UsuarioHogar;

public class TestUsuarioHogar {
    public void probarUsuarioHogar() {
        System.out.println("TEST CLASE: UsuarioHogar");
        UsuarioHogar testUsuario = new UsuarioHogar("kevin_galeas", "Kevin Galeas", "kgaleas@uce.edu.ec", "Secreta123");
        System.out.println("Estado inicial: " + testUsuario.toString());

        System.out.println("Ejecutando Set...");
        testUsuario.setNombre("Kevin Adrian Galeas");
        testUsuario.setContrasenia("clavisitaa22");

        System.out.println("Resultados de Getters tras la modificación:");
        System.out.println("- Nuevo Nombre obtenido: " + testUsuario.getNombre());
        System.out.println("- Nueva Contraseña obtenida: " + testUsuario.getContrasenia());
        System.out.println("--------------------------------------------------");
    }
}