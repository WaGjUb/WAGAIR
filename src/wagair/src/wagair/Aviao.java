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
public class Aviao {
    private int id = -1;
    private String fabricante;
    private String modelo;
    private int capacidade;
    private CompanhiaAerea companhia = null;
    
    public Aviao(String fabricante, String modelo, int capacidade, CompanhiaAerea companhia)
    {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.capacidade = capacidade;  
        this.companhia = companhia;
    }
    
    public Aviao(String fabricante, String modelo, int capacidade)
    {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.capacidade = capacidade;             
    }
    public boolean setID(int id)
        {
            try{
                this.id = id;
                return true;
            }
               catch (Exception e)
               {
                   JOptionPane.showMessageDialog(null, "erro ao setar o id do avião");
                   return false;
               }
        }
    
            public String getFabricante()
            {
                return this.fabricante;
            }

    public int getID() {
        return this.id;
    }
            public String getModelo()
            {
                return this.modelo;
            }
            public int getCapacidade()
            {
                return this.capacidade;
            }
            public CompanhiaAerea getComp()
            {
                return this.companhia;
            }
}
