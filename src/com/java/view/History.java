/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.view;

import com.java.controller.HistoryController;
import com.java.controller.ReportController;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 927
 */
public class History extends javax.swing.JFrame {

    private final HistoryController controller;

    /**
     * Creates new form History
     */
    public History() {
        initComponents();
        this.setIconImage(new ImageIcon("images/logo_1.png").getImage());

        controller = new HistoryController();

        txt_fromDate.getSettings().setFormatForDatesCommonEra("dd-MM-yyyy");
        txt_toDate.getSettings().setFormatForDatesCommonEra("dd-MM-yyyy");

        try {
            controller.setAllDatatoTable(tbl_history);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(History.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_history = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_facilityNo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_vehicleNo = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        txt_fromDate = new com.github.lgooddatepicker.components.DatePicker();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_toDate = new com.github.lgooddatepicker.components.DatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("All Recoded Files");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbl_history.setAutoCreateRowSorter(true);
        tbl_history.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Received Date", "Facility No", "Vehicle No", "File Type", "Comment", "Cheque Completed Date", "Received By"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_history.setFocusable(false);
        tbl_history.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbl_history.setRowHeight(20);
        tbl_history.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_history.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_history.setShowGrid(true);
        tbl_history.getTableHeader().setReorderingAllowed(false);
        tbl_history.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_historyMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_history);
        if (tbl_history.getColumnModel().getColumnCount() > 0) {
            tbl_history.getColumnModel().getColumn(0).setResizable(false);
            tbl_history.getColumnModel().getColumn(1).setResizable(false);
            tbl_history.getColumnModel().getColumn(2).setResizable(false);
            tbl_history.getColumnModel().getColumn(3).setResizable(false);
            tbl_history.getColumnModel().getColumn(4).setResizable(false);
            tbl_history.getColumnModel().getColumn(5).setResizable(false);
            tbl_history.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.setFocusable(false);

        jLabel2.setText("Facility No.");
        jLabel2.setFocusable(false);
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txt_facilityNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_facilityNo.setNextFocusableComponent(txt_vehicleNo);

        jLabel3.setText("Vehicle No.");
        jLabel3.setFocusable(false);
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txt_vehicleNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_vehicleNo.setNextFocusableComponent(txt_fromDate);

        btn_search.setText("Search");
        btn_search.setFocusable(false);
        btn_search.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_search.setNextFocusableComponent(txt_facilityNo);
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        btn_clear.setText("Clear");
        btn_clear.setFocusable(false);
        btn_clear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_clear.setNextFocusableComponent(txt_facilityNo);
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        txt_fromDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_fromDate.setNextFocusableComponent(txt_toDate);

        jLabel4.setText("From Date");
        jLabel4.setFocusable(false);
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setText("To Date");
        jLabel5.setFocusable(false);
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txt_toDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_toDate.setNextFocusableComponent(txt_facilityNo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_facilityNo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_vehicleNo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_fromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_toDate, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(240, 240, 240))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_facilityNo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_fromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_vehicleNo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_toDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_historyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_historyMouseClicked
        if (evt.getClickCount() == 2 && evt.getButton() == MouseEvent.BUTTON1) {
            DefaultTableModel model = (DefaultTableModel) tbl_history.getModel();
            Inquiry inquiry = new Inquiry(model.getValueAt(tbl_history.getSelectedRow(), 1).toString());
            inquiry.setVisible(true);
        }
    }//GEN-LAST:event_tbl_historyMouseClicked

  private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
      try {
          String facilityNo = txt_facilityNo.getText().trim();
          String vehicleNo = txt_vehicleNo.getText().trim();
          LocalDate from = txt_fromDate.getDate();
          LocalDate to = txt_toDate.getDate();

          if (!facilityNo.isEmpty() && vehicleNo.isEmpty() && from == null && to == null) {
              controller.searchByFacilityNo(tbl_history, facilityNo);
          } else if (facilityNo.isEmpty() && !vehicleNo.isEmpty() && from == null && to == null) {
              controller.searchByVehicleNo(tbl_history, vehicleNo);
          } else if (facilityNo.isEmpty() && vehicleNo.isEmpty() && from != null && to != null) {
              controller.searchByDatePeriod(tbl_history, txt_fromDate.getDate(), txt_toDate.getDate().plusDays(1));
          } else {
              //JOptionPane.showMessageDialog(this, "Data saved successfuly.", "Warning", JOptionPane.WARNING_MESSAGE);
          }

      } catch (ClassNotFoundException | SQLException ex) {
          Logger.getLogger(History.class.getName()).log(Level.SEVERE, null, ex);
      }
  }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        txt_facilityNo.setText("");
        txt_vehicleNo.setText("");
        txt_fromDate.setText("");
        txt_toDate.setText("");
        try {
            controller.setAllDatatoTable(tbl_history);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(History.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_clearActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_search;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_history;
    private javax.swing.JTextField txt_facilityNo;
    private com.github.lgooddatepicker.components.DatePicker txt_fromDate;
    private com.github.lgooddatepicker.components.DatePicker txt_toDate;
    private javax.swing.JTextField txt_vehicleNo;
    // End of variables declaration//GEN-END:variables

}
