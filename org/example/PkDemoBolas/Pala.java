package org.example.PkDemoBolas;

import org.example.ApliCanvas.Dibujable;
import org.example.ApliCanvas.Lienzo;

import java.awt.*;

/**
 * Created by desir 🥑on 04  mayo, 2024
 */
public class Pala implements Dibujable {
    private int x, y; //posicion de la pala
    private int ancho, alto; // dimensiones de la pala
    private Color color;
    private Lienzo lienzo;

    public Pala(int x, int y, int ancho, int alto, Color color, Lienzo lienzo) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.color = color;
        this.lienzo = lienzo;

    }


    public void mover(int deltaY) {
        this.y += deltaY;// Esto aumenta o disminuye el tamaño de la pala
        this.y = Math.max(0, Math.min(lienzo.getTamY() - alto, this.y));//  // Para que la pala no se salga del lienzo
        // ademas al asegurarnos de que this.y sea menor que 0, impide que la pala se salga por arriba del lienzo
    }


    @Override
    public void setLienzo(Lienzo lienzo) {
        this.lienzo = lienzo;
    }

    @Override
    public void dibujar() {
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                lienzo.marcarPixel(x + j, y + i, color);
            }
        }
    }
}
