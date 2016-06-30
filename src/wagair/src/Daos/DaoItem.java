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
import java.util.ArrayList;
import wagair.Aviao;
import wagair.Conexao;
import wagair.Item;
import wagair.Passagem;

/**
 *
 * @author wagjub
 */
public class DaoItem {
    private JDBCwagair c;
    private Item item;
    private ArrayList<Passagem> passagem;
    private int ID;
    
    public DaoItem(Item i) throws SQLException, ClassNotFoundException, Exception{
            this.c = new JDBCwagair();
            this.item = i;
            this.passagem = i.getPassagem();
    }
    
    public int insertItem() throws SQLException, Exception
    {
        
        Connection myConn = this.c.getConnection();
        // Statement myStmt = myConn.createStatement();
        
         String sql = "INSERT INTO itens "+
                 "() "+
                   "values ()";
         PreparedStatement stmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


         
         stmt.executeUpdate();
         ResultSet rs = stmt.getGeneratedKeys();
         rs.next();
         this.ID = rs.getInt(1);
         this.item.setID(this.ID);
         
         sql = "INSERT INTO link_item "+
                 "(passagemID, itensID) "+
                   "values (?, ?)";
            stmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
          
         for (Passagem pas : this.passagem)
         {
            stmt.setInt(1, pas.getID());
            stmt.setInt(2, this.ID);
            stmt.executeUpdate();
         }

         c.closeConnection(myConn, rs, stmt);
         return (this.ID);
         
         //ResultSet rs = preparedStatement.executeQuery();
       // myStmt.executeUpdate("insert * from valet");
        
    }
    
}
