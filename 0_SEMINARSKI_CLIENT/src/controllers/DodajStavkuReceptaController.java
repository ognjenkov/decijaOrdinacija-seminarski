/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import cordinator.Cordinator;
import domain.Lek;
import domain.Recept;
import domain.StavkaRecepta;
import forms.DodajStavkuReceptaForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ognje
 */
public class DodajStavkuReceptaController {

    private final DodajStavkuReceptaForm dsrf;

    public DodajStavkuReceptaController(DodajStavkuReceptaForm dsrf) {
        this.dsrf = dsrf;
        addActionListeners();
    }

    private void addActionListeners() {
        dsrf.addBtnDODAJActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String terapija = dsrf.getjTextAreaTERAPIJA().getText();
                String zakljucak = dsrf.getjTextAreaZAKLJUCAK().getText();

                Lek lek = (Lek) dsrf.getjComboBoxLEKOVI().getSelectedItem();

                Recept r = (Recept) cordinator.Cordinator.getInstance().vratiParam("recept");

                StavkaRecepta stavka = new StavkaRecepta(1, r.getIdRecept(), lek, terapija, zakljucak);
                try {
                    communication.Communication.getInstance().dodajStavkuRecepta(stavka);
                    JOptionPane.showMessageDialog(dsrf, "Sistem je kreirao stavku recepta", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    ocistiPolja();

                    dsrf.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dsrf, "Sistem ne moze da kreira stavku recepta", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void otvoriFormu() {
        pripremiFormu();
        dsrf.setVisible(true);
    }

    private void ocistiPolja() {
//        dsdf.getjLabelID().setText("");
    }

    private void pripremiFormu() {

        Recept r = (Recept) cordinator.Cordinator.getInstance().vratiParam("recept");

        dsrf.getjLabelRECEPT().setText(r.toString());

        List<Lek> lekovi = communication.Communication.getInstance().ucitajLekove();
        
        dsrf.getjComboBoxLEKOVI().removeAllItems();

        if (lekovi == null || lekovi.isEmpty()) {
            System.out.println("lekovi su prazni");
        } else {
            for (Lek l : lekovi) {
                dsrf.getjComboBoxLEKOVI().addItem(l);
            }
        }

    }
}
