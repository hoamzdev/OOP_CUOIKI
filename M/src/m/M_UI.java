package m;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class M_UI extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(M_UI.class.getName());
    
    private List<MatHang> listMh = new ArrayList<>();

    public M_UI() {
        initComponents();
        initData();
        btnSearch.addActionListener((v) -> {
            String ma = edtMaMH.getText();
            List<MatHang> listSearched = listMh
                    .stream()
                    .filter((mh) -> mh.maMH.equals(ma))
                    .collect(Collectors.toList());

            if (listSearched.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Khong co san pham mong muon");
                edtMaMH.setText("");
                tvDataShow.setText("");
            }

            String data = "";
            for (MatHang mh : listSearched) {
                data += mh.toString();
                data += "\n";
            }
            tvDataShow.setText(data);
        });
        btnSort.addActionListener((v) -> {
            listMh.sort((a, b) -> {
                if (a.tinhGiaTrenMenu() > b.tinhGiaTrenMenu()) {
                    return -1;
                } else if (a.tinhGiaTrenMenu() < b.tinhGiaTrenMenu()) {
                    return 1;
                }
                return 0;
            });

            listMh.forEach((t) -> {
                System.out.println(t.toString());
            });
        });
    }

    private void initData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("mathang.txt"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals("1")) {
                    //uong
                    MatHang mh = new DoUong(data[1], data[2], Integer.parseInt(data[3]), Double.parseDouble(data[4]), Boolean.parseBoolean(data[5]));
                    listMh.add(mh);
                } else {
                    //an
                    MatHang mh = new MonAn(data[1], data[2], Integer.parseInt(data[3]), Double.parseDouble(data[4]), Boolean.parseBoolean(data[5]));
                    listMh.add(mh);
                }
            }
        } catch (IOException e) {
            JOptionPane.showConfirmDialog(null, "Loi trong qua trinh doc file");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        edtMaMH = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnSort = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tvDataShow = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nhap ma mat hang");

        btnSearch.setText("Tim kiem");

        btnSort.setText("Sap xep");

        tvDataShow.setColumns(20);
        tvDataShow.setRows(5);
        jScrollPane1.setViewportView(tvDataShow);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(btnSort, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(edtMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(btnSort))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        java.awt.EventQueue.invokeLater(() -> new M_UI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSort;
    private javax.swing.JTextField edtMaMH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea tvDataShow;
    // End of variables declaration//GEN-END:variables
}
