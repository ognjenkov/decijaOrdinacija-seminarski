/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operations.predskolskoDete;

import domain.PredskolskoDete;
import operations.AbstractGenericOperation;

/**
 *
 * @author ognje
 */
public class DodajPredskolskoDeteSO extends AbstractGenericOperation {

    @Override
    protected void preduslovi(Object param) throws Exception {
         if(param == null || !(param instanceof PredskolskoDete)) {
            throw new Exception("Sistem nije mogao da doda predskolsko dete #1");
        }
        PredskolskoDete dete = (PredskolskoDete) param;
        if(dete.getGrupa()== null || dete.getIdDete() < 0) { //TODO manje od nula ili od 1
            throw new Exception("Sistem nije mogao da doda predskolsko dete #2");
        }
        if(dete.getGrupa().length() > 50) {
            throw new Exception("Sistem nije mogao da doda predskolsko dete #3");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.add((PredskolskoDete) param);
    }
    
}
