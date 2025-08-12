/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visual;

import javax.swing.JOptionPane;

public class ClasesGrupales {

    private String[] nombres = {"Yoga", "Zumba", "Pilates"};
    private String[] horarios = {"mañana", "noche", "mañana"};
    private int[] capacidades = {10, 15, 10};
    private int[] ocupados = {0, 0, 0};
    private Socio[] reservas = new Socio[100];
    private int totalReservas = 0;

    public String resumenClases() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nombres.length; i++) {
            sb.append(i).append(". ").append(nombres[i]).append(" - ")
              .append(horarios[i]).append(" - ")
              .append(ocupados[i]).append("/").append(capacidades[i]).append(" ocupados\n");
        }
        return sb.toString();
    }

    public void reservarClase(Socio socio, int num) {
        if (num < 0 || num >= nombres.length) {
            JOptionPane.showMessageDialog(null, "Clase no existe.");
            return;
        }
        if (ocupados[num] >= capacidades[num]) {
            JOptionPane.showMessageDialog(null, "Clase llena.");
            return;
        }
        ocupados[num]++;
        reservas[totalReservas++] = socio;
        JOptionPane.showMessageDialog(null, "Reserva en clase " + nombres[num] + " realizada.");
    }

    public void modificarClase(int num, String nombre, String horario, int capacidad) {
        if (num < 0 || num >= nombres.length) {
            JOptionPane.showMessageDialog(null, "Clase no existe.");
            return;
        }
        nombres[num] = nombre;
        horarios[num] = horario;
        capacidades[num] = capacidad;
        JOptionPane.showMessageDialog(null, "Clase modificada.");
    }

    public void liberarReserva(int num) {
        if (num < 0 || num >= nombres.length) {
            JOptionPane.showMessageDialog(null, "Clase no existe.");
            return;
        }
        if (ocupados[num] <= 0) {
            JOptionPane.showMessageDialog(null, "No hay reservas para liberar.");
            return;
        }
        ocupados[num]--;
        JOptionPane.showMessageDialog(null, "Reserva liberada en clase " + nombres[num]);
    }
}

