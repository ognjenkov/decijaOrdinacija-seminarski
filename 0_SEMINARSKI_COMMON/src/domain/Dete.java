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
public class Dete implements AbstractDomainObject {
    private int idDete;
    private String ime;
    private String prezime;
    private LocalDate datumRodjenja;

    public Dete() {
    }

    public Dete(int idDete, String ime, String prezime, LocalDate datumRodjenja) {
        this.idDete = idDete;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
    }

    @Override
    public String toString() {
        return "Dete{" + "ime=" + ime + ", prezime=" + prezime + '}';
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
        final Dete other = (Dete) obj;
        return this.idDete == other.idDete;
    }

    public int getIdDete() {
        return idDete;
    }

    public void setIdDete(int idDete) {
        this.idDete = idDete;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    @Override
    public String returnTableName() {
        return "dete";
    }

    @Override
    public List<AbstractDomainObject> returnListFromRS(ResultSet rs) throws Exception {
        List<AbstractDomainObject> list = new ArrayList<>();
        
        while (rs.next()) {
            int idDete = rs.getInt("dete.idDete");
            String ime = rs.getString("dete.ime");
            String prezime = rs.getString("dete.prezime");
            java.sql.Date sqlDate = rs.getDate("dete.datumRodjenja");
            LocalDate datumRodjenja = (sqlDate != null) ? sqlDate.toLocalDate() : null;
            
            Dete d = new Dete(idDete, ime, prezime, datumRodjenja);
            list.add(d);
        }
        
        return list;
    }

    @Override
    public AbstractDomainObject returnObjectFromRS(ResultSet rs) throws Exception {
        while (rs.next()) {
            int idDete = rs.getInt("dete.idDete");
            String ime = rs.getString("dete.ime");
            String prezime = rs.getString("dete.prezime");
            java.sql.Date sqlDate = rs.getDate("dete.datumRodjenja");
            LocalDate datumRodjenja = (sqlDate != null) ? sqlDate.toLocalDate() : null;
            
            Dete d = new Dete(idDete, ime, prezime, datumRodjenja);
            return d;
        }
        return null;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ime, prezime, datumRodjenja";
    }

    @Override
    public String vratiVrednostZaUbacivanje() {
        return "'" + ime + "','" + prezime + "','" + datumRodjenja + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "dete.idDete=" + idDete;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ime='" + ime + "', prezime='" + prezime + "', datumRodjenja='" + datumRodjenja + "'";
    }
}
