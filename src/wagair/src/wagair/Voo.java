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
 * @author a1625381 java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime());
 * 
Calendar cal = Calendar.getInstance();
cal.set(Calendar.HOUR_OF_DAY,17);
cal.set(Calendar.MINUTE,30);
cal.set(Calendar.SECOND,0);
cal.set(Calendar.MILLISECOND,0);
 */
public class Voo {
    private Calendar dataPartida; //data e hora
    private Calendar dataChegada; //data e hora
    private int assentosLivres;
    private Rota rota;
    private Aviao aviao;
    private int id = -1;
    
     public Voo(Calendar dataPartida, Calendar dataChegada, Aviao aviao, int assentosLivres, Rota rota)
     {         
           this.dataPartida = dataPartida;
           this.dataChegada = dataChegada;
           this.assentosLivres = assentosLivres;
           this.rota = rota;
           this.aviao = aviao;
     }

    public Calendar getDataPartida() {
        return dataPartida;
    }

    public Calendar getDataChegada() {
        return dataChegada;
    }

    public int getAssentosLivres() {
        return assentosLivres;
    }

    public int getId() {
        return id;
    }
    
             public boolean setID(int id)
        {
            try{
                this.id = id;
                return true;
            }
               catch (Exception e)
               {
                   JOptionPane.showMessageDialog(null, "erro ao setar o id do voo");
                   return false;
               }
        }
             
                        public int getID() throws Exception
            {
                if (this.id == -1)
                 {
                      throw new Exception("Erro, id do voo inválido (-1)");
                 }
                
                 else
                       return this.id;
                 }
     
     public Aviao getAviao()
     {
         return this.aviao;
     }
     
     public Rota getRota()
     {
         return this.rota;
     }
     
     public int getLivres()
     {
         return this.assentosLivres;
     }
     
     public java.sql.Timestamp getSQLPartida()
     {
         Date aux = this.dataPartida.getTime();
         return new java.sql.Timestamp(aux.getTime());
     }
    
         
     public java.sql.Timestamp getSQLChegada()
     {
         Date aux = this.dataChegada.getTime();
         return new java.sql.Timestamp(aux.getTime());
     }
    
}
