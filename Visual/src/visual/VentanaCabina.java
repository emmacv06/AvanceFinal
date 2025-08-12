package visual;

import javax.swing.*;
import java.awt.*;

public class VentanaCabina extends JFrame {

    private Socio socio;
    private Cabina cabina;

    private DefaultListModel<String> model;

    public VentanaCabina(Socio socio, Cabina cabina) {
        this.socio = socio;
        this.cabina = cabina;

        setTitle("Cabina");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Fondo negro para toda la ventana
        getContentPane().setBackground(Color.BLACK);

        model = new DefaultListModel<>();
        JList<String> listaHorarios = new JList<>(model);
        JScrollPane scroll = new JScrollPane(listaHorarios);

        // Estilo lista: fondo gris oscuro y texto naranja
        listaHorarios.setBackground(Color.DARK_GRAY);
        listaHorarios.setForeground(Color.ORANGE);
        listaHorarios.setFont(new Font("Arial", Font.BOLD, 14));

        JButton btnReservar = new JButton("Reservar Horario");
        JButton btnLiberar = new JButton("Liberar Horario");
        JButton btnCerrar = new JButton("Cerrar");

        Color botonNaranja = new Color(255, 140, 0);
        Font fuenteBotones = new Font("Arial", Font.BOLD, 14);

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
        panelBotones.add(btnReservar);
        panelBotones.add(btnLiberar);
        panelBotones.add(btnCerrar);

        add(scroll, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        actualizarLista();

        btnReservar.addActionListener(e -> {
            String hora = JOptionPane.showInputDialog("Ingrese horario para reservar (ejemplo: 9am):");
            if (hora != null) {
                cabina.reservarHorario(socio, hora.trim());
                actualizarLista();
            }
        });

        btnLiberar.addActionListener(e -> {
            String hora = JOptionPane.showInputDialog("Ingrese horario para liberar (ejemplo: 9am):");
            if (hora != null) {
                cabina.liberarReserva(hora.trim());
                actualizarLista();
            }
        });

        btnCerrar.addActionListener(e -> dispose());
    }

    private void actualizarLista() {
        model.clear();
        String[] datos = cabina.getHorariosEstado().split("\n");
        for (String linea : datos) {
            model.addElement(linea);
        }
    }
}
