package Soldados;

import Operaciones_Militares.OperacionesMilitares;
import Soldado_Principal.Soldado;



public class Capitan extends Soldado implements OperacionesMilitares {

    private int cantidadSoldadosBajoSuMando;

    public Capitan(String nombresoldado, int ID, int rango, int cantidadSoldadosBajoSuMando) {
        super(nombresoldado, ID, rango);
        this.cantidadSoldadosBajoSuMando = cantidadSoldadosBajoSuMando;

       
    }

    public int getCantidadSoldadosBajoSuMando() {
        return cantidadSoldadosBajoSuMando;
    }

    public void setCantidadSoldadosBajoSuMando(int cantidadSoldadosBajoSuMando) {
        this.cantidadSoldadosBajoSuMando = cantidadSoldadosBajoSuMando;
    }
    
    // Método para mostrar rango
    public void mostrarRango() {
        System.out.println("Rango: Capitán");
    }

    @Override
    public void asignarMision(String mision) {
        System.out.println("El Capitán " + getNombresoldado() + " asignó la misión: " + mision);
    }

    @Override
    public void reportarEstado() {
        System.out.println("El Capitan- Nombre: " + getNombresoldado() + ", ID: " + getID() + ", Rango: " + getRango());
        System.out.println("El Capitán reporta: Todo en orden.");
    }

    @Override
    public String toString() {
        return "|ID: " + ID + "| Nombre: " + nombresoldado.toUpperCase() + "| Rango: " + getRango() +"| Soldados Bajo su Mando: " + cantidadSoldadosBajoSuMando + "|";
    }

}
