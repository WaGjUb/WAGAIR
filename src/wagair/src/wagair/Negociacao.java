/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wagair;

import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author a1625381
 */
public class Negociacao {
    
    private Calendar dataNegociacao; //horario e data
    private float total;
    private boolean status = false; //pagamento
    private Cliente cliente;
    private Vendedor vendedor;
    private Item item;
    private int id = -1;
    
    public Negociacao(Item item, Cliente cliente, Vendedor vendedor, float total)
    {
        this.dataNegociacao = Calendar.getInstance();
        this.item = item;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.total = total;
    }
    
      public boolean setID(int id)
        {
            try{
                this.id = id;
                return true;
            }
               catch (Exception e)
               {
                   JOptionPane.showMessageDialog(null, "erro ao setar o id da negociação");
                   return false;
               }
        }
    
      public int getID() throws Exception
            {
                if (this.id == -1)
                 {
                      throw new Exception("Erro, id da negociação inválido (-1)");
                 }
                
                 else
                       return this.id;
                 }
      
     public java.sql.Timestamp getData()
     {
         Date aux = this.dataNegociacao.getTime();
         return new java.sql.Timestamp(aux.getTime());
     }
     
     public Cliente getCliente()
     {
         return this.cliente;
     }

    public float getTotal() {
        return total;
    }

    public boolean isStatus() {
        return status;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public Item getItem() {
        return item;
    }
     
    
    public void pagamentoConfirmado()
    {
        this.status = true;
    }
     
}
