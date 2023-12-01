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
import com.java.entity.FileEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SandBox
 */
public class DashboardController {
    
    private final DataBaseConnection connection;
    
    public DashboardController() {
        connection = new DataBaseConnection();
    }
    
    public String[] getPageAccessUsers() throws SQLException {
        String sql = "SELECT user_name FROM page_access";
        PreparedStatement statement = connection.getDBConnection().prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        
        String[] users = new String[resultSet.getFetchSize() + 1];
        while (resultSet.next()) {
            users[resultSet.getRow() - 1] = resultSet.getString("user_name");
        }
        return users;
    }
    
    public void closeDBConnetion() throws SQLException {
        connection.DBClose();
    }
    
}
