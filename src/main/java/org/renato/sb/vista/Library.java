package org.renato.sb.vista;

import org.renato.sb.controlador.Categoria_Controlador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Library extends javax.swing.JFrame{
    private JPanel panel1;
    private JButton btnPrestamo;
    private JButton btnDevolucion;
    private JComboBox<String> cmb_Categoria;
    private JTable tabla;
    private JButton btnFiltrar;
    private DefaultTableModel modelo;

    public Library(){
        initialize();
        setVisible(true);
        setResizable(false);
        setSize(new Dimension(430, 430));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().add(panel1);
    }

    private void initialize(){
        cmb_Categoria.addItem("Selecciona una categoria");
        cmb_Categoria.addItem("Ficcion");
        cmb_Categoria.addItem("Terror");
        cmb_Categoria.addItem("Accion");


        modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE LIBRO");
        modelo.addColumn("CATEGORIA");

        pack();
        Categoria_Controlador c = new Categoria_Controlador(this);
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public JButton getBtnPrestamo() {
        return btnPrestamo;
    }

    public JButton getBtnDevolucion() {
        return btnDevolucion;
    }

    public JComboBox<String> getCmb_Categoria() {
        return cmb_Categoria;
    }

    public JTable getTabla() {
        return tabla;
    }

    public JButton getBtnFiltrar() {
        return btnFiltrar;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }
}
