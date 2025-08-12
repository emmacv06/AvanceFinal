/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visual;

import javax.swing.JOptionPane;

public class SalaDePesas {

    private String[] idsSocios = new String[75];
    private boolean[] reservas = new boolean[75];
    private int contadorReservas = 0;

    public void reservar(Socio socio) {
        if (contadorReservas >= idsSocios.length) {
            JOptionPane.showMessageDialog(null, "La sala de pesas está llena.");
            return;
        }
        idsSocios[contadorReservas] = socio.getId();
        reservas[contadorReservas] = true;
        contadorReservas++;
        JOptionPane.showMessageDialog(null, "Reserva exitosa para " + socio.getId());
    }

    public String[] getReservas() {
        String[] res = new String[contadorReservas];
        for (int i = 0; i < contadorReservas; i++) {
            res[i] = idsSocios[i];
        }
        return res;
    }

    public void liberarReserva(String id) {
        boolean encontrado = false;
        for (int i = 0; i < contadorReservas; i++) {
            if (idsSocios[i].equals(id)) {
                idsSocios[i] = idsSocios[contadorReservas - 1];
                reservas[i] = reservas[contadorReservas - 1];
                idsSocios[contadorReservas - 1] = null;
                reservas[contadorReservas - 1] = false;
                contadorReservas--;
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "ID no encontrado.");
        } else {
            JOptionPane.showMessageDialog(null, "Reserva liberada correctamente.");
        }
    }
}

