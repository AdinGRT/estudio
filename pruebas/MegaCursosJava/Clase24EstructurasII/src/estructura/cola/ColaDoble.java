package estructura.cola;

/**
 *
 * @author adingrt
 */
public class ColaDoble<E> implements InterfazColaDoble<E> {
    
    private ColaDobleNodo<E> head;
    private ColaDobleNodo<E> tail;
    private int size;
    
    public ColaDoble() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if(this.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public E front() {
        if(this.isEmpty()) {
            return null;
        } else {
            return this.head.getElemento();
        }
    }

    @Override
    public E tail() {
         if(this.isEmpty()) {
            return null;
        } else {
            return this.tail.getElemento();
        }
    }

    @Override
    public void enqueue(E elemento) {
        if(this.isEmpty()) {
            ColaDobleNodo<E> nuevoNodo = new ColaDobleNodo<E>();
            nuevoNodo.setElemento(elemento);
            nuevoNodo.setNext(null);
            nuevoNodo.setPrev(null);
            this.head = nuevoNodo;
            this.tail = nuevoNodo;
            this.size = 1;
        } else {
            ColaDobleNodo<E> nuevoNodo = new ColaDobleNodo<E>();
            nuevoNodo.setElemento(elemento);
            nuevoNodo.setPrev(this.tail);
            this.tail.setNext(nuevoNodo);
            nuevoNodo.setNext(null);
            this.tail = nuevoNodo;
            this.size++;
        }
        
    }

    @Override
    public void dequeue() {
        if(this.isEmpty()) {
            System.out.println("La Cola esta vacia");
        } else {
            this.head = this.head.getNext();
            this.size--;
        }
    }
    
}
