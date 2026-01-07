/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package d;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class DMainUI extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DMainUI.class.getName());
    private DefaultTableModel modelData;
    private List<Ruong> listRuong = new ArrayList<>();
    
    public DMainUI() {
        initComponents();
        initTable();
        cbChuNhat.setSelected(true);
        tvChieuRong.setVisible(true);
        edtChieuRong.setVisible(true);
        handlerUserClick();
    }
    
    private void thongKe(){
        int tongSoRuong = listRuong.size();
        int tongSoRuongVuong = (int) listRuong.stream()
                .filter((r) -> r instanceof RuongVuong)
                .count();
        int soRuongCn = tongSoRuong - tongSoRuongVuong;
        
        int soLuongLonHonMax = (int) listRuong.stream()
                .filter((it) -> it.tinhDienTich() > Ruong.DIEN_TICH_MAX)
                .count();
        
        Map<String,Integer> hm = new HashMap<>();
        
        listRuong.forEach((r) -> {
            hm.put(r.loaiCayTrong,hm.getOrDefault(r.loaiCayTrong,0) + 1);
        });
        
        List<String> cays = new ArrayList<>();
        int MaxCnt = 0;
        for(Map.Entry<String, Integer> entry : hm.entrySet()){
            if(entry.getValue() > MaxCnt){
                cays.clear();
                MaxCnt = entry.getValue();
                cays.add(entry.getKey());
            }
            else if(entry.getValue() == MaxCnt){
                cays.add(entry.getKey());
            }
        }
            
        tvTongSoRuong.setText(String.valueOf(tongSoRuong));
        tvSoRuongVuong.setText(String.valueOf(tongSoRuongVuong));
        tvSoRuongCn.setText(String.valueOf(soRuongCn));
        tvCayNhieu.setText(String.join(", ", cays));
        tvCntLonHonMax.setText(String.valueOf(soLuongLonHonMax));
    }
        
   
    private void handlerUserClick(){
        
        cbChuNhat.addActionListener((v) -> {
            tvChieuRong.setVisible(true);
            edtChieuRong.setVisible(true);
        });
        
        cbVuong.addActionListener((v) -> {
            tvChieuRong.setVisible(false);
            edtChieuRong.setVisible(false);
        });
        
        btnSave.addActionListener((v) -> {
            String maR = edtMaRuong.getText();
            String tenChuHo = edtTenChuHo.getText();
            String loadiCay = edtCayTrong.getText();
            double doDai = 0.0;
            double doRong = 0.0;
            String chieuDai = edtChieuDai.getText();
            
            try{
                doDai = Double.parseDouble(chieuDai);
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Nhap so pls");
            }
            
            if(cbChuNhat.isSelected()){
                String chieuRong = edtChieuRong.getText();
                try{
                    doRong = Double.parseDouble(chieuRong);
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Nhap so pls");
                }
                //tao obj
                RuongChuNhat r = new RuongChuNhat(maR, tenChuHo, loadiCay, doDai, doRong);
                listRuong.add(r);
                modelData.addRow(r.toObject());
            }
            
            else{
                //tao obj
                RuongVuong r = new RuongVuong(maR, tenChuHo, loadiCay, doDai);
                listRuong.add(r);
                modelData.addRow(r.toObject());
            }
            
            edtMaRuong.setText("");
            edtChieuDai.setText("");
            edtChieuRong.setText("");
            edtCayTrong.setText("");
            edtTenChuHo.setText("");
            thongKe();
        });
        
        
        btnSaveToFile.addActionListener((v) -> {
            try(BufferedWriter writer = new BufferedWriter(new FileWriter("ruong.txt"))){
                for(Ruong r : listRuong){
                    writer.write(r.toString());
                    writer.write("\n");
                }
            }
            catch(IOException e){
                JOptionPane.showMessageDialog(null, "Luu khong thanh cong co loi xay ra");
            }
        });
    }
    
    
    private void initTable(){
        modelData = new DefaultTableModel(new Object[]{"Ma ruong", "Ten chu ho", "Loai cay trong", " Chieu dai", "Chieu rong"}, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbData.setModel(modelData);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        edtMaRuong = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        edtTenChuHo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        edtCayTrong = new javax.swing.JTextField();
        tvChieuDai = new javax.swing.JLabel();
        edtChieuDai = new javax.swing.JTextField();
        tvChieuRong = new javax.swing.JLabel();
        edtChieuRong = new javax.swing.JTextField();
        btnSaveToFile = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbData = new javax.swing.JTable();
        cbVuong = new javax.swing.JRadioButton();
        cbChuNhat = new javax.swing.JRadioButton();
        tvLoaiCayTrongNhieu = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tvTongSoRuong = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tvSoRuongVuong = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tvSoRuongCn = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tvCntLonHonMax = new javax.swing.JLabel();
        tvCayNhieu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ma ruong");

        edtMaRuong.addActionListener(this::edtMaRuongActionPerformed);

        jLabel2.setText("Ten chu ho");

        edtTenChuHo.addActionListener(this::edtTenChuHoActionPerformed);

        jLabel3.setText("Loai cay trong");

        edtCayTrong.addActionListener(this::edtCayTrongActionPerformed);

        tvChieuDai.setText("Chieu dai");

        edtChieuDai.addActionListener(this::edtChieuDaiActionPerformed);

        tvChieuRong.setText("Chieu rong");

        edtChieuRong.addActionListener(this::edtChieuRongActionPerformed);

        btnSaveToFile.setText("Luu vao file");

        btnSave.setText("Luu");

        tbData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma ruong", "Ten chu ho", "Loai cay trong", " Chieu dai", "Chieu rong"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbData);

        buttonGroup1.add(cbVuong);
        cbVuong.setText("Vuong");

        buttonGroup1.add(cbChuNhat);
        cbChuNhat.setText("Chu Nhat");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnSaveToFile, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tvChieuDai, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(edtTenChuHo)
                                    .addComponent(edtMaRuong)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                    .addComponent(edtCayTrong)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbVuong, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbChuNhat)))
                                .addComponent(edtChieuDai, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tvChieuRong, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(edtChieuRong, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(edtMaRuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtTenChuHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtCayTrong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbVuong)
                            .addComponent(cbChuNhat))
                        .addGap(18, 18, 18)
                        .addComponent(tvChieuDai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtChieuDai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tvChieuRong)
                        .addGap(18, 18, 18)
                        .addComponent(edtChieuRong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSaveToFile, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Nhap", jPanel1);

        tvLoaiCayTrongNhieu.setName("0"); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Thong ke");

        jLabel6.setText("Tong so ruong");

        tvTongSoRuong.setText("0");

        jLabel9.setText("So ruong vuong");

        tvSoRuongVuong.setText("0");

        jLabel11.setText("So ruong chu nhat");

        tvSoRuongCn.setText("0");

        jLabel13.setText("Loai cay trong nhieu nhat");

        jLabel15.setText("So ruong co dien tich lon hon MAX");

        tvCntLonHonMax.setText("0");

        tvCayNhieu.setText("\"\"");

        javax.swing.GroupLayout tvLoaiCayTrongNhieuLayout = new javax.swing.GroupLayout(tvLoaiCayTrongNhieu);
        tvLoaiCayTrongNhieu.setLayout(tvLoaiCayTrongNhieuLayout);
        tvLoaiCayTrongNhieuLayout.setHorizontalGroup(
            tvLoaiCayTrongNhieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tvLoaiCayTrongNhieuLayout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addGroup(tvLoaiCayTrongNhieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tvLoaiCayTrongNhieuLayout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(tvCntLonHonMax, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tvLoaiCayTrongNhieuLayout.createSequentialGroup()
                        .addGroup(tvLoaiCayTrongNhieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(tvLoaiCayTrongNhieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(tvLoaiCayTrongNhieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tvSoRuongVuong, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tvTongSoRuong, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(tvLoaiCayTrongNhieuLayout.createSequentialGroup()
                        .addGroup(tvLoaiCayTrongNhieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(tvLoaiCayTrongNhieuLayout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(tvCayNhieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(tvLoaiCayTrongNhieuLayout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(tvSoRuongCn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(349, 349, 349))
        );
        tvLoaiCayTrongNhieuLayout.setVerticalGroup(
            tvLoaiCayTrongNhieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tvLoaiCayTrongNhieuLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel8)
                .addGap(35, 35, 35)
                .addGroup(tvLoaiCayTrongNhieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tvTongSoRuong)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(tvLoaiCayTrongNhieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tvSoRuongVuong))
                .addGap(18, 18, 18)
                .addGroup(tvLoaiCayTrongNhieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tvSoRuongCn))
                .addGap(26, 26, 26)
                .addGroup(tvLoaiCayTrongNhieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(tvCayNhieu))
                .addGap(26, 26, 26)
                .addGroup(tvLoaiCayTrongNhieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(tvCntLonHonMax))
                .addContainerGap(320, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thong ke", tvLoaiCayTrongNhieu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edtMaRuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtMaRuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtMaRuongActionPerformed

    private void edtTenChuHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtTenChuHoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtTenChuHoActionPerformed

    private void edtCayTrongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCayTrongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtCayTrongActionPerformed

    private void edtChieuDaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtChieuDaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtChieuDaiActionPerformed

    private void edtChieuRongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtChieuRongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtChieuRongActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new DMainUI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveToFile;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton cbChuNhat;
    private javax.swing.JRadioButton cbVuong;
    private javax.swing.JTextField edtCayTrong;
    private javax.swing.JTextField edtChieuDai;
    private javax.swing.JTextField edtChieuRong;
    private javax.swing.JTextField edtMaRuong;
    private javax.swing.JTextField edtTenChuHo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbData;
    private javax.swing.JLabel tvCayNhieu;
    private javax.swing.JLabel tvChieuDai;
    private javax.swing.JLabel tvChieuRong;
    private javax.swing.JLabel tvCntLonHonMax;
    private javax.swing.JPanel tvLoaiCayTrongNhieu;
    private javax.swing.JLabel tvSoRuongCn;
    private javax.swing.JLabel tvSoRuongVuong;
    private javax.swing.JLabel tvTongSoRuong;
    // End of variables declaration//GEN-END:variables
}
