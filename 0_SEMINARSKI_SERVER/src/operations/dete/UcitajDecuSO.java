/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operations.dete;

import domain.Dete;
import java.util.List;
import operations.AbstractGenericOperation;

/**
 *
 * @author ognje
 */
public class UcitajDecuSO extends AbstractGenericOperation {
    private List<Dete> deca;
    
    @Override
    protected void preduslovi(Object param) throws Exception {
        
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        deca = broker.getAll(param, kljuc);
    }

    public List<Dete> getDeca() {
        return deca;
    }
    
}
