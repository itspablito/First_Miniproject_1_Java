package Soldados;
import Interfaz.OperacionesMilitares;
import Rango.Rango;

public class Capitan extends Rango implements OperacionesMilitares{
   private int soldadosbajosumando;


    public Capitan(int nivel) {
        super(nivel);
    }
    public void mostrarRango() {
        System.out.println("Rango: Capitan");
    
    }

    public void soldadosbajosumando() {
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

