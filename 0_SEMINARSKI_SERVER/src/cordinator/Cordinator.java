/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cordinator;

import forms.DodajDoktoraForm;
import forms.DodajLekForm;
import forms.FormMode;
import forms.PrikazDoktoraForm;
import forms.PrikazLekovaForm;
import forms.PrikazSpecijalizacijaForm;
import forms.controllers.DodajDoktoraController;
import forms.controllers.DodajLekController;
import forms.controllers.PrikazDoktoraController;
import forms.controllers.PrikazLekovaController;
import forms.controllers.PrikazSpecijalizacijaController;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ognje
 */
public class Cordinator {
    private static Cordinator instance;
    private Map<String, Object> parametri;

    private PrikazLekovaController prikazLekovaController;
    private PrikazDoktoraController prikazDoktoraController;
    private DodajLekController dodajLekController;
    private DodajDoktoraController dodajDoktoraController;
    private PrikazSpecijalizacijaController prikazSpecijalizacijaController; 

    private Cordinator() {
        parametri = new HashMap<>();
    }
    public static Cordinator getInstance() {
        if(instance == null) instance = new Cordinator();
        return instance;
    }
    public void dodajParam(String s, Object o) {
        parametri.put(s, o);
    }
    public Object vratiParam(String s) {
        return parametri.get(s);
    }
    
    public void otvoriPrikazLekovaForm () {
        prikazLekovaController = new PrikazLekovaController(new PrikazLekovaForm());
        prikazLekovaController.otvoriFormu();
    }
    public void osveziPrikazLekovaForm() {
        if(prikazLekovaController != null)
            prikazLekovaController.pripremiFormu();
        
    }
    
    public void otvoriPrikazDoktoraForm () {
        prikazDoktoraController = new PrikazDoktoraController(new PrikazDoktoraForm());
        prikazDoktoraController.otvoriFormu();
    }
    public void osveziPrikazDoktoraForm() {
        if(prikazDoktoraController != null)
            prikazDoktoraController.pripremiFormu();
    }
    
    public void otvoriDodajDoktoraForm() {
        dodajDoktoraController = new DodajDoktoraController(new DodajDoktoraForm());
        dodajDoktoraController.otvoriFormu(FormMode.DODAJ);
    }
    public void otvoriIzmeniDoktoraForm() {
        dodajDoktoraController = new DodajDoktoraController(new DodajDoktoraForm());
        dodajDoktoraController.otvoriFormu(FormMode.IZMENI);
    }
    
    public void otvoriDodajLekFormu() {
        dodajLekController = new DodajLekController(new DodajLekForm());
        dodajLekController.otvoriFormu(FormMode.DODAJ);
    }
    
    public void otvoriIzmeniLekFormu() {
        dodajLekController = new DodajLekController(new DodajLekForm());
        dodajLekController.otvoriFormu(FormMode.IZMENI);
    }
    
    public void otvoriPrikazSpecijalizacijeForm() {
        prikazSpecijalizacijaController = new PrikazSpecijalizacijaController(new PrikazSpecijalizacijaForm());
        prikazSpecijalizacijaController.otvoriFormu();
    }
}
