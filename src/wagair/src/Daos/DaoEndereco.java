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
import wagair.Endereco;


/**
 *
 * @author a1625381
 */
public class DaoEndereco {
   private JDBCwagair c;
   private Endereco end;
   private int ID;
   private String rua;
   private int numero;
   private String CEP;
   private String complemento;

    
    
   public DaoEndereco(Endereco e) throws SQLException, ClassNotFoundException, Exception{
            this.c = new JDBCwagair();
            this.end = e;
            this.rua = e.getRua();
            this.numero = e.getNumero();
            this.CEP = e.getCEP();
            this.complemento = e.getComplemento();
                                  
    }
 //retorna o ID gerado 
    public int insertEndereco() throws SQLException, Exception
    {
        
        Connection myConn = this.c.getConnection();
        // Statement myStmt = myConn.createStatement();
        
         String sql = "INSERT INTO endereco "+
                 "(rua, numero, CEP, complemento) "+
                   "values (?, ?, ?, ?)";
         PreparedStatement stmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         stmt.setString(1, this.rua);
         stmt.setInt(2, this.numero);
         stmt.setString(3, this.CEP);
         stmt.setString(4, this.complemento);
         
         stmt.executeUpdate();
         ResultSet rs = stmt.getGeneratedKeys();
         rs.next();
         this.ID = rs.getInt(1);
         this.end.setID(this.ID);
         c.closeConnection(myConn, rs, stmt);
         return (this.ID);
         
         //ResultSet rs = preparedStatement.executeQuery();
       // myStmt.executeUpdate("insert * from valet");
        
    }
}
