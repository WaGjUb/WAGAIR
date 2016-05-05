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
public abstract class Pessoa {
    private String nome;
    private String telefone;
    private String celular;
    private Endereco endereco;
    private Login login; 
        
        public Pessoa(String nome, String telefone, String celular, Endereco endereco, Login login)
        {
           this.nome = nome;
           this.telefone = telefone;
           this.celular = celular;
           this.endereco = endereco;
           this.login = login;
        }
}
