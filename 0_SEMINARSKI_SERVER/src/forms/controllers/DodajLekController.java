/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.controllers;

import domain.Lek;
import forms.DodajLekForm;
import forms.FormMode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import operations.lek.DodajLekSO;
import operations.lek.IzmeniLekSO;

/**
 *
 * @author ognje
 */
public class DodajLekController {

    private final DodajLekForm dlf;

    public DodajLekController(DodajLekForm dlf) {
        this.dlf = dlf;
        addActionListenes();
    }

    private void addActionListenes() {
        dlf.dodajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aktivniSastojak = dlf.getjTextFieldAKTIVNISASTOJAK().getText();
                String farmaceutskaGrupa = dlf.getjTextFieldFARMACEUTSKAGRUPA().getText();
                String naziv = dlf.getjTextFieldNAZIV().getText();
                String proizvodjac = dlf.getjTextFieldPROIZVODJAC().getText();
                
                Lek lek = new Lek(-1, naziv, proizvodjac, aktivniSastojak, farmaceutskaGrupa);

                try {
                    DodajLekSO so = new DodajLekSO();
                    so.izvrsi(lek, null);
                    
                    JOptionPane.showMessageDialog(dlf, "Sistem je kreirao lek", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    ocistiPolja();
                    cordinator.Cordinator.getInstance().osveziPrikazLekovaForm();

                    dlf.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dlf, "Sistem ne moze da kreira lek", "Greska", JOptionPane.ERROR_MESSAGE);
                    System.out.println(ex);
                }
            }

        });
        dlf.azurirajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aktivniSastojak = dlf.getjTextFieldAKTIVNISASTOJAK().getText();
                String farmaceutskaGrupa = dlf.getjTextFieldFARMACEUTSKAGRUPA().getText();
                String naziv = dlf.getjTextFieldNAZIV().getText();
                String proizvodjac = dlf.getjTextFieldPROIZVODJAC().getText();
                
                Lek l = (Lek) cordinator.Cordinator.getInstance().vratiParam("lek");
                Lek lek = new Lek(l.getIdLek(), naziv, proizvodjac, aktivniSastojak, farmaceutskaGrupa);
                try {
                    IzmeniLekSO so = new IzmeniLekSO();
                    so.izvrsi(lek, null);

                    JOptionPane.showMessageDialog(dlf, "Sistem je izmenio lek", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    ocistiPolja();
                    cordinator.Cordinator.getInstance().osveziPrikazLekovaForm();

                    dlf.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dlf, "Sistem ne moze da izmeni lek", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
    }

    public void otvoriFormu(FormMode mode) {
        pripremiFormu(mode);
        dlf.setVisible(true);
    }

    private void ocistiPolja() {
        dlf.getjTextFieldAKTIVNISASTOJAK().setText("");
        dlf.getjTextFieldFARMACEUTSKAGRUPA().setText("");
        dlf.getjTextFieldNAZIV().setText("");
        dlf.getjTextFieldPROIZVODJAC().setText("");

    }

    private void pripremiFormu(FormMode mode) {
        if (mode == FormMode.DODAJ) {

            dlf.getjButtonDODAJ().setVisible(true);
            dlf.getjButtonAZURIRAJ().setVisible(false);
            dlf.getjLabelID1().setVisible(false);
            dlf.getjLabelID2().setVisible(false);

        } else if (mode == FormMode.IZMENI) {
            dlf.getjButtonDODAJ().setVisible(false);
            dlf.getjButtonAZURIRAJ().setVisible(true);
            dlf.getjLabelID1().setVisible(true);
            dlf.getjLabelID2().setVisible(true);
            Lek l = (Lek) cordinator.Cordinator.getInstance().vratiParam("lek");

            dlf.getjLabelID2().setText(l.getIdLek() + "");
            dlf.getjTextFieldAKTIVNISASTOJAK().setText(l.getAktivniSastojak());
            dlf.getjTextFieldFARMACEUTSKAGRUPA().setText(l.getFarmaceutskaGrupa());
            dlf.getjTextFieldNAZIV().setText(l.getNaziv());
            dlf.getjTextFieldPROIZVODJAC().setText(l.getProizvodjac());

        }
    }
}
