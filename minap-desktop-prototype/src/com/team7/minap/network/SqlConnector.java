///**
// * Helper class to temporarily store patient data in a local SQLite DB.
// * For the time being, it stores results to a local phpMyAdmin SQL DB
// * @author david
// */
//package com.team7.minap.network;
//import java.sql.*;
//
//public class SqlConnector implements Network {
//	
//	public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
//	public static final String URL = "jdbc:mysql://localhost/minap";
//	public static final String USER = "root";
//	public static final String PASS = "root";
//	
//	
//	public void openConnection() {
//		// SQLite connection setup
//		Class.forName(MYSQL_DRIVER);
//	}
//	
//	public void closeConnection() {
//		
//	}
//	
//	public boolean isConnected(){
//		return false;
//	}
//	
//}
package com.team7.minap.network;
 
//Step 1: Use interfaces from java.sql package
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class SqlConnector {
    //static reference to itself
    private static SqlConnector instance = new SqlConnector();
    public static final String URL = "jdbc:mysql://localhost:8889/minap";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; 
 
    //private constructor
    private SqlConnector() {
        try {
            //Step 2: Load MySQL Java driver
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
 
    private Connection createConnection() {

        Connection connection = null;
        try {
            //Step 3: Establish Java MySQL connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }   
 
    public static Connection getConnection() {
        return instance.createConnection();
    }
}