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
public class QueueDoble<E> implements InterfazQueueDoble<E> {
    ColaDobleNodo<E> head;
    ColaDobleNodo<E> tail;
    int size;
    
    public QueueDoble(){
        head=null;
        tail=null;
        size=0;
    }

    @Override
    public int Size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
       if(this.Size()==0){
           return true;
       }else{
           return false;
       }
    }

    @Override
    public E Front() {
        E elemento;
        if(this.isEmpty()){
            elemento=null;
            System.out.println("La cola esta vacia");
        }else{
            elemento= this.head.getElemento();
        }
        return elemento;
    }

    @Override
    public E Tail() {
        E elemento;
        if(this.isEmpty()){
            elemento=null;
            System.out.println("La cola esta vacia");
        }else{
            elemento= this.tail.getElemento();
        }
        return elemento;
    }

    @Override
    public void Enqueue(E elemento) {
        if(this.isEmpty()){
            ColaDobleNodo<E> newnodo=new ColaDobleNodo<E>();
            newnodo.setElemento(elemento);
            newnodo.setNext(null);
            newnodo.setPrev(null);
            this.head=newnodo;
            this.tail=newnodo;
            this.size=1;
        }else{
            ColaDobleNodo<E> newnodo=new ColaDobleNodo<E>();
            newnodo.setElemento(elemento);
            newnodo.setPrev(tail);
            newnodo.setNext(null);
            this.tail.setNext(newnodo);
            tail=newnodo;
            this.size++;
            
        }
    }

    @Override
    public void Dequeue() {
        if(this.isEmpty()){
            System.out.println("La cola esata vacia");
        }else{
            head=head.getNext();
            this.size--;
         }
    }

    
    
    
}
