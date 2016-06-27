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
import wagair.Aeroporto;
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
   
   public DaoRota() throws SQLException, ClassNotFoundException 
   {
    this.c = new JDBCwagair();   
   }
    
      public ArrayList<Rota> getRotas() throws SQLException, ClassNotFoundException
   {
        ArrayList<Rota> resultado = new ArrayList<>();
        
        Connection myConn = this.c.getConnection();       
        Statement myStmt = myConn.createStatement();
        ResultSet myRS = myStmt.executeQuery("select * from rota");

        while (myRS.next()) {
            int id = Integer.parseInt(myRS.getString("id"));
            int origem = Integer.parseInt(myRS.getString("origemID"));
            int destino = Integer.parseInt(myRS.getString("destinoID"));
            DaoAeroporto da = new DaoAeroporto();
            Aeroporto aerOrigem = da.getAeroportoByID(origem);
            Aeroporto aerDestino = da.getAeroportoByID(destino);
            Rota aux = new Rota(aerOrigem, aerDestino);
            aux.setID(id);            
            resultado.add(aux);
        }
       
       return resultado;
   }
      
       public Rota getRotasByID(int searchID) throws SQLException, ClassNotFoundException
   {
        
        
        Connection myConn = this.c.getConnection();     

         String sql = "select * from rota where id = ?";

         PreparedStatement stmt = myConn.prepareStatement(sql);
         stmt.setInt(1, searchID);
                
        ResultSet myRS = stmt.executeQuery();

        if (myRS.next()) {
            int id = Integer.parseInt(myRS.getString("id"));
            int origem = Integer.parseInt(myRS.getString("origemID"));
            int destino = Integer.parseInt(myRS.getString("destinoID"));
            DaoAeroporto da = new DaoAeroporto();
            Aeroporto aerOrigem = da.getAeroportoByID(origem);
            Aeroporto aerDestino = da.getAeroportoByID(destino);
            Rota aux = new Rota(aerOrigem, aerDestino);
            aux.setID(id);                   
            return aux;
        }
       else
        {
            return null;
        }
   }
   
    public int insertRota() throws SQLException
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
