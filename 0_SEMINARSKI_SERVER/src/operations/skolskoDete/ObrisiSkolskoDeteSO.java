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
public class ObrisiSkolskoDeteSO  extends AbstractGenericOperation  {
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param == null || !(param instanceof SkolskoDete)) {
            throw new Exception("Sistem nije mogao da obrise skolsko dete");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.delete((SkolskoDete) param);

    }
    
}
