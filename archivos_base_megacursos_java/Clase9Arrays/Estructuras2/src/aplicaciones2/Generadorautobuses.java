/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicaciones2;

import java.util.Random;

/**
 *
 * @author Kisko
 */
public  class Generadorautobuses {
    
    /* this.origen = origen;
        this.destino = destino;
        this.duracion = duracion;
        this.pasajeros = pasajeros;
    */
    public static Autobus[] GenerarAutobuses(int n){
    String[] lorigenes={"Cuenca","Madrid","Malaga","Hong kong","Almeria"};
    String[] ldestinos={"Cuenca","Madrid","Malaga","Hong kong","Almeria"};
     Autobus[] resultado=new Autobus[n];
    
    for(int i=0;i<n;i++){
         Random r = new Random();
         Autobus a=new Autobus();
         a.setOrigen(lorigenes[r.nextInt(lorigenes.length)]);
         a.setDestino(ldestinos[r.nextInt(ldestinos.length)]);
         a.setDuracion(r.nextInt(600));
         a.setPasajeros(GeneradorPasajeros.generarPasajeros(20));
         
         resultado[i]=a;
     }
    return resultado;
    
    }
  
    
    
    
}
