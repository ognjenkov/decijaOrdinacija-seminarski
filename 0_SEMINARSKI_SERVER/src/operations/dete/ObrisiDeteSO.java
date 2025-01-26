package operations.dete;

import domain.Dete;
import operations.AbstractGenericOperation;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ognje
 */
public class ObrisiDeteSO extends AbstractGenericOperation {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param == null || !(param instanceof Dete)) {
            throw new Exception("Sistem nije mogao da obrise dete");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.delete((Dete) param);

    }
    
}
