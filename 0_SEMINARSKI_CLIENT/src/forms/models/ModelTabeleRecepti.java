/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms.models;
import domain.Dete;
import domain.Recept;
import java.awt.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author ognje
 */
public class ModelTabeleRecepti extends AbstractTableModel{

    List<Recept> lista;
    String[] kolone = {"idRecept", "datumIzavanja", "Doktor", "Dete", "dijagnoza"};

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
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy"); // Custom format
                String dateString = r.getDatumIzdavanja().format(formatter);
                return dateString;
            case 2:
                return r.getDoktor().getIme();
            case 3:
                return r.getDete().getIme();
            case 4:
                return r.getDijagnoza();
            default:
                return "error";
        }
    }

    public List<Recept> getLista() {
        return lista;
    }

    public void pretrazi(String imeDeteta, String prezimeDeteta, String imeDoktora, String prezimeDoktora, String emailDoktora, LocalDate datumIzdavanja, String dijagnoza, Component parentComponent) {
        List<Recept> filteredList = lista.stream()
                .filter(d -> (imeDeteta == null || imeDeteta.isEmpty() || d.getDete().getIme().toLowerCase().contains(imeDeteta.toLowerCase())))
                .filter(d -> (prezimeDeteta == null || prezimeDeteta.isEmpty() || d.getDete().getPrezime().toLowerCase().contains(prezimeDeteta.toLowerCase())))
                .filter(d -> (imeDoktora == null || imeDoktora.isEmpty() || d.getDoktor().getIme().toLowerCase().contains(imeDoktora.toLowerCase())))
                .filter(d -> (prezimeDoktora == null || prezimeDoktora.isEmpty() || d.getDoktor().getPrezime().toLowerCase().contains(prezimeDoktora.toLowerCase())))
                .filter(d -> (emailDoktora == null || emailDoktora.isEmpty() || d.getDoktor().getEmail().toLowerCase().contains(emailDoktora.toLowerCase())))
                .filter(d -> (dijagnoza == null || dijagnoza.isEmpty() || d.getDijagnoza().toLowerCase().contains(dijagnoza.toLowerCase())))
                .filter(d -> (datumIzdavanja == null || datumIzdavanja.isEqual(d.getDatumIzdavanja())))
                .collect(Collectors.toList());
        this.lista = filteredList;
        if(filteredList.size() > 0) {
            JOptionPane.showMessageDialog(parentComponent, "Sistem je nasao recepte po zadatik kriterijumima", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(parentComponent, "Sistem ne moze da nadje recept po zadatik kriterijumima", "Greska", JOptionPane.ERROR_MESSAGE);
        }
        
        fireTableChanged(null);
    }

}
