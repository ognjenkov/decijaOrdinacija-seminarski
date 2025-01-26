/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Dete;
import domain.Doktor;
import java.util.List;
import operations.dete.DodajDeteSO;
import operations.dete.IzmeniDeteSO;
import operations.dete.ObrisiDeteSO;
import operations.dete.UcitajDecuSO;
import operations.login.LoginOperation;

/**
 *
 * @author ognje
 */
public class Controller {

    private static Controller instance;

    private Controller() {

    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Doktor login(Doktor d) throws Exception {
        System.out.println("Controller - login");
        LoginOperation op = new LoginOperation();
        op.izvrsi(d, null);
        return op.getDoktor();
    }

    public List<Dete> ucitajDecu() throws Exception {
        System.out.println("Controller - ucitajDecu");

        UcitajDecuSO so = new UcitajDecuSO();
        so.izvrsi(new Dete(), null);
        return so.getDeca();
    }

    public void obrisiDete(Dete dete) throws Exception {
        System.out.println("Controller - obrisiDete");

        ObrisiDeteSO obrisi = new ObrisiDeteSO();
        obrisi.izvrsi(dete, null);
    }

    public void dodajDete(Dete dete) throws Exception {
        System.out.println("Controller - dodajDete");

        DodajDeteSO so = new DodajDeteSO();
        so.izvrsi(dete, null);
    }

    public void izmeniDete(Dete dete) throws Exception {
        System.out.println("Controller - izmeniDete");
        IzmeniDeteSO so = new IzmeniDeteSO();
        so.izvrsi(dete, null);
    }
}
