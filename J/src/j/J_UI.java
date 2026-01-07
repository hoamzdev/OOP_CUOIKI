/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package j;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class J_UI extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(J_UI.class.getName());

    DefaultTableModel mdNV;
    DefaultTableModel mdQL;

    private List<CanBo> listCanBo = new ArrayList<>();

    public J_UI() {
        initComponents();
        initTable();
        rdNV.setSelected(true);
        hanlderClickable();
    }

    private void hanlderClickable() {
        rdNV.addActionListener((v) -> {
            lbNDT_HSCV.setText("Nganh dao tao");
        });
        rdQL.addActionListener((v) -> {
            lbNDT_HSCV.setText("He so chuc vu");
        });

        btnThem.addActionListener((v) -> {
            String ten = edtTen.getText();
            String namSinh = edtNamSinh.getText();
            String gioiTinh = cbSex.getSelectedItem().toString();
            String diaChi = edtDiaChi.getText();
            String heSoLuong = edtHsl.getText();
            double hsl = 0.0F;

            try {
                hsl = Double.parseDouble(heSoLuong);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "He so luong phai la so");
                return;
            }

            if (rdNV.isSelected()) {
                String nganhDaoTao = edtNDT_HSCV.getText();
                CanBo cb = new NhanVien(ten, namSinh, gioiTinh, diaChi, hsl, nganhDaoTao);
                listCanBo.add(cb);
                mdNV.addRow(cb.toObject());
            } else {
                String hscv = edtNDT_HSCV.getText();
                double heSoChucVu = 0.0F;
                try {
                    heSoChucVu = Double.parseDouble(hscv);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "He so chuc vu phai la so");
                    return;
                }
                CanBo cb = new QuanLy(ten, namSinh, gioiTinh, diaChi, hsl, heSoChucVu);
                listCanBo.add(cb);
                mdQL.addRow(cb.toObject());
            }
            edtTen.setText("");
            edtHsl.setText("");
            edtDiaChi.setText("");
            edtNDT_HSCV.setText("");
            edtNamSinh.setText("");
        });

        btnSaveFile.addActionListener((v) -> {
            try (BufferedWriter w = new BufferedWriter(new FileWriter("Canbo.txt"))) {
                for (CanBo cb : listCanBo) {
                    if (cb instanceof NhanVien) {
                        w.write("1, " + cb.toString());
                    } else if (cb instanceof QuanLy) {
                        w.write("2, " + cb.toString());
                    }
                    w.write("\n");
                }
                JOptionPane.showMessageDialog(null, "Luu file thanh cong");

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Co loi trong qua trinh luu file");
            }
        });
    }

    private void initTable() {
        mdNV = new DefaultTableModel(new Object[]{"Ten", "Nam sinh", "Gioi tinh", "Dia chi", "He so luong", "Nganh dao tao", "Luong"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        mdQL = new DefaultTableModel(new Object[]{"Ten", "Nam sinh", "Gioi tinh", "Dia chi", "He so luong", "He so chuc vu", "Luong"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbNV.setModel(mdNV);
        tbQL.setModel(mdQL);

        File file = new File("Canbo.txt");
        if (file.exists() && file.length() > 0) {
            try (BufferedReader reader = new BufferedReader(new FileReader("Canbo.txt"))) {
                String line;
                while ((line = (reader.readLine())) != null) {
                    String data[] = line.split(", ");
                    if (data[0].equals("1")) {
                        NhanVien cb = new NhanVien(data[1], data[2], data[3], data[4], Double.parseDouble(data[5]), data[6]);
                        mdNV.addRow(cb.toObject());
                    } else {
                        CanBo cb = new QuanLy(data[1], data[2], data[3], data[4], Double.parseDouble(data[5]), Double.parseDouble(data[6]));
                        mdQL.addRow(cb.toObject());
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Co loi trong qua trinh doc du lieu");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        edtTen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        edtNamSinh = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        edtDiaChi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        edtHsl = new javax.swing.JTextField();
        cbSex = new javax.swing.JComboBox<>();
        lbNDT_HSCV = new javax.swing.JLabel();
        edtNDT_HSCV = new javax.swing.JTextField();
        rdNV = new javax.swing.JRadioButton();
        rdQL = new javax.swing.JRadioButton();
        btnSaveFile = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbQL = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbNV = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ten");

        edtTen.addActionListener(this::edtTenActionPerformed);

        jLabel2.setText("Nam sinh");

        edtNamSinh.addActionListener(this::edtNamSinhActionPerformed);

        jLabel3.setText("Dia chi");

        edtDiaChi.addActionListener(this::edtDiaChiActionPerformed);

        jLabel4.setText("He so luong");

        edtHsl.addActionListener(this::edtHslActionPerformed);

        cbSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nu" }));

        lbNDT_HSCV.setText("Nganh dao tao");

        edtNDT_HSCV.addActionListener(this::edtNDT_HSCVActionPerformed);

        buttonGroup1.add(rdNV);
        rdNV.setText("Nhan vien");

        buttonGroup1.add(rdQL);
        rdQL.setText("Quan ly");

        btnSaveFile.setText("Luu file");

        btnThem.setText("Them");

        tbQL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ten", "Nam sinh", "Gioi tinh", "Dia chi", "He so luong", "He so chuc vu", "Luong"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbQL);

        tbNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ten", "Nam sinh", "Gioi tinh", "Dia chi", "He so luong", "Nganh dao tao", "Luong"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbNV);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbNDT_HSCV, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtNDT_HSCV, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtHsl, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtNamSinh, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtTen)
                            .addComponent(cbSex, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(rdNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rdQL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSaveFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(edtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(edtNamSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(edtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(edtHsl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdNV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdQL)
                        .addGap(47, 47, 47)
                        .addComponent(lbNDT_HSCV)
                        .addGap(18, 18, 18)
                        .addComponent(edtNDT_HSCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSaveFile, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edtTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtTenActionPerformed

    private void edtNamSinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtNamSinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtNamSinhActionPerformed

    private void edtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtDiaChiActionPerformed

    private void edtHslActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtHslActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtHslActionPerformed

    private void edtNDT_HSCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtNDT_HSCVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtNDT_HSCVActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new J_UI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveFile;
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbSex;
    private javax.swing.JTextField edtDiaChi;
    private javax.swing.JTextField edtHsl;
    private javax.swing.JTextField edtNDT_HSCV;
    private javax.swing.JTextField edtNamSinh;
    private javax.swing.JTextField edtTen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbNDT_HSCV;
    private javax.swing.JRadioButton rdNV;
    private javax.swing.JRadioButton rdQL;
    private javax.swing.JTable tbNV;
    private javax.swing.JTable tbQL;
    // End of variables declaration//GEN-END:variables
}
