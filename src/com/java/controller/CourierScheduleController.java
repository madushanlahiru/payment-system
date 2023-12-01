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
package com.java.controller;

import com.java.DataBaseConnection;
import com.java.entity.CourierSchedule;
import com.java.entity.CourierScheduleDetail;
import com.java.entity.CourierScheduleRecords;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author SandBox
 */
public class CourierScheduleController {
    
    private final DataBaseConnection connection;
    
    public CourierScheduleController() {
        connection = new DataBaseConnection();
    }
    
    public LinkedHashMap<String, String> getBranchList() throws SQLException {
        String sql = "SELECT branch, branch_code FROM branch_ref WHERE status = true";
        PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        
        LinkedHashMap<String, String> branches = new LinkedHashMap<>();
        while (resultSet.next()) {
          branches.put(resultSet.getString("branch_code"), resultSet.getString("branch"));
        }
        return branches;
    }
    
    public List<String> getCourierCategoryList() throws SQLException {
        String sql = "SELECT category FROM courier_category_ref WHERE status = true";
        PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        
        List<String> categories = new ArrayList<>();
        while (resultSet.next()) {
          categories.add(resultSet.getString("category"));
        }
        return categories;
    }
    
    public List<String> getChequeTypeList() throws SQLException {
        String sql = "SELECT cheque_type FROM cheque_type_ref WHERE status = true";
        PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        
        List<String> types = new ArrayList<>();
        while (resultSet.next()) {
          types.add(resultSet.getString("cheque_type"));
        }
        return types;
    }
    
    public int saveCourierDetails(CourierScheduleDetail courierScheduleDetail, String facilityNo) throws SQLException {
        String sql = "INSERT INTO courier_schedule_details(file_id, courier_category, "
            + "courier_branch, cheque_type, cheque_no, cheque_amount, remarks, added_user) "
            + "VALUES((SELECT id FROM file_received WHERE facility_no = ? LIMIT 1), ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
        statement.setString(1, facilityNo);
        statement.setInt(2, courierScheduleDetail.getCourierCategory());
        statement.setInt(3, courierScheduleDetail.getCourierBranch());
        statement.setInt(4, courierScheduleDetail.getChequeType());
        statement.setInt(5, courierScheduleDetail.getChequeNo());
        statement.setDouble(6, courierScheduleDetail.getChequeAmount());
        statement.setString(7, courierScheduleDetail.getRemarks());
        statement.setString(8, courierScheduleDetail.getAddedUser());

        return statement.executeUpdate();
    }
    
    public List<CourierScheduleDetail> getCourierDetails() throws SQLException {
        String sql = "SELECT sequence_no, schedule_id, file_id, courier_category, courier_branch, "
            + "cheque_type, cheque_no, cheque_amount, remarks, added_date_time, is_printed "
            + "FROM courier_schedule_details";
        PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        
        List<CourierScheduleDetail> details = new ArrayList<>();
        while (resultSet.next()) {
            CourierScheduleDetail record = new CourierScheduleDetail();
            record.setSequenceNo(resultSet.getLong("sequence_no"));
            record.setSchedule(resultSet.getInt("schedule_id"));
            record.setFileId(resultSet.getInt("file_id"));
            record.setCourierCategory(resultSet.getInt("courier_category"));
            record.setCourierBranch(resultSet.getInt("courier_branch"));
            record.setChequeType(resultSet.getInt("cheque_type"));
            record.setChequeNo(resultSet.getInt("cheque_no"));
            record.setChequeAmount(resultSet.getDouble("cheque_amount"));
            record.setRemarks(resultSet.getString("remarks"));
            record.setAddedDateTime(resultSet.getTimestamp("added_date_time"));
            record.setIsPrinted(resultSet.getBoolean("is_printed"));
            
            details.add(record);
        }
        return details;
    }
    
    public List<CourierScheduleDetail> getCourierDetails(String facilityNo) throws SQLException {
        String sql = "SELECT sequence_no, schedule_id, file_id, courier_category, courier_branch, "
            + "cheque_type, cheque_no, cheque_amount, remarks, added_date_time, is_printed "
            + "FROM courier_schedule_details WHERE file_id = (SELECT id FROM file_received WHERE facility_no = ?)";
        PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
        statement.setString(1, facilityNo);
        ResultSet resultSet = statement.executeQuery();
        
        List<CourierScheduleDetail> details = new ArrayList<>();
        while (resultSet.next()) {
            CourierScheduleDetail record = new CourierScheduleDetail();
            record.setSequenceNo(resultSet.getLong("sequence_no"));
            record.setSchedule(resultSet.getInt("schedule_id"));
            record.setFileId(resultSet.getInt("file_id"));
            record.setCourierCategory(resultSet.getInt("courier_category"));
            record.setCourierBranch(resultSet.getInt("courier_branch"));
            record.setChequeType(resultSet.getInt("cheque_type"));
            record.setChequeNo(resultSet.getInt("cheque_no"));
            record.setChequeAmount(resultSet.getDouble("cheque_amount"));
            record.setRemarks(resultSet.getString("remarks"));
            record.setAddedDateTime(resultSet.getTimestamp("added_date_time"));
            record.setIsPrinted(resultSet.getBoolean("is_printed"));
            
            details.add(record);
        }
        return details;
    }
    
    public List<CourierScheduleRecords> getTableDetails(String branch, LocalDate date) throws SQLException {
        String sql = "SELECT br.branch, csd.sequence_no, fr.facility_no, ctr.cheque_type, cheque_no, "
            + "cheque_amount, csd.is_printed, csd.added_date_time "
            + "FROM courier_schedule_details AS csd "
            + "JOIN file_received AS fr ON fr.id = csd.file_id "
            + "JOIN cheque_type_ref AS ctr ON ctr.id = csd.cheque_type "
            + "JOIN branch_ref AS br ON br.id = csd.courier_branch "
            + "WHERE csd.is_printed = false AND br.branch = ? AND DATE(csd.added_date_time) = ? "
            + "AND csd.courier_category IN (1, 2)";
        PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
        statement.setString(1, branch);
        statement.setDate(2, Date.valueOf(date));
        ResultSet resultSet = statement.executeQuery();
        
        List<CourierScheduleRecords> details = new ArrayList<>();
        while (resultSet.next()) {
            CourierScheduleRecords record = new CourierScheduleRecords();
            record.setCourierBranch(resultSet.getString("branch"));
            record.setSequenceNo(resultSet.getLong("sequence_no"));
            record.setFacilityNo(resultSet.getString("facility_no"));
            record.setChequeType(resultSet.getString("cheque_type"));
            record.setChequeNo(resultSet.getInt("cheque_no"));
            record.setChequeAmount(resultSet.getDouble("cheque_amount"));
            record.setIsPrinted(resultSet.getBoolean("is_printed"));
            record.setAddedDateTime(resultSet.getTimestamp("added_date_time"));

            details.add(record);
        }
        
        return details;
    }
    
    public int updateScheduleIdAndStatus(List<CourierScheduleRecords> records, int scheduleId) throws SQLException {
        String sql = "UPDATE courier_schedule_details AS csd "
                + "JOIN file_received AS fr ON fr.id = csd.file_id "
                + "JOIN cheque_type_ref AS ctr ON ctr.id = csd.cheque_type "
                + "JOIN branch_ref AS br ON br.id = csd.courier_branch "
                + "SET csd.schedule_id = ?, csd.is_printed = true "
                + "WHERE fr.facility_no = ? AND ctr.cheque_type = ? AND br.branch = ? "
                + "AND csd.cheque_no= ? AND csd.cheque_amount= ? AND DATE(csd.added_date_time) = ?";
        PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
        
        int result = 0;
        for (CourierScheduleRecords record : records) {
            statement.setInt(1, scheduleId);
            statement.setString(2, record.getFacilityNo());
            statement.setString(3, record.getChequeType());
            statement.setString(4, record.getCourierBranch());
            statement.setInt(5, record.getChequeNo());
            statement.setDouble(6, record.getChequeAmount());
            statement.setDate(7, Date.valueOf(record.getAddedDateTime().toLocalDateTime().toLocalDate()));
            
            result = statement.executeUpdate();
        }
        
        return result;
    }
    
    /**
     * Save the courier schedule data and return the auto generated key.
     * 
     * @param schedule
     * @return Auto generated schedule id, if not successful 0.
     * @throws SQLException 
     */
    public int saveSchedule(CourierSchedule schedule) throws SQLException {
        String sql = "INSERT INTO courier_schedule(courier_branch, printed_user) VALUES(?, ?)";
        PreparedStatement statement = connection.getDBConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        statement.setInt(1, schedule.getCourierBranch());
        statement.setString(2, schedule.getPrintedUser());

        int i = statement.executeUpdate();
        if(i != 0) {
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) {
                return resultSet.getInt(1);
            }
        }
        
        return 0;
    }
    
    public int updateScheduleDetails(CourierScheduleDetail oldRecord, CourierScheduleDetail newRecord) throws SQLException {     
        String sql = "SELECT facility_no FROM file_received WHERE id = ?";
        PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
        statement.setLong(1, oldRecord.getFileId());
        ResultSet resultSet = statement.executeQuery();
        
        int result = 0;
        if(resultSet.next()) {
            result = deleteScheduleDetail(oldRecord);
            result = saveCourierDetails(newRecord, resultSet.getString("facility_no"));
        }
        return result;
    }
    
    public int deleteScheduleDetail(CourierScheduleDetail record) throws SQLException {
        String sql = "DELETE FROM courier_schedule_details WHERE sequence_No = ?";
        PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
        statement.setLong(1, record.getSequenceNo());
        return statement.executeUpdate();
    }
    
}
