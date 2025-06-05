/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operations.recept;

import domain.Recept;
import domain.StavkaRecepta;
import java.time.LocalDate;
import java.util.List;
import operations.AbstractGenericOperation;
import operations.stavkarecepta.DodajStavkuReceptaSO;

/**
 *
 * @author ognje
 */
public class DodajReceptSO extends AbstractGenericOperation {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Recept)) {
            throw new Exception("Sistem nije mogao da doda Recept #1");
        }
        Recept recept = (Recept) param;
        if (recept.getDete() == null || recept.getDoktor() == null) {
            throw new Exception("Sistem nije mogao da doda Recept #2");
        }
        if (recept.getDete().getIdDete() < 1 || recept.getDoktor().getIdDoktor() < 1) {
            throw new Exception("Sistem nije mogao da doda Recept #3");
        }

        List<StavkaRecepta> stavke = recept.getStavke();
        for (StavkaRecepta stavka : stavke) {
            if (stavka.getLek() == null || stavka.getTerapija() == null || stavka.getZakljucak() == null) {
                throw new Exception("Sistem nije mogao da doda Recept #4");
            }
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        System.out.println("SO");

        Recept recept = (Recept) param;

        List<StavkaRecepta> stavke = recept.getStavke();
        recept.setDatumIzdavanja(LocalDate.now());
        int receptId = broker.add((Recept) recept);
        recept.setIdRecept(receptId);
        recept.setStavke(null);
        int rb = 1;
        for (StavkaRecepta stavka : stavke) {
            stavka.setRecept(recept);
            stavka.setRb(rb);
            broker.add((StavkaRecepta) stavka);
            rb++;
        }
    }
}
