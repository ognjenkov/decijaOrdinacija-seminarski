/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author ognje
 */
public class PrikazReceptaForm extends javax.swing.JFrame {

    /**
     * Creates new form PrikazReceptaForm
     */
    public PrikazReceptaForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRECEPTI = new javax.swing.JTable();
        jButtonOBRISIrecept = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableStavke = new javax.swing.JTable();
        jButtonOBRISIstavku = new javax.swing.JButton();
        jButtonDODAJstavku = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldDATUMIZDAVANJA = new javax.swing.JTextField();
        jTextFieldImeDETETA = new javax.swing.JTextField();
        jTextFieldPrezimeDETETA = new javax.swing.JTextField();
        jTextFieldIMEdoktora = new javax.swing.JTextField();
        jTextFieldPREZIMEdoktora = new javax.swing.JTextField();
        jButtonPRETRAZI = new javax.swing.JButton();
        jButtonRESETUJ = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldDIJAGNOZA = new javax.swing.JTextField();
        jButtonAZURIRAJRECEPT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Prikaz izdatih recepta");

        jTableRECEPTI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableRECEPTI);

        jButtonOBRISIrecept.setText("OBRISI RECEPT");

        jTableStavke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableStavke);

        jButtonOBRISIstavku.setText("Obrisi Stavku");

        jButtonDODAJstavku.setText("Dodaj Stavku");

        jLabel1.setText("Datum izdavanja:");

        jLabel2.setText("Ime deteta:");

        jLabel3.setText("Prezime deteta:");

        jLabel4.setText("Ime doktora:");

        jLabel5.setText("Prezime doktora:");

        jButtonPRETRAZI.setText("Pretrazi");

        jButtonRESETUJ.setText("Resetuj");

        jLabel6.setText("( 1.1.2001 )");

        jLabel7.setText("Dijagnoza:");

        jButtonAZURIRAJRECEPT.setText("AZURIRAJ RECEPT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonAZURIRAJRECEPT, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonOBRISIrecept))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldImeDETETA, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPrezimeDETETA, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldIMEdoktora, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPREZIMEdoktora, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                            .addComponent(jTextFieldDATUMIZDAVANJA)
                            .addComponent(jTextFieldDIJAGNOZA))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonPRETRAZI)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRESETUJ))
                            .addComponent(jLabel6))))
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonDODAJstavku)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonOBRISIstavku, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonOBRISIstavku)
                            .addComponent(jButtonDODAJstavku))
                        .addContainerGap(262, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldDIJAGNOZA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldDATUMIZDAVANJA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldImeDETETA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldPrezimeDETETA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldIMEdoktora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldPREZIMEdoktora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPRETRAZI)
                            .addComponent(jButtonRESETUJ))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonOBRISIrecept)
                            .addComponent(jButtonAZURIRAJRECEPT))
                        .addGap(29, 29, 29))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAZURIRAJRECEPT;
    private javax.swing.JButton jButtonDODAJstavku;
    private javax.swing.JButton jButtonOBRISIrecept;
    private javax.swing.JButton jButtonOBRISIstavku;
    private javax.swing.JButton jButtonPRETRAZI;
    private javax.swing.JButton jButtonRESETUJ;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableRECEPTI;
    private javax.swing.JTable jTableStavke;
    private javax.swing.JTextField jTextFieldDATUMIZDAVANJA;
    private javax.swing.JTextField jTextFieldDIJAGNOZA;
    private javax.swing.JTextField jTextFieldIMEdoktora;
    private javax.swing.JTextField jTextFieldImeDETETA;
    private javax.swing.JTextField jTextFieldPREZIMEdoktora;
    private javax.swing.JTextField jTextFieldPrezimeDETETA;
    // End of variables declaration//GEN-END:variables

    public JTable getjTableRECEPTI() {
        return jTableRECEPTI;
    }

    public JTable getjTableStavke() {
        return jTableStavke;
    }

    public void addBtnOBRISIreceptActionListener(ActionListener actionListener) {
        jButtonOBRISIrecept.addActionListener(actionListener);
    }
    
    public void addBtnDODAJstavkuActionListener(ActionListener actionListener) {
        jButtonDODAJstavku.addActionListener(actionListener);
    }
    public void addBtnOBRISIstavkuActionListener(ActionListener actionListener) {
        jButtonOBRISIstavku.addActionListener(actionListener);
    }
    public void addBtnPRETRAZIActionListener(ActionListener actionListener) {
        jButtonPRETRAZI.addActionListener(actionListener);
    }
    public void addBtnRESETUJActionListener(ActionListener actionListener) {
        jButtonRESETUJ.addActionListener(actionListener);
    }
    public void addBtnAZURIRAJRECEPTActionListener(ActionListener actionListener) {
        jButtonAZURIRAJRECEPT.addActionListener(actionListener);
    }

    public JButton getjButtonAZURIRAJRECEPT() {
        return jButtonAZURIRAJRECEPT;
    }
    

    public JButton getjButtonDODAJstavku() {
        return jButtonDODAJstavku;
    }

    public JButton getjButtonOBRISIrecept() {
        return jButtonOBRISIrecept;
    }

    public JButton getjButtonOBRISIstavku() {
        return jButtonOBRISIstavku;
    }

    public JButton getjButtonPRETRAZI() {
        return jButtonPRETRAZI;
    }

    public JButton getjButtonRESETUJ() {
        return jButtonRESETUJ;
    }

    public JTextField getjTextFieldDATUMIZDAVANJA() {
        return jTextFieldDATUMIZDAVANJA;
    }

    public JTextField getjTextFieldIMEdoktora() {
        return jTextFieldIMEdoktora;
    }

    public JTextField getjTextFieldImeDETETA() {
        return jTextFieldImeDETETA;
    }

    public JTextField getjTextFieldPREZIMEdoktora() {
        return jTextFieldPREZIMEdoktora;
    }

    public JTextField getjTextFieldPrezimeDETETA() {
        return jTextFieldPrezimeDETETA;
    }

    public JTextField getjTextFieldDIJAGNOZA() {
        return jTextFieldDIJAGNOZA;
    }

    

}
