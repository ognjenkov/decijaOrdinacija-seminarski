/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.models;
import domain.Recept;
import domain.StavkaRecepta;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ognje
 */
public class ModelTabeleStavke extends AbstractTableModel {
    List<StavkaRecepta> lista;
    String[] kolone = {"rb", "idRecept", "Lek", "terapija", "zakljucak"};

    public ModelTabeleStavke(List<StavkaRecepta> lista) {
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
        StavkaRecepta s = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getRb();
            case 1:
                return s.getIdRecept();
            case 2:
                return s.getLek().getNaziv();
            case 3:
                return s.getTerapija();
            case 4:
                return s.getZakljucak();
            default:
                return "error";
        }
    }

    public List<StavkaRecepta> getLista() {
        return lista;
    }

}
