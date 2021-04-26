package estructura.test;

import estructura.cola.ColaDoble;

/**
 *
 * @author adingrt
 */
public class TestCola {
    
    public static void main(String[] args) {
        ColaDoble c = new ColaDoble();
        
        System.out.println("La pila esta vacia: " + c.isEmpty());
        
        String meter = "A";
        c.enqueue(meter);
        System.out.println("El primero en la cola es: " + (String) c.front());
        System.out.println("El ultimo en la cola es: " + (String) c.tail());
        System.out.println("Size de la Pila: " + c.size());
        
        meter = "B";
        c.enqueue(meter);
        System.out.println("El primero en la cola es: " + (String) c.front());
        System.out.println("El ultimo en la cola es: " + (String) c.tail());
        System.out.println("Size de la Pila: " + c.size());
        
        meter = "C";
        c.enqueue(meter);
        System.out.println("El primero en la cola es: " + (String) c.front());
        System.out.println("El ultimo en la cola es: " + (String) c.tail());
        System.out.println("Size de la Pila: " + c.size());
        
        c.dequeue();
        System.out.println("El primero en la cola es: " + (String) c.front());
        System.out.println("El ultimo en la cola es: " + (String) c.tail());
        System.out.println("Size de la Pila: " + c.size());
        
        System.out.println("La pila esta vacia: " + c.isEmpty());
    }
    
    
}
