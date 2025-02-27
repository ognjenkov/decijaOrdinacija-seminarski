/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cordinator;

import controllers.DodajDeteController;
import controllers.DodajPredskolskoDeteController;
import controllers.DodajSkolskoDeteController;
import controllers.LoginController;
import controllers.MainController;
import controllers.PrikazDeceController;
import controllers.PrikazObrazovanjaController;
import controllers.PrikazReceptaController;
import domain.Doktor;
import forms.DodajDeteForm;
import forms.DodajPredskolskoDeteForm;
import forms.DodajSkolskoDeteForm;
import forms.FormMode;
import forms.LoginForm;
import forms.MainForm;
import forms.PrikazDeceForm;
import forms.PrikazObrazovanjaForm;
import forms.PrikazReceptaForm;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ognje
 */
public class Cordinator {
    private static Cordinator instance;
    private Doktor ulogovani;
    private LoginController loginController;
    private MainController mainController;
    private PrikazDeceController prikazDeceController;
    private DodajDeteController dodajDeteController;
    private PrikazReceptaController prikazReceptaController;
    private DodajSkolskoDeteController dodajSkolskoDeteController;
    private DodajPredskolskoDeteController dodajPredskolskoDeteController;
    private PrikazObrazovanjaController prikazObrazovanjaController;

    private Map<String, Object> parametri;
    
    private Cordinator() {
        parametri = new HashMap<>();
    }
    public static Cordinator getInstance() {
        if(instance == null) instance = new Cordinator();
        return instance;
    }

    public void otvoriLoginFormu() {
        loginController = new LoginController(new LoginForm());
        loginController.otvoriFormu();
    }

    public void openMainForm() {
        mainController = new MainController(new MainForm());
        mainController.otvoriFormu();
    }
    
    public void openPrikazDeceForm() {
        prikazDeceController = new PrikazDeceController(new PrikazDeceForm());
        prikazDeceController.otvoriFormu();
    }

    public Doktor getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(Doktor ulogovani) {
        this.ulogovani = ulogovani;
    }

    public void openDodajDeteForm() {
        dodajDeteController = new DodajDeteController(new DodajDeteForm());
        dodajDeteController.otvoriFormu(FormMode.DODAJ);
    }


    public void dodajParam(String s, Object o) {
        parametri.put(s, o);
    }
    public Object vratiParam(String s) {
        return parametri.get(s);
    }

    public void openIzmeniDeteFormu() {
        dodajDeteController = new DodajDeteController(new DodajDeteForm());
        dodajDeteController.otvoriFormu(FormMode.IZMENI);
    }

    public void osveziFormuPrikazDece() {
        prikazDeceController.pripremiFormu();
    }
    public void openPrikaziRacuneForm() {
        prikazReceptaController = new PrikazReceptaController(new PrikazReceptaForm());
        prikazReceptaController.otvoriFormu();
    }
    
    public void openDodajSkolskoDeteForm(){
        dodajSkolskoDeteController = new DodajSkolskoDeteController(new DodajSkolskoDeteForm());
        dodajSkolskoDeteController.otvoriFormu(FormMode.DODAJ);
    }
    public void openIzmeniSkolskoDeteForm(){
        dodajSkolskoDeteController = new DodajSkolskoDeteController(new DodajSkolskoDeteForm());
        dodajSkolskoDeteController.otvoriFormu(FormMode.IZMENI);
    }
    public void openDodajPredskolskoDeteForm(){
        dodajPredskolskoDeteController = new DodajPredskolskoDeteController(new DodajPredskolskoDeteForm());
        dodajPredskolskoDeteController.otvoriFormu(FormMode.DODAJ);
    }
    public void openIzmeniPredskolskoDeteForm(){
        dodajPredskolskoDeteController = new DodajPredskolskoDeteController(new DodajPredskolskoDeteForm());
        dodajPredskolskoDeteController.otvoriFormu(FormMode.IZMENI);
    }
    
    public void openPrikazObrazovanjaForm() {
        prikazObrazovanjaController = new PrikazObrazovanjaController(new PrikazObrazovanjaForm());
        prikazObrazovanjaController.otvoriFormu();
    }
    public void osveziFormuPrikazObrazovanja() {
        prikazObrazovanjaController.pripremiFormu();
    }
}
