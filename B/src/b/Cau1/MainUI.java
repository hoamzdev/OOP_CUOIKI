package b.Cau1;

import b.Cau1.LopHoc;
import b.Cau1.SinhVien;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MainUI extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainUI.class.getName());

    private DefaultTableModel modelEditClass;
    private DefaultTableModel modelShowClass;

    private List<LopHoc> lopHocs;
    private LopHoc lopHoc;

    public MainUI() {
        initComponents();
        lopHocs = new ArrayList<>();
        btnAdd.setBackground(Color.green);
        initTable();
        btnAdd.addActionListener((v) -> {
            handlerAddSinhVien();
        });
        btnAddClass.addActionListener((v) -> {
            hanlderAddClass();
        });
        btnSave.addActionListener((v) -> {
            handlerClickSave();
        });
        btnShow.addActionListener((v) -> handlerShowSinhVien());
    }

    private void handlerShowSinhVien() {
        String tenLop = (String) cbbTenLop.getSelectedItem();
        List<SinhVien> listSinhVien = getSinhVienByLop(tenLop);
        modelShowClass.setRowCount(0);
        listSinhVien.forEach((sv) -> {
            modelShowClass.addRow(sv.toObject());
        });
    }

    //luu lop hoc vao list lop hoc
    private void handlerClickSave() {
        lopHocs.add(lopHoc);
    }

    //tao lop
    private void hanlderAddClass() {
        String tenLop = edtTenLop.getText();
        String ss = edtSiSo.getText();
        int siSo = 0;
        try {
            siSo = Integer.parseInt(ss);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Si so phai la so");
            edtSiSo.requestFocus();
        }
        //add lop hoc
        lopHoc = new LopHoc(siSo, tenLop);
        modelEditClass.setRowCount(0);
        //cho nen combobox
        cbbTenLop.addItem(tenLop);
    }

    //them sinh vien vao lop
    private void handlerAddSinhVien() {
        String msv = edtMaSv.getText();
        String hoTen = edtHoTen.getText();
        String dqt = edtDiemQt.getText();
        double diemQuaTrinh = 0.0;
        String dhp = edtDiemHp.getText();
        double diemHocPhan = 0.0;

        if (msv.isEmpty() || hoTen.isEmpty() || dhp.isEmpty() || dqt.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Khong duoc bo trong");
        }

        try {
            diemQuaTrinh = Double.parseDouble(dqt);
            if (diemQuaTrinh < 0.0 || diemQuaTrinh > 10.0) {
                JOptionPane.showMessageDialog(null, "Diem phai >= 0 va <= 10");
                edtDiemQt.requestFocus();
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Diem phai la so");
            edtDiemQt.requestFocus();
            return;
        }

        try {
            diemHocPhan = Double.parseDouble(dhp);
            if (diemHocPhan < 0.0 || diemHocPhan > 10.0) {
                JOptionPane.showMessageDialog(null, "Diem phai >= 0 va <= 10");
                edtDiemHp.requestFocus();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Diem phai la so");
            edtDiemHp.requestFocus();
        }
        
        SinhVien sv = new SinhVien(msv, hoTen, diemHocPhan, diemQuaTrinh);
        if(lopHoc == null){
            JOptionPane.showMessageDialog(null, "Lop chua duoc khoi tao");
        }
        else{
            modelEditClass.addRow(sv.toObject());
            lopHoc.addSinhVien(sv);
            edtDiemHp.setText("");
            edtDiemQt.setText("");
            edtHoTen.setText("");
            edtMaSv.setText("");
        }
    }

    private void initTable() {
        modelEditClass = new DefaultTableModel(new Object[]{"Mã SV", "Họ tên", "Điểm quá trình", "Điểm học phần"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modelShowClass = new DefaultTableModel(new Object[]{"Mã SV", "Họ tên", "Điểm quá trình", "Điểm học phần"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tbClass.setModel(modelEditClass);
        tbShowClass.setModel(modelShowClass);
    }

    //loc du lieu sinh vien theo lop
    private List<SinhVien> getSinhVienByLop(String tenLop) {
        LopHoc lhoc = lopHocs.stream()
                .filter((lh) -> lh.getTenLop().equals(tenLop))
                .findFirst()
                .orElse(null);
        if (lhoc != null) {
            return lhoc.getListSV();
        }
        return new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnShow = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbShowClass = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        cbbTenLop = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        edtHoTen = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        edtDiemHp = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        edtSiSo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        edtTenLop = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        edtMaSv = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        edtDiemQt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbClass = new javax.swing.JTable();
        btnAddClass = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel8.setText("Nhập lớp :");

        btnShow.setText("Hiển thị");

        tbShowClass.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SV", "Họ tên", "Điểm quá trình", "Điểm học phần", "Điểm trung bình"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbShowClass);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Hiển thị danh sách lớp");

        cbbTenLop.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnShow))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(cbbTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnShow))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hiển thị", jPanel2);

        btnAdd.setText("Thêm");

        jLabel5.setText("Họ tên");

        jLabel6.setText("Điểm học phần");

        edtDiemHp.addActionListener(this::edtDiemHpActionPerformed);

        jLabel1.setText("Sĩ Số: ");

        edtSiSo.addActionListener(this::edtSiSoActionPerformed);

        jLabel2.setText("Tên Lớp");

        edtTenLop.addActionListener(this::edtTenLopActionPerformed);

        jLabel3.setBackground(new java.awt.Color(153, 51, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Thêm sinh viên");

        jLabel4.setText("Mã sinh viên");

        edtMaSv.addActionListener(this::edtMaSvActionPerformed);

        jLabel7.setText("Điểm quá trình");

        edtDiemQt.addActionListener(this::edtDiemQtActionPerformed);

        tbClass.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SV", "Họ tên", "Điểm quá trình", "Điểm học phần", "Điểm trung bình"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbClass);

        btnAddClass.setText("Tạo lớp");

        btnSave.setText("Luu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtSiSo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddClass))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(edtDiemQt, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(edtMaSv)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(edtHoTen)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(edtDiemHp)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(edtSiSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(edtTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddClass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(edtMaSv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(edtDiemHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(edtDiemQt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSave)
                        .addGap(35, 35, 35))))
        );

        jTabbedPane1.addTab("Edit", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edtTenLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtTenLopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtTenLopActionPerformed

    private void edtDiemQtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtDiemQtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtDiemQtActionPerformed

    private void edtDiemHpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtDiemHpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtDiemHpActionPerformed

    private void edtMaSvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtMaSvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtMaSvActionPerformed

    private void edtSiSoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtSiSoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtSiSoActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new MainUI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddClass;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnShow;
    private javax.swing.JComboBox<String> cbbTenLop;
    private javax.swing.JTextField edtDiemHp;
    private javax.swing.JTextField edtDiemQt;
    private javax.swing.JTextField edtHoTen;
    private javax.swing.JTextField edtMaSv;
    private javax.swing.JTextField edtSiSo;
    private javax.swing.JTextField edtTenLop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbClass;
    private javax.swing.JTable tbShowClass;
    // End of variables declaration//GEN-END:variables
}
