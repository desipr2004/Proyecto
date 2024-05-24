package org.example.PkDemoBolas;

import java.awt.Color;


import org.example.ApliCanvas.*;

public class PrincipalDemoBolas {
    private static final int DELAY = 30; // Milisegundos.

    public static void main(String[] args) {

        Lienzo lienzo = new VentanaMultimedia("A jugar!!",400,400,2,Color.pink);
        ((VentanaMultimedia) lienzo).setTitle("PIN PON");

        //Creacion de la bola y la pala y las agregamos al lienzo
// Ejemplo si los argumentos debían ser reorganizados:
        Pelota bola = new Pelota(16.00, 16.00, 45.00, 1, 20, Color.black, lienzo);
        Pala pala1 = new Pala((int) 20.0, (int) 200.0, (int) 20.0, 100, Color.pink, lienzo);

        Pala pala2 = new Pala((int) 460.0, (int) 200.0, (int) 20.0, 100, Color.pink, lienzo);


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