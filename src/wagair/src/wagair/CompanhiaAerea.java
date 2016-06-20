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
public class CompanhiaAerea {
    String nome;
    int id = -1;
    
    CompanhiaAerea(String nome)
    {
        this.nome = nome;
    }
    
    public int getID() throws Exception
    {
        if (this.id == -1)
                 {
                      throw new Exception("Erro, id da companhiaAerea inválido (-1)");
                 }
                
                 else
                       return this.id;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public void setID(int id)
    {
        this.id = id;
    }
}
