import java.util.Scanner;
import Soldados.SoldadoRaso;
import java.util.ArrayList;
import java.util.List;
    
public class App {
        private static List<SoldadoRaso> soldados = new ArrayList<>();

        public static void main(String[] args) throws Exception {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. Crear Soldado");
                System.out.println("2. Leer Soldado");
                System.out.println("3. Actualizar Soldado");
                System.out.println("4. Eliminar Soldado");
                System.out.println("5. Gestionar Misiones");
                System.out.println("6. Salir");
                System.out.print("Elija una opción: ");
                int option = scanner.nextInt();

                switch (option) {
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
            String name = scanner.next();
            System.out.print("Rangos:\n(1)SoldadoRaso \n(2)Capitan \n(3)Coronel \n(4)Teniente \nIntroduzca Rango: ");
            int rango = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Introduzca ID : ");
            int ID = scanner.nextInt();
            scanner.nextLine();


            SoldadoRaso soldado = new SoldadoRaso(name, ID, rango);
            soldados.add(soldado);
            System.out.println("Soldado creado");
        }

///////////////////////////////////LECTURA DE SOLDADOS //////////////////////////////////////////
        
        private static void leerSoldado(Scanner scanner) {
            for (int i = 0; i < soldados.size(); i++) {
                SoldadoRaso soldado = soldados.get(i);
                System.out.println("///////// Soldados Actuales //////////\nID: " + soldado.getID() + " \nNombre: " + soldado.getNombresoldado() + " \nRango: " + soldado.getRango() + "\n-----------------------------------");
            }
        }
///////////////////////////////////ACTUALIZACION DE SOLDADOS //////////////////////////////////////////


        private static void actSoldado(Scanner scanner) {
            System.out.print(" Introduzca ID del soldado : ");
            int index = scanner.nextInt();

            if (index >= 0 && index < soldados.size()) {
                SoldadoRaso soldado = soldados.get(index);
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
            System.out.print("Introduzca id del soldado:: ");
            int index = scanner.nextInt();

                if (index >= 0 && index < soldados.size()) {
                    soldados.remove(index);
                    System.out.println("Soldado borrado.");
                } 
                else {
                    System.out.println("ID invalido");
                    }
            
            
            }
/////////////////////////////////////////////////////////////////////////////    

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
        SoldadoRaso soldado = soldados.get(index);
        switch (opcion) {
            case 1:
                if (soldado.getRango() == 1) {
                    System.out.println("El soldado raso no puede hacer misiones");
                } else {
                    System.out.println("Introduzca la mision a asignar: ");
                    String mision = scanner.nextLine();
                    soldado.asignarMision(mision);
                }
                break;
            case 2:
                soldado.reportarEstado();
                break;
            case 3:
                break;
            default:
                break;
            }
        }else {
            System.out.println("ID invalido");
        }

        //////////////////////////////////////////////////////////
        
           
    }

}

