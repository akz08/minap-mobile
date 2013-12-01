package com.team7.minap.network;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.team7.minap.network.SqlConnector;
import com.team7.minap.datacollection.values.PatientCaseRecordNumber;
 
public class SQLTest {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the EmployeeID:");
 
        int employeeId;
        try {
            employeeId = Integer.parseInt(br.readLine());
            SQLTest demo = new SQLTest();
            PatientCaseRecordNumber employee = demo.getEmployee(employeeId);
            System.out.println(employee);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public PatientCaseRecordNumber getEmployee(int employeeId)  {
        ResultSet rs = null;
        Connection connection = null;
        Statement statement = null; 
 
        PatientCaseRecordNumber employee = null;
        
        String query = "SELECT * FROM patient";
        try {
            connection = SqlConnector.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
 
            if (rs.next()) {
                employee = new PatientCaseRecordNumber();
                employee.setCaseNumber(rs.getString("PatientCaseRecordNo"));
                System.out.print(employee.getCaseNumber());
//                employee.setEmpName(rs.getString("emp_name"));
//                employee.setDob(rs.getDate("dob"));
//                employee.setSalary(rs.getDouble("salary"));
//                employee.setDeptId((rs.getInt("dept_id")));
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
        return employee;
    }
}