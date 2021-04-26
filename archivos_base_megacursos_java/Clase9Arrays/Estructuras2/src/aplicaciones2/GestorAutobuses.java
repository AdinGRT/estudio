/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicaciones2;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;
import maps.Producto;

/**
 *
 * @author Kisko
 */
public class GestorAutobuses {
    
    Autobus[] autobuses;
    String nombre;
    Hashtable<String,ArrayList<Autobus>> tablaorigenes=new Hashtable<String,ArrayList<Autobus>>();
    Hashtable<String,ArrayList<Autobus>> tabladestinos=new Hashtable<String,ArrayList<Autobus>>(); 
   

    public GestorAutobuses(Autobus[] autobuses, String nombre) {
        this.autobuses = autobuses;
        this.nombre = nombre;
        pasarOrigenes();
        pasarDestinos();
    }

    public GestorAutobuses() {
        pasarOrigenes();
        pasarDestinos();
    }

    public Autobus[] getAutobuses() {
        return autobuses;
    }

    public void setAutobuses(Autobus[] autobuses) {
        this.autobuses = autobuses;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

     public void pasarOrigenes(){
           for(int i=0 ;i<autobuses.length;i++){
            ArrayList<Autobus> lista=tablaorigenes.get(autobuses[i].getOrigen());
            if(lista==null){
                lista=new ArrayList<Autobus>();
                lista.add(autobuses[i]);
                tablaorigenes.put(autobuses[i].getOrigen(), lista);
                }else{
            lista.add(autobuses[i]);
            tablaorigenes.put(autobuses[i].getOrigen(), lista);
            }
        }
     }
     
         public void pasarDestinos(){
           for(int i=0 ;i<autobuses.length;i++){
            ArrayList<Autobus> lista=tabladestinos.get(autobuses[i].getDestino());
            if(lista==null){
                lista=new ArrayList<Autobus>();
                lista.add(autobuses[i]);
                tabladestinos.put(autobuses[i].getDestino(), lista);
                }else{
            lista.add(autobuses[i]);
            tabladestinos.put(autobuses[i].getDestino(), lista);
            }
        }
     }
         
    public void imprimeTodo(){
        Iterator<ArrayList<Autobus>> it=tablaorigenes.values().iterator();
        while(it.hasNext()){
            ArrayList<Autobus> lista=it.next();
            Iterator<Autobus> it2=lista.iterator();
            while(it2.hasNext()){
             Autobus a=it2.next();
               a.toString();
               System.out.println(a.toString());
            }
        }
    }
        
       public ArrayList<Autobus> filtrarOrigen(String ciudad){
           ArrayList<Autobus> lista=tablaorigenes.get(ciudad);
           Iterator<Autobus> it=lista.iterator();
           while(it.hasNext()){
               Autobus a = it.next();
               System.out.println(a.toString());;
           }
           return lista;          
       }
       
          public ArrayList<Autobus> filtrarDestino(String ciudad){          
           ArrayList<Autobus> lista=tabladestinos.get(ciudad);
           Iterator<Autobus> it=lista.iterator();
           while(it.hasNext()){
               Autobus a = it.next();
               System.out.println(a.toString());
           }
           return lista;          
       }
        
            
        
       
        
        public void imprimeduracion(){
            int sumatotal=0;
            for(int i=0;i<autobuses.length;i++){
                sumatotal+=autobuses[i].getDuracion();
            }
            System.out.println(sumatotal);
        }
        
        
    public void buscarPasajero(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Escribe el nombre del sospechoso");
        String nombre=sc.nextLine();
        System.out.println("Escribe el apellido del sospechoso");
        String apellido=sc.nextLine();
        System.out.println("Escribe el destino de el sospechoso");
        String destino=sc.nextLine();
        ArrayList<Autobus> lista=tabladestinos.get(destino);
        boolean encontrado=false;
        Iterator<Autobus> it=lista.iterator();
           while(it.hasNext()){
               Autobus a = it.next();
               Pasajero[] listapasajeros=a.getPasajeros();
               int i=0;
               while((encontrado==false)&&(i<listapasajeros.length)){
                   if ((listapasajeros[i].getNombre().compareToIgnoreCase(nombre)==0)
                       &&(listapasajeros[i].getApellido().compareToIgnoreCase(apellido)==0)){
                       Pasajero p=listapasajeros[i];
                       encontrado=true;
                       System.out.println("---------------------------------");
                       System.out.println("Pasajero encontrado "+p.toString());
                       System.out.println("mas info "+a.toString());
                   }
                   i++;
               }
           }
        
        
        
        
    }// fin de metodo buscar apsajeros
    
    
    
   
     
    
    
    
    
}
