package SoldadoBase;
import java.util.ArrayList;
import java.util.List;

import Interfaz.OperacionesMilitares;

public class Soldado{

    public String nombresoldado;
    public final int ID;
    public int rango;
    private List<String> Tarea;

    public Soldado(String nombresoldado, int nuevoID, int rango) {
        this.nombresoldado = nombresoldado;
        this.ID = nuevoID;
        this.rango = rango;
        this.Tarea = new ArrayList<>();
    
    }
    public void asignarMision(String Mision) {
        Tarea.add(Mision); 
        System.out.println("Misión '" + Tarea + "' asignada al soldado " + nombresoldado + ".");
    }
    public void mostrarMisiones() {
        if (Tarea.isEmpty()) {
            System.out.println("El soldado " + nombresoldado + " no tiene misiones asignadas.");
        } else {
            System.out.println("Misiones asignadas a " + nombresoldado + ": " + String.join(", ", Tarea));
        }
    }

    public void mostrardatos() {
        System.out.println("Nombre del Soldado: " + nombresoldado);
        System.out.println("ID del Soldado: " + ID);
    }

    public String getNombresoldado() {
        return nombresoldado;
    }

    public void setNombresoldado(String nombresoldado) {
        this.nombresoldado = nombresoldado;
    }

    public int getID() {
        return ID;
    }

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }

}

