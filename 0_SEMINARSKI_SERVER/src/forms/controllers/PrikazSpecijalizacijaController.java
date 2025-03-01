/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.controllers;

import domain.Specijalizacija;
import forms.PrikazSpecijalizacijaForm;
import forms.models.ModelTabeleSpecijalizacije;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import operations.specijalizacija.DodajSpecijalizacijuSO;
import operations.specijalizacija.ObrisiSpecijalizacijaSO;
import operations.specijalizacija.UcitajSpecijalizacijeSO;

/**
 *
 * @author ognje
 */
public class PrikazSpecijalizacijaController {
    private final PrikazSpecijalizacijaForm psf;

    public PrikazSpecijalizacijaController(PrikazSpecijalizacijaForm psf) {
        this.psf = psf;
        addActionListenes();
    }

    private void addActionListenes() {
        psf.dodajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String naziv = psf.getjTextFieldSPECIJALIZACIJA().getText();
                
                Specijalizacija specijalizacija = new Specijalizacija(-1, naziv);

                try {
                    controller.Controller.getInstance().dodajSpecijalizaciju(specijalizacija);
                    
                    
                    JOptionPane.showMessageDialog(psf, "Sistem je kreirao specijalizaciju", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    pripremiFormu();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(psf, "Sistem ne moze da kreira specijalizaciju", "Greska", JOptionPane.ERROR_MESSAGE);
                    System.out.println(ex);
                }
            }

        });
        psf.obrisiAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           
                int red = psf.getjTableSPECIJALIZACIJA().getSelectedRow();
                if (red == -1) {
                    //TODO poruke u joption pane moraju da budu kao u dokumentaciji
                    JOptionPane.showMessageDialog(psf, "Sistem ne moze da obrise specijalizaciju", "Greska", JOptionPane.ERROR_MESSAGE);
                } else {
                    ModelTabeleSpecijalizacije mts = (ModelTabeleSpecijalizacije) psf.getjTableSPECIJALIZACIJA().getModel();
                    Specijalizacija specijalizacija = mts.getLista().get(red);
                    try {
                        controller.Controller.getInstance().obrisiSpecijalizaciju(specijalizacija);

                        JOptionPane.showMessageDialog(psf, "Sistem je obrisao specijalizaciju", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                        pripremiFormu();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(psf, "Sistem ne moze da obrise specijalizaciju", "Greska", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        });
    }

    public void otvoriFormu() {
        pripremiFormu();
        psf.setVisible(true);
    }
    
    private void ocistiPolja() {
        psf.getjTextFieldSPECIJALIZACIJA().setText("");
    }

    public void pripremiFormu() {
        ocistiPolja();
        List<Specijalizacija> specijalizacije = new ArrayList<>();
        try {
            specijalizacije = controller.Controller.getInstance().ucitajSpecijalizacije();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ModelTabeleSpecijalizacije mts = new ModelTabeleSpecijalizacije(specijalizacije);
        psf.getjTableSPECIJALIZACIJA().setModel(mts);
    }
}
