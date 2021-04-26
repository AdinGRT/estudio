package estructura.test;

import estructura.linkedlist.DoubleLinkedList;

/**
 *
 * @author adingrt
 */
public class TestList {
    public static void main(String[] args) {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        
        String meter = "A";
        list.addFirst(meter);
        
        meter = "B";
        list.addLast(meter);
        
        meter = "C";
        list.addFirst(meter);
        
        System.out.println("El primer elemento es: " + list.getFirst());
        System.out.println("El ultimo elemento es: " + list.getLast());
        System.out.println("El tamanio de la lista es: " + list.size());
        System.out.println("El elemento buscado es: " + list.get(1));
        list.remove(1);
        System.out.println("");
        System.out.println("El primer elemento es: " + list.getFirst());
        System.out.println("El ultimo elemento es: " + list.getLast());
        System.out.println("El tamanio de la lista es: " + list.size());
        System.out.println("El elemento buscado es: " + list.get(1));
        meter = "Z";
        list.add(meter, 0);
        System.out.println("");
        System.out.println("El primer elemento es: " + list.getFirst());
        System.out.println("El ultimo elemento es: " + list.getLast());
        System.out.println("El tamanio de la lista es: " + list.size());
        System.out.println("El elemento buscado es: " + list.get(1));
        
    }
}
