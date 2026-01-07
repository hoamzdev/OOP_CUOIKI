/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package c;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class UI extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(UI.class.getName());

    private DefaultTableModel modelTbShow;
    
    private List<MatHang> matHangs =  new ArrayList<>();
    
    public UI() {
        initComponents();
        
        modelTbShow = new DefaultTableModel(new Object[]{"Ma mat hang", "Ten", "So luong", "Gia tien tren menu"}, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tbShow.setModel(modelTbShow);
        
        initData();
        
        showAllMatHang(matHangs);
        
        btnSearch.addActionListener((v) -> {
            modelTbShow.setRowCount(0);
            String maHangInput = edtMaHang.getText();
            MatHang mhang = matHangs.stream().filter((mh) -> mh.maHang.equals(maHangInput))
                    .findFirst()
                    .orElse(null);
            if(mhang != null){         
                modelTbShow.setNumRows(0);
                modelTbShow.addRow(mhang.toObject());
            }
        });
        
        
        btnShowAll.addActionListener((v) -> {
            modelTbShow.setNumRows(0);
            showAllMatHang(matHangs);
        });
        
        btnSort.addActionListener((v) -> {
            List<MatHang> list = new ArrayList<>(matHangs);
            list.sort((a,b) -> {
                if(a.tinhGiaTrenMenu() > b.tinhGiaTrenMenu()){
                    return -1;
                }
                else if(a.tinhGiaTrenMenu() < b.tinhGiaTrenMenu()) return 1;
                return 0;
            });
            showAllMatHang(list);
        });
        
    }
    
    private void showAllMatHang(List<MatHang> list){ 
        modelTbShow.setRowCount(0);
        list.forEach((mh) -> {
                modelTbShow.addRow(mh.toObject());
            });
    }

    private void initData(){
        try(BufferedReader reader = new BufferedReader(new FileReader("mathang.txt"))){
            String line;
            while((line = reader.readLine()) != null){
                if(!line.isEmpty()){
                    String []mh = line.split(",");
                    String type = mh[0];
                    String maHang = mh[1];
                    String ten = mh[2];
                    int soLuong = Integer.parseInt(mh[3]);
                    double giaTien = Double.parseDouble(mh[4]);
                    if("1".equals(type)){
                        String td = mh[5];
                        boolean isTrinhDien = false;
                        if("true".equals(td)){
                            isTrinhDien = true;
                        }
                        matHangs.add(new MonAn(maHang,ten,soLuong,giaTien,isTrinhDien));
                    }
                    else{
                        String tt = mh[5];
                        boolean isCoNong = false;
                        if("true".equals(tt)){
                            isCoNong = true;
                        }
                        matHangs.add(new DoUong(maHang,ten,soLuong,giaTien,isCoNong));
                    }
                }
            }
        }catch(IOException e){
            System.out.println(e);
        }
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        edtMaHang = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnShowAll = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbShow = new javax.swing.JTable();
        btnSort = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setText("Ma hang");

        btnSearch.setText("tim kiem");

        btnShowAll.setText("Hien thi tat ca");

        tbShow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ma hang", "Ten Hang", "So luong", "Gia tien"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbShow);

        btnSort.setText("Xap xep");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(40, 40, 40)
                        .addComponent(edtMaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnSearch)
                        .addGap(52, 52, 52)
                        .addComponent(btnShowAll)))
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSort)
                .addGap(305, 305, 305))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(edtMaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(btnShowAll))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(btnSort)
                .addContainerGap(31, Short.MAX_VALUE))
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
        java.awt.EventQueue.invokeLater(() -> new UI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnShowAll;
    private javax.swing.JButton btnSort;
    private javax.swing.JTextField edtMaHang;
    private javax.swing.JTextField edtMaMh;
    private javax.swing.JTextField edtMaMh1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbSearch;
    private javax.swing.JTable tbSearch1;
    private javax.swing.JTable tbShow;
    // End of variables declaration//GEN-END:variables
}
