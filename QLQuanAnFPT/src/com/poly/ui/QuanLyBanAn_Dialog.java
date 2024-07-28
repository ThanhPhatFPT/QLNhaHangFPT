/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.poly.ui;

import com.poly.DAO.BanAnDAO;
import com.poly.DAO.KhuVucDAO;
import com.poly.entity.BanAn;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author votha
 */
public class QuanLyBanAn_Dialog extends javax.swing.JDialog {

    /**
     * Creates new form QuanLyBanAn_Dialog
     */
    public QuanLyBanAn_Dialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.initBanAn();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TrangThaiBanAn = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaBanAn = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenBanAn = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cboKhuVucBanAn = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        rdoBanTrong = new javax.swing.JRadioButton();
        rdoCoKhach = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBanAnTrong = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBanAnCoKhach = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý bàn ăn");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin bàn ăn"));

        jLabel2.setText("Mã bàn ăn:");

        jLabel3.setText("Tên bàn ăn:");

        jLabel4.setText("Khu vực bàn ăn:");

        cboKhuVucBanAn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Trạng thái:");

        jPanel6.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1);

        jButton2.setText("Cập nhật");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2);

        jButton3.setText("Xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton3);

        jButton4.setText("Làm mới");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton4);

        TrangThaiBanAn.add(rdoBanTrong);
        rdoBanTrong.setText("Bàn trống");

        TrangThaiBanAn.add(rdoCoKhach);
        rdoCoKhach.setText("Có khách");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtTenBanAn)
                        .addComponent(txtMaBanAn)
                        .addComponent(cboKhuVucBanAn, 0, 281, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdoBanTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(rdoCoKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(172, 172, 172)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaBanAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenBanAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(rdoBanTrong)
                            .addComponent(rdoCoKhach))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cboKhuVucBanAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách bàn ăn"));

        tblBanAnTrong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblBanAnTrong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBanAnTrongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBanAnTrong);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Bàn trống", jPanel4);

        tblBanAnCoKhach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblBanAnCoKhach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBanAnCoKhachMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBanAnCoKhach);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Có khách", jPanel5);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.insertBanAn();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.deleteBanAn();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.updateBanAn();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.refreshForm();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tblBanAnTrongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBanAnTrongMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblBanAnTrong.getSelectedRow();
        if (selectedRow == -1) {
            return; // No row is selected
        }

        // Get the selected row data
        String maBanAn = (String) tblBanAnTrong.getValueAt(selectedRow, 0);
        String tenBan = (String) tblBanAnTrong.getValueAt(selectedRow, 1);
        String trangThai = (String) tblBanAnTrong.getValueAt(selectedRow, 2);
        String maKhuVuc = (String) tblBanAnTrong.getValueAt(selectedRow, 3);

        // Set the data to form fields
        txtMaBanAn.setText(maBanAn);
        txtTenBanAn.setText(tenBan);
        rdoBanTrong.setSelected(trangThai.equals("Bàn trống"));
        rdoCoKhach.setSelected(trangThai.equals("Có khách"));
        cboKhuVucBanAn.setSelectedItem(maKhuVuc);
    }//GEN-LAST:event_tblBanAnTrongMouseClicked

    private void tblBanAnCoKhachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBanAnCoKhachMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblBanAnCoKhach.getSelectedRow();
        if (selectedRow == -1) {
            return;
        }

        String maBanAn = (String) tblBanAnCoKhach.getValueAt(selectedRow, 0);
        String tenBan = (String) tblBanAnCoKhach.getValueAt(selectedRow, 1);
        String trangThai = (String) tblBanAnCoKhach.getValueAt(selectedRow, 2);
        String maKhuVuc = (String) tblBanAnCoKhach.getValueAt(selectedRow, 3);

        txtMaBanAn.setText(maBanAn);
        txtTenBanAn.setText(tenBan);
//        rdoBanTrong.setSelected(trangThai.equals("Bàn trống"));
        rdoCoKhach.setSelected(trangThai.equals("Có khách"));
        cboKhuVucBanAn.setSelectedItem(maKhuVuc);

    }//GEN-LAST:event_tblBanAnCoKhachMouseClicked

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyBanAn_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyBanAn_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyBanAn_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyBanAn_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuanLyBanAn_Dialog dialog = new QuanLyBanAn_Dialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup TrangThaiBanAn;
    private javax.swing.JComboBox<String> cboKhuVucBanAn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdoBanTrong;
    private javax.swing.JRadioButton rdoCoKhach;
    private javax.swing.JTable tblBanAnCoKhach;
    private javax.swing.JTable tblBanAnTrong;
    private javax.swing.JTextField txtMaBanAn;
    private javax.swing.JTextField txtTenBanAn;
    // End of variables declaration//GEN-END:variables

    void initBanAn() {
        this.fillBanAnTrong();
        this.fillBanAnCoKhach();
        this.fillMaKhuVucBanAn();
    }

    public void fillBanAnTrong() {
        String[] columnNames = {
            "Mã bàn ăn",
            "Tên bàn ăn",
            "Trạng thái",
            "Mã khu vực"
        };

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tblBanAnTrong.setModel(model);

        BanAnDAO banAnDAO = new BanAnDAO();
        List<BanAn> list = banAnDAO.selectAll();

        for (BanAn banAn : list) {
            if (banAn.isTrangThai()) {
                Object[] row = new Object[]{
                    banAn.getMaBanAn(),
                    banAn.getTenBan(),
                    banAn.isTrangThai() ? "Bàn trống" : "có khách",
                    banAn.getMaKhuVuc()
                };
                model.addRow(row);
            }
        }
    }

    public void fillBanAnCoKhach() {
        String[] columnNames = {
            "Mã bàn ăn",
            "Tên bàn ăn",
            "Trạng thái",
            "Mã khu vực"
        };

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tblBanAnCoKhach.setModel(model);

        BanAnDAO banAnDAO = new BanAnDAO();
        List<BanAn> list = banAnDAO.selectAll();

        for (BanAn banAn : list) {
            if (!banAn.isTrangThai()) {
                Object[] row = new Object[]{
                    banAn.getMaBanAn(),
                    banAn.getTenBan(),
                    banAn.isTrangThai() ? "Bàn trống" : "có khách",
                    banAn.getMaKhuVuc()
                };
                model.addRow(row);
            }
        }
    }

    public void fillMaKhuVucBanAn() {
        KhuVucDAO khuVucDAO = new KhuVucDAO();
        List<String> khuVucNames = khuVucDAO.selectIdKhuVuc();

        cboKhuVucBanAn.removeAllItems();

        for (String name : khuVucNames) {
            cboKhuVucBanAn.addItem(name);
        }
    }

//    public void setForm(BanAn banAn) {
//        txtMaBanAn.setText(banAn.getMaBanAn());
//        txtTenBanAn.setText(banAn.getTenBan());
//        rdoBanTrong.setText(banAn.isTrangThai() ? "Bàn trống" : "Có khách");
//        cboKhuVucBanAn.setText(banAn.getMaKhuVuc());
//        txtBanAnGoc.setText(banAn.getBanAnGoc());
//    }
    public BanAn getForm() {
        BanAn banAn = new BanAn();
        banAn.setMaBanAn(txtMaBanAn.getText());
        banAn.setTenBan(txtTenBanAn.getText());
        banAn.setTrangThai(rdoBanTrong.isSelected());
        banAn.setMaKhuVuc(cboKhuVucBanAn.getSelectedItem().toString());

        return banAn;
    }

    public void insertBanAn() {
        try {
            BanAn banAn = getForm();
            BanAnDAO banAnDAO = new BanAnDAO();
            banAnDAO.insert(banAn);
            JOptionPane.showMessageDialog(this, "Thêm bàn ăn thành công!");
            fillBanAnTrong();
            fillBanAnCoKhach();
            refreshForm();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm bàn ăn: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteBanAn() {
        int selectedRow = tblBanAnTrong.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một bàn ăn để xóa.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String maBanAn = (String) tblBanAnTrong.getValueAt(selectedRow, 0);

        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa bàn ăn này?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                BanAnDAO banAnDAO = new BanAnDAO();
                banAnDAO.delete(maBanAn);
                JOptionPane.showMessageDialog(this, "Xóa bàn ăn thành công!");
                fillBanAnTrong();
                fillBanAnCoKhach();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lỗi khi xóa bàn ăn: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void updateBanAn() {
        BanAn banAn = getForm(); // Get the BanAn entity from form data

        if (banAn.getMaBanAn().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã bàn ăn.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn cập nhật bàn ăn này?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                BanAnDAO banAnDAO = new BanAnDAO();
                BanAn existingBanAn = banAnDAO.selectById(banAn.getMaBanAn());

                if (existingBanAn == null) {
                    JOptionPane.showMessageDialog(this, "Bàn ăn không tồn tại.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                banAnDAO.update(banAn);
                JOptionPane.showMessageDialog(this, "Cập nhật bàn ăn thành công!");
                fillBanAnTrong();
                fillBanAnCoKhach();
                refreshForm();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật bàn ăn: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void refreshForm() {
        txtMaBanAn.setText("");
        txtTenBanAn.setText("");
        rdoBanTrong.setSelected(true);
//        cboKhuVucBanAn.setSelectedIndex(0); // Reset to the first item in the combo box

    }

    public void setForm(BanAn banAn) {
        txtMaBanAn.setText(banAn.getMaBanAn());
        txtTenBanAn.setText(banAn.getTenBan());
        rdoBanTrong.setSelected(banAn.isTrangThai()); 
        rdoCoKhach.setSelected(!banAn.isTrangThai()); 
        cboKhuVucBanAn.setSelectedItem(banAn.getMaKhuVuc());

    }

}
