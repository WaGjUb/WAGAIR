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
import wagair.Aeroporto;

/**
 *
 * @author a1625381
 */
public class DaoAeroporto {
    private JDBCwagair c;
    private Aeroporto aero;
    private String nome;
    private String cidade;
    private String pais;
    private int ID;
    DaoAeroporto(Aeroporto a) throws SQLException, ClassNotFoundException, Exception{
            this.c = new JDBCwagair();
            this.aero = a;
            this.nome = a.getNome();
            this.cidade = a.getCidade();
            this.pais = a.getPais();
    }
    
    int insertAeroporto() throws SQLException
    {
        
        Connection myConn = this.c.getConnection();
        // Statement myStmt = myConn.createStatement();
        
         String sql = "INSERT INTO aeroporto "+
                 "(nome, cidade, pais) "+
                   "values (?, ?, ?)";
         PreparedStatement stmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         stmt.setString(1, this.nome);
         stmt.setString(2, this.cidade);
         stmt.setString(3, this.pais);

         
         stmt.executeUpdate();
         ResultSet rs = stmt.getGeneratedKeys();
         rs.next();
         this.ID = rs.getInt(1);
         this.aero.setID(this.ID);
         c.closeConnection(myConn, rs, stmt);
         return (this.ID);
         
         //ResultSet rs = preparedStatement.executeQuery();
       // myStmt.executeUpdate("insert * from valet");
        
    }
}
