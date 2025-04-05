/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operations.skolskoDete;

import domain.SkolskoDete;
import operations.AbstractGenericOperation;

/**
 *
 * @author ognje
 */
public class DodajSkolskoDeteSO extends AbstractGenericOperation {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof SkolskoDete)) {
            throw new Exception("Sistem nije mogao da doda SkolskoDete #1");
        }
        SkolskoDete dete = (SkolskoDete) param;
        if (dete.getOdeljenje() == null || dete.getRazred() == null || dete.getIdDete() < 0) { //TODO manje od nula ili od 1
            throw new Exception("Sistem nije mogao da doda SkolskoDete dete #2");
        }
        if (dete.getOdeljenje().length() > 50 || dete.getOdeljenje().length() > 50) {
            throw new Exception("Sistem nije mogao da doda SkolskoDete dete #3");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        System.out.println("SO");
        broker.add((SkolskoDete) param);
    }
}
