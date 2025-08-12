/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visual;

import javax.swing.JOptionPane;

public class Parqueo {

    private char[][] planta1 = new char[4][5];
    private char[][] planta2 = new char[5][5];
    private char[][] planta3 = new char[6][5];

    public Parqueo() {
        inicializarPlantas();
    }

    private void inicializarPlantas() {
        inicializarPlanta(planta1, 3, 2);
        inicializarPlanta(planta2, 3, 2);
        inicializarPlanta(planta3, 3, 2);
    }

    private void inicializarPlanta(char[][] planta, int discapacitados, int entrenadores) {
        for (int i = 0; i < planta.length; i++) {
            for (int j = 0; j < planta[0].length; j++) {
                planta[i][j] = 'L';
            }
        }
        for (int i = 0; i < discapacitados; i++) {
            planta[0][i] = 'D';
        }
        for (int i = 0; i < entrenadores; i++) {
            planta[0][planta[0].length - 1 - i] = 'E';
        }
    }

    public String mostrarEstado() {
        StringBuilder sb = new StringBuilder();
        sb.append("Planta 1:\n").append(mostrarPlanta(planta1));
        sb.append("Planta 2:\n").append(mostrarPlanta(planta2));
        sb.append("Planta 3:\n").append(mostrarPlanta(planta3));
        return sb.toString();
    }

    private String mostrarPlanta(char[][] planta) {
        StringBuilder sb = new StringBuilder();
        for (char[] fila : planta) {
            for (char c : fila) {
                sb.append(c).append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public void reservarEspacioGUI(Socio socio) {
        if (!socio.isActivo()) {
            JOptionPane.showMessageDialog(null, "Su membresía no está activa.");
            return;
        }
        String plantaStr = JOptionPane.showInputDialog("Ingrese planta para reservar (1-3):");
        String filaStr = JOptionPane.showInputDialog("Ingrese fila:");
        String columnaStr = JOptionPane.showInputDialog("Ingrese columna:");
        try {
            int planta = Integer.parseInt(plantaStr);
            int fila = (Integer.parseInt(filaStr))-1;
            int columna = (Integer.parseInt(columnaStr))-1;
            reservar(planta, fila, columna);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida.");
        }
    }

    public void reservar(int plantaNum, int fila, int columna) {
        char[][] planta = getPlanta(plantaNum);
        if (planta == null) {
            JOptionPane.showMessageDialog(null, "Planta inválida.");
            return;
        }
        if (fila < 0 || fila >= planta.length || columna < 0 || columna >= planta[0].length) {
            JOptionPane.showMessageDialog(null, "Posición inválida.");
            return;
        }
        if (planta[fila][columna] == 'L') {
            planta[fila][columna] = 'O';
            JOptionPane.showMessageDialog(null, "Espacio reservado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "El espacio no está libre.");
        }
    }

    public void liberarEspacioGUI() {
        String plantaStr = JOptionPane.showInputDialog("Ingrese planta para liberar (1-3):");
        String filaStr = JOptionPane.showInputDialog("Ingrese fila:");
        String columnaStr = JOptionPane.showInputDialog("Ingrese columna:");
        try {
            int planta = Integer.parseInt(plantaStr);
            int fila = (Integer.parseInt(filaStr))-1;
            int columna = (Integer.parseInt(columnaStr))-1;
            liberar(planta, fila, columna);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida.");
        }
    }

    public void liberar(int plantaNum, int fila, int columna) {
        char[][] planta = getPlanta(plantaNum);
        if (planta == null) {
            JOptionPane.showMessageDialog(null, "Planta inválida.");
            return;
        }
        if (fila < 0 || fila >= planta.length || columna < 0 || columna >= planta[0].length) {
            JOptionPane.showMessageDialog(null, "Posición inválida.");
            return;
        }
        if (planta[fila][columna] == 'O') {
            planta[fila][columna] = 'L';
            JOptionPane.showMessageDialog(null, "Espacio liberado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "El espacio no está ocupado o no puede ser liberado.");
        }
    }

    private char[][] getPlanta(int num) {
        if (num == 1) return planta1;
        if (num == 2) return planta2;
        if (num == 3) return planta3;
        return null;
    }
}

