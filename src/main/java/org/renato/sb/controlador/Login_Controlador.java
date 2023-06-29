package org.renato.sb.controlador;

import org.renato.sb.modelo.BibliotecaRepositorio;
import org.renato.sb.modelo.plantilla.Empleado;
import org.renato.sb.modelo.RepositorioDAO;
import org.renato.sb.vista.Library;
import org.renato.sb.vista.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_Controlador implements ActionListener {
    private Login login;
    public Login_Controlador(Login login){
        this.login = login;
        login.getBtn_login().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login.getBtn_login()){
            Empleado em = new Empleado();
            em.setNombre(login.getTxt_name().getText());
            em.setPassword(String.valueOf(login.getTxt_password().getPassword()));

            BibliotecaRepositorio r = new RepositorioDAO();
            boolean v = r.validarEmpleado(em);

            if (v){
                JOptionPane.showMessageDialog(login, "Has iniciado correctamente");
                Library l = new Library();
                login.dispose();
            }else{
                JOptionPane.showMessageDialog(login, "Error al iniciar sesion");
            }
        }
    }
}
