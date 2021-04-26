/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras2.list;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kisko
 */
public class DoubleLinked<E> implements InterfazDoubleLinkedList<E> {
    int size;
    Nodo<E> head;
    Nodo<E> tail;
    
    public DoubleLinked(){
        size=0;
        head=null;
        tail=null;
    }

    @Override
    public void addFirst(E elemento) {
        //esto añade por la cabecera (izquierda)
        if(this.isEmpty()){
            Nodo<E> newnode=new Nodo<E>();
            newnode.setElemento(elemento);
            newnode.setNext(null);
            newnode.setPrev(null);
            this.head=newnode;
            this.tail=newnode;
            this.size=1;
        }else{
            Nodo<E> newnode=new Nodo<E>();
            newnode.setElemento(elemento);
            newnode.setNext(this.head);
            newnode.setPrev(null);
            this.head.setPrev(newnode);
            this.head=newnode; 
            this.size++;            
        }
    }

    @Override
    public void addLast(E elemento) {
        //esto añade por la cabecera (izquierda)
        if(this.isEmpty()){
            Nodo<E> newnode=new Nodo<E>();
            newnode.setElemento(elemento);
            newnode.setNext(null);
            newnode.setPrev(null);
            this.head=newnode;
            this.tail=newnode;
            this.size=1;
        }else{
            Nodo<E> newnode=new Nodo<E>();
            newnode.setElemento(elemento);
            newnode.setNext(null);
            newnode.setPrev(this.tail);
            this.tail.setNext(newnode);
            this.tail=newnode; 
            this.size++;            
        }
    }

    @Override
    public void add(E elemento, int index) {
        if(index==0){
            this.addFirst(elemento);
        }else if (index==this.size){
            this.addLast(elemento);
        }else if(index > this.size()){
            System.out.println(" el indice es iuncorrecto");
        }else{
            DoubleLinked<E> nuevalista=new DoubleLinked<E>();
            int contador=0;
            while(this.isEmpty()==false){
                if(index==contador){
                    nuevalista.addLast(elemento);
                    contador++;
                }else{
                   nuevalista.addLast(this.getFirst());
                   this.removeFirst();
                   contador++;
                }
            }//fin del while
            this.head=nuevalista.head;
            this.tail=nuevalista.tail;
            this.size=nuevalista.size;
        }
    }

    @Override
    public void removeFirst() {
        if(this.isEmpty()){
            System.out.println("la lista esta vacia");
        }else{
            this.head=head.getNext();
            this.size--;
        }
    }

    @Override
    public void removeLast() {
         if(this.isEmpty()){
            System.out.println("la lista esta vacia");
        }else{
            this.tail=tail.getPrev();
            this.size--;
        }
    }

    @Override
    public void remove(int index) {
             if(index==0){
            this.removeFirst();
        }else if (index==this.size-1){
            this.removeLast();
        }else if(index >= this.size()){
            System.out.println(" el indice es iuncorrecto");
        }else{
            DoubleLinked<E> nuevalista=new DoubleLinked<E>();
            int contador=0;
            while(this.isEmpty()==false){
                if(index==contador){
                    this.removeFirst();
                    contador++;
                }else{
                   nuevalista.addLast(this.getFirst());
                   this.removeFirst();
                   contador++;
                }
            }//fin del while
            this.head=nuevalista.head;
            this.tail=nuevalista.tail;
            this.size=nuevalista.size;
        }
    
    }

    @Override
    public boolean isEmpty() {
        if(this.size==0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E getFirst() {
        E elemento;
        if(this.isEmpty()){
            elemento=null;
            System.out.println("La lista esta vacia");
        }else{
           elemento= head.getElemento();
        }
        return elemento;
    }

    @Override
    public E getLast() {
        E elemento;
        if(this.isEmpty()){
            elemento=null;
            System.out.println("La lista esta vacia");
        }else{
           elemento= tail.getElemento();
        }
        return elemento;
    }
    
    
    

    @Override
    public boolean contains(E elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E get(int index) {
        E elemento=null;
        if(index==0){
            elemento=this.getFirst();
        }else if (index==this.size){
            this.getLast();
        }else if(index >= this.size()){
            System.out.println(" el indice es iuncorrecto");
        }else{
            DoubleLinked<E> nuevalista=new DoubleLinked<E>();
            int contador=0;
            while(this.isEmpty()==false){
                if(index==contador){
                    elemento=this.getFirst();
                    nuevalista.addLast(this.getFirst());
                    this.removeFirst();     
                    contador++;
                }else{
                   nuevalista.addLast(this.getFirst());
                   this.removeFirst();
                   contador++;
                }
            }//fin del while
            this.head=nuevalista.head;
            this.tail=nuevalista.tail;
            this.size=nuevalista.size;
        }
            return elemento;
    }


    public Iterable<Nodo<E>> iterator(){
        List<Nodo<E>> listaresultado=new ArrayList<Nodo<E>>();
        DoubleLinked<E> dlaux=new DoubleLinked<E>();
        while(this.isEmpty()==false){
            //consultar
            Nodo<E> nodo=new Nodo<E>();
            nodo=this.head;
            listaresultado.add(nodo);
            //construir lista2
            dlaux.addLast(this.getFirst());
            //destruir lista1
            this.removeFirst();
            
        }
        //asignar volvemos a tener la lista 1 instactac
        this.head=dlaux.head;
        this.tail=dlaux.tail;
        this.size=dlaux.size;
        
       return listaresultado; 
    }
    
    
}
