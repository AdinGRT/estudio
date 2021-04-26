/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras2.LinkedBinaryTree;

import estructuras2.Tree.Position;
import estructuras2.Tree.Tree;

/**
 *
 * @author Kisko
 */
public interface InterfazBinaryTree<E> extends Tree<E> {
    
    public Position<E> left(Position<E> p);
    public Position<E> right(Position<E> p);
    public boolean hasRight(Position<E> p);
    public boolean hasLeft(Position<E> p);
   
}
