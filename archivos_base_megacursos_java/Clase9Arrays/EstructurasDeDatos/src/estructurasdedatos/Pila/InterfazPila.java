/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatos.Pila;

/**
 *
 * @author Kisko
 */
public interface InterfazPila<E> {
    /*
Push()->añade elemento a la cima
Pop()->extrae elemento de la cima
Size()->devuelve el tamaño de la pila
isEmpty()->pregunta si esta vacia
Top()->devuelve el elemento de la cima de la pila

    */
    
    public void Push(E elemento);
    public void Pop();
    public int Size();
    public boolean isEmpty();
    public E Top();
    
}
