/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicaciones;

import estructuras2.LinkedBinaryTree.LinkedBinaryTree;
import estructuras2.Tree.Position;
import java.util.Scanner;

/**
 *
 * @author Kisko
 */
public class Adivinator {

    /**
     * @param args the command line arguments
     */
    
    static LinkedBinaryTree<String> a=new LinkedBinaryTree<String>();
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String cadena1="";
        String cadena2="";
        // TODO code application logic here
        System.out.println("¿De que tema quieres que te adivine?");
        cadena1=sc.nextLine();
        a.addRoot(cadena1);
        System.out.println("Dame un ejemplo de un "+a.root().element());
        cadena1=sc.nextLine();
        a.addLeft(a.root(), cadena1);
        
        while(cadena2.compareToIgnoreCase("fin")!=0){
            Adivinator.recorreArbol(a.root());
            
        }//fin del while
        
        
        
    }//fin del metodo main
    
    public static void recorreArbol(Position<String> p){
        Scanner sc=new Scanner(System.in);
        String res1="";
        if(a.isLeaf(p)){
            System.out.println(p.element()+"?");
            res1=sc.nextLine();
            if(res1.compareToIgnoreCase("si")==0){
                System.out.println("Bien he acertado!!! volvemos a empezar");
                Adivinator.recorreArbol(a.root());
            }else{
                System.out.println("vaya nunca lo habria adivinado...");
                System.out.println("por favor escribeme la solucion");
                String solucion=sc.nextLine();    
                System.out.println("Escrimebe lo que diferencia "+solucion+" y "+p.element());
                String nodointerno=sc.nextLine();
                String oldleaf=p.element();
                a.replace(p, nodointerno);
                a.addLeft(p, solucion);
                a.addRight(p,oldleaf);
                System.out.println("volvemos a empezar");
                Adivinator.recorreArbol(a.root());
            }
            
        }//en caso de que el nodo sea hoja
        else{
         System.out.println(p.element()+"?");
         res1=sc.nextLine();
         if(res1.compareToIgnoreCase("si")==0){
             if(a.hasLeft(p)){
                 Adivinator.recorreArbol(a.left(p));
             }else{
                 System.out.println("¿En que estabas pensado?");
                 String res2=sc.nextLine();
                 a.addLeft(p, res2);
                 System.out.println("volvemos a empezar");
                Adivinator.recorreArbol(a.root());
             }
         }else{// en caso de respuesta negativa
              if(a.hasRight(p)){
                 Adivinator.recorreArbol(a.right(p));
             }else{
                 System.out.println("¿En que estabas pensado?");
                 String res2=sc.nextLine();
                 a.addRight(p, res2);
                 System.out.println("volvemos a empezar");
                Adivinator.recorreArbol(a.root());
             }
             
         }
             
            
        }//fin de else caso contrario
        
    }
    
}
