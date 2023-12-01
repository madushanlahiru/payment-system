/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.view;

import com.java.CommonUtils;
import com.java.controller.NewEntryController;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author 927
 */
public class NewEntry extends JFrame {

    /**
     * Creates new form NewEntry
     */
    public NewEntry() {
        initComponents();
        this.setIconImage(new ImageIcon("images/logo_1.png").getImage());

        // Load file type items
        for (String item : CommonUtils.TYPE) {
            cb_fileType.addItem(item);
        }
        // Load comment items
        for (String item : CommonUtils.COMMENT) {
            cb_comment.addItem(item);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_facilityNo = new javax.swing.JTextField();
        txt_vehicleNo = new javax.swing.JTextField();
        cb_fileType = new javax.swing.JComboBox<>();
        btn_clear = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        cb_comment = new javax.swing.JComboBox<>();
        lable_error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Accepting Files From Related Party");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Accepting Files From Related Party");
        jLabel1.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Facility No.");
        jLabel2.setFocusable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Vehicle No.");
        jLabel3.setFocusable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("File Type");
        jLabel4.setFocusable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Comments");
        jLabel5.setFocusable(false);

        txt_facilityNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_facilityNo.setToolTipText("");
        txt_facilityNo.setNextFocusableComponent(txt_vehicleNo);

        txt_vehicleNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_vehicleNo.setToolTipText("");
        txt_vehicleNo.setNextFocusableComponent(cb_fileType);
        txt_vehicleNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_vehicleNoFocusGained(evt);
            }
        });

        cb_fileType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_fileType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<--- Select File Type --->" }));
        cb_fileType.setToolTipText("");
        cb_fileType.setNextFocusableComponent(cb_comment);

        btn_clear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_clear.setText("Clear");
        btn_clear.setFocusable(false);
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_save.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_save.setText("Save");
        btn_save.setToolTipText("");
        btn_save.setNextFocusableComponent(txt_facilityNo);
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        btn_save.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_saveKeyPressed(evt);
            }
        });

        cb_comment.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_comment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<--- Select Comment --->" }));
        cb_comment.setToolTipText("");
        cb_comment.setNextFocusableComponent(btn_save);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_facilityNo)
                    .addComponent(txt_vehicleNo)
                    .addComponent(cb_fileType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_comment, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lable_error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_facilityNo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lable_error, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_vehicleNo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cb_fileType, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_comment, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btn_saveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_saveKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btn_saveActionPerformed(new ActionEvent(evt, 0, null));
        }
    }//GEN-LAST:event_btn_saveKeyPressed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        if (!txt_facilityNo.getText().isEmpty() && !txt_vehicleNo.getText().isEmpty()
            && cb_fileType.getSelectedIndex() != 0 && cb_comment.getSelectedIndex() != 0) {
            int i = new NewEntryController().save(txt_facilityNo.getText().trim().toUpperCase(), txt_vehicleNo.getText().trim().toUpperCase(),
                cb_fileType.getSelectedIndex(), cb_comment.getSelectedIndex());
            if (i == 1) {
                JOptionPane.showMessageDialog(null, "Data saved successfuly.", "Success", JOptionPane.INFORMATION_MESSAGE);
                btn_clearActionPerformed(new ActionEvent(evt, 0, null));
            } else {
                JOptionPane.showMessageDialog(this, "Data not saved, Please try again.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            this.nextFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Please fill all the details.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        txt_facilityNo.setText("");
        txt_vehicleNo.setText("");
        cb_fileType.setSelectedIndex(0);
        cb_comment.setSelectedIndex(0);
    }//GEN-LAST:event_btn_clearActionPerformed

    private void txt_vehicleNoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_vehicleNoFocusGained
        String code = txt_facilityNo.getText().trim().length() != 0 ? txt_facilityNo.getText().trim().toUpperCase().substring(5, 7) : "";
        if (code.equals("PM") || code.equals("MX") || code.equals("PL") || code.equals("AD") || code.equals("GM")) {
            txt_vehicleNo.setText(code);
        }
        txt_vehicleNo.selectAll();
    }//GEN-LAST:event_txt_vehicleNoFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_save;
    private javax.swing.JComboBox<String> cb_comment;
    private javax.swing.JComboBox<String> cb_fileType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lable_error;
    private javax.swing.JTextField txt_facilityNo;
    private javax.swing.JTextField txt_vehicleNo;
    // End of variables declaration//GEN-END:variables

}