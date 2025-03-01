/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import domain.Recept;
import domain.StavkaRecepta;
import forms.PrikazReceptaForm;
import forms.models.ModelTabeleRecepti;
import forms.models.ModelTabeleStavke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ognje
 */
public class PrikazReceptaController {

    private final PrikazReceptaForm prf;

    public PrikazReceptaController(PrikazReceptaForm prf) {
        this.prf = prf;
        addActionListenes();
        addMouseListeners();
    }

    private void addActionListenes() {
        
        prf.addBtnOBRISIreceptActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = prf.getjTableRECEPTI().getSelectedRow();
                if (red == -1) {
                    //TODO poruke u joption pane moraju da budu kao u dokumentaciji
                    JOptionPane.showMessageDialog(prf, "Sistem ne moze da obrise recept", "Greska", JOptionPane.ERROR_MESSAGE);
                } else {
                    ModelTabeleRecepti mtr = (ModelTabeleRecepti) prf.getjTableRECEPTI().getModel();
                    Recept recept = mtr.getLista().get(red);
                    try {
                        communication.Communication.getInstance().obrisiRecept(recept);
                        JOptionPane.showMessageDialog(prf, "Sistem je obrisao recept", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                        pripremiFormu();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(prf, "Sistem ne moze da obrise recept", "Greska", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        });
        prf.addBtnDODAJstavkuActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = prf.getjTableRECEPTI().getSelectedRow();
                if (red == -1) {
                    //TODO poruke u joption pane moraju da budu kao u dokumentaciji
                    JOptionPane.showMessageDialog(prf, "Sistem ne moze da doda stavku", "Greska", JOptionPane.ERROR_MESSAGE);
                } else {
                    ModelTabeleRecepti mtr = (ModelTabeleRecepti) prf.getjTableRECEPTI().getModel();
                    Recept recept = mtr.getLista().get(red);

                    cordinator.Cordinator.getInstance().dodajParam("recept", recept);
                    cordinator.Cordinator.getInstance().openDodajStavkuRecepta();

                }

            }
        });
        prf.addBtnOBRISIstavkuActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = prf.getjTableStavke().getSelectedRow();
                if (red == -1) {
                    //TODO poruke u joption pane moraju da budu kao u dokumentaciji
                    JOptionPane.showMessageDialog(prf, "Sistem ne moze da obrise stavku recepta", "Greska", JOptionPane.ERROR_MESSAGE);
                } else {
                    ModelTabeleStavke mts = (ModelTabeleStavke) prf.getjTableStavke().getModel();
                    StavkaRecepta stavkaRecepta = mts.getLista().get(red);
                    try {
                        communication.Communication.getInstance().obrisiStavkuRecepta(stavkaRecepta);
                        JOptionPane.showMessageDialog(prf, "Sistem je obrisao stavku recepta", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                        pripremiFormu();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(prf, "Sistem ne moze da obrise stavku recepta", "Greska", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        });

        prf.addBtnPRETRAZIActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String datumIzdavanjaString = prf.getjTextFieldDATUMIZDAVANJA().getText();

                LocalDate datumIzdavanja = null;
                if (!datumIzdavanjaString.isEmpty()) {
                    try {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
                        datumIzdavanja = LocalDate.parse(datumIzdavanjaString, formatter);
                    } catch (DateTimeParseException ex) {
                        System.err.println("Invalid date format: " + datumIzdavanjaString);
                        JOptionPane.showMessageDialog(prf, "Sistem ne moze da pretrazi recept", "Greska", JOptionPane.ERROR_MESSAGE);
                        return; // Exit early if the date is invalid
                    }
                }

                String imeDeteta = prf.getjTextFieldImeDETETA().getText();
                String prezimeDeteta = prf.getjTextFieldPrezimeDETETA().getText();
                String imeDoktora = prf.getjTextFieldIMEdoktora().getText();
                String prezimeDoktora = prf.getjTextFieldPREZIMEdoktora().getText();

                ModelTabeleRecepti mtr = (ModelTabeleRecepti) prf.getjTableRECEPTI().getModel();
                mtr.pretrazi(imeDeteta, prezimeDeteta, imeDoktora, prezimeDoktora, imeDoktora, datumIzdavanja);

                List<StavkaRecepta> stavkeRecepata = new ArrayList<>();
                ModelTabeleStavke mts = new ModelTabeleStavke(stavkeRecepata);
                prf.getjTableStavke().setModel(mts);
            }

        });
        prf.addBtnRESETUJActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pripremiFormu();
            }

        });
    }

    private void addMouseListeners() {
        prf.getjTableRECEPTI().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int red = prf.getjTableRECEPTI().getSelectedRow();
                if (red != -1) {
                    ModelTabeleRecepti mtr = (ModelTabeleRecepti) prf.getjTableRECEPTI().getModel();
                    Recept recept = mtr.getLista().get(red);
                    List<StavkaRecepta> stavke = communication.Communication.getInstance().ucitajStavke(recept.getIdRecept());
                    ModelTabeleStavke mts = new ModelTabeleStavke(stavke);
                    prf.getjTableStavke().setModel(mts);
                }
            }
        });
    }

    public void otvoriFormu() {
        pripremiFormu();
        prf.setVisible(true);
    }

    public void pripremiFormu() {
        List<Recept> recepti = communication.Communication.getInstance().ucitajRecepte();
        ModelTabeleRecepti mtr = new ModelTabeleRecepti(recepti);
        prf.getjTableRECEPTI().setModel(mtr);

        List<StavkaRecepta> stavkeRecepata = new ArrayList<>();
        ModelTabeleStavke mts = new ModelTabeleStavke(stavkeRecepata);
        prf.getjTableStavke().setModel(mts);
    }
}
