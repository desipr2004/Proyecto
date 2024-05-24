package org.example.ApliCanvas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

//NOTA: los códigos de los colores están en forma de constantes en Color.ZZZ
//o se pueden crear en el momento mediante "new Color(int, int, int)".

public class VentanaMultimedia extends JFrame implements Lienzo {
    private static final long serialVersionUID = 1L;
    private int ancho = 200, alto = 200;
    private int tamPixel;
    private Color colorFondo;
    private GraphicsConfiguration configuracionGraficaSistema;
    private Canvas canvas;
    private BufferedImage imagenEnBuffer;
    private Graphics2D imagenG2D;
    private Teclado teclado = new Teclado();

    public VentanaMultimedia(String tituloVentana, int ancho, int alto, int tamPixel, Color colorFondo) {
        super(tituloVentana);
        this.ancho = ancho;
        this.alto = alto;
        this.tamPixel = tamPixel;
        this.colorFondo = colorFondo;
        GraphicsEnvironment entornoGrafico = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice adaptadorGrafico = entornoGrafico.getDefaultScreenDevice();
        configuracionGraficaSistema = adaptadorGrafico.getDefaultConfiguration();
        canvas = new Canvas(configuracionGraficaSistema);
        canvas.setSize(ancho * tamPixel, alto * tamPixel);
        canvas.setIgnoreRepaint(true);
        this.add(canvas);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.createBufferStrategy(2);
        imagenEnBuffer = configuracionGraficaSistema.createCompatibleImage(ancho * tamPixel, alto * tamPixel);
        imagenG2D = imagenEnBuffer.createGraphics();
        imagenG2D.setColor(colorFondo);
        imagenG2D.fillRect(0, 0, ancho * tamPixel, alto * tamPixel);
        canvas.addKeyListener(teclado);

    }

    public Teclado getTeclado() {
        return teclado;
    }

    public void limpiar() {
        imagenG2D.setColor(colorFondo);
        imagenG2D.fillRect(0, 0, ancho * tamPixel, alto * tamPixel);
    }

    public void marcarPixel(int x, int y, Color color) {
        imagenG2D.setColor(color);
        imagenG2D.fillRect(x * tamPixel, y * tamPixel, tamPixel, tamPixel);
    }

    public void escribirTexto(int x, int y, String texto, Color color) {
        imagenG2D.setColor(color);
        imagenG2D.drawString(texto, x * tamPixel, (y + 1) * tamPixel);
    }

    public void volcar() {
        BufferStrategy buffer = canvas.getBufferStrategy();
        Graphics graphics = buffer.getDrawGraphics();
        graphics.drawImage(imagenEnBuffer, 0, 0, null);
        if (!buffer.contentsLost()) buffer.show();
    }

    public int getTamX() {
        return ancho;
    }

    public int getTamY() {
        return alto;
    }

    public void redimensionar(int tamX, int tamY) {
        ancho = tamX;
        alto = tamY;
        ajustarTamannoMarco();
    }

    private void ajustarTamannoMarco() {
        canvas.setSize(ancho * tamPixel, alto * tamPixel);
        this.pack();
    }

    public Lienzo getLienzo() {
        return this;
    }

    public static void main(String[] args) {
        VentanaMultimedia prueba= new VentanaMultimedia(
                "Prueba",200,200,100,Color.pink
        );
    }
}