package k;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class K_UI extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(K_UI.class.getName());

    private List<HangHoa> listHangHoa = new ArrayList<>();

    public K_UI() {
        initComponents();
        initData();

        handlerClickable();

    }

    private void handlerClickable() {
        btnSearch.addActionListener((v) -> {
            String maHH = edtMaHh.getText();
            HangHoa hh = listHangHoa
                    .stream()
                    .filter((h) -> h.ma.equals(maHH))
                    .findFirst()
                    .orElse(null);
            if (hh != null) {
                lbHH.setText(hh.toString());
            } else {
                JOptionPane.showMessageDialog(null, "San pham khong ton tai");
            }
        });

        btnSort.addActionListener((v) -> {
            listHangHoa.sort((a, b) -> {
                if (a.tinhLoiNhuan() > b.tinhLoiNhuan()) {
                    return -1;
                } else if (a.tinhLoiNhuan() < b.tinhLoiNhuan()) {
                    return 1;
                }
                return 0;
            });

            listHangHoa.forEach((t) -> {
                System.out.println(t);
            });
        });
    }

    private void initData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("hanghoa.txt"))) {
            String line = null;
            while ((line = (reader.readLine())) != null) {
                String[] data = line.split(",");
                if (data[0].equals("1")) {
                    HangHoa hangHoa = new DienThoai(data[1], data[2], Double.parseDouble(data[3]), Double.parseDouble(data[4]), Double.parseDouble(data[5]));
                    listHangHoa.add(hangHoa);
                } else {
                    HangHoa hangHoa = new MayTinhBang(data[1], data[2], Double.parseDouble(data[3]), Double.parseDouble(data[4]), Double.parseDouble(data[5]));
                    listHangHoa.add(hangHoa);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Co loi trong qua trinh doc file");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSearch = new javax.swing.JButton();
        btnSort = new javax.swing.JButton();
        edtMaHh = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lbHH = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSearch.setText("Search");

        btnSort.setText("Sort");

        edtMaHh.addActionListener(this::edtMaHhActionPerformed);

        jLabel1.setText("Ma hang hoa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbHH, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(edtMaHh, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(btnSort, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSort, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtMaHh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(133, 133, 133)
                .addComponent(lbHH, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(274, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edtMaHhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtMaHhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtMaHhActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new K_UI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSort;
    private javax.swing.JTextField edtMaHh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbHH;
    // End of variables declaration//GEN-END:variables
}
