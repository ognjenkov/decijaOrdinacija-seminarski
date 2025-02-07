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
public class ObrisiLekSO  extends AbstractGenericOperation {
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param == null || !(param instanceof Lek)) {
            throw new Exception("Sistem nije mogao da obrise lek");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.delete((Lek) param);

    }
}
