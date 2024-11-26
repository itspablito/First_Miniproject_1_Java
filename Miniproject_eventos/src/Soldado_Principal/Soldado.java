package Soldado_Principal;
import Interfaz.OperacionesMilitares;


public class Soldado{

    public String nombresoldado;
    public final int ID;
    public int rango;

    public Soldado(String nombresoldado, int nuevoID, int rango) {
        this.nombresoldado = nombresoldado;
        this.ID = nuevoID;
        this.rango = rango;
    }

    @Override
    public String toString() {
        return "Nombre = " + nombresoldado + " \nID = " + ID + " \nRango = ";
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
