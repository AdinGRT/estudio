/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrusturas2.AVLTree;

import BSTree.BSTree;
import Exceptions.BadPosition;
import estructuras2.LinkedBinaryTree.BTNode;
import estructuras2.Tree.Position;
import java.util.Comparator;

/**
 *
 * @author Kisko
 */
public class AVLTree<E> extends BSTree<E> {

    public AVLTree() {
        super();
    }

    public AVLTree(Comparator<E> comp) {
        super(comp);
    }
    
    public int balanceado(Position<E> p){
        int alturaderecha=tree.altura(tree.left(p));
        int alturaizquierda=tree.altura(tree.right(p));  
        return alturaizquierda-alturaderecha;
    }
    
    public Position<E> insert(E value){
        Position<E> nodo =super.insert(value);
        
        while(nodo!=this.tree.root()){
            int balanceo=balanceado(nodo);
            System.out.println(" el nodo "+nodo.element()+" tiene un balance de "+balanceo);
            if(balanceo==2){//desequilibrio por la derecha
                restructurarDerecha(nodo);
            }if (balanceo==-2){//desequilibrio por la izquierda
                restructurarIzquierda(nodo);
            }
            nodo=tree.parent(nodo);    
        }
        
            int balanceo=balanceado(this.tree.root());
            System.out.println(" el nodo "+nodo.element()+" tiene un balance de "+balanceo);
            if(balanceo==2){//desequilibrio por la derecha
                restructurarDerecha(this.tree.root());
            }if (balanceo==-2){//desequilibrio por la izquierda
                restructurarIzquierda(this.tree.root());
            }

       return nodo; 
    }
    
       public Position<E> remove(E value){
        Position<E> nodo =super.remove(value);
        
        while(nodo!=this.tree.root()){
            int balanceo=balanceado(nodo);
            System.out.println(" el nodo "+nodo.element()+" tiene un balance de "+balanceo);
            if(balanceo==2){//desequilibrio por la derecha
                restructurarDerecha(nodo);
            }if (balanceo==-2){//desequilibrio por la izquierda
                restructurarIzquierda(nodo);
            }
            nodo=tree.parent(nodo);    
        }
        
            int balanceo=balanceado(this.tree.root());
            System.out.println(" el nodo "+nodo.element()+" tiene un balance de "+balanceo);
            if(balanceo==2){//desequilibrio por la derecha
                restructurarDerecha(this.tree.root());
            }if (balanceo==-2){//desequilibrio por la izquierda
                restructurarIzquierda(this.tree.root());
            }

       return nodo; 
    }
    
    public void restructurarDerecha(Position<E> p){
        BTNode<E> nodo=checkPosition(p);
        BTNode<E> hd=nodo.getRight();
        int balanceo=balanceado(hd);
        if(balanceo>0){//rotacion simple derecha
            rotacionSimpleD(nodo);
        }else{//rotacion doble derecha izquierda
            rotacionDobleDI(nodo);
        }
        
    }
    
    public void restructurarIzquierda(Position<E> p){
        BTNode<E> nodo=checkPosition(p);
        BTNode<E> hi=nodo.getLeft();
        int balanceo=balanceado(hi);
        if(balanceo<0){//rotacion simple izquierda
            rotacionSimpleI(nodo);
        }else{//rotacion doble  izquierda derecha
            rotacionDobleID(nodo);
        }
    }
    
    public void rotacionSimpleD(Position<E> p){
        BTNode<E> nodo=checkPosition(p);//nodo que detecta el desequilibrio
        BTNode<E> hd=nodo.getRight();// si hijo derecho
        if(nodo==this.tree.root()){// el nodo desbalanceado es root
            BTNode<E> hdi=null;
            if(this.tree.hasLeft(hd)){
            hdi=hd.getLeft();
            }
            this.tree.swapRoot(hd);
            nodo.setRight(hdi);
            hd.setLeft(nodo);
            
        }else{// el nodo desbalanceado es un nodo no root
         BTNode<E> hdi=null;
         BTNode<E> abuelo=nodo.getParent();
            if(this.tree.hasLeft(hd)){
            hdi=hd.getLeft();
            }
            abuelo.setRight(hd);
            nodo.setRight(hdi);
            
            hd.setLeft(nodo);
        
        }             
    }
    
    public void rotacionSimpleI(Position<E> p){
        BTNode<E> nodo=checkPosition(p);//nodo que detecta el desequilibrio
        BTNode<E> hi=nodo.getLeft();// si hijo derecho
        if(nodo==this.tree.root()){// el nodo desbalanceado es root
            BTNode<E> hid=null;
            if(this.tree.hasRight(hi)){
            hid=hi.getRight();
            }
            this.tree.swapRoot(hi);
            nodo.setRight(hid);
            hi.setRight(nodo);
            
        }else{// el nodo desbalanceado es un nodo no root
         BTNode<E> hid=null;
         BTNode<E> abuelo=nodo.getParent();
            if(this.tree.hasRight(hi)){
            hid=hi.getRight();
            }
            nodo.setLeft(hid);
            abuelo.setLeft(hi);
            hi.setLeft(nodo);
        
        }             
    }
    
    public void rotacionDobleDI(Position<E> p){
        BTNode<E> nodo=checkPosition(p);//nodo que detecta el desequilibrio
        BTNode<E> hd=nodo.getRight();// si hijo derecho
        BTNode<E> hdi=hd.getLeft();
        if(nodo==this.tree.root()){// si el nodo es root
            hdi.setLeft(nodo);
            hdi.setRight(hd);
          this.tree.swapRoot(hdi);
          nodo.setRight(null);
          hd.setLeft(null);
          hd.setParent(hdi);
        }else{
            BTNode<E> abuelo=nodo.getParent();
            hdi.setLeft(nodo);
            hdi.setRight(hd);
            abuelo.setRight(hdi);
            nodo.setRight(null);
            hd.setLeft(null);
            hd.setParent(hdi);
            
            
        }
        
    }
    
    public void rotacionDobleID(Position<E> p){
          BTNode<E> nodo=checkPosition(p);//nodo que detecta el desequilibrio
        BTNode<E> hd=nodo.getLeft();// si hijo derecho
        BTNode<E> hdi=hd.getRight();
        if(nodo==this.tree.root()){// si el nodo es root
          hdi.setRight(nodo);
          hdi.setLeft(hd);
          this.tree.swapRoot(hdi);
          nodo.setLeft(null);
          hd.setRight(null);
          hd.setParent(hdi);
        }else{
            BTNode<E> abuelo=nodo.getParent();
            hdi.setRight(nodo);
            hdi.setLeft(hd);
            abuelo.setLeft(hdi);
            nodo.setLeft(null);
          hd.setRight(null);
          hd.setParent(hdi);
            
            
        }
    }
    
    
    
    
    
      
    
    
    /*metodos auxiliares*/
    protected BTNode<E> checkPosition(Position<E> p){
         if((p==null)||!(p instanceof BTNode))
            throw new BadPosition("posicion no valida");
        BTNode<E> n=(BTNode<E>) p;
        return n;
    }
    
}
