package org.example.ApliCanvas;

import java.awt.Color;
import java.awt.event.KeyEvent;

/**
 * Created by desir 🥑on 17 abril, 2024
 */
public class PrincipalDemoCuadrado {
    private VentanaMultimedia ventana;
    private Teclado teclado;
    private Pelota pelota;
    private Pala pala1;
    private Pala pala2;
    private static final int DELAY = 30;

    public PrincipalDemoCuadrado(VentanaMultimedia ventana) {
        System.out.println("Inicializando PrincipalDemoCuadrado...");
        this.ventana = ventana;
        this.teclado = ventana.getTeclado();
        this.pelota = new Pelota(ventana.getTamX() / 2.0, ventana.getTamY() / 2.0, 45.0, 2.0, 100, Color.BLACK, ventana);
        this.pala1 = new Pala(10, ventana.getTamY() / 2 - 30, 10, 60, Color.RED, ventana);
        this.pala2 = new Pala(ventana.getTamX() - 20, ventana.getTamY() / 2 - 30, 10, 60, Color.BLUE, ventana);

        if (this.pala1 == null || this.pala2 == null) {
            throw new RuntimeException("Las palas no se inicializaron correctamente");
        }
    }

    public void iniciarJuego() {
        System.out.println("Iniciando el juego...");
        while (true) {

            ventana.limpiar();
            System.out.println("Ventana limpiada");
            pelota.dibujar();
            if (teclado.pulsada(KeyEvent.VK_UP)) pala1.mover(-2);
            if (teclado.pulsada(KeyEvent.VK_DOWN)) pala1.mover(2);

            pelota.mover();
            System.out.println("Pelota movida");

            pelota.comprobarColision(pala1);
            pelota.comprobarColision(pala2);

            pala1.dibujar();
            pala2.dibujar();
            pelota.dibujar();
            System.out.println("Elementos dibujados");

            ventana.volcar();
            System.out.println("Contenido volcado");

            Utilidades.espera(DELAY);
        }
    }

    public static void main(String[] args) {
        System.out.println("Creando ventana multimedia...");
        VentanaMultimedia ventana = new VentanaMultimedia("PING PONG", 800, 600, 1, Color.pink);
       PrincipalDemoCuadrado juego = new PrincipalDemoCuadrado(ventana);
        juego.iniciarJuego();
    }
}
