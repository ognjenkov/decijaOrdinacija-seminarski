/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ognje
 */
public class DrSp implements AbstractDomainObject {

    private Doktor doktor;
    private Specijalizacija specijalizacija;

    public DrSp() {
    }

    public DrSp(Doktor doktor, Specijalizacija specijalizacija) {
        this.doktor = doktor;
        this.specijalizacija = specijalizacija;
    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    public Specijalizacija getSpecijalizacija() {
        return specijalizacija;
    }

    public void setSpecijalizacija(Specijalizacija specijalizacija) {
        this.specijalizacija = specijalizacija;
    }

    @Override
    public String returnTableName() {
        return "drsp";
    }

    @Override
    public List<AbstractDomainObject> returnListFromRS(ResultSet rs) throws Exception {
        List<AbstractDomainObject> list = new ArrayList<>();

        while (rs.next()) {
            int idDoktor = rs.getInt("drsp.idDoktor");
            String imeDoktor = rs.getString("doktor.ime");
            String prezimeDoktor = rs.getString("doktor.prezime");
            String emailDoktor = rs.getString("doktor.email");

            int idSpecijalizacija = rs.getInt("drsp.idSpecijalizacija");
            String nazivSpecijalizacija = rs.getString("specijalizacija.naziv");

            Doktor doktor = new Doktor(idDoktor, imeDoktor, prezimeDoktor, emailDoktor, "");
            Specijalizacija specijalizacija = new Specijalizacija(idSpecijalizacija, nazivSpecijalizacija);

            DrSp drSp = new DrSp(doktor, specijalizacija);
            list.add(drSp);
        }

        return list;
    }

    @Override
    public AbstractDomainObject returnObjectFromRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            int idDoktor = rs.getInt("drsp.idDoktor");
            String imeDoktor = rs.getString("doktor.ime");
            String prezimeDoktor = rs.getString("doktor.prezime");
            String emailDoktor = rs.getString("doktor.email");

            int idSpecijalizacija = rs.getInt("drsp.idSpecijalizacija");
            String nazivSpecijalizacija = rs.getString("specijalizacija.naziv");

            Doktor doktor = new Doktor(idDoktor, imeDoktor, prezimeDoktor, emailDoktor, "");
            Specijalizacija specijalizacija = new Specijalizacija(idSpecijalizacija, nazivSpecijalizacija);

            return new DrSp(doktor, specijalizacija);
        }
        return null;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "idDoktor, idSpecijalizacija";
    }

    @Override
    public String vratiVrednostZaUbacivanje() {
        return doktor.getIdDoktor() + ", " + specijalizacija.getIdSpecijalizacija();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "drsp.idDoktor = " + doktor.getIdDoktor() + " AND drsp.idSpecijalizacija = " + specijalizacija.getIdSpecijalizacija();
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "idDoktor = " + doktor.getIdDoktor() + ", idSpecijalizacija = " + specijalizacija.getIdSpecijalizacija();
    }
}
