package Rango;
public abstract class Rango {

    private int rango;

    public Rango(int rango) {
        this.rango = rango;
    }
    public int getRango() {
        return rango;
    }
    public abstract void realizarAccion();{
    }
}
