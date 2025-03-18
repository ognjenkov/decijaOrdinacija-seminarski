/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operations.recept;

import domain.Recept;
import operations.AbstractGenericOperation;

/**
 *
 * @author ognje
 */
public class IzmeniReceptSO extends AbstractGenericOperation {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Recept)) {
            throw new Exception("Sistem nije mogao da doda Recept #1");
        }
        Recept recept = (Recept) param;
        if (recept.getDete() == null || recept.getDoktor() == null || recept.getDijagnoza() == null) {
            throw new Exception("Sistem nije mogao da doda Recept #2");
        }
        if (recept.getDete().getIdDete() < 1 || recept.getDoktor().getIdDoktor() < 1 || recept.getDijagnoza().length() > 50) {
            throw new Exception("Sistem nije mogao da doda Recept #3");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.edit((Recept) param);

    }

}
