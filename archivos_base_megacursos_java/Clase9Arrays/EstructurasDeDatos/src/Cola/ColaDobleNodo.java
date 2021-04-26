/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cola;

/**
 *
 * @author Kisko
 */
public class ColaDobleNodo<E> {
    E elemento;
    ColaDobleNodo<E> prev;
    ColaDobleNodo<E> next;
    
    public ColaDobleNodo(){
        elemento=null;
        prev=null;
        next=null;
    }

    public E getElemento() {
        return elemento;
    }

    public void setElemento(E elemento) {
        this.elemento = elemento;
    }

    public ColaDobleNodo<E> getPrev() {
        return prev;
    }

    public void setPrev(ColaDobleNodo<E> prev) {
        this.prev = prev;
    }

    public ColaDobleNodo<E> getNext() {
        return next;
    }

    public void setNext(ColaDobleNodo<E> next) {
        this.next = next;
    }
    
    
        
}
