import java.util.Scanner;
import Soldados.Capitan;
import Soldados.Coronel;
import Soldados.SoldadoRaso;
import Soldados.Teniente;

import java.util.ArrayList;
import java.util.List;
import SoldadoBase.Soldado;



public class App {
    private static List<Soldado> soldados = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println( "(1) Para crear Soldado" + 
                                "\n(2) Para leer Soldado" +
                                "\n(3) Para actualizar Soldado" +
                                "\n(4) Para eliminar Soldado" +
                                "\n(5) Para gestionar Misiones" +
                                "\n(6) Salir" +
                                "\nElija una opción: ");
            int numero = scanner.nextInt();
            
            switch (numero) {
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
                    break;
                case 6:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opcion invalida, vuelve a intentarlo \n ");
            }
        }
    }

    ////////////////////////////////////////////////METODO CREAR SOLDADO//////////////////////////////////////////////

    private static void crearSoldado(Scanner scanner) {
        System.out.print("Introduzca el Nombre: ");
        String NomSoldado = scanner.next();
        System.out.print("Rangos:\n(1) SoldadoRaso \n(2) Teniente \n(3) Capitan \n(4) Coronel \nIntroduzca Rango: ");
        int RanSoldado = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduzca ID: ");
        int IDSoldado = scanner.nextInt();
        scanner.nextLine();
    
        switch (RanSoldado) {
            case 1 -> {
                SoldadoRaso soldado = new SoldadoRaso(NomSoldado, IDSoldado, RanSoldado);
                soldados.add(soldado);
                System.out.println("Soldado Raso creado.\n");
            }
            case 2 -> {
                System.out.print("Introduzca la unidad del Teniente: ");
                String unidad = scanner.nextLine();
    
                Teniente teniente = new Teniente(NomSoldado, IDSoldado, RanSoldado, unidad);
                soldados.add(teniente);
                System.out.println("Teniente creado.\n");
            }
            case 3 -> {
                System.out.print("Introduzca la cantidad de soldados bajo su mando: ");
                int cantidadSoldados = scanner.nextInt();
                scanner.nextLine();
    
                Capitan capitan = new Capitan(NomSoldado, IDSoldado, RanSoldado, cantidadSoldados);
                soldados.add(capitan);
                System.out.println("Capitán creado.\n");
            }
            case 4 -> {
                System.out.print("Introduzca la estrategia militar: ");
                String estrategia = scanner.nextLine();
    
                Coronel coronel = new Coronel(NomSoldado, IDSoldado, RanSoldado, estrategia);
                soldados.add(coronel);
                System.out.println("Coronel creado.\n");
            }
            default -> System.out.println("Rango inválido.");
        }
    }
    

    
    ////////////////////////////////////////////// MÉTODO PARA OBTENER RANGO //////////////////////////////////////////////

    private static String getNombreRango(int rango) {
        return switch (rango) {
            case 1 -> "Soldado Raso";
            case 2 -> "Teniente";
            case 3 -> "Capitan";
            case 4 -> "Coronel";
            default -> "Rango desconocido";
        };
    }


    ////////////////////////////////////////////////METODO LEER SOLDADO//////////////////////////////////////////////

    private static void leerSoldado(Scanner scanner) {
        if (soldados.isEmpty()) {
            System.out.println("--------------------------------\n" +
                                "No hay soldados registrados\n" +
                                "--------------------------------\n");
            return; 
        }
        System.out.println("/////////////////// Lista de Soldados ///////////////////");

        for (Soldado soldado : soldados) {
            System.out.println("ID: " + soldado.getID() + " \nNombre: " + soldado.getNombresoldado());
            System.out.println("__________________\n");

            switch (soldado.getRango()) {
                case 1 -> System.out.println("Rango: Soldado Raso");
                case 2 -> System.out.println("Rango: Teniente");
                case 3 -> System.out.println("Rango: Capitan");
                case 4 -> System.out.println("Rango: Coronel");
                default -> System.out.println("Rango desconocido");
            }
            System.out.println("__________________\n");
        }
    }

    ////////////////////////////////////////////////METODO ACTUALIZAR SOLDADO//////////////////////////////////////////////

    private static void actSoldado(Scanner scanner) {
        System.out.print("Introduzca el ID del soldado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        boolean encontrado = false;
        for (Soldado soldado : soldados) {
            if (soldado.getID() == id) {
                encontrado = true;
                

                System.out.print("Introducir nuevo nombre: ");
                String nuevoNombre = scanner.nextLine();

                System.out.print("Introducir nuevo rango (1-4): ");
                int nuevoRango = scanner.nextInt();

                if (nuevoRango < 1 || nuevoRango > 4) {
                    System.out.println("Rango inválido. Vuelve a intentarlo.\n");
                    return;
                }

                soldado.setNombresoldado(nuevoNombre);
                soldado.setRango(nuevoRango);
                System.out.println("Soldado actualizado correctamente.\n");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("ID inválido. Vuelve a intentarlo. \n");
        }
    }

    ////////////////////////////////////////////////METODO BORRAR SOLDADO//////////////////////////////////////////////

    private static void borrarSoldado(Scanner scanner) {
        System.out.print("Introduzca el ID del soldado: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < soldados.size(); i++) {
            if (soldados.get(i).getID() == id) {  
                soldados.remove(i);
                System.out.println("Soldado borrado. \n");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("ID invalido, vuelve a intentarlo \n ");
        }
    }



    //////////////////////////////////////////////METODO GESTIONAR MISIONES//////////////////////////////////////////////

    private static void misiones(Scanner scanner) {
        System.out.println("Gestión de Misiones");
        System.out.println("(1) Asignar Misión\n(2) Reportar Estado\n(3) Regañar Soldado\n(4) Volver");
        System.out.print("Elija una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
    
        if (opcion == 4) {
            return; 
        }
    
        System.out.print("Introduzca el ID del soldado: ");
        int id = scanner.nextInt();
        scanner.nextLine();
    
        Soldado soldado = buscarSoldadoPorID(id); 
        if (soldado == null) {
            System.out.println("ID inválido. Vuelve a intentarlo.");
            return;
        }
        
        switch (opcion) {
            case 1 -> asignarMision(scanner, soldado);
            case 2 -> soldado.mostrardatos();
            case 3 -> regañarSoldado(scanner, soldado);
            default -> System.out.println("Opción inválida. Vuelve a intentarlo.");
        }
        /*switch (opcion) {
            case 1 -> {
                if (soldado instanceof SoldadoRaso soldadoRaso) {
                    asignarMision(scanner, soldadoRaso);
                } else {
                    System.out.println("Solo los Soldados Rasos pueden recibir misiones específicas.");
                }
            }
            case 2 -> soldado.mostrardatos();
            case 3 -> {
                if (soldado instanceof SoldadoRaso soldadoRaso && soldadoRaso.getRango() < 2) {
                    System.out.println("Solo los soldados de rango Capitán o superior pueden regañar.");
                } else {
                    regañarSoldado(scanner, soldado);
                }
            }
            default -> System.out.println("Opción inválida. Vuelve a intentarlo."); 
        }*/
    }
    
    
    private static void asignarMision(Scanner scanner, Soldado soldado) {
        int rango = soldado.getRango();
        List<Tarea> tareas = Tarea.getTareasPorRango(rango);

        if (tareas.isEmpty()) {
            System.out.println("Este rango no tiene tareas asignables.");
            return;
        }

        System.out.println("Tareas disponibles para este rango:");
        for (int i = 0; i < tareas.size(); i++) {
            System.out.println("(" + (i + 1) + ") " + tareas.get(i));
        }

        System.out.print("Seleccione una tarea: ");
        int seleccion = scanner.nextInt();
        scanner.nextLine();

        if (seleccion < 1 || seleccion > tareas.size()) {
            System.out.println("Selección inválida. Vuelve a intentarlo.");
            return;
        }

        Tarea tareaAsignada = tareas.get(seleccion - 1);
        soldado.asignarMision(tareaAsignada.name()); // Implementa este método en la clase Soldado.
        System.out.println("Misión '" + tareaAsignada + "' asignada correctamente.");
}

    //////////////////////////////////////////////METODO BUSCAR SOLDADO POR ID//////////////////////////////////////////////

    private static Soldado buscarSoldadoPorID(int id) {
        for (Soldado soldado : soldados) {
            if (soldado.getID() == id) {
                return soldado; // Devuelve el objeto tal cual, sin hacer downcasting.
            }
        }
        System.out.println("Soldado no encontrado.");
        return null;
    }
    

 ////////////////////////////////////////////// ENUM PARA TAREA //////////////////////////////////////////////

    public enum Tarea{
        RECONOCIMIENTO,
        DEFENSA,
        ENTRENAMIENTO;

        public static List<Tarea> getTareasPorRango(int rango) {
            List<Tarea> tareas = new ArrayList<>();
            switch (rango) {
                case 1: 
                    tareas.add(RECONOCIMIENTO);
                    tareas.add(ENTRENAMIENTO);
                    break;
                case 2:
                    tareas.add(DEFENSA);
                    tareas.add(RECONOCIMIENTO);
                    break;
                case 3: 
                    tareas.add(DEFENSA);
                    tareas.add(RECONOCIMIENTO);
                    tareas.add(ENTRENAMIENTO);
                    break;
                case 4: 
                    tareas.add(DEFENSA);
                    break;
                default:
                    break;
            }
            return tareas;
        }
    }

 ////////////////////////////////////////////// MÉTODO REGAÑAR SOLDADO //////////////////////////////////////////////


 private static void regañarSoldado(Scanner scanner, Soldado soldadoRegañador) {
    System.out.print("Introduzca el ID del soldado a regañar: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    Soldado soldadoRegañado = buscarSoldadoPorID(id);

    if (soldadoRegañado == null) {
        System.out.println("Soldado no encontrado. Intenta de nuevo.");
        return;
    }

    if (soldadoRegañador.getRango() <= soldadoRegañado.getRango()) {
        System.out.println("No puedes regañar a un soldado de igual o mayor rango.");
        return;
    }

    if (soldadoRegañado.getRango() == 1) {
        soldados.remove(soldadoRegañado);
        System.out.println("El Soldado " + soldadoRegañado.getNombresoldado() + " ha sido EXPULSADO!!!");
    } else {
        int nuevoRango = soldadoRegañado.getRango() - 1;
        soldadoRegañado.setRango(nuevoRango);
        System.out.println("El soldado " + soldadoRegañado.getNombresoldado() +
                        " ha sido bajado de rango. Ahora es: " + getNombreRango(nuevoRango) + ".");
    }
}
}

   