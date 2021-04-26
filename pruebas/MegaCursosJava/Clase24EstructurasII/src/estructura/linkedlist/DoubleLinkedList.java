package estructura.linkedlist;

/**
 *
 * @author adingrt
 */
public class DoubleLinkedList<E> implements InterfazDoubleLinkedList<E> {

    private NodoDoubleLinkedList<E> head;
    private NodoDoubleLinkedList<E> tail;
    private int size;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void addFirst(E elemento) {
        NodoDoubleLinkedList<E> nuevoNodo = new NodoDoubleLinkedList<E>();
        if (this.isEmpty()) {
            nuevoNodo.setElemento(elemento);
            nuevoNodo.setNext(null);
            nuevoNodo.setPrev(null);
            this.head = nuevoNodo;
            this.tail = nuevoNodo;
            this.size = 1;
        } else {
            nuevoNodo.setElemento(elemento);
            nuevoNodo.setNext(this.head);
            nuevoNodo.setPrev(null);
            this.head.setPrev(nuevoNodo);
            this.head = nuevoNodo;
            this.size++;

        }
    }

    @Override
    public void addLast(E elemento) {
        NodoDoubleLinkedList<E> nuevoNodo = new NodoDoubleLinkedList<E>();
        if (this.isEmpty()) {
            nuevoNodo.setElemento(elemento);
            nuevoNodo.setNext(null);
            nuevoNodo.setPrev(null);
            this.head = nuevoNodo;
            this.tail = nuevoNodo;
            this.size = 1;
        } else {
            nuevoNodo.setElemento(elemento);
            nuevoNodo.setNext(null);
            nuevoNodo.setPrev(this.tail);
            this.tail.setNext(nuevoNodo);
            this.tail = nuevoNodo;
            this.size++;
        }
    }

    @Override
    public void add(E elemento, int index) {
        if (index == 0) {
            this.addFirst(elemento);
        } else if (index == this.size) {
            this.addLast(elemento);
        } else if (index > this.size) {
            System.out.println("El indice no existe");
        } else {
            DoubleLinkedList<E> nuevaLista = new DoubleLinkedList<E>();
            int contador = 0;
            while (!this.isEmpty()) {
                if (index == contador) {
                    nuevaLista.addLast(elemento);
                    contador++;
                } else {
                    nuevaLista.addLast(this.getFirst());
                    this.removeFirst();
                    contador++;
                }
            }
            this.head = nuevaLista.head;
            this.tail = nuevaLista.tail;
            this.size = nuevaLista.size;
        }
    }

    @Override
    public void removeFirst() {
        if (this.isEmpty()) {
            System.out.println("La Lista esta vacia");
        } else {
            this.head = this.head.getNext();
            this.size--;
        }
    }

    @Override
    public void removeLast() {
        if (this.isEmpty()) {
            System.out.println("La Lista esta vacia");
        } else {
            this.tail = this.tail.getPrev();
            this.size--;
        }
    }

    @Override
    public void remove(int index) {
        if (index == 0) {
            this.removeFirst();
        } else if (index == this.size - 1) {
            this.removeLast();
        } else if (index > this.size) {
            System.out.println("El indice no existe");
        } else {
            DoubleLinkedList<E> nuevaLista = new DoubleLinkedList<E>();
            int contador = 0;
            while (!this.isEmpty()) {
                if (index == contador) {
                    this.removeFirst();
                    contador++;
                } else {
                    nuevaLista.addLast(this.getFirst());
                    this.removeFirst();
                    contador++;
                }
            }
            this.head = nuevaLista.head;
            this.tail = nuevaLista.tail;
            this.size = nuevaLista.size;
        }
    }

    @Override
    public boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E getFirst() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.head.getElemento();
        }
    }

    @Override
    public E getLast() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.tail.getElemento();
        }
    }

    @Override
    public E get(int index) {
        
        if (index == 0) {
            return this.getFirst();
        } else if (index == this.size - 1) {
            return this.getLast();
        } else if (index >= this.size) {
            System.out.println("El indice no existe");
            return null;
        } else {
            DoubleLinkedList<E> nuevaLista = new DoubleLinkedList<E>();
            int contador = 0;
            E elemento = null;
            while (!this.isEmpty()) {
                if (index == contador) {
                    elemento = this.getFirst();                    
                } 
                nuevaLista.addLast(this.getFirst());
                this.removeFirst();
                contador++;               
            }
            this.head = nuevaLista.head;
            this.tail = nuevaLista.tail;
            this.size = nuevaLista.size;
            return elemento;
        }
    }

        @Override
        public boolean contains
        (E elemento
        
            ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }
