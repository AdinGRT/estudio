/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicaciones2;

/**
 *
 * @author Kisko
 */
public class Ejecutame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        GestorAutobuses ga=new GestorAutobuses(Generadorautobuses.GenerarAutobuses(300),"Elpastosa");
        ga.imprimeTodo();
        System.out.println("-----------------------");
        ga.filtrarDestino("Cuenca");
        System.out.println("-----------------------");
        System.out.println("SOSpechoso localizado");
        System.out.println(ga.getAutobuses()[50].getPasajeros()[15].toString()+" con destino"+ ga.getAutobuses()[50].getDestino());
        
        ga.buscarPasajero();
        // TODO code application logic here
    }
    
}
