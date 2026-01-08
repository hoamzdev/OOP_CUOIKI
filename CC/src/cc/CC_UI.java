/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cc;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class CC_UI extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CC_UI.class.getName());

    private List<TaiKhoan> listTK = new ArrayList<>();

    public CC_UI() {
        initComponents();
        handleClickable();
    }

    private void handleClickable() {

        rdTK.addActionListener((v) -> {
            lbLS_LT.setText("Lãi suất");
            lbKH_SLGD.setText("Kì hạn");
        });
        rdTT.addActionListener((v) -> {
            lbLS_LT.setText("Loại thẻ");
            lbKH_SLGD.setText("Số lượng giao dịch");
        });

        btnSave.addActionListener((v -> {
            String maTK = edtMaThe.getText();
            String ten = edtHoTen.getText();
            String sd = edtSoDu.getText();

            if (maTK.isEmpty() || ten.isEmpty() || sd.isEmpty() || edtLaiSuat_LoaiThe.getText().isEmpty() || edtKiHan_SLGD.getText().isEmpty()) {
                showMsg("Vui lòng nhập đủ thông tin");
                return;
            }
            double soDu;
            try {
                soDu = Double.parseDouble(sd);
            } catch (NumberFormatException e) {
                showMsg("Số dư sai định dạng");
                return;
            }
            if (rdTK.isSelected()) {
                String ls = edtLaiSuat_LoaiThe.getText();
                float laiSuat;
                try {
                    laiSuat = Float.parseFloat(ls);
                } catch (NumberFormatException e) {
                    showMsg("Lãi suất sai định dạng");
                    return;
                }
                String kh = edtKiHan_SLGD.getText();
                int kiHan;
                try {
                    kiHan = Integer.parseInt(kh);
                } catch (NumberFormatException e) {
                    showMsg("Kì hạn sai định dạng");
                    return;
                }
                TaiKhoan tk = new TaiKhoanTietKem(maTK, ten, soDu, laiSuat, kiHan);
                saveToFile(tk);
                listTK.add(tk);
            } else {
                String loaiThe = edtLaiSuat_LoaiThe.getText();
                String sl = edtKiHan_SLGD.getText();
                int soLuongGiaoDich;
                try {
                    soLuongGiaoDich = Integer.parseInt(sl);
                } catch (NumberFormatException e) {
                    showMsg("Số lượng thanh toán sai định dạng");
                    return;
                }
                TaiKhoan tk = new TaiKhoanThanhToan(maTK, ten, soDu, loaiThe, soLuongGiaoDich);
                saveToFile(tk);
                listTK.add(tk);
            }
        }));
        
        btnThongKe.addActionListener((v -> {
            double tongSoDu = 0;
            double tongSoDuTK = 0;
            double tongSoDuTT = 0;

            for (TaiKhoan tk : listTK) {
                tongSoDu += tk.soDu;
                if (tk instanceof TaiKhoanThanhToan taiKhoanThanhToan) {
                    tongSoDuTT += taiKhoanThanhToan.soDu;
                } else if (tk instanceof TaiKhoanTietKem taiKhoanTietKem) {
                    tongSoDuTK += taiKhoanTietKem.soDu;
                }
            }
            lbTongDu.setText("Tổng số dư các tài khoản :" + tongSoDu + "$");
            lbTongDuTK.setText("Tổng số dư các tài khoản tiết kiệm :" + tongSoDuTK + "$");
            lbTongDuTT.setText("Tổng số dư các tài khoản thanh toán :" + tongSoDuTT + "$");
        }));
    }

    private void clearInput(){
        edtHoTen.setText("");
        edtKiHan_SLGD.setText("");
        edtMaThe.setText("");
        edtSoDu.setText("");
        edtLaiSuat_LoaiThe.setText("");
    }
    
    private void showMsg(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    //save to file
    private void saveToFile(TaiKhoan taiKhoan) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("taikhoan.txt", true))) {
            if (taiKhoan instanceof TaiKhoanThanhToan) {
                writer.write("TKTT," + taiKhoan.toString());
                writer.write("\n");
            } else if (taiKhoan instanceof TaiKhoanTietKem) {
                writer.write("TKTK," + taiKhoan.toString());
                writer.write("\n");
            }
        } catch (IOException e) {
            showMsg("Có lỗi trong quá tình lưu vào file");
            System.err.println(e.getMessage());
        } finally {
            clearInput();
            showMsg("Lưu thành công vào file");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        edtMaThe = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        edtHoTen = new javax.swing.JTextField();
        edtSoDu = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rdTK = new javax.swing.JRadioButton();
        rdTT = new javax.swing.JRadioButton();
        lbLS_LT = new javax.swing.JLabel();
        edtLaiSuat_LoaiThe = new javax.swing.JTextField();
        lbKH_SLGD = new javax.swing.JLabel();
        edtKiHan_SLGD = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        lbTongDu = new javax.swing.JLabel();
        lbTongDuTT = new javax.swing.JLabel();
        lbTongDuTK = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mã thẻ");

        jLabel2.setText("Họ tên");

        edtHoTen.addActionListener(this::edtHoTenActionPerformed);

        edtSoDu.addActionListener(this::edtSoDuActionPerformed);

        jLabel3.setText("Số dư");

        buttonGroup1.add(rdTK);
        rdTK.setSelected(true);
        rdTK.setText("Tài khoản tiết kiệm");
        rdTK.addActionListener(this::rdTKActionPerformed);

        buttonGroup1.add(rdTT);
        rdTT.setText("Tài khoản thanh toán");
        rdTT.addActionListener(this::rdTTActionPerformed);

        lbLS_LT.setText("Lãi suất (%)");

        edtLaiSuat_LoaiThe.addActionListener(this::edtLaiSuat_LoaiTheActionPerformed);

        lbKH_SLGD.setText("Kì hạn (năm)");

        btnSave.setText("Lưu");

        btnThongKe.setText("Thống kê");

        lbTongDu.setText("Tổng số dư tất cả các tài khoản : 0");

        lbTongDuTT.setText("Tổng số dư tài khoản thanh toán : 0");

        lbTongDuTK.setText("Tổng số dư tài khoản thanh toán : 0 ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 102, 51));
        jLabel9.setText("Thống kê");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rdTT, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(rdTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(edtSoDu)
                            .addComponent(edtMaThe)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbLS_LT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(edtLaiSuat_LoaiThe)
                            .addComponent(lbKH_SLGD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(edtKiHan_SLGD)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(270, 270, 270)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTongDu, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lbTongDuTK, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                        .addComponent(lbTongDuTT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)))))
                .addContainerGap(223, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtMaThe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbTongDu))
                .addGap(18, 18, 18)
                .addComponent(edtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbTongDuTT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtSoDu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdTK)
                    .addComponent(lbTongDuTK))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdTT)
                .addGap(18, 18, 18)
                .addComponent(lbLS_LT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(edtLaiSuat_LoaiThe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbKH_SLGD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(edtKiHan_SLGD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdTTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdTTActionPerformed

    private void rdTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdTKActionPerformed

    private void edtLaiSuat_LoaiTheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtLaiSuat_LoaiTheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtLaiSuat_LoaiTheActionPerformed

    private void edtHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtHoTenActionPerformed

    private void edtSoDuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtSoDuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtSoDuActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new CC_UI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnThongKe;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField edtHoTen;
    private javax.swing.JTextField edtKiHan_SLGD;
    private javax.swing.JTextField edtLaiSuat_LoaiThe;
    private javax.swing.JTextField edtMaThe;
    private javax.swing.JTextField edtSoDu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbKH_SLGD;
    private javax.swing.JLabel lbLS_LT;
    private javax.swing.JLabel lbTongDu;
    private javax.swing.JLabel lbTongDuTK;
    private javax.swing.JLabel lbTongDuTT;
    private javax.swing.JRadioButton rdTK;
    private javax.swing.JRadioButton rdTT;
    // End of variables declaration//GEN-END:variables
}
