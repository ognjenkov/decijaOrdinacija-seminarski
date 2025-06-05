/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import forms.MainForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import cordinator.Cordinator;
import domain.Dete;
import domain.Doktor;
import domain.Lek;
import domain.Recept;
import domain.StavkaRecepta;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ognje
 */
public class MainController {

    private final MainForm mainForm;

    public MainController(MainForm mainForm) {
        this.mainForm = mainForm;
        addActionListenes();
    }

    private void addActionListenes() {
        mainForm.LOGOUTAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean successfulDisconnect = communication.Communication.getInstance().logout();

                if (!successfulDisconnect) {
                    //TODO
                    JOptionPane.showMessageDialog(mainForm, "Logout error", "Error", JOptionPane.ERROR_MESSAGE);

                } else {
                    communication.Communication.getInstance().disconnect();
                    Cordinator.getInstance().setUlogovani(null);

                    JOptionPane.showMessageDialog(mainForm, "Izlogovali ste se", "Success", JOptionPane.INFORMATION_MESSAGE);
                    Cordinator.getInstance().otvoriLoginFormu();
                    mainForm.dispose();
                    //TODO treba da se otvori sledeca forma

                }
            }

        });

        mainForm.closeAddActionListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                boolean successfulDisconnect = communication.Communication.getInstance().logout();

                if (!successfulDisconnect) {
                    //TODO
                    JOptionPane.showMessageDialog(mainForm, "Logout error", "Error", JOptionPane.ERROR_MESSAGE);

                } else {
                    Cordinator.getInstance().setUlogovani(null);

                    JOptionPane.showMessageDialog(mainForm, "Izlogovali ste se", "Success", JOptionPane.INFORMATION_MESSAGE);
                    Cordinator.getInstance().otvoriLoginFormu();
                    mainForm.dispose();
                    //TODO treba da se otvori sledeca forma

                }

            }

        });

        mainForm.addBtnIZDAJActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dijagnoza = (String) mainForm.getjComboBoxDIJAGNOZA().getSelectedItem();
                String terapija = mainForm.getjTextAreaTERAPIJA().getText();
                String zakljucak = mainForm.getjTextAreaZAKLJUCAK().getText();
                Dete dete = (Dete) mainForm.getjComboBoxDECA().getSelectedItem();
                Lek lek = (Lek) mainForm.getjComboBoxLEKOVI().getSelectedItem();
                Doktor doktor = Cordinator.getInstance().getUlogovani();

                Recept recept = new Recept(-1, doktor, dete, LocalDate.now(), dijagnoza);
                StavkaRecepta stavka = new StavkaRecepta(1, null, lek, terapija, zakljucak);
                List<StavkaRecepta> stavke = new ArrayList<>();
                stavke.add(stavka);
                recept.setStavke(stavke);
                System.out.println("get stavke" + recept.getStavke().toString());

                try {
                    communication.Communication.getInstance().dodajRecept(recept);
                    JOptionPane.showMessageDialog(mainForm, "Sistem je kreirao recept", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    mainForm.getjTextAreaTERAPIJA().setText("");
                    mainForm.getjTextAreaZAKLJUCAK().setText("");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(mainForm, "Sistem ne moze da kreira recept", "Greska", JOptionPane.ERROR_MESSAGE);

                    mainForm.getjTextAreaTERAPIJA().setText("");
                    mainForm.getjTextAreaZAKLJUCAK().setText("");

                }
            }

        });
    }

    public void otvoriFormu() {
        mainForm.setVisible(true);
        mainForm.getjLabelNAME().setText(Cordinator.getInstance().getUlogovani().getIme() + " " + Cordinator.getInstance().getUlogovani().getPrezime());
        pripremiFormu();
    }

    public void pripremiFormu() {
        List<Dete> deca = communication.Communication.getInstance().ucitajDecu();
        List<Lek> lekovi = communication.Communication.getInstance().ucitajLekove();

        isprazniSvaPolja();

        if (deca == null || deca.isEmpty()) {
            System.out.println("deca su prazna");
        } else {
            for (Dete d : deca) {
                mainForm.getjComboBoxDECA().addItem(d);//TODO proveri da li je na pocetku nesto selektovano ili nije, idem sa pretpostavkom da nije
            }
        }

        if (lekovi == null || lekovi.isEmpty()) {
            System.out.println("lekovi su prazni");
        } else {
            for (Lek l : lekovi) {
                mainForm.getjComboBoxLEKOVI().addItem(l);//TODO proveri da li je na pocetku nesto selektovano ili nije, idem sa pretpostavkom da nije
            }
        }

    }

    public void isprazniSvaPolja() {
        mainForm.getjComboBoxDECA().removeAllItems();
        mainForm.getjComboBoxLEKOVI().removeAllItems();
        mainForm.getjTextAreaTERAPIJA().setText("");
        mainForm.getjTextAreaZAKLJUCAK().setText("");
    }

}
