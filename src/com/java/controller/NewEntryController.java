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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author Madushan Lahiru
 */
public class NewEntryController {

  private final DataBaseConnection connection;

  public NewEntryController() {
    connection = new DataBaseConnection();
  }

  private int saveData(FileEntity file) throws SQLException, ClassNotFoundException {
    String sql = "INSERT INTO file_received(date_time, facility_no, vehicle_no, file_type, comment, entered_user) VALUES(?, ?, ?, ?, ?, ?)";
    PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
    statement.setTimestamp(1, file.getDateTime());
    statement.setString(2, file.getFacilityNo());
    statement.setString(3, file.getVehicleNo());
    statement.setInt(4, file.getFileType());
    statement.setInt(5, file.getComment());
    statement.setString(6, file.getEnteredUser());

    return statement.executeUpdate();
  }

  public int save(String facilityNo, String vehicleNo, int fileType, int comment) {
    if (CommonUtils.facilityNoValidator(facilityNo)) {
      if (CommonUtils.vehicleNoValidator(vehicleNo) || vehicleNo.equals("U/R") || vehicleNo.equals("MX") || vehicleNo.equals("PL")
              || vehicleNo.equals("AD") || vehicleNo.equals("PM") || vehicleNo.equals("GM")) {

        String user = System.getProperty("user.name");
        FileEntity file = new FileEntity(Timestamp.valueOf(LocalDateTime.now()), facilityNo, vehicleNo,
                fileType, comment, user);

        try {
          int i = saveData(file);
          if (i == 1) {
            return i;
          }
        } catch (SQLException ex) {
          if (ex.getErrorCode() == 1062) {
            JOptionPane.showMessageDialog(null, "Duplicate data found.", "Warning", JOptionPane.WARNING_MESSAGE);
          } else {
              System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Database connection not found.", "Error", JOptionPane.ERROR_MESSAGE);
          }
        } catch (ClassNotFoundException ex) {
          JOptionPane.showMessageDialog(null, "Database connection not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
      } else {
        JOptionPane.showMessageDialog(null, "Please enter valid vehicle number.", "Warning", JOptionPane.WARNING_MESSAGE);
      }
    } else {
      JOptionPane.showMessageDialog(null, "Please enter valid facility number.", "Warning", JOptionPane.WARNING_MESSAGE);
    }
    return 0;
  }

}
