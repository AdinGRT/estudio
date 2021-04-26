package estructura.linkedlist;

/**
 *
 * @author adingrt
 */
public class NodoDoubleLinkedList<E> {
    
    private E elemento;
    private NodoDoubleLinkedList<E> prev;
    private NodoDoubleLinkedList<E> next;
    
    public NodoDoubleLinkedList() {
    }

    public E getElemento() {
        return elemento;
    }

    public void setElemento(E elemento) {
        this.elemento = elemento;
    }

    public NodoDoubleLinkedList<E> getPrev() {
        return prev;
    }

    public void setPrev(NodoDoubleLinkedList<E> prev) {
        this.prev = prev;
    }

    public NodoDoubleLinkedList<E> getNext() {
        return next;
    }

    public void setNext(NodoDoubleLinkedList<E> next) {
        this.next = next;
    }
    
}
