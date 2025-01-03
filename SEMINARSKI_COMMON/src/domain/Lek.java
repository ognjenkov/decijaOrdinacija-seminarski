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
public class Lek implements AbstractDomainObject {

    private int idLek;
    private String naziv;
    private String proizvodjac;
    private String aktivniSastojak;
    private String farmaceutskaGrupa;

    public Lek() {
    }

    public Lek(int idLek, String naziv, String proizvodjac, String aktivniSastojak, String farmaceutskaGrupa) {
        this.idLek = idLek;
        this.naziv = naziv;
        this.proizvodjac = proizvodjac;
        this.aktivniSastojak = aktivniSastojak;
        this.farmaceutskaGrupa = farmaceutskaGrupa;
    }

    public int getIdLek() {
        return idLek;
    }

    public void setIdLek(int idLek) {
        this.idLek = idLek;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public String getAktivniSastojak() {
        return aktivniSastojak;
    }

    public void setAktivniSastojak(String aktivniSastojak) {
        this.aktivniSastojak = aktivniSastojak;
    }

    public String getFarmaceutskaGrupa() {
        return farmaceutskaGrupa;
    }

    public void setFarmaceutskaGrupa(String farmaceutskaGrupa) {
        this.farmaceutskaGrupa = farmaceutskaGrupa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lek other = (Lek) obj;
        return this.idLek == other.idLek;
    }

    @Override
    public String toString() {
        return "Lek{" + "naziv=" + naziv + ", proizvodjac=" + proizvodjac + ", aktivniSastojak=" + aktivniSastojak + ", farmaceutskaGrupa=" + farmaceutskaGrupa + '}';
    }

    @Override
    public String returnTableName() {
        return "lek";
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv, proizvodjac, aktivniSastojak, farmaceutskaGrupa";
    }

    @Override
    public AbstractDomainObject returnObjectFromRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            return new Lek(
                    rs.getInt("lek.idLek"),
                    rs.getString("lek.naziv"),
                    rs.getString("lek.proizvodjac"),
                    rs.getString("lek.aktivniSastojak"),
                    rs.getString("lek.farmaceutskaGrupa")
            );
        }
        return null;
    }

    @Override
    public List<AbstractDomainObject> returnListFromRS(ResultSet rs) throws Exception {
        List<AbstractDomainObject> lekovi = new ArrayList<>();
        while (rs.next()) {
            Lek lek = new Lek(
                    rs.getInt("lek.idLek"),
                    rs.getString("lek.naziv"),
                    rs.getString("lek.proizvodjac"),
                    rs.getString("lek.aktivniSastojak"),
                    rs.getString("lek.farmaceutskaGrupa")
            );
            lekovi.add(lek);
        }
        return lekovi;
    }

    @Override
    public String vratiVrednostZaUbacivanje() {
        return "'" + naziv + "', '" + proizvodjac + "', '" + aktivniSastojak + "', '" + farmaceutskaGrupa + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "lek.idLek = " + idLek;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv = '" + naziv + "', proizvodjac = '" + proizvodjac
                + "', aktivniSastojak = '" + aktivniSastojak
                + "', farmaceutskaGrupa = '" + farmaceutskaGrupa + "'";
    }
}
