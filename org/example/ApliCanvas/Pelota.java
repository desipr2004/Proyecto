package org.example.ApliCanvas;

import java.awt.Color;
import java.util.Random;

public class Pelota implements Dibujable, Tickable {
    private double posX, posY;
    private double angulo;
    private double velocidad;
    private int anchoPaleta;
    private Color color;
    private Lienzo lienzo;

    private Random aleatorio = new Random();
    private boolean rapidez = false;

    public Pelota(double posX, double posY, double angulo, double velocidad, int anchoPaleta, Color color, Lienzo lienzo) {
        this.posX = posX;
        this.posY = posY;
        this.angulo = angulo;
        this.velocidad = velocidad;
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
                velocidad = 1; // Para que la pelota vaya más rápido
            } else {
                velocidad = 0.5; // Para que la pelota vaya más despacio
            }
        }

        // Convertir el ángulo en radianes para calcular los desplazamientos
        double desplazamientoX = velocidad * Math.cos(Math.toRadians(angulo));
        double desplazamientoY = velocidad * Math.sin(Math.toRadians(angulo));

        // Mover la pelota
        posX += desplazamientoX;
        posY += desplazamientoY;

        // Rebotar en los bordes verticales del lienzo
        if (posY <= 0 || posY >= lienzo.getTamY() - 1) { // Comprueba si la pelota está en el borde superior o inferior del lienzo
            angulo = 360 - angulo; // Cambia la dirección para que rebote
        }

        // Rebotar en las palas
        if (colisionarConPala(pala1) || colisionarConPala(pala2)) {
            angulo = 180 - angulo + aleatorio.nextDouble() * 20 - 10; // Añadir un pequeño ángulo aleatorio para variar
        }
    }

    public void dibujar() {
        lienzo.marcarPixel((int) Math.floor(posX), (int) Math.floor(posY), color);
    }

    private boolean colisionarConPala(Pala pala) {
        // Verificar colisión con la pala
        if (pala != null) {
            int palaX = (int) pala.getPosX();
            int palaY = (int) pala.getPosY();
            int palaAncho = pala.getAncho();
            int palaAlto = pala.getAlto();

            if (posX >= palaX && posX <= palaX + palaAncho && posY >= palaY && posY <= palaY + palaAlto) {
                return true;
            }
        }
        return false;
    }

    public void invertirVelocidadHorizontal() {
        angulo = (angulo + 180) % 360; // Este método cambia la dirección de la pelota 180 grados
    }

    public void mover() {
        tick(null, null); // Llamar al método tick sin palas para solo mover la pelota
    }

    public void comprobarColision(Pala pala1) {
        if (colisionarConPala(pala1)) {
            invertirVelocidadHorizontal();
        }
    }
}
