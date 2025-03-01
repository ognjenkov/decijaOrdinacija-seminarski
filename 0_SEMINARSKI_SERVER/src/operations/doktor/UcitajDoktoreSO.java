/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operations.doktor;

import domain.Doktor;
import java.util.List;
import operations.AbstractGenericOperation;

/**
 *
 * @author ognje
 */
public class UcitajDoktoreSO extends AbstractGenericOperation {
    List<Doktor> doktori;

    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        doktori = broker.getAll(new Doktor(), null);
    }

    public List<Doktor> getDoktori() {
        return doktori;
    }
    
    
    
    
}
