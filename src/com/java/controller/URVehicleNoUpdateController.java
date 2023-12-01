/*
 * The MIT License
 *
 * Copyright 2021 Madushan Lahiru.
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
package com.java.controller;

import com.java.DataBaseConnection;
import com.java.entity.FileEntity;
import com.java.view.URVehicleNoUpdate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Madushan Lahiru
 */
public class URVehicleNoUpdateController {

  private final URVehicleNoUpdate view;
  private final DataBaseConnection connection;
  private final DefaultTableModel defaultTableModel;

  public URVehicleNoUpdateController(URVehicleNoUpdate view) {
    this.view = view;
    connection = new DataBaseConnection();
    defaultTableModel = (DefaultTableModel) view.tbl_URVehicles.getModel();
  }

  private List<FileEntity> getAllURVehicles() throws ClassNotFoundException, SQLException {
    String sql = "SELECT facility_no, vehicle_no FROM file_received WHERE vehicle_no LIKE 'U/R'";
    PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
    ResultSet resultSet = statement.executeQuery();
    List<FileEntity> files = new ArrayList<>();
    while (resultSet.next()) {
      FileEntity file = new FileEntity();
      file.setFacilityNo(resultSet.getString("facility_no"));
      file.setVehicleNo(resultSet.getString("vehicle_no"));
      files.add(file);
    }
    return files;
  }

  private List<FileEntity> getURVehicleByFacilityNo(String facilityNo) throws ClassNotFoundException, SQLException {
    String sql = "SELECT facility_no, vehicle_no FROM file_received WHERE vehicle_no LIKE 'U/R' AND facility_no LIKE ?";
    PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
    statement.setString(1, "%" + facilityNo);

    ResultSet resultSet = statement.executeQuery();
    List<FileEntity> files = new ArrayList<>();
    while (resultSet.next()) {
      FileEntity file = new FileEntity();
      file.setFacilityNo(resultSet.getString("facility_no"));
      file.setVehicleNo(resultSet.getString("vehicle_no"));
      files.add(file);
    }
    return files;
  }

  private int updateVehicleNo(String facilityNo, String vehicleNo) throws ClassNotFoundException, SQLException {
    String sql = "UPDATE file_received SET vehicle_no=? WHERE facility_no=?";
    PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
    statement.setString(1, vehicleNo);
    statement.setString(2, facilityNo);
    return statement.executeUpdate();
  }

  public void loadAllData() throws ClassNotFoundException, SQLException {
    loadDataToTable(getAllURVehicles());
  }

  public void search(String facilityNo) throws ClassNotFoundException, SQLException {
    List<FileEntity> records = getURVehicleByFacilityNo(facilityNo);
    if (!records.isEmpty()) {
      loadDataToTable(records);
    } else {
      JOptionPane.showMessageDialog(null, "No Data Found.", "Warning", JOptionPane.WARNING_MESSAGE);
    }
  }

  public int update(String facilityNo, String vehicleNo) throws ClassNotFoundException, SQLException {
    return updateVehicleNo(facilityNo, vehicleNo);
  }

  private void loadDataToTable(List<FileEntity> files) throws ClassNotFoundException, SQLException {
    clearTable();
    for (FileEntity file : files) {
      Object[] object = {file.getFacilityNo(), file.getVehicleNo()};
      defaultTableModel.addRow(object);
    }
  }

  public void clearTable() {
    while (defaultTableModel.getRowCount() > 0) {
      defaultTableModel.removeRow(0);
    }
  }

  public void clear() {
    view.txt_facilityNo.setText("");
    view.txt_facilityNo.setEditable(true);
    view.txt_vehicleNo.setText("");
  }

  public void close() throws SQLException {
    connection.DBClose();
  }

}
