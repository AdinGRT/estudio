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
public class Ordenacion {
    public void BurbujaCreciente(int[] a){
      int aux;  
      for(int i=0;i<a.length-1;i++){
          for(int j=0;j<a.length-1;j++){
              if(a[j]>a[j+1]){
                  aux=a[j];
                  a[j]=a[j+1];
                  a[j+1]=aux;
              }
          }
      }  
    }
    
}
