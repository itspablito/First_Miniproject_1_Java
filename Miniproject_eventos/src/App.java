public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("hi, World!");
        Soldado soldado1 = new Soldado("Juan", "123", 1);
        Rango rango1 = new Rango(4);
        System.out.println(rango1.rango);
        System.out.println(soldado1.nombresoldado);
        System.out.println(soldado1.ID);

        
    }
}
