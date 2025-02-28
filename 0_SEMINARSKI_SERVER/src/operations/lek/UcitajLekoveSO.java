/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operations.lek;

import domain.Lek;
import java.util.List;
import operations.AbstractGenericOperation;

/**
 *
 * @author ognje
 */
public class UcitajLekoveSO extends AbstractGenericOperation {
    List<Lek> lekovi;
    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        lekovi = broker.getAll(new Lek(), null);
    }

    public List<Lek> getLekovi() {
        return lekovi;
    }
    
    
}
