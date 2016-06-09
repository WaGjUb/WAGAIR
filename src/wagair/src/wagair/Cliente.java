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
public class Cliente extends Pessoa{
       String CPF;
    public Cliente(String nome, String sobrenome, String CPF, String telefone, String celular, Endereco endereco, Login login) {
        super(nome, sobrenome, telefone, celular, endereco, login);
        this.CPF = CPF;
    }
    

    
    
}
