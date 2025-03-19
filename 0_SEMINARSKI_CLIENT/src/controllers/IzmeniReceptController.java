/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import domain.Recept;
import forms.IzmeniReceptForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author ognje
 */
public class IzmeniReceptController {

    private final IzmeniReceptForm irf;

    public IzmeniReceptController(IzmeniReceptForm irf) {
        this.irf = irf;
        addActionListeners();
    }

    private void addActionListeners() {
        irf.azurirajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dijagnoza = (String) irf.getjComboBoxDIJAGNOZA().getSelectedItem();
                String datumString = irf.getjTextFieldDATUM().getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
                LocalDate datum = LocalDate.parse(datumString, formatter);

                Recept r = (Recept) cordinator.Cordinator.getInstance().vratiParam("recept");
                r.setDatumIzdavanja(datum);
                r.setDijagnoza(dijagnoza);

                try {
                    communication.Communication.getInstance().izmeniRecept(r);
                    JOptionPane.showMessageDialog(irf, "Sistem je izmenio recept", "Uspeh", JOptionPane.INFORMATION_MESSAGE);

                    irf.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(irf, "Sistem ne moze da izmeni recept", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void otvoriFormu() {
        pripremiFormu();
        irf.setVisible(true);
    }

    private void ocistiPolja() {
        irf.getjComboBoxDIJAGNOZA().setSelectedIndex(0);
        irf.getjLabelRECEPT().setText("");
        irf.getjTextFieldDATUM().setText("");
    }

    private void pripremiFormu() {
        
        Recept r = (Recept) cordinator.Cordinator.getInstance().vratiParam("recept");
        
        irf.getjLabelRECEPT().setText(r.toString());
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        
        irf.getjTextFieldDATUM().setText(r.getDatumIzdavanja().format(formatter));
        
        irf.getjComboBoxDIJAGNOZA().setSelectedItem(r.getDijagnoza());
    }
}
