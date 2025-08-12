package visual;

import javax.swing.*;
import java.awt.*;

public class VentanaClasesGrupales extends JFrame {

    private Socio socio;
    private ClasesGrupales clasesGrupales;

    private DefaultListModel<String> model;

    public VentanaClasesGrupales(Socio socio, ClasesGrupales clasesGrupales) {
        this.socio = socio;
        this.clasesGrupales = clasesGrupales;

        setTitle("Clases Grupales");
        setSize(450, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Fondo negro para la ventana
        getContentPane().setBackground(Color.BLACK);

        model = new DefaultListModel<>();
        JList<String> listaClases = new JList<>(model);
        JScrollPane scroll = new JScrollPane(listaClases);

        // Estilo lista
        listaClases.setBackground(Color.DARK_GRAY);
        listaClases.setForeground(Color.ORANGE);
        listaClases.setFont(new Font("Arial", Font.BOLD, 14));

        JButton btnReservar = new JButton("Reservar Clase");
        JButton btnLiberar = new JButton("Liberar Reserva");
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
            String input = JOptionPane.showInputDialog("Ingrese número de clase a reservar:");
            if (input != null) {
                try {
                    int num = Integer.parseInt(input.trim());
                    clasesGrupales.reservarClase(socio, num);
                    actualizarLista();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Número inválido.");
                }
            }
        });

        btnLiberar.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Ingrese número de clase para liberar reserva:");
            if (input != null) {
                try {
                    int num = Integer.parseInt(input.trim());
                    clasesGrupales.liberarReserva(num);
                    actualizarLista();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Número inválido.");
                }
            }
        });

        btnCerrar.addActionListener(e -> dispose());
    }

    private void actualizarLista() {
        model.clear();
        String[] datos = clasesGrupales.resumenClases().split("\n");
        for (String linea : datos) {
            model.addElement(linea);
        }
    }
}
