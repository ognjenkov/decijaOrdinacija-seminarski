/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author ognje
 */
public class Doktor implements AbstractDomainObject {
    private int idDoktor;
    private String ime;
    private String prezime;
    private String email;

    public Doktor() {
    }

    public Doktor(int idDoktor, String ime, String prezime, String email) {
        this.idDoktor = idDoktor;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
    }
    
    public Doktor(int idDoktor, String email) {
        this.idDoktor = idDoktor;
        this.email = email;
    }
    
    public Doktor(String ime, String prezime, String email) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
    }

    @Override
    public String toString() {
        return this.email;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Doktor other = (Doktor) obj;
        if (this.idDoktor != other.idDoktor) {
            return false;
        }
        return Objects.equals(this.email, other.email);
    }

    public int getIdDoktor() {
        return idDoktor;
    }

    public void setIdDoktor(int idDoktor) {
        this.idDoktor = idDoktor;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String returnTableName() {
        return "doktor";
    }

    @Override
    public List<AbstractDomainObject> returnListFromRS(ResultSet rs) throws Exception {
        List<AbstractDomainObject> list = new ArrayList<>();
        
        while (rs.next()) {
            int idDoktor = rs.getInt("doktor.idDoktor");
            String ime = rs.getString("doktor.ime");
            String prezime = rs.getString("doktor.prezime");
            String email = rs.getString("doktor.email");
            
            Doktor doktor = new Doktor(idDoktor, ime, prezime, email);
            list.add(doktor);
        }
        
        return list;
    }

    @Override
    public AbstractDomainObject returnObjectFromRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            int idDoktor = rs.getInt("doktor.idDoktor");
            String ime = rs.getString("doktor.ime");
            String prezime = rs.getString("doktor.prezime");
            String email = rs.getString("doktor.email");
            
            return new Doktor(idDoktor, ime, prezime, email);
        }
        return null;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ime, prezime, email";
    }

    @Override
    public String vratiVrednostZaUbacivanje() {
        return "'" + ime + "','" + prezime + "','" + email + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "doktor.idDoktor=" + idDoktor;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ime='" + ime + "', prezime='" + prezime + "', email='" + email + "'";
    }
}
