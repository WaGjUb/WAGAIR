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
import wagair.Aviao;
import wagair.Rota;

/**
 *
 * @author a1625381
 */
public class DaoAviao {
    private JDBCwagair c;
    private Aviao aviao;
    private String fabricante;
    private String modelo;
    private int capacidade;
    private int idComp = -1;
    private int ID;
    
    public DaoAviao(Aviao a) throws SQLException, ClassNotFoundException, Exception{
            this.c = new JDBCwagair();
            this.aviao = a;
            this.fabricante = a.getFabricante();
            this.modelo = a.getModelo();
            this.capacidade = a.getCapacidade();
            if (a.getComp() != null)
            {
                this.idComp = a.getComp().getID();
            }
    }

    public DaoAviao() throws SQLException, ClassNotFoundException {
       this.c = new JDBCwagair();
    }
     
    
     public Aviao getAvioesByID(int searchID) throws SQLException, ClassNotFoundException
   {
        
        
        Connection myConn = this.c.getConnection();     

         String sql = "select * from aviao where id = ?";

         PreparedStatement stmt = myConn.prepareStatement(sql);
         stmt.setInt(1, searchID);
                
        ResultSet myRS = stmt.executeQuery();

        if (myRS.next()) {
            int id = Integer.parseInt(myRS.getString("id"));
            int capacidade = myRS.getInt("capacidade");
            String fabricante = myRS.getString("fabricante");
            String modelo = myRS.getString("modelo");
            //try {
            //    int companhiaID = myRS.getInt("companhiaID");
              
           // }
           // catch(Exception e) {
                Aviao aux = new Aviao(fabricante, modelo, capacidade);
           // }
        //}
            
            aux.setID(id);          
            return aux;
        }
       else
        {
            return null;
        }
   }
    
     public ArrayList<Aviao> getAviao() throws SQLException
   {
        ArrayList<Aviao> resultado = new ArrayList<>();
        
        Connection myConn = this.c.getConnection();       
        Statement myStmt = myConn.createStatement();
        ResultSet myRS = myStmt.executeQuery("select * from aviao");

        while (myRS.next()) {
            int id = Integer.parseInt(myRS.getString("id"));
            int capacidade = myRS.getInt("capacidade");
            String fabricante = myRS.getString("fabricante");
            String modelo = myRS.getString("modelo");
            //try {
            //    int companhiaID = myRS.getInt("companhiaID");
              
           // }
           // catch(Exception e) {
                Aviao aux = new Aviao(fabricante, modelo, capacidade);
           // }
        //}
            
            aux.setID(id);            
            resultado.add(aux);
        }
       
       return resultado;
   }
    
    public int insertAviao() throws SQLException
    {
        
        Connection myConn = this.c.getConnection();
        // Statement myStmt = myConn.createStatement();
        if (this.idComp == -1)
        {
             String sql = "INSERT INTO aviao "+
                 "(capacidade, fabricante, modelo) "+
                   "values (?, ?, ?)";
                      PreparedStatement stmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         stmt.setInt(1, this.capacidade);
         stmt.setString(2, this.fabricante);
         stmt.setString(3, this.modelo);
         stmt.executeUpdate();
         ResultSet rs = stmt.getGeneratedKeys();
         rs.next();
         this.ID = rs.getInt(1);
         this.aviao.setID(this.ID);
         c.closeConnection(myConn, rs, stmt);
        }
        else
        {
         String sql = "INSERT INTO aviao "+
                 "(capacidade, fabricante, modelo, companhiaID) "+
                   "values (?, ?, ?, ?)";
                  PreparedStatement stmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         stmt.setInt(1, this.capacidade);
         stmt.setString(2, this.fabricante);
         stmt.setString(3, this.modelo);
         stmt.setInt(4, this.idComp);
         stmt.executeUpdate();
         ResultSet rs = stmt.getGeneratedKeys();
         rs.next();
         this.ID = rs.getInt(1);
         this.aviao.setID(this.ID);
         c.closeConnection(myConn, rs, stmt);
        }


         
         return (this.ID);
         
         //ResultSet rs = preparedStatement.executeQuery();
       // myStmt.executeUpdate("insert * from valet");
        
    }
}
