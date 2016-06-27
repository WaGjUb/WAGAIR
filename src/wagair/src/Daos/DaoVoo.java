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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import wagair.Aeroporto;
import wagair.Aviao;
import wagair.Passagem;
import wagair.Rota;
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
    
    public DaoVoo() throws SQLException, ClassNotFoundException, Exception{
            this.c = new JDBCwagair();

    }
    
    public ArrayList<Voo> getVoos() throws SQLException, ClassNotFoundException
   {
        ArrayList<Voo> resultado = new ArrayList<>();
        
        Connection myConn = this.c.getConnection();       
        Statement myStmt = myConn.createStatement();
        ResultSet myRS = myStmt.executeQuery("select * from voo");

        while (myRS.next()) {
            int id = Integer.parseInt(myRS.getString("id"));
            java.sql.Timestamp dataPartida = java.sql.Timestamp.valueOf(myRS.getString("dataPartida"));
            java.sql.Timestamp dataChegada = java.sql.Timestamp.valueOf(myRS.getString("dataChegada"));
            int assentosLivres = Integer.parseInt(myRS.getString("assentosLivres"));
            int rotaID = Integer.parseInt(myRS.getString("rotaID"));
            int aviaoID = Integer.parseInt(myRS.getString("aviaoID"));
            DaoRota dr = new DaoRota();
            Rota rota = dr.getRotasByID(rotaID);
            DaoAviao da = new DaoAviao();
            Aviao aviao = da.getAvioesByID(aviaoID);
            Calendar calPartida = Calendar.getInstance();
            Calendar calChegada = Calendar.getInstance();
            calPartida.setTime(new Date(dataPartida.getTime()));
            calChegada.setTime(new Date(dataChegada.getTime()));
            Voo aux = new Voo(calPartida, calChegada, aviao, assentosLivres, rota);
            aux.setID(id);            
            resultado.add(aux);
        }
       
       return resultado;
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
         
     /*    //geraPassagens
         for (int i = 0; i < this.assentosLivres; i++)
         {
             try{
             Passagem p = new Passagem(this.voo, String.valueOf(i));
             DaoPassagem dp = new DaoPassagem(p);
             dp.insertPassagem();
         }
            catch (Exception e)
               {
                   JOptionPane.showMessageDialog(null, "erro ao gerar passagens para voo");
                  
               }
         }*/
         
         return (this.ID);
         
         //ResultSet rs = preparedStatement.executeQuery();
       // myStmt.executeUpdate("insert * from valet");
        
    }
}
