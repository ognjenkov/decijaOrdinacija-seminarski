/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operations.predskolskoDete;

import domain.PredskolskoDete;
import operations.AbstractGenericOperation;

/**
 *
 * @author ognje
 */
public class ObrisiPredskolskoDeteSO  extends AbstractGenericOperation {
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param == null || !(param instanceof PredskolskoDete)) {
            throw new Exception("Sistem nije mogao da obrise PredskolskoDete");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.delete((PredskolskoDete) param);

    }
    
}
