/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import domain.AbstractDomainObject;
import java.util.ArrayList;
import java.util.List;
import repository.db.DbRepository;

/**
 *
 * @author ognje
 */
public class DbRepositoryGeneric implements DbRepository<AbstractDomainObject> {

    @Override
    public List getAll(Object param) throws Exception {
        List<AbstractDomainObject> list = new ArrayList<>();
        String upit = "SELECT FROM " + ((AbstractDomainObject)param).returnTableName();

        return list;
    }

    @Override
    public void add(Object param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void edit(Object param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Object param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List getAll() {
        List<AbstractDomainObject> list = new ArrayList<>();
        String upit = "SELECT FROM";

        return list;
    }

}
