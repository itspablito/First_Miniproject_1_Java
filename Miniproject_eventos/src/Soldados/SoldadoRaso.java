package Soldados;
import Soldado_Principal.Soldado;

public class SoldadoRaso extends Soldado {
    public SoldadoRaso(String nombresoldado, String ID) {
        super(nombresoldado, ID);
        System.out.println("Soldado Raso");
    }
    public void mostrarRango() {
        System.out.println("Rango: Soldado Raso");
    }
    
}