/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import domain.Dete;
import forms.PrikazDeceForm;
import forms.models.ModelTabeleDeca;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ognje
 */
public class PrikazDeceController {

    private final PrikazDeceForm pdf;

    public PrikazDeceController(PrikazDeceForm pdf) {
        this.pdf = pdf;
        addActionListenes();
    }

    private void addActionListenes() {
//        mainForm.mainAddActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//            }
//
//        });
        pdf.addBtnDELETEActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = pdf.getjTableDECA().getSelectedRow();
                if (red == -1) {
                    //TODO poruke u joption pane moraju da budu kao u dokumentaciji
                    JOptionPane.showMessageDialog(pdf, "Sistem ne moze da obrise dete", "Greska", JOptionPane.ERROR_MESSAGE);
                } else {
                    ModelTabeleDeca mtd = (ModelTabeleDeca) pdf.getjTableDECA().getModel();
                    Dete dete = mtd.getLista().get(red);
                    try {
                        communication.Communication.getInstance().obrisiDete(dete);
                        JOptionPane.showMessageDialog(pdf, "Sistem je obrisao dete", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                        pripremiFormu();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(pdf, "Sistem ne moze da obrise dete", "Greska", JOptionPane.ERROR_MESSAGE);
                    }

                }

            }

        });
        pdf.addBtnAZURIRAJActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = pdf.getjTableDECA().getSelectedRow();
                if (red == -1) {
                    //TODO poruke u joption pane moraju da budu kao u dokumentaciji
                    JOptionPane.showMessageDialog(pdf, "Sistem ne moze da azurira dete", "Greska", JOptionPane.ERROR_MESSAGE);
                } else {
                    ModelTabeleDeca mtd = (ModelTabeleDeca) pdf.getjTableDECA().getModel();
                    Dete dete = mtd.getLista().get(red);
                    cordinator.Cordinator.getInstance().dodajParam("dete", dete);
                    cordinator.Cordinator.getInstance().openIzmeniDeteFormu();

                }

            }

        });
        pdf.addBtnPRETRAZIctionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ime = pdf.getjTextFieldIME().getText();
                String prezime = pdf.getjTextFieldPREZIME().getText();
                String datumRodjenjaString = pdf.getjTextFieldDATUMRODJENJA().getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate datumRodnjenja = LocalDate.parse(datumRodjenjaString, formatter);

                
                ModelTabeleDeca mtd = (ModelTabeleDeca) pdf.getjTableDECA().getModel();
                mtd.pretrazi(ime, prezime, datumRodnjenja);
            }

        });
        pdf.addBtnRESETUJctionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pripremiFormu();
            }

        });
    }

    public void otvoriFormu() {
        pripremiFormu();
        pdf.setVisible(true);
    }

    public void pripremiFormu() {
        List<Dete> deca = communication.Communication.getInstance().ucitajDecu();
        ModelTabeleDeca mtd = new ModelTabeleDeca(deca);
        pdf.getjTableDECA().setModel(mtd);
    }
}
