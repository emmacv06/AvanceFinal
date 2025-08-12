/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visual;

import javax.swing.JOptionPane;

public class EspacioRecreativo {

    private String[] nombres = {"Cancha", "Piscina", "Pista"};
    private int[] capacidades = {20, 15, 30};
    private int[] ocupados = {0, 0, 0};

    public String resumenEspacios() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nombres.length; i++) {
            sb.append(i).append(". ").append(nombres[i]).append(" - ")
              .append(ocupados[i]).append("/").append(capacidades[i]).append(" ocupados\n");
        }
        return sb.toString();
    }

    public void reservarEspacio(Socio socio, int num, int cantidad) {
        if (num < 0 || num >= nombres.length) {
            JOptionPane.showMessageDialog(null, "Espacio no existe.");
            return;
        }
        if (ocupados[num] + cantidad > capacidades[num]) {
            JOptionPane.showMessageDialog(null, "No hay suficiente espacio disponible.");
            return;
        }
        ocupados[num] += cantidad;
        JOptionPane.showMessageDialog(null, "Reserva en " + nombres[num] + " realizada.");
    }

    public void liberarReserva(int num, int cantidad) {
        if (num < 0 || num >= nombres.length) {
            JOptionPane.showMessageDialog(null, "Espacio no existe.");
            return;
        }
        if (ocupados[num] < cantidad) {
            JOptionPane.showMessageDialog(null, "Cantidad a liberar mayor que ocupada.");
            return;
        }
        ocupados[num] -= cantidad;
        JOptionPane.showMessageDialog(null, "Reserva liberada en " + nombres[num]);
    }
}

