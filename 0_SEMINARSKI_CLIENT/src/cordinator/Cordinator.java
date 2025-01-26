/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cordinator;

import controllers.DodajDeteController;
import controllers.LoginController;
import controllers.MainController;
import controllers.PrikazDeceController;
import domain.Doktor;
import forms.DodajDeteForm;
import forms.LoginForm;
import forms.MainForm;
import forms.PrikazDeceForm;

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
    private Cordinator() {
        
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
        DodajDeteController ddc = new DodajDeteController(new DodajDeteForm());
        ddc.otvoriFormu();
    }


    
}
