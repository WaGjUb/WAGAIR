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
public class Pessoa {
    private int id = -1;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String celular;
    private Endereco endereco;
    private Login login; 
        
        public Pessoa(String nome, String sobrenome, String telefone, String celular, Endereco endereco, Login login)
        {
           this.nome = nome;
           this.sobrenome = sobrenome;
           this.telefone = telefone;
           this.celular = celular;
           this.endereco = endereco;
           this.login = login;
        }
        
        public boolean setID(int id)
        {
            try{
                this.id = id;
                return true;
            }
               catch (Exception e)
               {
                   JOptionPane.showMessageDialog(null, "erro ao setar o id da pessoa");
                   return false;
               }
        }
        
        

          public String getNome()
            {
                return this.nome;
            }
            
           public String getSobrenome()
            {
                return this.sobrenome;
            }
           public String getTelefone()
            {
                return this.telefone;
            }
            
            public String getCelular()
            {
                return this.celular;
            }
            
            public int getID() throws Exception
            {
                if (this.id == -1)
                 {
                      throw new Exception("Erro, id da pessoa inválido (-1)");
                 }
                
                 else
                       return this.id;
                 }
            
            public Endereco getEndereco()
            {
                return this.endereco;
            }
            
            public Login getLogin()
            {
                return this.login;                     
            }

        
        
}
