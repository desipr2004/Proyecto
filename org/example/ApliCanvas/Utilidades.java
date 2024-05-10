package org.example.ApliCanvas;

/**
 * Created by desir 🥑on 17  abril, 2024
 */
public class Utilidades {
    public static void espera(int milisegundos) {
        // Se espera unos milisegundos.
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            // No hacemos nada/anulamos la posible excepción.
        }
    }
}
