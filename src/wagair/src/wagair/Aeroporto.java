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
public class Aeroporto {
    String nome;
    String cidade;
    String pais;
    int id = -1;
    
    Aeroporto(String nome, String cidade, String pais)
    {
        this.nome = nome;
        this.cidade = cidade;
        this.pais = pais;
    }
    
            public String getNome()
            {
                return this.nome;
            }
            
            public String getCidade()
            {
                return this.cidade;
            }
            
            public String getPais()
            {
                return this.pais;
            }
            
            public int getID() throws Exception
            {
                if (this.id == -1)
                 {
                      throw new Exception("Erro, id do aeroporto inválido (-1)");
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
                   JOptionPane.showMessageDialog(null, "erro ao setar o id do aeroporto");
                   return false;
               }
        }
}
