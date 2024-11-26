import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazEjercito {
    private JFrame frame;
    private JList<String> listaSoldados;
    private DefaultListModel<String> modeloLista;
    private JPanel panelAcciones;
    private JTextArea textArea;

    public InterfazEjercito() {
        // Configurar ventana principal
        frame = new JFrame("Gestión de Ejército");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Crear panel izquierdo: Lista de soldados
        JPanel panelIzquierdo = new JPanel(new BorderLayout());
        panelIzquierdo.setBorder(BorderFactory.createTitledBorder("Listado de Soldados"));

        modeloLista = new DefaultListModel<>();
        listaSoldados = new JList<>(modeloLista);
        JScrollPane scrollLista = new JScrollPane(listaSoldados);

        panelIzquierdo.add(scrollLista, BorderLayout.CENTER);

        // Agregar panel izquierdo a la ventana
        frame.add(panelIzquierdo, BorderLayout.WEST);

        // Crear panel central: Opciones y acciones
        panelAcciones = new JPanel();
        panelAcciones.setLayout(new GridLayout(5, 2, 10, 10)); // Botones y opciones en cuadrícula
        panelAcciones.setBorder(BorderFactory.createTitledBorder("Crear Soldado / Gestionar"));

        // Agregar botones y opciones
        agregarBotonesAcciones();

        // Crear un área para mensajes o detalles de acciones
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBorder(BorderFactory.createTitledBorder("Detalles de Operaciones"));
        JScrollPane scrollTexto = new JScrollPane(textArea);

        // Panel central que combina acciones y detalles
        JPanel panelCentral = new JPanel(new BorderLayout());
        panelCentral.add(panelAcciones, BorderLayout.CENTER);
        panelCentral.add(scrollTexto, BorderLayout.SOUTH);

        frame.add(panelCentral, BorderLayout.CENTER);

        // Crear botón de reset
        JButton botonReset = new JButton("Reset Aplicación");
        botonReset.addActionListener(e -> resetAplicacion());
        frame.add(botonReset, BorderLayout.SOUTH);

        // Hacer visible la ventana
        frame.setVisible(true);
    }

    // Método para agregar botones al panel de acciones
    private void agregarBotonesAcciones() {
        // Botón Crear Soldado
        JButton botonCrear = new JButton("Crear Soldado");
        botonCrear.addActionListener(e -> crearSoldado());
        panelAcciones.add(botonCrear);

        // Botón Leer Soldado
        JButton botonLeer = new JButton("Leer Soldado");
        botonLeer.addActionListener(e -> leerSoldado());
        panelAcciones.add(botonLeer);

        // Botón Actualizar Soldado
        JButton botonActualizar = new JButton("Actualizar Soldado");
        botonActualizar.addActionListener(e -> actualizarSoldado());
        panelAcciones.add(botonActualizar);

        // Botón Eliminar Soldado
        JButton botonEliminar = new JButton("Eliminar Soldado");
        botonEliminar.addActionListener(e -> eliminarSoldado());
        panelAcciones.add(botonEliminar);

        // Botón Gestionar Misiones
        JButton botonMisiones = new JButton("Gestionar Misiones");
        botonMisiones.addActionListener(e -> gestionarMisiones());
        panelAcciones.add(botonMisiones);
    }

    // Métodos de ejemplo para manejar las acciones
    private void crearSoldado() {
        String nombre = JOptionPane.showInputDialog(frame, "Nombre del Soldado:");
        if (nombre != null && !nombre.trim().isEmpty()) {
            modeloLista.addElement(nombre);
            textArea.append("Soldado creado: " + nombre + "\n");
        }
    }

    private void leerSoldado() {
        StringBuilder detalles = new StringBuilder("Lista de Soldados:\n");
        for (int i = 0; i < modeloLista.size(); i++) {
            detalles.append("- ").append(modeloLista.getElementAt(i)).append("\n");
        }
        textArea.append(detalles.toString());
    }

    private void actualizarSoldado() {
        String seleccionado = listaSoldados.getSelectedValue();
        if (seleccionado == null) {
            JOptionPane.showMessageDialog(frame, "Seleccione un soldado para actualizar.");
            return;
        }
        String nuevoNombre = JOptionPane.showInputDialog(frame, "Nuevo nombre para el soldado:", seleccionado);
        if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
            modeloLista.setElementAt(nuevoNombre, listaSoldados.getSelectedIndex());
            textArea.append("Soldado actualizado: " + nuevoNombre + "\n");
        }
    }

    private void eliminarSoldado() {
        String seleccionado = listaSoldados.getSelectedValue();
        if (seleccionado != null) {
            modeloLista.removeElement(seleccionado);
            textArea.append("Soldado eliminado: " + seleccionado + "\n");
        } else {
            JOptionPane.showMessageDialog(frame, "Seleccione un soldado para eliminar.");
        }
    }

    private void gestionarMisiones() {
        String seleccionado = listaSoldados.getSelectedValue();
        if (seleccionado == null) {
            JOptionPane.showMessageDialog(frame, "Seleccione un soldado para gestionar.");
            return;
        }
        textArea.append("Gestionando misiones para: " + seleccionado + "\n");
        // Aquí podrías implementar más lógica para asignar misiones.
    }

    private void resetAplicacion() {
        modeloLista.clear();
        textArea.setText("");
        textArea.append("Aplicación reiniciada.\n");
    }

    // Método principal para iniciar la interfaz
    public static void main(String[] args) {
        new InterfazEjercito();
    }
}
