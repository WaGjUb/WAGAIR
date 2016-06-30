/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wagair;

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author a1625381
 */
public class Conexao {
   
   private int id;
   private float preco;
   private ArrayList<Voo> voo; 
   private int quantidade;
   private Login loginVendedor;
    
   public Conexao (float preco, ArrayList<Voo> voo, int quantidade, Login loginVendedor)
    {
        this.preco = preco;
        this.voo = voo;
        this.quantidade = quantidade;
        this.loginVendedor = loginVendedor;
        
    }
    
       public Conexao (float preco)
    {
        this.preco = preco;
    }
        
   
      public Conexao (ArrayList<Voo> voo)
    {
        this.voo = voo;
    }

    public ArrayList<Voo> getVoo() {
        return voo;
    }
    
    public boolean getVooInDate(Calendar c, Rota or, Rota ds) throws Exception {
        ArrayList<Voo> result = new ArrayList<>();
        
        Voo sai = this.voo.get(0);
        Voo chega = this.voo.get(this.voo.size()-1);;
        boolean verif = false;
        
        System.out.println(sai.getRota().getOrigem().getCidade());
        System.out.println(chega.getRota().getDestino().getCidade());

            System.out.println("dia " + sai.getDataPartida().getTime().getDay() + " -> " + c.getTime().getDay());
            System.out.println("mes " + sai.getDataPartida().getTime().getMonth() + " -> " + c.getTime().getMonth());
            System.out.println("ano " + sai.getDataPartida().getTime().getYear() + " -> " + c.getTime().getYear());
            if ((sai.getRota().getOrigem().getID() ==  or.getOrigem().getID()) && (chega.getRota().getDestino().getID() ==  or.getDestino().getID()))// && (c.getTime().getDay() == sai.getDataPartida().getTime().getDay()) && (c.getTime().getMonth() == sai.getDataPartida().getTime().getMonth() && (c.getTime().getYear() == sai.getDataPartida().getTime().getYear())))
            {
                verif = true;
            }
            
        
        
        return verif;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Login getLoginVendedor() {
        return loginVendedor;
    }

    
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
       
       
       
          public int getID() throws Exception
            {
                if (this.id == -1)
                 {
                      throw new Exception("Erro, id da conexão inválido (-1)");
                 }
                
                 else
                       return this.id;
                 }
          
        public boolean setID(int id)
        {
            try{
                this.id = id;
                return true;
            }
               catch (Exception e)
               {
                   JOptionPane.showMessageDialog(null, "erro ao setar o id da conexão");
                   return false;
               }
        }
      public boolean addVoo (Voo voo)
    {
        try
        {
            this.voo.add(voo);
            return(true);
        }
            catch(Exception e)
                    {
                        return(false);
                    }
    }
       

       
        public boolean removerVoo (Voo voo) //cuidado ao usar
    {
        try
        {
            this.voo.remove(voo);
            return(true);
        }
            catch(Exception e)
                    {
                        return(false);
                    }
    }
        
      public boolean alterarPreco (float preco)
    {
        try
        {
            this.preco = preco;
            return(true);
        }
            catch(Exception e)
                    {
                        return(false);
                    }
    }
       
      public float getPreco()
       {
           return(this.preco);
       }
}
