/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.controllers;

import domain.Doktor;
import forms.DodajDoktoraForm;
import forms.FormMode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import operations.doktor.DodajDoktoraSO;
import operations.doktor.IzmeniDoktorSO;

/**
 *
 * @author ognje
 */
public class DodajDoktoraController {

    private final DodajDoktoraForm ddf;

    public DodajDoktoraController(DodajDoktoraForm ddf) {
        this.ddf = ddf;
        addActionListenes();
    }

    private void addActionListenes() {
        ddf.dodajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = ddf.getjTextFieldEMAIL().getText();
                String ime = ddf.getjTextFieldIME().getText();
                String prezime = ddf.getjTextFieldPREZIME().getText();
                String sifra = String.valueOf(ddf.getjPasswordFieldSIFRA().getPassword());

                Doktor doktor = new Doktor(-1, ime, prezime, email, sifra);

                try {
                    controller.Controller.getInstance().dodajDoktora(doktor);

                    JOptionPane.showMessageDialog(ddf, "Sistem je kreirao doktora", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    cordinator.Cordinator.getInstance().osveziPrikazDoktoraForm();

                    ddf.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ddf, "Sistem ne moze da kreira doktora", "Greska", JOptionPane.ERROR_MESSAGE);
                    System.out.println(ex);
                }
            }
        });
        ddf.azurirajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = ddf.getjTextFieldEMAIL().getText();
                String ime = ddf.getjTextFieldIME().getText();
                String prezime = ddf.getjTextFieldPREZIME().getText();
                String sifra = String.valueOf(ddf.getjPasswordFieldSIFRA().getPassword());

                Doktor d = (Doktor) cordinator.Cordinator.getInstance().vratiParam("doktor");
                Doktor doktor = new Doktor(d.getIdDoktor(), ime, prezime, email, sifra);

                try {
                    controller.Controller.getInstance().izmeniDoktora(doktor);

                    JOptionPane.showMessageDialog(ddf, "Sistem je azurirao doktora", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    cordinator.Cordinator.getInstance().osveziPrikazDoktoraForm();

                    ddf.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ddf, "Sistem ne moze da azurira doktora", "Greska", JOptionPane.ERROR_MESSAGE);
                    System.out.println(ex);
                }
            }
        });
    }

    public void otvoriFormu(FormMode mode) {
        pripremiFormu(mode);
        ddf.setVisible(true);
    }

    private void pripremiFormu(FormMode mode) {
        if (mode == FormMode.DODAJ) {

            ddf.getjButtonDODAJ().setVisible(true);
            ddf.getjButtonAZURIRAJ().setVisible(false);
            ddf.getjLabelID1().setVisible(false);
            ddf.getjLabelID2().setVisible(false);

            ddf.getjTextFieldEMAIL().setText("");
            ddf.getjTextFieldIME().setText("");
            ddf.getjTextFieldPREZIME().setText("");
//            ddf.getjPasswordFieldSIFRA().setText(l.getProizvodjac());

        } else if (mode == FormMode.IZMENI) {
            ddf.getjButtonDODAJ().setVisible(false);
            ddf.getjButtonAZURIRAJ().setVisible(true);
            ddf.getjLabelID1().setVisible(true);
            ddf.getjLabelID2().setVisible(true);
            Doktor d = (Doktor) cordinator.Cordinator.getInstance().vratiParam("doktor");

            ddf.getjLabelID2().setText(d.getIdDoktor() + "");
            ddf.getjTextFieldEMAIL().setText(d.getEmail());
            ddf.getjTextFieldIME().setText(d.getIme());
            ddf.getjTextFieldPREZIME().setText(d.getPrezime());
//            ddf.getjPasswordFieldSIFRA().setText(l.getProizvodjac());

        }
    }
}
