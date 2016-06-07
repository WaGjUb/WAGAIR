/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import java.sql.Connection;
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
    
    JDBCwagair c;
    
    private String nome;
    private String telefone;
    private String celular;
    private Endereco endereco;
    private Login login; 
    
    
    DaoPessoa(Pessoa p) throws SQLException, ClassNotFoundException{
            this.c = new JDBCwagair();
            
            this.nome = p.getNome();
            this.telefone = p.getTelefone();
            this.celular = p.getCelular();
            this.endereco = p.getEndereco();
            this.login = p.getLogin();
            
            
    }
    
    String insertPessoa() throws SQLException
    {
        
        Connection myConn = this.c.getConection();
         Statement myStmt = myConn.createStatement();
        
         String sql = "INSERT INTO pessoa";
        myStmt.executeUpdate("insert * from valet");

        
    }
    
    
    
    
    
}
