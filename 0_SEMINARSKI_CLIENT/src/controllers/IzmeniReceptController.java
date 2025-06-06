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
import java.time.format.DateTimeParseException;
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
                try {
                    String dijagnoza = (String) irf.getjComboBoxDIJAGNOZA().getSelectedItem();
                    String datumString = irf.getjTextFieldDATUM().getText();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
                    LocalDate datum = LocalDate.parse(datumString, formatter);

//                ovako ti se formatira majmune
//LocalDate datumRodjenja = null;
//                if (!datumRodjenjaString.isEmpty()) {
//                    try {
//                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
//                        datumRodjenja = LocalDate.parse(datumRodjenjaString, formatter);
//                    } catch (DateTimeParseException ex) {
//                        System.err.println("Invalid date format: " + datumRodjenjaString);
//                        return; // Exit early if the date is invalid
//                    }
//                }

int godina = datum.getYear();
if (dijagnoza.contains(String.valueOf(godina))) {
    System.out.println("Dijagnoza contains the year from datum.");
}

                    Recept r = (Recept) cordinator.Cordinator.getInstance().vratiParam("recept");
                    r.setDatumIzdavanja(datum);
                    r.setDijagnoza(dijagnoza);
                    
                    

                    communication.Communication.getInstance().izmeniRecept(r);
                    JOptionPane.showMessageDialog(irf, "Sistem je zapamtio recept", "Uspeh", JOptionPane.INFORMATION_MESSAGE);

                    irf.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(irf, "Sistem ne moze da zapamti recept", "Greska", JOptionPane.ERROR_MESSAGE);
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
