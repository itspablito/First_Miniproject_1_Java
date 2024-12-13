package Soldados;
import Soldado_Principal.Soldado;

import javax.swing.JOptionPane;

import Operaciones_Militares.OperacionesMilitares;

public class SoldadoRaso extends Soldado implements OperacionesMilitares { 
    private String misionAsignada = "Sin Asignar";
    
    public SoldadoRaso(String nombresoldado, int ID, int rango) {
        super(nombresoldado, ID, rango);
    }

    public void mostrarRango() {
        System.out.println("Rango: Soldado Raso");
    }

    
   @Override
    public void asignarMision(String mision) {
        this.misionAsignada = mision;
        JOptionPane.showMessageDialog(null, 
            "Misión asignada al Soldado Raso: " + mision,
            "Asignar Misión", 
            JOptionPane.INFORMATION_MESSAGE);
    }
 

    @Override
    public void reportarEstado() {
        String estado = "Estado del Soldado Raso:\n" +
                        "Nombre: " + this.getNombresoldado() + "\n" +
                        "ID: " + this.getID() + "\n" +
                        "Rango: " + this.getRango() + "\n" +
                        "Misión: " + misionAsignada;

        JOptionPane.showMessageDialog(null, 
            estado, 
            "Estado del Soldado Raso", 
            JOptionPane.INFORMATION_MESSAGE);
    }

@Override
public String getMisionActual() {
    return misionAsignada; // Devuelve la misión actual
}

    @Override
    public String toString() {
        return "|ID: " + ID + "| Nombre: " + nombresoldado.toUpperCase() + "| Rango: " + rango + "(Soldado Raso)" + "|";
    }
    /*/ @Override
    public void realizarAccion() {
        System.out.println( getNombresoldado() + " está siguiendo órdenes como Soldado Raso.");
    }*/
    

}
