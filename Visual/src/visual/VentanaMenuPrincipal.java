/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visual;

import javax.swing.*;
import java.awt.*;

public class VentanaMenuPrincipal extends JFrame {

    private Socio socio;
    private SalaDePesas salaDePesas;
    private Cabina cabina;
    private Auditorio auditorio;
    private ClasesGrupales clasesGrupales;
    private EspacioRecreativo espacioRecreativo;
    private Parqueo parqueo;

    public VentanaMenuPrincipal(Socio socio, SalaDePesas salaDePesas, Cabina cabina,
                                Auditorio auditorio, ClasesGrupales clasesGrupales,
                                EspacioRecreativo espacioRecreativo, Parqueo parqueo) {
        this.socio = socio;
        this.salaDePesas = salaDePesas;
        this.cabina = cabina;
        this.auditorio = auditorio;
        this.clasesGrupales = clasesGrupales;
        this.espacioRecreativo = espacioRecreativo;
        this.parqueo = parqueo;

        setTitle("Gimnasio Premium - Menú Principal");
        setSize(550, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(20, 20, 20);
                Color color2 = new Color(60, 60, 60);
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(new GridBagLayout());

        Font fuenteBotones = new Font("Segoe UI", Font.BOLD, 20);
        Font fuenteTitulo = new Font("Segoe UI Black", Font.BOLD, 32);

        JLabel titulo = new JLabel("GIMNASIO EMFIT");
        titulo.setForeground(new Color(255, 140, 0));
        titulo.setFont(fuenteTitulo);
        titulo.setHorizontalAlignment(JLabel.CENTER);

        JButton btnSalaPesas = crearBoton("Sala de Pesas", fuenteBotones);
        JButton btnCabina = crearBoton("Cabina", fuenteBotones);
        JButton btnAuditorio = crearBoton("Auditorio", fuenteBotones);
        JButton btnClasesGrupales = crearBoton("Clases Grupales", fuenteBotones);
        JButton btnEspacioRecreativo = crearBoton("Espacio Recreativo", fuenteBotones);
        JButton btnParqueo = crearBoton("Parqueo", fuenteBotones);
        JButton btnSalir = crearBoton("Salir", fuenteBotones);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 50, 15, 50);
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridy = 0;
        panel.add(titulo, gbc);

        gbc.gridy = 1;
        panel.add(btnSalaPesas, gbc);
        gbc.gridy = 2;
        panel.add(btnCabina, gbc);
        gbc.gridy = 3;
        panel.add(btnAuditorio, gbc);
        gbc.gridy = 4;
        panel.add(btnClasesGrupales, gbc);
        gbc.gridy = 5;
        panel.add(btnEspacioRecreativo, gbc);
        gbc.gridy = 6;
        panel.add(btnParqueo, gbc);
        gbc.gridy = 7;
        panel.add(btnSalir, gbc);

        // Acciones
        btnSalaPesas.addActionListener(e -> {
            VentanaSalaPesas ventana = new VentanaSalaPesas(socio, salaDePesas);
            ventana.setVisible(true);
        });

        btnCabina.addActionListener(e -> {
            VentanaCabina ventana = new VentanaCabina(socio, cabina);
            ventana.setVisible(true);
        });

        btnAuditorio.addActionListener(e -> {
            VentanaAuditorio ventana = new VentanaAuditorio(socio, auditorio);
            ventana.setVisible(true);
        });

        btnClasesGrupales.addActionListener(e -> {
            VentanaClasesGrupales ventana = new VentanaClasesGrupales(socio, clasesGrupales);
            ventana.setVisible(true);
        });

        btnEspacioRecreativo.addActionListener(e -> {
            VentanaEspacioRecreativo ventana = new VentanaEspacioRecreativo(socio, espacioRecreativo);
            ventana.setVisible(true);
        });

        btnParqueo.addActionListener(e -> {
            VentanaParqueo ventana = new VentanaParqueo(socio, parqueo);
            ventana.setVisible(true);
        });

        btnSalir.addActionListener(e -> System.exit(0));

        add(panel);
        setVisible(true);
    }

    private JButton crearBoton(String texto, Font fuente) {
        JButton btn = new JButton(texto);
        btn.setFont(fuente);
        btn.setForeground(Color.BLACK);
        btn.setBackground(new Color(255, 140, 0));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(new Color(255, 140, 0).darker(), 2));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setPreferredSize(new Dimension(300, 50));

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(255, 160, 50));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(255, 140, 0));
            }
        });

        return btn;
    }
}


