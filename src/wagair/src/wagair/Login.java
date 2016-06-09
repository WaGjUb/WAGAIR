/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wagair;

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
}
