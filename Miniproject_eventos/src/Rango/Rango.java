package Rango;
public class Rango { 
    private int rango;


    public void AsignarRango(int rango) {
        if (rango == 1) {
            System.out.println("EL Rango del Soldado es: SoldadoRaso");
            this.rango = rango;
        } else if (rango == 2) {
            System.out.println("EL Rango del Soldado es: Capitan");
            this.rango = rango;
        } else if (rango == 3) {
            System.out.println("EL Rango del Soldado es: Coronel");
            this.rango = rango;
        } else if (rango == 4) {
            System.out.println("EL Rango del Soldado es: Teniente");
            this.rango = rango;
        }


    }
     
    public void setRango(int nuevoRango) {
        rango = nuevoRango;
    }

    public int getRango() {
        return rango;
    }





}

