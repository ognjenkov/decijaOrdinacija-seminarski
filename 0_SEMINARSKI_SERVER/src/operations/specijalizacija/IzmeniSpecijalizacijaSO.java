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
public class IzmeniSpecijalizacijaSO extends AbstractGenericOperation {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Specijalizacija)) {
            throw new Exception("Sistem nije mogao da izmeni specijalizaciju #1");
        }
        Specijalizacija Specijalizacija = (Specijalizacija) param;
        if (Specijalizacija.getNaziv() == null) {
            throw new Exception("Sistem nije mogao da izmeni specijalizaciju #2");
        }
        if (Specijalizacija.getNaziv().length() > 50) {
            throw new Exception("Sistem nije mogao da izmeni specijalizaciju #3");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.edit((Specijalizacija) param);
    }
}
