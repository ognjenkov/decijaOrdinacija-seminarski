/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import domain.Dete;
import forms.DodajDeteForm;
import forms.FormMode;
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
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
                LocalDate datumRodnjenja = LocalDate.parse(datumRodjenjaString, formatter);

                Dete dete = new Dete(-1, ime, prezime, datumRodnjenja);
                try {
                    communication.Communication.getInstance().dodajDete(dete);
                    JOptionPane.showMessageDialog(ddf, "Sistem je kreirao dete", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    ocistiPolja();

                    ddf.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ddf, "Sistem ne moze da kreira dete", "Greska", JOptionPane.ERROR_MESSAGE);
                    System.out.println(ex);
                }
            }
        });
        
        
        
        ddf.azurirajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                azuriraj(e);
            }

            private void azuriraj(ActionEvent e) {
                String ime = ddf.getjTextIME().getText();
                String prezime = ddf.getjTextFieldPREZIME().getText();
                String datumRodjenjaString = ddf.getjTextFieldDATUMRODJENJA().getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
                LocalDate datumRodnjenja = LocalDate.parse(datumRodjenjaString, formatter);
                int id = Integer.parseInt(ddf.getjLabelID().getText());
                
                Dete dete = new Dete(id, ime, prezime, datumRodnjenja);
                try {
                    communication.Communication.getInstance().izmeniDete(dete);
                    JOptionPane.showMessageDialog(ddf, "Sistem je izmenio dete", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    ocistiPolja();

                    ddf.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ddf, "Sistem ne moze da izmeni dete", "Greska", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

    }

    public void otvoriFormu(FormMode mode) {
        pripremiFormu(mode);
        ddf.setVisible(true);
    }

    private void ocistiPolja() {
        ddf.getjTextIME().setText("");
        ddf.getjTextFieldPREZIME().setText("");
        ddf.getjTextFieldDATUMRODJENJA().setText("");
        ddf.getjLabelID().setText("");
    }

    private void pripremiFormu(FormMode mode) {
        if(mode == FormMode.DODAJ) {
            
            ddf.getjButtonDODAJ().setVisible(true);
            ddf.getjButtonAZURIRAJ().setVisible(false);
            ddf.getjLabelID().setVisible(false);
            ddf.getjLabelID1().setVisible(false);
            
        } else if (mode == FormMode.IZMENI) {
            ddf.getjButtonDODAJ().setVisible(false);
            ddf.getjButtonAZURIRAJ().setVisible(true);
            ddf.getjLabelID().setVisible(true);
            ddf.getjLabelID1().setVisible(true);
            Dete d = (Dete)cordinator.Cordinator.getInstance().vratiParam("dete");
            
            ddf.getjLabelID().setText(d.getIdDete() + "");
            ddf.getjTextIME().setText(d.getIme());
            ddf.getjTextFieldPREZIME().setText(d.getPrezime());
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");

            ddf.getjTextFieldDATUMRODJENJA().setText(d.getDatumRodjenja().format(formatter));

        }
    }
}
