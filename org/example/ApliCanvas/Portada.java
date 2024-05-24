package org.example.ApliCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by desir 🥑on 11  mayo, 2024
 */
public class Portada extends JPanel {
    private ImageIcon imageIcon;

    public Portada() { // creamos constructor
        setLayout(new BorderLayout());
        JPanel panelBoton = new JPanel();
        JButton boton = new JButton("Iniciar Juego");

        boton.addActionListener(e -> {
            VentanaMultimedia ventana = new VentanaMultimedia("PING PONG", 800, 600, 1, Color.WHITE);
            PrincipalDemoCuadrado juego = new PrincipalDemoCuadrado(ventana); // Pasar ventana al constructor
            juego.iniciarJuego();
        });

        panelBoton.add(boton);
        panelBoton.setPreferredSize(new Dimension(100, 50));
        add(panelBoton, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon imagen = new ImageIcon("/org/example/ApliCanvas/images.jpg");
        // g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), this);
        JLabel imagenFondo=new JLabel(imageIcon);
        this.add(imagenFondo);
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("PING PONG");
        Portada fondo = new Portada();
        ventana.setContentPane(fondo);
        ventana.setSize(800, 800);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
