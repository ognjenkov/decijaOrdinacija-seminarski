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
public class Specijalizacija implements AbstractDomainObject {

    private int idSpecijalizacija;
    private String naziv;

    public Specijalizacija() {
    }

    public Specijalizacija(int idSpecijalizacija, String naziv) {
        this.idSpecijalizacija = idSpecijalizacija;
        this.naziv = naziv;
    }

    public int getIdSpecijalizacija() {
        return idSpecijalizacija;
    }

    public void setIdSpecijalizacija(int idSpecijalizacija) {
        this.idSpecijalizacija = idSpecijalizacija;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return "Specijalizacija{" + "naziv=" + naziv + '}';
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
        final Specijalizacija other = (Specijalizacija) obj;
        if (this.idSpecijalizacija != other.idSpecijalizacija) {
            return false;
        }
        return Objects.equals(this.naziv, other.naziv);
    }

    @Override
    public String returnTableName() {
        return "specijalizacija";
    }

    @Override
    public List<AbstractDomainObject> returnListFromRS(ResultSet rs) throws Exception {
        List<AbstractDomainObject> list = new ArrayList<>();
        
        while (rs.next()) {
            int idSpecijalizacija = rs.getInt("specijalizacija.idSpecijalizacija");
            String naziv = rs.getString("specijalizacija.naziv");
            
            Specijalizacija specijalizacija = new Specijalizacija(idSpecijalizacija, naziv);
            list.add(specijalizacija);
        }
        
        return list;
    }

    @Override
    public AbstractDomainObject returnObjectFromRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            int idSpecijalizacija = rs.getInt("specijalizacija.idSpecijalizacija");
            String naziv = rs.getString("specijalizacija.naziv");
            
            return new Specijalizacija(idSpecijalizacija, naziv);
        }
        return null;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv";
    }

    @Override
    public String vratiVrednostZaUbacivanje() {
        return "'" + naziv + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "specijalizacija.idSpecijalizacija = " + idSpecijalizacija;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv='" + naziv + "'";
    }

}
