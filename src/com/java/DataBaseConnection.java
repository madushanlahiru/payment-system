/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Madushan Lahiru
 */
public class DataBaseConnection {

  private Connection connection = null;
  private int success;

  // Default constructor
  public DataBaseConnection() {
    //
  }

  public Connection getDBConnection() throws SQLException {
    if(connection == null) {
        connection = setDBConnection();
    }
    return connection;
  }
  
  private Connection setDBConnection() throws SQLException {
    // Test Database
//     return DriverManager.getConnection("jdbc:mysql://localhost:3306/test_payment_system", "root", "Admin_0927@VF");
//     return DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/payment_system", "user", "INS@vf*00");
//    return DriverManager.getConnection("jdbc:mysql://192.168.100.15:3306/payment_system_test", "user", "INS@vf*00");
    
    // Production Database
     return DriverManager.getConnection("jdbc:mysql://192.168.100.60:3306/payment_system", "user", "payments@VFPLC");
  }

  public void DBClose() throws SQLException {
    connection.close();
  }

}
