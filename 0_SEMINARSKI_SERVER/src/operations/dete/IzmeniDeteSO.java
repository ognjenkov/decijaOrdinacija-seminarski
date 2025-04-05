/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operations.dete;

import domain.Dete;
import operations.AbstractGenericOperation;

/**
 *
 * @author ognje
 */
public class IzmeniDeteSO extends AbstractGenericOperation {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Dete)) {
            throw new Exception("Sistem nije mogao da izmeni dete #1");
        }
        Dete dete = (Dete) param;
        if (dete.getIme() == null || dete.getPrezime() == null || dete.getDatumRodjenja() == null) {
            throw new Exception("Sistem nije mogao da izmeni dete #2");
        }
        if (dete.getIme().length() > 50 || dete.getPrezime().length() > 50) {
            throw new Exception("Sistem nije mogao da izmeni dete #3");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        System.out.println("SO");
        broker.edit((Dete) param);
    }

}
