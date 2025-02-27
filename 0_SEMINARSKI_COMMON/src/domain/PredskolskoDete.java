package domain;

import java.sql.ResultSet;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ognje
 */
public class PredskolskoDete extends Dete implements AbstractDomainObject {
    private String grupa;

    public PredskolskoDete() {
    }

    public PredskolskoDete(String grupa, int idDete, String ime, String prezime, LocalDate datumRodjenja) {
        super(idDete, ime, prezime, datumRodjenja);
        this.grupa = grupa;
    }
    
    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    @Override
    public String toString() {
        return "PredskolskoDete{" + "grupa=" + grupa + ", ime=" + getIme() + ", prezime=" + getPrezime() + '}';
    }
    
    @Override
    public String returnTableName() {
        return "predskolskodete";
    }

    @Override
    public List<AbstractDomainObject> returnListFromRS(ResultSet rs) throws Exception {
        List<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            PredskolskoDete dete = new PredskolskoDete(
                rs.getString("predskolskodete.grupa"),
                rs.getInt("dete.idDete"),
                rs.getString("dete.ime"),
                rs.getString("dete.prezime"),
                rs.getDate("dete.datumRodjenja").toLocalDate()
            );
            lista.add(dete);
        }
        return lista;
    }

    @Override
    public AbstractDomainObject returnObjectFromRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            return new PredskolskoDete(
                rs.getString("predskolskodete.grupa"),
                rs.getInt("dete.idDete"),
                rs.getString("dete.ime"),
                rs.getString("dete.prezime"),
                rs.getDate("dete.datumRodjenja").toLocalDate()
            );
        }
        return null;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "idDete, grupa";
    }

    @Override
    public String vratiVrednostZaUbacivanje() {
        return getIdDete()+ ", '" + grupa + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {//TODO da li je ovo dobro
        return "predskolskodete.idDete = " + getIdDete();
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "grupa = '" + grupa + "'";
    }
}