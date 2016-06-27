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
    
    
    public DaoPessoa(Pessoa p) throws SQLException, ClassNotFoundException, Exception{
            this.c = new JDBCwagair();
            this.pess = p;
            this.nome = p.getNome();
            this.sobrenome = p.getSobrenome();
            this.telefone = p.getTelefone();
            this.celular = p.getCelular();
            this.enderecoID = p.getEndereco().getID();
            this.loginID = p.getLogin().getID();

                      
    }
   //fere o OO a função abaixo

    public DaoPessoa() throws SQLException, ClassNotFoundException {
       this.c = new JDBCwagair();
    }
    
        public int getPessoaIDByLoginID(int searchID) throws SQLException
   {
        
        
        Connection myConn = this.c.getConnection();     

         String sql = "select id from pessoa where loginID = ?";

         PreparedStatement stmt = myConn.prepareStatement(sql);
         stmt.setInt(1, searchID);
                
        ResultSet myRS = stmt.executeQuery();

        if (myRS.next()) {
            int id = Integer.parseInt(myRS.getString("id"));
            
            return id;
        }
       else
        {
            return -1;
        }
   }
   
     //insere a pessoa e retorna o ID gerado
    public int insertPessoa() throws SQLException
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
