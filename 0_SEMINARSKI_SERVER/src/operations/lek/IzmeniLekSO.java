/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operations.lek;

import domain.Lek;
import operations.AbstractGenericOperation;

/**
 *
 * @author ognje
 */
public class IzmeniLekSO extends AbstractGenericOperation {
    @Override
    protected void preduslovi(Object param) throws Exception {
         if(param == null || !(param instanceof Lek)) {
            throw new Exception("Sistem nije mogao da izmeni lek #1");
        }
        Lek lek = (Lek) param;
        if(lek.getNaziv()== null || lek.getProizvodjac() == null || lek.getAktivniSastojak() == null
                || lek.getFarmaceutskaGrupa() == null) {
            throw new Exception("Sistem nije mogao da izmeni lek #2");
        }
        if(lek.getNaziv().length() > 50 || lek.getProizvodjac().length() > 50 || lek.getAktivniSastojak().length() > 50 || lek.getFarmaceutskaGrupa().length() > 50) {
            throw new Exception("Sistem nije mogao da izmeni lek #3");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.edit((Lek) param);
    }
}
