package estructura.cola;

/**
 *
 * @author adingrt
 */
public interface InterfazColaDoble<E> {
    public int size();
    public boolean isEmpty();
    public E front();
    public E tail();
    
    // Metodo Colar();
    public void enqueue(E elemento);
    
    //Metodo Descolar();
    public void dequeue();
}
