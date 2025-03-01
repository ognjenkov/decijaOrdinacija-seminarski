/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.models;

import domain.DrSp;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ognje
 */
public class ModelTabeleDoktori extends AbstractTableModel {

    List<DrSp> lista;
    String[] kolone = {"idDoktor", "Ime", "Prezime", "Email", "Specijalizacija"};

    public ModelTabeleDoktori(List<DrSp> lista) {
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
        DrSp drsp = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return drsp.getDoktor().getIdDoktor();
            case 1:
                return drsp.getDoktor().getIme();
            case 2:
                return drsp.getDoktor().getPrezime();
            case 3:
                return drsp.getDoktor().getEmail();
            case 4:
                if (drsp.getSpecijalizacija() != null) {
                    return drsp.getSpecijalizacija().getNaziv();
                } else {
                    return "null";
                }

            default:
                return "error";
        }
    }

    public List<DrSp> getLista() {
        return lista;
    }

}
