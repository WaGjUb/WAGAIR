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
public class Aviao {
    
    private String fabricante;
    private String modelo;
    private int capacidade;
    private CompanhiaAerea companhia;
    
    Aviao(String fabricante, String modelo, int capacidade, CompanhiaAerea companhia)
    {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.capacidade = capacidade;  
        this.companhia = companhia;
    }
    
    Aviao(String fabricante, String modelo, int capacidade)
    {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.capacidade = capacidade;             
    }
    
    
}
