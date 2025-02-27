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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

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

//        prf.addBtnDELETEActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int red = pdf.getjTableDECA().getSelectedRow();
//                if (red == -1) {
//                    //TODO poruke u joption pane moraju da budu kao u dokumentaciji
//                    JOptionPane.showMessageDialog(pdf, "Sistem ne moze da obrise dete", "Greska", JOptionPane.ERROR_MESSAGE);
//                } else {
//                    ModelTabeleDeca mtd = (ModelTabeleDeca) pdf.getjTableDECA().getModel();
//                    Dete dete = mtd.getLista().get(red);
//                    try {
//                        communication.Communication.getInstance().obrisiDete(dete);
//                        JOptionPane.showMessageDialog(pdf, "Sistem je obrisao dete", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
//                        pripremiFormu();
//                    } catch (Exception ex) {
//                        JOptionPane.showMessageDialog(pdf, "Sistem ne moze da obrise dete", "Greska", JOptionPane.ERROR_MESSAGE);
//                    }
//
//                }
//
//            }
//
//        });
//        pdf.addBtnAZURIRAJActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int red = pdf.getjTableDECA().getSelectedRow();
//                if (red == -1) {
//                    //TODO poruke u joption pane moraju da budu kao u dokumentaciji
//                    JOptionPane.showMessageDialog(pdf, "Sistem ne moze da azurira dete", "Greska", JOptionPane.ERROR_MESSAGE);
//                } else {
//                    ModelTabeleDeca mtd = (ModelTabeleDeca) pdf.getjTableDECA().getModel();
//                    Dete dete = mtd.getLista().get(red);
//                    cordinator.Cordinator.getInstance().dodajParam("dete", dete);
//                    cordinator.Cordinator.getInstance().openIzmeniDeteFormu();
//
//                }
//
//            }
//
//        });
//        pdf.addBtnPRETRAZIctionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String ime = pdf.getjTextFieldIME().getText();
//                String prezime = pdf.getjTextFieldPREZIME().getText();
//                String datumRodjenjaString = pdf.getjTextFieldDATUMRODJENJA().getText();
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.M.yyyy");
//                LocalDate datumRodnjenja = LocalDate.parse(datumRodjenjaString, formatter);
//
//                
//                ModelTabeleDeca mtd = (ModelTabeleDeca) pdf.getjTableDECA().getModel();
//                mtd.pretrazi(ime, prezime, datumRodnjenja);
//            }
//
//        });
//        pdf.addBtnRESETUJctionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                pripremiFormu();
//            }
//
//        });
    }

    public void otvoriFormu() {
        pripremiFormu();
        prf.setVisible(true);
    }

    public void pripremiFormu() {
        List<Recept> recepti = communication.Communication.getInstance().ucitajRecepte();
        ModelTabeleRecepti mtr = new ModelTabeleRecepti(recepti);
        prf.getjTableRACUNI().setModel(mtr);
        
        List<StavkaRecepta> stavkeRecepata = new ArrayList<>();
        ModelTabeleStavke mts = new ModelTabeleStavke(stavkeRecepata);
        prf.getjTableStavke().setModel(mtr);
    }
    
    private void addMouseListeners() {
        prf.getjTableRACUNI().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int red = prf.getjTableRACUNI().getSelectedRow();
                if(red != -1) {
                    ModelTabeleRecepti mtr = (ModelTabeleRecepti) prf.getjTableRACUNI().getModel();
                    Recept recept = mtr.getLista().get(red);
                    List<StavkaRecepta> stavke = communication.Communication.getInstance().ucitajStavke(recept.getIdRecept());
                      ModelTabeleStavke mts = new ModelTabeleStavke(stavke);
                      prf.getjTableStavke().setModel(mts);
                }
            }
        });
    }
}
