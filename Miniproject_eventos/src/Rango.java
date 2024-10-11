public class Rango { 
    private int rango;


    public void AsignarRango(int rango) {
        if (rango == 1) {
            System.out.println("EL Rango del Soldado es: SoldadoRaso");
        } else if (rango == 2) {
            System.out.println("EL Rango del Soldado es: Capitan");
        } else if (rango == 3) {
            System.out.println("EL Rango del Soldado es: Coronel");
        } else if (rango == 4) {
            System.out.println("EL Rango del Soldado es: Teniente");
        }


    }
     
    public void setRango(int nuevoRango) {
        rango = nuevoRango;
    }

    public int getRango() {
        return rango;
    }





}

