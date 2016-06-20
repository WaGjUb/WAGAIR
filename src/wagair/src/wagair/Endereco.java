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
public class Endereco {
   private int id = -1;
   private String rua;
   private int numero;
   private String CEP;
   private String complemento = "";
    
    public Endereco(String rua, int numero, String CEP, String complemento)
    {
     this.rua = rua;
     this.numero = numero;
     this.CEP = CEP;
     this.complemento = complemento;
    }
    
        public Endereco(String rua, int numero, String CEP)
    {
     this.rua = rua;
     this.numero = numero;
     this.CEP = CEP;
    }
    
        public void setID(int novoID) throws Exception
    {
      this.id = novoID;
    }
        
    public int getID() throws Exception
    {
        if (this.id == -1)
        {
            throw new Exception("Erro, id do endereco inválido (-1)");
        }
        else
        {
           return this.id;
        }
    }
    
    public String getRua()
    {
        return this.rua;
    }
    
    public int getNumero()
    {
        return this.numero;
    }
    
    public String getCEP()
    {
        return this.CEP;
    }
    
    public String getComplemento()
    {
        return this.complemento;
    }
            
}
