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
import wagair.Passagem;

/**
 *
 * @author wagjub
 */
public class DaoPassagem {
    private JDBCwagair c;
    private Passagem pas;
    private int conexaoID;
    private String numAssento;
    private int ID;
    
      public DaoPassagem(Passagem p) throws SQLException, ClassNotFoundException, Exception{
            this.c = new JDBCwagair();
            this.pas = p;
            this.conexaoID = p.getConexao().getID();
            this.numAssento = p.getAssento();
    }
      
            public DaoPassagem(int conID) throws SQLException, ClassNotFoundException, Exception{
            this.c = new JDBCwagair();
            this.conexaoID = conID;
    }
      
        public String getUltimoAssento() throws SQLException
        {
               
        ArrayList<Aviao> resultado = new ArrayList<>();
        
        Connection myConn = this.c.getConnection();       
        Statement myStmt = myConn.createStatement();
        
        String sql = "select max(numAssento) as resultado from passagem where conexaoID = ?";

         PreparedStatement stmt = myConn.prepareStatement(sql);
         stmt.setInt(1, this.conexaoID);
                
        ResultSet myRS = stmt.executeQuery();
        String assento = "0";

        if (myRS.next()) {
            assento = myRS.getString("resultado");

            //try {
            //    int companhiaID = myRS.getInt("companhiaID");
              
           // }
           // catch(Exception e) {
            if (assento == null)
                    {
                        System.out.println("Era NULL");
                        assento = "0";
                    }
            return assento;
                
           // }
        //}
            
        }
       
       return assento;
        }
        
      
          public int insertPassagem() throws SQLException
    {
        
        Connection myConn = this.c.getConnection();
        // Statement myStmt = myConn.createStatement();
        
         String sql = "INSERT INTO passagem "+
                 "(numAssento, conexaoID) "+
                   "values (?, ?)";
         PreparedStatement stmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         stmt.setString(1, this.numAssento);
         stmt.setInt(2, this.conexaoID);
        
         stmt.executeUpdate();
         ResultSet rs = stmt.getGeneratedKeys();
         rs.next();
         this.ID = rs.getInt(1);
         this.pas.setID(this.ID);
         c.closeConnection(myConn, rs, stmt);
         return (this.ID);
         
         //ResultSet rs = preparedStatement.executeQuery();
       // myStmt.executeUpdate("insert * from valet");
        
    }
          
          
}
