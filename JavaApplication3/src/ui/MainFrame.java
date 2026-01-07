package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
        setLocationRelativeTo(null);
        btnSave.setBackground(Color.CYAN);

        btnSave.addActionListener(ac -> {
            String content = edtTest.getText();
            tvShow.setText(content);

            String sel = (String) cbBox.getSelectedItem();
            tvSelected.setText(sel);
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSave = new javax.swing.JButton();
        tvShow = new javax.swing.JLabel();
        edtTest = new javax.swing.JTextField();
        cbBox = new javax.swing.JComboBox<>();
        tvSelected = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSave.setText("save");
        btnSave.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        btnSave.setFocusPainted(false);
        btnSave.setMargin(new java.awt.Insets(4, 20, 4, 20));
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 343, 64, 32));

        tvShow.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tvShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 248, 207, 30));
        getContentPane().add(edtTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 303, 135, -1));

        cbBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "hwa", "hoa", "hoamz", "Hoaf" }));
        getContentPane().add(cbBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 47, -1, -1));

        tvSelected.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tvSelected, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 47, 151, 20));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setName("tb1"); // NOI18N
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, -1, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbBox;
    private javax.swing.JTextField edtTest;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel tvSelected;
    private javax.swing.JLabel tvShow;
    // End of variables declaration//GEN-END:variables
}
