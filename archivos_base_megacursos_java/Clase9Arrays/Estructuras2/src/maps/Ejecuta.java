/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maps;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import static javafx.scene.input.KeyCode.K;

/**
 *
 * @author Kisko
 */
public class Ejecuta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     /*   Producto[] vp=GeneradorProductos.generarProductos(20);
        TablasHash tabla=new TablasHash();
        tabla.pasaraTabla(vp);
        //Hashtable<String,Producto> nuevatabla=new Hashtable<String,Producto>(4,(float)0.2);
        ArrayList<Producto> listaprod=tabla.listaProd();
        Iterator<Producto> it=listaprod.iterator();
        int contador=0;
        Producto aux=new Producto();
        while(it.hasNext()){
            if(contador==0){
                aux=it.next();
                aux.imprime();
                contador++;
            }else{
            Producto p=it.next();
            p.imprime();
            }
          ;
        }
        System.out.println("-------------");
               
        tabla.getP(aux.getID()).imprime();
    }*/
        
    Producto[] vp=GeneradorProductos.generarProductos(20);
    DiccionarioHash dic=new DiccionarioHash();
    dic.pasaraTabla(vp);
    dic.filtrarPorClase("B");
    
}
}