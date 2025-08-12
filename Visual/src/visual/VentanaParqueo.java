package visual;

import javax.swing.*;
import java.awt.*;

public class VentanaParqueo extends JFrame {

    private Socio socio;
    private Parqueo parqueo;

    private JTextArea areaEstado;

    public VentanaParqueo(Socio socio, Parqueo parqueo) {
        this.socio = socio;
        this.parqueo = parqueo;

        setTitle("Parqueo");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        getContentPane().setBackground(Color.BLACK);

        areaEstado = new JTextArea();
        areaEstado.setEditable(false);
        areaEstado.setBackground(Color.DARK_GRAY);
        areaEstado.setForeground(Color.ORANGE);
        areaEstado.setFont(new Font("Arial", Font.BOLD, 14));
        JScrollPane scroll = new JScrollPane(areaEstado);

        JButton btnMostrar = new JButton("Mostrar Estado");
        JButton btnReservar = new JButton("Reservar Espacio");
        JButton btnLiberar = new JButton("Liberar Espacio");
        JButton btnCerrar = new JButton("Cerrar");

        Color botonNaranja = new Color(255, 140, 0);
        Font fuenteBotones = new Font("Arial", Font.BOLD, 14);

        btnMostrar.setBackground(botonNaranja);
        btnMostrar.setForeground(Color.BLACK);
        btnMostrar.setFont(fuenteBotones);

        btnReservar.setBackground(botonNaranja);
        btnReservar.setForeground(Color.BLACK);
        btnReservar.setFont(fuenteBotones);

        btnLiberar.setBackground(botonNaranja);
        btnLiberar.setForeground(Color.BLACK);
        btnLiberar.setFont(fuenteBotones);

        btnCerrar.setBackground(botonNaranja);
        btnCerrar.setForeground(Color.BLACK);
        btnCerrar.setFont(fuenteBotones);

        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(Color.BLACK);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnReservar);
        panelBotones.add(btnLiberar);
        panelBotones.add(btnCerrar);

        add(scroll, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        btnMostrar.addActionListener(e -> areaEstado.setText(parqueo.mostrarEstado()));

        btnReservar.addActionListener(e -> {
            parqueo.reservarEspacioGUI(socio);
            areaEstado.setText(parqueo.mostrarEstado());
        });

        btnLiberar.addActionListener(e -> {
            parqueo.liberarEspacioGUI();
            areaEstado.setText(parqueo.mostrarEstado());
        });

        btnCerrar.addActionListener(e -> dispose());
    }
}
