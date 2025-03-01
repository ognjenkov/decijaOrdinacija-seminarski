/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Dete;
import domain.Doktor;
import domain.Lek;
import domain.PredskolskoDete;
import domain.Recept;
import domain.SkolskoDete;
import domain.StavkaRecepta;
import java.util.ArrayList;
import java.util.List;
import niti.ObradaKlijentskihZahteva;
import operations.dete.DodajDeteSO;
import operations.dete.IzmeniDeteSO;
import operations.dete.ObrisiDeteSO;
import operations.dete.UcitajDecuSO;
import operations.lek.UcitajLekoveSO;
import operations.login.LoginOperation;
import operations.recept.UcitajRecepteSO;
import operations.stavkarecepta.UcitajStavkeSO;
import operations.predskolskoDete.IzmeniPredskolskoDeteSO;
import operations.predskolskoDete.DodajPredskolskoDeteSO;
import operations.predskolskoDete.ObrisiPredskolskoDeteSO;
import operations.predskolskoDete.UcitajPredskolskuDecuSO;
import operations.recept.DodajReceptSO;
import operations.recept.ObrisiReceptSO;
import operations.skolskoDete.IzmeniSkolskoDeteSO;
import operations.skolskoDete.DodajSkolskoDeteSO;
import operations.skolskoDete.ObrisiSkolskoDeteSO;
import operations.skolskoDete.UcitajSkolskuDecuSO;
import operations.stavkarecepta.DodajStavkuReceptaSO;
import operations.stavkarecepta.ObrisiStavkuReceptaSO;

/**
 *
 * @author ognje
 */
public class Controller {

    private static Controller instance;
    private List<ObradaKlijentskihZahteva> users;

    private Controller() {
        users = new ArrayList<>();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public List<ObradaKlijentskihZahteva> getUsers() {
        return users;
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

    public List<SkolskoDete> ucitajSkolskuDecu() throws Exception {
        System.out.println("Controller - ucitajSkolskuDecu");

        UcitajSkolskuDecuSO so = new UcitajSkolskuDecuSO();
        so.izvrsi(new SkolskoDete(), null);
        return so.getSkolskaDeca();
    }

    public List<PredskolskoDete> ucitajPredskolskuDecu() throws Exception {
        System.out.println("Controller - ucitajPredskolskuDecu");

        UcitajPredskolskuDecuSO so = new UcitajPredskolskuDecuSO();
        so.izvrsi(new PredskolskoDete(), null);
        return so.getPredskolskaDeca();
    }

    public void obrisiPredskolskoDete(PredskolskoDete predskolskoDete) throws Exception {
        System.out.println("Controller - obrisiPredskolskoDete");

        ObrisiPredskolskoDeteSO obrisi = new ObrisiPredskolskoDeteSO();
        obrisi.izvrsi(predskolskoDete, null);
    }

    public void obrisiSkolskoDete(SkolskoDete skolskoDete) throws Exception {
        System.out.println("Controller - obrisiSkolskoDete");

        ObrisiSkolskoDeteSO obrisi = new ObrisiSkolskoDeteSO();
        obrisi.izvrsi(skolskoDete, null);
    }

    public List<Lek> ucitajLekove() throws Exception {
        System.out.println("Controller - ucitajLekove");

        UcitajLekoveSO so = new UcitajLekoveSO();
        so.izvrsi(new Lek(), null);
        return so.getLekovi();
    }

    public void dodajRecept(StavkaRecepta sr) throws Exception {
        System.out.println("Controller - dodajRecept");

        Recept recept = sr.getRecept();

        DodajReceptSO drso = new DodajReceptSO();
        drso.izvrsi(recept, null);
        int receptId = drso.getReceptId();
        sr.getRecept().setIdRecept(receptId);
        sr.setRb(1);

        DodajStavkuReceptaSO dsrso = new DodajStavkuReceptaSO();
        dsrso.izvrsi(sr, null);

    }

    public void obrisiRecept(Recept recept) throws Exception{
        System.out.println("Controller - obrisiRecept");

        ObrisiReceptSO so = new ObrisiReceptSO();
        so.izvrsi(recept, null);
    }

    public void obrisiStavkuRecepta(StavkaRecepta stavkaRecepta) throws Exception {
        System.out.println("Controller - obrisiStavkuRecepta");

        ObrisiStavkuReceptaSO so = new ObrisiStavkuReceptaSO();
        so.izvrsi(stavkaRecepta, null);
    }

    public void dodajStavkuRecepta(StavkaRecepta sr) throws Exception{
        System.out.println("Controller - dodajStavkuRecepta");
        int idRecept = sr.getRecept().getIdRecept();
        
        UcitajStavkeSO so = new UcitajStavkeSO();
        so.izvrsi(idRecept, null);
        List<StavkaRecepta> stavkeRecepta = so.getStavke();
        
        int posledjiRb = stavkeRecepta.size();
        
        sr.setRb(posledjiRb + 1);
        
        DodajStavkuReceptaSO dsrso = new DodajStavkuReceptaSO();
        dsrso.izvrsi(sr, null);
    }
}
