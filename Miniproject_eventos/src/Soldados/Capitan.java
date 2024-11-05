package Soldados;
import Rango.Rango;

public class Capitan extends Rango {
    public Capitan(int nivel) {
        super(1);
        System.out.println("Capitan");
    }
    public void mostrarRango() {
        System.out.println("Rango: Capitan");
    }
    
}
