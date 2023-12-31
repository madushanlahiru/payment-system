/*
 * The MIT License
 *
 * Copyright 2023 SandBox.
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

import com.java.controller.CourierScheduleController;
import com.java.entity.CourierScheduleDetail;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SandBox
 */
public class EditCourierSchedule extends javax.swing.JFrame {
    
    private CourierScheduleController controller;
    private Map<String, String> branches;
    private List<String> courierCatogories;
    private List<String> chequeTypes;
    private List<CourierScheduleDetail> records;
    
    private CourierScheduleDetail oldRecord;
    private CourierScheduleDetail newRecord;

    /**
     * Creates new form CourierSchedule
     */
    public EditCourierSchedule() {
        initComponents();
        this.setIconImage(new ImageIcon("images/logo_1.png").getImage());
 
        controller = new CourierScheduleController();

        try {
            branches = controller.getBranchList();
            branches.values().forEach(branch -> cbCourierBranch.addItem(branch));
            
            courierCatogories = controller.getCourierCategoryList();
            courierCatogories.forEach(category -> cbCourierMethod.addItem(category));
            
            chequeTypes = controller.getChequeTypeList();
            chequeTypes.forEach(type -> cbChequeType.addItem(type));
        } catch (SQLException ex) {
            Logger.getLogger(EditCourierSchedule.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Validation
        txtChequeNo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || txtChequeNo.getText().length() >= 6) {
                    e.consume(); // Ignore the key event if it's not a digit or exceeds 6 characters.
                }
            }
        });
        
        txtChequeAmount.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.') {
                    e.consume(); // Ignore the key event if it's not a digit or exceeds 6 characters.
                }
            }
        });

        cbCourierMethod.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent arg0) {
                if(arg0.getStateChange() == 1 && arg0.getItem().equals("SAME BRANCH")){
                    cbCourierBranch.setSelectedItem(branches.get(txtFacilityNo.getText().substring(0, 3)));
                    cbCourierBranch.setEnabled(false);
                } else if(arg0.getStateChange() == 1 && arg0.getItem().equals("COLLECT FROM HEAD OFFICE")){
                    cbCourierBranch.setSelectedItem(branches.get("HOF"));
                    cbCourierBranch.setEnabled(false);
                } else {
                    cbCourierBranch.setEnabled(true);
                }
            }
        });
         
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetails = new javax.swing.JTable();
        cbCourierMethod = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtFacilityNo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbCourierBranch = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbChequeType = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRemarks = new javax.swing.JTextArea();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        txtChequeNo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtChequeAmount = new javax.swing.JFormattedTextField();
        btnRemove = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Courier Details");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setName(""); // NOI18N

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setFocusable(false);
        jScrollPane2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane2.setPreferredSize(new java.awt.Dimension(100, 50));

        tblDetails.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cheque Type", "Cheque No", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetails.setFocusable(false);
        tblDetails.setRowHeight(20);
        tblDetails.setShowGrid(true);
        tblDetails.getTableHeader().setReorderingAllowed(false);
        tblDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDetails);
        if (tblDetails.getColumnModel().getColumnCount() > 0) {
            tblDetails.getColumnModel().getColumn(0).setResizable(false);
            tblDetails.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblDetails.getColumnModel().getColumn(1).setResizable(false);
            tblDetails.getColumnModel().getColumn(2).setResizable(false);
        }

        cbCourierMethod.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbCourierMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select a Method --" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setLabelFor(cbCourierMethod);
        jLabel1.setText("Facility No");

        txtFacilityNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setLabelFor(cbCourierMethod);
        jLabel2.setText("Courier Method");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setLabelFor(cbCourierMethod);
        jLabel3.setText("Courier Branch");

        cbCourierBranch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbCourierBranch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select a Branch --" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setLabelFor(cbCourierMethod);
        jLabel4.setText("Cheque No");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setLabelFor(cbCourierMethod);
        jLabel5.setText("Cheque Type");

        cbChequeType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbChequeType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select a Type --" }));

        jLabel7.setText("(Optional)");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setLabelFor(cbCourierMethod);
        jLabel6.setText("Remarks");

        txtRemarks.setColumns(20);
        txtRemarks.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtRemarks.setLineWrap(true);
        txtRemarks.setRows(5);
        txtRemarks.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtRemarks);

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        txtChequeNo.setColumns(6);
        txtChequeNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setLabelFor(cbCourierMethod);
        jLabel8.setText("Cheque Amount");

        txtChequeAmount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        txtChequeAmount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtChequeAmount.setName(""); // NOI18N

        btnRemove.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtChequeNo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCourierBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtFacilityNo, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbCourierMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(78, 78, 78))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtChequeAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(67, 73, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbChequeType, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFacilityNo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCourierMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCourierBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbChequeType, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChequeNo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtChequeAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
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

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtFacilityNo.setText("");
        cbChequeType.setSelectedIndex(0);
        cbCourierBranch.setSelectedIndex(0);
        cbCourierMethod.setSelectedIndex(0);
        txtChequeNo.setText("");
        txtChequeAmount.setText("");
        txtRemarks.setText("");
        clearTableData();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String facilityNo = txtFacilityNo.getText().trim().toUpperCase();
        int chequeType = cbChequeType.getSelectedIndex();
        int courierBranch = cbCourierBranch.getSelectedIndex();
        int courierMethod = cbCourierMethod.getSelectedIndex();
        String chequeNo = txtChequeNo.getText();
        String chequeAmount = txtChequeAmount.getText().replace(",", "");
        String remarks = txtRemarks.getText();

        if(facilityNo.isEmpty() || chequeType == 0 || courierBranch == 0 || courierMethod == 0 || chequeNo.length() < 6 || chequeAmount.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Provide all the necessary data.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                String user = System.getProperty("user.name");
                newRecord = new CourierScheduleDetail();
                
                newRecord.setChequeType(chequeType);
                newRecord.setCourierBranch(courierBranch);
                newRecord.setCourierCategory(courierMethod);
                newRecord.setChequeNo(Integer.parseInt(chequeNo));
                newRecord.setChequeAmount(Double.parseDouble(chequeAmount));
                newRecord.setRemarks(remarks);
                newRecord.setAddedUser(user);
                                
                int result = controller.updateScheduleDetails(oldRecord, newRecord);
                if(result != 0) {
                    btnClearActionPerformed(null);
                    JOptionPane.showMessageDialog(this, "Data updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getErrorCode());
                if(ex.getErrorCode() == 1048) {
                    JOptionPane.showMessageDialog(this, "Entered Facility No not found in the system.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(EditCourierSchedule.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            String facilityNo = txtFacilityNo.getText().trim().toUpperCase();
            records = controller.getCourierDetails(facilityNo);
            setDataToTable(records);
        } catch (SQLException ex) {
            Logger.getLogger(EditCourierSchedule.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "No records found for entered facility number.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tblDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetailsMouseClicked
        if (evt.getClickCount() == 2) {
            DefaultTableModel model = (DefaultTableModel) tblDetails.getModel();
            int chequeNo = (int) model.getValueAt(tblDetails.getSelectedRow(), 1);
            oldRecord = records.stream().filter(record -> (chequeNo == record.getChequeNo())).findAny().get();
            
            if (!oldRecord.isIsPrinted()) {
                cbChequeType.setSelectedIndex(oldRecord.getChequeType());
                cbCourierBranch.setSelectedIndex(oldRecord.getCourierBranch());
                cbCourierMethod.setSelectedIndex(oldRecord.getCourierCategory());
                txtChequeNo.setText(Integer.toString(oldRecord.getChequeNo()));
                txtChequeAmount.setText(Double.toString(oldRecord.getChequeAmount()));
                txtRemarks.setText(oldRecord.getRemarks());

                model.removeRow(tblDetails.getSelectedRow());
            } else {
                JOptionPane.showMessageDialog(this, "Selected record already printed. Can not edit or remove.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_tblDetailsMouseClicked

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        try {
            int chequeNo = Integer.parseInt(txtChequeNo.getText());
            oldRecord = records.stream().filter(record -> (chequeNo == record.getChequeNo())).findAny().get();
            
            int result = JOptionPane.showConfirmDialog(this, String.format("Do you confirm to remove this from the system?\n "
            + "This operation can not reverse."), "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
            if (result == JOptionPane.YES_OPTION) {
                controller.deleteScheduleDetail(oldRecord);
                JOptionPane.showMessageDialog(this, "Record removed successfully.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                btnClearActionPerformed(null);
            }
            
        } catch (SQLException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please select a record to remove.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRemoveActionPerformed
    
    private void setDataToTable(List<CourierScheduleDetail> records) {
        DefaultTableModel model = (DefaultTableModel) tblDetails.getModel();
        for (CourierScheduleDetail record : records) {
            Object[] obj = {chequeTypes.get(record.getChequeType() - 1), record.getChequeNo(), 
                record.getChequeAmount()};
            model.addRow(obj);
        }
    }
    
    private void clearTableData() {
        DefaultTableModel tablMmodel = (DefaultTableModel) tblDetails.getModel();
        while (tablMmodel.getRowCount() > 0) {
          tablMmodel.removeRow(0);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbChequeType;
    private javax.swing.JComboBox<String> cbCourierBranch;
    private javax.swing.JComboBox<String> cbCourierMethod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDetails;
    private javax.swing.JFormattedTextField txtChequeAmount;
    private javax.swing.JTextField txtChequeNo;
    private javax.swing.JTextField txtFacilityNo;
    private javax.swing.JTextArea txtRemarks;
    // End of variables declaration//GEN-END:variables
}
