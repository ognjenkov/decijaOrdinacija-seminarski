/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operations.login;

import domain.Doktor;
import java.util.List;
import operations.AbstractGenericOperation;

/**
 *
 * @author ognje
 */
public class LoginOperation extends AbstractGenericOperation {

    private Doktor doktor;

    public Doktor getDoktor() {
        return doktor;
    }

    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param == null || !(param instanceof Doktor)) {
            throw new Exception("Sistem nije mogao da uloguje doktora");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        List<Doktor> sviDoktori = broker.getAll((Doktor) param, null);
        System.out.println("KLASA loginOperacija" + sviDoktori);

        if (sviDoktori.contains((Doktor) param)) {
            System.out.println("TRUE");
            for (Doktor doktor1 : sviDoktori) {
                if (doktor1.equals((Doktor) param)) {
                    doktor = doktor1;
                    return;
                }
            }
        }

        doktor = null;
    }

}
