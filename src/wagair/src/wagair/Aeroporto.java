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
}
