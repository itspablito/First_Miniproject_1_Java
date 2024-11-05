package Soldado_Principal;


public class Soldado {

    public String nombresoldado;
    public String ID;

    public Soldado(String nombresoldado,String ID) {
        this.nombresoldado = nombresoldado;
        this.ID = ID;
    
    }

    public void mostrardatos() {
        System.out.println("Nombre del Soldado: " + nombresoldado);
        System.out.println("ID del Soldado: " + ID);
    }

}
