/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTree;

import static java.lang.Math.E;
import java.util.Comparator;

/**
 *
 * @author Kisko
 */
public class ComparadorSimple<E> implements Comparator<E> {

    
    /*
    Clase comparadora de objetos
  Método compare(E a, E b):
  x <0 si a es menor que b
  x==0 si a es igual a b
  x>0 si a es mayor que b

    */
    @Override
    public int compare(E a, E b) {
        return ((Comparable<E>)a).compareTo(b);
    }

 
        
}
