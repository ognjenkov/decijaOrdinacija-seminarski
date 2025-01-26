/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.models;

import domain.Dete;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ognje
 */
public class ModelTabeleDeca extends AbstractTableModel {

    List<Dete> lista;
    String[] kolone = {"idDete", "ime", "prezime", "datumRodjenja"};

    public ModelTabeleDeca(List<Dete> lista) {
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
        Dete d = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return d.getIdDete();
            case 1:
                return d.getIme();
            case 2:
                return d.getPrezime();
            case 3:
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Custom format
                String dateString = d.getDatumRodjenja().format(formatter);
                return dateString;
            default:
                return "error";
        }
    }

    public List<Dete> getLista() {
        return lista;
    }

}
