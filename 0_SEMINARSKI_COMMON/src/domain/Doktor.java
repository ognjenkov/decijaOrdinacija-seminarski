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
    private String sifra;
    
    public Doktor() {
    }

    public Doktor(int idDoktor, String ime, String prezime, String email, String sifra) {
        this.idDoktor = idDoktor;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.sifra = sifra;
    }
    
    public Doktor(String email, String sifra) {
        this.email = email;
        this.sifra = sifra;
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
        if (!Objects.equals(this.sifra,other.getSifra())) {
            return false;
        }
        
        return Objects.equals(this.email, other.getEmail());
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

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
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
            String sifra = rs.getString("doktor.sifra");
            
            Doktor doktor = new Doktor(idDoktor, ime, prezime, email, sifra);
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
            String sifra = rs.getString("doktor.sifra");
            
            return new Doktor(idDoktor, ime, prezime, email, sifra);
        }
        return null;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ime, prezime, email, sifra";
    }

    @Override
    public String vratiVrednostZaUbacivanje() {
        return "'" + ime + "','" + prezime + "','" + email + "','" + sifra + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "doktor.idDoktor=" + idDoktor;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ime='" + ime + "', prezime='" + prezime + "', email='" + email + "', sifra='" + sifra + "'";
    }
}
