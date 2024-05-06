package org.example;

/**
 * Created by desir 🥑on 17  abril, 2024
 */
public class Jugadores {
    private String nombre;
    private int puntos;

    public Jugadores(String nombre, int puntos) {
        this.nombre = nombre;
        this.puntos = puntos;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
