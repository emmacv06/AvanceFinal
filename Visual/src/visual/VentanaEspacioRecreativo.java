package visual;

import javax.swing.*;
import java.awt.*;

public class VentanaEspacioRecreativo extends JFrame {

    private Socio socio;
    private EspacioRecreativo espacioRecreativo;

    private DefaultListModel<String> model;

    public VentanaEspacioRecreativo(Socio socio, EspacioRecreativo espacioRecreativo) {
        this.socio = socio;
        this.espacioRecreativo = espacioRecreativo;

        setTitle("Espacio Recreativo");
        setSize(450, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        getContentPane().setBackground(Color.BLACK);

        model = new DefaultListModel<>();
        JList<String> listaEspacios = new JList<>(model);
        JScrollPane scroll = new JScrollPane(listaEspacios);

        listaEspacios.setBackground(Color.DARK_GRAY);
        listaEspacios.setForeground(Color.ORANGE);
        listaEspacios.setFont(new Font("Arial", Font.BOLD, 14));

        JButton btnReservar = new JButton("Reservar Espacio");
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
            String inputNum = JOptionPane.showInputDialog("Ingrese número de espacio a reservar:");
            String inputCantidad = JOptionPane.showInputDialog("Ingrese cantidad a reservar:");
            if (inputNum != null && inputCantidad != null) {
                try {
                    int num = Integer.parseInt(inputNum.trim());
                    int cantidad = Integer.parseInt(inputCantidad.trim());
                    espacioRecreativo.reservarEspacio(socio, num, cantidad);
                    actualizarLista();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida.");
                }
            }
        });

        btnLiberar.addActionListener(e -> {
            String inputNum = JOptionPane.showInputDialog("Ingrese número de espacio para liberar:");
            String inputCantidad = JOptionPane.showInputDialog("Ingrese cantidad a liberar:");
            if (inputNum != null && inputCantidad != null) {
                try {
                    int num = Integer.parseInt(inputNum.trim());
                    int cantidad = Integer.parseInt(inputCantidad.trim());
                    espacioRecreativo.liberarReserva(num, cantidad);
                    actualizarLista();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida.");
                }
            }
        });

        btnCerrar.addActionListener(e -> dispose());
    }

    private void actualizarLista() {
        model.clear();
        String[] datos = espacioRecreativo.resumenEspacios().split("\n");
        for (String linea : datos) {
            model.addElement(linea);
        }
    }
}
