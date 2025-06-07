/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Dete;
import domain.Doktor;
import domain.DrSp;
import domain.Lek;
import domain.PredskolskoDete;
import domain.Recept;
import domain.SkolskoDete;
import domain.Specijalizacija;
import domain.StavkaRecepta;
import java.util.ArrayList;
import java.util.List;
import niti.ObradaKlijentskihZahteva;
import operations.dete.DodajDeteSO;
import operations.dete.IzmeniDeteSO;
import operations.dete.ObrisiDeteSO;
import operations.dete.UcitajDecuSO;
import operations.doktor.DodajDoktoraSO;
import operations.doktor.IzmeniDoktorSO;
import operations.doktor.ObrisiDoktorSO;
import operations.doktor.UcitajDoktoreSO;
import operations.drsp.DodajDRSPSO;
import operations.drsp.ObrisiDRSPSO;
import operations.drsp.UcitajDRSPSO;
import operations.lek.DodajLekSO;
import operations.lek.IzmeniLekSO;
import operations.lek.ObrisiLekSO;
import operations.lek.UcitajLekoveSO;
import operations.login.LoginOperation;
import operations.recept.UcitajRecepteSO;
import operations.stavkarecepta.UcitajStavkeSO;
import operations.predskolskoDete.IzmeniPredskolskoDeteSO;
import operations.predskolskoDete.DodajPredskolskoDeteSO;
import operations.predskolskoDete.ObrisiPredskolskoDeteSO;
import operations.predskolskoDete.UcitajPredskolskuDecuSO;
import operations.recept.DodajReceptSO;
import operations.recept.IzmeniReceptSO;
import operations.recept.ObrisiReceptSO;
import operations.skolskoDete.IzmeniSkolskoDeteSO;
import operations.skolskoDete.DodajSkolskoDeteSO;
import operations.skolskoDete.ObrisiSkolskoDeteSO;
import operations.skolskoDete.UcitajSkolskuDecuSO;
import operations.specijalizacija.DodajSpecijalizacijuSO;
import operations.specijalizacija.ObrisiSpecijalizacijaSO;
import operations.specijalizacija.UcitajSpecijalizacijeSO;
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

    public void dodajRecept(Recept recept) throws Exception {
        System.out.println("Controller - dodajRecept");

        DodajReceptSO drso = new DodajReceptSO();
        drso.izvrsi(recept, null);
    }
    
    public void izmeniRecept(Recept recept) throws Exception {
        System.out.println("Controller - izmeniRecept");
        
        IzmeniReceptSO so = new IzmeniReceptSO();
        so.izvrsi(recept, null);
    }

    public void obrisiRecept(Recept recept) throws Exception {
        System.out.println("Controller - obrisiRecept");

        ObrisiReceptSO so = new ObrisiReceptSO();
        so.izvrsi(recept, null);
    }

    public void obrisiStavkuRecepta(StavkaRecepta stavkaRecepta) throws Exception {
        System.out.println("Controller - obrisiStavkuRecepta");

        ObrisiStavkuReceptaSO so = new ObrisiStavkuReceptaSO();
        so.izvrsi(stavkaRecepta, null);
    }

    public void dodajStavkuRecepta(Recept recept) throws Exception {
        System.out.println("Controller - dodajStavkuRecepta");
        
        IzmeniReceptSO irso = new IzmeniReceptSO();
        irso.izvrsi(recept, null);
    }

    public void dodajSpecijalizaciju(Specijalizacija specijalizacija) throws Exception {
        System.out.println("Controller - dodajSpecijalizaciju");
        DodajSpecijalizacijuSO so = new DodajSpecijalizacijuSO();
        so.izvrsi(specijalizacija, null);
    }

    public void obrisiSpecijalizaciju(Specijalizacija specijalizacija) throws Exception {
        System.out.println("Controller - obrisiSpecijalizaciju");
        ObrisiSpecijalizacijaSO so = new ObrisiSpecijalizacijaSO();
        so.izvrsi(specijalizacija, null);
    }

    public List<Specijalizacija> ucitajSpecijalizacije() throws Exception {
        System.out.println("Controller - ucitajSpecijalizacije");

        UcitajSpecijalizacijeSO so = new UcitajSpecijalizacijeSO();
        so.izvrsi(new Specijalizacija(), null);
        return so.getSpecijalizacije();
    }

    public void obrisiLek(Lek lek) throws Exception {
        System.out.println("Controller - obrisiLek");

        ObrisiLekSO so = new ObrisiLekSO();
        so.izvrsi(lek, null);
    }

    public void obrisiDoktora(Doktor doktor) throws Exception {
        System.out.println("Controller - obrisiDoktora");

        ObrisiDoktorSO so = new ObrisiDoktorSO();
        so.izvrsi(doktor, null);
    }

    public void dodajDRSP(DrSp drsp) throws Exception {
        System.out.println("Controller - dodajDRSP");
        DodajDRSPSO so = new DodajDRSPSO();
        so.izvrsi(drsp, null);
    }

    public void obrisiDRSP(DrSp drsp) throws Exception {
        System.out.println("Controller - obrisiDRSP");
        ObrisiDRSPSO so = new ObrisiDRSPSO();
        so.izvrsi(drsp, null);
    }

    public List<DrSp> ucitajDRSP() throws Exception {
        System.out.println("Controller - ucitajDRSP");

        UcitajDRSPSO so = new UcitajDRSPSO();
        so.izvrsi(new DrSp(), null);

        return so.getDrsp();
    }

    public List<Doktor> ucitajDoktore() throws Exception {
        System.out.println("Controller - ucitajDoktore");

        UcitajDoktoreSO so = new UcitajDoktoreSO();
        so.izvrsi(new Doktor(), null);

        return so.getDoktori();
    }
    
    public void dodajLek(Lek lek) throws Exception {
        System.out.println("Controller - dodajLek");
        DodajLekSO so = new DodajLekSO();
        so.izvrsi(lek, null);
    }
    public void izmeniLek(Lek lek) throws Exception {
        System.out.println("Controller - izmeniLek");
        IzmeniLekSO so = new IzmeniLekSO();
        so.izvrsi(lek, null);
    }
    public void dodajDoktora(Doktor doktor) throws Exception {
        System.out.println("Controller - dodajDoktora");
        DodajDoktoraSO so = new DodajDoktoraSO();
        so.izvrsi(doktor, null);
    }
    public void izmeniDoktora(Doktor doktor) throws Exception {
        System.out.println("Controller - izmeniDoktora");
        IzmeniDoktorSO so = new IzmeniDoktorSO();
        so.izvrsi(doktor, null);
    }
    
}
