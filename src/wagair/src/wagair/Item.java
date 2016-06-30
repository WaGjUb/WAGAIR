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
    
    private ArrayList<Passagem> passagem = new ArrayList<>();
    private int id = -1;
    
    
    public Item(ArrayList<Passagem> passagem)
    {
        this.passagem = passagem;
    }

    public ArrayList<Passagem> getPassagem() {
        return passagem;
    }
    
    public boolean addPassagem(Passagem passagem)
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
    
      public boolean removerPassagem(Passagem passagem)
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
