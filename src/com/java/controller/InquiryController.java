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
import com.java.view.Inquiry;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Madushan Lahiru
 */
public class InquiryController {

  private final DataBaseConnection connection;
  private final Inquiry frame;

  public InquiryController(Inquiry frame) {
    connection = new DataBaseConnection();
    this.frame = frame;
  }

  private FileEntity getDataByFacilityNo(String facilityNo) throws ClassNotFoundException, SQLException {
    String sql = "SELECT id, date_time, facility_no, vehicle_no, file_type, comment, completed_date_time, "
            + "entered_user FROM file_received WHERE facility_no=?";
    PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
    statement.setString(1, facilityNo);
    ResultSet resultSet = statement.executeQuery();
    FileEntity file = new FileEntity();
    while (resultSet.next()) {
      file.setId(resultSet.getLong("id"));
      file.setDateTime(resultSet.getTimestamp("date_time"));
      file.setFacilityNo(resultSet.getString("facility_no"));
      file.setVehicleNo(resultSet.getString("vehicle_no"));
      file.setFileType(resultSet.getInt("file_type"));
      file.setComment(resultSet.getInt("comment"));
      file.setCompletedDataTime(resultSet.getTimestamp("completed_date_time"));
      file.setEnteredUser(resultSet.getString("entered_user"));
    }
    return file;
  }

  private List<FileReturnHistory> getFileReturnHistoryData(String facilityNo) throws ClassNotFoundException, SQLException {
    String sql = "SELECT fr.facility_no, fre.process, fre.updated_comment, fre.returned_date_time, fre.received_date_time, "
        + "fre.returned_user, fre.received_user FROM file_return AS fre JOIN file_received AS fr ON fr.id = fre.file_id " 
        + "WHERE fr.facility_no = ?";
    PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
    statement.setString(1, facilityNo);
    ResultSet resultSet = statement.executeQuery();
    List<FileReturnHistory> history = new ArrayList<>();

    while (resultSet.next()) {
      FileReturnHistory record = new FileReturnHistory();
      record.setFacilityNo(resultSet.getString("facility_no"));
      record.setProcess(resultSet.getInt("process"));
      record.setUpdatedComment(resultSet.getString("updated_comment"));
      record.setReturnedDateTime(resultSet.getTimestamp("returned_date_time"));
      record.setReceivedDateTime(resultSet.getTimestamp("received_date_time"));
      record.setReturnedUser(resultSet.getString("returned_user"));
      record.setReceivedUser(resultSet.getString("received_user"));
      history.add(record);
    }
    return history;
  }

  public void setData(String facilityNo) {

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh.mm aa");

    try {
      FileEntity fileDetails = getDataByFacilityNo(facilityNo);
      List<FileReturnHistory> records = getFileReturnHistoryData(facilityNo);

      frame.txt_facilityNo.setText(fileDetails.getFacilityNo());
      frame.txt_vehicleNo.setText(fileDetails.getVehicleNo());
      frame.txt_acceptedDateTime.setText(dateFormat.format(fileDetails.getDateTime()));
      frame.txt_fileType.setText(CommonUtils.selectFileType(fileDetails.getFileType()));
      frame.txt_comment.setText(CommonUtils.selectComment(fileDetails.getComment()));
      frame.txt_completedDateTime.setText(fileDetails.getCompletedDataTime() != null
              && !dateFormat.format(fileDetails.getCompletedDataTime()).equals("01-01-1990 00.00 AM")
              ? dateFormat.format(fileDetails.getCompletedDataTime()) : "");
      frame.txt_enteredUser.setText(fileDetails.getEnteredUser());

      DefaultTableModel model = (DefaultTableModel) frame.tbl_records.getModel();
      for (FileReturnHistory file : records) {
        String returnReceivedDateTime = file.getReceivedDateTime() != null
                ? dateFormat.format(file.getReceivedDateTime()) : "";
        Object[] obj = {dateFormat.format(file.getReturnedDateTime()), CommonUtils.selectProcess(file.getProcess()),
          file.getUpdatedComment(), returnReceivedDateTime, file.getReturnedUser(), file.getReceivedUser()};
        model.addRow(obj);
      }

    } catch (ClassNotFoundException | SQLException ex) {
      Logger.getLogger(Inquiry.class.getName()).log(Level.SEVERE, null, ex);
    }

  }
}
