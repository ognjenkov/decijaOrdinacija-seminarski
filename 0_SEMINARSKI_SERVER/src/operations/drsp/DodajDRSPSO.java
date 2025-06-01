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
public class DodajDRSPSO extends AbstractGenericOperation {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof DrSp)) {
            throw new Exception("Sistem nije mogao da doda drsp #1");
        }
        DrSp drsp = (DrSp) param;
        if (drsp.getDoktor() == null || drsp.getSpecijalizacija() == null) {
            throw new Exception("Sistem nije mogao da doda drsp #2");
        }
        if (drsp.getSpecijalizacija().getIdSpecijalizacija() < 1 || drsp.getDoktor().getIdDoktor() < 1) {
            throw new Exception("Sistem nije mogao da doda drsp #3");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        System.out.println("SO");
        broker.add((DrSp) param);
    }

}
