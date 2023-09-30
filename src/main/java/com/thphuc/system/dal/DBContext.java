/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thphuc.system.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tran Hoang Phuc
 */
public class DBContext {

    protected Connection connection;

    public DBContext() {
        try { 
            String url = "jdbc:sqlserver://DESKTOP-R7H31J3\\THPHUC:1433;databaseName=AssignmentPRJ301;encrypt=false";
            String user = "sa";
            String password = "PcyTt11@";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

      
}
