/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package g;

import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class G_UI extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(G_UI.class.getName());

    /**
     * Creates new form G_UI
     */
    List<TaiKhoan> listTaiKhoan = new ArrayList<>();

    public G_UI() {
        initComponents();

        cbTK.setSelected(true);

        handleClickable();

    }

    private void handleClickable() {
        cbTK.addActionListener((v) -> {
            lbLS_LT.setText("Lai suat");
            lbKH_SLGD.setText("Ki han");
        });

        cbTT.addActionListener((v) -> {
            lbLS_LT.setText("Loai the");
            lbKH_SLGD.setText("So luong giao dich");
        });

        btnSave.addActionListener((ActionEvent v) -> {
            String maThe = edtMaTaiKhoan.getText();
            String ten = edtName.getText();

            String sd = edtSoDu.getText();
            double soDu = 0.0F;
            try {
                soDu = Double.parseDouble(sd);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "So du phai la dang so");
                return;
            }

            if (cbTK.isSelected()) {
                String ls = edtLS_LT.getText();
                double laiSuat = 0.0F;
                try {
                    laiSuat = Double.parseDouble(ls);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Lai suat phai la dang so");
                    return;
                }
                String kiHan = edtKH_SLGD.getText();
                TaiKhoan tk = new TaiKhoanTietKiem(maThe, ten, soDu, laiSuat, kiHan);
                listTaiKhoan.add(tk);
                save(tk);
            } else {
                String loaiThe = edtLS_LT.getText();
                String slgd = edtKH_SLGD.getText();
                int soLuongGiaoDich = 0;
                try {
                    soLuongGiaoDich = Integer.parseInt(slgd);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "So luong giao dich phai la dang so");
                    return;
                }
                TaiKhoan tk = new TaiKhoanThanhToan(maThe, ten, soDu, loaiThe, soLuongGiaoDich);
                listTaiKhoan.add(tk);               
                save(tk);
            }
        });

        btnThongKe.addActionListener((v) -> {
            double tongSoDu = 0.0F;
            double tongSoDuTK = 0.0F;
            double tongSoDuTT = 0.0F;

            for (TaiKhoan tk : listTaiKhoan) {
                tongSoDu += tk.getSoDu();
                if (tk instanceof TaiKhoanThanhToan) {
                    tongSoDuTT += tk.getSoDu();
                } else if (tk instanceof TaiKhoanTietKiem) {
                    tongSoDuTK += tk.getSoDu();
                }
            }
            lbTongSoDu.setText("Tong so du : " + tongSoDu);
            lbTongTK.setText("Tong so du tiet kiem: " + tongSoDuTK);
            lbTongTT.setText("Tong so du thanh toan: " + tongSoDuTT);
        });

    }

    private void save(TaiKhoan tk) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Taikhoan.txt",true))) {
            if (tk instanceof TaiKhoanThanhToan) {
                writer.write("1," + tk.toString());
                writer.write("\n");
            } else if (tk instanceof TaiKhoanTietKiem) {
                writer.write("2," + tk.toString());
                writer.write("\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Co loi xay ra khi luu vao file");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        edtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        edtMaTaiKhoan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        edtSoDu = new javax.swing.JTextField();
        cbTK = new javax.swing.JRadioButton();
        cbTT = new javax.swing.JRadioButton();
        lbLS_LT = new javax.swing.JLabel();
        edtLS_LT = new javax.swing.JTextField();
        lbKH_SLGD = new javax.swing.JLabel();
        edtKH_SLGD = new javax.swing.JTextField();
        btnThongKe = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        lbTongSoDu = new javax.swing.JLabel();
        lbTongTK = new javax.swing.JLabel();
        lbTongTT = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Quan ly ngan hang");

        jLabel2.setText("Ma tai khoan");

        jLabel3.setText("Ten chu tai khoan");

        jLabel4.setText("So du");

        buttonGroup1.add(cbTK);
        cbTK.setText("Tiet kiem");

        buttonGroup1.add(cbTT);
        cbTT.setText("Thanh toan");
        cbTT.addActionListener(this::cbTTActionPerformed);

        lbLS_LT.setText("Lai suat");

        lbKH_SLGD.setText("Ki han");

        btnThongKe.setText("Thong ke");

        btnSave.setText("Luu");

        lbTongSoDu.setText("Tong so du: 0.0");

        lbTongTK.setText("Tong so du tiet kiem: 0.0");

        lbTongTT.setText("Tong so du thanh toan: 0.0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbKH_SLGD, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(edtLS_LT, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(edtKH_SLGD))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(edtMaTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(edtSoDu, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                .addComponent(cbTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbTT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbLS_LT, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(edtName, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 371, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbTongTT, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                    .addComponent(lbTongTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbTongSoDu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(86, 86, 86))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(167, 167, 167))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(edtMaTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lbTongSoDu)
                .addGap(2, 2, 2)
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbTongTK)
                        .addGap(26, 26, 26)
                        .addComponent(lbTongTT))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(edtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)))
                .addGap(28, 28, 28)
                .addComponent(edtSoDu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbTK)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbTT)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLS_LT)
                    .addComponent(edtLS_LT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbKH_SLGD)
                    .addComponent(edtKH_SLGD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTTActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new G_UI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnThongKe;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton cbTK;
    private javax.swing.JRadioButton cbTT;
    private javax.swing.JTextField edtKH_SLGD;
    private javax.swing.JTextField edtLS_LT;
    private javax.swing.JTextField edtMaTaiKhoan;
    private javax.swing.JTextField edtName;
    private javax.swing.JTextField edtSoDu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbKH_SLGD;
    private javax.swing.JLabel lbLS_LT;
    private javax.swing.JLabel lbTongSoDu;
    private javax.swing.JLabel lbTongTK;
    private javax.swing.JLabel lbTongTT;
    // End of variables declaration//GEN-END:variables
}
