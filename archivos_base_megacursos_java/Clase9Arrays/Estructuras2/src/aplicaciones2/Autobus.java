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
public class Autobus {
    String origen;
    String destino;
    int duracion;
    Pasajero[] pasajeros;

    public Autobus(String origen, String destino, int duracion, Pasajero[] pasajeros) {
        this.origen = origen;
        this.destino = destino;
        this.duracion = duracion;
        this.pasajeros = pasajeros;
    }

    public Autobus() {
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Pasajero[] getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(Pasajero[] pasajeros) {
        this.pasajeros = pasajeros;
    }

    @Override
    public String toString() {
        return "Autobus{" + "origen=" + origen + ", destino=" + destino + ", duracion=" + duracion + ", pasajeros=" + pasajeros + '}';
    }
    
    
    
    
}
