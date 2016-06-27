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
import wagair.Cliente;
import wagair.Pessoa;

/**
 *
 * @author a1625381
 */
public class DaoCliente extends DaoPessoa {
private JDBCwagair c;
private String CPF;
private Cliente cliente;

    public DaoCliente(Cliente cli) throws SQLException, ClassNotFoundException, Exception {
        super(cli);
        this.c = new JDBCwagair();
        this.CPF = cli.getCPF();
        this.cliente = cli;
    }

    public DaoCliente() throws SQLException, ClassNotFoundException {
        this.c = new JDBCwagair();
    }
    
   public int insertCliente() throws SQLException
    {
        int IDCLIENTE;
        int idPessoa = this.insertPessoa();
        Connection myConn = this.c.getConnection();
        // Statement myStmt = myConn.createStatement();
        
         String sql = "INSERT INTO cliente "+
                 "(pessoaID, CPF) "+
                   "values (?, ?)";
         PreparedStatement stmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         stmt.setInt(1, idPessoa);
         stmt.setString(2, this.CPF);
         
         stmt.executeUpdate();
         ResultSet rs = stmt.getGeneratedKeys();
         rs.next();
         IDCLIENTE = rs.getInt(1);
         c.closeConnection(myConn, rs, stmt);
         return (IDCLIENTE);
         
         //ResultSet rs = preparedStatement.executeQuery();
       // myStmt.executeUpdate("insert * from valet");
        
    }
    
    
    
    
    

}
