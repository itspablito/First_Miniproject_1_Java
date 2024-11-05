package Soldados;
import Rango.Rango;
import Interfaz.OperacionesMilitares;

public class Coronel extends Rango  implements OperacionesMilitares{
    private String EstrategiaMilitar;


    public Coronel(int nivel) {
        super(3);
        System.out.println("Coronel");
    }

    @Override
    public void realizarAccion() {
            System.out.println("Realiza una estrategia militar");
        }

    public void mostrarRango() {
        System.out.println("Rango: Coronel");
    }
    
    public void mostrarEstrategiaMilitar( String estrategiaMilitar){
        System.out.println("Estrategia Militar: " + EstrategiaMilitar );
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
