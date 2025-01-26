/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operations;

import repository.Repository;
import repository.db.DbRepository;
import repository.db.impl.DbRepositoryGeneric;

/**
 *
 * @author ognje
 */
public abstract class AbstractGenericOperation {

    protected final Repository broker;

    public AbstractGenericOperation() {
        this.broker = new DbRepositoryGeneric();
    }

    public final void izvrsi(Object objekat, String kljuc) throws Exception {
        System.out.println("izvrsiti");
        try {
            preduslovi(objekat);
            zapocniTransakciju();
            izvrsiOperaciju(objekat, kljuc);
            potvrdiTransakciju();
        } catch (Exception e) {
            ponistiTransakciju();
            throw e;
        } finally {
//            ugasiKonekciju();
// TODO ugasi konekciju kada se izloguje ili nesto tako
        }
    }

    protected abstract void preduslovi(Object param) throws Exception;

    protected abstract void izvrsiOperaciju(Object param, String kljuc) throws Exception;

    private void zapocniTransakciju() throws Exception {
        ((DbRepository) broker).connect();
    }

    private void potvrdiTransakciju() throws Exception {
        ((DbRepository) broker).commit();
    }

    private void ponistiTransakciju() throws Exception {
        ((DbRepository) broker).rollback();
    }

    private void ugasiKonekciju() throws Exception {
        ((DbRepository) broker).disconnect();
    }
}
