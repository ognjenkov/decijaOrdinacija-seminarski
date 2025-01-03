/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author ognje
 */
public interface AbstractDomainObject extends Serializable {

    public String returnTableName();

    public List<AbstractDomainObject> returnListFromRS(ResultSet rs) throws Exception;

    public AbstractDomainObject returnObjectFromRS(ResultSet rs) throws Exception;

    public String vratiKoloneZaUbacivanje();

    public String vratiVrednostZaUbacivanje();

    public String vratiPrimarniKljuc();

    public String vratiVrednostiZaIzmenu();
}
