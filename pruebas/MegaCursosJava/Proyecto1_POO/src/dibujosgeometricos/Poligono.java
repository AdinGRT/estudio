package dibujosgeometricos;

import java.awt.Polygon;

/**
 *
 * @author adingrt
 */
public class Poligono {
    private int npuntos;
    private int[] coordX;
    private int[] coordY;

    public Poligono() {
    }

    public Poligono(int npuntos, int[] coordX, int[] coordY) {
        this.npuntos = npuntos;
        this.coordX = coordX;
        this.coordY = coordY;
    }
    
    public Polygon prepararPoligono() {
        return new Polygon(this.getCoordX(), this.getCoordY(), this.getNpuntos());
    }

    public int getNpuntos() {
        return npuntos;
    }

    public void setNpuntos(int npuntos) {
        this.npuntos = npuntos;
    }

    public int[] getCoordX() {
        return coordX;
    }

    public void setCoordX(int[] coordX) {
        this.coordX = coordX;
    }

    public int[] getCoordY() {
        return coordY;
    }

    public void setCoordY(int[] coordY) {
        this.coordY = coordY;
    }
    
    
}
