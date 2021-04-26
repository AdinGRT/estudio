/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras2.LinkedTree;

import estructuras2.Tree.Position;
import java.util.List;

/**
 *
 * @author Kisko
 */
public class TNodo<E> implements Position<E>{
    private TNodo<E> padre;
    private  E elemento;
    private List<TNodo<E>> hijos;

    public TNodo(TNodo<E> padre, E elemento, List<TNodo<E>> hijos) {
        this.padre = padre;
        this.elemento = elemento;
        this.hijos = hijos;
    }
    
    
    
    
    @Override
    public E element() {
        return elemento;
    }

    public TNodo<E> getPadre() {
        return padre;
    }

    public void setPadre(TNodo<E> padre) {
        this.padre = padre;
    }

    public E getElemento() {
        return elemento;
    }

    public void setElemento(E elemento) {
        this.elemento = elemento;
    }

    public List<TNodo<E>> getHijos() {
        return hijos;
    }

    public void setHijos(List<TNodo<E>> hijos) {
        this.hijos = hijos;
    }
    
    
    
}
