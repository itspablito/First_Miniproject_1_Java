import javax.swing.*;
import Soldado_Principal.Soldado;
import java.awt.*;
import java.util.List;

public class Visual extends JFrame {
    public static JFrame frame;
    public static JList<Soldado> SoldadoJlist;
    public static JList<Tarea> TareasJlist;
    public static DefaultListModel<Soldado> modelo;
    public static DefaultListModel<Tarea> modelo2;
    private JButton botoncrear, botonleer, botonactualizar, botoneliminar, botongestiormision;
    public static JPanel panelCentral, panelCrearsoldado, panelactualizar, panelelimiar, gestionarmisionesPrincipal, panelIzquierdo, panelRegañar, panelleer;
    public static JTextField nombredelsoldado, IDdelsoldado, TextobuscarID, BuscarEliminar, IDRegañador;
    public static JButton bombon, buscarID,boton_asignarmision, boton_reportarestado, boton_realizarregaño, botonRegañar;
    public static ButtonGroup  grupoRangos;
    public static JRadioButton botonrango1, botonrango2, botonrango3, botonrango4;
    public static JScrollPane scroll, scroll1;


    public void sisas(List<Soldado> soldados) {
        // Inicializa el JFrame
        frame = new JFrame("Gestión de Soldados");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setLayout(new BorderLayout());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // lista de soldados
        modelo = new DefaultListModel<>();
        for (Soldado soldado : soldados) {
            modelo.addElement(soldado);
        }
        SoldadoJlist = new JList<>(modelo);
        JScrollPane scroll = new JScrollPane(SoldadoJlist);

        // lista de tareas
        // modelo2 = new DefaultListModel<>();
        // for (Tarea tarea : tareas) {
        //     modelo2.addElement(tarea);
        // }
        // TareasJlist = new JList<>(modelo2);
        // JScrollPane scroll1 = new JScrollPane(TareasJlist);
        // panelIzquierdo.add(scroll1);
        // frame.add(panelIzquierdo, BorderLayout.CENTER);
        
   
        panelIzquierdo = new JPanel();
        panelIzquierdo.setBorder(BorderFactory.createTitledBorder("Listado de Soldados"));
        panelIzquierdo.add(scroll);
        frame.add(panelIzquierdo, BorderLayout.WEST);


        JPanel mainPanel = new JPanel(new CardLayout());
        frame.add(mainPanel, BorderLayout.CENTER);

        /////////////////// Panel Central ///////////////////////////////////////////
        panelCentral = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelCentral.setBorder(BorderFactory.createTitledBorder("Opciones"));
        
        botoncrear = new JButton("Crear Soldado");
        botonleer = new JButton("Leer Soldado");
        botonactualizar = new JButton("Actualizar Soldado");
        botoneliminar = new JButton("Eliminar Soldado");
        botongestiormision = new JButton("Gestionar Misiones");


        Dimension tamañoBoton = new Dimension(200, 50);
        botoncrear.setPreferredSize(tamañoBoton);
        botonleer.setPreferredSize(tamañoBoton);
        botonactualizar.setPreferredSize(tamañoBoton);
        botoneliminar.setPreferredSize(tamañoBoton);
        botongestiormision.setPreferredSize(tamañoBoton);

        panelCentral.add(botoncrear);
        panelCentral.add(botonleer);
        panelCentral.add(botonactualizar);
        panelCentral.add(botoneliminar);
        panelCentral.add(botongestiormision);
        
        botoncrear.addActionListener(e -> CambiarPanelCrearSoldado());
        botonleer.addActionListener(e -> cambiarpanelleer());
        botonactualizar.addActionListener(e -> cambiarpanelactializar());
        botoneliminar.addActionListener(e -> cambiarpanelEliminar());
        botongestiormision.addActionListener(e -> cambiarpanelGestionarMisiones());


        // Panel Crear Soldado///////////////////////////////////////////////

        panelCrearsoldado = new JPanel(new GridLayout(0, 1));
        panelCrearsoldado.setBorder(BorderFactory.createTitledBorder("Crear Soldado"));
        JLabel labelNombre = new JLabel("SISTEMA CREACION DE SOLDADOS:");
        nombredelsoldado = new JTextField();
        IDdelsoldado = new JTextField();
        grupoRangos = new ButtonGroup();        
        botonrango1 = new JRadioButton("soldado raso");
        botonrango2 = new JRadioButton("teniente");
        botonrango3 = new JRadioButton("capitan");
        botonrango4 = new JRadioButton("coronel");

        grupoRangos.add(botonrango1);
        grupoRangos.add(botonrango2);
        grupoRangos.add(botonrango3);
        grupoRangos.add(botonrango4);

        bombon = new JButton("Crear Soldado");
        bombon.addActionListener(e -> funcionarCrearsoldado());
        panelCrearsoldado.add(labelNombre);
        panelCrearsoldado.add(new JLabel("Nombre:"));
        panelCrearsoldado.add(nombredelsoldado);
        panelCrearsoldado.add(new JLabel("ID:"));
        panelCrearsoldado.add(IDdelsoldado);
        panelCrearsoldado.add(new JLabel("Rango:"));
        panelCrearsoldado.add(botonrango1);
        panelCrearsoldado.add(botonrango2);
        panelCrearsoldado.add(botonrango3);
        panelCrearsoldado.add(botonrango4);
        panelCrearsoldado.add(bombon);

        // Panel leer SOLDADO/////////////////////////////////////////////// 

        panelleer= new JPanel(new GridLayout(0, 1));
        panelleer.setBorder(BorderFactory.createTitledBorder("Leer Soldado"));
        JLabel labelNombre3 = new JLabel("SISTEMA LECTURA DE SOLDADOS:");
        

        

        // Panel ACTUALIZAR SOLDADO/////////////////////////////////////////////// 

        panelactualizar = new JPanel(new GridLayout(0, 1));
        panelactualizar.setBorder(BorderFactory.createTitledBorder("Actualizar Soldado"));
        JLabel labelNombre2 = new JLabel("SISTEMA ACTUALIZACION DE SOLDADOS:");
        TextobuscarID = new JTextField();
        buscarID = new JButton("Buscar Soldado");
        buscarID.addActionListener(e -> funcionActualizar());
        panelactualizar.add(TextobuscarID);
        panelactualizar.add(labelNombre2);
        panelactualizar.add(buscarID);
        // PANEL ELIMINAR SOLDADO///////////////////////////////////////////////

        panelelimiar = new JPanel(new GridLayout(0, 1));
        panelelimiar.setBorder(BorderFactory.createTitledBorder("Actualizar Soldado"));
        JLabel Etiqueta_eliminar = new JLabel("SISTEMA ELIMINACION DE SOLDADOS:");
        BuscarEliminar = new JTextField();
        JButton botonEliminarSoldado = new JButton("Eliminar Soldado");
        botonEliminarSoldado.addActionListener(e -> funcionEliminar());
        panelelimiar.add(Etiqueta_eliminar);
        panelelimiar.add(BuscarEliminar);
        panelelimiar.add(botonEliminarSoldado);

        /////////////////////////// PANEL GESTIONAR MISIONES //////////////////////////////////////////
        gestionarmisionesPrincipal = new JPanel(new GridLayout(0, 1));
        gestionarmisionesPrincipal.setBorder(BorderFactory.createTitledBorder("Gestionar Misiones"));
        JButton boton_asignarmision = new JButton("Asignar Mision");
        JButton boton_reportarestado = new JButton("Reportar Estado");
        JButton boton_realizarregaño = new JButton("Regañar Soldado");
        boton_asignarmision.addActionListener(e -> funcionGestionarMisiones());
        gestionarmisionesPrincipal.add(boton_asignarmision);
        gestionarmisionesPrincipal.add(boton_reportarestado);
        gestionarmisionesPrincipal.add(boton_realizarregaño);
        boton_realizarregaño.addActionListener(e -> cambiarpanelregañar());

        ///////////////////////////PANEL GESTIONAR MISIONES - REGAÑAR////////////////////////////////////////
        panelRegañar = new JPanel(new GridLayout(0, 1));
        panelRegañar.setBorder(BorderFactory.createTitledBorder("Regañar Soldado"));
        JLabel labelRegañar = new JLabel("regañador:");
        IDRegañador = new JTextField();
        botonRegañar = new JButton("Regañar");
        botonRegañar.addActionListener(e -> funcionRegañar(3));
        panelRegañar.add(labelRegañar);
        panelRegañar.add(IDRegañador);
        panelRegañar.add(botonRegañar);


        
///////////////////////////////////////PANELES////////////////////////////////////////
        mainPanel.add(panelCentral, "panelCentral");
        mainPanel.add(panelCrearsoldado, "panelCrearsoldado");
        mainPanel.add(panelactualizar, "panelactualizar");
        mainPanel.add(panelelimiar, "panelelimiar");
        mainPanel.add(gestionarmisionesPrincipal, "mainpanel2");
        mainPanel.add(panelRegañar, "panelRegañar");
        mainPanel.add(panelleer, "panelleer");
        frame.setVisible(true);        
        panelCentral.setVisible(true);
        panelCrearsoldado.setVisible(false);
        panelactualizar.setVisible(false);
        panelelimiar.setVisible(false);
        gestionarmisionesPrincipal.setVisible(false);
        panelRegañar.setVisible(false);
        panelleer.setVisible(false);
    }
    public static void actualizarLista() {
        modelo.clear(); // Limpia el modelo antes de agregar nuevos elementos
        for (Soldado soldado : App.soldados) {
            modelo.addElement(soldado); // Añade los soldados al modelo
        }
        SoldadoJlist.setModel(modelo); // Actualiza el modelo de la JList
    }

    public static void CambiarPanelCrearSoldado() {
        panelCentral.setVisible(false);
        panelCrearsoldado.setVisible(true);
    }

    public void funcionarCrearsoldado() {
        String nombreVisual = nombredelsoldado.getText();
        String idVisual = IDdelsoldado.getText();
        if (botonrango1.isSelected())
            try {
                int rango = 1;
                int id = Integer.parseInt(idVisual);
                App.crearSoldado(nombreVisual, id, rango); // Llama al método modificado
                JOptionPane.showMessageDialog(panelCrearsoldado, "Soldado creado exitosamente.");
                actualizarLista(); // Actualizar la lista visual
                panelCrearsoldado.setVisible(false);
                panelCentral.setVisible(true);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(panelCrearsoldado, "ID y Rango deben ser números.", "Error", JOptionPane.ERROR_MESSAGE);
                } 
        
        else if (botonrango2.isSelected())
            try {
                int rango = 2;
                int id = Integer.parseInt(idVisual);
                App.crearSoldado(nombreVisual, id, rango); // Llama al método modificado
                JOptionPane.showMessageDialog(panelCrearsoldado, "Soldado creado exitosamente.");
                actualizarLista(); // Actualizar la lista visual
                panelCrearsoldado.setVisible(false);
                panelCentral.setVisible(true);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(panelCrearsoldado, "ID y Rango deben ser números.", "Error", JOptionPane.ERROR_MESSAGE);
                } 
        else if (botonrango3.isSelected())
            try {
                int rango = 3;
                int id = Integer.parseInt(idVisual);
                App.crearSoldado(nombreVisual, id, rango); // Llama al método modificado
                JOptionPane.showMessageDialog(panelCrearsoldado, "Soldado creado exitosamente.");
                actualizarLista(); // Actualizar la lista visual
                panelCrearsoldado.setVisible(false);
                panelCentral.setVisible(true);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(panelCrearsoldado, "ID y Rango deben ser números.", "Error", JOptionPane.ERROR_MESSAGE);
                } 
        else if (botonrango4.isSelected())
            try {
                int rango = 4;
                int id = Integer.parseInt(idVisual);
                App.crearSoldado(nombreVisual, id, rango); // Llama al método modificado
                JOptionPane.showMessageDialog(panelCrearsoldado, "Soldado creado exitosamente.");
                actualizarLista(); // Actualizar la lista visual
                panelCrearsoldado.setVisible(false);
                panelCentral.setVisible(true);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(panelCrearsoldado, "ID y Rango deben ser números.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    } 
            
    public static void cambiarpanelactializar() {
        panelCentral.setVisible(false);
        panelactualizar.setVisible(true);
    } 
    
    public static void funcionActualizar() {
        String ID = TextobuscarID.getText();
        int IDbuscar = Integer.parseInt(ID);
        App.actSoldado(IDbuscar); // Llama al método modificado
    }
    public static void cambiarpanelEliminar() {
        panelCentral.setVisible(false);
        panelelimiar.setVisible(true);
    }

    public static void funcionEliminar() {
        String eliminar = BuscarEliminar.getText();
        int IDaeliminar = Integer.parseInt(eliminar);
        App.borrarSoldado(IDaeliminar); // Llama al método modificado
    }
    
    public static void cambiarpanelGestionarMisiones() {
        panelCentral.setVisible(false);
        gestionarmisionesPrincipal.setVisible(true);
    }

    public static void funcionGestionarMisiones() {

    }     
    public static void cambiarpanelregañar() {

        panelRegañar.setVisible(true);
        gestionarmisionesPrincipal.setVisible(false);

    }

    public static void funcionRegañar(int opcion) {
        String ID = IDRegañador.getText();
        int IDRegañar = Integer.parseInt(ID);
        botonRegañar.setVisible(false);
        App.misiones(opcion,IDRegañar); // Llama al método modificado
    }
    public static void cambiarpanelleer() {
        if (panelIzquierdo != null) {
            panelCentral.setVisible(false);
            panelleer.setVisible(true);
    
            // Quitar y volver a agregar el panelIzquierdo
            frame.remove(panelIzquierdo);
            frame.add(panelIzquierdo, BorderLayout.CENTER);
    
            frame.revalidate();
            frame.repaint();
        } else {
            System.err.println("Error: panelIzquierdo no está inicializado.");
        }
    }
    
    
}



