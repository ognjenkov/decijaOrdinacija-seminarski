/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.controllers;

import cordinator.Cordinator;
import domain.Lek;
import forms.PrikazLekovaForm;
import forms.models.ModelTabeleLekovi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import operations.lek.ObrisiLekSO;
import operations.lek.UcitajLekoveSO;

/**
 *
 * @author ognje
 */
public class PrikazLekovaController {

    private final PrikazLekovaForm plf;

    public PrikazLekovaController(PrikazLekovaForm plf) {
        this.plf = plf;
        addActionListenes();
    }

    private void addActionListenes() {

        plf.addBTNobrisiAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = plf.getjTableLEK().getSelectedRow();
                if (red == -1) {
                    //TODO poruke u joption pane moraju da budu kao u dokumentaciji
                    JOptionPane.showMessageDialog(plf, "Sistem ne moze da obrise lek", "Greska", JOptionPane.ERROR_MESSAGE);
                } else {
                    ModelTabeleLekovi mtl = (ModelTabeleLekovi) plf.getjTableLEK().getModel();
                    Lek lek = mtl.getLista().get(red);
                    try {
                        ObrisiLekSO so = new ObrisiLekSO();
                        so.izvrsi(lek, null);

                        JOptionPane.showMessageDialog(plf, "Sistem je obrisao lek", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                        pripremiFormu();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(plf, "Sistem ne moze da obrise lek", "Greska", JOptionPane.ERROR_MESSAGE);
                    }

                }

            }

        });

        plf.addBTNazurirajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = plf.getjTableLEK().getSelectedRow();
                if (red == -1) {
                    //TODO poruke u joption pane moraju da budu kao u dokumentaciji
                    JOptionPane.showMessageDialog(plf, "Sistem ne moze da azurira lek", "Greska", JOptionPane.ERROR_MESSAGE);
                } else {
                    ModelTabeleLekovi mtl = (ModelTabeleLekovi) plf.getjTableLEK().getModel();
                    Lek lek = mtl.getLista().get(red);
                    cordinator.Cordinator.getInstance().dodajParam("lek", lek);
                    cordinator.Cordinator.getInstance().otvoriIzmeniLekFormu();

                }

            }

        });
        plf.addBTNdodajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cordinator.getInstance().otvoriDodajLekFormu();
            }

        });
        plf.addBTNpretraziAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aktivniSastojak = plf.getjTextFieldAKTIVNISASTOJAK().getText().trim();
                String farmaceutskaGrupa = plf.getjTextFieldFARMACEUTSKAGRUPA().getText().trim();
                String naziv = plf.getjTextFieldNAZIV().getText().trim();
                String proizvodjac = plf.getjTextFieldPROIZVODJAC().getText().trim();

                ModelTabeleLekovi mtl = (ModelTabeleLekovi) plf.getjTableLEK().getModel();
                mtl.pretrazi(aktivniSastojak.isEmpty() ? null : aktivniSastojak, farmaceutskaGrupa.isEmpty() ? null : farmaceutskaGrupa, naziv.isEmpty() ? null : naziv, proizvodjac.isEmpty() ? null : proizvodjac);
            }

        });
        plf.addBTNresetujAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pripremiFormu();
            }

        });
    }

    public void otvoriFormu() {
        pripremiFormu();
        plf.setVisible(true);
    }

    public void pripremiFormu() {
        UcitajLekoveSO so = new UcitajLekoveSO();
        try {
            so.izvrsi(new Lek(), null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        List<Lek> lekovi = so.getLekovi();
        ModelTabeleLekovi mtl = new ModelTabeleLekovi(lekovi);
        plf.getjTableLEK().setModel(mtl);
    }
}
