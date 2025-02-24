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
public class IzmeniSkolskoDeteSO extends AbstractGenericOperation {
    @Override
    protected void preduslovi(Object param) throws Exception {
         if(param == null || !(param instanceof SkolskoDete)) {
            throw new Exception("Sistem nije mogao da izmeni SkolskoDete #1");
        }
        SkolskoDete dete = (SkolskoDete) param;
        if(dete.getOdeljenje()== null || dete.getRazred()== null || dete.getIdDete() < 0) { //TODO manje od nula ili od 1
            throw new Exception("Sistem nije mogao da izmeniSkolskoDete dete #2");
        }
        if(dete.getOdeljenje().length() > 50 || dete.getOdeljenje().length() > 50 ) {
            throw new Exception("Sistem nije mogao da izmeni SkolskoDete dete #3");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.edit((SkolskoDete) param);
    }
}
