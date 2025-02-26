/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import domain.Dete;
import domain.PredskolskoDete;
import domain.SkolskoDete;

import forms.PrikazObrazovanjaForm;
import forms.models.ModelTabeleDeca;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
                
            }
        });
        pof.addBtnKATEGORISISKOLSKOActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        pof.addBtnPREDAZURIRAJActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        pof.addBtnPREDOBRISIActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        pof.addBtnSKOAZURIRAJActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        pof.addBtnSKOOBRISIActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        pof.addCmbDECAActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    public void otvoriFormu() {
        pripremiFormu();
        pof.setVisible(true);
    }

    public void pripremiFormu() {
        List<Dete> deca = communication.Communication.getInstance().ucitajDecu();
        if (deca == null || deca.isEmpty()) {
            System.out.println("deca su prazna");
        } else {
            for (Dete d : deca) {
                pof.getjComboBoxDECA().addItem(d);//TODO proveri da li je na pocetku nesto selektovano ili nije, idem sa pretpostavkom da nije
            }
        }

    }

}
