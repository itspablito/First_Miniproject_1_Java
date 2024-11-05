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
                    System.out.println("5. Salir");
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
                            scanner.close();
                            return;
                        default:
                            System.out.println("Opcion invalida");
                    }
                }
            }

            private static void crearSoldado(Scanner scanner) {
                System.out.print("Introduzca Nombre: ");
                String name = scanner.next();
                System.out.print("Introduzca Rango: ");
                int rango = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Introduzca ID: ");
                int ID = scanner.nextInt();
                scanner.nextLine();


                SoldadoRaso soldado = new SoldadoRaso(name, ID, rango);
                soldados.add(soldado);
                System.out.println("Soldado creado");
            }

            private static void leerSoldado(Scanner scanner) {
                for (int i = 0; i < soldados.size(); i++) {
                    SoldadoRaso soldado = soldados.get(i);
                    System.out.println("ID: " + soldado.getID() + ", Nombre: " + soldado.getNombresoldado() + ", Rango: " + soldado.getRango());
                }
            }

            private static void actSoldado(Scanner scanner) {
                System.out.print("Introduzca id del soldado: ");
                int index = scanner.nextInt();

                if (index >= 0 && index < soldados.size()) {
                    SoldadoRaso soldado = soldados.get(index);
                    System.out.print("Introducir nuevo nombre: ");
                    String nuevoNombre = scanner.next();
                    System.out.print("Introducir nuevo rango: ");
                    int nuevoRango = scanner.nextInt();

                    soldado.setNombresoldado(nuevoNombre);;
                    soldado.setRango(nuevoRango);;;
                    System.out.println("Soldado actualizado.");
                } else {
                    System.out.println("ID invalido");
                }
            }

            private static void borrarSoldado(Scanner scanner) {
                System.out.print("Introduzca id del soldado:: ");
                int index = scanner.nextInt();

                if (index >= 0 && index < soldados.size()) {
                    soldados.remove(index);
                    System.out.println("Soldado borrado.");
                } else {
                    System.out.println("ID invalido");
                }
            }
        }
        

