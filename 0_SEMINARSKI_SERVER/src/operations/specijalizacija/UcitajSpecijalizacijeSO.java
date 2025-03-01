/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operations.specijalizacija;

import domain.Specijalizacija;
import java.util.List;
import operations.AbstractGenericOperation;

/**
 *
 * @author ognje
 */
public class UcitajSpecijalizacijeSO extends AbstractGenericOperation  {

    List<Specijalizacija> specijalizacije;
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        specijalizacije = broker.getAll(new Specijalizacija(), null);
    }

    public List<Specijalizacija> getSpecijalizacije() {
        return specijalizacije;
    }

 
}
