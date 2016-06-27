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
import wagair.Conexao;
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
    
        public DaoConexao(Conexao c) throws SQLException, ClassNotFoundException, Exception{
            this.c = new JDBCwagair();
            this.conexao = c;
            this.preco = c.getPreco();
            this.voos = c.getVoo();
            this.quantidade = c.getQuantidade();
    }
        
        
        
         public int insertConexao() throws SQLException, Exception
    {
        
        Connection myConn = this.c.getConnection();
        // Statement myStmt = myConn.createStatement();
        
         String sql = "INSERT INTO conexao "+
                 "(preco, quantidade) "+
                   "values (?, ?)";
         PreparedStatement stmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         stmt.setFloat(1, this.preco);
         stmt.setInt(2, this.quantidade);
         

         
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