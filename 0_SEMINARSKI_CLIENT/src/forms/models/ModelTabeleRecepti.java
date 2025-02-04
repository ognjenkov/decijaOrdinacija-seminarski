/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.models;
import domain.Dete;
import domain.Recept;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author ognje
 */
public class ModelTabeleRecepti extends AbstractTableModel{

    List<Recept> lista;
    String[] kolone = {"idRecept", "datumIzavanja", "Doktor", "Dete"};

    public ModelTabeleRecepti(List<Recept> lista) {
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
        Recept r = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return r.getIdRecept();
            case 1:
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Custom format
                String dateString = r.getDatumIzdavanja().format(formatter);
                return dateString;
            case 2:
                return r.getDoktor().getIme();
            case 3:
                return r.getDete().getIme();
            default:
                return "error";
        }
    }

    public List<Recept> getLista() {
        return lista;
    }

//    public void pretrazi(String ime, String prezime, LocalDate datumRodnjenja) {
//        List<Dete> filteredList = lista.stream()
//                .filter(d -> (ime == null || ime.isEmpty() || d.getIme().toLowerCase().contains(ime.toLowerCase())))
//                .filter(d -> (prezime == null || prezime.isEmpty() || d.getPrezime().toLowerCase().contains(prezime.toLowerCase())))
//                .filter(d -> (datumRodnjenja == null || datumRodnjenja.isEqual(d.getDatumRodjenja())))
//                .collect(Collectors.toList());
//        this.lista = filteredList;
//        fireTableChanged(null);
//    }

}
