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

import com.java.CommonUtils;
import com.java.DataBaseConnection;
import com.java.entity.FileEntity;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Madushan Lahiru
 */
public class HistoryController {

  private final DataBaseConnection connection;
  private final SimpleDateFormat dateFormat;

  public HistoryController() {
    connection = new DataBaseConnection();
    dateFormat = new SimpleDateFormat("dd-MM-yyyy hh.mm aa");
  }

  private List<FileEntity> getData(PreparedStatement statement, String sql) throws ClassNotFoundException, SQLException {
    ResultSet resultSet = statement.executeQuery();
    List<FileEntity> files = new ArrayList<>();
    while (resultSet.next()) {
      FileEntity file = new FileEntity();
      file.setId(resultSet.getLong("id"));
      file.setDateTime(resultSet.getTimestamp("date_time"));
      file.setFacilityNo(resultSet.getString("facility_no"));
      file.setVehicleNo(resultSet.getString("vehicle_no"));
      file.setFileType(resultSet.getInt("file_type"));
      file.setComment(resultSet.getInt("comment"));
      file.setCompletedDataTime(resultSet.getTimestamp("completed_date_time"));
      file.setEnteredUser(resultSet.getString("entered_user"));

      files.add(file);
    }
    return files;
  }

  private List<FileEntity> getAllData() throws ClassNotFoundException, SQLException {
    String sql = "SELECT id, date_time, facility_no, vehicle_no, file_type, comment, completed_date_time, "
            + "entered_user FROM file_received WHERE is_removed = false";
    PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);

    return getData(statement, sql);
  }

  private List<FileEntity> getAllDataByFacilityNo(String facilityNo) throws ClassNotFoundException, SQLException {
    String sql = "SELECT id, date_time, facility_no, vehicle_no, file_type, comment, completed_date_time, "
            + "entered_user FROM file_received WHERE facility_no LIKE ?";
    PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
    statement.setString(1, "%" + facilityNo);

    return getData(statement, sql);
  }

  private List<FileEntity> getAllDataByVehicleNo(String vehicleNo) throws ClassNotFoundException, SQLException {
    String sql = "SELECT id, date_time, facility_no, vehicle_no, file_type, comment, completed_date_time, "
            + "entered_user FROM file_received WHERE vehicle_no LIKE ?";
    PreparedStatement statement = new DataBaseConnection().getDBConnection().prepareStatement(sql);
    statement.setString(1, "%" + vehicleNo);

    return getData(statement, sql);
  }

  private List<FileEntity> getAllDataByDatePeriod(LocalDate fromDate, LocalDate toDate) throws ClassNotFoundException, SQLException {
    String sql = "SELECT id, date_time, facility_no, vehicle_no, file_type, comment, completed_date_time, "
            + "entered_user FROM file_received WHERE date_time BETWEEN ? AND ?";
    PreparedStatement statement = new DataBaseConnection().getDBConnection().prepareStatement(sql);
    statement.setDate(1, Date.valueOf(fromDate));
    statement.setDate(2, Date.valueOf(toDate));

    return getData(statement, sql);
  }

  public void setAllDatatoTable(JTable table) throws ClassNotFoundException, SQLException {
    setDataToTable(table, getAllData());
  }

  public void searchByFacilityNo(JTable table, String facilityNo) throws ClassNotFoundException, SQLException {
    List<FileEntity> records = getAllDataByFacilityNo(facilityNo);
    if (!records.isEmpty()) {
      setDataToTable(table, records);
    } else {
      JOptionPane.showMessageDialog(null, "No Data Found.", "Warning", JOptionPane.WARNING_MESSAGE);
    }
  }

  public void searchByVehicleNo(JTable table, String vehicleNo) throws ClassNotFoundException, SQLException {
    List<FileEntity> records = getAllDataByVehicleNo(vehicleNo);
    if (!records.isEmpty()) {
      setDataToTable(table, records);
    } else {
      JOptionPane.showMessageDialog(null, "No Data Found.", "Warning", JOptionPane.WARNING_MESSAGE);
    }
  }

  public void searchByDatePeriod(JTable table, LocalDate fromDate, LocalDate toDate) throws ClassNotFoundException, SQLException {
    List<FileEntity> records = getAllDataByDatePeriod(fromDate, toDate);
    if (!records.isEmpty()) {
      setDataToTable(table, records);
    } else {
      JOptionPane.showMessageDialog(null, "No Data Found.", "Warning", JOptionPane.WARNING_MESSAGE);
    }
  }

  private void setDataToTable(JTable table, List<FileEntity> data) {
    clearTable(table);
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    for (FileEntity file : data) {
      String completedDate = "";
      if (file.getCompletedDataTime() != null) {
        if (!dateFormat.format(file.getCompletedDataTime()).equals("01-01-1990 00.00 AM")) {
          completedDate = dateFormat.format(file.getCompletedDataTime());
        }
      }

      Object[] obj = {dateFormat.format(file.getDateTime()), file.getFacilityNo(), file.getVehicleNo(),
        CommonUtils.selectFileType(file.getFileType()), CommonUtils.selectComment(file.getComment()),
        completedDate, file.getEnteredUser()};
      model.addRow(obj);
    }
  }

  public void clearTable(JTable table) {
    DefaultTableModel tablMmodel = (DefaultTableModel) table.getModel();
    while (tablMmodel.getRowCount() > 0) {
      tablMmodel.removeRow(0);
    }
  }

}
