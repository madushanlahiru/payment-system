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

import com.java.DBExcelExport;
import com.java.DataBaseConnection;
import com.java.entity.FileEntity;
import com.java.entity.FileReportEntity;
import com.java.entity.ScheduleReportEntity;
import com.java.model.DataModel;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Protector
 */
public class ReportController {
    
    private final DataBaseConnection connection;

    public ReportController() {
        connection = new DataBaseConnection();
    }

    public void getFileReceivedReport() {
        try {
            DBExcelExport report = new DBExcelExport();
            report.export(getAllFileReceivedData());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getFileReceivedReport(LocalDate fromDate, LocalDate toDate) {
        try {
            DBExcelExport report = new DBExcelExport();
            report.export(getAllFileReceivedData(fromDate, toDate));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getFileHistoryReport(LocalDate fromDate, LocalDate toDate) {
        try {
            DBExcelExport report = new DBExcelExport();
            report.exportWithHistory(getAllFileHistoryData(fromDate, toDate));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getFileHistoryReport() {
        try {
            DBExcelExport report = new DBExcelExport();
            report.exportWithHistory(getAllFileHistoryData());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getCourierDetailsReport(LocalDate fromDate, LocalDate toDate) {
        try {
            DBExcelExport report = new DBExcelExport();
            report.exportScheduleDetails(getAllCourierData(fromDate, toDate));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private List<FileEntity> getAllFileReceivedData() throws ClassNotFoundException, SQLException {
        String sql = "SELECT id, date_time, facility_no, vehicle_no, file_type, comment, completed_date_time, "
                + "entered_user FROM file_received";
        PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
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
    
    private List<FileEntity> getAllFileReceivedData(LocalDate fromDate, LocalDate toDate) throws ClassNotFoundException, SQLException {
        String sql = "SELECT id, date_time, facility_no, vehicle_no, file_type, comment, completed_date_time, "
            + "entered_user FROM file_received WHERE date_time BETWEEN ? AND ?";
        PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
        statement.setDate(1, Date.valueOf(fromDate));
        statement.setDate(2, Date.valueOf(toDate));
        
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

    private List<FileReportEntity> getAllFileHistoryData() throws ClassNotFoundException, SQLException {
        String sql = "SELECT R.id, R.date_time, R.facility_no, R.vehicle_no, R.file_type, R.comment, R.completed_date_time,"
                + " R.entered_user, H.process, H.updated_comment, H.returned_date_time, H.received_date_time, H.returned_user,"
                + " H.received_user FROM file_received R LEFT JOIN file_return H ON R.id = H.file_id"
                + " ORDER BY R.date_time ASC, H.returned_date_time ASC";
        PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<FileReportEntity> files = new ArrayList<>();

        while (resultSet.next()) {
            FileReportEntity file = new FileReportEntity();

            file.setId(resultSet.getLong("id"));
            file.setDateTime(resultSet.getTimestamp("date_time"));
            file.setFacilityNo(resultSet.getString("facility_no"));
            file.setVehicleNo(resultSet.getString("vehicle_no"));
            file.setFileType(resultSet.getInt("file_type"));
            file.setComment(resultSet.getInt("comment"));
            file.setCompletedDateTime(resultSet.getTimestamp("completed_date_time"));
            file.setEnteredUser(resultSet.getString("entered_user"));

            file.setProcess(resultSet.getInt("process"));
            file.setUpdatedComment(resultSet.getString("updated_comment"));
            file.setReturnedDateTime(resultSet.getTimestamp("returned_date_time"));
            file.setReceivedDateTime(resultSet.getTimestamp("received_date_time"));
            file.setReturnedUser(resultSet.getString("returned_user"));
            file.setReceivedUser(resultSet.getString("received_user"));

            files.add(file);
        }
        return files;
    }

    private List<FileReportEntity> getAllFileHistoryData(LocalDate fromDate, LocalDate toDate) throws ClassNotFoundException, SQLException {
        String sql = "SELECT R.id, R.date_time, R.facility_no, R.vehicle_no, R.file_type, R.comment, R.completed_date_time,"
                + " R.entered_user, H.process, H.updated_comment, H.returned_date_time, H.received_date_time, H.returned_user,"
                + " H.received_user FROM file_received R LEFT JOIN file_return H ON R.id = H.file_id"
                + " WHERE R.date_time BETWEEN ? AND ? ORDER BY R.date_time ASC, H.returned_date_time ASC ";
        PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
        statement.setDate(1, Date.valueOf(fromDate));
        statement.setDate(2, Date.valueOf(toDate));
        
        ResultSet resultSet = statement.executeQuery();
        List<FileReportEntity> files = new ArrayList<>();

        while (resultSet.next()) {
            FileReportEntity file = new FileReportEntity();

            file.setId(resultSet.getLong("id"));
            file.setDateTime(resultSet.getTimestamp("date_time"));
            file.setFacilityNo(resultSet.getString("facility_no"));
            file.setVehicleNo(resultSet.getString("vehicle_no"));
            file.setFileType(resultSet.getInt("file_type"));
            file.setComment(resultSet.getInt("comment"));
            file.setCompletedDateTime(resultSet.getTimestamp("completed_date_time"));
            file.setEnteredUser(resultSet.getString("entered_user"));

            file.setProcess(resultSet.getInt("process"));
            file.setUpdatedComment(resultSet.getString("updated_comment"));
            file.setReturnedDateTime(resultSet.getTimestamp("returned_date_time"));
            file.setReceivedDateTime(resultSet.getTimestamp("received_date_time"));
            file.setReturnedUser(resultSet.getString("returned_user"));
            file.setReceivedUser(resultSet.getString("received_user"));

            files.add(file);
        }
        return files;
    }

    private List<ScheduleReportEntity> getAllCourierData(LocalDate fromDate, LocalDate toDate) throws ClassNotFoundException, SQLException {
        String sql = "SELECT fr.facility_no, br.branch, ccr.category, ctr.cheque_type, csd.cheque_no, "
            + "csd.cheque_amount, csd.remarks, csd.added_user, csd.added_date_time, csd.is_printed, "
            + "cs.id AS schedule_id, cs.printed_user, cs.printed_date_time "
            + "FROM courier_schedule_details AS csd "
            + "JOIN file_received AS fr ON fr.id = csd.file_id "
            + "JOIN branch_ref AS br ON br.id = csd.courier_branch "
            + "JOIN courier_category_ref AS ccr ON ccr.id = csd.courier_category "
            + "JOIN cheque_type_ref AS ctr ON ctr.id = csd.cheque_type "
            + "LEFT JOIN courier_schedule AS cs ON cs.id = csd.schedule_id "
            + "WHERE csd.added_date_time BETWEEN ? AND ?";
        PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
        statement.setDate(1, Date.valueOf(fromDate));
        statement.setDate(2, Date.valueOf(toDate));
        
        ResultSet resultSet = statement.executeQuery();
        List<ScheduleReportEntity> records = new ArrayList<>();

        while (resultSet.next()) {
            ScheduleReportEntity record = new ScheduleReportEntity();

            record.setFacilityNo(resultSet.getString("facility_no"));
            record.setCourierBranch(resultSet.getString("branch"));
            record.setCourierType(resultSet.getString("category"));
            record.setChequeType(resultSet.getString("cheque_type"));
            record.setChequeNo(resultSet.getInt("cheque_no"));
            record.setChequeAmount(resultSet.getDouble("cheque_amount"));
            record.setRemarks(resultSet.getString("remarks"));
            record.setAddedUser(resultSet.getString("added_user"));
            record.setAddedDateTime(resultSet.getTimestamp("added_date_time"));
            record.setIsPrinted(resultSet.getBoolean("is_printed"));
            record.setSceduleId(resultSet.getInt("schedule_id"));
            record.setPrintedUser(resultSet.getString("printed_user"));
            record.setPrintedDateTime(resultSet.getTimestamp("printed_date_time"));

            records.add(record);
        }
        return records;
    }
}
