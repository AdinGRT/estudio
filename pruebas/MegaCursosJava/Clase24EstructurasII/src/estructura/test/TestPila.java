package estructura.test;

import estructura.pila.Pila;

/**
 *
 * @author adingrt
 */
public class TestPila {
    public static void main(String[] args) {
        Pila p = new Pila();
        
        System.out.println("La pila esta vacia: " + p.isEmpty());
        
        String meter = "A";
        p.push(meter);
        System.out.println("El Top Actual es: " + (String) p.top());
        System.out.println("Size de la Pila: " + p.size());
        
        meter = "B";
        p.push(meter);
        System.out.println("El Top Actual es: " + (String) p.top());
        System.out.println("Size de la Pila: " + p.size());
        
        meter = "C";
        p.push(meter);
        System.out.println("El Top Actual es: " + (String) p.top());
        System.out.println("Size de la Pila: " + p.size());
        
        p.pop();
        System.out.println("El Top Actual es: " + (String) p.top());
        System.out.println("Size de la Pila: " + p.size());
        
        System.out.println("La pila esta vacia: " + p.isEmpty());
        
    }
}
