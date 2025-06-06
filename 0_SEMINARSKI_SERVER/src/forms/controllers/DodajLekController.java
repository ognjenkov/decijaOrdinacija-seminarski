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

                String naziv = dlf.getjTextFieldNAZIV().getText();
                String proizvodjac = dlf.getjTextFieldPROIZVODJAC().getText();
                String inn = dlf.getjTextFieldINN().getText();
                String atcKlasifikacija = dlf.getjTextFieldATCKLASIFIKACIJA().getText();
                String farmakoloskaHemijskaPodgrupa = dlf.getjTextFieldFARMAKOLOSKA().getText();
                String farmaceutskiOblik = dlf.getjTextFieldFARMACEUTSKIOBLIK().getText();
                String sadrzajAktivneSupstance = dlf.getjTextFieldSADRZAJAKTIVNESUPSTANCE().getText();
                String pakovanje = dlf.getjTextFieldPAKOVANJE().getText();
                String terapijskaGrupa = dlf.getjTextFieldTERAPIJSKAGRUPA().getText();

                Lek lek = new Lek(-1, naziv, proizvodjac, inn, atcKlasifikacija, farmakoloskaHemijskaPodgrupa, farmaceutskiOblik, sadrzajAktivneSupstance, pakovanje, terapijskaGrupa);

                try {
                    if (proizvodjac.length() <= naziv.length()
                            || inn.length() <= proizvodjac.length() + 1
                            || atcKlasifikacija.length() <= inn.length() + 2) {
                        throw new Exception("Medjuzavisnost atributa jedne tabele");
                    }

                    controller.Controller.getInstance().dodajLek(lek);

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
                String naziv = dlf.getjTextFieldNAZIV().getText();
                String proizvodjac = dlf.getjTextFieldPROIZVODJAC().getText();
                String inn = dlf.getjTextFieldINN().getText();
                String atcKlasifikacija = dlf.getjTextFieldATCKLASIFIKACIJA().getText();
                String farmakoloskaHemijskaPodgrupa = dlf.getjTextFieldFARMAKOLOSKA().getText();
                String farmaceutskiOblik = dlf.getjTextFieldFARMACEUTSKIOBLIK().getText();
                String sadrzajAktivneSupstance = dlf.getjTextFieldSADRZAJAKTIVNESUPSTANCE().getText();
                String pakovanje = dlf.getjTextFieldPAKOVANJE().getText();
                String terapijskaGrupa = dlf.getjTextFieldTERAPIJSKAGRUPA().getText();

                Lek l = (Lek) cordinator.Cordinator.getInstance().vratiParam("lek");
                Lek lek = new Lek(l.getIdLek(), naziv, proizvodjac, inn, atcKlasifikacija, farmakoloskaHemijskaPodgrupa, farmaceutskiOblik, sadrzajAktivneSupstance, pakovanje, terapijskaGrupa);
                try {
                    if (proizvodjac.length() <= naziv.length()
                            || inn.length() <= proizvodjac.length() + 1
                            || atcKlasifikacija.length() <= inn.length() + 2) {
                        throw new Exception("Medjuzavisnost atributa jedne tabele");
                    }
                    
                    controller.Controller.getInstance().izmeniLek(lek);

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
        dlf.getjTextFieldNAZIV().setText("");
        dlf.getjTextFieldPROIZVODJAC().setText("");
        dlf.getjTextFieldINN().setText("");
        dlf.getjTextFieldATCKLASIFIKACIJA().setText("");
        dlf.getjTextFieldFARMAKOLOSKA().setText("");
        dlf.getjTextFieldFARMACEUTSKIOBLIK().setText("");
        dlf.getjTextFieldSADRZAJAKTIVNESUPSTANCE().setText("");
        dlf.getjTextFieldPAKOVANJE().setText("");
        dlf.getjTextFieldTERAPIJSKAGRUPA().setText("");
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
            dlf.getjTextFieldNAZIV().setText(l.getNaziv());
            dlf.getjTextFieldPROIZVODJAC().setText(l.getProizvodjac());
            dlf.getjTextFieldINN().setText(l.getInn());
            dlf.getjTextFieldATCKLASIFIKACIJA().setText(l.getAtcKlasifikacija());
            dlf.getjTextFieldFARMAKOLOSKA().setText(l.getFarmakoloskaHemijskaPodgrupa());
            dlf.getjTextFieldFARMACEUTSKIOBLIK().setText(l.getFarmaceutskiOblik());
            dlf.getjTextFieldSADRZAJAKTIVNESUPSTANCE().setText(l.getSadrzajAktivneSupstance());
            dlf.getjTextFieldPAKOVANJE().setText(l.getPakovanje());
            dlf.getjTextFieldTERAPIJSKAGRUPA().setText(l.getTerapijskaGrupa());

        }
    }
}
