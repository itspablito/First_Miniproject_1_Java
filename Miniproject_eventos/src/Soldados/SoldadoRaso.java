package Soldados;
import Soldado_Principal.Soldado;
import Operaciones_Militares.OperacionesMilitares;

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
        System.out.println("Soldado Raso - Nombre: " + getNombresoldado() + ", ID: " + getID() + ", Rango: " + getRango());
    }

    @Override
    public String toString() {
        return "|ID: " + ID + "| Nombre: " + nombresoldado.toUpperCase() + "| Rango: " + getRango() + "|";
    }
    /*/ @Override
    public void realizarAccion() {
        System.out.println( getNombresoldado() + " está siguiendo órdenes como Soldado Raso.");
    }*/
    

}
