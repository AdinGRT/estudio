/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage1;

import BSTree.BSTree;
import Exceptions.BadPosition;
import estructuras2.LinkedBinaryTree.BTNode;
import estructuras2.Tree.Position;
import java.util.Comparator;

/**
 *
 * @author Kisko
 */
public class AVLTree<E> extends BSTree<E>{

    public AVLTree() {
        super();
    }

    public AVLTree(Comparator<E> comp) {
        super(comp);
    }
    
    public int balanceado(Position<E> p){
        int izda=this.tree.altura(this.tree.left(p));
        int derecha=this.tree.altura(this.tree.right(p));
        return derecha-izda;
    }
    
    public Position<E> insert(E value){
        Position<E> p=super.insert(value);
        // este nodo insertado tiene un balance de 0
       BTNode<E> nodo=checkPosition(p);   
        while(this.tree.root()!=nodo){
            int balance=this.balanceado(nodo);
            System.out.println(" el nodo "+nodo.element()+" tiene un balance de "+balance);
            if(balance==2){
                RestructurarDer(nodo);
            }else if (balance==-2){
                
            }
            nodo=nodo.getParent();
        }
        //ultima reestructuracion para root
          BTNode<E> nodor=checkPosition(this.tree.root());
         int balance=this.balanceado(nodor);
            System.out.println(" el nodo "+nodo.element()+" tiene un balance de "+balance);
            if(balance==2){
                RestructurarDer(nodor);
            }else if (balance==-2){
                
            }
            nodo=nodo.getParent();
        
        
        
        
        
        return p;
    }
    
    public void RestructurarDer(Position<E> p){
     BTNode<E> nodo=checkPosition(p);
     BTNode<E> hijoderecho=nodo.getRight();
     int balance2=this.balanceado(hijoderecho);
     if(balance2>0){//rotacion simple derecha
         rotacionSimpleDer(nodo);
     }else{//rotacion derecha izquierda
        // rotacionDobleDerIzda(nodo);
     }
     
    }
    
    
    
    public void RestructurarIzda(Position<E> p){
        while(this.tree.root()!=p){
            BTNode<E> nodo=checkPosition(p);
            
        }
    }
    
    public void rotacionSimpleDer(Position<E> p){
        BTNode<E> nodo=checkPosition(p);
        BTNode<E> hd=nodo.getRight();
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
            nodo.setRight(hdi);
            abuelo.setRight(hd);
            hd.setLeft(nodo);
        
        }     
    }
    
       protected BTNode<E> checkPosition(Position<E> p){
         if((p==null)||!(p instanceof BTNode))
            throw new BadPosition("posicion no valida");
        BTNode<E> n=(BTNode<E>) p;
        return n;
    }
    
}
