/*
 * The MIT License
 *
 * Copyright 2021 Protector.
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
import com.java.entity.FileReturnHistory;
import com.java.model.DataModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Protector
 */
public class EditController {
    
    private DataModel dataModel;
    private DataBaseConnection connection;

    public EditController() {
        dataModel = new DataModel();
        connection = new DataBaseConnection();
    }
    
    public FileEntity getFileDetails(String facilityNo) {
        FileEntity file = null;
        try {
            file = dataModel.getFileReceivedDataByFacilityNo(facilityNo);
            file.setReturnHistory(dataModel.getFileReturnHistoryData(facilityNo));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return file;
    }
    
    public void removeFile(FileEntity removingFile, String reason, String user) {
        try {
            updateFileReceivedFacilityNo(removingFile.getId().intValue(), String.format("%s_REMOVED", removingFile.getId()));
//            updateReturnHistoryFacilityNo(removingFile.getFacilityNo(), String.format("%s_REMOVED", removingFile.getId()));
            insertFileRemoveLog(removingFile.getId().intValue(), reason, removingFile.getFacilityNo(), user);
        } catch (SQLException ex) {
            Logger.getLogger(EditController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private int updateFileReceivedFacilityNo(int fileId, String facilityNo) throws SQLException {
        String sql = "UPDATE file_received SET facility_no = ?, is_removed = true WHERE id = ?";
        PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
        statement.setString(1, facilityNo);
        statement.setInt(2, fileId);
        return statement.executeUpdate();
    }
    
    /*private int updateReturnHistoryFacilityNo(String facilityNo, String newFacilityNo) throws SQLException {
        String sql = "UPDATE file_return SET facility_no = ? WHERE facility_no = ";
        PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
        statement.setString(2, facilityNo);
        statement.setString(1, newFacilityNo);
        return statement.executeUpdate();
    }*/
    
    private int insertFileRemoveLog(int fileId, String facilityNo, String reason, String removedUser) throws SQLException {
        String sql = "INSERT INTO removed_file(file_id, facility_no, reason, removed_user) VALUES(?, ?, ?, ?)";
        PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
        statement.setInt(1, fileId);
        statement.setString(2, facilityNo);
        statement.setString(3, reason);
        statement.setString(4, removedUser);
        return statement.executeUpdate();
    }
    
}
