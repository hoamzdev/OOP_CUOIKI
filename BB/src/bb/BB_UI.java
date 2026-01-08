/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bb;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class BB_UI extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(BB_UI.class.getName());

    private DefaultTableModel dfSVCN;
    private DefaultTableModel dfSVTD;
    private final List<SinhVien> listSinhVien = new ArrayList<>();

    public BB_UI() {
        initComponents();
        initTable();
        handleClickable();
    }

    private void handleClickable() {
        rdSVCN.addActionListener((v) -> {
            lb_NH_TTD.setText("Ngành học");
            lb_NHH_TGTD.setText("Năm nhập học");
        });
        rdSVTD.addActionListener((v) -> {
            lb_NH_TTD.setText("Trường trao đổi");
            lb_NHH_TGTD.setText("Thời gian trao đổi");
        });

        btnSave.addActionListener((v) -> {
            String msv = edtMaSV.getText();
            String hoTen = edtHoTen.getText();
            String dtb = edtDTB.getText();
            float diemTrungBinh;
            String nh_ttd = edtNganhHoc_TruongTraoDoi.getText();
            String nnh_tgtd = edtNamNhapHoc_ThoiGianTraoDoi.getText();
            
            if(msv.isEmpty() || hoTen.isEmpty() || dtb.isEmpty() || nh_ttd.isEmpty() || nnh_tgtd.isEmpty()){
                showMessage("Vui lòng nhập đủ thông tin");
                return;
            }
            
            try {
                diemTrungBinh = Float.parseFloat(dtb);
                if (diemTrungBinh < 0 || diemTrungBinh > 10) {
                    throw new RuntimeException("Điểm trung bình phải ở trong đoạn [0,10]");
                }
            } catch (NumberFormatException e) {
                showMessage("Điểm trung bình phải ở dạng số");
                edtDTB.setText("");
                return;
            } catch (RuntimeException e) {
                showMessage(e.getMessage());
                edtDTB.setText("");
                return;
            }
            
            SinhVien sv;
            if (rdSVCN.isSelected()) {
                
                int namNhapHoc;
                try {
                    namNhapHoc = Integer.parseInt(nnh_tgtd);
                } catch (NumberFormatException e) {
                    showMessage("Năm nhập học phải ở dạng số");
                    return;
                }

                sv = new SinhVienCN(msv, hoTen, diemTrungBinh, nh_ttd, namNhapHoc);

            } else {
                int thoiGianTraoDoi;
                try {
                    thoiGianTraoDoi = Integer.parseInt(nnh_tgtd);
                } catch (NumberFormatException e) {
                    showMessage("Thời gian trao đổi phải ở dạng số");
                    return;
                }
                sv = new SinhVienTD(msv, hoTen, diemTrungBinh, nh_ttd, thoiGianTraoDoi);
            }
            
            listSinhVien.add(sv);
            //hien thi
            System.out.println(sv.toString());
            edtDTB.setText("");
            edtHoTen.setText("");
            edtMaSV.setText("");
            edtNamNhapHoc_ThoiGianTraoDoi.setText("");
            edtNganhHoc_TruongTraoDoi.setText("");
        });

        btnShow.addActionListener((v) -> {
            dfSVCN.setRowCount(0);
            dfSVTD.setRowCount(0);
            listSinhVien.forEach((sv) -> {
                if (sv instanceof SinhVienCN) {
                    dfSVCN.addRow(sv.toObject());
                } else if (sv instanceof SinhVienTD) {
                    dfSVTD.addRow(sv.toObject());
                }
            });
        });
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    private void initTable() {
        dfSVCN = new DefaultTableModel(new Object[]{"Mã sinh viên", "Họ tên", "Điểm trung bình", "Ngành học", "Năm nhập học"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dfSVTD = new DefaultTableModel(new Object[]{"Mã sinh viên", "Họ tên", "Điểm trung bình", "Trường trao đổi", "Thời gian trao đổi (tháng)"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbSVTD.setModel(dfSVTD);
        tbSVCN.setModel(dfSVCN);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        edtMaSV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        edtHoTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        edtDTB = new javax.swing.JTextField();
        rdSVCN = new javax.swing.JRadioButton();
        rdSVTD = new javax.swing.JRadioButton();
        lb_NH_TTD = new javax.swing.JLabel();
        edtNganhHoc_TruongTraoDoi = new javax.swing.JTextField();
        lb_NHH_TGTD = new javax.swing.JLabel();
        edtNamNhapHoc_ThoiGianTraoDoi = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSVCN = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbSVTD = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mã sinh viên");

        jLabel2.setText("Họ và tên");

        jLabel3.setText("Điểm trung bình");

        edtDTB.addActionListener(this::edtDTBActionPerformed);

        buttonGroup1.add(rdSVCN);
        rdSVCN.setSelected(true);
        rdSVCN.setText("Sinh viên chuyên ngành ");
        rdSVCN.addActionListener(this::rdSVCNActionPerformed);

        buttonGroup1.add(rdSVTD);
        rdSVTD.setText("Sinh viên trao đổi");

        lb_NH_TTD.setText("Ngành học");

        lb_NHH_TGTD.setText("Năm nhập học");

        btnSave.setText("Lưu");

        btnShow.setText("Hiển thị");

        tbSVCN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sinh viên", "Họ tên", "Điểm trung bình", "Ngành học", "Năm nhập học"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbSVCN);

        tbSVTD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sinh viên", "Họ tên", "Điểm trung bình", "Trường trao đổi", "Thời gian trao đổi (tháng)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbSVTD);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edtDTB)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edtHoTen)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edtMaSV)
                    .addComponent(rdSVCN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rdSVTD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_NH_TTD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edtNganhHoc_TruongTraoDoi)
                    .addComponent(lb_NHH_TGTD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edtNamNhapHoc_ThoiGianTraoDoi)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnShow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(0, 47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtDTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdSVCN, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdSVTD))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lb_NH_TTD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtNganhHoc_TruongTraoDoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lb_NHH_TGTD)
                        .addGap(18, 18, 18)
                        .addComponent(edtNamNhapHoc_ThoiGianTraoDoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnSave)
                        .addGap(18, 18, 18)
                        .addComponent(btnShow))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edtDTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtDTBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtDTBActionPerformed

    private void rdSVCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdSVCNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdSVCNActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new BB_UI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnShow;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField edtDTB;
    private javax.swing.JTextField edtHoTen;
    private javax.swing.JTextField edtMaSV;
    private javax.swing.JTextField edtNamNhapHoc_ThoiGianTraoDoi;
    private javax.swing.JTextField edtNganhHoc_TruongTraoDoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_NHH_TGTD;
    private javax.swing.JLabel lb_NH_TTD;
    private javax.swing.JRadioButton rdSVCN;
    private javax.swing.JRadioButton rdSVTD;
    private javax.swing.JTable tbSVCN;
    private javax.swing.JTable tbSVTD;
    // End of variables declaration//GEN-END:variables
}
