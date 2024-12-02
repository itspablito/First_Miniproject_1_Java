package Soldados;

import Soldado_Principal.Soldado;
import Operaciones_Militares.OperacionesMilitares;

public class Coronel extends Soldado implements OperacionesMilitares {

    private String estrategiaMilitar;

    
    public Coronel(String nombresoldado, int ID, int rango, String estrategiaMilitar) {
        super(nombresoldado, ID, rango);
        this.estrategiaMilitar = estrategiaMilitar;
        
    }


    public String getEstrategiaMilitar() {
        return estrategiaMilitar;
    }

    public void setEstrategiaMilitar(String estrategiaMilitar) {
        this.estrategiaMilitar = estrategiaMilitar;
    }


    @Override
    public void asignarMision(String mision) {
        System.out.println("El Coronel " + getNombresoldado() + " asignó la misión: " + mision);
    }

    @Override
    public void reportarEstado() {
        System.out.println("El Coronel - Nombre: " + getNombresoldado() + ", ID: " + getID() + ", Rango: " + getRango());
        System.out.println("El Coronel " + getNombresoldado() + " reporta que la operación está en curso.");
    }

    @Override
    public String toString() {
        return "|ID: " + ID + "| Nombre: " + nombresoldado.toUpperCase() + "| Rango: " + rango + " (Coronel)" + "| Estrategia Militar Coronel: " + estrategiaMilitar + "|";
    }

}


