package imagenes;

import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelImage extends JLabel {

    private int x, y;
    private final String path;

    public JPanelImage(JPanel panel, String path) {
        this.path = path;
        this.x = panel.getWidth();
        this.y = panel.getHeight();
        this.setSize(x, y);

        // Listener pa’ que la imagen se ajuste si cambias el tamaño del panel
        panel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                x = panel.getWidth();
                y = panel.getHeight();
                setSize(x, y);
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        ImageIcon img = new ImageIcon(path);
        if (img.getImage() != null) {
            g.drawImage(img.getImage(), 0, 0, x, y, null);
        } else {
            System.out.println("No se pudo cargar la imagen en: " + path);
        }
    }
}
