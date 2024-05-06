package org.example.PkDemoBolas;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;


import org.example.ApliCanvas.Lienzo;
import org.example.ApliCanvas.PantallaBN;
import org.example.ApliCanvas.Utilidades;
import org.example.ApliCanvas.VentanaMultimedia;

public class PrincipalDemoBolas {
    private static final int DELAY = 30; // Milisegundos.
    private static final Random aleatorio = new Random();

    public static void main(String[] args) {
        boolean pantallaBuena = true; // true: VentanaMultimedia; false: PantallaBN
        boolean aumentoProgresivoPantalla = false;

        Lienzo lienzo;
        if (pantallaBuena) {
            lienzo = new VentanaMultimedia("PIN PON", 50, 50, 10, Color.BLACK);
            ((VentanaMultimedia) lienzo).setTitle("PIN PON");
        } else {
            lienzo = new PantallaBN(16, 16);
        }

        ArrayList<Pelota> bolas = new ArrayList<Pelota>();

        double anguloAleatorioX = aleatorio.nextDouble()* 360;
        bolas.add(new Pelota(16, 16, anguloAleatorioX , 0.50, 3,4 ,Color.BLUE, lienzo));

        while (true) {
            if (aumentoProgresivoPantalla && Math.random() < 0.02) {
                lienzo.redimensionar(lienzo.getTamX() + 1, lienzo.getTamY() + 1);
            }

            lienzo.limpiar();


            for (Pelota bola : bolas) {
                bola.tick();
                bola.dibujar();
            }

            lienzo.volcar();

            Utilidades.espera(DELAY);
        }
    }
}