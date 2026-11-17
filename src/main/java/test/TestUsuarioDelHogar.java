package test;

import Dominio.UsuarioDelHogar;

public class TestUsuarioDelHogar {
    public void probarUsuarioHogar() {
        UsuarioDelHogar usuario = new UsuarioDelHogar("Kevin Galeas", "kevin@mail.com", "pass123", "Quito Norte", 0);
        System.out.println("--- TEST USUARIO DEL HOGAR ---");
        System.out.println(usuario.getNombre());
        System.out.println(usuario.getCorreo());
        System.out.println(usuario.getDireccion());
        usuario.setPuntos(100);
        System.out.println(usuario.getPuntos());
        System.out.println("------------------------------");
    }
}