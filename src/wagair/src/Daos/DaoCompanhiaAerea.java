/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import wagair.CompanhiaAerea;

/**
 *
 * @author a1625381
 */
public class DaoCompanhiaAerea {
    private JDBCwagair c;
    private CompanhiaAerea comp;
    private String nome;
    private int ID;
    
    DaoCompanhiaAerea(CompanhiaAerea co) throws SQLException, ClassNotFoundException, Exception{
            this.c = new JDBCwagair();
            this.comp = co;
            this.nome = co.getNome();
    }
    
    int insertCompanhiaAerea() throws SQLException
    {
        
        Connection myConn = this.c.getConnection();
        // Statement myStmt = myConn.createStatement();
        
         String sql = "INSERT INTO companhia_aerea "+
                 "(nome) "+
                   "values (?)";
         PreparedStatement stmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         stmt.setString(1, this.nome);

         
         stmt.executeUpdate();
         ResultSet rs = stmt.getGeneratedKeys();
         rs.next();
         this.ID = rs.getInt(1);
         this.comp.setID(this.ID);
         c.closeConnection(myConn, rs, stmt);
         return (this.ID);
         
         //ResultSet rs = preparedStatement.executeQuery();
       // myStmt.executeUpdate("insert * from valet");
        
    }
}
