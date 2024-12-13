package Soldados;

import Operaciones_Militares.OperacionesMilitares;
import Soldado_Principal.Soldado;

import javax.swing.JOptionPane;

public class Capitan extends Soldado implements OperacionesMilitares {

    private int cantidadSoldadosBajoSuMando;
    private String misionAsignada = "Sin Asignar"; // Atributo específico para misiones

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

    
    @Override
    public void asignarMision(String mision) {
        this.misionAsignada = mision;
        JOptionPane.showMessageDialog(null,
            "El Capitán " + getNombresoldado() + " asignó la misión: " + mision,
            "Asignar Misión",
            JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void reportarEstado() {
        String estado = "Estado del Capitán:\n" +
                        "Nombre: " + getNombresoldado() + "\n" +
                        "ID: " + getID() + "\n" +
                        "Rango: " + getRango() + "\n" +
                        "Soldados Bajo su Mando: " + cantidadSoldadosBajoSuMando + "\n" +
                        "Misión: " + misionAsignada;

        JOptionPane.showMessageDialog(null,
            estado,
            "Estado del Capitán",
            JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public String getMisionActual() {
        return misionAsignada; // Devuelve la misión actual
    }

    @Override
    public String toString() {
        return "|ID: " + ID + "| Nombre: " + nombresoldado.toUpperCase() + 
               "| Rango: " + rango + " (Capitán)" + 
               "| Soldados Bajo su Mando: " + cantidadSoldadosBajoSuMando + "|";
    }

}
