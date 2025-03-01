/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.controllers;

import domain.Doktor;
import domain.DrSp;
import domain.Specijalizacija;
import forms.PrikazDoktoraForm;
import forms.models.ModelTabeleDoktori;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ognje
 */
public class PrikazDoktoraController {

    private final PrikazDoktoraForm pdf;

    public PrikazDoktoraController(PrikazDoktoraForm pdf) {
        this.pdf = pdf;
        addActionListenes();
    }

    private void addActionListenes() {

        pdf.AZURIRAJaddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = pdf.getjTableDOKTORI().getSelectedRow();
                if (red == -1) {
                    //TODO poruke u joption pane moraju da budu kao u dokumentaciji
                    JOptionPane.showMessageDialog(pdf, "Sistem ne moze da azurira doktora", "Greska", JOptionPane.ERROR_MESSAGE);
                } else {
                    ModelTabeleDoktori mtd = (ModelTabeleDoktori) pdf.getjTableDOKTORI().getModel();
                    DrSp drsp = mtd.getLista().get(red);
                    Doktor doktor = drsp.getDoktor();
                    cordinator.Cordinator.getInstance().dodajParam("doktor", doktor);
                    cordinator.Cordinator.getInstance().otvoriIzmeniDoktoraForm();

                }
            }
        });

        pdf.DODAJaddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cordinator.Cordinator.getInstance().otvoriDodajDoktoraForm();

            }
        });

        pdf.OBRISIaddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = pdf.getjTableDOKTORI().getSelectedRow();
                if (red == -1) {
                    //TODO poruke u joption pane moraju da budu kao u dokumentaciji
                    JOptionPane.showMessageDialog(pdf, "Sistem ne moze da obrise doktora", "Greska", JOptionPane.ERROR_MESSAGE);
                } else {
                    ModelTabeleDoktori mtd = (ModelTabeleDoktori) pdf.getjTableDOKTORI().getModel();
                    DrSp drsp = mtd.getLista().get(red);
                    Doktor doktor = drsp.getDoktor();
                    try {
                        if (doktor == null) {
                            throw new Exception();
                        }

                        controller.Controller.getInstance().obrisiDoktora(doktor);

                        JOptionPane.showMessageDialog(pdf, "Sistem je obrisao doktora", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                        pripremiFormu();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(pdf, "Sistem ne moze da obrise doktora", "Greska", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        });

        pdf.DODAJSPECIJALIZACIJUaddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = pdf.getjTableDOKTORI().getSelectedRow();
                if (red == -1) {
                    //TODO poruke u joption pane moraju da budu kao u dokumentaciji
                    JOptionPane.showMessageDialog(pdf, "Sistem ne moze da specijalizuje doktora", "Greska", JOptionPane.ERROR_MESSAGE);
                } else {
                    ModelTabeleDoktori mtd = (ModelTabeleDoktori) pdf.getjTableDOKTORI().getModel();
                    DrSp drsp = mtd.getLista().get(red);
                    Specijalizacija spec = (Specijalizacija) pdf.getjComboBoxSPECIJALIZACIJA().getSelectedItem();
                    try {
                        if (drsp.getSpecijalizacija() != null || spec == null) {
                            throw new Exception();
                        }
                        drsp.setSpecijalizacija(spec);

                        controller.Controller.getInstance().dodajDRSP(drsp);

                        JOptionPane.showMessageDialog(pdf, "Sistem je specijalizovao doktora", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                        pripremiFormu();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(pdf, "Sistem ne moze da specijalizuje doktora", "Greska", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        });
        pdf.OBRISISPECIJALIZACIJUaddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = pdf.getjTableDOKTORI().getSelectedRow();
                if (red == -1) {
                    //TODO poruke u joption pane moraju da budu kao u dokumentaciji
                    JOptionPane.showMessageDialog(pdf, "Sistem ne moze da despecijalizuje doktora", "Greska", JOptionPane.ERROR_MESSAGE);
                } else {
                    ModelTabeleDoktori mtd = (ModelTabeleDoktori) pdf.getjTableDOKTORI().getModel();
                    DrSp drsp = mtd.getLista().get(red);
                    try {
                        if (drsp.getSpecijalizacija() == null) {
                            throw new Exception();
                        }

                        controller.Controller.getInstance().obrisiDRSP(drsp);

                        JOptionPane.showMessageDialog(pdf, "Sistem je despecijalizovao doktora", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                        pripremiFormu();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(pdf, "Sistem ne moze da despecijalizuje doktora", "Greska", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        });

    }

    public void otvoriFormu() {
        pripremiFormu();
        pdf.setVisible(true);
    }

    public void pripremiFormu() {
        List<DrSp> drsps = new ArrayList<>();

        try {
            drsps = controller.Controller.getInstance().ucitajDRSP();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        List<Doktor> doktori = new ArrayList<>();
        try {
            doktori = controller.Controller.getInstance().ucitajDoktore();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        List<DrSp> newDrsps = new ArrayList<>(drsps);

        for (Doktor doktor : doktori) {
            boolean exists = drsps.stream().anyMatch(d -> d.getDoktor().getIdDoktor() == doktor.getIdDoktor());
            if (!exists) {
                newDrsps.add(new DrSp(doktor, null));
            }
        }

        ModelTabeleDoktori mtd = new ModelTabeleDoktori(newDrsps);
        pdf.getjTableDOKTORI().setModel(mtd);

        List<Specijalizacija> specijalizacije = new ArrayList<>();
        try {
            specijalizacije = controller.Controller.getInstance().ucitajSpecijalizacije();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        pdf.getjComboBoxSPECIJALIZACIJA().removeAllItems();
        for (Specijalizacija specijalizacija : specijalizacije) {
            pdf.getjComboBoxSPECIJALIZACIJA().addItem(specijalizacija);
        }
    }
}
