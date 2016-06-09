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
public class Vendedor extends Pessoa{
    
    String CNPJ;
    public Vendedor(String nome, String sobrenome, String CNPJ, String telefone, String celular, Endereco endereco, Login login) {
        super(nome, sobrenome, telefone, celular, endereco, login);
        this.CNPJ = CNPJ;
    }
    
    
}
