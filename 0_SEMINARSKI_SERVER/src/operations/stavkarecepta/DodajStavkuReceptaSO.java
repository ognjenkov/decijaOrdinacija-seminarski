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
public class DodajStavkuReceptaSO extends AbstractGenericOperation {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof StavkaRecepta)) {
            throw new Exception("Sistem nije mogao da doda Stavku #1");
        }
        StavkaRecepta stavka = (StavkaRecepta) param;
        if (stavka.getRecept() == null || stavka.getLek() == null || stavka.getTerapija() == null || stavka.getZakljucak() == null) {
            throw new Exception("Sistem nije mogao da doda Stavku #2");
        }
        if (stavka.getRecept().getIdRecept() < 1 || stavka.getLek().getIdLek() < 1 || stavka.getRb() < 1) {
            throw new Exception("Sistem nije mogao da doda Stavku #3");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        System.out.println("SO");
        broker.add((StavkaRecepta) param);
    }

}
