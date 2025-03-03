/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operations.recept;

import domain.Recept;
import java.util.List;
import operations.AbstractGenericOperation;

/**
 *
 * @author ognje
 */
public class UcitajRecepteSO extends AbstractGenericOperation {
    private List<Recept> recepti;

    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        String uslov = " JOIN doktor ON recept.idDoktor = doktor.idDoktor JOIN dete ON recept.idDete = dete.idDete";
        recepti = broker.getAll(new Recept(), uslov);
        
    }

    public List<Recept> getRecepti() {
        return recepti;
    }
    
    
    
}
