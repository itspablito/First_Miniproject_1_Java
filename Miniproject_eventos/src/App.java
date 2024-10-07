import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("hi, World!");

        Scanner Scanner = new Scanner(System.in);
        String nombre = Scanner.nextLine();

        String ID = Scanner.nextLine();

        System.out.print("Ingrese el rango: ");
        int rango = Scanner.nextInt();


        Soldado soldado1 = new Soldado(nombre, ID);      
        Rango rango1 = new Rango(rango);

        soldado1.mostrardatos();

        
        System.out.println(rango1.rango);         
        
    }
}
