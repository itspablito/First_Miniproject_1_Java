import java.util.Scanner;

import javax.swing.*;

import Soldados.Capitan;
import Soldados.Coronel;
import Soldados.SoldadoRaso;
import Soldados.Teniente;

import java.util.ArrayList;
import java.util.List;
import Soldado_Principal.Soldado;



public class App extends JFrame {
    public static List<Soldado> soldados = new ArrayList<>();
    public static List<Tarea> tareas = new ArrayList<>();
    

    public static void main(String[] args) throws Exception {
        new Visual().sisas(soldados);
    }
        

    ////////////////////////////////////////////////METODO CREAR SOLDADO//////////////////////////////////////////////

    public static void crearSoldado(String nombreVisual,int id,int rango) {
        System.out.print("Introduzca el Nombre: ");
        System.out.print("Rangos:\n(1) SoldadoRaso \n(2) Teniente \n(3) Capitan \n(4) Coronel \nIntroduzca Rango: ");

        switch (rango) {
            case 1 -> {
                SoldadoRaso soldado = new SoldadoRaso(nombreVisual, id, rango);
                soldados.add(soldado);
                System.out.println("Soldado Raso creado.\n");
                Visual.actualizarLista();
            }
            case 2 -> {
                System.out.print("Introduzca la unidad del Teniente: ");
                String unidad = JOptionPane.showInputDialog(null, "unidad:", "Entrada de Datos", JOptionPane.PLAIN_MESSAGE);
    
                Teniente teniente = new Teniente(nombreVisual, id, rango, unidad);
                soldados.add(teniente);
                System.out.println("Teniente creado.\n");
                Visual.actualizarLista();
                
                
            }
            case 3 -> {
                System.out.print("Introduzca la cantidad de soldados bajo su mando: ");
                String mando = JOptionPane.showInputDialog(null, "ingrese los soldados bajo su mando:", "Entrada de Datos", JOptionPane.PLAIN_MESSAGE);
                int soldadosbajosumando = Integer.parseInt(mando);

                Capitan capitan = new Capitan(nombreVisual, id, rango, soldadosbajosumando);
                soldados.add(capitan);
                System.out.println("Capitán creado.\n");
                Visual.actualizarLista();
            }
            case 4 -> {
                String estrategia = JOptionPane.showInputDialog(null, "estrategia militar:", "Entrada de Datos", JOptionPane.PLAIN_MESSAGE);
                System.out.print("Introduzca la estrategia militar: ");
    
                Coronel coronel = new Coronel(nombreVisual, id, rango, estrategia);
                soldados.add(coronel);
                System.out.println("Coronel creado.\n");
                Visual.actualizarLista();
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

    public static void actSoldado(int id) {                    
        JLabel etiqueta_nuevoNombre = new JLabel("Introducir nuevo nombre: ");
        JTextField nuevoNombre_actualizar = new JTextField(20); // Campo de texto
        JLabel etiqueta_nuevoRango = new JLabel("Introducir nuevo rango (1-4): ");
        JTextField nuevoRango = new JTextField(5); // Campo de texto
        JButton funcionar = new JButton("Actualizar Soldado");
    
        boolean encontrado = false;
    
        for (Soldado soldado : soldados) {
            if (soldado.getID() == id) {
                encontrado = true;                        
                Visual.buscarID.setVisible(false);
                JOptionPane.showMessageDialog(Visual.panelactualizar, "Soldado encontrado: " + soldado.getNombresoldado());

                Visual.panelactualizar.removeAll();
                Visual.panelactualizar.add(etiqueta_nuevoNombre);
                Visual.panelactualizar.add(nuevoNombre_actualizar);
                Visual.panelactualizar.add(etiqueta_nuevoRango);
                Visual.panelactualizar.add(nuevoRango);
                Visual.panelactualizar.add(funcionar);
                Visual.panelactualizar.revalidate();
                Visual.panelactualizar.repaint();
                funcionar.addActionListener(e -> {
                    String nuevo_nombre = nuevoNombre_actualizar.getText();
                    String nuevo_rango = nuevoRango.getText();
                    try {
                        int rango = Integer.parseInt(nuevo_rango);
                        soldado.setNombresoldado(nuevo_nombre); 
                        soldado.setRango(rango);
                        JOptionPane.showMessageDialog(Visual.panelactualizar, "Soldado actualizado correctamente.");
                        Visual.actualizarLista(); 
                        Visual.panelactualizar.setVisible(false);;
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(Visual.panelactualizar, "El rango debe ser un número válido.");
                    }
                });
                break;
            }
        }
    
        if (!encontrado) {
            JOptionPane.showMessageDialog(Visual.panelactualizar, "Soldado no encontrado.");
        
    }
    }

    ////////////////////////////////////////////////METODO BORRAR SOLDADO//////////////////////////////////////////////

    public static void borrarSoldado(int IDaeliminar) {
        
        boolean encontrado = false;
        for (int i = 0; i < soldados.size(); i++) {
            if (soldados.get(i).getID() == IDaeliminar) {  
                soldados.remove(i);
                System.out.println("Soldado borrado. \n");
                encontrado = true;
                Visual.actualizarLista();
                JOptionPane.showMessageDialog(Visual.panelelimiar, "Soldado eliminado corractamente.");
                Visual.panelelimiar.setVisible(false);
                Visual.panelCentral.setVisible(true);
                break;
            }
        }
        if (!encontrado) {
            System.out.println("ID invalido, vuelve a intentarlo \n ");
        }
    }



    //////////////////////////////////////////////METODO GESTIONAR MISIONES//////////////////////////////////////////////

    public static void misiones(int opcion, int ID) {
        JOptionPane.showMessageDialog(Visual.panelRegañar, "1", "Error", JOptionPane.ERROR_MESSAGE);

        int opcion1 = opcion;
        if (opcion1 == 4) {
            return; 
        }
    
        Soldado soldado1 = buscarSoldadoPorID(ID); 
        if (soldado1 == null) {
            System.out.println("1");
            return;
        }
        
        if (opcion1 == 2) {
            soldado1.mostrardatos();
            }
        else if (opcion1 == 3) {
            regañarSoldado(soldado1);
            }
        else {
        System.out.println("3");
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
    
    
    private static void asignarMision(Scanner scanner,int IDasiganado) {

        Soldado soldado = buscarSoldadoPorID(IDasiganado); 
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
                // Soldado encontrado
                JOptionPane.showMessageDialog(null, "Soldado encontrado: " + soldado.getNombresoldado());
                return soldado;
            }
        }
        // No se encontró el soldado
        JOptionPane.showMessageDialog(null, "Soldado no encontrado con ID: " + id, "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }
    
    
    

 ////////////////////////////////////////////// ENUM PARA TAREA //////////////////////////////////////////////

    public enum Tarea{
        RECONOCIMIENTO,
        DEFENSA,
        ENTRENAMIENTO;
        public static List<Tarea> getTareasPorRango(int rango) {
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


    private static void regañarSoldado(Soldado soldadoRegañador) {
        JTextField regañado1 = new JTextField(5);
        JButton btnConfirmar = new JButton("Confirmar");

        // Añadir campo y botón al panel
        Visual.panelRegañar.add(new JLabel("Ingrese ID del soldado a regañar:"));
        Visual.panelRegañar.add(regañado1);
        Visual.panelRegañar.add(btnConfirmar);
        
        regañado1.setVisible(true);
        btnConfirmar.setVisible(true);

        Visual.panelRegañar.revalidate();
        Visual.panelRegañar.repaint();

        // Acción del botón
        btnConfirmar.addActionListener(e -> {
            try {
                String input = regañado1.getText();
                if (input.isEmpty()) {
                    JOptionPane.showMessageDialog(Visual.panelRegañar, "Debe ingresar un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int regañado = Integer.parseInt(input);
                Soldado soldadoRegañado = buscarSoldadoPorID(regañado);

                if (soldadoRegañado == null) {
                    JOptionPane.showMessageDialog(Visual.panelRegañar, "Soldado no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (soldadoRegañador.getRango() <= soldadoRegañado.getRango()) {
                    JOptionPane.showMessageDialog(Visual.panelRegañar, "No puedes regañar a un soldado de igual o mayor rango.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (soldadoRegañado.getRango() == 1) {
                    soldados.remove(soldadoRegañado);
                    JOptionPane.showMessageDialog(Visual.panelRegañar, "El Soldado " + soldadoRegañado.getNombresoldado() + " ha sido EXPULSADO!!!");
                    Visual.actualizarLista();
                    Visual.panelRegañar.setVisible(false);
                    Visual.gestionarmisionesPrincipal.setVisible(true);
                } else {
                    int nuevoRango = soldadoRegañado.getRango() - 1;
                    JOptionPane.showMessageDialog(Visual.panelRegañar, "El soldado " + soldadoRegañado.getNombresoldado() + " ha sido bajado de rango a: " + getNombreRango(nuevoRango));
                    solicitarDatosPorRango(soldadoRegañado, nuevoRango);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Visual.panelRegañar, "El ID debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }


    private static void solicitarDatosPorRango(Soldado soldadoRegañado, int nuevoRango) {
        String nuevoNombre = soldadoRegañado.getNombresoldado();  
        int id = soldadoRegañado.getID();

        switch (nuevoRango) {
            case 2 -> {
                String unidad = JOptionPane.showInputDialog(null, "unidad:", "Entrada de Datos", JOptionPane.PLAIN_MESSAGE);
                Teniente nuevoTeniente = new Teniente(nuevoNombre, id, nuevoRango, unidad);
                reemplazarSoldadoEnLista(soldadoRegañado, nuevoTeniente);
                System.out.println("El Capitán ha sido degradado a Teniente con su nueva unidad: " + unidad);
                Visual.actualizarLista();
                Visual.panelRegañar.setVisible(false);
                Visual.gestionarmisionesPrincipal.setVisible(true);
                
            }
            case 3 -> {
                System.out.print("Introduzca la cantidad de soldados bajo su mando (nuevo Capitán): ");
                String cantidadSoldados1 = JOptionPane.showInputDialog(null, "unidad:", "Entrada de Datos", JOptionPane.PLAIN_MESSAGE);
                int cantidadSoldados = Integer.parseInt(cantidadSoldados1);
                Capitan nuevoCapitan = new Capitan(nuevoNombre, id, nuevoRango, cantidadSoldados);
                reemplazarSoldadoEnLista(soldadoRegañado, nuevoCapitan);
                System.out.println("El Coronel ha sido degradado a Capitán con " + cantidadSoldados + " soldados bajo su mando.");
                Visual.actualizarLista();
                Visual.panelRegañar.setVisible(false);
                Visual.gestionarmisionesPrincipal.setVisible(true);
            }
            case 4 -> {
                String estrategia = JOptionPane.showInputDialog(null, "unidad:", "Entrada de Datos", JOptionPane.PLAIN_MESSAGE);
                Coronel nuevoCoronel = new Coronel(nuevoNombre, id, nuevoRango, estrategia);
                reemplazarSoldadoEnLista(soldadoRegañado, nuevoCoronel);
                System.out.println("El Coronel ha sido degradado y ahora sigue una nueva estrategia: " + estrategia);
                Visual.actualizarLista();
                Visual.panelRegañar.setVisible(false);
                Visual.gestionarmisionesPrincipal.setVisible(true);
            }
        }
    }

    private static void reemplazarSoldadoEnLista(Soldado viejoSoldado, Soldado nuevoSoldado) {
        int index = soldados.indexOf(viejoSoldado);
        if (index != -1) {
            soldados.set(index, nuevoSoldado);
        }

    }
    public void reportarEstado() {
    }
}

   