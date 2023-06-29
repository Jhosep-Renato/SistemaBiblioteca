package org.renato.sb.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TablaPrestamo extends javax.swing.JFrame {
    private JPanel panel1;
    private JTable table1;
    private JButton button1;
    private JComboBox comboBox1;
    private DefaultTableModel modelo;

    public TablaPrestamo() {
        initialize();
        setVisible(true);
        setResizable(false);
        setSize(new Dimension(430, 430));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().add(panel1);
    }

    private void initialize() {
        modelo = (DefaultTableModel) table1.getModel();
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE LIBRO");
        modelo.addColumn("CATEGORIA");
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public JTable getTable1() {
        return table1;
    }
}
