/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maps;

import estructuras2.list.DoubleLinked;
import estructuras2.list.Nodo;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

/**
 *
 * @author Kisko
 */
public class DiccionarioHash {
    Hashtable<String,DoubleLinked<Producto>> tabla=new Hashtable<String,DoubleLinked<Producto>>();
    
     public void pasaraTabla(Producto[] vp){
     
     for(int i=0 ;i<vp.length;i++){
     DoubleLinked<Producto> llinked=tabla.get(vp[i].getClase());
     if(llinked==null){
         llinked=new DoubleLinked<Producto>();
         llinked.addLast(vp[i]); 
         tabla.put(vp[i].getClase(), llinked);
     }else{
     llinked.addLast(vp[i]);
     tabla.put(vp[i].getClase(), llinked);
     }
    }
 }
     
     public void filtrarPorClase(String filtro){
         DoubleLinked<Producto> lista=tabla.get(filtro);
         if(lista!=null){
         Iterable<Nodo<Producto>> iter=lista.iterator();
         Iterator<Nodo<Producto>> it=iter.iterator();
         while(it.hasNext()){
             Nodo<Producto> n=it.next();
             n.getElemento().imprime();
         }
         }
         
    }
 
    
}
