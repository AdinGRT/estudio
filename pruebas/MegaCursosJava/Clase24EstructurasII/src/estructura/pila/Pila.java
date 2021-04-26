package estructura.pila;

/**
 *
 * @author adingrt
 */
public class Pila<E> implements InterfazPila<E> {

    private int size;
    private NodoPila<E> cima;
    
    public Pila() {
        this.size = 0;
        this.cima = null;
    }
    
    @Override
    public void push(E elemento) {
        if(this.isEmpty()) {
            NodoPila<E> nodoPila = new NodoPila<E>();
            nodoPila.setElemento((E) elemento);
            nodoPila.setPrev(null);
            this.cima = nodoPila;
            this.size = 1;
        } else {
            NodoPila<E> nodoPila = new NodoPila<E>();
            nodoPila.setElemento(elemento);
            nodoPila.setPrev(cima);
            this.cima = nodoPila;
            this.size = size+1;
        }
    }

    @Override
    public void pop() {
        if(this.isEmpty()) {
            System.out.println("La Pila esta vacia");
        } else {
            this.cima = this.cima.getPrev();
            this.size--;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if(this.size()==0) {
            return true;
        } else
            return false;
    }

    @Override
    public E top() {
        if(this.isEmpty()) {
            System.out.println("La Pila esta vacia");
            return null;
            
        } else {
            return this.cima.getElemento();
        }
    }
}
