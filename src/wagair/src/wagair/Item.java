/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wagair;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author a1625381
 */
public class Item {
    
    private ArrayList<Conexao> conexao = new ArrayList<>();
    private int id = -1;
    
    
    public Item(ArrayList<Conexao> conexao)
    {
        this.conexao = conexao;
    }

    public ArrayList<Conexao> getConexao() {
        return conexao;
    }
    
    public boolean addConexao(Conexao conexao)
    {
     
        try
        {
            this.conexao.add(conexao);
            return(true);
        }
            catch(Exception e)
                    {
                        return(false);
                    }
    
    }
    
      public boolean removerConexao(Conexao conexao)
    {
     
        try
        {
            this.conexao.remove(conexao);
            return(true);
        }
            catch(Exception e)
                    {
                        return(false);
                    }
    
    }
       
       public float getValorTotal()
       {
           float total = 0;
           for (Conexao con : conexao)
           {
               total = total + con.getPreco();
           }
           return(total);
       }
       
       public boolean setID(int id)
        {
            try{
                this.id = id;
                return true;
            }
               catch (Exception e)
               {
                   JOptionPane.showMessageDialog(null, "erro ao setar o id do item");
                   return false;
               }
        }
    
       public int getID() throws Exception
            {
                if (this.id == -1)
                 {
                      throw new Exception("Erro, id do item inválido (-1)");
                 }
                
                 else
                       return this.id;
                 }
}
