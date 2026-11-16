package Dominio;

import java.util.Arrays;

public class Recolector extends Usuario {

    private EntregaDeReciclaje[] entregasValidadas;

    public Recolector() {
        super();
    }

    public Recolector(EntregaDeReciclaje[] entregasValidadas) {
        super();
        this.entregasValidadas = entregasValidadas;
    }

    public EntregaDeReciclaje[] getEntregasValidadas() {
        return entregasValidadas;
    }

    public void setEntregasValidadas(EntregaDeReciclaje[] entregasValidadas) {
        this.entregasValidadas = entregasValidadas;
    }

    @Override
    public String toString() {
        return "Recolector{" +
                "entregasValidadas=" + Arrays.toString(entregasValidadas) +
                "} " + super.toString();
    }
}