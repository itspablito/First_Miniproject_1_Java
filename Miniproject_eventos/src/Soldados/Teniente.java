package Soldados;
import Rango.Rango;

public class Teniente extends Rango {
    public Teniente(int nivel) {
        super(3);
        System.out.println("Teniente");
    }
    public void mostrarRango() {
        System.out.println("Rango: Teniente");
    }
    
}
