/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras2.LinkedBinaryTree;

import Exceptions.ArbolVacioException;
import Exceptions.BadPosition;
import Exceptions.InaccesibleException;
import estructuras2.Tree.Position;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Kisko
 */
public class LinkedBinaryTree<E> implements InterfazBinaryTree<E> {
    
    BTNode<E> root;
    int size;

    
    public LinkedBinaryTree(){
        root=null;
        size=0;
    }
    
    @Override
    public Position<E> left(Position<E> p) {
        BTNode<E> nodo=checkPosition(p);
        BTNode<E> left=null;
        if(this.hasLeft(p)){
            left=nodo.getLeft();
        }
        return left;
    }

    @Override
    public Position<E> right(Position<E> p) {
     BTNode<E> nodo=checkPosition(p);
        BTNode<E> right=null;
        if(this.hasRight(p)){
            right=nodo.getRight();
        }
        return right;
    }

    @Override
    public boolean hasRight(Position<E> p) {
         BTNode<E> nodo=checkPosition(p);
         if(nodo.getRight()==null){
             return false;
         }else{
             return true;
         }
    }

    @Override
    public boolean hasLeft(Position<E> p) {
       BTNode<E> nodo=checkPosition(p);
         if(nodo.getLeft()==null){
             return false;
         }else{
             return true;
         }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if(size==0){
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

    public int altura(Position<E> p){
        BTNode<E> node=checkPosition(p);
    
        if (this.isLeaf(p))
    {
        return 0;
    }
    else
    {   if((this.hasLeft(p))&&(this.hasRight(p))){
        return 1 +  Math.max(altura(this.left(p)),altura(this.right(p)));
            }else if((this.hasLeft(p))&&(!this.hasRight(p))){
                return 1+altura(this.left(p));
            }else{
                return 1+altura(this.right(p));
            }
        }
    }
    
    
    @Override
    public Iterable<Position<E>> positions() {
        List<Position<E>> lista=new ArrayList<Position<E>>();   
        preorden(this.root,lista); 
        return (Iterable) lista;
    }

    @Override
    public Position<E> root()throws ArbolVacioException {
        if(this.isEmpty()==true)throw new ArbolVacioException("el arbol esta vacio");
        return this.root;
    }

    @Override
    public Position<E> parent(Position<E> p) {
        BTNode<E> nodo=checkPosition(p);
        BTNode<E> parent;
        if(nodo.equals(root)){
            throw new InaccesibleException("el nodo el raiz no tiene hijos");
        }else{
            parent=nodo.getParent();
        }
        
       return parent;
    }

    @Override
    public Iterable children(Position<E> p) {
        BTNode<E> nodo=checkPosition(p);
        List<Position<E>> hijos=new ArrayList<Position<E>>();    
        if(!this.isLeaf(p)){
            
        if(nodo.getLeft()!=null){
            hijos.add((Position<E>)nodo.getLeft());
        }
        if(nodo.getRight()!=null){
            hijos.add((Position<E>)nodo.getRight());
        }
        }
       return hijos;
    }

    @Override
    public boolean isLeaf(Position<E> p) {
        BTNode<E> nodo=checkPosition(p);
        if((nodo.getLeft()==null)&&(nodo.getRight()==null)){
            return true;
         }else{
            return false;
        }
    }
    
    public void swapRoot(Position<E> p){
        root=checkPosition(p);
    }

    @Override
    public boolean isInternal(Position<E> p) {
         return !this.isLeaf(p);
    }

    @Override
    public boolean isRoot(Position<E> p) {
        BTNode<E> nodo=checkPosition(p);
        return nodo.equals(root);
    }

    @Override
    public E replace(Position<E> p, E elemento) {
        BTNode<E> nodo=checkPosition(p);
        E element=nodo.getElemento();
        nodo.setElemento(elemento);
        return element;
    }
    
    public BTNode<E> addRight(Position<E> p,E elemento){
        BTNode<E> nodo=checkPosition(p);
        E element=nodo.getElemento();
        BTNode<E> newnode= this.crearNodo(elemento, null, null, nodo);
        if(nodo.getRight()==null){
            nodo.setRight(newnode);
            this.size++;
        }else{
            throw new InaccesibleException("YA tiene un hijo derecho");
        }
        return newnode;
    }
    
    public BTNode<E> addLeft(Position<E> p,E elemento){
        BTNode<E> nodo=checkPosition(p);
        BTNode<E> newnode= this.crearNodo(elemento, null, null, nodo);
        if(nodo.getLeft()==null){
            nodo.setLeft(newnode);
            this.size++;
        }else{
            throw new InaccesibleException("YA tiene un hijo izquierdo");
        }
        return newnode;
    }
    
    public BTNode<E> addRoot(E elemento){
        BTNode<E> newnode= this.crearNodo(elemento, null, null, null);
        if(this.root==null){
            this.root=newnode;
            this.size++;
        }else{
            throw new BadPosition("el arbol ya contiene una raiz");
        }
        return newnode;
    }
    
    public E remove(Position<E> p){
        BTNode<E> nodo=checkPosition(p);
        BTNode<E> nleft=nodo.getLeft();
        BTNode<E> nright=nodo.getRight();
        E element=nodo.getElemento();
        if((nleft!=null)&&(nright!=null)){
            throw new BadPosition("No se pueden borrar nodos con 2 hijos");
        }else{
            BTNode<E> hijo;
            if(nright!=null){//solo hijo derecho
                hijo=nright;
            }if(nleft!=null){//solo hijo izdo
                hijo=nleft;
            }else{//nodo hoja
                hijo=null;
            }
            if(nodo.equals(root)){//si el nodo es raiz
                if(hijo==null){
                    root=null;
                    size=0;
                }else{
                    hijo.setParent(null);
                    root=hijo;
                }
            }else{// el nodo no es raiz
                BTNode<E> grandpa=nodo.getParent();
                if(nodo.equals(grandpa.getLeft())){
                    grandpa.setLeft(hijo);
                    
                }else if(nodo.equals(grandpa.getRight())){
                    grandpa.setRight(hijo);
                  
                }
                
               if(hijo!=null){
                   hijo.setParent(grandpa);
               } 
            }//fon de si no es nodo raiz
            this.size--;
        }
      return element;  
    }
    
    
    /*metodos auxiliares*/
    protected BTNode<E> checkPosition(Position<E> p){
         if((p==null)||!(p instanceof BTNode))
            throw new BadPosition("posicion no valida");
        BTNode<E> n=(BTNode<E>) p;
        return n;
    }
    
    protected BTNode<E> crearNodo(E elemento,BTNode<E> r,BTNode<E> l,BTNode<E> p){
        return new BTNode<E>(elemento,r,l,p);  
    }
    
   protected void preorden(Position<E> p, List<Position<E>> lista){
		lista.add(p);
		if (hasLeft(p))
			preorden(left(p), lista); 
		if (hasRight(p))
			preorden(right(p), lista); 
	}
    
}
