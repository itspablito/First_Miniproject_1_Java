package Soldados;
import Interfaz.OperacionesMilitares;
import Soldado_Principal.Soldado;

public class Teniente extends Soldado implements OperacionesMilitares { 
    private int unidad;

    public Teniente(String nombredelsoldado, int ID, int rango, int unidad) {
        super(nombredelsoldado, ID, rango);
        this.unidad = unidad; 
        System.out.println("Teniente");
    
    }

    public void mostrarRango() {
        System.out.println("Rango: Teniente");
    }

    public void mostrarUnidad() {
        System.out.println("Unidad: " + unidad);
    }

    @Override
    public String toString() {
        return super.toString() + "Teniente" + "\nUnidad=" + unidad;
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
