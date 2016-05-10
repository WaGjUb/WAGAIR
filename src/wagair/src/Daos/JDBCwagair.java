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
    
    JDBCwagair() throws SQLException, ClassNotFoundException {

        //Get Connection
        Class.forName("com.mysql.jdbc.Driver");

        String dbURL = "jdbc:mysql://localhost:3306/wagair";
        String user = "root";
        String pass = "";
        Connection myConn = DriverManager.getConnection(dbURL, user, pass);
/*
        Statement myStmt = myConn.createStatement();

        ResultSet myRS = myStmt.executeQuery("select * from valet");

        while (myRS.next()) {
            System.out.println("Modelo" + myRS.getString("modelo"));
            System.out.println("Placa" + myRS.getString("placa"));
        }*/

    }
    }
    

