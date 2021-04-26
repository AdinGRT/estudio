public class TestAdinRubio {
    public static void main(String[] args) {

        // Metodo que ordene un arreglo numerico de mayo a menor sin importar el tamanio.
        int[] arregloEnteros = {2, 4, 1, 9, 8, 0};
        String cadena = "adan 2323 lalo";

        //System.out.println(obtenerCaracteres(cadena));
        //System.out.println("Contiene letras: " + contieneLetras(cadena));
        //System.out.println("Contiene numeros: " + contieneNumeros(cadena));
        //System.out.println("Apariciones de s: " + contarAparicionesDeCaracter(cadena, 's'));
        //imprimirPosiciones(cadena, 'a');


        indicarComposicionDeCadena(cadena);
        determinarPalindromo("re conoc er");
        /*
        recorrerArreglo(arregloEnteros);
        determinarOrdenArreglo(arregloEnteros);
        ordenarArregloDsc(arregloEnteros);
        recorrerArreglo(arregloEnteros);
        determinarOrdenArreglo(arregloEnteros);
        ordenarArregloAsc(arregloEnteros);
        recorrerArreglo(arregloEnteros);
        determinarOrdenArreglo(arregloEnteros);
        determinarNumeroPerfecto(28);

        */
    }

    /*
        adan
        a | d | n
     */

    public static void indicarComposicionDeCadena(String cadena) {
        String composicion = obtenerCaracteres(cadena);
        System.out.println("Composicion de la cadena: " + cadena);
        for (int i = 0; i < composicion.length(); i++) {
            char temp = composicion.charAt(i);
            System.out.print("El caracter " + temp + " aparece " + contarAparicionesDeCaracter(cadena, temp));
            System.out.print(" veces y sus posiciones son: ");
            imprimirPosiciones(cadena, temp);
            System.out.println();
        }
        if (contieneNumeros(cadena)) {
            System.out.println("La cadena tiene numeros.");
        }
        if (contieneLetras(cadena)) {
            System.out.println("La cadena tiene letras.");
        }
    }

    public static void imprimirPosiciones(String cadena, char a) {
        int index = 0;
        int posicion = cadena.indexOf(a, index);
        while (posicion != -1) {
            index = posicion + 1;
            System.out.print(posicion + ", ");
            posicion = cadena.indexOf(a, index);
        }
    }

    public static int contarAparicionesDeCaracter(String cadena, char a) {
        int contador = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == a) {
                contador++;
            }
        }
        return contador;
    }

    public static boolean contieneNumeros(String cadena) {
        boolean hayNumeros = false;
        char aux;
        for (int i = 0; i < cadena.length(); i++) {
            aux = cadena.charAt(i);
            if (Character.isDigit(aux)) {
                hayNumeros = true;
            }
        }
        return hayNumeros;
    }

    public static boolean contieneLetras(String cadena) {
        boolean hayLetras = false;
        char aux;
        for (int i = 0; i < cadena.length(); i++) {
            aux = cadena.charAt(i);
            if ((aux >= 'a' && aux <= 'z') || (aux >= 'A' && aux <= 'Z')) {
                hayLetras = true;
            }
        }
        return hayLetras;
    }

    public static String obtenerCaracteres(String cadena) {
        String tempCadena = "";
        boolean estaRepetido = false;
        for(int i=0;i<cadena.length();i++){
            if (tempCadena.equals("")) {
                tempCadena += cadena.charAt(i);
            } else {
                for(int j=0;j<tempCadena.length();j++) {
                    if(cadena.charAt(i) == tempCadena.charAt(j)) {
                        estaRepetido = true;
                        break;
                    } else {
                        estaRepetido = false;
                    }
                }
                if (!estaRepetido) {
                    tempCadena += cadena.charAt(i);
                }
            }
        }
        return tempCadena;
    }

    public static void determinarPalindromo(String cadena) {
        String nuevaCadena = "";
        cadena = cadena.replace(" ", "");

        for (int i = cadena.length()-1; i >= 0; i--) {
            nuevaCadena += cadena.charAt(i);
        }
        if(cadena.equals(nuevaCadena)) System.out.println("La palabra " + cadena + " es palindromo.");
        else System.out.println("La palabra " + cadena + " no es palindromo.");
    }

    public static void determinarNumeroPerfecto(int numero) {

        int sumatoria = 0;
        int contador = 1;
        int resto;
        while(numero != contador) {
            resto = numero % contador;
            if(resto == 0) {
                System.out.println(contador);
                sumatoria += contador;

            }
            contador++;
        }
        if (sumatoria == numero) {
            System.out.println("El numero " + numero + " es perfecto.");
        } else {
            System.out.println("El numero " + numero + " no es perfecto.");
        }
    }

    public static void ordenarArregloAsc(int[] arreglo) {
        int temp;
        for(int j = 0; j < arreglo.length; j++) {
            for(int i = 0; i < arreglo.length-1; i++) {
                if(arreglo[i] > arreglo[i+1]) {
                    temp = arreglo[i];
                    arreglo[i] = arreglo[i+1];
                    arreglo[i+1] = temp;
                }
            }
        }
    }

    public static void determinarOrdenArreglo(int[] arreglo) {
        boolean ordenAsc = false;
        boolean ordenDsc = false;
        for(int i = 0; i < arreglo.length-1; i++) {
            if(arreglo[i] < arreglo[i+1]) {
                ordenAsc = true;
            } else if(arreglo[i] > arreglo[i+1]){
                ordenDsc = true;
            }
            if(ordenAsc == true && ordenDsc == true) {
                System.out.println("Estan desordenados");
                break;
            }
        }
        if(ordenAsc && !ordenDsc) {
            System.out.println("Estan ordenados ascendentemente");
        } else if (!ordenAsc && ordenDsc){
            System.out.println("Estan ordenados descendentemente");
        }

    }

    public static void ordenarArregloDsc(int[] arreglo) {
        int temp;
        for(int j = 0; j < arreglo.length; j++) {
            for(int i = 0; i < arreglo.length-1; i++) {
                if(arreglo[i] < arreglo[i+1]) {
                    temp = arreglo[i];
                    arreglo[i] = arreglo[i+1];
                    arreglo[i+1] = temp;
                }
            }
        }
    }

    public static void recorrerArreglo(int[] arreglo) {
        for(int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + "|");
        }
    }
}
