/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import domain.Doktor;
import forms.LoginForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import cordinator.Cordinator;
/**
 *
 * @author ognje
 */
public class LoginController {

    private final LoginForm lf;

    public LoginController(LoginForm lf) {
        this.lf = lf;
        addActionListenes();
    }

    private void addActionListenes() {
        lf.loginAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prijava(e);
            }

            private void prijava(ActionEvent e) {
                String email = lf.getjTextField1().getText().trim();
                String sifra = String.valueOf(lf.getjPasswordField1().getPassword());
                
                communication.Communication.getInstance().connection();
                Doktor doktor = communication.Communication.getInstance().login(email, sifra);

                if (doktor == null) {
                    //TODO
                    JOptionPane.showMessageDialog(lf, "Korisnicno ime i sifra nisu ispravni", "Error", JOptionPane.ERROR_MESSAGE);

                } else {
                    Cordinator.getInstance().setUlogovani(doktor);
                    JOptionPane.showMessageDialog(lf, "Korisnicko ime i sifra su ispravni", "Success", JOptionPane.INFORMATION_MESSAGE);
                    Cordinator.getInstance().openMainForm();
                    lf.dispose();
                    //TODO treba da se otvori sledeca forma
                }
            }
        });
    }

    public void otvoriFormu() {
        lf.setVisible(true);
    }

}
