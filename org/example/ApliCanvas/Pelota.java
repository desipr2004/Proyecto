package org.example.ApliCanvas;

import java.awt.Color;
import java.util.Random;

import org.example.ApliCanvas.Dibujable;
import org.example.ApliCanvas.Lienzo;
import org.example.ApliCanvas.Pala;
import org.example.ApliCanvas.Tickable;


public class Pelota implements Dibujable, Tickable {
    private double posX, posY;
    private double angulo;
    private double velocidad;
    private double elasticidad;
    private Color color;
    private Lienzo lienzo;

    // Movimientos aleatorios en la pantalla

    private Random aleatorio = new Random();
    private boolean rapidez = false;

    private int anchoPaleta;

    public Pelota(double posX, double posY, double angulo, double velocidad, double elasticidad, int anchoPaleta, Color color, Lienzo lienzo) {
        this.posX = posX;
        this.posY = posY;
        this.angulo = angulo;
        this.velocidad = velocidad;
        this.elasticidad = elasticidad;
        this.anchoPaleta = anchoPaleta;
        this.color = color;
        this.lienzo = lienzo;
    }


    public void setLienzo(Lienzo lienzo) {
        this.lienzo = lienzo;
    }

    public void tick(Pala pala1, Pala pala2) {
        if (System.currentTimeMillis() % 2000 == 0) {
            rapidez = !rapidez;
            if (rapidez) {
                velocidad = 50; //Para que la pelota vaya más rápido
            } else {
                velocidad = 0.5; // Para que la pelota vaya maas despacio
            }
        }

// Convierte el angulo en radianes que serian los desplazamientos
        double minimo = 10;
        double maximo = 20;
        double numeroEnRango = minimo + (maximo - minimo) * Math.random(); // Genera un número entre 10 (inclusive) y 20 (exclusivo)

        double desplazamientoX = velocidad * Math.cos(Math.toRadians(angulo+numeroEnRango));
        double desplazamientoY = velocidad * Math.sin(Math.toRadians(angulo+numeroEnRango));

//Mover la pelota
        posX += desplazamientoX;
        posY += desplazamientoY;

        // Rebotar en los bordes verticales del lienzo
        if (posY <= 0 || posY >= lienzo.getTamY() - 1 ) { // comprueba si la pelota esta en el borde superior o inferior del lienzo
            angulo = 360 - angulo; // se le resta para que rebote en sentido contrario
            posY = Math.max(0, Math.min(lienzo.getTamY() - 1, posY)); // se asegura de que la pelota no salga del lienzo
        }

        //Para que rebote en las palas

        if (colisionarConPala(pala1) || colisionarConPala(pala2)) {
            angulo = 180 - angulo + aleatorio.nextDouble() * 20 - 10;
            posX = Math.max(0, Math.min(lienzo.getTamX() - 1, posX));
        }
    }

    public void dibujar() {// toma las posiciones de la pelota y se van visiualizando en la pantalla
        lienzo.marcarPixel((int) Math.floor(posX), (int) Math.floor(posY), color);
    }

    private boolean colisionarConPala(Pala pala) {
        // Hay que asegurarse de la colision con la pala de arriba y abajo

        if (posX <= anchoPaleta && posY >= lienzo.getTamY() / 4 && posY <= 3 * lienzo.getTamY() / 4) {
            return true;
        }
        if (posX >= lienzo.getTamX() - 1 - anchoPaleta && posY >= lienzo.getTamY() / 4 && posY <= 3 * lienzo.getTamY() / 4) {
            return true;
        }

        return false;
    }// verifica si la bola esta muy cerca del borde derechp del lienzo y dentro del rango vertical
    // que corresponde a la pala de abajo

    public void invertirVelocidadHorizontal() {
        angulo = (angulo + 180) % 360;// este metodo cambia la direccion de lapelota unos 180 grados
    }

}
