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
public class Recept implements AbstractDomainObject {

    private int idRecept;
    private Doktor doktor;
    private Dete dete;
    private LocalDate datumIzdavanja;
    private String dijagnoza;
    private List<StavkaRecepta> stavke;

    public Recept() {
    }

    public Recept(int idRecept, Doktor doktor, Dete dete, LocalDate datumIzdavanja, String dijagnoza) {
        this.idRecept = idRecept;
        this.doktor = doktor;
        this.dete = dete;
        this.datumIzdavanja = datumIzdavanja;
        this.dijagnoza = dijagnoza;
    }

    public int getIdRecept() {
        return idRecept;
    }

    public void setIdRecept(int idRecept) {
        this.idRecept = idRecept;
    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    public Dete getDete() {
        return dete;
    }

    public void setDete(Dete dete) {
        this.dete = dete;
    }

    public LocalDate getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(LocalDate datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public String getDijagnoza() {
        return dijagnoza;
    }

    public void setDijagnoza(String dijagnoza) {
        this.dijagnoza = dijagnoza;
    }

    public List<StavkaRecepta> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaRecepta> stavke) {
        this.stavke = stavke;
    }
    

    @Override
    public String toString() {
        return "Recept{" + "idRecept=" + idRecept + ", doktor=" + doktor + ", dete=" + dete + ", datumIzdavanja=" + datumIzdavanja + ", dijagnoza=" + dijagnoza + "}";
    }

    @Override
    public int hashCode() {
        return 7; // Default hash code
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
        final Recept other = (Recept) obj;
        return this.idRecept == other.idRecept;
    }

    @Override
    public String returnTableName() {
        return "recept";
    }

    @Override
    public List<AbstractDomainObject> returnListFromRS(ResultSet rs) throws Exception {
        List<AbstractDomainObject> list = new ArrayList<>();

        while (rs.next()) {
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

            Dete dete1 = new Dete(idDete, imeDete, prezimeDete, datumRodjenjaDete);
            
            list.add(new Recept(idRecept, doktor, dete1, datumIzdavanja, dijagnoza));
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

            return new Recept(idRecept, doktor, dete, datumIzdavanja, dijagnoza);
        }
        return null;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "idDoktor, idDete, datumIzdavanja, dijagnoza";
    }

    @Override
    public String vratiVrednostZaUbacivanje() {
        return "'" + doktor.getIdDoktor() + "','" + dete.getIdDete() + "','" + datumIzdavanja + "','" + dijagnoza + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "recept.idDoktor = " + doktor.getIdDoktor() + " AND recept.idRecept = " + idRecept + " AND recept.idDete = " + dete.getIdDete();
    }

    @Override
    public String vratiVrednostiZaIzmenu() {//TODO mislim da ovo nije dobro
        return "datumIzdavanja='" + datumIzdavanja + "', dijagnoza='" + dijagnoza + "'";
    }
}
