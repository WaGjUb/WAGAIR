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
public class Login {
    String usuario;
    String senha;
    int id = -1;
    
    public Login(String usuario, String senha)
    {
      this.usuario = usuario;
      this.senha = senha;
    }
    
    public String getUsuario() throws Exception
    {
      return(this.usuario)  ;
    }
    
    public String getSenha() throws Exception
    {
        return(this.senha);
    }
    
    public int getID() throws Exception
    {   if (this.id == -1)
        {
            throw new Exception("Erro, id do login inválido (-1)");
        }
        else
    {
        return this.id;
    }
    }
 
    public boolean setID(int id) throws Exception
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
}
