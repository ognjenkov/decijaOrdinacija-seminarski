/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operations.recept;

import domain.Recept;
import operations.AbstractGenericOperation;

/**
 *
 * @author ognje
 */
public class ObrisiReceptSO  extends AbstractGenericOperation  {
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param == null || !(param instanceof Recept)) {
            throw new Exception("Sistem nije mogao da obrise recept");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.delete((Recept) param);

    }
}
