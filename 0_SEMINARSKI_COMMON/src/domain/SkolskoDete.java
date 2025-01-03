/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ognje
 */
public class SkolskoDete extends Dete implements AbstractDomainObject {

    private String odeljenje;
    private String razred;

    public SkolskoDete() {
    }

    public SkolskoDete(String odeljenje, String razred, int idDete, String ime, String prezime, LocalDate datumRodjenja) {
        super(idDete, ime, prezime, datumRodjenja);
        this.odeljenje = odeljenje;
        this.razred = razred;
    }

    @Override
    public String toString() {
        return "SkolskoDete{" + "odeljenje=" + odeljenje + ", razred=" + razred + getIme() + getPrezime() + '}';
    }

    @Override
    public String returnTableName() {
        return "skolskodete";
    }

    @Override
    public List<AbstractDomainObject> returnListFromRS(ResultSet rs) throws Exception {
        List<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            SkolskoDete dete = new SkolskoDete(
                    rs.getString("skolskodete.odeljenje"),
                    rs.getString("skolskodete.razred"),
                    rs.getInt("dete.idDete"),
                    rs.getString("dete.ime"),
                    rs.getString("dete.prezime"),
                    rs.getDate("dete.datumRodnjenja").toLocalDate()
            );
            lista.add(dete);
        }
        return lista;
    }

    @Override
    public AbstractDomainObject returnObjectFromRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            return new SkolskoDete(
                    rs.getString("skolskodete.odeljenje"),
                    rs.getString("skolskodete.razred"),
                    rs.getInt("dete.idDete"),
                    rs.getString("dete.ime"),
                    rs.getString("dete.prezime"),
                    rs.getDate("dete.datumRodnjenja").toLocalDate()
            );
        }
        return null;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "idDete, odeljenje, razred";

    }

    @Override
    public String vratiVrednostZaUbacivanje() {
        return getIdDete() + ", '" + odeljenje + "', '" + razred + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "skolskodete.idDete = " + getIdDete();

    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
