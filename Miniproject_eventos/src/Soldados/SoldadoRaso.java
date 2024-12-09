package Soldados;
import Interfaz.OperacionesMilitares;
import SoldadoBase.Soldado;

public class SoldadoRaso extends Soldado implements OperacionesMilitares { 
    
    public SoldadoRaso(String nombresoldado, int ID, int rango) {
        super(nombresoldado, ID, rango);
    }

    public void mostrarRango() {
        System.out.println("Rango: Soldado Raso");
    }

    @Override
    public void asignarMision(String mision) {
        System.out.println("Mision: " + mision);
    }

    @Override
    public void reportarEstado() {
        System.out.println("Reportando Estado");
    }

}