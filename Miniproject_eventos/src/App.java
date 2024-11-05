import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("hi, World!");

        Scanner Scanner = new Scanner(System.in);

        ////////////////////Soldado////////////////////////
  
        String nombre = Scanner.nextLine();

        String ID = Scanner.nextLine();

        System.out.print("Ingrese el rango: ");
        int rango = Scanner.nextInt();


        Soldado soldado1 = new Soldado(nombre, ID);  
        
        ////////////////////Rango////////////////////////
        Rango rango1 = new Rango();

        soldado1.mostrardatos();

        rango1.AsignarRango(rango);
        //System.out.println(rango1.rango);
        
        Scanner.close();
>>>>>>> 3f78a86b33955c5ff2aa11a6477cf855bd221b71
        
    }

}

