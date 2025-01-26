/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import forms.MainForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import cordinator.Cordinator;
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
        mainForm.mainAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }

        });
    }

    public void otvoriFormu() {
        mainForm.setVisible(true);
        mainForm.getjLabelNAME().setText(Cordinator.getInstance().getUlogovani().getIme() + " " + Cordinator.getInstance().getUlogovani().getPrezime());
    }
}
