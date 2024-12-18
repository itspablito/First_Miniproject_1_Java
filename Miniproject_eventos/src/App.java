import java.util.Scanner;
import java.awt.*;
import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import Operaciones_Militares.OperacionesMilitares;
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
        reproducirMusica();
        try {
            Thread.sleep(10000); // Mantén el programa corriendo durante 10 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
        

    ////////////////////////////////////////////////METODO CREAR SOLDADO//////////////////////////////////////////////

    public static void crearSoldado(String nombreVisual,int id,int rango) {
        switch (rango) {
            case 1 -> {
                SoldadoRaso soldado = new SoldadoRaso(nombreVisual, id, rango);
                soldados.add(soldado);
                Visual.actualizarLista();
            }
            case 2 -> {
                String unidad = JOptionPane.showInputDialog(null, "unidad:", "Entrada de Datos", JOptionPane.PLAIN_MESSAGE);
    
                Teniente teniente = new Teniente(nombreVisual, id, rango, unidad);
                soldados.add(teniente);
                Visual.actualizarLista();
                
                
            }
            case 3 -> {
                String mando = JOptionPane.showInputDialog(null, "ingrese los soldados bajo su mando:", "Entrada de Datos", JOptionPane.PLAIN_MESSAGE);
                int soldadosbajosumando = Integer.parseInt(mando);

                Capitan capitan = new Capitan(nombreVisual, id, rango, soldadosbajosumando);
                soldados.add(capitan);
                Visual.actualizarLista();
            }
            case 4 -> {
                String estrategia = JOptionPane.showInputDialog(null, "estrategia militar:", "Entrada de Datos", JOptionPane.PLAIN_MESSAGE);    
                Coronel coronel = new Coronel(nombreVisual, id, rango, estrategia);
                soldados.add(coronel);
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
        etiqueta_nuevoNombre.setFont(new Font("Arial", Font.BOLD, 30));
    
        JTextField nuevoNombre_actualizar = new JTextField(5); // Campo de texto
        nuevoNombre_actualizar.setFont(new Font("Arial", Font.BOLD, 40));
    
        JLabel etiqueta_nuevoRango = new JLabel("Introducir nuevo rango (1-4): ");
        etiqueta_nuevoRango.setFont(new Font("Arial", Font.BOLD, 30));
    
        JTextField nuevoRango = new JTextField(5); // Campo de texto
        nuevoRango.setFont(new Font("Arial", Font.BOLD, 40));
    
        JButton funcionar = new JButton("Actualizar");
        ImageIcon iconodelapp = new ImageIcon("Miniproject_eventos\\src\\Images\\Fondo_Botones.jpg"); // Carga la imagen del botón
        funcionar.setIcon(iconodelapp); // Establece la imagen en el botón
        funcionar.setHorizontalTextPosition(SwingConstants.CENTER); // Texto centrado horizontalmente
        funcionar.setVerticalTextPosition(SwingConstants.CENTER);   // Texto centrado verticalmente
        funcionar.setContentAreaFilled(false); // Hace transparente el área de contenido
        funcionar.setFocusPainted(false); // Elimina el enfoque visual del botón
        funcionar.setFont(new Font("Bebas Neue", Font.BOLD, 20));
        funcionar.setForeground(new Color(53, 53, 53)); // Color del texto
        funcionar.setBounds(50, 300, 500, 50);
        
        boolean encontrado = false;
    
        for (Soldado soldado : soldados) {
            if (soldado.getID() == id) {
                encontrado = true;                        
                JOptionPane.showMessageDialog(Visual.panelactualizar, "Soldado encontrado: " + soldado.getNombresoldado());
    
                Visual.panelactualizar.removeAll(); // Limpiar el panel antes de agregar nuevos componentes
    
                // Agregar nuevos componentes
                etiqueta_nuevoNombre.setBounds(50, 50, 500, 50);
                nuevoNombre_actualizar.setBounds(50, 100, 500, 50);
                etiqueta_nuevoRango.setBounds(50, 200, 500, 50);
                nuevoRango.setBounds(50, 250, 500, 50);
                funcionar.setBounds(50, 350, 200, 50);
    
                Visual.panelactualizar.add(etiqueta_nuevoNombre);
                Visual.panelactualizar.add(nuevoNombre_actualizar);
                Visual.panelactualizar.add(etiqueta_nuevoRango);
                Visual.panelactualizar.add(nuevoRango);
                Visual.panelactualizar.add(funcionar);
    
                // Actualizar el panel visualmente
                Visual.panelactualizar.revalidate();
                Visual.panelactualizar.repaint();
                
                funcionar.addActionListener(e -> {
                    String nuevo_nombre = nuevoNombre_actualizar.getText();
                    String nuevo_rango = nuevoRango.getText();
                    JOptionPane.showMessageDialog(Visual.panelactualizar, "Soldado actualizado correctamente.");
                    try {
                        int rango = Integer.parseInt(nuevo_rango);
                        soldado.setNombresoldado(nuevo_nombre); // Actualiza el nombre del soldado
                        solicitarDatosPorRango(soldado, rango); // Actualiza el rango y otros datos
                        funcionar.setVisible(false);
                        
                        // Actualizar el panel después de la actualización
                        Visual.panelactualizar.removeAll(); 
                        Visual.panelactualizar.revalidate();
                        Visual.panelactualizar.repaint();
    
                        // Mostrar panel de búsqueda
                        Visual.labelNombre2.setVisible(true);
                        Visual.Nombreactualizar.setVisible(true);
                        Visual.TextobuscarID.setVisible(true);
                        Visual.buscarID.setVisible(true);
                        Visual.panelactualizar.add(Visual.labelNombre2);
                        Visual.panelactualizar.add(Visual.Nombreactualizar);
                        Visual.panelactualizar.add(Visual.TextobuscarID);
                        Visual.panelactualizar.add(Visual.buscarID);
                        
                        Visual.panelactualizar.revalidate();
                        Visual.panelactualizar.repaint();
    
                        // Actualizar la lista de soldados visualmente
                        Visual.actualizarLista();
                        
                        // Ocultar panel de actualización y mostrar el panel central
                        Visual.cambiarpanelcentral();

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
        

        for (int i = 0; i < soldados.size(); i++) {

            if (soldados.get(i).getID() == IDaeliminar) {  
                soldados.remove(i);

                Visual.actualizarLista();
                Visual.paneleliminar.setVisible(false);
                Visual.panelCentral.setVisible(true);
                break;
            }
        }

    }



    ////////////////////////////////////////////METODO GESTIONAR MISIONES//////////////////////////////////////////////

    public static void misiones(int opcion, int IDRegañador, int IDRegañado) {
        // Validar la opción
        if (opcion == 4) {
            return;
        }
    
        // Buscar al soldado que regaña y al que será regañado
        Soldado soldadoRegañador = buscarSoldadoPorID(IDRegañador);
        Soldado soldadoRegañado = buscarSoldadoPorID(IDRegañado);
    
        // Validar si ambos soldados existen
        if (soldadoRegañador == null || soldadoRegañado == null) {
            JOptionPane.showMessageDialog(null, "Uno o ambos IDs no corresponden a soldados válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        // Opciones disponibles
        switch (opcion) {
            case 2: // Mostrar datos del soldado regañador
                soldadoRegañador.mostrardatos();
                break;
    
            case 3: // Regañar al soldado
                if (soldadoRegañador.getRango() <= soldadoRegañado.getRango()) {
                    JOptionPane.showMessageDialog(null, "No puedes regañar a un soldado de igual o mayor rango.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    regañarSoldado(soldadoRegañador, soldadoRegañado);
                }
                break;
    
            default: // Opción no válida
                System.out.println("Opción no válida.");
                break;
        }
    }
    
    /*public static void asignarMisionGeneral(Soldado soldado, String mision) {
    if (soldado instanceof OperacionesMilitares) {
        OperacionesMilitares operaciones = (OperacionesMilitares) soldado;
        operaciones.asignarMision(mision);
    } else {
        System.out.println("Este soldado no puede recibir misiones.");
    }}
    



    
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

    *//////////////////////////////////////////////// ASIGNAR MISION GENERAL //////////////////////////////////////////////


    public static void asignarMisionGeneral(Soldado soldado) {
        if (soldado instanceof OperacionesMilitares) {
            OperacionesMilitares operaciones = (OperacionesMilitares) soldado;
    
            // Obtener las misiones disponibles según el rango del soldado
            List<Tarea> misiones = Tarea.getTareasPorRango(soldado.getRango());
            String[] opcionesMisiones = misiones.stream().map(Enum::name).toArray(String[]::new);
    
            String misionSeleccionada = (String) JOptionPane.showInputDialog(
                null,
                "Selecciona una misión para el soldado:\n" + soldado.getNombresoldado(),
                "Asignar Misión",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesMisiones,
                opcionesMisiones[0]
            );
    
            if (misionSeleccionada != null) {
                operaciones.asignarMision(misionSeleccionada);
                JOptionPane.showMessageDialog(null,
                    "Misión '" + misionSeleccionada + "' asignada a " + soldado.getNombresoldado(),
                    "Misión Asignada",
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                    "No se asignó ninguna misión.",
                    "Asignar Misión",
                    JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                "Este soldado no tiene rango para recibir misiones.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    

    public static void reportarEstadoGeneral(Soldado soldado) {
        if (soldado instanceof OperacionesMilitares) {
            OperacionesMilitares operaciones = (OperacionesMilitares) soldado;
    
            StringBuilder estado = new StringBuilder();
            estado.append("Nombre: ").append(soldado.getNombresoldado()).append("\n");
            estado.append("ID: ").append(soldado.getID()).append("\n");
            estado.append("Rango: ").append(soldado.getRango()).append("\n");
            estado.append("Misión: ").append(operaciones.getMisionActual()).append("\n");
    
            JOptionPane.showMessageDialog(null, estado.toString(), "Estado del Soldado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                "No hay información disponible para este soldado.",
                "Estado del Soldado",
                JOptionPane.WARNING_MESSAGE);
        }
    }
    


    //////////////////////////////////////////////METODO BUSCAR SOLDADO POR ID//////////////////////////////////////////////

    public static Soldado buscarSoldadoPorID(int id) {
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

    public enum Tarea {
        RECONOCIMIENTO,
        ESCOLTA,
        DEFENSA,
        ENTRENAMIENTO,
        INTELIGENCIA,
        ATAQUE;

        public static List<Tarea> getTareasPorRango(int rango) {
            List<Tarea> tareas = new ArrayList<>();
            switch (rango) {
                case 1: // Soldado Raso
                    tareas.add(RECONOCIMIENTO);
                    tareas.add(ESCOLTA);
                    tareas.add(ENTRENAMIENTO);
                    break;

                case 2: // Teniente
                    tareas.add(DEFENSA);
                    tareas.add(RECONOCIMIENTO);
                    tareas.add(ESCOLTA);
                    break;

                case 3: // Capitán
                    tareas.add(DEFENSA);
                    tareas.add(RECONOCIMIENTO);
                    tareas.add(ENTRENAMIENTO);
                    tareas.add(INTELIGENCIA);
                    break;

                case 4: // Coronel
                    tareas.add(DEFENSA);
                    tareas.add(ATAQUE);
                    tareas.add(INTELIGENCIA);
                    tareas.add(RECONOCIMIENTO);
                    break;

                default: // Sin rango válido
                    break;
            }
            return tareas;
        }
    }

////////////////////////////////////////////// MÉTODO REGAÑAR SOLDADO //////////////////////////////////////////////


    private static void regañarSoldado(Soldado soldadoRegañador, Soldado soldadoRegañado) {
        try {
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
                Visual.actualizarLista(); // Refresca la lista de soldados en la interfaz
                Visual.panelRegañar.setVisible(false);
                Visual.gestionarmisionesPrincipal.setVisible(true);
            } else {
                int nuevoRango = soldadoRegañado.getRango() - 1;
                JOptionPane.showMessageDialog(Visual.panelRegañar, "El soldado " + soldadoRegañado.getNombresoldado() + " ha sido bajado de rango a: " + getNombreRango(nuevoRango));
                solicitarDatosPorRango(soldadoRegañado, nuevoRango); // Actualiza el rango del soldado
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(Visual.panelRegañar, "Ocurrió un error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private static void solicitarDatosPorRango(Soldado soldadoRegañado, int nuevoRango) {
        String nuevoNombre = soldadoRegañado.getNombresoldado();  
        int id = soldadoRegañado.getID();

        switch (nuevoRango) {
    case 1 -> {
        SoldadoRaso nuevoSoldado = new SoldadoRaso(nuevoNombre, id, nuevoRango);
        reemplazarSoldadoEnLista(soldadoRegañado, nuevoSoldado);
        Visual.actualizarLista();
        Visual.panelRegañar.setVisible(false);
        Visual.panelCentral.setVisible(true);
    }
    case 2 -> {
        String unidad = JOptionPane.showInputDialog(null, "Unidad:", "Entrada de Datos", JOptionPane.PLAIN_MESSAGE);
        Teniente nuevoTeniente = new Teniente(nuevoNombre, id, nuevoRango, unidad);
        reemplazarSoldadoEnLista(soldadoRegañado, nuevoTeniente);
        Visual.actualizarLista();
        Visual.panelRegañar.setVisible(false);
        Visual.panelCentral.setVisible(true);
    }
    case 3 -> {
        String cantidadSoldados1 = JOptionPane.showInputDialog(null, "Soldados bajo su mando:", "Entrada de Datos", JOptionPane.PLAIN_MESSAGE);
        int cantidadSoldados = Integer.parseInt(cantidadSoldados1);
        Capitan nuevoCapitan = new Capitan(nuevoNombre, id, nuevoRango, cantidadSoldados);
        reemplazarSoldadoEnLista(soldadoRegañado, nuevoCapitan);
        Visual.actualizarLista();
        Visual.panelRegañar.setVisible(false);
        Visual.panelCentral.setVisible(true);
    }
    case 4 -> {
        String estrategia = JOptionPane.showInputDialog(null, "Estrategia militar:", "Entrada de Datos", JOptionPane.PLAIN_MESSAGE);
        Coronel nuevoCoronel = new Coronel(nuevoNombre, id, nuevoRango, estrategia);
        reemplazarSoldadoEnLista(soldadoRegañado, nuevoCoronel);
        Visual.actualizarLista();
        Visual.panelRegañar.setVisible(false);
        Visual.panelCentral.setVisible(true);
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

    public static boolean soldadoExiste(int id) {
        // Suponiendo que los soldados están guardados en una lista llamada listaSoldados
        for (Soldado soldado : soldados) {
            if (soldado.getID() == id) {
                return true; // El soldado con el ID existe
            }
        }
        return false; // El soldado no se encuentra en la lista
    }
    


////////////////////////////////////////////// METODO REPRODUCIR MUSICA //////////////////////////////////////////////

    public static void reproducirMusica() {
        try {
            File archivo = new File("Miniproject_eventos\\src\\Sounds\\Soundtrack.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(archivo));
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


   