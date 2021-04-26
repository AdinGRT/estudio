package dibujosgeometricos;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


/**
 *
 * @author adingrt
 */
public class Dibujo extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        
        Poligono p1 = new Poligono();
        p1.setNpuntos(4);
        int[] coxs = {150, 220, 220, 150};
        int[] coys = {300, 300, 200, 200};
        p1.setCoordX(coxs);
        p1.setCoordY(coys);
        g.setColor(Color.red);
        g.drawPolygon(p1.prepararPoligono());
        
    }
}
