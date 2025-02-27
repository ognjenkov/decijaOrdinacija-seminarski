/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operations.predskolskoDete;

import domain.PredskolskoDete;
import java.util.List;
import operations.AbstractGenericOperation;

/**
 *
 * @author ognje
 */
public class UcitajPredskolskuDecuSO extends AbstractGenericOperation {
    List<PredskolskoDete> predskolskaDeca;


    @Override
    protected void preduslovi(Object param) throws Exception {
        
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        predskolskaDeca = broker.getAll(new PredskolskoDete(), " JOIN dete on dete.idDete = predskolskodete.idDete");
    }

    public List<PredskolskoDete> getPredskolskaDeca() {
        return predskolskaDeca;
    }
    
    
    
}
