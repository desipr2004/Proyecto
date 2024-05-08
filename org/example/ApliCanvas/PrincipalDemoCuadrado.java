package org.example.ApliCanvas;

import java.awt.Color;
import java.awt.event.KeyEvent;

/**
 * Created by desir 🥑on 17  abril, 2024
 */
public class PrincipalDemoCuadrado {
    private static final int DELAY = 50; // Milisegundos.
    private static final int velocidadInicial_X = 1;
    private static final int velocidadInicial_Y = 1;
    private static final int velocidadMaximaPelota = 5;
    private static final int incrementoDeVelocidad = 1;

    public static void main(String[] args) {
        VentanaMultimedia ventana = new VentanaMultimedia("Ventana gráfica", 20, 20, 20, Color.BLACK);

        int x = 10, y = 10;


        int direccionX = 1;
        int direccionY = 1;
        int velocidadX = 1;
        int velocidadX = velocidadInicial_X;
        int velocidadY = velocidadInicial_Y;

        boolean modoTecladoContinuo = true; // true: modo continuo / false: modo "1-vez".

        Teclado teclado = ventana.getTeclado();

        while (true) { // Al cerrar la ventana se acaba la aplicación.


            ventana.limpiar();

            x += direccionX * velocidadX;
            y += direccionY * velocidadY ;

            if (x <=0)
            if (modoTecladoContinuo) {
                if (teclado.pulsada(KeyEvent.VK_LEFT) && x > 0) x--;
                if (teclado.pulsada(KeyEvent.VK_RIGHT) && x < ventana.getAncho() - 1) x++;
                if (teclado.pulsada(KeyEvent.VK_UP) && y > 0) y--;
                if (teclado.pulsada(KeyEvent.VK_DOWN) && y < ventana.getAlto() - 1) y++;
            } else {
                if (teclado.pulsada1Vez(KeyEvent.VK_LEFT) && x > 0) x--;
                if (teclado.pulsada1Vez(KeyEvent.VK_RIGHT) && x < ventana.getAncho() - 1) x++;
                if (teclado.pulsada1Vez(KeyEvent.VK_UP) && y > 0) y--;
                if (teclado.pulsada1Vez(KeyEvent.VK_DOWN) && y < ventana.getAlto() - 1) y++;
            }

            ventana.marcarPixel(x, y, Color.GREEN);


            ventana.volcar();

            Utilidades.espera(DELAY);
        }
    }
}

