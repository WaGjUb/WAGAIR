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
public class Rota {
       private Aeroporto origem;
       private Aeroporto destino;
       private int id = -1;
    
        Rota(Aeroporto origem, Aeroporto destino)
        {
            this.origem = origem;
            this.destino = destino;
        }
        
        public int getID() throws Exception
    {
        if (this.id == -1)
                 {
                      throw new Exception("Erro, id da companhiaAerea inválido (-1)");
                 }
                
                 else
                       return this.id;
    }
    
    public Aeroporto getOrigem()
    {
        return this.origem;
    }
   
    public Aeroporto getDestino()
    {
        return this.destino;
    }
    
    public void setID(int id)
    {
        this.id = id;
    }
}
