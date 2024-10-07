public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("hi, World!");
        Soldado soldado1 = new Soldado("Juan", "123", 2);
        System.out.println(soldado1.nombresoldado);
        System.out.println(soldado1.ID);
        System.out.println(soldado1.rango);
        
    }
}
