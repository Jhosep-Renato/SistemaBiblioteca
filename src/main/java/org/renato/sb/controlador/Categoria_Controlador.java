package org.renato.sb.controlador;

import org.renato.sb.modelo.BibliotecaRepositorio;
import org.renato.sb.modelo.RepositorioDAO;
import org.renato.sb.modelo.plantilla.Libro;
import org.renato.sb.vista.Library;
import org.renato.sb.vista.Prestamo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Categoria_Controlador implements ActionListener {

    private Library l;
    public Categoria_Controlador(Library l){
        this.l = l;
        l.getBtnFiltrar().addActionListener(this);
        l.getBtnPrestamo().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        l.getModelo().setRowCount(0);

        if (e.getSource() == l.getBtnFiltrar()){
            BibliotecaRepositorio br = new RepositorioDAO();
            List<Libro> libros = br.filtrarCategoria((String)l.getCmb_Categoria().getSelectedItem());

            if (!libros.isEmpty()){
                for(Libro li: libros){
                    String[] a = {String.valueOf(li.getId()), li.getNombreLibro(), li.getCategoria()};
                    l.getModelo().addRow(a);
                }
            }
        }
        if (e.getSource() == l.getBtnPrestamo()){
            Prestamo ps = new Prestamo();
            l.dispose();
        }
    }
}
