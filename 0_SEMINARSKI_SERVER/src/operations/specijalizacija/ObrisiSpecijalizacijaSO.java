/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operations.specijalizacija;

import domain.Specijalizacija;
import operations.AbstractGenericOperation;

/**
 *
 * @author ognje
 */
public class ObrisiSpecijalizacijaSO extends AbstractGenericOperation  {
   @Override
    protected void preduslovi(Object param) throws Exception {
        if(param == null || !(param instanceof Specijalizacija)) {
            throw new Exception("Sistem nije mogao da obrise specijalizaciju");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.delete((Specijalizacija) param);

    } 
}
