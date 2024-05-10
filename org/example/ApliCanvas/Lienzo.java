package org.example.ApliCanvas;

/**
 * Created by desir 🥑on 17  abril, 2024
 */
import java.awt.Color;

//NOTA: los códigos de los colores están en forma de constantes en Color.ZZZ
//      o se pueden crear en el momento mediante "new Color(int, int, int)".

public interface Lienzo {
    public int getTamX();
    public int getTamY();
    public void redimensionar(int tamX, int tamY);

    public void limpiar();
    public void marcarPixel(int x, int y, Color color);
    public void marcarPixel2(int x, int y, Color color);
    public void escribirTexto(int x, int y, String texto, Color color);

    public void volcar();


    void dibujar2();
}

