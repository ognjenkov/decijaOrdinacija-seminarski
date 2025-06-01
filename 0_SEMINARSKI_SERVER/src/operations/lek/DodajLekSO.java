/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operations.lek;

import operations.AbstractGenericOperation;
import domain.Lek;

/**
 *
 * @author ognje
 */
public class DodajLekSO extends AbstractGenericOperation {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Lek)) {
            throw new Exception("Sistem nije mogao da doda lek #1");
        }
        Lek lek = (Lek) param;
        if (lek.getNaziv() == null
                || lek.getProizvodjac() == null
                || lek.getInn() == null
                || lek.getAtcKlasifikacija() == null
                || lek.getFarmakoloskaHemijskaPodgrupa() == null
                || lek.getFarmaceutskiOblik() == null
                || lek.getSadrzajAktivneSupstance() == null
                || lek.getPakovanje() == null
                || lek.getTerapijskaGrupa() == null) {
            throw new Exception("Sistem nije mogao da doda lek #2");
        }
        if (lek.getNaziv().length() > 50
                || lek.getProizvodjac().length() > 50
                || lek.getInn().length() > 50
                || lek.getAtcKlasifikacija().length() > 50
                || lek.getFarmakoloskaHemijskaPodgrupa().length() > 50
                || lek.getFarmaceutskiOblik().length() > 50
                || lek.getSadrzajAktivneSupstance().length() > 50
                || lek.getPakovanje().length() > 50
                || lek.getTerapijskaGrupa().length() > 50) {
            throw new Exception("Sistem nije mogao da doda lek #3");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        System.out.println("SO");
        broker.add((Lek) param);
    }

}
