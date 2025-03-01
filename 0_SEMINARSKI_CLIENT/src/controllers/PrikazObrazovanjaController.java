/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import domain.Dete;
import domain.PredskolskoDete;
import domain.SkolskoDete;

import forms.PrikazObrazovanjaForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ognje
 */
public class PrikazObrazovanjaController {

    private final PrikazObrazovanjaForm pof;

    public PrikazObrazovanjaController(PrikazObrazovanjaForm pof) {
        this.pof = pof;
        addActionListenes();
    }
    private List<PredskolskoDete> predskolskaDeca;
    private List<SkolskoDete> skolskaDeca;
    private Dete odabranoDete;
    private PredskolskoDete odabranoPredskolskoDete;
    private SkolskoDete odabranoSkolskoDete;

    private void addActionListenes() {
//        mainForm.mainAddActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//            }
//
//        });
        pof.addBtnKATEGORISIPREDSKOLSKOActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cordinator.Cordinator.getInstance().dodajParam("dete", odabranoDete);
                cordinator.Cordinator.getInstance().openDodajPredskolskoDeteForm();
            }
        });
        pof.addBtnKATEGORISISKOLSKOActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cordinator.Cordinator.getInstance().dodajParam("dete", odabranoDete);
                cordinator.Cordinator.getInstance().openDodajSkolskoDeteForm();
            }
        });
        pof.addBtnPREDAZURIRAJActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cordinator.Cordinator.getInstance().dodajParam("predskolskoDete", odabranoPredskolskoDete);
                cordinator.Cordinator.getInstance().openIzmeniPredskolskoDeteForm();
            }
        });
        pof.addBtnPREDOBRISIActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    communication.Communication.getInstance().obrisiPredskolskoDete(odabranoPredskolskoDete);
                    JOptionPane.showMessageDialog(pof, "Sistem je obrisao Predskolsko Dete", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    pripremiFormu();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(pof, "Sistem ne moze da obrise Predskolsko Dete", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        pof.addBtnSKOAZURIRAJActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cordinator.Cordinator.getInstance().dodajParam("skolskoDete", odabranoSkolskoDete);
                cordinator.Cordinator.getInstance().openIzmeniSkolskoDeteForm();
            }
        });
        pof.addBtnSKOOBRISIActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    communication.Communication.getInstance().obrisiSkolskoDete(odabranoSkolskoDete);
                    JOptionPane.showMessageDialog(pof, "Sistem je obrisao Skolsko Dete", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    pripremiFormu();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(pof, "Sistem ne moze da obrise Skolsko Dete", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        pof.addCmbDECAActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                odabranoDete = (Dete) pof.getjComboBoxDECA().getSelectedItem();
                proveriObrazovanje();
            }
        });
    }

    public void otvoriFormu() {
        pripremiFormu();
        pof.setVisible(true);
    }

    public void izabranoSkolskoDete() {
        sveSakri();
        pof.getjLabelOBRAZOVANJE().setVisible(true);
        pof.getjLabelOBRAZOVANJE().setText("Obrazovanje: SKOLSKO DETE");

        pof.getjLabelSKO1().setVisible(true);
        pof.getjLabelSKO2().setVisible(true);
        pof.getjLabelSKO3().setVisible(true);
        pof.getjLabelSKO3().setText(odabranoSkolskoDete.getRazred());
        pof.getjLabelSKO4().setVisible(true);
        pof.getjLabelSKO5().setVisible(true);
        pof.getjLabelSKO5().setText(odabranoSkolskoDete.getOdeljenje());

        pof.getjButtonSKOAZURIRAJ().setVisible(true);
        pof.getjButtonSKOOBRISI().setVisible(true);
    }

    public void izabranoPredskolskoDete() {
        sveSakri();
        pof.getjLabelOBRAZOVANJE().setVisible(true);
        pof.getjLabelOBRAZOVANJE().setText("Obrazovanje: PREDSKOLSKO DETE");

        pof.getjLabelPRED1().setVisible(true);
        pof.getjLabelPRED2().setVisible(true);
        pof.getjLabelPRED3().setVisible(true);
        pof.getjLabelPRED3().setText(odabranoPredskolskoDete.getGrupa());

        pof.getjButtonPREDAZURIRAJ().setVisible(true);
        pof.getjButtonPREDOBRISI().setVisible(true);

    }

    public void izabranoNeobrazovanoDete() {
        sveSakri();
        pof.getjLabelOBRAZOVANJE().setVisible(true);
        pof.getjLabelOBRAZOVANJE().setText("Obrazovanje: DETE JE NEOBRAZOVANO");
        pof.getjButtonKATEGORISIPREDSKOLSKO().setVisible(true);
        pof.getjButtonKATEGORISISKOLSKO().setVisible(true);
    }

    public void sveSakri() {
        pof.getjLabelOBRAZOVANJE().setVisible(false);

        pof.getjButtonKATEGORISIPREDSKOLSKO().setVisible(false);
        pof.getjButtonKATEGORISISKOLSKO().setVisible(false);

        pof.getjLabelPRED1().setVisible(false);
        pof.getjLabelPRED2().setVisible(false);
        pof.getjLabelPRED3().setVisible(false);

        pof.getjButtonPREDAZURIRAJ().setVisible(false);
        pof.getjButtonPREDOBRISI().setVisible(false);

        pof.getjLabelSKO1().setVisible(false);
        pof.getjLabelSKO2().setVisible(false);
        pof.getjLabelSKO3().setVisible(false);
        pof.getjLabelSKO4().setVisible(false);
        pof.getjLabelSKO5().setVisible(false);

        pof.getjButtonSKOAZURIRAJ().setVisible(false);
        pof.getjButtonSKOOBRISI().setVisible(false);
    }

    public void proveriObrazovanje() {
        odabranoPredskolskoDete = null;
        odabranoSkolskoDete = null;

        if (odabranoDete != null) {
            int idDete = odabranoDete.getIdDete(); // Get the selected child's ID

            // Search in predskolskaDeca
            for (PredskolskoDete dete : predskolskaDeca) {
                if (dete.getIdDete() == idDete) {
                    odabranoPredskolskoDete = dete;
                    izabranoPredskolskoDete();
                    return;
                }
            }

            // Search in skolskaDeca (only if not already found in predskolskaDeca)
            for (SkolskoDete dete : skolskaDeca) {
                if (dete.getIdDete() == idDete) {
                    odabranoSkolskoDete = dete;
                    izabranoSkolskoDete();
                    return;
                }
            }

            izabranoNeobrazovanoDete();
        }
    }

    public void pripremiFormu() {
        List<Dete> deca = communication.Communication.getInstance().ucitajDecu();
        predskolskaDeca = communication.Communication.getInstance().ucitajPredskolskuDecu();
        skolskaDeca = communication.Communication.getInstance().ucitajSkolskuDecu();
        sveSakri();
        pof.getjComboBoxDECA().removeAllItems();
        if (deca == null || deca.isEmpty()) {
            System.out.println("deca su prazna");
        } else {
            for (Dete d : deca) {
                pof.getjComboBoxDECA().addItem(d);//TODO proveri da li je na pocetku nesto selektovano ili nije, idem sa pretpostavkom da nije
            }
//            odabranoDete = deca.get(0);
//            proveriObrazovanje();
        }

    }

}
