package Soldados;

import Soldado_Principal.Soldado;
import Operaciones_Militares.OperacionesMilitares;

import javax.swing.JOptionPane;

public class Teniente extends Soldado implements OperacionesMilitares { 
    private String unidad;
    private String misionAsignada = "Sin Asignar"; // Atributo para misiones

    public Teniente(String nombresoldado, int ID, int rango, String unidad) {
        super(nombresoldado, ID, rango); 
        this.unidad = unidad;
        
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }


    public void realizarRegaño() {
        JOptionPane.showMessageDialog(null,
            "El Teniente " + getNombresoldado() + " está regañando a un soldado en la unidad " + unidad + ".",
            "Regaño del Teniente",
            JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mostrardatos() {
        String datos = "Nombre: " + getNombresoldado() + "\n" +
                       "ID: " + getID() + "\n" +
                       "Rango: " + getRango() + " (Teniente)\n" +
                       "Unidad: " + unidad;
        JOptionPane.showMessageDialog(null, datos, "Datos del Teniente", JOptionPane.INFORMATION_MESSAGE);
    } 

    @Override
    public void asignarMision(String mision) {
        this.misionAsignada = mision;
        JOptionPane.showMessageDialog(null,
            "El Teniente asignó la misión: " + mision,
            "Asignar Misión",
            JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void reportarEstado() {
        String estado = "Estado del Teniente:\n" +
                        "Nombre: " + getNombresoldado() + "\n" +
                        "ID: " + getID() + "\n" +
                        "Rango: " + getRango() + " (Teniente)\n" +
                        "Unidad: " + unidad + "\n" +
                        "Misión: " + misionAsignada + "\n" +
                        "El Teniente reporta que todo está bajo control.";
        JOptionPane.showMessageDialog(null, estado, "Estado del Teniente", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public String getMisionActual() {
        return misionAsignada; // Devuelve la misión actual
    }

    @Override
    public String toString() {
        return "|ID: " + ID + "| Nombre: " + nombresoldado.toUpperCase() + 
               "| Rango: " + rango + " (Teniente)" + 
               "| Unidad: " + unidad + "|";
    }
}
