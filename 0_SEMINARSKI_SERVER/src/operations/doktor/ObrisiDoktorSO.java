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
public class ObrisiDoktorSO extends AbstractGenericOperation  {
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param == null || !(param instanceof Doktor)) {
            throw new Exception("Sistem nije mogao da obrise doktora");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.delete((Doktor) param);

    }
    
}
