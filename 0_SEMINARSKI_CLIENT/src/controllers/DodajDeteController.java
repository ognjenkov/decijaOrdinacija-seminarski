/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import domain.Dete;
import forms.DodajDeteForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ognje
 */
public class DodajDeteController {

    private final DodajDeteForm ddf;

    public DodajDeteController(DodajDeteForm ddf) {
        this.ddf = ddf;
        addActionListenes();
    }

    private void addActionListenes() {
        ddf.dodajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodaj(e);
            }

            private void dodaj(ActionEvent e) {
                String ime = ddf.getjTextIME().getText();
                String prezime = ddf.getjTextFieldPREZIME().getText();
                String datumRodjenjaString = ddf.getjTextFieldDATUMRODJENJA().getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate datumRodnjenja = LocalDate.parse(datumRodjenjaString, formatter);

                Dete dete = new Dete(-1, ime, prezime, datumRodnjenja);
                try {
                    communication.Communication.getInstance().dodajDete(dete);
                    JOptionPane.showMessageDialog(ddf, "Sistem je kreirao dete", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    ocistiPolja();

                    ddf.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ddf, "Sistem ne moze da kreira dete", "Greska", JOptionPane.ERROR_MESSAGE);
                }

            }

        });

    }

    public void otvoriFormu() {
        ddf.setVisible(true);
    }

    private void ocistiPolja() {
        ddf.getjTextIME().setText("");
        ddf.getjTextFieldPREZIME().setText("");
        ddf.getjTextFieldDATUMRODJENJA().setText("");
    }
}
