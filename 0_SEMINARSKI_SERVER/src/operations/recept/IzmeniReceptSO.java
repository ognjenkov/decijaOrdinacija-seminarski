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

        List<StavkaRecepta> stavke = recept.getStavke();
        for (StavkaRecepta stavka : stavke) {
            if (stavka == null || !(stavka instanceof StavkaRecepta)) {
                throw new Exception("Sistem nije mogao da doda Stavku #1");
            }
            if (stavka.getLek() == null || stavka.getTerapija() == null || stavka.getZakljucak() == null) {
                throw new Exception("Sistem nije mogao da doda Stavku #2");
            }
            if (stavka.getLek().getIdLek() < 1) {
                throw new Exception("Sistem nije mogao da doda Stavku #3");
            }
        }

    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.edit((Recept) param);
        Recept recept = (Recept) param;
        List<StavkaRecepta> stavke = recept.getStavke();

        int maxRb = stavke.stream()
                .mapToInt(o -> o.getRb())
                .max()
                .orElse(0);
        if (maxRb == -1) {
            maxRb = 1;
        } else {
            maxRb ++;
        }
        for (StavkaRecepta stavka : stavke) {
            if (stavka.getRb() == -1) {
                stavka.setRb(maxRb);
                broker.add((StavkaRecepta) stavka);

            }
        }
    }

}
