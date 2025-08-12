/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visual;

import javax.swing.JOptionPane;

public class Cabina {

    private String[] horarios = {"9am", "10am", "11am", "12pm", "1pm"};
    private String[] estado = {"Libre", "Libre", "Libre", "Libre", "Libre"};

    public String getHorariosEstado() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < horarios.length; i++) {
            sb.append(horarios[i]).append(" : ").append(estado[i]).append("\n");
        }
        return sb.toString();
    }

    public void reservarHorario(Socio socio, String hora) {
        for (int i = 0; i < horarios.length; i++) {
            if (horarios[i].equalsIgnoreCase(hora)) {
                if (estado[i].equals("Libre")) {
                    estado[i] = "Ocupado";
                    JOptionPane.showMessageDialog(null, "Horario reservado con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "Horario ya ocupado.");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Horario no encontrado.");
    }

    public void liberarReserva(String hora) {
        for (int i = 0; i < horarios.length; i++) {
            if (horarios[i].equalsIgnoreCase(hora)) {
                if (estado[i].equals("Ocupado")) {
                    estado[i] = "Libre";
                    JOptionPane.showMessageDialog(null, "Reserva liberada.");
                } else {
                    JOptionPane.showMessageDialog(null, "El horario ya está libre.");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Horario no encontrado.");
    }
}

