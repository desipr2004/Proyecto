package org.example.ApliCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by desir 🥑on 11  mayo, 2024
 */
public class Portada extends JPanel {
    public Portada() { // creamos constructor
        setLayout(new BorderLayout());
        JPanel panelBoton = new JPanel();
        JButton boton = new JButton("Iniciar Juego");

        boton.addActionListener(e -> {
            VentanaMultimedia ventana = new VentanaMultimedia("PING PONG");
            ventana.redimensionar(400, 400);
            ventana.limpiar();
            ventana.volcar();

            PrincipalDemoCuadrado juego = new PrincipalDemoCuadrado(ventana);
            juego.iniciarJuego();
        });

        panelBoton.add(boton);
        panelBoton.setPreferredSize(new Dimension(100,50));

    add(panelBoton, BorderLayout.SOUTH);

}

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ImageIcon imagen = new ImageIcon("C:\\Users\\desir\\IdeaProjects\\Proyecto\\src\\main\\java\\org\\example\\ApliCanvas\\images.jpg");

        g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), this);
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("PING PONG");
        Portada fondo = new Portada();
        ventana.setContentPane(fondo);
        ventana.setSize(400, 400);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
