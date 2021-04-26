package dibujosgeometricos;

import javax.swing.JFrame;

/**
 *
 * @author adingrt
 */
public class Main {
    public static void main(String[] args) {
         JFrame marco = new JFrame("Nuestro Dibujo");
         marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         Dibujo paneldeDibujo = new Dibujo();
         marco.add(paneldeDibujo);
         marco.setSize(400,400);  
         marco.setVisible(true);
    }
}
