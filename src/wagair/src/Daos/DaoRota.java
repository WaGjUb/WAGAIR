/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import java.sql.SQLException;
import wagair.Aviao;
import wagair.Rota;

/**
 *
 * @author a1625381
 */
public class DaoRota {
    private JDBCwagair c;
    private Rota rota;
    private int idDestino;
    private int idOrigem;
    private int ID;
    
    DaoRota(Rota r) throws SQLException, ClassNotFoundException, Exception{
            this.c = new JDBCwagair();
            this.rota = r;
          /*  this.fabricante = a.getFabricante();
            this.modelo = a.getModelo();
            this.capacidade = a.getCapacidade();
            this.idComp = a.getComp().getID();*/
    }
}
