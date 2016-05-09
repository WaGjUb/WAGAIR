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
public class Conexao {
    
   private float preco;
   private ArrayList<Passagem> passagem; 
    
    Conexao (float preco, ArrayList<Passagem> passagem)
    {
        this.preco = preco;
        this.passagem = passagem;
    }
    
        Conexao (float preco)
    {
        this.preco = preco;
    }
        
   
       Conexao (ArrayList<Passagem> passagem)
    {
        this.passagem = passagem;
    }
       
       boolean addPassagem (Passagem passagem)
    {
        try
        {
            this.passagem.add(passagem);
            return(true);
        }
            catch(Exception e)
                    {
                        return(false);
                    }
    }
       
       
        boolean removerPassagem (Passagem passagem)
    {
        try
        {
            this.passagem.remove(passagem);
            return(true);
        }
            catch(Exception e)
                    {
                        return(false);
                    }
    }
        
       boolean alterarPreco (float preco)
    {
        try
        {
            this.preco = preco;
            return(true);
        }
            catch(Exception e)
                    {
                        return(false);
                    }
    }
       
       float getPreco()
       {
           return(this.preco);
       }
}
