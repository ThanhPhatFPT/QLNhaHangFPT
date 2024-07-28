/*  
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.poly.ui;

import com.poly.DAO.BanAnDAO;
import com.poly.DAO.KhuVucDAO;
import com.poly.DAO.LoaiMonAnDAO;
import com.poly.DAO.MonAnDAO;
import com.poly.DAO.NhanVienDAO;

import com.poly.entity.BanAn;
import com.poly.entity.LoaiMonAn;
import com.poly.entity.MonAn;
import com.poly.entity.NhanVien;

import com.poly.utils.Auth;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import com.poly.utils.MsgBox;
import com.poly.utils.XDate;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.Timer;

/**
 *
 * @author votha
 */
public class Home_Frm extends javax.swing.JFrame {

    // Biến ChiTietBanAn1 đã được tạo từ công cụ thiết kế GUI
//    private javax.swing.JPanel ChiTietBanAn1;
    public Home_Frm() {
        initComponents(); // Khởi tạo các thành phần giao diện từ công cụ thiết kế
        setLocationRelativeTo(null); // Đặt cửa sổ ở giữa màn hình
        this.initMonAn();
        this.initNhanVien();
//        this.initTaiKhoan();
        fillBanAN();
        new DanhNhap(this, true).setVisible(true);// Gọi phương thức để cập nhật dữ liệu
        this.initBanAN();

    }

    void openDoiMatKhau() {
        if (Auth.isLogin()) {
            new DoiMatKhauJDialog(this, true).setVisible(true);
        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập!");
        }
    }

    void dangXuat() {
        Auth.clear();
        new DanhNhap(this, true).setVisible(true);
    }

    void ketThuc() {
        if (MsgBox.confirm(this, "Bạn muốn kết thúc làm việc?")) {
            System.exit(0);
        }
    }

    public void fillBanAN() {
        // Tạo DAO và lấy dữ liệu
        BanAnDAO dao = new BanAnDAO();
        List<BanAn> list = dao.selectAll();

        // Xóa tất cả các component cũ trong KhuVucNgoaiTroiPanel
        KhuVucNgoaiTroiPanel.removeAll();

        // Sử dụng GridBagLayout cho KhuVucNgoaiTroiPanel
        KhuVucNgoaiTroiPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Khoảng cách giữa các panel
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        int count = 0; // Đếm số lượng panel đã thêm
        int maxColumns = 4; // Số lượng item tối đa trên mỗi hàng

        for (BanAn banAn : list) {
            if (count >= 15) {
                break; // Dừng lại sau khi đã thêm 10 item
            }

            // Tạo và cấu hình panel
            if ("KV02".equals(banAn.getMaKhuVuc())) { // Giả sử phương thức getId() trả về ID của bàn
                // Tạo và cấu hình panel
                JPanel panel = new JPanel();
                panel.setPreferredSize(new Dimension(100, 100)); // Kích thước của panel
                panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel.setBackground(Color.GREEN); // Màu nền xanh lá cây
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

                // Thêm nhãn vào panel
                JLabel tenBanLabel = new JLabel("" + banAn.getTenBan());
                tenBanLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                tenBanLabel.setFont(new Font("Arial", Font.BOLD, 10));
                panel.add(Box.createVerticalGlue()); // Thêm glue để căn giữa theo chiều dọc
                panel.add(tenBanLabel);
                panel.add(Box.createVerticalGlue()); // Thêm glue để căn giữa theo chiều dọc

                // Cài đặt GridBagConstraints cho panel
                gbc.gridx = count % maxColumns; // Xác định cột dựa trên số lượng đã thêm
                gbc.gridy = count / maxColumns; // Xác định dòng dựa trên số lượng đã thêm

                // Thêm panel vào KhuVucNgoaiTroiPanel
                KhuVucNgoaiTroiPanel.add(panel, gbc);

                count++; // Tăng số lượng panel đã thêm
            }
        }
        // Cập nhật giao diện
        KhuVucNgoaiTroiPanel.revalidate();
        KhuVucNgoaiTroiPanel.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        grbTrangThaiMA = new javax.swing.ButtonGroup();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        grbGender = new javax.swing.ButtonGroup();
        grpChucVu = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        KhuVucNgoaiTroiPanel = new javax.swing.JPanel();
        KhuVucPhongLanhPanel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblKhuVucPhongLanh = new javax.swing.JTable();
        KhuVucSanhPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblKhuVucSanh = new javax.swing.JTable();
        ChiTietBanAn = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        CboKhuVuc = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaKhachHangBD = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSoDienThoaiDB = new javax.swing.JTextField();
        txtNgayDB = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTienCoc = new javax.swing.JTextField();
        txtTenBanAnDB = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtMoTaBD = new javax.swing.JTextArea();
        btnDacBan = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel25 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtMaMA = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtTenMA = new javax.swing.JTextField();
        txtGiaMA = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMoTaMA = new javax.swing.JTextArea();
        chkLoaiMA = new javax.swing.JComboBox<>();
        jPanel34 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        lblHinhMA = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtDVTMA = new javax.swing.JTextField();
        rdoYes = new javax.swing.JRadioButton();
        rdoNo = new javax.swing.JRadioButton();
        jPanel29 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        btnThemMA = new javax.swing.JButton();
        btnSuaMA = new javax.swing.JButton();
        btnXoaMonAn = new javax.swing.JButton();
        btnLamMoiMA = new javax.swing.JButton();
        btnCapNhatMA = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblMonAn = new javax.swing.JTable();
        jPanel37 = new javax.swing.JPanel();
        txtTimKiemMA = new javax.swing.JTextField();
        btnTimKiemMA = new javax.swing.JButton();
        jPanel38 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtCCCD = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        rdoQuanLi = new javax.swing.JRadioButton();
        rdoNhanVien = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        lblHinhNV = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jPanel44 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        txtTimKiemNV = new javax.swing.JTextField();
        btnTimKiemNV = new javax.swing.JButton();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel43 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jPanel48 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblNhanVien2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();

        jTextField2.setText("jTextField1");

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel7.setBackground(new java.awt.Color(255, 153, 102));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton3.setText("Chuyển bàn");

        jButton4.setText("Cập nhật");

        jButton5.setText("Thêm Bàn");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Gộp Bàn");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setLayout(new java.awt.CardLayout());

        KhuVucNgoaiTroiPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Ngoài trời"));

        javax.swing.GroupLayout KhuVucNgoaiTroiPanelLayout = new javax.swing.GroupLayout(KhuVucNgoaiTroiPanel);
        KhuVucNgoaiTroiPanel.setLayout(KhuVucNgoaiTroiPanelLayout);
        KhuVucNgoaiTroiPanelLayout.setHorizontalGroup(
            KhuVucNgoaiTroiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
        );
        KhuVucNgoaiTroiPanelLayout.setVerticalGroup(
            KhuVucNgoaiTroiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
        );

        jPanel8.add(KhuVucNgoaiTroiPanel, "card3");

        KhuVucPhongLanhPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Phòng lạnh"));

        tblKhuVucPhongLanh.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(tblKhuVucPhongLanh);

        javax.swing.GroupLayout KhuVucPhongLanhPanelLayout = new javax.swing.GroupLayout(KhuVucPhongLanhPanel);
        KhuVucPhongLanhPanel.setLayout(KhuVucPhongLanhPanelLayout);
        KhuVucPhongLanhPanelLayout.setHorizontalGroup(
            KhuVucPhongLanhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhuVucPhongLanhPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addContainerGap())
        );
        KhuVucPhongLanhPanelLayout.setVerticalGroup(
            KhuVucPhongLanhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KhuVucPhongLanhPanelLayout.createSequentialGroup()
                .addContainerGap(300, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel8.add(KhuVucPhongLanhPanel, "card4");

        KhuVucSanhPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Sảnh"));

        tblKhuVucSanh.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tblKhuVucSanh);

        javax.swing.GroupLayout KhuVucSanhPanelLayout = new javax.swing.GroupLayout(KhuVucSanhPanel);
        KhuVucSanhPanel.setLayout(KhuVucSanhPanelLayout);
        KhuVucSanhPanelLayout.setHorizontalGroup(
            KhuVucSanhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhuVucSanhPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addContainerGap())
        );
        KhuVucSanhPanelLayout.setVerticalGroup(
            KhuVucSanhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KhuVucSanhPanelLayout.createSequentialGroup()
                .addContainerGap(142, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel8.add(KhuVucSanhPanel, "card2");

        ChiTietBanAn.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Chi tiết đặt bàn"));

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin bàn ăn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin đặc bàn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton7.setText("Hủy thông tin đặc bàn");

        javax.swing.GroupLayout ChiTietBanAnLayout = new javax.swing.GroupLayout(ChiTietBanAn);
        ChiTietBanAn.setLayout(ChiTietBanAnLayout);
        ChiTietBanAnLayout.setHorizontalGroup(
            ChiTietBanAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ChiTietBanAnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ChiTietBanAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        ChiTietBanAnLayout.setVerticalGroup(
            ChiTietBanAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ChiTietBanAnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        CboKhuVuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CboKhuVuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CboKhuVucMouseClicked(evt);
            }
        });

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Đặc Bàn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Họ tên khách hàng:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Số điện thoại:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Ngày đặt:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Tiền cọc");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Tên bàn:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Mô tả");

        txtMoTaBD.setColumns(20);
        txtMoTaBD.setRows(5);
        jScrollPane8.setViewportView(txtMoTaBD);

        btnDacBan.setText("Đặt bàn");
        btnDacBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDacBanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaKhachHangBD)
                    .addComponent(txtSoDienThoaiDB, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                .addGap(94, 94, 94)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(46, 46, 46)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNgayDB)
                    .addComponent(txtTienCoc, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                .addGap(65, 65, 65)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(txtTenBanAnDB))
                .addGap(53, 53, 53)
                .addComponent(btnDacBan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaKhachHangBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenBanAnDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtSoDienThoaiDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtTienCoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnDacBan, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CboKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChiTietBanAn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(CboKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(ChiTietBanAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Trang Chủ", jPanel6);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1348, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Đổi mật khẩu", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1348, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Doanh thu", jPanel5);

        jPanel1.add(jTabbedPane2);

        jTabbedPane1.addTab("Hệ thống", jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel27.setBackground(new java.awt.Color(255, 204, 102));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("QUẢN LÝ MÓN ĂN");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel31.setBackground(new java.awt.Color(204, 204, 204));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Thông tin món ăn");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        jLabel15.setText("Mã món:");

        txtMaMA.setEditable(false);

        jLabel16.setText("Tên món:");

        jLabel17.setText("Giá:");

        jLabel18.setText("Mô tả:");

        jLabel19.setText("Loại món:");

        txtMoTaMA.setColumns(20);
        txtMoTaMA.setRows(5);
        jScrollPane3.setViewportView(txtMoTaMA);

        chkLoaiMA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder("Hình ảnh"));

        jPanel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblHinhMA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHinhMA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhMAMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinhMA, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinhMA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel21.setText("DVT:");

        grbTrangThaiMA.add(rdoYes);
        rdoYes.setText("Đang bán");

        grbTrangThaiMA.add(rdoNo);
        rdoNo.setText("Tạm ngưng");
        rdoNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel15))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaMA)
                                    .addComponent(txtTenMA)))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkLoaiMA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDVTMA)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel28Layout.createSequentialGroup()
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel28Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoYes, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdoNo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE))
                                    .addGroup(jPanel28Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(txtGiaMA))))))
                        .addGap(9, 9, 9))
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtMaMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtTenMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkLoaiMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtDVTMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtGiaMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoYes)
                    .addComponent(rdoNo))
                .addGap(11, 11, 11)
                .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel32.setBackground(new java.awt.Color(204, 204, 204));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Xử lý");

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        jPanel36.setLayout(new java.awt.GridLayout(0, 1, 0, 20));

        btnThemMA.setText("Thêm");
        btnThemMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMAActionPerformed(evt);
            }
        });
        jPanel36.add(btnThemMA);

        btnSuaMA.setText("Sửa");
        btnSuaMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaMAActionPerformed(evt);
            }
        });
        jPanel36.add(btnSuaMA);

        btnXoaMonAn.setText("Trạng thái");
        btnXoaMonAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMonAnActionPerformed(evt);
            }
        });
        jPanel36.add(btnXoaMonAn);

        btnLamMoiMA.setText("Làm mới");
        btnLamMoiMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiMAActionPerformed(evt);
            }
        });
        jPanel36.add(btnLamMoiMA);

        btnCapNhatMA.setText("Cập nhật");
        jPanel36.add(btnCapNhatMA);

        jButton1.setText("jButton1");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel33.setBackground(new java.awt.Color(204, 204, 204));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Danh sách thực đơn");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        tblMonAn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        tblMonAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMonAnMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblMonAn);

        btnTimKiemMA.setText("Tìm kiếm");
        btnTimKiemMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemMAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addComponent(txtTimKiemMA)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiemMA))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemMA))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 31, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane4.addTab("Món Ăn", jPanel25);

        jPanel39.setBackground(new java.awt.Color(255, 204, 102));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("QUẢN LÝ NHÂN VIÊN");

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 1164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 184, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
        );

        jPanel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel41.setBackground(new java.awt.Color(204, 204, 204));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Thông tin nhân viên");

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel23.setText("Mã nhân viên");

        jLabel24.setText("Họ và Tên");

        jLabel25.setText("Số Điện Thoại");

        jLabel26.setText("CCCD");

        jLabel27.setText("Ngày Sinh");

        jLabel28.setText("Giới Tính:");

        jLabel30.setText("Địa Chỉ");

        jLabel31.setText("Chức Vụ");

        jLabel32.setText("Hình nhân viên");

        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder("Xử Lý"));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel42.add(btnThem);

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel42.add(btnXoa);

        btnCapNhat.setText("Cập Nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });
        jPanel42.add(btnCapNhat);

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        jPanel42.add(btnLamMoi);

        jButton2.setText("jButton2");
        jPanel42.add(jButton2);

        grbGender.add(rdoNam);
        rdoNam.setText("Nam");

        grbGender.add(rdoNu);
        rdoNu.setText("Nữ");

        grpChucVu.add(rdoQuanLi);
        rdoQuanLi.setText("Quản Lý");
        rdoQuanLi.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        grpChucVu.add(rdoNhanVien);
        rdoNhanVien.setText("Nhân Viên");
        rdoNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblHinhNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHinhNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhNVMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinhNV, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinhNV, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
        );

        jLabel36.setText("Mật khẩu:");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel40Layout.createSequentialGroup()
                                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel40Layout.createSequentialGroup()
                                        .addComponent(rdoNam)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdoNu)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel40Layout.createSequentialGroup()
                                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMaNV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                            .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel40Layout.createSequentialGroup()
                                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel40Layout.createSequentialGroup()
                                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPassword))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel40Layout.createSequentialGroup()
                                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(37, 37, 37)
                                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCCCD)
                                            .addComponent(txtDiaChi)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel40Layout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSDT)))
                                .addGap(108, 108, 108)))
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel40Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel40Layout.createSequentialGroup()
                                .addComponent(rdoQuanLi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoNhanVien)))))
                .addGap(17, 17, 17))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel31)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoQuanLi)
                    .addComponent(rdoNhanVien))
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel45.setBackground(new java.awt.Color(204, 204, 204));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setText("Danh sách nhân viên");

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnTimKiemNV.setText("Tìm kiếm");
        btnTimKiemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addComponent(txtTimKiemNV)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiemNV))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemNV))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblNhanVien);

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
        );

        jTabbedPane5.addTab("Đang Làm", jPanel43);

        tblNhanVien2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11"
            }
        ));
        tblNhanVien2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblNhanVien2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVien2MouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblNhanVien2);

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane5.addTab("Đã Nghỉ", jPanel48);

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel46, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane5)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane4.addTab("Nhân Viên", jPanel38);

        jPanel2.add(jTabbedPane4, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.addTab("Quản lý", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1348, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Thống kê", jPanel3);

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

    private void tblNhanVien2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVien2MouseClicked
        // TODO add your handling code here:
        int selectedRow = tblNhanVien2.getSelectedRow();

        if (selectedRow != -1) { // Ensure a row is selected
            // Retrieve the table model
            DefaultTableModel model = (DefaultTableModel) tblNhanVien2.getModel();

            // Get data from the selected row
            String maNV = (String) model.getValueAt(selectedRow, 0); // "Mã NV"
            String hoTenNV = (String) model.getValueAt(selectedRow, 1); // "Họ Tên NV"
            boolean gioiTinh = "Nam".equals(model.getValueAt(selectedRow, 2)); // "Giới Tính"
            Date ngaySinh = XDate.toDate((String) model.getValueAt(selectedRow, 3), "dd/MM/yyyy"); // "Ngày Sinh"
            String sdtNV = (String) model.getValueAt(selectedRow, 4); // "Số Điện Thoại"
            String cccd = (String) model.getValueAt(selectedRow, 5); // "CCCD"
            String diaChi = (String) model.getValueAt(selectedRow, 6); // "Địa Chỉ"
            boolean chucVu = "Quản Lý".equals(model.getValueAt(selectedRow, 7)); // "Chức Vụ"
            Date ngayVaoLam = XDate.toDate((String) model.getValueAt(selectedRow, 8), "dd/MM/yyyy"); // "Ngày Vào Làm"
            String anhNhanVien = (String) model.getValueAt(selectedRow, 10); // "Hình Ảnh"
            String matKhau = (String) model.getValueAt(selectedRow, 11);

            // Create a NhanVien object and set its fields
            NhanVien nv = new NhanVien();
            nv.setMaNV(maNV);
            nv.setHoTenNV(hoTenNV);
            nv.setGioiTinh(gioiTinh);
            nv.setNgaySinh(ngaySinh);
            nv.setSdtNV(sdtNV);
            nv.setCccd(cccd);
            nv.setDiaChi(diaChi);
            nv.setChucVu(chucVu);
            nv.setNgayVaoLam(ngayVaoLam);
            nv.setHinhAnhNV(anhNhanVien);
            nv.setMatKhau(matKhau);

            // Populate the form with the selected data
            setFormNV(nv);
        }
    }//GEN-LAST:event_tblNhanVien2MouseClicked

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblNhanVien.getSelectedRow();

        if (selectedRow != -1) { // Ensure a row is selected
            // Retrieve the table model
            DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();

            // Get data from the selected row
            String maNV = (String) model.getValueAt(selectedRow, 0); // "Mã NV"
            String hoTenNV = (String) model.getValueAt(selectedRow, 1); // "Họ Tên NV"
            boolean gioiTinh = "Nam".equals(model.getValueAt(selectedRow, 2)); // "Giới Tính"
            Date ngaySinh = XDate.toDate((String) model.getValueAt(selectedRow, 3), "dd/MM/yyyy"); // "Ngày Sinh"
            String sdtNV = (String) model.getValueAt(selectedRow, 4); // "Số Điện Thoại"
            String cccd = (String) model.getValueAt(selectedRow, 5); // "CCCD"
            String diaChi = (String) model.getValueAt(selectedRow, 6); // "Địa Chỉ"
            boolean chucVu = "Quản Lý".equals(model.getValueAt(selectedRow, 7)); // "Chức Vụ"
            Date ngayVaoLam = XDate.toDate((String) model.getValueAt(selectedRow, 8), "dd/MM/yyyy"); // "Ngày Vào Làm"
            String anhNhanVien = (String) model.getValueAt(selectedRow, 10); // "Hình Ảnh"
            String matKhau = (String) model.getValueAt(selectedRow, 11);

            // Create a NhanVien object and set its fields
            NhanVien nv = new NhanVien();
            nv.setMaNV(maNV);
            nv.setHoTenNV(hoTenNV);
            nv.setGioiTinh(gioiTinh);
            nv.setNgaySinh(ngaySinh);
            nv.setSdtNV(sdtNV);
            nv.setCccd(cccd);
            nv.setDiaChi(diaChi);
            nv.setChucVu(chucVu);
            nv.setNgayVaoLam(ngayVaoLam);
            nv.setHinhAnhNV(anhNhanVien);
            nv.setMatKhau(matKhau);
            // Populate the form with the selected data
            setFormNV(nv);
        }
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnTimKiemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemNVActionPerformed
        // TODO add your handling code here:
        this.searchNV();
    }//GEN-LAST:event_btnTimKiemNVActionPerformed

    private void lblHinhNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhNVMouseClicked
        // TODO add your handling code here:
        this.chonAnhNV();
    }//GEN-LAST:event_lblHinhNVMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        this.clearFormNV();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        this.updateNV();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        this.deleteNV();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        this.insertNV();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnTimKiemMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemMAActionPerformed
        //         TODO add your handling code here:
        this.findMonAn();
    }//GEN-LAST:event_btnTimKiemMAActionPerformed

    private void tblMonAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMonAnMouseClicked
        // TODO add your handling code here:
        int row = tblMonAn.getSelectedRow();

        if (row >= 0) {
            // Lấy giá trị từ các ô trong dòng được chọn
            int maMonAn = (int) tblMonAn.getValueAt(row, 0); // Giả sử cột đầu tiên chứa mã món ăn
            String tenMonAn = (String) tblMonAn.getValueAt(row, 1); // Tên món ăn
            String loaiMonAn = (String) tblMonAn.getValueAt(row, 2); // Loại món ăn
            String dvt = (String) tblMonAn.getValueAt(row, 3); // Đơn vị tính
            double donGia = (double) tblMonAn.getValueAt(row, 4); // Đơn giá
            String moTa = (String) tblMonAn.getValueAt(row, 5); // Mô tả
            String trangThaiStr = (String) tblMonAn.getValueAt(row, 6); // Trạng thái
            String hinhMonAn = (String) tblMonAn.getValueAt(row, 7); // Trạng thái
            // Xử lý trạng thái
            boolean trangThai = "Đang bán".equals(trangThaiStr);

            // Tạo đối tượng MonAn với dữ liệu từ bảng
            MonAn monAn = new MonAn();
            monAn.setMaMonAn(maMonAn);
            monAn.setTenMonAn(tenMonAn);

            // Lấy mã loại món ăn từ danh sách
            int maLoaiMon = loaiMonAnDAO.selectAll().stream()
                    .filter(loai -> loai.getTenLoaiMon().equals(loaiMonAn))
                    .findFirst()
                    .map(LoaiMonAn::getMaLoaiMon)
                    .orElse(null);
            monAn.setMaLoaiMon(maLoaiMon);
            monAn.setDvt(dvt);
            monAn.setDonGia(donGia);
            monAn.setMoTa(moTa);
            monAn.setTrangThai(trangThai);
            monAn.setHinhAnhMonAn(hinhMonAn);

            // Cập nhật form với dữ liệu của món ăn đã chọn
            setFormMonAn(monAn);
        }
    }//GEN-LAST:event_tblMonAnMouseClicked

    private void btnLamMoiMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiMAActionPerformed
        // TODO add your handling code here:
        this.clearFormMonAn();
    }//GEN-LAST:event_btnLamMoiMAActionPerformed

    private void btnXoaMonAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMonAnActionPerformed
        // TODO add your handling code here:
        this.TrangThaiMonAn();
    }//GEN-LAST:event_btnXoaMonAnActionPerformed

    private void btnSuaMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaMAActionPerformed
        // TODO add your handling code here:
        this.updateMonAn();
    }//GEN-LAST:event_btnSuaMAActionPerformed

    private void btnThemMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMAActionPerformed
        // TODO add your handling code here:\
        this.insertMonAn();
    }//GEN-LAST:event_btnThemMAActionPerformed

    private void rdoNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNoActionPerformed

    private void lblHinhMAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMAMouseClicked
        // TODO add your handling code here:
        this.chonAnhMonAn();
    }//GEN-LAST:event_lblHinhMAMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        QuanLyBanAn_Dialog banAn_Dialog = new QuanLyBanAn_Dialog(this, true);
        banAn_Dialog.setVisible(true);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void CboKhuVucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CboKhuVucMouseClicked
        // TODO add your handling code here:
        String selectedKhuVuc = (String) CboKhuVuc.getSelectedItem();

        // Ẩn tất cả các panel trước khi hiển thị panel mới
        KhuVucNgoaiTroiPanel.setVisible(false);
        KhuVucSanhPanel.setVisible(false);
        KhuVucPhongLanhPanel.setVisible(false);

        if ("Ngoài trời".equals(selectedKhuVuc)) {
            fillBanANKhuVucNgoaiTroi();
            KhuVucNgoaiTroiPanel.setVisible(true);
        } else if ("Sảnh".equals(selectedKhuVuc)) {
            fillBanANKhuVucSanh();
            KhuVucSanhPanel.setVisible(true);
        } else if ("Phòng lạnh".equals(selectedKhuVuc)) {
            fillBanANKhuVucPhongLanh();
            KhuVucPhongLanhPanel.setVisible(true);
        } else {
            // Nếu cần, xử lý trường hợp không hợp lệ hoặc mặc định
        }
    }//GEN-LAST:event_CboKhuVucMouseClicked

    private void btnDacBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDacBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDacBanActionPerformed

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
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home_Frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home_Frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home_Frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home_Frm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home_Frm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CboKhuVuc;
    private javax.swing.JPanel ChiTietBanAn;
    private javax.swing.JPanel KhuVucNgoaiTroiPanel;
    private javax.swing.JPanel KhuVucPhongLanhPanel;
    private javax.swing.JPanel KhuVucSanhPanel;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnCapNhatMA;
    private javax.swing.JButton btnDacBan;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLamMoiMA;
    private javax.swing.JButton btnSuaMA;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemMA;
    private javax.swing.JButton btnTimKiemMA;
    private javax.swing.JButton btnTimKiemNV;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaMonAn;
    private javax.swing.JComboBox<String> chkLoaiMA;
    private javax.swing.ButtonGroup grbGender;
    private javax.swing.ButtonGroup grbTrangThaiMA;
    private javax.swing.ButtonGroup grpChucVu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblHinhMA;
    private javax.swing.JLabel lblHinhNV;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNhanVien;
    private javax.swing.JRadioButton rdoNo;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JRadioButton rdoQuanLi;
    private javax.swing.JRadioButton rdoYes;
    private javax.swing.JTable tblKhuVucPhongLanh;
    private javax.swing.JTable tblKhuVucSanh;
    private javax.swing.JTable tblMonAn;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTable tblNhanVien2;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtDVTMA;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtGiaMA;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaKhachHangBD;
    private javax.swing.JTextField txtMaMA;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextArea txtMoTaBD;
    private javax.swing.JTextArea txtMoTaMA;
    private javax.swing.JTextField txtNgayDB;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSoDienThoaiDB;
    private javax.swing.JTextField txtTenBanAnDB;
    private javax.swing.JTextField txtTenMA;
    private javax.swing.JTextField txtTienCoc;
    private javax.swing.JTextField txtTimKiemMA;
    private javax.swing.JTextField txtTimKiemNV;
    // End of variables declaration//GEN-END:variables

//Form quản lý món ăn
    void initMonAn() {
        this.fillTableMonAn();
        this.fillLoaiMon();
        rowMA = -1;
        rdoYes.setVisible(false);
        rdoNo.setVisible(false);
    }

    private MonAnDAO monAnDAO = new MonAnDAO();
    private LoaiMonAnDAO loaiMonAnDAO = new LoaiMonAnDAO();
    int rowMA = -1;

    // tạo bảng món ăn
    public void fillTableMonAn() {
        String[] columnNames = {
            "Mã Món Ăn",
            "Tên Món Ăn",
            "Loại Món Ăn",
            "Đơn Vị Tính",
            "Đơn Giá",
            "Mô Tả",
            "Trạng Thái",
            "Hình Ảnh Món Ăn"
        };

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tblMonAn.setModel(model);
        try {
            List<MonAn> list = monAnDAO.selectAll();
            list.sort(Comparator.comparing(MonAn::isTrangThai).reversed());
            for (MonAn monAn : list) {
                Object[] row = {
                    monAn.getMaMonAn(),
                    monAn.getTenMonAn(),
                    loaiMonAnDAO.selectById(monAn.getMaLoaiMon()).getTenLoaiMon(),
                    monAn.getDvt(),
                    monAn.getDonGia(),
                    monAn.getMoTa(),
                    monAn.isTrangThai() ? "Tạm Ngưng" : "Đang bán",
                    monAn.getHinhAnhMonAn()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // lấy dữ liệu tên loại món từ bảng LoaiMonAn
    private void fillLoaiMon() {
        try {
            List<LoaiMonAn> loaiMonAnList = loaiMonAnDAO.selectAll();
            chkLoaiMA.removeAllItems();
            for (LoaiMonAn loaiMonAn : loaiMonAnList) {
                chkLoaiMA.addItem(loaiMonAn.getTenLoaiMon());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // lấy dữ liệu lên món ăn
    public MonAn getFormMonAn() {
        MonAn ma = new MonAn();
        ma.setTenMonAn(txtTenMA.getText());
        ma.setDvt(txtDVTMA.getText());
        ma.setDonGia(Double.parseDouble(txtGiaMA.getText()));
        ma.setMoTa(txtMoTaMA.getText());
        ma.setHinhAnhMonAn(lblHinhMA.getToolTipText());
        ma.setHinhAnhMonAn(lblHinhMA.getToolTipText());
        ma.setMaLoaiMon(loaiMonAnDAO.selectAll().stream()
                .filter(loai -> loai.getTenLoaiMon().equals(chkLoaiMA.getSelectedItem()))
                .findFirst()
                .orElse(new LoaiMonAn())
                .getMaLoaiMon());
        ma.setTrangThai(rdoYes.isSelected());
        return ma;
    }

    // truyền dữ liệu vào Form món ăn
    public void setFormMonAn(MonAn monAn) {
        txtMaMA.setText(String.valueOf(monAn.getMaMonAn()));
        txtTenMA.setText(monAn.getTenMonAn());
        chkLoaiMA.setSelectedItem(loaiMonAnDAO.selectById(monAn.getMaLoaiMon()).getTenLoaiMon());
        txtDVTMA.setText(monAn.getDvt());
        txtGiaMA.setText(String.valueOf(monAn.getDonGia()));
        txtMoTaMA.setText(monAn.getMoTa());

        if (monAn.isTrangThai()) {
            rdoYes.setSelected(true);
        } else {
            rdoNo.setSelected(true);
        }

        setImageLabelMonAn(lblHinhMA, monAn.getHinhAnhMonAn());
    }

    // tạo mới form món ăn
    void clearFormMonAn() {
        txtMaMA.setText("");
        txtTenMA.setText("");
        chkLoaiMA.setSelectedItem(null);
        txtGiaMA.setText("");
        txtMoTaMA.setText("");
        rdoNo.setSelected(false);
        rdoYes.setSelected(false);
        txtDVTMA.setText("");
        setImageLabelMonAn(lblHinhMA, "");
        fillTableMonAn();
    }

    // bắt lỗi form Món Ăn
    boolean isValidFormMonAn() {
        if (txtTenMA.getText().trim().isEmpty()) {
            MsgBox.alert(this, "Tên món ăn không được để trống!");
            return false;
        }

        if (txtDVTMA.getText().trim().isEmpty()) {
            MsgBox.alert(this, "Đơn vị tính không được để trống!");
            return false;
        }

        String giaMAText = txtGiaMA.getText().trim();
        try {
            if (!giaMAText.isEmpty()) {
                double giaMA = Double.parseDouble(giaMAText);
                if (giaMA <= 10000) {
                    MsgBox.alert(this, "Giá phải lớn hơn 10,000!");
                    return false;
                }
            } else {
                MsgBox.alert(this, "Giá không được để trống!");
                return false;
            }
        } catch (NumberFormatException e) {
            MsgBox.alert(this, "Giá phải là một số hợp lệ!");
            return false;
        }

        return true;
    }

    // Thêm món ăn mới
    void insertMonAn() {
        if (!isValidFormMonAn()) {
            return;
        }

        MonAn model = getFormMonAn();
        try {
            monAnDAO.insert(model);
            this.fillTableMonAn();
            this.clearFormMonAn();
            MsgBox.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Thêm mới thất bại!");
        }
    }

    // Set thời gian món tạm ngưng
    public class SuspensionConfigDialog extends JDialog {

        private JTextField txtDuration;
        private boolean confirmed = false;

        public SuspensionConfigDialog(Frame owner) {
            super(owner, "Món đã hết", true);
            setLayout(new GridLayout(2, 2));
            add(new JLabel("Món sẽ có lại sau(phút)"));
            txtDuration = new JTextField();
            add(txtDuration);

            JButton btnConfirm = new JButton("Xác nhận");
            JButton btnCancel = new JButton("Hủy");

            btnConfirm.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    confirmed = true;
                    setVisible(false);
                }
            });

            btnCancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                }
            });

            add(btnConfirm);
            add(btnCancel);
            pack();
            setLocationRelativeTo(owner);
        }

        public boolean isConfirmed() {
            return confirmed;
        }

        public int getDuration() {
            return Integer.parseInt(txtDuration.getText());
        }
    }

    // cập nhật trạng thái món ăn
    void TrangThaiMonAn() {
        if (tblMonAn.getSelectedRow() == -1) {
            MsgBox.alert(this, "Vui lòng chọn một món ăn để cập nhật trạng thái!");
            return;
        }

        int maMonAn = (int) tblMonAn.getValueAt(tblMonAn.getSelectedRow(), 0);
        MonAn monAn = monAnDAO.selectById(maMonAn);

        if (monAn == null) {
            MsgBox.alert(this, "Món ăn không tồn tại!");
            return;
        }

        if (rdoYes.isSelected()) {
            SuspensionConfigDialog dialog = new SuspensionConfigDialog(this);
            dialog.setVisible(true);

            if (!dialog.isConfirmed()) {
                return;
            }

            int duration = dialog.getDuration();

            monAn.setTrangThai(true);
            try {
                monAnDAO.update(monAn);
                fillTableMonAn();
                MsgBox.alert(this, "Cập nhật trạng thái thành công!");

                Timer timer = new Timer(duration * 60 * 1000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        monAn.setTrangThai(false);
                        try {
                            monAnDAO.update(monAn);
                            fillTableMonAn();
                            // Notify the user
                            JOptionPane.showMessageDialog(null,
                                    "Món ăn \"" + monAn.getTenMonAn() + "\" đã có món!",
                                    "Trạng thái cập nhật",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            MsgBox.alert(null, "Cập nhật trạng thái thất bại!");
                        }
                    }
                });
                timer.setRepeats(false);
                timer.start();
            } catch (Exception e) {
                e.printStackTrace();
                MsgBox.alert(this, "Cập nhật trạng thái thất bại!");
            }
        } else {
            monAn.setTrangThai(false);
            try {
                monAnDAO.update(monAn);
                fillTableMonAn();
                MsgBox.alert(this, "Cập nhật trạng thái thành công!");
            } catch (Exception e) {
                e.printStackTrace();
                MsgBox.alert(this, "Cập nhật trạng thái thất bại!");
            }
        }
    }

    void updateMonAn() {
        // Check if a row is selected in the table
        int selectedRow = tblMonAn.getSelectedRow();

        if (selectedRow == -1) {
            MsgBox.alert(this, "Vui lòng chọn một món ăn để cập nhật!");
            return;
        }

        // Retrieve the mã món ăn from the selected row
        int maMonAn = (int) tblMonAn.getValueAt(selectedRow, 0);
        MonAn monAn = monAnDAO.selectById(maMonAn);

        if (monAn == null) {
            MsgBox.alert(this, "Món ăn không tồn tại!");
            return;
        }

        // Update the MonAn object with the new data from the form
        try {
            monAn.setTenMonAn(txtTenMA.getText());
            monAn.setDvt(txtDVTMA.getText());
            monAn.setDonGia(Double.parseDouble(txtGiaMA.getText()));
            monAn.setMoTa(txtMoTaMA.getText());

            // Check if the image path is set in the tooltip of lblHinhMA
            if (lblHinhMA.getToolTipText() != null && !lblHinhMA.getToolTipText().isEmpty()) {
                monAn.setHinhAnhMonAn(lblHinhMA.getToolTipText());
            }

            // Set the MaLoaiMon based on the selected item in chkLoaiMA
            monAn.setMaLoaiMon(loaiMonAnDAO.selectAll().stream()
                    .filter(loai -> loai.getTenLoaiMon().equals(chkLoaiMA.getSelectedItem()))
                    .findFirst()
                    .orElse(new LoaiMonAn())
                    .getMaLoaiMon());

            monAn.setTrangThai(rdoYes.isSelected());

            // Update the MonAn in the database
            monAnDAO.update(monAn);

            // Refresh the table to show the updated data
            fillTableMonAn();
            MsgBox.alert(this, "Cập nhật món ăn thành công!");

        } catch (NumberFormatException e) {
            MsgBox.alert(this, "Giá phải là một số hợp lệ!");
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Cập nhật món ăn thất bại!");
        }
    }

    // Chức năng tìm món ăn
    void findMonAn() {
        // Get the search term from the text field (assume you have a text field named txtTimKiemMA)
        String searchTerm = txtTimKiemMA.getText().trim();

        if (searchTerm.isEmpty()) {
            // If the search term is empty, show all dishes
            fillTableMonAn();
            return;
        }

        try {
            // Retrieve the list of MonAn based on the search term
            List<MonAn> list = monAnDAO.searchByName(searchTerm);

            // Define the table columns
            String[] columnNames = {
                "Mã Món Ăn",
                "Tên Món Ăn",
                "Loại Món Ăn",
                "Đơn Vị Tính",
                "Đơn Giá",
                "Mô Tả",
                "Trạng Thái",
                "Hình Ảnh Món Ăn"
            };

            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            tblMonAn.setModel(model);

            if (list.isEmpty()) {
                MsgBox.alert(this, "Không tìm thấy món ăn với tên '" + searchTerm + "'.");
            } else {
                // Show a message indicating that the search was successful
                MsgBox.alert(this, "Tìm thấy " + list.size() + " món ăn.");

                // Prepare the table rows
                for (MonAn monAn : list) {
                    // Fetch LoaiMonAn details
                    String tenLoaiMon = "Không xác định";
                    if (monAn.getMaLoaiMon() != null) {
                        LoaiMonAn loaiMonAn = loaiMonAnDAO.selectById(monAn.getMaLoaiMon());
                        if (loaiMonAn != null) {
                            tenLoaiMon = loaiMonAn.getTenLoaiMon();
                        }
                    }

                    Object[] row = {
                        monAn.getMaMonAn(),
                        monAn.getTenMonAn(),
                        tenLoaiMon,
                        monAn.getDvt(),
                        monAn.getDonGia(),
                        monAn.getMoTa(),
                        monAn.isTrangThai() ? "Tạm Ngưng" : "Đang bán",
                        monAn.getHinhAnhMonAn()
                    };
                    model.addRow(row);
                }

                // Scroll to the top to make sure the table is scrolled to the top
                tblMonAn.scrollRectToVisible(tblMonAn.getCellRect(0, 0, true));
            }

        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Tìm kiếm thất bại!");
        }
    }

    //anh mon an
    private String currentFilePathMonAn = "";
    private String currentFilePath = "";

    private void setImageLabelMonAn(JLabel label, String imagePath) {
        if (imagePath != null && !imagePath.isEmpty()) {
            ImageIcon icon = com.poly.utils.XImage.read(imagePath);
            ImageIcon resizedIcon = resizeImageMonAn(icon, 130, 150);
            label.setIcon(resizedIcon);
            label.setToolTipText(imagePath);
        } else {
            label.setIcon(null);
            label.setToolTipText(null);
        }
    }

    private ImageIcon resizeImageMonAn(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }

    void chonAnhMonAn() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                com.poly.utils.XImage.save(file);
                ImageIcon icon = com.poly.utils.XImage.read(file.getName());
                ImageIcon resizedIcon = resizeImageMonAn(icon, lblHinhMA.getWidth(), lblHinhMA.getHeight());
                lblHinhMA.setIcon(resizedIcon);
                lblHinhMA.setToolTipText(file.getName());
                currentFilePathMonAn = file.getPath();
            } catch (Exception e) {

                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error loading image: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

//Form Quanly nhan vien
    void initNhanVien() {
        this.fillTableNhanVien();
        this.fillTableNhanVien2();

    }

    private NhanVienDAO NVdao = new NhanVienDAO();
    int row = -1;

    void fillTableNhanVien() {
        String[] columnNames = {
            "Mã NV",
            "Họ Tên NV",
            "Giới Tính",
            "Ngày Sinh",
            "Số Điện Thoại",
            "CCCD",
            "Địa Chỉ",
            "Chức Vụ",
            "Ngày Vào Làm",
            "Trạng Thái",
            "Hình Ảnh",
            "Mật Khẩu"
        };

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tblNhanVien.setModel(model);

        try {
            String keyword = txtTimKiemNV.getText();
            List<NhanVien> list = NVdao.selectByKeyword(keyword);
            for (NhanVien nv : list) {
                if (nv.isTrangThai()) { // Check if the employee is currently working
                    Object[] row = {
                        nv.getMaNV(),
                        nv.getHoTenNV(),
                        nv.isGioiTinh() ? "Nam" : "Nữ",
                        XDate.toString(nv.getNgaySinh(), "dd/MM/yyyy"),
                        nv.getSdtNV(),
                        nv.getCccd(),
                        nv.getDiaChi(),
                        nv.isChucVu() ? "Quản Lý" : "Nhân viên",
                        XDate.toString(nv.getNgayVaoLam(), "dd/MM/yyyy"),
                        nv.isTrangThai() ? "Đang Làm" : "Đã Nghỉ",
                        nv.getHinhAnhNV(),
                        nv.getMatKhau()
                    };
                    model.addRow(row); // Add row to the table model
                }
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void fillTableNhanVien2() {
        String[] columnNames = {
            "Mã NV",
            "Họ Tên NV",
            "Giới Tính",
            "Ngày Sinh",
            "Số Điện Thoại",
            "CCCD",
            "Địa Chỉ",
            "Chức Vụ",
            "Ngày Vào Làm",
            "Trạng Thái",
            "Hình Ảnh",
            "Mật khẩu"
        };

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tblNhanVien2.setModel(model);

        try {
            String keyword = txtTimKiemNV.getText();
            List<NhanVien> list = NVdao.selectByKeyword(keyword);
            for (NhanVien nv : list) {
                if (!nv.isTrangThai()) { // Check if the employee has left
                    Object[] row = {
                        nv.getMaNV(),
                        nv.getHoTenNV(),
                        nv.isGioiTinh() ? "Nam" : "Nữ",
                        XDate.toString(nv.getNgaySinh(), "dd/MM/yyyy"),
                        nv.getSdtNV(),
                        nv.getCccd(),
                        nv.getDiaChi(),
                        nv.isChucVu() ? "Quản Lý" : "Nhân viên",
                        XDate.toString(nv.getNgayVaoLam(), "dd/MM/yyyy"),
                        nv.isTrangThai() ? "Đang Làm" : "Đã Nghỉ",
                        nv.getHinhAnhNV(),
                        nv.getMatKhau()
                    };
                    model.addRow(row); // Add row to the table model
                }
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void clearFormNV() {
        txtMaNV.setText("");
        txtHoTen.setText("");
        rdoNam.setSelected(false);
        rdoNu.setSelected(false);
        txtNgaySinh.setText("");
        txtSDT.setText("");
        txtCCCD.setText("");
        txtDiaChi.setText("");
        rdoQuanLi.setSelected(false);
        rdoNhanVien.setSelected(false);
        this.row = -1;
        setImageLabelNV(lblHinhNV, "");
        txtPassword.setText("");
    }

    void editNV() {
        String manv = (String) tblNhanVien.getValueAt(this.row, 0);
        NhanVien nv = NVdao.selectById(manv);
        this.setFormNV(nv);
    }

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    void setFormNV(NhanVien nv) {
        txtMaNV.setText(nv.getMaNV());
        txtHoTen.setText(nv.getHoTenNV());

        // Set gender radio buttons
        rdoNam.setSelected(nv.isGioiTinh());
        rdoNu.setSelected(!nv.isGioiTinh());

        // Set date of birth
        txtNgaySinh.setText(XDate.toString(nv.getNgaySinh(), "dd/MM/yyyy"));

        txtSDT.setText(nv.getSdtNV());
        txtCCCD.setText(nv.getCccd());
        txtDiaChi.setText(nv.getDiaChi());

        // Set position radio buttons
        rdoQuanLi.setSelected(nv.isChucVu());
        rdoNhanVien.setSelected(!nv.isChucVu());

        // Set the image
        setImageLabelNV(lblHinhNV, nv.getHinhAnhNV());
        txtPassword.setText(nv.getMatKhau());
    }

    NhanVien getFormNV() {
        NhanVien nv = new NhanVien();
        nv.setMaNV(txtMaNV.getText());
        nv.setHoTenNV(txtHoTen.getText());
        nv.setGioiTinh(rdoNam.isSelected());
        nv.setNgaySinh(XDate.toDate(txtNgaySinh.getText(), "dd/MM/yyyy"));
        nv.setSdtNV(txtSDT.getText());
        nv.setCccd(txtCCCD.getText());
        nv.setDiaChi(txtDiaChi.getText());
//        nv.setChucVu(rdoNhanVien.isSelected());
        nv.setChucVu(rdoNhanVien.isSelected() ? false : true);
        nv.setNgayVaoLam(new Date());
        nv.setTrangThai(true);
        nv.setHinhAnhNV(lblHinhNV.getToolTipText());
        nv.setMatKhau(new String(txtPassword.getPassword()));
        return nv;
    }

    void insertNV() {
        NhanVien nv = this.getFormNV();

        // Check if any field is empty
        if (nv.getMaNV().isEmpty() || nv.getHoTenNV().isEmpty() || txtNgaySinh.getText().isEmpty()
                || nv.getSdtNV().isEmpty() || nv.getCccd().isEmpty() || nv.getDiaChi().isEmpty()) {
            MsgBox.alert(this, "Vui lòng điền đầy đủ thông tin.");
            return;
        }

        // Attempt to insert the new employee record
        try {
            NVdao.insert(nv); // thêm mới

            this.fillTableNhanVien(); // đổ lại bảng
            this.clearFormNV(); // xóa trắng form
            MsgBox.alert(this, "Thêm mới thành công!");

        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Thêm mới thất bại.");
        }
    }

    void deleteNV() {
        // Check if a row is selected in the table
        int selectedRow = tblNhanVien.getSelectedRow();
        if (selectedRow < 0) {
            MsgBox.alert(this, "Vui lòng chọn một nhân viên để xóa.");
            return;
        }

        // Get the employee ID from the selected row
        String maNV = (String) tblNhanVien.getValueAt(selectedRow, 0);

        // Confirm the deletion
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa nhân viên này?");
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            // Fetch the employee object from DAO
            NhanVien nv = NVdao.selectById(maNV);
            if (nv != null) {
                // Update the employee's status to "Đã Thôi Việc"
                nv.setTrangThai(false); // Assuming false means the employee has left
                NVdao.update(nv); // Update the employee in the database
                this.fillTableNhanVien(); // Refresh the table of employees currently working
                this.fillTableNhanVien2(); // Refresh the table of employees who have left
                MsgBox.alert(this, "Xóa nhân viên thành công!");
            } else {
                MsgBox.alert(this, "Nhân viên không tồn tại.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Xóa nhân viên thất bại.");
        }
    }

    void updateNV() {
        NhanVien nv = this.getFormNV();

        // Check if any field is empty
        if (nv.getMaNV().isEmpty() || nv.getHoTenNV().isEmpty() || txtNgaySinh.getText().isEmpty()
                || nv.getSdtNV().isEmpty() || nv.getCccd().isEmpty() || nv.getDiaChi().isEmpty()) {
            MsgBox.alert(this, "Vui lòng điền đầy đủ thông tin.");
            return;
        }
        setImageLabelNV(lblHinhNV, nv.getHinhAnhNV());
        // Ensure that a valid employee ID is set for the update operation
        if (nv.getMaNV() == null || nv.getMaNV().isEmpty()) {
            MsgBox.alert(this, "Mã nhân viên không hợp lệ.");
            return;
        }

        // Attempt to update the existing employee record
        try {
            // Call the DAO's update method to update the employee record in the database
            NVdao.update(nv);

            this.fillTableNhanVien(); // Refresh the table to reflect changes
            this.clearFormNV(); // Clear the form after successful update
            MsgBox.alert(this, "Cập nhật thành công!");

        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Cập nhật thất bại.");
        }
    }

    void searchNV() {
        this.fillTableNhanVien();
        this.fillTableNhanVien2();
    }
    //anh nhan vien

    private void setImageLabelNV(JLabel label, String imagePath) {
        if (imagePath != null && !imagePath.isEmpty()) {
            ImageIcon icon = com.poly.utils.XImage.read(imagePath);
            ImageIcon resizedIcon = resizeImageNV(icon, 130, 150);
            label.setIcon(resizedIcon);
            label.setToolTipText(imagePath);
        } else {
            label.setIcon(null);
            label.setToolTipText(null);
        }
    }

    private ImageIcon resizeImageNV(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }

    void chonAnhNV() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                com.poly.utils.XImage.save(file);
                ImageIcon icon = com.poly.utils.XImage.read(file.getName());
                ImageIcon resizedIcon = resizeImageNV(icon, lblHinhNV.getWidth(), lblHinhNV.getHeight());
                lblHinhNV.setIcon(resizedIcon);
                lblHinhNV.setToolTipText(file.getName());
                currentFilePath = file.getPath();
            } catch (Exception e) {

                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error loading image: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /*Quản Lý bàn ăn và đặc bàn*/
    public void fillKhuVucComboBox() {
        KhuVucDAO khuVucDAO = new KhuVucDAO();
        List<String> khuVucNames = khuVucDAO.selectNameKhuVuc();

        CboKhuVuc.removeAllItems();

        for (String name : khuVucNames) {
            CboKhuVuc.addItem(name);
        }
    }

    void initBanAN() {
        fillBanANKhuVucNgoaiTroi();
        fillKhuVucComboBox();
        fillBanANKhuVucSanh();
        fillBanANKhuVucPhongLanh();
    
    }

    public void fillBanANKhuVucSanh() {
        // Tạo DAO và lấy dữ liệu
        BanAnDAO dao = new BanAnDAO();
        List<BanAn> list = dao.selectAll();

        // Xóa tất cả các component cũ trong KhuVucSanhPanel
        KhuVucSanhPanel.removeAll();

        // Sử dụng GridBagLayout cho KhuVucSanhPanel
        KhuVucSanhPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Khoảng cách giữa các panel
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        int count = 0; // Đếm số lượng panel đã thêm
        int maxColumns = 4; // Số lượng item tối đa trên mỗi hàng

        for (BanAn banAn : list) {
            if (count >= 15) {
                break; // Dừng lại sau khi đã thêm 15 item
            }

            if ("KV01".equals(banAn.getMaKhuVuc())) { // Kiểm tra khu vực
                // Tạo và cấu hình panel
                JPanel panel = new JPanel();
                panel.setPreferredSize(new Dimension(100, 100)); // Kích thước của panel

                // Đặt màu nền dựa trên trạng thái
                panel.setBackground(banAn.isTrangThai() ? Color.RED : Color.GREEN);

                panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

                // Thêm nhãn vào panel
                JLabel tenBanLabel = new JLabel(banAn.getTenBan());
                tenBanLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                tenBanLabel.setFont(new Font("Arial", Font.BOLD, 12));

                JLabel trangThaiLabel = new JLabel(banAn.isTrangThai() ? "Có khách" : "Bàn trống");
                trangThaiLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                trangThaiLabel.setFont(new Font("Arial", Font.PLAIN, 10));

                panel.add(Box.createVerticalGlue()); // Thêm glue để căn giữa theo chiều dọc
                panel.add(tenBanLabel);
                panel.add(trangThaiLabel);
                panel.add(Box.createVerticalGlue()); // Thêm glue để căn giữa theo chiều dọc

                // Thêm MouseListener cho panel
                panel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        txtTenBanAnDB.setText(tenBanLabel.getText()); // Điền tên bàn vào JTextField
                        // Kiểm tra trạng thái của bàn ăn và vô hiệu hóa btnDacBan nếu có khách
                        if (banAn.isTrangThai()) {
                            btnDacBan.setEnabled(false);
                        } else {
                            btnDacBan.setEnabled(true);
                        }
                    }
                });

                // Cài đặt GridBagConstraints cho panel
                gbc.gridx = count % maxColumns;
                gbc.gridy = count / maxColumns;

                // Thêm panel vào KhuVucSanhPanel
                KhuVucSanhPanel.add(panel, gbc);

                count++; // Tăng số lượng panel đã thêm
            }
        }
        // Cập nhật giao diện
        KhuVucSanhPanel.revalidate();
        KhuVucSanhPanel.repaint();
    }

    public void fillBanANKhuVucNgoaiTroi() {
        // Tạo DAO và lấy dữ liệu
        BanAnDAO dao = new BanAnDAO();
        List<BanAn> list = dao.selectAll();

        // Xóa tất cả các component cũ trong KhuVucNgoaiTroiPanel
        KhuVucNgoaiTroiPanel.removeAll();

        // Sử dụng GridBagLayout cho KhuVucNgoaiTroiPanel
        KhuVucNgoaiTroiPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Khoảng cách giữa các panel
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        int count = 0; // Đếm số lượng panel đã thêm
        int maxColumns = 4; // Số lượng item tối đa trên mỗi hàng

        for (BanAn banAn : list) {
            if (count >= 15) {
                break; // Dừng lại sau khi đã thêm 15 item
            }

            if ("KV02".equals(banAn.getMaKhuVuc())) { // Kiểm tra khu vực
                // Tạo và cấu hình panel
                JPanel panel = new JPanel();
                panel.setPreferredSize(new Dimension(100, 100)); // Kích thước của panel

                // Đặt màu nền dựa trên trạng thái
                panel.setBackground(banAn.isTrangThai() ? Color.RED : Color.GREEN);

                panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

                // Thêm nhãn vào panel
                JLabel tenBanLabel = new JLabel(banAn.getTenBan());
                tenBanLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                tenBanLabel.setFont(new Font("Arial", Font.BOLD, 12));

                JLabel trangThaiLabel = new JLabel(banAn.isTrangThai() ? "Có khách" : "Bàn trống");
                trangThaiLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                trangThaiLabel.setFont(new Font("Arial", Font.PLAIN, 10));

                panel.add(Box.createVerticalGlue()); // Thêm glue để căn giữa theo chiều dọc
                panel.add(tenBanLabel);
                panel.add(trangThaiLabel);
                panel.add(Box.createVerticalGlue()); // Thêm glue để căn giữa theo chiều dọc

                // Thêm MouseListener cho panel
                panel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        txtTenBanAnDB.setText(tenBanLabel.getText());
                        // Kiểm tra trạng thái của bàn ăn và vô hiệu hóa btnDacBan nếu có khách
                        if (banAn.isTrangThai()) {
                            btnDacBan.setEnabled(false);
                        } else {
                            btnDacBan.setEnabled(true);
                        }
                    }
                });

                // Cài đặt GridBagConstraints cho panel
                gbc.gridx = count % maxColumns;
                gbc.gridy = count / maxColumns;

                // Thêm panel vào KhuVucNgoaiTroiPanel
                KhuVucNgoaiTroiPanel.add(panel, gbc);

                count++; // Tăng số lượng panel đã thêm
            }
        }
        // Cập nhật giao diện
        KhuVucNgoaiTroiPanel.revalidate();
        KhuVucNgoaiTroiPanel.repaint();
    }

    public void fillBanANKhuVucPhongLanh() {
        // Tạo DAO và lấy dữ liệu
        BanAnDAO dao = new BanAnDAO();
        List<BanAn> list = dao.selectAll();

        // Xóa tất cả các component cũ trong KhuVucPhongLanhPanel
        KhuVucPhongLanhPanel.removeAll();

        // Sử dụng GridBagLayout cho KhuVucPhongLanhPanel
        KhuVucPhongLanhPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Khoảng cách giữa các panel
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        int count = 0; // Đếm số lượng panel đã thêm
        int maxColumns = 4; // Số lượng item tối đa trên mỗi hàng

        for (BanAn banAn : list) {
            if (count >= 15) {
                break; // Dừng lại sau khi đã thêm 15 item
            }

            if ("KV03".equals(banAn.getMaKhuVuc())) { // Kiểm tra khu vực
                // Tạo và cấu hình panel
                JPanel panel = new JPanel();
                panel.setPreferredSize(new Dimension(100, 100)); // Kích thước của panel

                // Đặt màu nền dựa trên trạng thái
                panel.setBackground(banAn.isTrangThai() ? Color.RED : Color.GREEN);

                panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

                // Thêm nhãn vào panel
                JLabel tenBanLabel = new JLabel(banAn.getTenBan());
                tenBanLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                tenBanLabel.setFont(new Font("Arial", Font.BOLD, 12));

                JLabel trangThaiLabel = new JLabel(banAn.isTrangThai() ? "Có khách" : "Bàn trống");
                trangThaiLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                trangThaiLabel.setFont(new Font("Arial", Font.PLAIN, 10));

                panel.add(Box.createVerticalGlue()); // Thêm glue để căn giữa theo chiều dọc
                panel.add(tenBanLabel);
                panel.add(trangThaiLabel);
                panel.add(Box.createVerticalGlue()); // Thêm glue để căn giữa theo chiều dọc

                // Thêm MouseListener cho panel
                panel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        txtTenBanAnDB.setText(tenBanLabel.getText()); // Điền tên bàn vào JTextField
                        // Kiểm tra trạng thái của bàn ăn và vô hiệu hóa btnDacBan nếu có khách
                        if (banAn.isTrangThai()) {
                            btnDacBan.setEnabled(false);
                        } else {
                            btnDacBan.setEnabled(true);
                        }
                    }
                });

                // Cài đặt GridBagConstraints cho panel
                gbc.gridx = count % maxColumns;
                gbc.gridy = count / maxColumns;

                // Thêm panel vào KhuVucPhongLanhPanel
                KhuVucPhongLanhPanel.add(panel, gbc);

                count++; // Tăng số lượng panel đã thêm
            }
        }
        // Cập nhật giao diện
        KhuVucPhongLanhPanel.revalidate();
        KhuVucPhongLanhPanel.repaint();
    }

   
}
