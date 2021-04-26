package dibujosgeometricos;

/**
 *
 * @author adingrt
 */
public class Recta {
    private Punto pini;
    private Punto pfinal;

    public Recta() {
    }

    public Recta(Punto pini, Punto pfinal) {
        this.pini = pini;
        this.pfinal = pfinal;
    }

    public Punto getPini() {
        return pini;
    }

    public void setPini(Punto pini) {
        this.pini = pini;
    }

    public Punto getPfinal() {
        return pfinal;
    }

    public void setPfinal(Punto pfinal) {
        this.pfinal = pfinal;
    }
    
    
}
