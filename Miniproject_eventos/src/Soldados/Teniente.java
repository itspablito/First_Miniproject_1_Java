package Soldados;
import Soldado_Principal.Soldado;
import Operaciones_Militares.OperacionesMilitares;

public class Teniente extends Soldado implements OperacionesMilitares { 
    private String unidad;

  
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
        System.out.println("El Teniente " + getNombresoldado() + " está regañando a un soldado en la unidad " + unidad + ".");
    }

    @Override
    public void mostrardatos() {
        super.mostrardatos(); 
        System.out.println("Unidad del Teniente: " + unidad);
        System.out.println("Teniete - Nombre: " + getNombresoldado() + ", ID: " + getID() + ", Rango: " + getRango());
    } 

    @Override
    public void asignarMision(String mision) {
        System.out.println("El Teniente asignó la misión: " + mision);
    }

    @Override
    public void reportarEstado() {
    
    System.out.println("El Teniente reporta que todo está bajo control.");
    }

    @Override
    public String toString() {
        return "|ID: " + ID + "| Nombre: " + nombresoldado.toUpperCase() + "| Rango: " + rango + " (Teniente)" +"| Unidad Teniente: " + unidad + "|";
    }
}
