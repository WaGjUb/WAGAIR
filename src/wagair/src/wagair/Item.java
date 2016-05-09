/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wagair;

import java.util.ArrayList;

/**
 *
 * @author a1625381
 */
public class Item {
    
    ArrayList<Conexao> conexao;
    
    Item(ArrayList<Conexao> conexao)
    {
        this.conexao = conexao;
    }
    
    boolean addConexao(Conexao conexao)
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
    
       boolean removerConexao(Conexao conexao)
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
       
       float getValorTotal()
       {
           float total = 0;
           for (Conexao con : conexao)
           {
               total = total + con.getPreco();
           }
           return(total);
       }
    
}
