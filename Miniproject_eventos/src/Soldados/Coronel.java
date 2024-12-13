package Soldados;

import Soldado_Principal.Soldado;
import Operaciones_Militares.OperacionesMilitares;

import javax.swing.JOptionPane;

public class Coronel extends Soldado implements OperacionesMilitares {

    private String estrategiaMilitar;
    private String misionAsignada = "Sin Asignar"; // Atributo específico para misiones

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
        this.misionAsignada = mision;
        JOptionPane.showMessageDialog(null,
            "El Coronel " + getNombresoldado() + " asignó la misión: " + mision,
            "Asignar Misión",
            JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void reportarEstado() {
        String estado = "Estado del Coronel:\n" +
                        "Nombre: " + getNombresoldado() + "\n" +
                        "ID: " + getID() + "\n" +
                        "Rango: " + getRango() + "\n" +
                        "Estrategia Militar: " + estrategiaMilitar + "\n" +
                        "Misión: " + misionAsignada;

        JOptionPane.showMessageDialog(null,
            estado,
            "Estado del Coronel",
            JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public String getMisionActual() {
        return misionAsignada; // Devuelve la misión actual
    }

    @Override
    public String toString() {
        return "|ID: " + ID + "| Nombre: " + nombresoldado.toUpperCase() + 
               "| Rango: " + rango + " (Coronel)" + 
               "| Estrategia Militar: " + estrategiaMilitar + "|";
    }

}


