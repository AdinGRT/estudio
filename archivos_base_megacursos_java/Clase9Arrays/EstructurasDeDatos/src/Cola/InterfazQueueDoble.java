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
public interface InterfazQueueDoble<E> {
    /*
    size()->devuelve el tamaño de la lista
    isEmpty()->si esta vacia
    front()->primer elemento
    enqueue(E e) ->poner en la cola
    dequeue()->quitar de la cola
    tail()->devuelva el ultimo elemento

    */
    
    public int Size();
    public boolean isEmpty();
    public E Front();
    public E Tail();
    public void Enqueue(E elemento);
    public void Dequeue();
    
}
