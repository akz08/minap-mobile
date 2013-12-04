package com.team7.minap.network;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.team7.minap.network.SqlConnector;
import com.team7.minap.datacollection.values.*;
 
public class SQLTest {
    public static void main(String[] args) {
         try {
            SQLTest demo = new SQLTest();
            demo.runQuery();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
 
    public void runQuery()  {
        ResultSet rs = null;
        Connection connection = null;
        Statement statement = null; 
        
        String query = "SELECT * from patient";
        String query2 = "UPDATE patient SET Forename='Jane' WHERE PatientCaseRecordNo='1234567890'";
        try {
            connection = SqlConnector.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query2);
            rs = statement.executeQuery(query);
 
            if (rs.next()) {
                PatientCaseRecordNumber.setCaseNumber(rs.getString("PatientCaseRecordNo"));
                System.out.print(PatientCaseRecordNumber.getCaseNumber());
                PatientSurname.setSurname(rs.getString("Surname"));
                System.out.print(PatientSurname.getSurname());
                PatientForename.setForename(rs.getString("Forename"));
                System.out.print(PatientForename.getForename());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}