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
import wagair.Conexao;
import wagair.Passagem;

/**
 *
 * @author wagjub
 */
public class DaoConexao {
    private JDBCwagair c;
    private Conexao conexao;
    private float preco;
    private ArrayList<Passagem> passagens;
    private int ID;
    
        public DaoConexao(Conexao c) throws SQLException, ClassNotFoundException, Exception{
            this.c = new JDBCwagair();
            this.conexao = c;
            this.preco = c.getPreco();
            this.passagens = c.getPassagem();
    }
        
         public int insertConexao() throws SQLException
    {
        
        Connection myConn = this.c.getConnection();
        // Statement myStmt = myConn.createStatement();
        
         String sql = "INSERT INTO conexao "+
                 "(preco) "+
                   "values (?)";
         PreparedStatement stmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         stmt.setFloat(1, this.preco);

         
         stmt.executeUpdate();
         ResultSet rs = stmt.getGeneratedKeys();
         rs.next();
         this.ID = rs.getInt(1);
         this.conexao.setID(this.ID);
         c.closeConnection(myConn, rs, stmt);
         return (this.ID);
         
         //ResultSet rs = preparedStatement.executeQuery();
       // myStmt.executeUpdate("insert * from valet");
        
    }
}
