/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operations.doktor;

import domain.Doktor;
import operations.AbstractGenericOperation;

/**
 *
 * @author ognje
 */
public class DodajDoktoraSO extends AbstractGenericOperation {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Doktor)) {
            throw new Exception("Sistem nije mogao da doda doktora #1");
        }
        Doktor doktor = (Doktor) param;
        if (doktor.getIme() == null || doktor.getPrezime() == null || doktor.getEmail() == null || !doktor.getEmail().contains("@")) {
            throw new Exception("Sistem nije mogao da doda doktora #2");
        }
        if (doktor.getIme().length() > 50 || doktor.getPrezime().length() > 50 || doktor.getEmail().length() > 50) {
            throw new Exception("Sistem nije mogao da doda doktora #3");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.add((Doktor) param);

    }

}
