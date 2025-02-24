/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operations.recept;

import domain.Recept;
import domain.StavkaRecepta;
import java.util.List;
import operations.AbstractGenericOperation;

/**
 *
 * @author ognje
 */
public class UcitajStavkeSO extends AbstractGenericOperation {
    private List<StavkaRecepta> stavke;
    
    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        String uslov = " JOIN lek ON stavkarecepta.idLek = lek.idLek JOIN recept ON stavkarecepta.idRecept = recept.idRecept "
                + "JOIN doktor ON recept.idDoktor = doktor.idDoktor JOIN dete ON recept.idDete = dete.idDete WHERE recept.idRecept="+(int)param;
        
        stavke = broker.getAll(new StavkaRecepta(), uslov);
        
    }

    public List<StavkaRecepta> getStavke() {
        return stavke;
    }
    
    
    
}
