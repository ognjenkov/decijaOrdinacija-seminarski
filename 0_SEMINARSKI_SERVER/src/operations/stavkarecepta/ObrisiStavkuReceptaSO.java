/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operations.stavkarecepta;

import domain.StavkaRecepta;
import operations.AbstractGenericOperation;

/**
 *
 * @author ognje
 */
public class ObrisiStavkuReceptaSO extends AbstractGenericOperation{
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param == null || !(param instanceof StavkaRecepta)) {
            throw new Exception("Sistem nije mogao da obrise stavku");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.delete((StavkaRecepta) param);

    }
}
