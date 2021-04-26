/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTree;

import estructuras2.LinkedBinaryTree.LinkedBinaryTree;
import estructuras2.Tree.Position;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Kisko
 */
public class BSTree<E> {
    int size;
    public LinkedBinaryTree<E> tree;
    Comparator<E> comparator; 
    
    public BSTree(){
        size=0;
        tree=new LinkedBinaryTree<E>();
        tree.addRoot(null);
        comparator=new ComparadorSimple<E>();
    }
    
    public BSTree(Comparator<E> comp){
        size=0;
        tree=new LinkedBinaryTree<E>();
        tree.addRoot(null);
        comparator=comp;
    }
    
    public boolean isEmpty(){
        if(size==0){
            return true;
        }else{
            return false;
        }
    } 
    
    public int size(){
        return size;
    }
    /* metodo que nos sirve para insertar, borrar y buscar*/
    protected Position<E> busquedaEnArbol(Position<E> p,E value){
        if(tree.isLeaf(p)){// en caso de que sea nodo externo posicion null lista para expandir
            return p;
        }else{
            E valueActual=p.element();
            int comparacion=comparator.compare(value, valueActual);
             if (comparacion<0){
                 //es menor recorro por la izquierda
                 return busquedaEnArbol(tree.left(p),value);
             }else if(comparacion>0){
                  //es mayor recorro por la derecha
                 return busquedaEnArbol(tree.right(p),value);
             }else{
                 //he encontrado el valor y me devuelve si posicion
                 return p;
             }
            
        }
    }
    
    protected Position<E> expandirHoja(Position<E> p,E value1,E value2){
        tree.addLeft(p, value1);
        tree.addRight(p, value2);
        return p;
    }
    
    protected Position<E> insertarEnHoja(Position<E> p,E value){
        this.expandirHoja(p,null, null);
        this.Replace(p, value);
        this.size++;
        return p;
    }
    
    protected Position<E> Replace (Position<E> p,E value){
        tree.replace(p, value);
        return p;
    }
    
    public Position<E> insert(E value){
  
        Position<E> p=this.busquedaEnArbol(tree.root(), value);
        if(p.element()!=value){
        this.insertarEnHoja(p, value);
        }
        return p;
        
    }
    //metodo auxiliar
    public Position<E> sucesor(Position<E> p){
        Position<E> sucesor=p;
        if(!tree.isLeaf(tree.right(p))){
            sucesor=tree.right(p);
        }
        while(tree.isInternal(tree.left(sucesor))){
            sucesor=tree.left(sucesor);
        }
        return sucesor;
    }
    
    public Position<E> remove(E value){
        Position<E> posrem=this.busquedaEnArbol(tree.root(), value);
         Position<E> aux=posrem;
        //Caso 1 es un nodo con sus nodos extrenos son null
        if((tree.left(posrem)==null)&&(tree.right(posrem)==null)){
           posrem=null;
           this.size--;
        }
        //caso numero 2 tiene uno de los 2 hijos
        if(((tree.left(posrem)!=null)&&(tree.right(posrem)==null))
                ||((tree.left(posrem)==null)&&(tree.right(posrem)!=null))){
            tree.remove(posrem);
            this.size--;
        }else{//tiene 2 hijos 
            Position<E> sucesor=this.sucesor(posrem);
            this.Replace(posrem, sucesor.element());
            tree.remove(tree.left(sucesor));
            //tree.remove(tree.right(sucesor));
            tree.remove(sucesor);
            this.size--;
        }
        return posrem;
    }
    
    public Position<E> buscar(E value){
        return busquedaEnArbol(tree.root(),value);
    }
    
    public void addLista(List<E> lista){
        List<E> l= lista;
        Iterator<E> it=l.iterator();
        while(it.hasNext()){
            E value=it.next();
            this.insert(value);
        }
    }
    
    
    
}
