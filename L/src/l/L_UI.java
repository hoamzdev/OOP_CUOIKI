package l;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class L_UI extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(L_UI.class.getName());
    private List<NhanVien> listNV = new ArrayList<>();
    private DefaultTableModel mdBep;
    private DefaultTableModel mdTN;

    public L_UI() {
        initComponents();
        initTable();
        rdBep.setSelected(true);
        handleClickale();
    }

    private void handleClickale() {
        rdBep.addActionListener((v) -> {
            lbThuongChucVu.setVisible(true);
            edtThuongCV.setVisible(true);
            cbBepTruong_BietNN.setText("Bep truong");
            cbBepTruong_BietNN.setSelected(false);
        });

        rdThuNgan.addActionListener((v) -> {
            lbThuongChucVu.setVisible(false);
            edtThuongCV.setVisible(false);
            cbBepTruong_BietNN.setText("Biet ngoai ngu");
            cbBepTruong_BietNN.setSelected(false);
        });

        btnAdd.addActionListener((v) -> {
            String ten = edtTen.getText();
            String que = edtQueQuan.getText();
            String tn = edtThamNien.getText();
            int thamNien = 0;
            
            try{
                thamNien = Integer.parseInt(tn);
            }
            catch (NumberFormatException e) {
                showMsg("Tham nien phai la so");
                return;
            }
            
            String sglv = edtSoGioLm.getText();
            double soGioLamViec = 0;
            try {
                soGioLamViec = Double.parseDouble(sglv);
            } catch (NumberFormatException e) {
                showMsg("So gio lam viec phai la so");
                return;
            }

            if (rdBep.isSelected()) {
                boolean bepTruong = (cbBepTruong_BietNN.isSelected());
                String tcv = edtThuongCV.getText();
                double thuongChucVu = 0.0;
                try {
                    thuongChucVu = Integer.parseInt(tcv);
                } catch (NumberFormatException e) {
                    showMsg("Thuong chuc vu phai la so");
                    return;
                }
                NhanVien nv = new NhanVienBep(ten, thamNien, que, soGioLamViec, bepTruong, thuongChucVu);
                listNV.add(nv);
                mdBep.addRow(nv.toObject());
            } else {
                boolean bietNN = (cbBepTruong_BietNN.isSelected());
                NhanVien nv = new ThuNgan(ten, thamNien, que, soGioLamViec, bietNN);
                listNV.add(nv);
                mdTN.addRow(nv.toObject());
            }
            edtQueQuan.setText("");
            edtSoGioLm.setText("");
            edtTen.setText("");
            edtThamNien.setText("");
            edtThuongCV.setText("");
        });

        btnSave.addActionListener((v) -> {
            try (BufferedWriter w = new BufferedWriter(new FileWriter("nhanvien.txt"))) {
                for (NhanVien nv : listNV) {
                    if (nv instanceof NhanVienBep) {
                        w.write("1," + nv.toString());
                    } else if (nv instanceof ThuNgan) {
                        w.write("2," + nv.toString());
                    }
                    w.write("\n");
                }
                showMsg("Luu thanh cong");
            } catch (IOException e) {
                showMsg("Co loi tonrg qua trinh ghi file");
            }
        });
        
    }

    private void showMsg(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        edtTen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        edtThamNien = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        edtQueQuan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        edtSoGioLm = new javax.swing.JTextField();
        rdBep = new javax.swing.JRadioButton();
        rdThuNgan = new javax.swing.JRadioButton();
        cbBepTruong_BietNN = new javax.swing.JCheckBox();
        lbThuongChucVu = new javax.swing.JLabel();
        edtThuongCV = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbThuNgan = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbBep = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ho ten");

        jLabel2.setText("Tham nien (nam)");

        jLabel3.setText("Que quan");

        jLabel4.setText("So gio lam viec");

        buttonGroup1.add(rdBep);
        rdBep.setText("Nhan vien bep");

        buttonGroup1.add(rdThuNgan);
        rdThuNgan.setText("Nhan vien thu ngan");

        cbBepTruong_BietNN.setText("Bep truong");

        lbThuongChucVu.setText("Thuong chuc vu");

        btnSave.setText("Luu file");

        btnAdd.setText("Them");

        tbThuNgan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ho ten", "Tham nien", "Que quan", "So gio lam viec", "Biet ngoai ngu", "Luong"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbThuNgan);

        tbBep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ho ten", "Tham nien", "Que quan", "So gio lam viec", "Bep truong", "Thuong chuc vu", "Luong"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbBep);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtTen)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtThamNien)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtQueQuan)
                    .addComponent(edtSoGioLm)
                    .addComponent(rdBep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rdThuNgan, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(cbBepTruong_BietNN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbThuongChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edtThuongCV)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(119, 119, 119))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtThamNien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtSoGioLm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdBep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdThuNgan)
                        .addGap(30, 30, 30)
                        .addComponent(cbBepTruong_BietNN)
                        .addGap(18, 18, 18)
                        .addComponent(lbThuongChucVu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtThuongCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addGap(45, 45, 45))
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
        java.awt.EventQueue.invokeLater(() -> new L_UI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbBepTruong_BietNN;
    private javax.swing.JTextField edtQueQuan;
    private javax.swing.JTextField edtSoGioLm;
    private javax.swing.JTextField edtTen;
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
    private javax.swing.JTable tbBep;
    private javax.swing.JTable tbThuNgan;
    // End of variables declaration//GEN-END:variables

    private void initTable() {
        mdBep = new DefaultTableModel(new Object[]{"Ho ten", "Tham nien", "Que quan", "So gio lam viec", "Bep truong", "Thuong chuc vu", "Luong"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        mdTN = new DefaultTableModel(new Object[]{"Ho ten", "Tham nien", "Que quan", "So gio lam viec", "Biet ngoai ngu", "Luong"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbBep.setModel(mdBep);
        tbThuNgan.setModel(mdTN);
    }
}
