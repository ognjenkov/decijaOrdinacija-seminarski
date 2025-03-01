/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operations.drsp;

import domain.DrSp;
import java.util.List;
import operations.AbstractGenericOperation;

/**
 *
 * @author ognje
 */
public class UcitajDRSPSO extends AbstractGenericOperation {

    List<DrSp> drsp;

    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        drsp = broker.getAll(new DrSp(), " JOIN doktor on doktor.idDoktor = drsp.idDoktor join specijalizacija on specijalizacija.idSpecijalizacija = drsp.idSpecijalizacija");

    }

    public List<DrSp> getDrsp() {
        return drsp;
    }

}
