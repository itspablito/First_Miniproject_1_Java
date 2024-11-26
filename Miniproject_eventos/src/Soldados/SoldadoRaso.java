package Soldados;
import Soldado_Principal.Soldado;
import Interfaz.OperacionesMilitares;

public class SoldadoRaso extends Soldado implements OperacionesMilitares { 
    
    public SoldadoRaso(String nombresoldado, int ID, int rango) {
        super(nombresoldado, ID, rango);
    }

    @Override
    public String toString() {
        return super.toString() + "Soldado Raso";
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