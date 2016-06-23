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
import wagair.Aviao;

/**
 *
 * @author a1625381
 */
public class DaoAviao {
    private JDBCwagair c;
    private Aviao aviao;
    private String fabricante;
    private String modelo;
    private int capacidade;
    private int idComp;
    private int ID;
    
    public DaoAviao(Aviao a) throws SQLException, ClassNotFoundException, Exception{
            this.c = new JDBCwagair();
            this.aviao = a;
            this.fabricante = a.getFabricante();
            this.modelo = a.getModelo();
            this.capacidade = a.getCapacidade();
            this.idComp = a.getComp().getID();
    }
     
    public int insertAviao() throws SQLException
    {
        
        Connection myConn = this.c.getConnection();
        // Statement myStmt = myConn.createStatement();
        
         String sql = "INSERT INTO aviao "+
                 "(capacidade, fabricante, modelo, companhiaID) "+
                   "values (?, ?, ?, ?)";
         PreparedStatement stmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         stmt.setInt(1, this.capacidade);
         stmt.setString(2, this.fabricante);
         stmt.setString(3, this.modelo);
         stmt.setInt(4, this.idComp);

         
         stmt.executeUpdate();
         ResultSet rs = stmt.getGeneratedKeys();
         rs.next();
         this.ID = rs.getInt(1);
         this.aviao.setID(this.ID);
         c.closeConnection(myConn, rs, stmt);
         return (this.ID);
         
         //ResultSet rs = preparedStatement.executeQuery();
       // myStmt.executeUpdate("insert * from valet");
        
    }
}
