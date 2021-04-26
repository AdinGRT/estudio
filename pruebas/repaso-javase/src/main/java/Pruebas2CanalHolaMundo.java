import java.util.Arrays;

public class Pruebas2CanalHolaMundo {
    public static void main(String[] args) {
        System.out.println("Resultado de 4x5 " + multiplicar(4, -5) );
        int[] arreglo = {1,4,5,5,1,1};
        System.out.println("El mayor numero del arreglo es: " + obtenerMayorEnArreglo(arreglo));


    }

    //1. Multiplicar dos numeros sin usar el operador *
    public static int multiplicar(int numero1, int numero2) {
        int resultado = 0;
        boolean positivo = Math.abs(numero1) == numero1;
        for (int i = 0; i < Math.abs(numero1); i++) {
            resultado = positivo ? resultado + numero2 : resultado - numero2;
        }
        return resultado;
    }

    //2. Obtener el mayor numero de un arreglo pero iterando una sola vez
    public static int obtenerMayorEnArreglo(int[] arreglo) {
        int temp = 0;

        for (int i = 0; i < arreglo.length-1; i++) {
            if(arreglo[i] > temp) {
                temp = arreglo[i];
            }
        }
        return temp;
    }
}
