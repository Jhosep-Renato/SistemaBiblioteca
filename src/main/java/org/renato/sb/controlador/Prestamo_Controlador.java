package org.renato.sb.controlador;

import org.renato.sb.modelo.BibliotecaRepositorio;
import org.renato.sb.modelo.RepositorioDAO;
import org.renato.sb.vista.Prestamo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prestamo_Controlador implements ActionListener {
    private Prestamo prestamo;
    public Prestamo_Controlador(Prestamo p){
        this.prestamo = p;
        prestamo.getBtnPrestamo().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == prestamo.getBtnPrestamo()){
            BibliotecaRepositorio br = new RepositorioDAO();

            String fecha = prestamo.getTxtDevolucion().getText();
            String idEstudiante = prestamo.getTxtEstudiante().getText();
            String idLibro = prestamo.getTxtLibro().getText();

            boolean v = br.realizarPrestamo(fecha, idEstudiante, idLibro);

            if(v){
                JOptionPane.showMessageDialog(prestamo.getPanel(), "Se realizo el prestamo exitoso");
            }else{
                JOptionPane.showMessageDialog(prestamo.getPanel(), "El estudiante tiene deuda");
            }
        }
    }
}