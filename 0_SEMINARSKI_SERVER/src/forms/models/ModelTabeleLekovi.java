/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.models;

import domain.Lek;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ognje
 */
public class ModelTabeleLekovi extends AbstractTableModel {

    List<Lek> lista;
    String[] kolone = {"idLek", "Naziv", "Proizvodjac", "Aktivni sastojak", "Farmaceutska grupa"};
    
    public ModelTabeleLekovi(List<Lek> lista) {
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
        Lek l = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return l.getIdLek();
            case 1:
                return l.getNaziv();
            case 2:
                return l.getProizvodjac();
            case 3:
                return l.getAktivniSastojak();
            case 4:
                return l.getFarmaceutskaGrupa();
            default:
                return "error";
        }
    }

    public List<Lek> getLista() {
        return lista;
    }
    
    public void pretrazi(String aktivniSastojak, String farmaceutskaGrupa, String naziv, String proizvodjac) {
        List<Lek> filteredList = lista.stream()
                .filter(d -> (aktivniSastojak == null || aktivniSastojak.isEmpty() || d.getAktivniSastojak().toLowerCase().contains(aktivniSastojak.toLowerCase())))
                .filter(d -> (farmaceutskaGrupa == null || farmaceutskaGrupa.isEmpty() || d.getFarmaceutskaGrupa().toLowerCase().contains(farmaceutskaGrupa.toLowerCase())))
                .filter(d -> (naziv == null || naziv.isEmpty() || d.getNaziv().toLowerCase().contains(naziv.toLowerCase())))
                .filter(d -> (proizvodjac == null || proizvodjac.isEmpty() || d.getProizvodjac().toLowerCase().contains(proizvodjac.toLowerCase())))
                .collect(Collectors.toList());
        this.lista = filteredList;
        fireTableChanged(null);
    }
    
}
