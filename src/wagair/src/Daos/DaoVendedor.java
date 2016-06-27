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
import wagair.Pessoa;
import wagair.Vendedor;

/**
 *
 * @author a1625381
 */
public class DaoVendedor extends DaoPessoa{
private JDBCwagair c;
private String CNPJ;
private Vendedor vendedor;

    
    public DaoVendedor(Vendedor vend) throws SQLException, ClassNotFoundException, Exception {
        super(vend);
        this.c = new JDBCwagair();
        this.CNPJ = vend.getCNPJ();
        this.vendedor = vend;
    }
    
    public int insertVendedor() throws SQLException
    {
        int IDVENDEDOR;
        int idPessoa = this.insertPessoa();
        Connection myConn = this.c.getConnection();
        // Statement myStmt = myConn.createStatement();
        
         String sql = "INSERT INTO vendedor "+
                 "(pessoaID, CNPJ) "+
                   "values (?, ?)";
         PreparedStatement stmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         stmt.setInt(1, idPessoa);
         stmt.setString(2, this.CNPJ);
         
         stmt.executeUpdate();
         ResultSet rs = stmt.getGeneratedKeys();
         rs.next();
         IDVENDEDOR = rs.getInt(1);
         c.closeConnection(myConn, rs, stmt);
         return (IDVENDEDOR);
         
         //ResultSet rs = preparedStatement.executeQuery();
       // myStmt.executeUpdate("insert * from valet");
        
    }
    
}
