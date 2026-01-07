/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aa;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AA_UI extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AA_UI.class.getName());

    private DefaultTableModel mdThuNgan;
    private DefaultTableModel mdBep;
    
    private List<NhanVien> listNhanVien = new ArrayList<>();

    public AA_UI() {
        initComponents();

        mdThuNgan = new DefaultTableModel(new Object[]{"Ho ten", "Tham nien", "Que quan", "So gio lam viec", "Biet ngoai ngu", "Luong"},0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        mdBep = new DefaultTableModel(new Object[]{"Ho ten", "Tham nien", "Que quan", "So gio lam viec", "Thuong chuc vu", "Bep truong", "Luong"},0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbNhanVienThuNgan.setModel(mdThuNgan);
        tbBEp.setModel(mdBep);
        
        rdBep.setSelected(true);
        
        rdBep.addActionListener((v) -> {
            lbThuongChucVu.setVisible(true);
            edtThuongCV.setVisible(true);
            cbBepTruong_BietNgoaiNgu.setText("Bep truong");
        });
        
        rdThuNgan.addActionListener((v) -> {
            lbThuongChucVu.setVisible(false);
            edtThuongCV.setVisible(false);
            cbBepTruong_BietNgoaiNgu.setText("Biet ngoai ngu");
        });
        
        btnThem.addActionListener((v) -> {
            String ten = edtName.getText();
            String quequan = edtQuequan.getText();
            String tn = edtThamNien.getText();
            String shlv = edtSoGioLamViec.getText();
            float thamNien = 0.0F;
            float soGioLamViec = 0.0F;
            try{
                thamNien = Float.parseFloat(tn);
            }catch(NumberFormatException e){
                showMsg("Tham nien phai la so");
                return;
            }
            
            try{
                soGioLamViec = Float.parseFloat(shlv);
            }catch(NumberFormatException e){
                showMsg("So gio lam viec phai la so");
                return;
            }
            
            if(rdBep.isSelected()){
                boolean bepTruong = cbBepTruong_BietNgoaiNgu.isSelected();
                String thuongCV = edtThuongCV.getText();
                double thuongChucVu = 0.0F;
                try{
                    thuongChucVu = Double.parseDouble(thuongCV);
                }catch(NumberFormatException e){
                    showMsg("Thuong chuc vu phai la so");
                    return;
                }
                NhanVien bep = new NhanVienBep(ten, thamNien, quequan, soGioLamViec, bepTruong, thuongChucVu);
                mdBep.addRow(bep.toObject());
                listNhanVien.add(bep);
            }
            else{
                boolean bietNN = cbBepTruong_BietNgoaiNgu.isSelected();
                NhanVien thuNgan = new NhanVienThuNgan(ten, thamNien, quequan, soGioLamViec, bietNN);
                mdThuNgan.addRow(thuNgan.toObject());
                listNhanVien.add(thuNgan);
            }
        });
        
        btnLuuFile.addActionListener((v) -> {
            try(BufferedWriter w = new BufferedWriter(new FileWriter("nhanvien.txt"))){
                for(NhanVien nv : listNhanVien){
                    if(nv instanceof NhanVienBep){
                        w.write("1," + nv.toString());
                    }
                    else if(nv instanceof NhanVienThuNgan){
                        w.write("2," + nv.toString());
                    }
                    w.write("\n");
                }
                showMsg("Luu file thanh cong");
            }catch(IOException e){
                showMsg("Loi trong qua trinh luu file");
            }
        });
    }
    
    
    private void showMsg(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        edtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        edtThamNien = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        edtQuequan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        edtSoGioLamViec = new javax.swing.JTextField();
        rdBep = new javax.swing.JRadioButton();
        rdThuNgan = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnLuuFile = new javax.swing.JButton();
        lbThuongChucVu = new javax.swing.JLabel();
        edtThuongCV = new javax.swing.JTextField();
        cbBepTruong_BietNgoaiNgu = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBEp = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbNhanVienThuNgan = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ho ten");

        jLabel2.setText("Tham nien(nam)");

        jLabel3.setText("Que quan");

        jLabel4.setText("So gio lam viec");

        buttonGroup1.add(rdBep);
        rdBep.setText("Nhan vien bep");

        buttonGroup1.add(rdThuNgan);
        rdThuNgan.setText("Nhan vien thu ngan");

        btnThem.setText("Them");

        btnLuuFile.setText("Luu file");

        lbThuongChucVu.setText("Thuong chuc vu");

        cbBepTruong_BietNgoaiNgu.setText("Bep truong");

        tbBEp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ho ten", "Tham nien", "Que quan", "So gio lam viec", "Thuong chuc vu", "Bep truong", "Luong"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbBEp);

        tbNhanVienThuNgan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ho ten", "Tham nien", "Que quan", "So gio lam viec", "Biet ngoai ngu", "Luong"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbNhanVienThuNgan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(edtSoGioLamViec)
                    .addComponent(edtQuequan)
                    .addComponent(edtThamNien)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtName)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rdBep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rdThuNgan, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLuuFile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbThuongChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edtThuongCV)
                    .addComponent(cbBepTruong_BietNgoaiNgu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(0, 118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(edtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtThamNien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtQuequan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtSoGioLamViec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdBep))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdThuNgan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbBepTruong_BietNgoaiNgu)
                        .addGap(18, 18, 18)
                        .addComponent(lbThuongChucVu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtThuongCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnThem)
                        .addGap(18, 18, 18)
                        .addComponent(btnLuuFile)
                        .addGap(48, 48, 48))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(40, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        java.awt.EventQueue.invokeLater(() -> new AA_UI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuuFile;
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbBepTruong_BietNgoaiNgu;
    private javax.swing.JTextField edtName;
    private javax.swing.JTextField edtQuequan;
    private javax.swing.JTextField edtSoGioLamViec;
    private javax.swing.JTextField edtThamNien;
    private javax.swing.JTextField edtThuongCV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbThuongChucVu;
    private javax.swing.JRadioButton rdBep;
    private javax.swing.JRadioButton rdThuNgan;
    private javax.swing.JTable tbBEp;
    private javax.swing.JTable tbNhanVienThuNgan;
    // End of variables declaration//GEN-END:variables
}
