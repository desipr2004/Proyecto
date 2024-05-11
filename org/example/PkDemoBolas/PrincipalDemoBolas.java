package org.example.PkDemoBolas;

import java.awt.Color;


import org.example.ApliCanvas.*;

public class PrincipalDemoBolas {
    private static final int DELAY = 30; // Milisegundos.

    public static void main(String[] args) {

        Lienzo lienzo = new VentanaMultimedia("A jugar!!");
        ((VentanaMultimedia) lienzo).setTitle("PIN PON");

        //Creacion de la bola y la pala y las agregamos al lienzo
        Pelota bola = new Pelota(16, 16, 45, 0.50, 3, 4, Color.white, lienzo);
        Pala pala1 = new Pala(20, 200, 20, 100, Color.pink, lienzo);
        Pala pala2 = new Pala(460, 200, 20, 100, Color.pink, lienzo);


        while (true) {

            lienzo.limpiar();
            bola.tick(pala1, pala2);
            bola.dibujar();
            pala1.dibujar();
            pala2.dibujar();
            lienzo.volcar();

            Utilidades.espera(DELAY);
        }
    }
}