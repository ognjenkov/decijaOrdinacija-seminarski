/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import domain.Dete;
import domain.PredskolskoDete;
import domain.SkolskoDete;
import forms.DodajPredskolskoDeteForm;
import forms.DodajSkolskoDeteForm;
import forms.FormMode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author ognje
 */
public class DodajSkolskoDeteController {
    private final DodajSkolskoDeteForm dsdf;

    public DodajSkolskoDeteController(DodajSkolskoDeteForm dsdf) {
        this.dsdf = dsdf;
        addActionListeners();
    }

    private void addActionListeners() {
        dsdf.dodajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodaj(e);
            }

            private void dodaj(ActionEvent e) {
                String odeljenje = dsdf.getjTextFieldODELJENJE().getText();
                String razred = dsdf.getjTextFieldRAZRED().getText();

                int id = Integer.parseInt(dsdf.getjLabelID().getText());
                SkolskoDete skolskoDete = new SkolskoDete(odeljenje, razred, id, "", "", null);
                try {
                    communication.Communication.getInstance().dodajSkolskoDete(skolskoDete);
                    JOptionPane.showMessageDialog(dsdf, "Sistem je kreirao skolskoDete", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    ocistiPolja();

                    dsdf.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dsdf, "Sistem ne moze da kreira skolskoDete", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        dsdf.azurirajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                azuriraj(e);
            }

            private void azuriraj(ActionEvent e) {
                String odeljenje = dsdf.getjTextFieldODELJENJE().getText();
                String razred = dsdf.getjTextFieldRAZRED().getText();

                int id = Integer.parseInt(dsdf.getjLabelID().getText());
                SkolskoDete skolskoDete = new SkolskoDete(odeljenje, razred, id, "", "", null);
                try {
                    communication.Communication.getInstance().izmeniSkolskoDete(skolskoDete);
                    JOptionPane.showMessageDialog(dsdf, "Sistem je izmenio skolskoDete", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    ocistiPolja();

                    dsdf.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dsdf, "Sistem ne moze da izmeni skolskoDete", "Greska", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        
    }

    public void otvoriFormu(FormMode mode) {
        pripremiFormu(mode);
        dsdf.setVisible(true);
    }

    private void ocistiPolja() {
//        dsdf.getjLabelID().setText("");
    }

    private void pripremiFormu(FormMode mode) {
        if (mode == FormMode.DODAJ) {

            dsdf.getjButtonDODAJ().setVisible(true);
            dsdf.getjButtonAZURIRAJ().setVisible(false);
            Dete d = (Dete) cordinator.Cordinator.getInstance().vratiParam("dete");

            dsdf.getjLabelIME().setText(d.getIme());
            dsdf.getjLabelID().setText(d.getIdDete() + "");

        } else if (mode == FormMode.IZMENI) {
            dsdf.getjButtonDODAJ().setVisible(false);
            dsdf.getjButtonAZURIRAJ().setVisible(true);
            SkolskoDete d = (SkolskoDete) cordinator.Cordinator.getInstance().vratiParam("skolskoDete");

            dsdf.getjLabelIME().setText(d.getIme());
            dsdf.getjLabelID().setText(d.getIdDete() + "");

            dsdf.getjTextFieldRAZRED().setText(d.getRazred());
            dsdf.getjTextFieldODELJENJE().setText(d.getOdeljenje());
        }
    }
}
