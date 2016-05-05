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
   private String rua;
   private int numero;
   private String CEP;
   private String complemento;
    
    public Endereco(String rua, int numero, String CEP, String complemento)
    {
     this.rua = rua;
     this.numero = numero;
     this.CEP = CEP;
     this.complemento = complemento;
    }
    
}
