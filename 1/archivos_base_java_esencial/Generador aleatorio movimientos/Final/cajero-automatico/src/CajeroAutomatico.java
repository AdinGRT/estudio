import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/*

Clase que emula las funcionalidades de un cajero automático.

La clase tendrá una variable de instancia llamada cuentaBancariaActual de tipo CuentaBancaria

La clase tendrá un constructor que tendrá como parámetros un String que identifica al usuario y otro String que contiene una contraseña.

Como se trata de una emulación, en lugar de conectar con la base de datos del banco para que nos devuelva la cuenta bancaria del usuario lo que vamos a hacer es crear un objeto de la clase CuentaBancaria con un nombre cualquiera y un saldo aleatorio

Esta clase tendrá los siguientes métodos:



mostrarSaldo() -> Mostrará por pantalla el saldo de cuentaBancariaActual

ingresarDinero() -> Preguntará al usuario cuánto dinero quiere ingresar y lo ingresará en cuentaBancariaActual

sacarDinero() -> Preguntará al usuario cuánto dinero quiere sacar y lo sacará de cuentaBancariaActual

consultarUltimosMovimientos -> Este método de momento no hará nada

salir() -> Dará las gracias al usuario por usar sus servicios



*/
public class CajeroAutomatico {

    CuentaBancaria cuentaBancariaActual;

    CajeroAutomatico(String identificador, String contraseña) {
        double cantidadAleatoria = ThreadLocalRandom.current().nextDouble(0, 50000);
        cuentaBancariaActual = new CuentaBancaria("Nombre cualquiera", cantidadAleatoria);
    }

    void mostrarSaldo() {
        System.out.println("Su saldo es " + cuentaBancariaActual.obtenerSaldo());
    }

    void ingresarDinero() {
        System.out.println("¿Cuánto dinero quiere ingresar?");
        Scanner scanner = new Scanner(System.in);
        double cantidad = scanner.nextDouble();
        cuentaBancariaActual.ingresarDinero(cantidad);
    }

    void sacarDinero() {
        System.out.println("¿Cuánto dinero quiere sacar?");
        Scanner scanner = new Scanner(System.in);
        double cantidad = scanner.nextDouble();
        cuentaBancariaActual.sacarDinero(cantidad);
    }

    void consultarUltimosMovimientos() {
        GeneradorAleatorioDeMovimientos generadorAleatorioDeMovimientos = new GeneradorAleatorioDeMovimientos();
        System.out.println("¿Cuántos movimientos quiere consultar?");
        Scanner scanner = new Scanner(System.in);
        int numeroDeMovimientos = scanner.nextInt();
        ArrayList<String> movimientos = generadorAleatorioDeMovimientos.obtenerMovimientos(numeroDeMovimientos, "euros");
        mostrarMovimientos(movimientos);
    }

    void mostrarMovimientos(ArrayList<String> movimientos) {
        for (String movimiento : movimientos) {
            System.out.println(movimiento);
        }
    }

    void salir() {
        System.out.println("Muchas gracias por utilizar nuestros servicios");
    }


}
