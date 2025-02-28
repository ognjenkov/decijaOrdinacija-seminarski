/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import domain.AbstractDomainObject;
import java.util.ArrayList;
import java.util.List;
import repository.db.DbRepository;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import repository.db.DbConnectionFactory;
import java.sql.Connection;
/**
 *
 * @author ognje
 */
public class DbRepositoryGeneric<T extends AbstractDomainObject> implements DbRepository<T> {

    @Override
    public List<T> getAll(T param, String uslov) throws Exception {
        List<T> list = new ArrayList<>();
        //TODO ovo ces da reworkujes dodaces param.returnAllColums koja ce da vrati dete.ime dete.prezime dete.id itd...
        String query = "SELECT * FROM " + param.returnTableName();
        if (uslov != null) { //TODO
            query = query + uslov;
        }
        System.out.println(query);
        Statement st = DbConnectionFactory.getInstance().getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);
        System.out.println("executed query");
        list = (List<T>) param.returnListFromRS(rs);
        for (T t : list) {
            System.out.println(t.toString());
        }
        rs.close();
        st.close();

        return list;
    }

    @Override
    public int add(T param) throws Exception {
        String query = "INSERT INTO " + param.returnTableName() + " (" + param.vratiKoloneZaUbacivanje() + ") VALUES (" + param.vratiVrednostZaUbacivanje() + ");";
        System.out.println(query);
        Connection conn = DbConnectionFactory.getInstance().getConnection();
        PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();
        int generatedId = -1;
        if (rs.next()) {
            generatedId = rs.getInt(1); // Retrieve the generated ID
        }

        rs.close();
        st.close();
        return generatedId;
    }

    @Override
    public void edit(T param) throws Exception {
        String query = "UPDATE " + param.returnTableName() + " SET " + param.vratiVrednostiZaIzmenu() + " WHERE " + param.vratiPrimarniKljuc() + ";";
        System.out.println(query);
        Statement st = DbConnectionFactory.getInstance().getConnection().createStatement();
        st.executeUpdate(query);
        st.close();

    }

    @Override
    public void delete(T param) throws Exception {
        String query = "DELETE FROM " + param.returnTableName() + " WHERE " + param.vratiPrimarniKljuc() + ";";
        System.out.println(query);
        Statement st = DbConnectionFactory.getInstance().getConnection().createStatement();
        st.executeUpdate(query);
        st.close();

    }

    @Override
    public List<T> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
