import javax.swing.*;
import java.awt.*;

public class PanelConFondo extends JPanel {
    private Image imagen;

    public PanelConFondo(String rutaImagen) {
        try {
            this.imagen = new ImageIcon(rutaImagen).getImage();
        } catch (Exception e) {
            System.err.println("Error al cargar la imagen: " + e.getMessage());
        }
        
        setLayout(null);  // Establece el layout a null para usar posiciones absolutas
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

