/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operations.skolskoDete;

import domain.SkolskoDete;
import java.util.List;
import operations.AbstractGenericOperation;

/**
 *
 * @author ognje
 */
public class UcitajSkolskuDecuSO extends AbstractGenericOperation{
    List<SkolskoDete> skolskaDeca;
    
    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
       skolskaDeca = broker.getAll(new SkolskoDete(), " JOIN dete on dete.idDete = skolskodete.idDete");
    }

    public List<SkolskoDete> getSkolskaDeca() {
        return skolskaDeca;
    }
}
