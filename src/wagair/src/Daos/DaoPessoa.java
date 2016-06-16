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
import wagair.Login;
import wagair.Pessoa;

/**
 *
 * @author a1625381
 */


public class DaoPessoa {
    
    private JDBCwagair c;
    private Pessoa pess;
    private int ID;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String celular;
    private int enderecoID;
    private int loginID;
    
    
    DaoPessoa(Pessoa p) throws SQLException, ClassNotFoundException, Exception{
            this.c = new JDBCwagair();
            this.pess = p;
            this.nome = p.getNome();
            this.sobrenome = p.getSobrenome();
            this.telefone = p.getTelefone();
            this.celular = p.getCelular();
            this.enderecoID = p.getEndereco().getID();
            this.loginID = p.getLogin().getID();

                      
    }
    //insere a pessoa e retorna o ID gerado
    public Pessoa getPessoa()
    {
        return(this.pess);
    }
    
    int insertPessoa() throws SQLException
    {
        
        Connection myConn = this.c.getConnection();
        // Statement myStmt = myConn.createStatement();
        
         String sql = "INSERT INTO pessoa "+
                 "(nome, sobrenome, telefone, celular, enderecoID, loginID) "+
                   "values (?, ?, ?, ?, ?, ?)";
         PreparedStatement stmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         stmt.setString(1, this.nome);
         stmt.setString(2, this.sobrenome);
         stmt.setString(3, this.telefone);
         stmt.setString(4, this.celular);
         stmt.setInt(5, this.enderecoID);
         stmt.setInt(6, this.loginID);
         
         stmt.executeUpdate();
         ResultSet rs = stmt.getGeneratedKeys();
         rs.next();
         this.ID = rs.getInt(1);
         this.pess.setID(this.ID);
         c.closeConnection(myConn, rs, stmt);
         return (this.ID);
         
         //ResultSet rs = preparedStatement.executeQuery();
       // myStmt.executeUpdate("insert * from valet");
        
    }
    
    
    
    
    
}
