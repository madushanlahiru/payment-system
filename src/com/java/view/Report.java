/*
 * The MIT License
 *
 * Copyright 2021 927.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.java.view;

import com.java.controller.ReportController;
import java.time.LocalDate;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author 927
 */
public class Report extends javax.swing.JFrame {

    /**
     * Creates new form Report
     */
    public Report() {
        initComponents();
        this.setIconImage(new ImageIcon("images/logo_1.png").getImage());
        
        txt_fromDate.getSettings().setFormatForDatesCommonEra("dd-MM-yyyy");
        txt_toDate.getSettings().setFormatForDatesCommonEra("dd-MM-yyyy");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_fromDate = new com.github.lgooddatepicker.components.DatePicker();
        txt_toDate = new com.github.lgooddatepicker.components.DatePicker();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_fileReceivedReport = new javax.swing.JButton();
        btn_returnHistoryReport = new javax.swing.JButton();
        btn_courierDetails = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reports");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txt_fromDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txt_toDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setText("From Date");
        jLabel4.setFocusable(false);
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setText("To Date");
        jLabel5.setFocusable(false);
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btn_fileReceivedReport.setText("File Received Report");
        btn_fileReceivedReport.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_fileReceivedReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fileReceivedReportActionPerformed(evt);
            }
        });

        btn_returnHistoryReport.setText("Return History Report");
        btn_returnHistoryReport.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_returnHistoryReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_returnHistoryReportActionPerformed(evt);
            }
        });

        btn_courierDetails.setText("Courier Details Report");
        btn_courierDetails.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_courierDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_courierDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_courierDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_fromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_toDate, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_fileReceivedReport, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_returnHistoryReport, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_fromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btn_fileReceivedReport, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_toDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(btn_returnHistoryReport, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_courierDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btn_fileReceivedReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fileReceivedReportActionPerformed
        LocalDate fromDate = txt_fromDate.getDate();
        LocalDate toDate = txt_toDate.getDate();
        if (fromDate != null && toDate != null) {
            ReportController reportController = new ReportController();
            reportController.getFileReceivedReport(fromDate, toDate.plusDays(1));
        } else {
//            ReportController reportController = new ReportController();
//            reportController.getFileReceivedReport();

            JOptionPane.showMessageDialog(null, "Please select a date range to generate report.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_fileReceivedReportActionPerformed

    private void btn_returnHistoryReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_returnHistoryReportActionPerformed
        LocalDate fromDate = txt_fromDate.getDate();
        LocalDate toDate = txt_toDate.getDate();
        if (fromDate != null && toDate != null) {
            ReportController reportController = new ReportController();
            reportController.getFileHistoryReport(fromDate, toDate.plusDays(1));
        } else {
//            ReportController reportController = new ReportController();
//            reportController.getFileHistoryReport();

            JOptionPane.showMessageDialog(null, "Please select a date range to generate report.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_returnHistoryReportActionPerformed

    private void btn_courierDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_courierDetailsActionPerformed
        LocalDate fromDate = txt_fromDate.getDate();
        LocalDate toDate = txt_toDate.getDate();
        if (fromDate != null && toDate != null) {
            ReportController reportController = new ReportController();
            reportController.getCourierDetailsReport(fromDate, toDate.plusDays(1));
        } else {
            JOptionPane.showMessageDialog(null, "Please select a date range to generate report.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_courierDetailsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_courierDetails;
    private javax.swing.JButton btn_fileReceivedReport;
    private javax.swing.JButton btn_returnHistoryReport;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private com.github.lgooddatepicker.components.DatePicker txt_fromDate;
    private com.github.lgooddatepicker.components.DatePicker txt_toDate;
    // End of variables declaration//GEN-END:variables
}
