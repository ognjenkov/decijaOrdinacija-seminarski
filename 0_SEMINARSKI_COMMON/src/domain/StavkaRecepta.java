/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author ognje
 */
public class StavkaRecepta implements AbstractDomainObject {

    private int rb;
    private int idRecept;
    private Lek lek;
    private String terapija;
    private String zakljucak;

    public StavkaRecepta() {
    }

    public StavkaRecepta(int rb, int idRecept, Lek lek, String terapija, String zakljucak) {
        this.rb = rb;
        this.idRecept = idRecept;
        this.lek = lek;
        this.terapija = terapija;
        this.zakljucak = zakljucak;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public int getIdRecept() {
        return idRecept;
    }

    public void setRecept(int idRecept) {
        this.idRecept = idRecept;
    }

    public Lek getLek() {
        return lek;
    }

    public void setLek(Lek lek) {
        this.lek = lek;
    }

    public String getTerapija() {
        return terapija;
    }

    public void setTerapija(String terapija) {
        this.terapija = terapija;
    }

    public String getZakljucak() {
        return zakljucak;
    }

    public void setZakljucak(String zakljucak) {
        this.zakljucak = zakljucak;
    }

    @Override
    public String toString() {
        return "StavkaRecepta{" + "rb=" + rb + ", recept=" + idRecept + ", lek=" + lek + ", terapija=" + terapija + ", zakljucak=" + zakljucak + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final StavkaRecepta other = (StavkaRecepta) obj;
        if (this.rb != other.rb) {
            return false;
        }
        if (!Objects.equals(this.terapija, other.terapija)) {
            return false;
        }
        if (!Objects.equals(this.zakljucak, other.zakljucak)) {
            return false;
        }
        if (this.idRecept != other.idRecept) {
            return false;
        }
        return Objects.equals(this.lek, other.lek);
    }

    @Override
    public String returnTableName() {
        return "stavkarecepta";
    }

    @Override
    public List<AbstractDomainObject> returnListFromRS(ResultSet rs) throws Exception {
        List<AbstractDomainObject> list = new ArrayList<>();

        while (rs.next()) {
            int idLek = rs.getInt("lek.idLek");
            String naziv = rs.getString("lek.naziv");
            String proizvodjac = rs.getString("lek.proizvodjac");
            String inn = rs.getString("lek.inn");
            String atcKlasifikacija = rs.getString("lek.atcKlasifikacija");
            String farmakoloskaHemijskaPodgrupa = rs.getString("lek.farmakoloskaHemijskaPodgrupa");
            String farmaceutskiOblik = rs.getString("lek.farmaceutskiOblik");
            String sadrzajAktivneSupstance = rs.getString("lek.sadrzajAktivneSupstance");
            String pakovanje = rs.getString("lek.pakovanje");
            String terapijskaGrupa = rs.getString("lek.terapijskaGrupa");

            Lek lek = new Lek(idLek, naziv, proizvodjac, inn, atcKlasifikacija, farmakoloskaHemijskaPodgrupa, farmaceutskiOblik, sadrzajAktivneSupstance, pakovanje, terapijskaGrupa);

            int rb = rs.getInt("stavkarecepta.rb");
            String terapija = rs.getString("stavkarecepta.terapija");
            String zakljucak = rs.getString("stavkarecepta.zakljucak");

            int idDoktor = rs.getInt("doktor.idDoktor");
            String ime = rs.getString("doktor.ime");
            String prezime = rs.getString("doktor.prezime");
            String email = rs.getString("doktor.email");
            Doktor doktor = new Doktor(idDoktor, ime, prezime, email, "");

            int idRecept = rs.getInt("recept.idRecept");
            LocalDate datumIzdavanja = rs.getDate("recept.datumIzdavanja").toLocalDate();
            String dijagnoza = rs.getString("recept.dijagnoza");

            int idDete = rs.getInt("dete.idDete");
            String imeDete = rs.getString("dete.ime");
            String prezimeDete = rs.getString("dete.prezime");
            java.sql.Date sqlDate = rs.getDate("dete.datumRodjenja");
            LocalDate datumRodjenjaDete = (sqlDate != null) ? sqlDate.toLocalDate() : null;

            Dete dete = new Dete(idDete, imeDete, prezimeDete, datumRodjenjaDete);

            Recept recept = new Recept(idRecept, doktor, dete, datumIzdavanja, dijagnoza);

            list.add(new StavkaRecepta(rb, recept, lek, terapija, zakljucak));
        }
        return list;
    }

    @Override
    public AbstractDomainObject returnObjectFromRS(ResultSet rs) throws Exception {//todo ovo mozda najverovatnije nije dobro
        if (rs.next()) {
            int idLek = rs.getInt("lek.idLek");
            String naziv = rs.getString("lek.naziv");
            String proizvodjac = rs.getString("lek.proizvodjac");
            String inn = rs.getString("lek.inn");
            String atcKlasifikacija = rs.getString("lek.atcKlasifikacija");
            String farmakoloskaHemijskaPodgrupa = rs.getString("lek.farmakoloskaHemijskaPodgrupa");
            String farmaceutskiOblik = rs.getString("lek.farmaceutskiOblik");
            String sadrzajAktivneSupstance = rs.getString("lek.sadrzajAktivneSupstance");
            String pakovanje = rs.getString("lek.pakovanje");
            String terapijskaGrupa = rs.getString("lek.terapijskaGrupa");

            Lek lek = new Lek(idLek, naziv, proizvodjac, inn, atcKlasifikacija, farmakoloskaHemijskaPodgrupa, farmaceutskiOblik, sadrzajAktivneSupstance, pakovanje, terapijskaGrupa);

            int rb = rs.getInt("stavkarecepta.rb");
            String terapija = rs.getString("stavkarecepta.terapija");
            String zakljucak = rs.getString("stavkarecepta.zakljucak");

            int idDoktor = rs.getInt("doktor.idDoktor");
            String ime = rs.getString("doktor.ime");
            String prezime = rs.getString("doktor.prezime");
            String email = rs.getString("doktor.email");
            Doktor doktor = new Doktor(idDoktor, ime, prezime, email, "");

            int idRecept = rs.getInt("recept.idRecept");
            LocalDate datumIzdavanja = rs.getDate("recept.datumIzdavanja").toLocalDate();
            String dijagnoza = rs.getString("recept.dijagnoza");

            int idDete = rs.getInt("dete.idDete");
            String imeDete = rs.getString("dete.ime");
            String prezimeDete = rs.getString("dete.prezime");
            java.sql.Date sqlDate = rs.getDate("dete.datumRodjenja");
            LocalDate datumRodjenjaDete = (sqlDate != null) ? sqlDate.toLocalDate() : null;

            Dete dete = new Dete(idDete, imeDete, prezimeDete, datumRodjenjaDete);

            Recept recept = new Recept(idRecept, doktor, dete, datumIzdavanja, dijagnoza);

            return new StavkaRecepta(rb, recept, lek, terapija, zakljucak);
        }
        return null;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "idRecept, rb, idLek, terapija, zakljucak";
    }

    @Override
    public String vratiVrednostZaUbacivanje() {
        return "'" + idRecept + "','" + rb + "','" + lek.getIdLek() + "','" + terapija + "','" + zakljucak + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "stavkarecepta.idRecept = " + idRecept + " AND stavkarecepta.rb = " + rb + " AND stavkarecepta.idLek = " + lek.getIdLek();

    }

    @Override
    public String vratiVrednostiZaIzmenu() {//TODO mislim da ovo nije dobro
        return "terapija='" + terapija + "', zakljucak='" + zakljucak + "'";
    }

}
