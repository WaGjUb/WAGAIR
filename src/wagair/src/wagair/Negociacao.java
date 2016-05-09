/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wagair;

import java.util.Date;

/**
 *
 * @author a1625381
 */
public class Negociacao {
    
    private Date dataNegociacao; //horario e data
    private float total;
    private boolean status = false; //pagamento
    private Cliente cliente;
    private Vendedor vendedor;
    private Item item;
    
    Negociacao(Date dataNegociacao, Item item, Cliente cliente, Vendedor vendedor)
    {
        this.dataNegociacao = dataNegociacao;
        this.item = item;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.total = this.item.getValorTotal();
    }
    
    void pagamentoConfirmado()
    {
        this.status = true;
    }
     
}
