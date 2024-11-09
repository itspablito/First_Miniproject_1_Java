package Soldados;
import Rango.Rango;
import Interfaz.OperacionesMilitares;
import Soldado_Principal.Soldado;  

public class Coronel extends Soldado implements OperacionesMilitares{
    private String EstrategiaMilitar;


    public Coronel(String nombredelsoldado, int ID, int rango, String EstrategiaMilitar) {
        super(nombredelsoldado, ID, rango);
        this.EstrategiaMilitar = EstrategiaMilitar;
        System.out.println("Coronel");
    }

    public void mostrarRango() {
        System.out.println("Rango: Coronel");
    }
    
    @Override
    public String toString() {
        return super.toString() + "Coronel" + "\nEstrategia Militar = " + EstrategiaMilitar;
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
