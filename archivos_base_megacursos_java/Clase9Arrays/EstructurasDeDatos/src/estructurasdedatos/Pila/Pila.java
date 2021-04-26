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
public class Pila<E> implements InterfazPila<E> {
    int size;
    NodoPila<E> cima;
    
    public Pila(){
       size=0;
       cima=null;
    }

    @Override
    public void Push(E elemento) {
        if(this.isEmpty()){
            NodoPila<E> pl=new NodoPila<E>();
            pl.setElemento(elemento);
            pl.setPrev(null);
            cima=pl;
            this.size=1;
        }else{
            NodoPila<E> pl=new NodoPila<E>();
            pl.setElemento(elemento);
            pl.setPrev(cima);
            cima=pl;
            this.size=size+1;
        }
    }

    @Override
    public void Pop() {
        if(this.isEmpty()){
            System.out.println("La pila esta vacia");
        }else{
            cima=cima.getPrev();
            this.size--;
        }
    }

    @Override
    public int Size() {
        return this.size;
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
    public E Top() {
        E elemento;
        if(this.isEmpty()){
            elemento=null;
            System.out.println("La pila esta vacia ");
        }else{
            elemento=cima.getElemento();
        }
        return elemento;
    }
    
    
    
}
