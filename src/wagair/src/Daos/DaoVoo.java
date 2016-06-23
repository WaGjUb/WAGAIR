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
import wagair.Voo;

/**
 *
 * @author wagjub java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime());
 */
public class DaoVoo {
    
    private JDBCwagair c;
    private Voo voo;
    private java.sql.Timestamp dataPartida;
    private java.sql.Timestamp dataChegada;
    private int assentosLivres;
    private int rotaID;
    private int aviaoID;
    private int ID;
    
    public DaoVoo(Voo v) throws SQLException, ClassNotFoundException, Exception{
            this.c = new JDBCwagair();
            this.voo = v;
            this.dataPartida = v.getSQLPartida();
            this.dataChegada = v.getSQLChegada();
            this.assentosLivres = v.getLivres();
            this.rotaID = v.getRota().getID();
            this.aviaoID = v.getAviao().getID();
    }
    
     public int insertAviao() throws SQLException
    {
        
        Connection myConn = this.c.getConnection();
        // Statement myStmt = myConn.createStatement();
        
         String sql = "INSERT INTO voo "+
                 "(dataPartida, dataChegada, assentosLivres, rotaID, aviaoID) "+
                   "values (?, ?, ?, ?, ?)";
         PreparedStatement stmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         stmt.setTimestamp(1, this.dataPartida);
         stmt.setTimestamp(2, this.dataChegada);
         stmt.setInt(3, this.assentosLivres);
         stmt.setInt(4, this.rotaID);
         stmt.setInt(5, this.aviaoID);

         
         stmt.executeUpdate();
         ResultSet rs = stmt.getGeneratedKeys();
         rs.next();
         this.ID = rs.getInt(1);
         this.voo.setID(this.ID);
         c.closeConnection(myConn, rs, stmt);
         return (this.ID);
         
         //ResultSet rs = preparedStatement.executeQuery();
       // myStmt.executeUpdate("insert * from valet");
        
    }
}
