/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Dete;
import domain.Doktor;
import domain.PredskolskoDete;
import domain.Recept;
import domain.SkolskoDete;
import domain.StavkaRecepta;
import java.util.List;
import operations.dete.DodajDeteSO;
import operations.dete.IzmeniDeteSO;
import operations.dete.ObrisiDeteSO;
import operations.dete.UcitajDecuSO;
import operations.login.LoginOperation;
import operations.recept.UcitajRecepteSO;
import operations.recept.UcitajStavkeSO;
import operations.predskolskoDete.IzmeniPredskolskoDeteSO;
import operations.predskolskoDete.DodajPredskolskoDeteSO;
import operations.skolskoDete.IzmeniSkolskoDeteSO;
import operations.skolskoDete.DodajSkolskoDeteSO;



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

    public List<Recept> ucitajRecepte() throws Exception {
        System.out.println("Controller - ucitajRecepte");

        UcitajRecepteSO so = new UcitajRecepteSO();
        so.izvrsi(new Recept(), null);
        return so.getRecepti();
    }

    public List<StavkaRecepta> ucitajStavke(int i) throws Exception {
        System.out.println("Controller - ucitajStavke");

        UcitajStavkeSO so = new UcitajStavkeSO();
        so.izvrsi(i, null);
        return so.getStavke();
    }
    
    public void dodajPredskolskoDete(PredskolskoDete predskolskoDete) throws Exception {
        System.out.println("Controller - DodajPredskolskoDeteSO");

        DodajPredskolskoDeteSO so = new DodajPredskolskoDeteSO();
        so.izvrsi(predskolskoDete, null);
    }

    public void izmeniPredskolskoDete(PredskolskoDete predskolskoDete) throws Exception {
        System.out.println("Controller - izmeniPredskolskoDete");
        IzmeniPredskolskoDeteSO so = new IzmeniPredskolskoDeteSO();
        so.izvrsi(predskolskoDete, null);
    }
    
    public void dodajSkolskoDete(SkolskoDete skolskoDete) throws Exception {
        System.out.println("Controller - DodajPredskolskoDeteSO");

        DodajSkolskoDeteSO so = new DodajSkolskoDeteSO();
        so.izvrsi(skolskoDete, null);
    }

    public void izmeniSkolskoDete(SkolskoDete skolskoDete) throws Exception {
        System.out.println("Controller - izmeniSkolskoDete");
        IzmeniSkolskoDeteSO so = new IzmeniSkolskoDeteSO();
        so.izvrsi(skolskoDete, null);
    }
}
