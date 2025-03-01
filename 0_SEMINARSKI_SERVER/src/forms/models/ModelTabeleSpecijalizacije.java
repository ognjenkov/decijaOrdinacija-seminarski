/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.models;

import domain.Specijalizacija;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ognje
 */
public class ModelTabeleSpecijalizacije extends AbstractTableModel {
    List<Specijalizacija> lista;
    String[] kolone = {"idSpecijalizacija", "Naziv"};
    
    public ModelTabeleSpecijalizacije(List<Specijalizacija> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Specijalizacija s = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getIdSpecijalizacija();
            case 1:
                return s.getNaziv();
            default:
                return "error";
        }
    }

    public List<Specijalizacija> getLista() {
        return lista;
    }
    
}
