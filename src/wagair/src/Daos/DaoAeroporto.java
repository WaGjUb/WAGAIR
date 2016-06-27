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

/**
 *
 * @author a1625381
 */
public class DaoAeroporto {
    private JDBCwagair c;
    private Aeroporto aero;
    private String nome;
    private String cidade;
    private String pais;
    private int ID;
   public DaoAeroporto(Aeroporto a) throws SQLException, ClassNotFoundException, Exception{
            this.c = new JDBCwagair();
            this.aero = a;
            this.nome = a.getNome();
            this.cidade = a.getCidade();
            this.pais = a.getPais();
    }

    public DaoAeroporto() throws SQLException, ClassNotFoundException {
        this.c = new JDBCwagair();
    }
   
    
   public ArrayList<Aeroporto> getAeroportos() throws SQLException
   {
        ArrayList<Aeroporto> resultado = new ArrayList<>();
        
        Connection myConn = this.c.getConnection();       
        Statement myStmt = myConn.createStatement();
        ResultSet myRS = myStmt.executeQuery("select * from aeroporto");

        while (myRS.next()) {
            int id = Integer.parseInt(myRS.getString("id"));
            String n = myRS.getString("nome");
            String cidade = myRS.getString("cidade");
            String pais = myRS.getString("pais");
            Aeroporto aux = new Aeroporto(n, cidade, pais);
            aux.setID(id);            
            resultado.add(aux);
        }
       
       return resultado;
   }
   
    public Aeroporto getAeroportoByID(int searchID) throws SQLException
   {
        
        
        Connection myConn = this.c.getConnection();     

         String sql = "select * from aeroporto where id = ?";

         PreparedStatement stmt = myConn.prepareStatement(sql);
         stmt.setInt(1, searchID);
                
        ResultSet myRS = stmt.executeQuery();

        if (myRS.next()) {
            int id = Integer.parseInt(myRS.getString("id"));
            String n = myRS.getString("nome");
            String cidade = myRS.getString("cidade");
            String pais = myRS.getString("pais");
            Aeroporto aux = new Aeroporto(n, cidade, pais);
            aux.setID(id);            
            return aux;
        }
       else
        {
            return null;
        }
   }
   
   public int insertAeroporto() throws SQLException
    {
        
        Connection myConn = this.c.getConnection();
        // Statement myStmt = myConn.createStatement();
        
         String sql = "INSERT INTO aeroporto "+
                 "(nome, cidade, pais) "+
                   "values (?, ?, ?)";
         PreparedStatement stmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         stmt.setString(1, this.nome);
         stmt.setString(2, this.cidade);
         stmt.setString(3, this.pais);

         
         stmt.executeUpdate();
         ResultSet rs = stmt.getGeneratedKeys();
         rs.next();
         this.ID = rs.getInt(1);
         this.aero.setID(this.ID);
         c.closeConnection(myConn, rs, stmt);
         return (this.ID);
         
         //ResultSet rs = preparedStatement.executeQuery();
       // myStmt.executeUpdate("insert * from valet");
        
    }
}
