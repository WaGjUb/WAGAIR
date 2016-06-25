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
public class Conexao {
   
   private int id;
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

    public ArrayList<Passagem> getPassagem() {
        return passagem;
    }
       
       
       
          public int getID() throws Exception
            {
                if (this.id == -1)
                 {
                      throw new Exception("Erro, id da conexão inválido (-1)");
                 }
                
                 else
                       return this.id;
                 }
          
        public boolean setID(int id)
        {
            try{
                this.id = id;
                return true;
            }
               catch (Exception e)
               {
                   JOptionPane.showMessageDialog(null, "erro ao setar o id da conexão");
                   return false;
               }
        }
      public boolean addPassagem (Passagem passagem)
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
       
       
        public boolean removerPassagem (Passagem passagem)
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
        
      public boolean alterarPreco (float preco)
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
       
      public float getPreco()
       {
           return(this.preco);
       }
}
