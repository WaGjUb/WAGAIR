/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wagair;

import javax.swing.JOptionPane;

/**
 *
 * @author a1625381
 */
public class Passagem {
    
    private Conexao conexao;
    private String assento;
    private int id = -1;
    
    
   public Passagem(Conexao conexao, String assento)
    {
        this.conexao = conexao;
        this.assento = assento;
    }

    public Conexao getConexao() {
        return conexao;
    }

    public String getAssento() {
        return assento;
    }
    
           public boolean setID(int id)
        {
            try{
                this.id = id;
                return true;
            }
               catch (Exception e)
               {
                   JOptionPane.showMessageDialog(null, "erro ao setar o id da passagem");
                   return false;
               }
        }
           
               public int getID() throws Exception
            {
                if (this.id == -1)
                 {
                      throw new Exception("Erro, id da passagem inválido (-1)");
                 }
                
                 else
                       return this.id;
                 }

}
