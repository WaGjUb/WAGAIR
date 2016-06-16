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
import wagair.Login;

/**
 *
 * @author a1625381
 */



public class DaoLogin {
    JDBCwagair c; //conexão
    private String usuario;
    private String senha;
    private int ID;
    private Login log;

    DaoLogin(Login l) throws SQLException, ClassNotFoundException, Exception{
            this.c = new JDBCwagair();
            
            this.usuario = l.getUsuario();
            this.senha = l.getSenha();           
            this.log = l;
    }
    
    int insertLogin() throws SQLException, Exception
    {
        
        Connection myConn = this.c.getConnection();
        // Statement myStmt = myConn.createStatement();
        
         String sql = "INSERT INTO login "+
                 "(usuario, senha) "+
                   "values (?, ?)";
         
         PreparedStatement stmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         stmt.setString(1, this.usuario);
         stmt.setString(2, this.senha);
         
         stmt.executeUpdate();
         ResultSet rs = stmt.getGeneratedKeys();
         rs.next();
         this.ID = rs.getInt(1);
         this.log.setID(this.ID);
         c.closeConnection(myConn, rs, stmt);
         return (this.ID);
         
         
       // myStmt.executeUpdate("insert * from valet");
        
    }
    
}
