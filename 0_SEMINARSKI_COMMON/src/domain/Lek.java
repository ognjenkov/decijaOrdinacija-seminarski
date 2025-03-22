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
    private String inn;
    private String atcKlasifikacija;
    private String farmakoloskaHemijskaPodgrupa;
    private String farmaceutskiOblik;
    private String sadrzajAktivneSupstance;
    private String pakovanje;
    private String terapijskaGrupa;

    public Lek() {
    }

    public Lek(int idLek, String naziv, String proizvodjac, String inn, String atcKlasifikacija, String farmakoloskaHemijskaPodgrupa, String farmaceutskiOblik, String sadrzajAktivneSupstance, String pakovanje, String terapijskaGrupa) {
        this.idLek = idLek;
        this.naziv = naziv;
        this.proizvodjac = proizvodjac;
        this.inn = inn;
        this.atcKlasifikacija = atcKlasifikacija;
        this.farmakoloskaHemijskaPodgrupa = farmakoloskaHemijskaPodgrupa;
        this.farmaceutskiOblik = farmaceutskiOblik;
        this.sadrzajAktivneSupstance = sadrzajAktivneSupstance;
        this.pakovanje = pakovanje;
        this.terapijskaGrupa = terapijskaGrupa;

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

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getAtcKlasifikacija() {
        return atcKlasifikacija;
    }

    public void setAtcKlasifikacija(String atcKlasifikacija) {
        this.atcKlasifikacija = atcKlasifikacija;
    }

    public String getFarmakoloskaHemijskaPodgrupa() {
        return farmakoloskaHemijskaPodgrupa;
    }

    public void setFarmakoloskaHemijskaPodgrupa(String farmakoloskaHemijskaPodgrupa) {
        this.farmakoloskaHemijskaPodgrupa = farmakoloskaHemijskaPodgrupa;
    }

    public String getFarmaceutskiOblik() {
        return farmaceutskiOblik;
    }

    public void setFarmaceutskiOblik(String farmaceutskiOblik) {
        this.farmaceutskiOblik = farmaceutskiOblik;
    }

    public String getSadrzajAktivneSupstance() {
        return sadrzajAktivneSupstance;
    }

    public void setSadrzajAktivneSupstance(String sadrzajAktivneSupstance) {
        this.sadrzajAktivneSupstance = sadrzajAktivneSupstance;
    }

    public String getPakovanje() {
        return pakovanje;
    }

    public void setPakovanje(String pakovanje) {
        this.pakovanje = pakovanje;
    }

    public String getTerapijskaGrupa() {
        return terapijskaGrupa;
    }

    public void setTerapijskaGrupa(String terapijskaGrupa) {
        this.terapijskaGrupa = terapijskaGrupa;
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
        return (naziv + " - " + proizvodjac).toUpperCase();
    }

    @Override
    public String returnTableName() {
        return "lek";
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv, proizvodjac, inn, atcKlasifikacija, farmakoloskaHemijskaPodgrupa, farmaceutskiOblik, sadrzajAktivneSupstance, pakovanje, terapijskaGrupa";
    }

    @Override
    public AbstractDomainObject returnObjectFromRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            return new Lek(
                    rs.getInt("lek.idLek"),
                    rs.getString("lek.naziv"),
                    rs.getString("lek.proizvodjac"),
                    rs.getString("lek.inn"),
                    rs.getString("lek.atcKlasifikacija"),
                    rs.getString("lek.farmakoloskaHemijskaPodgrupa"),
                    rs.getString("lek.farmaceutskiOblik"),
                    rs.getString("lek.sadrzajAktivneSupstance"),
                    rs.getString("lek.pakovanje"),
                    rs.getString("lek.terapijskaGrupa")
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
                    rs.getString("lek.inn"),
                    rs.getString("lek.atcKlasifikacija"),
                    rs.getString("lek.farmakoloskaHemijskaPodgrupa"),
                    rs.getString("lek.farmaceutskiOblik"),
                    rs.getString("lek.sadrzajAktivneSupstance"),
                    rs.getString("lek.pakovanje"),
                    rs.getString("lek.terapijskaGrupa")
            );
            lekovi.add(lek);
        }
        return lekovi;
    }

    @Override
    public String vratiVrednostZaUbacivanje() {
        return "'" + naziv + "', '" + proizvodjac + "', '" + inn + "', '" + atcKlasifikacija + "', '" + farmakoloskaHemijskaPodgrupa + "', '" + farmaceutskiOblik + "', '" + sadrzajAktivneSupstance + "', '" + pakovanje + "', '" + terapijskaGrupa + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "lek.idLek = " + idLek;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv = '" + naziv + "', proizvodjac = '" + proizvodjac
                + "', inn = '" + inn
                + "', atcKlasifikacija = '" + atcKlasifikacija
                + "', farmakoloskaHemijskaPodgrupa = '" + farmakoloskaHemijskaPodgrupa
                + "', farmaceutskiOblik = '" + farmaceutskiOblik
                + "', sadrzajAktivneSupstance = '" + sadrzajAktivneSupstance
                + "', pakovanje = '" + pakovanje
                + "', terapijskaGrupa = '" + terapijskaGrupa + "'";
    }
}
