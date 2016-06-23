/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import java.sql.*;

/**
 *
 * @author a1625381
 */
public class JDBCwagair {
    String dbURL;
    String user;
    String pass;
    
   public JDBCwagair() throws SQLException, ClassNotFoundException {
         
        //Get Connection
        Class.forName("com.mysql.jdbc.Driver");

        this.dbURL = "jdbc:mysql://localhost:3306/wagair";
        this.user = "root";
        this.pass = "wagjub";
        
/*
        Statement myStmt = myConn.createStatement();

        ResultSet myRS = myStmt.executeQuery("select * from valet");

        while (myRS.next()) {
            System.out.println("Modelo" + myRS.getString("modelo"));
            System.out.println("Placa" + myRS.getString("placa"));
        }*/

    }
    
    public Connection getConnection() throws SQLException
    {
        Connection myConn = DriverManager.getConnection(this.dbURL, this.user, this.pass);
        return (myConn);
    
    }
    
    public void closeConnection(Connection c, ResultSet rs, PreparedStatement ps){
    

        
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e){}
        }
        
         if (ps != null){
            try {
                ps.close();
            } catch (SQLException e){}
        }
              
        if (c != null){
            try {
                c.close();
            } catch (SQLException e){}
        }         
    }
    }
    

