/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wagair;

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
   
    public static void main(String[] args) {
        // TODO code application logic here
        
  
   Calendar mdata = Calendar.getInstance(); 
    System.out.println(mdata.getTime());
    Date aux = mdata.getTime();
    java.sql.Timestamp  sql = new java.sql.Timestamp(aux.getTime());
    System.out.println(sql);

    }
}
