/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras2.LinkedTree;

import Exceptions.ArbolVacioException;
import Exceptions.BadPosition;
import Exceptions.InaccesibleException;
import estructuras2.Tree.Position;
import estructuras2.Tree.Tree;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Kisko
 */
public class LinkedTree<E> implements Tree<E> {
    private TNodo<E> root;
    private int size;
    
    public LinkedTree(){
        root=null;
        size=0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
         if (this.size==0){
             return true;
         }else{
             return false;
         }
    }

    @Override
    public Iterator iterator() {
        Iterable<Position<E>> pos=(Iterable<Position<E>>) positions();
        List<Position<E>> resultado=new ArrayList<Position<E>>();
        for(Position<E> p: pos){
            resultado.add(p);
        }
        return resultado.iterator();
    }

    @Override
    public Iterable<Position<E>> positions() {
        List<Position<E>> lista=new ArrayList<Position<E>>();   
        preorden(this.root,lista); 
        return (Iterable) lista;
    }

    @Override
    public Position<E> root() throws ArbolVacioException {
        if(root==null)throw new ArbolVacioException("el arbol esta vacio");
        return (Position<E>) this.root; 
   
    }

    @Override
    public Position<E> parent(Position<E> p)throws InaccesibleException{
      TNodo<E> nodo=cPosition(p);
      TNodo<E> padre=nodo.getPadre();
      if(padre==null) throw new InaccesibleException("no tiene padre");
      return (Position<E>) padre;
    }

    @Override
    public Iterable children(Position<E> p) {
        TNodo<E> nodo=cPosition(p);
        List<E> listahijos=(ArrayList<E>) nodo.getHijos();
        return listahijos;
    }

    @Override
    public boolean isLeaf(Position<E> p) {
      TNodo<E> nodo=cPosition(p);
      boolean resultado=false;
      List<TNodo<E>> hijos=nodo.getHijos();
      if((hijos==null)||(hijos.isEmpty())){
          resultado=true;
      }else{
          resultado =false;
      }
      return resultado;
    }

    @Override
    public boolean isInternal(Position<E> p) {
       boolean resultado=false;
       if (isLeaf(p)){
           resultado=false;
       }else{
           resultado=true;
       }
       return resultado;
    }

    @Override
    public boolean isRoot(Position<E> p) {
       TNodo<E> nodo=cPosition(p);
       return (nodo==this.root);
    }

    @Override
    public E replace(Position<E> p, E elemento) {
        TNodo<E> nodo=cPosition(p);
        E aux=nodo.element();
        nodo.setElemento(elemento);
        return aux;
    }
    
    public Position<E> add(Position<E> padre,E elemento){
        TNodo<E> nodopadre=cPosition(padre);
        TNodo<E> newnode=crearNodo(nodopadre,elemento,new ArrayList<TNodo<E>>());
        List<TNodo<E>> children=nodopadre.getHijos();
        children.add(newnode);
        this.size=this.size+1;
        return (Position<E>)newnode;   
    }
    public Position<E> addRoot(E elemento){       
        TNodo<E> newnode=crearNodo(null,elemento,new ArrayList<TNodo<E>>());
        this.root=newnode;
        this.size=this.size+1;
        return (Position<E>)newnode;   
    }
    
    public Position<E> remove(Position<E> p){
        TNodo<E> nodo=cPosition(p);
        TNodo<E> padre=nodo.getPadre();
        List<TNodo<E>> children=padre.getHijos();
        children.remove(nodo);
        
        List<Position<E>> list = new ArrayList<Position<E>>();
		this.preorden(p, list);
		size = size- list.size(); //
        
        return (Position<E>) nodo;
    }
   
    
    
    
    
    /*castea un position a TNodo si es posible
    
    */
    protected TNodo<E> cPosition(Position<E> p)throws BadPosition{
        if((p==null)||!(p instanceof TNodo))
            throw new BadPosition("posicion no valida");
        TNodo<E> n=(TNodo<E>)p;
        return n;
    }
    
    protected TNodo<E> crearNodo(TNodo<E> padre,E elemento,List<TNodo<E>> hijos){
        TNodo<E> newnode=new TNodo<E>(padre,elemento,hijos);
        return newnode;
    }


    public void preorden(Position<E> p,List<Position<E>> list){
        list.add(p);
        TNodo<E> nodo= cPosition(p);
        if(!this.isLeaf(p)){
            for(Position<E> h : nodo.getHijos() ){
                preorden(h,list);
            }
        }
            
                
    }
    
}
