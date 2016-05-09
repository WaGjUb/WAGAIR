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
public class Voo {
    private Date dataPartida; //data e hora
    private Date dataChegada; //data e hora
    private int assentosLivres;
    private Rota rota;
    private Aviao aviao;
    
     Voo(Date dataPartida, Date dataChegada, Aviao aviao, int assentosLivres, Rota rota)
     {         
           this.dataPartida = dataPartida;
           this.dataChegada = dataChegada;
           this.assentosLivres = assentosLivres;
           this.rota = rota;
           this.aviao = aviao;
     }
    
    
}
