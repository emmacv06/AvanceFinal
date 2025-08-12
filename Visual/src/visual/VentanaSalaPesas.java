package visual;

import javax.swing.*;
import java.awt.*;

public class VentanaSalaPesas extends JFrame {

    private Socio socio;
    private SalaDePesas salaDePesas;

    private DefaultListModel<String> model;

    public VentanaSalaPesas(Socio socio, SalaDePesas salaDePesas) {
        this.socio = socio;
        this.salaDePesas = salaDePesas;

        setTitle("Sala de Pesas");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Cambiar color de fondo de la ventana
        getContentPane().setBackground(Color.BLACK);

        model = new DefaultListModel<>();
        JList<String> listaReservas = new JList<>(model);
        JScrollPane scroll = new JScrollPane(listaReservas);

        // Cambiar fondo y color del texto de la lista
        listaReservas.setBackground(Color.DARK_GRAY);
        listaReservas.setForeground(Color.ORANGE);
        listaReservas.setFont(new Font("Arial", Font.BOLD, 14));

        JButton btnReservar = new JButton("Reservar");
        JButton btnLiberar = new JButton("Liberar Reserva");
        JButton btnCerrar = new JButton("Cerrar");

        // Cambiar colores de los botones
        Color botonNaranja = new Color(255, 140, 0); // naranja oscuro
        btnReservar.setBackground(botonNaranja);
        btnReservar.setForeground(Color.BLACK);
        btnLiberar.setBackground(botonNaranja);
        btnLiberar.setForeground(Color.BLACK);
        btnCerrar.setBackground(botonNaranja);
        btnCerrar.setForeground(Color.BLACK);

        // Cambiar fuente de los botones para dar estilo
        Font fuenteBotones = new Font("Arial", Font.BOLD, 14);
        btnReservar.setFont(fuenteBotones);
        btnLiberar.setFont(fuenteBotones);
        btnCerrar.setFont(fuenteBotones);

        JPanel panelBotones = new JPanel();
        // Cambiar color de fondo del panel de botones
        panelBotones.setBackground(Color.BLACK);

        panelBotones.add(btnReservar);
        panelBotones.add(btnLiberar);
        panelBotones.add(btnCerrar);

        add(scroll, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        actualizarLista();

        btnReservar.addActionListener(e -> {
            salaDePesas.reservar(socio);
            actualizarLista();
        });

        btnLiberar.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("Ingrese ID para liberar reserva:");
            if (id != null) {
                salaDePesas.liberarReserva(id.trim());
                actualizarLista();
            }
        });

        btnCerrar.addActionListener(e -> dispose());
    }

    private void actualizarLista() {
        model.clear();
        for (String reserva : salaDePesas.getReservas()) {
            model.addElement(reserva);
        }
    }
}
