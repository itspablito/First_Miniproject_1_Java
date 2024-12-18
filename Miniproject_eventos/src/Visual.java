import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Soldado_Principal.Soldado;
import Soldados.Capitan;
import Soldados.Coronel;
import Soldados.SoldadoRaso;
import Soldados.Teniente;

import java.util.ArrayList;
import java.util.List;


public class Visual extends JFrame {
    
	public static JFrame frame;
    public static JList<Soldado> SoldadoJlist, SoldadoJlist2;
    public static DefaultListModel<Soldado> modelo;
    private JButton botoncrear, botonleer, botonactualizar, botoneliminar, botongestiormision;
    public static JPanel panelCentral, panelCrearsoldado, panelactualizar, paneleliminar, gestionarmisionesPrincipal, panelIzquierdo, panelRegañar, panelleer, panelAsignarMision;
    public static JLabel Nombreactualizar,labelNombre2;
    public static JTextField nombredelsoldado, IDdelsoldado, TextobuscarID, BuscarEliminar, IDRegañador,IDRegañado, IDAsignador;
    public static JButton bombon, buscarID,boton_asignarmision, boton_reportarestado, boton_realizarregaño, botonRegañar, volvercentral, volvercentral2;
    public static ButtonGroup  grupoRangos;
    public static JTable tablaSoldados;
    public static DefaultTableModel modeloTabla;
    public static JRadioButton botonrango1, botonrango2, botonrango3, botonrango4;
    public static JScrollPane scroll, scroll1;
    
    public void sisas(List<Soldado> soldados) {
        Color gris = new Color(53, 53, 53);

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
        Font font = new Font("Arial", Font.PLAIN, 11);
        SoldadoJlist.setFont(font);
        SoldadoJlist.setForeground(Color.WHITE);
        SoldadoJlist.setBackground(gris);
        SoldadoJlist.setBorder(null);
        
        panelIzquierdo = new JPanel(new BorderLayout());
        panelIzquierdo.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.WHITE),  // Color del borde
            "Listado de Soldados",                       // Título del borde
            TitledBorder.LEFT,                           // Alineación del título
            TitledBorder.TOP,                            // Ubicación del título
            new Font("Arial", Font.BOLD, 16),            // Fuente del título
            Color.WHITE                                  // Color del título
        ));
        panelIzquierdo.setPreferredSize(new Dimension(300, 1080));
        scroll.setBorder(BorderFactory.createEmptyBorder());
        panelIzquierdo.add(scroll,BorderLayout.CENTER);
        panelIzquierdo.setBackground(gris);
        
        volvercentral = new JButton("Volver");
        ImageIcon icono = new ImageIcon("Miniproject_eventos\\src\\Images\\Fondo_Botones.jpg"); // Carga la imagen del botón
        Image imagen = icono.getImage().getScaledInstance(313, 213, Image.SCALE_SMOOTH);
        volvercentral.setIcon(new ImageIcon(imagen)); // Establece la imagen en el botón
        

        // Personaliza la posición del texto en relación con la imagen
        volvercentral.setHorizontalTextPosition(SwingConstants.CENTER); // Texto centrado horizontalmente
        volvercentral.setVerticalTextPosition(SwingConstants.CENTER);   // Texto centrado verticalmente
        volvercentral.setContentAreaFilled(false); // Hace transparente el área de contenido
        
        volvercentral.setFocusPainted(false); // Elimina el enfoque visual del botón
        volvercentral.setFont(new Font("Bebas Neue", Font.BOLD, 20)); // Establece la fuente
        volvercentral.setForeground(gris); // Color del texto
        volvercentral.setPreferredSize(new Dimension(ABORT, 50));// Establece el tamaño del botón
        panelIzquierdo.add(volvercentral, BorderLayout.SOUTH);
        volvercentral.addActionListener(e -> cambiarpanelcentral());
        
        


        
        frame.add(panelIzquierdo, BorderLayout.WEST);
        

        JPanel mainPanel = new JPanel(new CardLayout());
        frame.add(mainPanel, BorderLayout.CENTER);
        
        /////////////////// Panel Central ///////////////////////////////////////////
        
        Visual.panelCentral = new JPanel();
        Visual.panelCentral = agregarFondo("Miniproject_eventos\\src\\Images\\Fondo1.jpg");
        Visual.panelCentral.setLayout(null);
        Visual.panelCentral.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.WHITE),  // Color del borde
            "Menu Principal",                       // Título del borde
            TitledBorder.LEFT,                           // Alineación del título
            TitledBorder.TOP,                            // Ubicación del título
            new Font("Arial", Font.BOLD, 16),            // Fuente del título
            Color.WHITE                                  // Color del título
        ));
        


        JLabel labelNombre_1 = new JLabel("MENU PRINCIPAL");
        labelNombre_1.setFont(new Font("Arial", Font.BOLD, 40));
        labelNombre_1.setForeground(gris);
        labelNombre_1.setHorizontalAlignment(SwingConstants.CENTER);
        labelNombre_1.setBounds(0,0,1200,100);  // Posición y tamaño de la etiqueta


        
        botoncrear = new JButton("Crear Soldado");
        botonleer = new JButton("Leer Soldado");
        botonactualizar = new JButton("Actualizar Soldado");
        botoneliminar = new JButton("Eliminar Soldado");
        botongestiormision = new JButton("Gestionar Misiones");


        botoncrear.setIcon(new ImageIcon(imagen)); // Establece la imagen en el botón
        botoncrear.setHorizontalTextPosition(SwingConstants.CENTER); // Texto centrado horizontalmente
        botoncrear.setVerticalTextPosition(SwingConstants.CENTER);   // Texto centrado verticalmente
        botoncrear.setContentAreaFilled(false); // Hace transparente el área de contenido
        botoncrear.setFocusPainted(false); // Elimina el enfoque visual del botón
        botoncrear.setFont(new Font("Bebas Neue", Font.BOLD, 20));
        botoncrear.setForeground(gris); // Color del texto

        botonleer.setIcon(new ImageIcon(imagen)); // Establece la imagen en el botón
        botonleer.setHorizontalTextPosition(SwingConstants.CENTER); // Texto centrado horizontalmente
        botonleer.setVerticalTextPosition(SwingConstants.CENTER);   // Texto centrado verticalmente
        botonleer.setContentAreaFilled(false); // Hace transparente el área de contenido
        botonleer.setFocusPainted(false); // Elimina el enfoque visual del botón
        botonleer.setFont(new Font("Bebas Neue", Font.BOLD, 20));
        botonleer.setForeground(gris); // Color del texto

        botonactualizar.setIcon(new ImageIcon(imagen)); // Establece la imagen en el botón
        botonactualizar.setHorizontalTextPosition(SwingConstants.CENTER); // Texto centrado horizontalmente
        botonactualizar.setVerticalTextPosition(SwingConstants.CENTER);   // Texto centrado verticalmente
        botonactualizar.setContentAreaFilled(false); // Hace transparente el área de contenido
        botonactualizar.setFocusPainted(false); // Elimina el enfoque visual del botón
        botonactualizar.setFont(new Font("Bebas Neue", Font.BOLD, 20));
        botonactualizar.setForeground(gris); // Color del texto

        botoneliminar.setIcon(new ImageIcon(imagen)); // Establece la imagen en el botón
        botoneliminar.setHorizontalTextPosition(SwingConstants.CENTER); // Texto centrado horizontalmente
        botoneliminar.setVerticalTextPosition(SwingConstants.CENTER);   // Texto centrado verticalmente
        botoneliminar.setContentAreaFilled(false); // Hace transparente el área de contenido
        botoneliminar.setFocusPainted(false); // Elimina el enfoque visual del botón
        botoneliminar.setFont(new Font("Bebas Neue", Font.BOLD, 20));
        botoneliminar.setForeground(gris); // Color del texto

        botongestiormision.setIcon(new ImageIcon(imagen)); // Establece la imagen en el botón
        botongestiormision.setHorizontalTextPosition(SwingConstants.CENTER); // Texto centrado horizontalmente
        botongestiormision.setVerticalTextPosition(SwingConstants.CENTER);   // Texto centrado verticalmente
        botongestiormision.setContentAreaFilled(false); // Hace transparente el área de contenido
        botongestiormision.setFocusPainted(false); // Elimina el enfoque visual del botón
        botongestiormision.setFont(new Font("Bebas Neue", Font.BOLD, 20));
        botongestiormision.setForeground(gris); // Color del texto

        //Ajuste de tamaño y posicion de los Botones
        botoncrear.setBounds(50, 500, 175, 50);
        botonleer.setBounds(250, 500, 175, 50);
        botonactualizar.setBounds(450, 500, 225, 50);
        botoneliminar.setBounds(700, 500, 200, 50);
        botongestiormision.setBounds(925, 500, 225, 51);


        Visual.panelCentral.add(labelNombre_1);
        Visual.panelCentral.add(botoncrear);
        Visual.panelCentral.add(botonleer);
        Visual.panelCentral.add(botonactualizar);
        Visual.panelCentral.add(botoneliminar);
        Visual.panelCentral.add(botongestiormision);
        

        
        botoncrear.addActionListener(e -> CambiarPanelCrearSoldado());
        botonleer.addActionListener(e -> cambiarpanelleer());
        botonactualizar.addActionListener(e -> cambiarpanelactializar());
        botoneliminar.addActionListener(e -> cambiarpanelEliminar());
        botongestiormision.addActionListener(e -> cambiarpanelGestionarMisiones());

        mainPanel.add(panelCentral, "panelCentral");
        frame.setVisible(true);
        
        
        
        //////////////////////////// Panel Crear Soldado ///////////////////////////////////////////////
        Visual.panelCrearsoldado = new JPanel();
        Visual.panelCrearsoldado = agregarFondo("Miniproject_eventos\\src\\Images\\Fondo2.jpg");  // Asegúrate de que esto retorne un JPanel válido
        Visual.panelCrearsoldado.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLACK),  // Color del borde
            "Menu Crear Soldados",                       // Título del borde
            TitledBorder.LEFT,                           // Alineación del título
            TitledBorder.TOP,                            // Ubicación del título
            new Font("Arial", Font.BOLD, 16),            // Fuente del título
            Color.BLACK                                 // Color del título
        ));
        Visual.panelCrearsoldado.setLayout(null);// Establecer layout nulo para el panel
        Visual.panelCrearsoldado.setPreferredSize(new Dimension(1620,1080));

        // Etiquetas y campos de texto
        JLabel labelNombre = new JLabel("SISTEMA CREACION DE SOLDADOS");
        labelNombre.setFont(new Font("Arial", Font.BOLD, 50));
        labelNombre.setForeground(gris);
        labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
        labelNombre.setBounds(50, 0, 1200, 100);  // Posición y tamaño de la etiqueta
        

        JLabel etiquetaNombre = new JLabel("Nombre Del Soldado:");
        etiquetaNombre.setFont(new Font("Arial", Font.BOLD, 30));
        etiquetaNombre.setForeground(gris);
        etiquetaNombre.setBounds(50, 150, 500, 50);  // Posición y tamaño de la etiqueta

        nombredelsoldado = new JTextField();
        nombredelsoldado.setFont(new Font("Arial", Font.BOLD, 40));
        nombredelsoldado.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        nombredelsoldado.setBounds(50, 200, 500, 50);  // Posición y tamaño del campo de texto
        

        JLabel etiquetaID = new JLabel("ID del Soldado:");
        etiquetaID.setFont(new Font("Arial", Font.BOLD, 30));
        etiquetaID.setForeground(gris);
        etiquetaID.setBounds(50, 250, 500, 50);  // Posición y tamaño de la etiqueta

        IDdelsoldado = new JTextField();
        IDdelsoldado.setFont(new Font("Arial", Font.BOLD, 40));
        IDdelsoldado.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        IDdelsoldado.setBounds(50, 300, 500, 50);  // Posición y tamaño del campo de texto

        
        JLabel etiquetaRango = new JLabel("Rango del Soldado:");
        etiquetaRango.setFont(new Font("Arial", Font.BOLD, 30));
        etiquetaRango.setForeground(gris);
        etiquetaRango.setBounds(50, 400, 500, 50);  // Posición y tamaño de la etiqueta

        // Botones de rango
        grupoRangos = new ButtonGroup();
        botonrango1 = new JRadioButton("Soldado Raso");
        botonrango1.setFont(new Font("Arial", Font.BOLD, 30));
        botonrango1.setForeground(gris);
        botonrango1.setOpaque(false); // Hacer transparente
        botonrango1.setBorderPainted(false); // Quitar borde
        botonrango1.setBounds(50, 450, 600, 50); // Establecer posición y tamaño

        botonrango2 = new JRadioButton("Teniente");
        botonrango2.setFont(new Font("Arial", Font.BOLD, 30));
        botonrango2.setForeground(gris);
        botonrango2.setOpaque(false); // Hacer transparente
        botonrango2.setBorderPainted(false); // Quitar borde
        botonrango2.setBounds(50, 500, 200, 50); // Establecer posición y tamaño

        botonrango3 = new JRadioButton("Capitan");
        botonrango3.setFont(new Font("Arial", Font.BOLD, 30));
        botonrango3.setForeground(gris);
        botonrango3.setOpaque(false); // Hacer transparente
        botonrango3.setBorderPainted(false); // Quitar borde
        botonrango3.setBounds(50, 550, 200, 50); // Establecer posición y tamaño

        botonrango4 = new JRadioButton("Coronel");
        botonrango4.setFont(new Font("Arial", Font.BOLD, 30));
        botonrango4.setForeground(gris);
        botonrango4.setOpaque(false); // Hacer transparente
        botonrango4.setBorderPainted(false); // Quitar borde
        botonrango4.setBounds(50, 600, 200, 50); // Establecer posición y tamaño

        // Agrupa los botones
        grupoRangos.add(botonrango1);
        grupoRangos.add(botonrango2);
        grupoRangos.add(botonrango3);
        grupoRangos.add(botonrango4);

        // Botón para crear soldado
        bombon = new JButton("Crear Soldado");
        bombon.setIcon(new ImageIcon(imagen)); // Establece la imagen en el botón
        bombon.setHorizontalTextPosition(SwingConstants.CENTER); // Texto centrado horizontalmente
        bombon.setVerticalTextPosition(SwingConstants.CENTER);   // Texto centrado verticalmente
        bombon.setContentAreaFilled(false); // Hace transparente el área de contenido
        bombon.setFocusPainted(false); // Elimina el enfoque visual del botón
        bombon.setFont(new Font("Bebas Neue", Font.BOLD, 20));
        bombon.setForeground(gris); // Color del texto
        bombon.setBounds(500, 670, 200, 50); 
        bombon.addActionListener(e -> funcionarCrearsoldado());

        // Agrega todos los componentes al panel principal
        Visual.panelCrearsoldado.add(labelNombre);
        Visual.panelCrearsoldado.add(etiquetaNombre);
        Visual.panelCrearsoldado.add(nombredelsoldado);
        Visual.panelCrearsoldado.add(etiquetaID);
        Visual.panelCrearsoldado.add(IDdelsoldado);
        Visual.panelCrearsoldado.add(etiquetaRango);
        Visual.panelCrearsoldado.add(botonrango1);
        Visual.panelCrearsoldado.add(botonrango2);
        Visual.panelCrearsoldado.add(botonrango3);
        Visual.panelCrearsoldado.add(botonrango4);
        Visual.panelCrearsoldado.add(bombon); // El botón directamente al panel principal

                
        /////////////////////////////////////////////// Panel leer SOLDADO /////////////////////////////////////////////// 
        // Crear el panel y asignar fondo
        Visual.panelleer = agregarFondo("Miniproject_eventos\\src\\Images\\Fondo Lectura.jpg");  // Asegúrate de que esto retorne un JPanel válido
        Visual.panelleer.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLACK),  // Color del borde
            "Menu Leer Soldados",                         // Título del borde
            TitledBorder.LEFT,                            // Alineación del título
            TitledBorder.TOP,                             // Ubicación del título
            new Font("Arial", Font.BOLD, 16),             // Fuente del título
            Color.BLACK                                   // Color del título
        ));
        Visual.panelleer.setLayout(null);

        // Etiqueta del título del panel
        JLabel labelNombre3 = new JLabel("SISTEMA LECTURA DE SOLDADOS");
        labelNombre3.setFont(new Font("Arial", Font.BOLD, 40));
        labelNombre3.setForeground(gris);
        labelNombre3.setBounds(450, 0, 1200, 100);
        Visual.panelleer.add(labelNombre3);

        String[] columnas = {"ID", "Nombre", "Rango", "Unidad", "Soldados Bajo Mando", "Estrategia Militar"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace que todas las celdas no sean editables
            }
        };


        // Crear la tabla con el modelo y personalizarla
        tablaSoldados = new JTable(modeloTabla);
        tablaSoldados.setFont(new Font("Arial", Font.BOLD, 15));
        tablaSoldados.setRowHeight(20);
        tablaSoldados.getTableHeader().setReorderingAllowed(false); // Deshabilitar movimiento de columnas



        

        // Personalizar el encabezado de la tabla también
        tablaSoldados.getTableHeader().setFont(new Font("Arial", Font.BOLD, 22)); // Encabezado en negrilla
        tablaSoldados.getTableHeader().setReorderingAllowed(false); // Evitar mover las columnas

        // Crear un renderizador personalizado para el contenido
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setFont(new Font("Arial", Font.BOLD, 20)); // Fuente negrilla para las celdas
        renderer.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el contenido si lo deseas
        tablaSoldados.setDefaultRenderer(Object.class, renderer);



        // Llenar la tabla con los datos de los soldados
        for (Soldado s : App.soldados) {
            if (s instanceof Teniente) {
                Teniente t = (Teniente) s;
                modeloTabla.addRow(new Object[]{s.getID(), s.getNombresoldado(), s.rango, t.getUnidad(), "NO APLICA", "NO APLICA"});
            } else if (s instanceof Capitan) {
                Capitan c = (Capitan) s;
                modeloTabla.addRow(new Object[]{s.getID(), s.getNombresoldado(), s.rango, "NO APLICA", c.getCantidadSoldadosBajoSuMando(), "NO APLICA"});
            } else if (s instanceof Coronel) {
                Coronel c = (Coronel) s;
                modeloTabla.addRow(new Object[]{s.getID(), s.getNombresoldado(), s.rango, "NO APLICA", "NO APLICA", c.getEstrategiaMilitar()});
            } else {
                modeloTabla.addRow(new Object[]{s.getID(), s.getNombresoldado(), s.rango, "NO APLICA", "NO APLICA", "NO APLICA"});
            }
        }

        // Agregar la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(tablaSoldados);
        scrollPane.setBounds(50, 80, 1440, 630);
        Visual.panelleer.add(scrollPane);

        // Botón "Volver"
        volvercentral2 = new JButton("Volver");
        volvercentral2.setIcon(icono); // Asegúrate de tener una ruta válida para el icono
        volvercentral2.setHorizontalTextPosition(SwingConstants.CENTER);
        volvercentral2.setVerticalTextPosition(SwingConstants.CENTER);
        volvercentral2.setContentAreaFilled(false);
        volvercentral2.setFocusPainted(false);
        volvercentral2.setFont(new Font("Bebas Neue", Font.BOLD, 20));
        volvercentral2.setForeground(gris);
        volvercentral2.setBounds(690, 720, 200, 50);
        Visual.panelleer.add(volvercentral2);

        // Acción del botón "Volver"
        volvercentral2.addActionListener(e -> cambiarpanelcentral());

        // Actualizar el panel
        Visual.panelleer.revalidate();
        Visual.panelleer.repaint();


        ////////////////////////////////////////// Panel ACTUALIZAR SOLDADO/////////////////////////////////////////////// 

        Visual.panelactualizar = new JPanel();
        Visual.panelactualizar = agregarFondo("Miniproject_eventos\\src\\Images\\Fondo3.jpg");
        Visual.panelactualizar.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLACK),  // Color del borde
            "Actualizar Soldados",                       // Título del borde
            TitledBorder.LEFT,                           // Alineación del título
            TitledBorder.TOP,                            // Ubicación del título
            new Font("Arial", Font.BOLD, 16),            // Fuente del título
            Color.BLACK                                 // Color del título
        ));
        Visual.panelactualizar.setLayout(null);
        labelNombre2 = new JLabel("SISTEMA ACTUALIZACION DE SOLDADOS");
        labelNombre2.setFont(new Font("Arial", Font.BOLD, 40));
        labelNombre2.setBounds(220, 0, 1200, 100);

        Nombreactualizar = new JLabel("ID del Soldado:");
        Nombreactualizar.setFont(new Font("Arial", Font.BOLD, 20));
        Nombreactualizar.setBounds(50, 150, 500, 50);


        TextobuscarID = new JTextField();
        TextobuscarID.setFont(new Font("Arial", Font.BOLD, 40));
        TextobuscarID.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        TextobuscarID.setBounds(50, 200, 500, 50);


        buscarID = new JButton("Buscar Soldado");
        buscarID.setIcon(icono); // Establece la imagen en el botón
        buscarID.setHorizontalTextPosition(SwingConstants.CENTER); // Texto centrado horizontalmente
        buscarID.setVerticalTextPosition(SwingConstants.CENTER);   // Texto centrado verticalmente
        buscarID.setContentAreaFilled(false); // Hace transparente el área de contenido
        buscarID.setFocusPainted(false); // Elimina el enfoque visual del botón
        buscarID.setFont(new Font("Bebas Neue", Font.BOLD, 20));
        buscarID.setForeground(gris); // Color del texto
        buscarID.setBounds(50, 300, 300, 50);
        
        buscarID.addActionListener(e -> funcionActualizar());
        Visual.panelactualizar.add(labelNombre2);
        Visual.panelactualizar.add(Nombreactualizar);
        Visual.panelactualizar.add(TextobuscarID);
        Visual.panelactualizar.add(buscarID);
        


        ///////////////////////////////////// PANEL ELIMINAR SOLDADO///////////////////////////////////////////////

        Visual.paneleliminar = new JPanel();
        Visual.paneleliminar = agregarFondo("Miniproject_eventos\\src\\Images\\Fondo4.jpg");
        Visual.paneleliminar.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.WHITE),  // Color del borde
            "Eliminar Soldados",                       // Título del borde
            TitledBorder.LEFT,                           // Alineación del título
            TitledBorder.TOP,                            // Ubicación del título
            new Font("Arial", Font.BOLD, 16),            // Fuente del título
            Color.WHITE                                 // Color del título
        ));
        Visual.paneleliminar.setLayout(null);

        JLabel Etiqueta_eliminar = new JLabel("SISTEMA ELIMINACION DE SOLDADOS");
        Etiqueta_eliminar.setFont(new Font("Arial", Font.BOLD, 30));
        Etiqueta_eliminar.setForeground(Color.WHITE);
        Etiqueta_eliminar.setBounds(300, 0, 1200, 100);

        //Poner el color de la fuente del siguien label en color white

        JLabel IDBuscarEliminar = new JLabel("ID del Soldado:");
        IDBuscarEliminar.setFont(new Font("Arial", Font.BOLD, 20));
        IDBuscarEliminar.setForeground(Color.WHITE);
        IDBuscarEliminar.setBounds(50, 150, 500, 50);

        BuscarEliminar = new JTextField();
        BuscarEliminar.setFont(new Font("Arial", Font.BOLD, 40));
        BuscarEliminar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        BuscarEliminar.setBounds(50, 200, 500, 50);

        JButton botonEliminarSoldado = new JButton("Eliminar Soldado");
        botonEliminarSoldado.setIcon(icono); // Establece la imagen en el botón
        botonEliminarSoldado.setHorizontalTextPosition(SwingConstants.CENTER); // Texto centrado horizontalmente
        botonEliminarSoldado.setVerticalTextPosition(SwingConstants.CENTER);   // Texto centrado verticalmente
        botonEliminarSoldado.setContentAreaFilled(false); // Hace transparente el área de contenido
        botonEliminarSoldado.setFocusPainted(false); // Elimina el enfoque visual del botón
        botonEliminarSoldado.setFont(new Font("Bebas Neue", Font.BOLD, 20));
        botonEliminarSoldado.setForeground(gris); // Color del texto
        botonEliminarSoldado.setBounds(50, 300, 300, 50);
        botonEliminarSoldado.addActionListener(e -> funcionEliminar());


        Visual.paneleliminar.add(Etiqueta_eliminar);
        Visual.paneleliminar.add(IDBuscarEliminar);
        Visual.paneleliminar.add(BuscarEliminar);
        Visual.paneleliminar.add(botonEliminarSoldado);    
        

        /////////////////////////// PANEL GESTIONAR MISIONES //////////////////////////////////////////
        
        Visual.gestionarmisionesPrincipal = new JPanel();
        Visual.gestionarmisionesPrincipal = agregarFondo("Miniproject_eventos\\src\\Images\\Fondo5.jpg");
        Visual.gestionarmisionesPrincipal.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLACK),  // Color del borde
            "Gestionar Misiones",                       // Título del borde
            TitledBorder.LEFT,                           // Alineación del título
            TitledBorder.TOP,                            // Ubicación del título
            new Font("Arial", Font.BOLD, 16),            // Fuente del título
            Color.BLACK                                 // Color del título
        ));
        Visual.gestionarmisionesPrincipal.setLayout(null);

        JLabel tituloGestionarMisiones = new JLabel("SISTEMA GESTION DE MISIONES");
        tituloGestionarMisiones.setFont(new Font("Arial", Font.BOLD, 30));
        tituloGestionarMisiones.setForeground(Color.WHITE);
        tituloGestionarMisiones.setBounds(350, 0, 1100, 100);

        JButton boton_asignarmision = new JButton("Asignar Mision");
        boton_asignarmision.setIcon(icono);
        boton_asignarmision.setHorizontalTextPosition(SwingConstants.CENTER);
        boton_asignarmision.setVerticalTextPosition(SwingConstants.CENTER);
        boton_asignarmision.setContentAreaFilled(false);
        boton_asignarmision.setFocusPainted(false);
        boton_asignarmision.setFont(new Font("Bebas Neue", Font.BOLD, 20));
        boton_asignarmision.setForeground(gris);
        boton_asignarmision.setBounds(300, 150, 200, 50);
        
        JButton boton_reportarestado = new JButton("Reportar Estado");
        boton_reportarestado.setIcon(icono);
        boton_reportarestado.setHorizontalTextPosition(SwingConstants.CENTER);
        boton_reportarestado.setVerticalTextPosition(SwingConstants.CENTER);
        boton_reportarestado.setContentAreaFilled(false);
        boton_reportarestado.setFocusPainted(false);   
        boton_reportarestado.setFont(new Font("Bebas Neue", Font.BOLD, 20));
        boton_reportarestado.setForeground(gris);
        boton_reportarestado.setBounds(300, 250, 200, 50);

        JButton boton_realizarregaño = new JButton("Regañar Soldado");
        boton_realizarregaño.setIcon(icono);
        boton_realizarregaño.setHorizontalTextPosition(SwingConstants.CENTER);
        boton_realizarregaño.setVerticalTextPosition(SwingConstants.CENTER);
        boton_realizarregaño.setContentAreaFilled(false);
        boton_realizarregaño.setFocusPainted(false);
        boton_realizarregaño.setFont(new Font("Bebas Neue", Font.BOLD, 20));
        boton_realizarregaño.setBounds(300, 350, 200, 50);   


        boton_asignarmision.addActionListener(e -> cambiarpanelAsignarmisiones());
        Visual.gestionarmisionesPrincipal.add(tituloGestionarMisiones);
        Visual.gestionarmisionesPrincipal.add(boton_asignarmision);
        Visual.gestionarmisionesPrincipal.add(boton_reportarestado);
        Visual.gestionarmisionesPrincipal.add(boton_realizarregaño);
        boton_realizarregaño.addActionListener(e -> cambiarpanelregañar());
        boton_reportarestado.addActionListener(e -> reportarEstado());

        ///////////////////////////PANEL GESTIONAR MISIONES - ASIGNAR MISION////////////////////////////////////////
        
        Visual.panelAsignarMision = new JPanel();
        Visual.panelAsignarMision = agregarFondo("Miniproject_eventos\\src\\Images\\Fondo5.jpg");
        Visual.panelAsignarMision.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLACK),  // Color del borde
            "Gestionar Misiones",                       // Título del borde
            TitledBorder.LEFT,                           // Alineación del título
            TitledBorder.TOP,                            // Ubicación del título
            new Font("Arial", Font.BOLD, 16),            // Fuente del título
            Color.BLACK                                 // Color del título
        ));
        Visual.panelAsignarMision.setLayout(null);

        JLabel tituloAsignarMision = new JLabel("SISTEMA ASIGNACION DE MISIONES");
        tituloAsignarMision.setFont(new Font("Arial", Font.BOLD, 30));
        tituloAsignarMision.setForeground(Color.WHITE);
        tituloAsignarMision.setBounds(350, 0, 1100, 100);

        JLabel labelAsignarMision = new JLabel("Introduzca el ID del soldado al que se le asignará una misión:");
        labelAsignarMision.setFont(new Font("Arial", Font.BOLD, 20));
        labelAsignarMision.setForeground(Color.WHITE);
        labelAsignarMision.setBounds(50, 200, 500, 50);

        IDAsignador = new JTextField();
        IDAsignador.setFont(new Font("Arial", Font.BOLD, 40));
        IDAsignador.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        IDAsignador.setBounds(50, 250, 500, 50);


        JButton botonAsignarMision = new JButton("Asignar Mision");
        botonAsignarMision.setIcon(icono);
        botonAsignarMision.setHorizontalTextPosition(SwingConstants.CENTER);
        botonAsignarMision.setVerticalTextPosition(SwingConstants.CENTER);
        botonAsignarMision.setContentAreaFilled(false);
        botonAsignarMision.setFocusPainted(false);
        botonAsignarMision.setFont(new Font("Bebas Neue", Font.BOLD, 20));
        botonAsignarMision.setForeground(gris);
        botonAsignarMision.setBounds(50, 500, 200, 50);
        botonAsignarMision.addActionListener(e -> funcionAsignarMision());

        Visual.panelAsignarMision.add(tituloAsignarMision);
        Visual.panelAsignarMision.add(labelAsignarMision);
        Visual.panelAsignarMision.add(IDAsignador);
        Visual.panelAsignarMision.add(botonAsignarMision);



        ///////////////////////////PANEL GESTIONAR MISIONES - REGAÑAR////////////////////////////////////////
        
        Visual.panelRegañar = new JPanel();
        Visual.panelRegañar = agregarFondo("Miniproject_eventos\\src\\Images\\Fondo6.jpg");
        Visual.panelRegañar.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLACK),  // Color del borde
            "Gestionar Misiones",                       // Título del borde
            TitledBorder.LEFT,                           // Alineación del título
            TitledBorder.TOP,                            // Ubicación del título
            new Font("Arial", Font.BOLD, 16),            // Fuente del título
            Color.BLACK                                 // Color del título
        ));  
        Visual.panelRegañar.setLayout(null);  

        JLabel tituloRegañar = new JLabel("SISTEMA REGAÑO DE SOLDADOS:");
        tituloRegañar.setFont(new Font("Arial", Font.BOLD, 30));
        tituloRegañar.setForeground(gris);
        tituloRegañar.setBounds(350, 0, 1100, 100);

        JLabel labelRegañar = new JLabel("Introduzca el ID del soldado que regañará:");
        labelRegañar.setFont(new Font("Arial", Font.BOLD, 20));
        labelRegañar.setForeground(Color.WHITE);   
        labelRegañar.setBounds(50, 200, 500, 50);

        IDRegañador = new JTextField();
        IDRegañador.setFont(new Font("Arial", Font.BOLD, 40));
        IDRegañador.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        IDRegañador.setBounds(50, 250, 500, 50);

        JLabel labelRegañar2 = new JLabel("Introduzca el ID del soldado a regañar:");
        labelRegañar2.setFont(new Font("Arial", Font.BOLD, 20));
        labelRegañar2.setForeground(Color.WHITE);   
        labelRegañar2.setBounds(50, 300, 500, 50);

        IDRegañado = new JTextField();
        IDRegañado.setFont(new Font("Arial", Font.BOLD, 40));
        IDRegañado.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        IDRegañado.setBounds(50, 350, 500, 50);


        botonRegañar = new JButton("Regañar");
        botonRegañar.setIcon(icono);
        botonRegañar.setHorizontalTextPosition(SwingConstants.CENTER);
        botonRegañar.setVerticalTextPosition(SwingConstants.CENTER);
        botonRegañar.setContentAreaFilled(false);
        botonRegañar.setFocusPainted(false);
        botonRegañar.setFont(new Font("Bebas Neue", Font.BOLD, 20));
        botonRegañar.setForeground(gris);
        botonRegañar.setBounds(50, 500, 200, 50);
        botonRegañar.addActionListener(e -> funcionRegañar(3));
        Visual.panelRegañar.add(tituloRegañar);
        Visual.panelRegañar.add(labelRegañar);
        Visual.panelRegañar.add(IDRegañador);
        Visual.panelRegañar.add(labelRegañar2);
        Visual.panelRegañar.add(IDRegañado);
        Visual.panelRegañar.add(botonRegañar);



        
///////////////////////////////////////PANELES////////////////////////////////////////
        mainPanel.add(panelCentral, "panelCentral");
        mainPanel.add(panelCrearsoldado, "panelCrearsoldado");
        mainPanel.add(panelactualizar, "panelactualizar");
        mainPanel.add(paneleliminar, "panelelimiar");
        mainPanel.add(gestionarmisionesPrincipal, "mainpanel2");
        mainPanel.add(panelRegañar, "panelRegañar");
        mainPanel.add(panelleer, "panelleer");
        mainPanel.add(panelAsignarMision, "panelAsignarMision");
        frame.setVisible(true);        
        panelCentral.setVisible(true);
        panelCrearsoldado.setVisible(false);
        panelactualizar.setVisible(false);
        paneleliminar.setVisible(false);
        gestionarmisionesPrincipal.setVisible(false);
        panelAsignarMision.setVisible(false);
        panelRegañar.setVisible(false);
        panelleer.setVisible(false);

    }
      
    
    public static void CambiarPanelCrearSoldado() {
        panelCentral.setVisible(false);
        Visual.panelCrearsoldado.setVisible(true);
    }
    
    public static void actualizarLista() {
        if (modeloTabla == null) {
            System.err.println("Error: modeloTabla no está inicializado.");
            return;
        }
    
        // Limpia los datos existentes
        modelo.clear();
        modeloTabla.setRowCount(0);
    
        // Actualiza los datos
        for (Soldado soldado : App.soldados) {
            modelo.addElement(soldado);
            if (soldado instanceof Teniente) {
                Teniente t = (Teniente) soldado;
                modeloTabla.addRow(new Object[]{soldado.getID(), soldado.getNombresoldado(), soldado.rango, t.getUnidad(), "NO APLICA", "NO APLICA"});
            } else if (soldado instanceof Capitan) {
                Capitan c = (Capitan) soldado;
                modeloTabla.addRow(new Object[]{soldado.getID(), soldado.getNombresoldado(), soldado.rango, "NO APLICA", c.getCantidadSoldadosBajoSuMando(), "NO APLICA"});
            } else if (soldado instanceof Coronel) {
                Coronel c = (Coronel) soldado;
                modeloTabla.addRow(new Object[]{soldado.getID(), soldado.getNombresoldado(), soldado.rango, "NO APLICA", "NO APLICA", c.getEstrategiaMilitar()});
            } else {
                modeloTabla.addRow(new Object[]{soldado.getID(), soldado.getNombresoldado(), soldado.rango, "NO APLICA", "NO APLICA", "NO APLICA"});
            }
        }
    
        // Actualiza el modelo de la lista
        SoldadoJlist.setModel(modelo);
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
                // Limpiar los campos de texto
                nombredelsoldado.setText(""); // Limpiar el campo nombre
                IDdelsoldado.setText(""); // Limpiar el campo ID
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
                // Limpiar los campos de texto
                nombredelsoldado.setText(""); // Limpiar el campo nombre
                IDdelsoldado.setText(""); // Limpiar el campo ID
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
                // Limpiar los campos de texto
                nombredelsoldado.setText(""); // Limpiar el campo nombre
                IDdelsoldado.setText(""); // Limpiar el campo ID
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
                // Limpiar los campos de texto
                nombredelsoldado.setText(""); // Limpiar el campo nombre
                IDdelsoldado.setText(""); // Limpiar el campo ID
                panelCrearsoldado.setVisible(false);
                panelCentral.setVisible(true);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(panelCrearsoldado, "ID y Rango deben ser números.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        
    public static void cambiarpanelleer() {
        if (panelIzquierdo != null) {
            panelIzquierdo.setVisible(false);
            panelCentral.setVisible(false);
            panelleer.setVisible(true);
            frame.repaint();                 // Redibuja la ventana para reflejar los cambios
            frame.revalidate(); 
            
        } else {
            System.err.println("Error: panelIzquierdo no está inicializado.");
        }
    }
            


    public static void cambiarpanelactializar() {
        TextobuscarID.setText("");
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
        paneleliminar.setVisible(true);
    }

    public static void funcionEliminar() {
        String eliminar = BuscarEliminar.getText().trim(); // Elimina los espacios al inicio y al final
        
        // Validar si el campo está vacío o contiene caracteres no numéricos
        if (eliminar.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                int IDaeliminar = Integer.parseInt(eliminar); // Intentamos convertir el texto en un número
                
                // Verificar si el ID existe en la lista de soldados
                boolean existe = App.soldadoExiste(IDaeliminar); // Asume que tienes este método en App
    
                if (existe) {
                    // Llamar al método de eliminación del soldado
                    App.borrarSoldado(IDaeliminar);
                    JOptionPane.showMessageDialog(null, "Soldado eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "El ID ingresado no se encuentra en la lista.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                // Si ocurre una excepción al intentar convertir el texto, mostramos un mensaje de error
                JOptionPane.showMessageDialog(null, "ID no válido. Asegúrese de ingresar un número.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    
    
    public static void cambiarpanelGestionarMisiones() {
        panelCentral.setVisible(false);
        gestionarmisionesPrincipal.setVisible(true);
    }

    public static void cambiarpanelAsignarmisiones() {
        panelAsignarMision.setVisible(true);
        gestionarmisionesPrincipal.setVisible(false);
        
    }   

    public static void cambiarpanelregañar() {
        panelRegañar.setVisible(true);
        gestionarmisionesPrincipal.setVisible(false);
        IDRegañador.setText("");
        IDRegañado.setText("");

    }
    
    public static void funcionAsignarMision() {
        try {
            String IDAsignadorText = IDAsignador.getText().trim();
            if (IDAsignadorText.isEmpty()) {
                JOptionPane.showMessageDialog(Visual.panelAsignarMision,
                    "Debe ingresar el ID del soldado que asignará la misión.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            int idAsignadorNumerico = Integer.parseInt(IDAsignadorText);
            Soldado soldadoAsignador = App.buscarSoldadoPorID(idAsignadorNumerico);
    
            if (soldadoAsignador == null) return;
    
            App.asignarMisionGeneral(soldadoAsignador);
    
            IDAsignador.setText("");
            cambiarpanelcentral(); // Si esta acción es necesaria
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(Visual.panelAsignarMision,
                "El ID debe ser un número válido.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    


    public static void funcionRegañar(int opcion) {
        try {
            String IDRegañadorText = IDRegañador.getText().trim(); // Obtener texto del campo del regañador
            String IDRegañadoText = IDRegañado.getText().trim(); // Obtener texto del campo del regañado
    
            // Validar que ambos campos no estén vacíos
            if (IDRegañadorText.isEmpty() || IDRegañadoText.isEmpty()) {
                JOptionPane.showMessageDialog(Visual.panelRegañar, "Debe ingresar ambos IDs.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            // Convertir ambos valores a enteros
            int IDRegañador = Integer.parseInt(IDRegañadorText);
            int IDRegañado = Integer.parseInt(IDRegañadoText);

            App.misiones(opcion, IDRegañador, IDRegañado); // Usar el ID del soldado que será regañado
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(Visual.panelRegañar, "Ambos IDs deben ser números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    

    public static void cambiarpanelcentral() {
        panelIzquierdo.setVisible(true);
        panelCentral.setVisible(true);
        panelleer.setVisible(false);
        panelCrearsoldado.setVisible(false);
        panelactualizar.setVisible(false);
        paneleliminar.setVisible(false);
        gestionarmisionesPrincipal.setVisible(false);
        panelAsignarMision.setVisible(false);
        panelRegañar.setVisible(false);


    }

    public static void panelIzquierdo() {
        panelleer.remove(panelIzquierdo);
        frame.add(panelIzquierdo, BorderLayout.WEST);
    }

    public static void reportarEstado() {
        try {
            String ID = JOptionPane.showInputDialog(gestionarmisionesPrincipal, 
                "Introduzca el ID del soldado a reportar:");
            if (ID == null) return;
    
            int IDreportar = Integer.parseInt(ID);
            Soldado soldado = App.buscarSoldadoPorID(IDreportar);
    
            if (soldado != null) {
                App.reportarEstadoGeneral(soldado);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(gestionarmisionesPrincipal,
                "El ID debe ser un número válido.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public static JPanel agregarFondo(String rutaImagen) {
        // Cargar la imagen de fondo
        ImageIcon imagenFondo = new ImageIcon(rutaImagen);
    
        // Crear un panel con fondo
        JPanel panelConFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagenFondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
    
        panelConFondo.setOpaque(true); // Hacer visible el fondo
        panelConFondo.setLayout(null);  // Mantener el layout nulo para agregar componentes manualmente
    
        return panelConFondo;
    }
    

    
    
    
    
    
}




