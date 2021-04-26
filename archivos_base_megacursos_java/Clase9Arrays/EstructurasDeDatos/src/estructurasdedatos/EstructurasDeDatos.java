/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasdedatos;

import Cola.QueueDoble;
import List.DoubleLinked;
import estructurasdedatos.Pila.Pila;

/**
 *
 * @author Kisko
 */
public class EstructurasDeDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DoubleLinked<String> dl=new DoubleLinked<String>();
        String s1="1";
        String s2="2";
        String s3="3";
        String s4="4";
        dl.addLast(s1);
        dl.addLast(s2);
        dl.addLast(s3);
        dl.addLast(s4);
        String s5="hola soy el nuevo";
        dl.add(s5, 2);
        String resultado="";
        
        DoubleLinked<String> dl2=new DoubleLinked<String>();
        
        while(dl.isEmpty()==false){
            //consultar
            System.out.println(dl.getFirst());
            //construir lista2
            dl2.addLast(dl.getFirst());
            //destruir lista1
            dl.removeFirst();
            
        }
        //asignar volvemos a tener la lista 1 instactac
        dl=dl2;     
        System.out.println("------------------------");
        System.out.println(dl.get(6));
   
    }
    
}
