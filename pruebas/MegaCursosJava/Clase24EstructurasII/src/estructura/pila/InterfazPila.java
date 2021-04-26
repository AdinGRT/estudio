package estructura.pila;

/**
 *
 * @author adingrt
 */
public interface InterfazPila<E> {
    
    public void push(E elemento);
    
    public void pop();
    
    public int size();
    
    public boolean isEmpty();
    
    public E top();
    
}
