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
import wagair.Aviao;
import wagair.Login;

/**
 *
 * @author a1625381
 */



public class DaoLogin {
    private JDBCwagair c; //conexão
    private String usuario;
    private String senha;
    private int ID;
    private Login log;

   public DaoLogin(Login l) throws SQLException, ClassNotFoundException, Exception {
            this.c = new JDBCwagair();
            
            this.usuario = l.getUsuario();
            this.senha = l.getSenha();           
            this.log = l;
    }
   
   public DaoLogin() throws SQLException, ClassNotFoundException
   {
       this.c = new JDBCwagair();
   }

   
   
   public Login getloginByUser(String user) throws SQLException, ClassNotFoundException, Exception
   {
        
        
        Connection myConn = this.c.getConnection();     

         String sql = "select * from login where usuario = ?";

         PreparedStatement stmt = myConn.prepareStatement(sql);
         stmt.setString(1, user);
                
        ResultSet myRS = stmt.executeQuery();

        if (myRS.next()) {
            int id = Integer.parseInt(myRS.getString("id"));
            String usuario = myRS.getString("usuario");
            String senha = myRS.getString("senha");
            
            //try {
            //    int companhiaID = myRS.getInt("companhiaID");
              
           // }
           // catch(Exception e) {
                Login aux = new Login(usuario, senha);
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
   
   public Login getloginByID(int loginID) throws SQLException, ClassNotFoundException, Exception
   {
        
        
        Connection myConn = this.c.getConnection();     

         String sql = "select * from login where id = ?";

         PreparedStatement stmt = myConn.prepareStatement(sql);
         stmt.setInt(1, loginID);
                
        ResultSet myRS = stmt.executeQuery();

        if (myRS.next()) {
            int id = Integer.parseInt(myRS.getString("id"));
            String usuario = myRS.getString("usuario");
            String senha = myRS.getString("senha");
            
            //try {
            //    int companhiaID = myRS.getInt("companhiaID");
              
           // }
           // catch(Exception e) {
                Login aux = new Login(usuario, senha);
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
    
    public int insertLogin() throws SQLException, Exception
    {
        
        Connection myConn = this.c.getConnection();
        // Statement myStmt = myConn.createStatement();
        
         String sql = "INSERT INTO login "+
                 "(usuario, senha) "+
                   "values (?, ?)";
         
         PreparedStatement stmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         stmt.setString(1, this.usuario);
         stmt.setString(2, this.senha);
         
         stmt.executeUpdate();
         ResultSet rs = stmt.getGeneratedKeys();
         rs.next();
         this.ID = rs.getInt(1);
         this.log.setID(this.ID);
         c.closeConnection(myConn, rs, stmt);
         return (this.ID);
         
         
       // myStmt.executeUpdate("insert * from valet");
        
    }
    
}
