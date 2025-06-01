/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operations.specijalizacija;

import domain.Specijalizacija;
import operations.AbstractGenericOperation;

/**
 *
 * @author ognje
 */
public class DodajSpecijalizacijuSO extends AbstractGenericOperation{
@Override
    protected void preduslovi(Object param) throws Exception {
         if(param == null || !(param instanceof Specijalizacija)) {
            throw new Exception("Sistem nije mogao da doda specijalizaciju #1");
        }
        Specijalizacija Specijalizacija = (Specijalizacija) param;
        if(Specijalizacija.getNaziv()== null || Specijalizacija.getNaziv().length() == 0) {
            throw new Exception("Sistem nije mogao da doda specijalizaciju #2");
        }
        if(Specijalizacija.getNaziv().length() > 50) {
            throw new Exception("Sistem nije mogao da doda specijalizaciju #3");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        System.out.println("izvrsiOperaciju");
        broker.add((Specijalizacija) param);
    }
    
    
}
