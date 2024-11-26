package Soldados;
import Interfaz.OperacionesMilitares;
import Rango.Rango;
import java.util.ArrayList;
import Soldado_Principal.Soldado;

public class Capitan extends Soldado implements OperacionesMilitares {

    private int soldadosbajosumando;


    public Capitan(String nombredelsoldado, int ID, int rango, int soldadosbajosumando) {
        super(nombredelsoldado, ID, rango);
        this.soldadosbajosumando = soldadosbajosumando;

        }
    
    
    public void mostrarRango() {
        System.out.println("Rango: Capitan");
    
        
    }

    @Override
    public String toString() {
        return super.toString() + "Capitan" + "\nSoldados bajo su mando=" + soldadosbajosumando ;
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

