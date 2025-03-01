/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operations.drsp;

import domain.DrSp;
import operations.AbstractGenericOperation;

/**
 *
 * @author ognje
 */
public class ObrisiDRSPSO extends AbstractGenericOperation{
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param == null || !(param instanceof DrSp)) {
            throw new Exception("Sistem nije mogao da obrise DrSp");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.delete((DrSp) param);

    }
}
