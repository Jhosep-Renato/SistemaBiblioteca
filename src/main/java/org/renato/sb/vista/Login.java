package org.renato.sb.vista;


import org.renato.sb.controlador.Login_Controlador;

import javax.swing.*;
import java.awt.*;

public class Login extends javax.swing.JFrame{
    private JPanel panel1;
    private JPasswordField txt_password;
    private JTextField txt_name;
    private JButton btn_login;

    public Login(){
        setSize(new Dimension(270, 270));
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(getPanel1());

        pack();
        Login_Controlador c = new Login_Controlador(this);
    }
    public JPanel getPanel1() {
        return panel1;
    }

    public JPasswordField getTxt_password() {
        return txt_password;
    }

    public JTextField getTxt_name() {
        return txt_name;
    }

    public JButton getBtn_login() {
        return btn_login;
    }
}
