public class Soldado {
    String nombresoldado;
    String ID;
    int rango;

    public Soldado(String nombresoldado, String ID, int rango) {
        this.nombresoldado = nombresoldado;
        this.ID = ID;

    }
    public String Seleccionar(int rango) {
        if (rango == 1) {
            return "SoldadoRaso";
        } else if (rango == 2) {
            return "Teniente";
        } else if (rango == 3) {
            return "Capitan";
        } else {
            return "coronel";
        }
    }

}
