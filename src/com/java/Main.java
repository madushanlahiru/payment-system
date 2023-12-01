/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java;

import com.java.view.AddCourierSchedule;
import com.java.view.Dashboard;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.JOptionPane;

/**
 *
 * @author Madushan Lahiru
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Default Look & Feel
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddCourierSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCourierSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCourierSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCourierSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        CommonLogger logger = new CommonLogger(Main.class.getName());

        try {
            DataBaseConnection db = new DataBaseConnection();
            db.getDBConnection();
            Dashboard dashboard = new Dashboard();
            dashboard.setVisible(true);
            db.DBClose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database server not found. Please start the database server.", "Error", JOptionPane.ERROR_MESSAGE);
            logger.getLogger().log(Level.SEVERE, ex.getMessage(), ex);
        }

        //System.out.println(System.getProperty("user.name")); // Get the windows account name   
    }

}
