import java.util.Scanner;
import java.util.ArrayList;
import Soldado_Principal.Soldado;
import Soldados.*;

public class App {
        private static ArrayList<Soldado> soldados = new ArrayList<>(); //Arraylist donde se almaceran los distintos soldados creados.
        public static void main(String[] args) throws Exception {
            Scanner scanner = new Scanner(System.in);
            while (true) { //Menu principal donde se elige la opcion a realizar.
                System.out.println("1. Crear Soldado");
                System.out.println("2. Leer Soldado");
                System.out.println("3. Actualizar Soldado");
                System.out.println("4. Eliminar Soldado");
                System.out.println("5. Gestionar Misiones");
                System.out.println("6. Salir");
                System.out.print("Elija una opción: ");
                int option = scanner.nextInt();

                switch (option) { //Switch para elegir la opcion a realizar y redirigir a la funcion correspondiente.
                    case 1:
                        crearSoldado(scanner); 
                        break;
                    case 2:
                        leerSoldado(scanner);
                        break;
                    case 3:
                        actSoldado(scanner);
                        break;
                    case 4:
                        borrarSoldado(scanner);
                        break;
                    case 5:
                        misiones(scanner);
                    case 6:
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opcion invalida");
                }
            }
        }

///////////////////////////////////CREACION DE SOLDADOS //////////////////////////////////////////

        private static void crearSoldado(Scanner scanner) {
            System.out.print("Introduzca Nombre : ");
            String nombre = scanner.next();     //Introducir nombre del soldado para guardarlo en el arraylist.
            System.out.print("Rangos:\n(1)SoldadoRaso \n(2)Teniente \n(3)Capitan \n(4)Coronel \nIntroduzca Rango: ");
            int rango = scanner.nextInt();
            scanner.nextLine();    //Se elige un rango para efectuar dentro de esta misma clase mandar a cual constriuctor se va a dirigir.
            System.out.println("Introduzca ID : ");
            int ID = scanner.nextInt();
            scanner.nextLine();

            switch (rango) {
                case 1:
                    SoldadoRaso soldado = new SoldadoRaso(nombre, ID, rango);//Creacion de un soldado raso. 
                    soldados.add(soldado); //Se añade el soldado creado previamente al arraylist.
                    break;
                case 2:
                    System.out.print("Introduzca la unidad: ");//Si la creacion es un Teniente se agrega unidad al cradad por medio del constructor.
                    int unidad = scanner.nextInt();
                    Teniente teniente = new Teniente(nombre, ID, rango,unidad);
                    soldados.add(teniente); //Se añade el teniente al arraylist.
                    break;               
                case 3:
                    System.out.print("Introduzca el numero de soldados bajo su mando: ");//Si la creacion es un Capital se agrega valor a soldadobajosumando por medio del constructor.
                    int soldadosbajosumando = scanner.nextInt();
                    Capitan capitan = new Capitan(nombre, ID, rango, soldadosbajosumando);
                    soldados.add(capitan); //Se añade el capitan al arraylist.
                    break;
                case 4:
                    System.out.print("Introduzca la estrategia militar: ");
                    String EstrategiaMilitar = scanner.nextLine();
                    Coronel coronel = new Coronel(nombre, ID, rango, EstrategiaMilitar);
                    soldados.add(coronel);  //Se añade el coronel al arraylist.
                    break;
                default:
                    break;
     
            }

            System.out.println("Soldado creado");
        }

///////////////////////////////////LECTURA DE SOLDADOS //////////////////////////////////////////
        
        private static void leerSoldado(Scanner scanner) {
            if (soldados.size() == 0)   {//Si el Arraylist de soldados esta vacio entonces imprimir "No hay soldados".
                System.out.println("°-°-°-°-°-°-°-°-°-°-°-°-°-°-°-°-°");
                System.out.println("|        No hay soldados        |");
                System.out.println("°-°-°-°-°-°-°-°-°-°-°-°-°-°-°-°-°");
                return;
            }else { 
                System.out.println("/////////////////////Lista de Soldados//////////////////");
                for (int i = 0; i < soldados.size(); i++) {
                    System.out.println(soldados.get(i));
                    System.out.println("-°-°-°-°-°-°-°-°-°-°-°-°-°-°-°-°-°-°-°-");
                    } 
            }  
        }
///////////////////////////////////ACTUALIZACION DE SOLDADOS //////////////////////////////////////////


    private static void actSoldado(Scanner scanner) {
        System.out.print("Introduzca ID del soldado : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Soldado soldado = null;
        for (Soldado s : soldados) {
            if (s.getID() == id) {
                soldado = s;
                break;
            }
        }
        if (soldado != null) {
            System.out.print("Introducir nuevo nombre: ");
            String nuevoNombre = scanner.next();
            System.out.print("Introducir nuevo rango: ");
            int nuevoRango = scanner.nextInt();
            soldado.setNombresoldado(nuevoNombre);
            soldado.setRango(nuevoRango);
            System.out.println("Soldado actualizado.");
        } else {
            System.out.println("ID invalido");
        }
    }

///////////////////////////////////BORRAR SOLDADOS //////////////////////////////////////////

private static void borrarSoldado(Scanner scanner) {

    System.out.print("Introduzca el ID del soldado: ");
    int id = scanner.nextInt();
    boolean encontrado = false;
    for (int i = 0; i < soldados.size(); i++) {

        if (soldados.get(i).getID() == id) {  
            soldados.remove(i);
            System.out.println("Soldado borrado.");
            encontrado = true;
            break;
        }
        else if (encontrado == false) {
            System.out.println("ID invalido");
        }
    }
            }
/////////////////////////////////////OPERACIONES MILITARES////////////////////////////////////////    

    private static void misiones(Scanner scanner) {
        System.out.println("Gestion de Misiones");
        System.out.println("1. Asignar Mision");
        System.out.println("2. Reportar Estado");
        System.out.println("3. Volver");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Introduzca id del soldado: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < soldados.size()) {
        Soldado soldado = soldados.get(index);
        switch (opcion) {
            case 1:
                System.out.print("Introduzca la mision: ");
                String mision = scanner.nextLine();
                
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                System.out.println("Opcion invalida");
        }
        }   
       

    }

}
