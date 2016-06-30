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
import java.sql.Timestamp;
import wagair.Negociacao;

/**
 *
 * @author wagjub
 */
public class DaoNegociacao {
    private JDBCwagair c;
    private Negociacao negociacao;
    private Timestamp data;
    private float total;
    private boolean status;
    private int clienteID;
    private int vendedorID;
    private int itemID;
    private int ID;
    
    public DaoNegociacao(Negociacao n) throws SQLException, ClassNotFoundException, Exception{
            this.c = new JDBCwagair();
            this.negociacao = n;
            this.data = n.getData();
            this.total = n.getTotal();
            this.status = n.isStatus();            
            this.clienteID = n.getCliente().getID();
            this.vendedorID = n.getVendedor().getID();
            this.itemID = n.getItem().getID();
    }
    
    public int insertNegociacao() throws SQLException
    {
        
        Connection myConn = this.c.getConnection();
        // Statement myStmt = myConn.createStatement();
        
         String sql = "INSERT INTO negociacao "+
                 "(data, total, status, clienteID, vendedorID, itensID) "+
                   "values (?, ?, ?, ?, ?, ?)";
         PreparedStatement stmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         stmt.setTimestamp(1, this.data);
         stmt.setFloat(2, this.total);
         stmt.setBoolean(3, this.status);
         stmt.setInt(4, this.clienteID);
         stmt.setInt(5, this.vendedorID);
         stmt.setInt(6, this.itemID);
         
         
         stmt.executeUpdate();
         ResultSet rs = stmt.getGeneratedKeys();
         rs.next();
         this.ID = rs.getInt(1);
         this.negociacao.setID(this.ID);
         c.closeConnection(myConn, rs, stmt);
         return (this.ID);
         
         //ResultSet rs = preparedStatement.executeQuery();
       // myStmt.executeUpdate("insert * from valet");
        
    }
    
}
