package Soldados;
import Interfaz.OperacionesMilitares;
import Rango.Rango;

public class Capitan extends Rango implements OperacionesMilitares{
    
   //private int soldadosbajosumando;
    public Capitan(int rango) {
        super(rango);
        if (rango == 2) {
            System.out.println("Soy un Capitan");
        } else {
            System.out.println("No soy un Capitan");
        }
    }
    
    public void mostrarRango() {
        System.out.println("Rango: Capitan");
    
    }

    public void soldadosbajosumando(int SoldadosCoronel){
        System.out.println("Soldados bajos sumando");
        //this.SoldadosCoronel = soldadosbajosumando;
    }


    @Override
    public void realizarAccion() {
        System.out.println("Realizando Accion");
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

