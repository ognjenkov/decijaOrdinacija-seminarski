/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import forms.MainForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import cordinator.Cordinator;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
        mainForm.mainAddActionListener(new ActionListener() {
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
                    communication.Communication.getInstance().disconnect();
                    Cordinator.getInstance().setUlogovani(null);

                    JOptionPane.showMessageDialog(mainForm, "Izlogovali ste se", "Success", JOptionPane.INFORMATION_MESSAGE);
                    Cordinator.getInstance().otvoriLoginFormu();
                    mainForm.dispose();
                    //TODO treba da se otvori sledeca forma
                    
                }
                
            }
            
        });
    }

    public void otvoriFormu() {
        mainForm.setVisible(true);
        mainForm.getjLabelNAME().setText(Cordinator.getInstance().getUlogovani().getIme() + " " + Cordinator.getInstance().getUlogovani().getPrezime());
    }
}
