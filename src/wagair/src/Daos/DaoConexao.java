/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;
import static java.lang.System.in;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import wagair.Aviao;
import wagair.Conexao;
import wagair.Login;
import wagair.Passagem;
import wagair.Voo;

/**
 *
 * @author wagjub
 */
public class DaoConexao {
    private JDBCwagair c;
    private Conexao conexao;
    private float preco;
    private ArrayList<Voo> voos;
    private int ID;
    private int quantidade;
    private Login login;
    
        public DaoConexao(Conexao c) throws SQLException, ClassNotFoundException, Exception{
            this.c = new JDBCwagair();
            this.conexao = c;
            this.preco = c.getPreco();
            this.voos = c.getVoo();
            this.quantidade = c.getQuantidade();
            this.login = c.getLoginVendedor();
    }

    public DaoConexao() throws SQLException, ClassNotFoundException {
        this.c = new JDBCwagair();
    }
    
    public ArrayList<Voo> getVooConexaoLink(int vooID) throws SQLException, Exception
   {
        ArrayList<Conexao> resultado = new ArrayList<>();
        
        Connection myConn = this.c.getConnection();       
        Statement myStmt = myConn.createStatement();
        ResultSet myRS = myStmt.executeQuery("select * from link_conexao");
        


            ArrayList<Voo> voo = new ArrayList<>();
           
            while (myRS.next())
            {
                   if (myRS.getInt("conexaoID") == vooID)
                   {
                       int idvoo = Integer.parseInt(myRS.getString("vooID"));
                         DaoVoo dv = new DaoVoo();     
                        voo.add(dv.getVooByID(idvoo));
                   }
                   

                   
            }
            
            //try {
            //    int companhiaID = myRS.getInt("companhiaID");
              
           // }
           // catch(Exception e) {
           // }
        //}
            
 
       
       return voo;
   }        
    
    public ArrayList<Conexao> getConexao() throws SQLException, Exception
   {
        ArrayList<Conexao> resultado = new ArrayList<>();
        
        Connection myConn = this.c.getConnection();       
        Statement myStmt = myConn.createStatement();
        ResultSet myRS = myStmt.executeQuery("select * from conexao");

        while (myRS.next()) {
            int id = Integer.parseInt(myRS.getString("id"));
            float preco = myRS.getFloat("preco");
            int quantidade = myRS.getInt("quantidade");
            int loginID = myRS.getInt("loginID");
            
            ArrayList<Voo> voo = getVooConexaoLink(id);
            DaoLogin dl = new DaoLogin();
            Login l = dl.getloginByID(loginID);
                Conexao aux = new Conexao(preco, voo, quantidade, l);

            aux.setID(id);            
            resultado.add(aux);
        }
       
       return resultado;
   }        
        
         public int insertConexao() throws SQLException, Exception
    {
        
        Connection myConn = this.c.getConnection();
        // Statement myStmt = myConn.createStatement();
        
         String sql = "INSERT INTO conexao "+
                 "(preco, quantidade, loginID) "+
                   "values (?, ?, ?)";
         PreparedStatement stmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         stmt.setFloat(1, this.preco);
         stmt.setInt(2, this.quantidade);
         stmt.setInt(3, this.login.getID());
         
         

         
         stmt.executeUpdate();
         ResultSet rs = stmt.getGeneratedKeys();
         rs.next();
         this.ID = rs.getInt(1);
         this.conexao.setID(this.ID);

         
         sql = "INSERT INTO link_conexao "+
                 "(ordenacao, conexaoID, vooID) "+
                   "values (?, ?, ?)";
            stmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int i = 1;
         for (Voo v : this.voos)
         {
            stmt.setInt(1, i);
            stmt.setInt(2, this.ID);
            stmt.setInt(3, v.getID());
            stmt.executeUpdate();
            i++;
         }
         c.closeConnection(myConn, rs, stmt);
         return (this.ID);
         
         //ResultSet rs = preparedStatement.executeQuery();
       // myStmt.executeUpdate("insert * from valet");
        
    }
}
