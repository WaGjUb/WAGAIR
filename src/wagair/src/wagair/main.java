/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wagair;

import Daos.DaoEndereco;
import frames.mainFrame;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author a1625381
 */
public class main {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) throws ClassNotFoundException, Exception {
        // TODO code application logic here
        
        mainFrame m = new mainFrame();
        m.setVisible(true);
  /*
   Calendar mdata = Calendar.getInstance(); 
    System.out.println(mdata.getTime());
    Date aux = mdata.getTime();
    java.sql.Timestamp  sql = new java.sql.Timestamp(aux.getTime());
    System.out.println(sql);
    
    Endereco e = new Endereco("rua teste dois", 18, "01625380");
    DaoEndereco d = new DaoEndereco(e);
    d.insertEndereco();
*/
    }
}
