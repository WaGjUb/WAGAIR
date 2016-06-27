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
   private ArrayList<Voo> voo; 
   private int quantidade;
    
   public Conexao (float preco, ArrayList<Voo> voo, int quantidade)
    {
        this.preco = preco;
        this.voo = voo;
        this.quantidade = quantidade;
    }
    
       public Conexao (float preco)
    {
        this.preco = preco;
    }
        
   
      public Conexao (ArrayList<Voo> voo)
    {
        this.voo = voo;
    }

    public ArrayList<Voo> getVoo() {
        return voo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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
      public boolean addVoo (Voo voo)
    {
        try
        {
            this.voo.add(voo);
            return(true);
        }
            catch(Exception e)
                    {
                        return(false);
                    }
    }
       
       
        public boolean removerVoo (Voo voo) //cuidado ao usar
    {
        try
        {
            this.voo.remove(voo);
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
