package Soldados;
import Soldado_Principal.Soldado;

public class SoldadoRaso extends Soldado{

    public SoldadoRaso(String nombresoldado,String ID) {
        super (nombresoldado, ID);


    }
}


public class SoldadoRaso { 
    String nombre;
    int ID;
    
    public SoldadoRaso(String nuevoNombre, int nuevoID) {
        nombre = nuevoNombre;
        ID = nuevoID;
    }
    
    public SoldadoRaso() {
        
    }
    //@Override void RealizarAccion() {
        //System.out.println("Soy un soldado raso y seguire todas las ordenes que me pidan");   
        
        //lo dejaremos esto prodicinomante para cambiarlo despues con el usuario ya que esto son los metodos a usar
    
    



    public void presentarse() {
        System.out.println("Soy el soldado:" + nombre + " y mi ID es:" + ID);
    }

    public void ordenes() {
        System.out.println("Soy un soldado raso y seguire todas las ordenes que me pidan");



    }
}