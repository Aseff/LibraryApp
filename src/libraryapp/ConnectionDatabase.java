/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asefn
 */
public abstract class ConnectionDatabase<T> {
     public static java.sql.Connection connection() throws SQLException, ClassNotFoundException {
        com.microsoft.sqlserver.jdbc.SQLServerDriver s;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=first_try;";
        String username = "asef";
        String password = "0773960282asef!";

        java.sql.Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
//        if (connection != null) {
//            JOptionPane.showMessageDialog(null,"Connected");
//        }
//        else{
//            System.out.println("connection failed");
//        }
    }
     
    public abstract List<T> getschooldataForStatement() throws Exception;
    public abstract List<T> getschooldataForPreparedStatement() throws Exception;
   // public abstract boolean update(T obj) throws Exception;
  //  public abstract int insertion(T obj) throws Exception;
   // public abstract int delete(int id) throws Exception;
    //public abstract SchoolData getById(int id) throws SQLException, ClassNotFoundException;
    public abstract int getCountOfRows() throws Exception;
//   public abstract List<T> getschooldataForSearch(String name, String surname) throws Exception;

}
