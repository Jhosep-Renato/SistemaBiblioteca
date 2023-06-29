package org.renato.sb.vista;

import org.renato.sb.controlador.Prestamo_Controlador;

import javax.swing.*;
import java.awt.*;

public class Prestamo extends javax.swing.JFrame{
    private JPanel panel;
    private JTextField txtEstudiante;
    private JButton btnPrestamo;
    private JTextField txtLibro;
    private JTextField txtDevolucion;
    private JButton btnVisualizarPrestamo;


    public Prestamo(){
        Prestamo_Controlador psc = new Prestamo_Controlador(this);
        setVisible(true);
        setSize(new Dimension(430, 430));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        pack();
    }
    public JPanel getPanel() {
        return panel;
    }

    public JTextField getTxtEstudiante() {
        return txtEstudiante;
    }

    public JButton getBtnPrestamo() {
        return btnPrestamo;
    }

    public JTextField getTxtLibro() {
        return txtLibro;
    }
    public JTextField getTxtDevolucion() {
        return txtDevolucion;
    }
}
