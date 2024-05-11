package org.example.ApliCanvas;

import java.awt.Color;
import java.awt.event.KeyEvent;

/**
 * Created by desir 🥑on 17  abril, 2024
 */
public class PrincipalDemoCuadrado {
    private static final int DELAY = 250; // Milisegundos.
    private static final int velocidadInicial_X = 1;
    private static final int velocidadInicial_Y = 2;
    private static final int velocidadMaximaPelota = 1;
    private static final int incrementoDeVelocidad = 0;
    private VentanaMultimedia ventana;

    public PrincipalDemoCuadrado(VentanaMultimedia ventana) {
        this.ventana = ventana;
    }

    public void iniciarJuego() {
        int x = 10, y = 10;
        int q = 0, w = 5;

        int direccionX = 1;
        int direccionY = 1;
        int velocidadX = velocidadInicial_X;
        int velocidadY = velocidadInicial_Y;

          boolean modoTecladoContinuo = true; // true: modo continuo / false: modo "1-vez".

        Teclado teclado = ventana.getTeclado();

        while (true) { // Al cerrar la ventana se acaba la aplicación.


            ventana.limpiar();

            x += direccionX * velocidadX;
            y += direccionY * velocidadY;
            w += direccionY * velocidadY;

            if (x <= 0 || x >= ventana.getAncho() - 1) {
                direccionX *= -1;
            }

            if (y <= 0 || y >= ventana.getAlto() - 1) {
                direccionY *= -1;
            }
            if (modoTecladoContinuo) {
            if (teclado.pulsada(KeyEvent.VK_UP) && y > 0) y--;
            if (teclado.pulsada(KeyEvent.VK_DOWN) && y < ventana.getAlto() - 1) y++;
             } else {
            if (teclado.pulsada1Vez(KeyEvent.VK_UP) && y > 0) y--;
            if (teclado.pulsada1Vez(KeyEvent.VK_DOWN) && y < ventana.getAlto() - 1) y++;
             }

            ventana.marcarPixel(x, y, Color.GREEN);

            ventana.marcarPixel2(q, w, Color.red);
            int g = 19;
            int h = 5;

            ventana.marcarPixel2(q, w, Color.red);
            ventana.volcar();

            Utilidades.espera(DELAY);
        }
    }

    public static void main(String[] args) {
        // Código para iniciar el juego aquí
        VentanaMultimedia ventana = new VentanaMultimedia("Nombre del Juego");
        ventana.redimensionar(800, 600); // ajusta el tamaño como desees
        ventana.limpiar();
        ventana.volcar();

        PrincipalDemoCuadrado juego = new PrincipalDemoCuadrado(ventana);
        juego.iniciarJuego();
    }
}


