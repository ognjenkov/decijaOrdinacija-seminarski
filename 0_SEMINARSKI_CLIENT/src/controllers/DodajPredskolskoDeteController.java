/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import domain.Dete;
import domain.PredskolskoDete;
import forms.DodajPredskolskoDeteForm;
import forms.FormMode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author ognje
 */
public class DodajPredskolskoDeteController {

    private final DodajPredskolskoDeteForm dsdf;

    public DodajPredskolskoDeteController(DodajPredskolskoDeteForm dsdf) {
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
                String grupa = dsdf.getjTextFieldGRUPA().getText();
                int id = Integer.parseInt(dsdf.getjLabelID().getText());
                PredskolskoDete predskolskoDete = new PredskolskoDete(grupa, id, "", "", null);
                try {
                    communication.Communication.getInstance().dodajPredskolskoDete(predskolskoDete);
                    JOptionPane.showMessageDialog(dsdf, "Sistem je kreirao predskolskoDete", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    ocistiPolja();

                    dsdf.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dsdf, "Sistem ne moze da kreira predskolskoDete", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        dsdf.azurirajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                azuriraj(e);
            }

            private void azuriraj(ActionEvent e) {
                String grupa = dsdf.getjTextFieldGRUPA().getText();
                int id = Integer.parseInt(dsdf.getjLabelID().getText());
                PredskolskoDete predskolskoDete = new PredskolskoDete(grupa, id, "", "", null);
                try {
                    communication.Communication.getInstance().izmeniPredskolskoDete(predskolskoDete);
                    JOptionPane.showMessageDialog(dsdf, "Sistem je izmenio PredskolskoDete", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    ocistiPolja();

                    dsdf.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dsdf, "Sistem ne moze da izmeni PredskolskoDete", "Greska", JOptionPane.ERROR_MESSAGE);
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
            Dete d = (Dete) cordinator.Cordinator.getInstance().vratiParam("predskolskoDete");

            dsdf.getjLabelIME().setText(d.getIme());
            dsdf.getjLabelID().setText(d.getIdDete() + "");

        } else if (mode == FormMode.IZMENI) {
            dsdf.getjButtonDODAJ().setVisible(false);
            dsdf.getjButtonAZURIRAJ().setVisible(true);
            Dete d = (Dete) cordinator.Cordinator.getInstance().vratiParam("predskolskoDete");

            dsdf.getjLabelIME().setText(d.getIme());
            dsdf.getjLabelID().setText(d.getIdDete() + "");



        }
    }

}