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
import com.java.entity.FileReturnHistory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Madushan Lahiru
 */
public class UpdateEntryController {

  private final DataBaseConnection connection;
  private final String user;

  public UpdateEntryController() {
    connection = new DataBaseConnection();
    user = System.getProperty("user.name");
  }

  private FileEntity getDetailsByFacilityNo(String facilityNo) throws ClassNotFoundException, SQLException {
    String sql = "SELECT id, date_time, facility_no, vehicle_no, file_type, comment FROM file_received WHERE "
            + "facility_no=?";
    PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
    statement.setString(1, facilityNo);
    ResultSet resultSet = statement.executeQuery();
    if (resultSet.next()) {
      FileEntity file = new FileEntity();
      file.setId(resultSet.getLong("id"));
      file.setDateTime(resultSet.getTimestamp("date_time"));
      file.setFacilityNo(resultSet.getString("facility_no"));
      file.setVehicleNo(resultSet.getString("vehicle_no"));
      file.setFileType(resultSet.getInt("file_type"));
      file.setComment(resultSet.getInt("comment"));
      return file;
    }
    
    return null;
  }

  private List<String> getFacilityNosByVehicleNo(String vehicleNo) throws ClassNotFoundException, SQLException {
    String sql = "SELECT facility_no FROM file_received WHERE vehicle_no LIKE ?";
    PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
    statement.setString(1, "%" + vehicleNo);
    ResultSet resultSet = statement.executeQuery();
    List<String> files = new ArrayList<>();
    while (resultSet.next()) {
      files.add(resultSet.getString("facility_no"));
    }

    return files;
  }

  private List<FileReturnHistory> getReturnHistory(String facilityNo) throws ClassNotFoundException, SQLException {
    String sql = "SELECT fr.facility_no, fre.process, fre.updated_comment, fre.returned_date_time, fre.received_date_time "
        + "FROM file_return AS fre JOIN file_received AS fr ON fr.id = fre.file_id " 
        + "WHERE fr.facility_no = ?";
    PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
    statement.setString(1, facilityNo);
    ResultSet resultSet = statement.executeQuery();
    List<FileReturnHistory> files = new ArrayList<>();
    while (resultSet.next()) {
      FileReturnHistory file = new FileReturnHistory();
      file.setFacilityNo(resultSet.getString("facility_no"));
      file.setProcess(resultSet.getInt("process"));
      file.setUpdatedComment(resultSet.getString("updated_comment"));
      file.setReturnedDateTime(resultSet.getTimestamp("returned_date_time"));
      file.setReceivedDateTime(resultSet.getTimestamp("received_date_time"));
      files.add(file);
    }

    return files;
  }

  private int saveReturnRecord(FileReturnHistory record, Timestamp completedTime) throws ClassNotFoundException, SQLException {
    String sql = "INSERT INTO file_return(file_id, process, updated_comment, returned_date_time, returned_user) "
            + "VALUES((SELECT id FROM file_received WHERE facility_no = ?), ?, ?, NOW(), ?)";
    PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
    statement.setString(1, record.getFacilityNo());
    statement.setInt(2, record.getProcess());
    statement.setString(3, record.getUpdatedComment());
    statement.setString(4, user);
    int i = statement.executeUpdate();
    if (i == 1 && completedTime != null) {
      String sql1 = "UPDATE file_received SET completed_date_time=? WHERE facility_no=?";
      PreparedStatement statement1 = connection.getDBConnection().prepareStatement(sql1);
      statement1.setTimestamp(1, completedTime);
      statement1.setString(2, record.getFacilityNo());
      i = statement1.executeUpdate();
    }

    return i;
  }

  private int updateReturnRecord(String facilityNo, String receivedUser) throws ClassNotFoundException, SQLException {
    String sql = "UPDATE file_return SET received_date_time=NOW(), received_user=? WHERE file_id = "
            + "(SELECT id FROM file_received WHERE facility_no=?) "
            + "ORDER BY returned_date_time DESC LIMIT 1";
    PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
    statement.setString(1, receivedUser);
    statement.setString(2, facilityNo);
    int i = statement.executeUpdate();

    return i;
  }

  public FileEntity getDataByFacilityNo(String facilityNo) {
    if (CommonUtils.facilityNoValidator(facilityNo)) {
      try {
        FileEntity file = getDetailsByFacilityNo(facilityNo);
        if (file != null) {
          file.setReturnHistory(getReturnHistory(facilityNo));
          return file;
        } else {
          return null;
        }
      } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(UpdateEntryController.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Database connection error.", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
    
    return null;
  }

  public List<FileReturnHistory> getReturnHistoryData(String facilityNo) {
    try {
      return getReturnHistory(facilityNo);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(UpdateEntryController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(UpdateEntryController.class.getName()).log(Level.SEVERE, null, ex);
      JOptionPane.showMessageDialog(null, "Database connection error.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    return null;
  }

  public List<String> getDataByVehicleNo(String vehicleNo) {
    if (CommonUtils.vehicleNoValidator(vehicleNo)) {
      try {
        return getFacilityNosByVehicleNo(vehicleNo);
      } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(UpdateEntryController.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Database connection error.", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
    return null;
  }

  public int updateFileReturn(String facilityNo) {
    try {
      return updateReturnRecord(facilityNo, user);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(UpdateEntryController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(UpdateEntryController.class.getName()).log(Level.SEVERE, null, ex);
      JOptionPane.showMessageDialog(null, "Database connection error.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    return 0;
  }

  public int insertReturnRecord(FileReturnHistory history, Timestamp completedTime) {
    try {
      return saveReturnRecord(history, completedTime);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(UpdateEntryController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(UpdateEntryController.class.getName()).log(Level.SEVERE, null, ex);
      JOptionPane.showMessageDialog(null, "Database connection error.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    return 0;
  }

}
