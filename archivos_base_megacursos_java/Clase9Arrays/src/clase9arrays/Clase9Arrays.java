/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase9arrays;

/**
 *
 * @author Kisko
 */
public class Clase9Arrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Ordenacion o1=new Ordenacion();
        int[] a={9,6,4,3,2,455,600,12,40};
        Busqueda b1=new Busqueda();
        System.out.println("El resultado es "+b1.BusquedaSecNoOrd(455, a));
        o1.BurbujaCreciente(a);
        
        for(int w=0;w<a.length;w++){
            System.out.print(a[w]+"|");       
        }
        System.out.println();  
        System.out.println("El resultado es "+b1.BusquedaBinario(455, a));
       
        
    }
    
}
