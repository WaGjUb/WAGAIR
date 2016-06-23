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
import wagair.Rota;

/**
 *
 * @author a1625381
 */
public class DaoRota {
    private JDBCwagair c;
    private Rota rota;
    private int idDestino;
    private int idOrigem;
    private int ID;
    
   public DaoRota(Rota r) throws SQLException, ClassNotFoundException, Exception{
            this.c = new JDBCwagair();
            this.rota = r;
            this.idOrigem = r.getOrigem().getID();
            this.idDestino = r.getDestino().getID();
            
          /*  this.fabricante = a.getFabricante();
            this.modelo = a.getModelo();
            this.capacidade = a.getCapacidade();
            this.idComp = a.getComp().getID();*/
    }
    
    int insertRota() throws SQLException
    {
        
        Connection myConn = this.c.getConnection();
        // Statement myStmt = myConn.createStatement();
        
         String sql = "INSERT INTO rota "+
                 "(origemID, destinoID) "+
                   "values (?, ?)";
         PreparedStatement stmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         stmt.setInt(1, this.idOrigem);
         stmt.setInt(2, this.idDestino);

         
         stmt.executeUpdate();
         ResultSet rs = stmt.getGeneratedKeys();
         rs.next();
         this.ID = rs.getInt(1);
         this.rota.setID(this.ID);
         c.closeConnection(myConn, rs, stmt);
         return (this.ID);
         
         //ResultSet rs = preparedStatement.executeQuery();
       // myStmt.executeUpdate("insert * from valet");
        
    }
    
    
}
