/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras2.list;

/**
 *
 * @author Kisko
 */
public interface InterfazDoubleLinkedList<E> {
    
    /*
 addFirst(E e)-> añade elemento al principio
 addLast(E e)->añade elemento al final
 add(E e, int index) ->añade elemento en posicion
 removeFirst()->elimina el primer elemento
 removeLast()->elimina el ultimo elemento
remove (int index)->elimina el elemento index
 isEmpty()->esta vacio?
 size() ->tamaño
getFirst()->devuelve el primer elemento
getLast()->devuelve el ultimo elemento
 get(int index) ->devuelve el elemento index
Contains(E e)->¿contiene este elemento?

    */
    
    public void addFirst (E elemento);
    public void addLast (E elemento);
    public void add(E elemento,int index);
    public void removeFirst();
    public void removeLast();
    public void remove(int index);
    public boolean isEmpty();
    public int size();
    public E getFirst();
    public E getLast();
    public E get(int index);
    public boolean contains(E elemento);
      
}
