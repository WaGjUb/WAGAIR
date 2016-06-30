/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import Daos.DaoCliente;
import Daos.DaoPessoa;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import wagair.Login;

/**
 *
 * @author a1625381
 */
public class comLogin extends javax.swing.JPanel {

    /**
     * Creates new form comLogin
     */
    private Login login;
    public void setLogin(Login l) throws Exception
    {
        this.login = l;
       // System.out.println("id login: " + l.getID());
        nomeLabel.setText(l.getUsuario());
    }
    public comLogin() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        olaLabel = new javax.swing.JLabel();
        nomeLabel = new javax.swing.JLabel();

        olaLabel.setText("Olá,");

        nomeLabel.setText("Nome do usuário");
        nomeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nomeLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(olaLabel)
                .addGap(5, 5, 5)
                .addComponent(nomeLabel))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(olaLabel)
                    .addComponent(nomeLabel)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nomeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nomeLabelMouseClicked
        // TODO add your handling code here:
        //verificar se é vendedor ou cliente
        
        try {
            int pessoaID;
            int clienteID;
            DaoPessoa dp;
            dp = new DaoPessoa();
            pessoaID = dp.getPessoaIDByLoginID(login.getID());
            //System.out.println("id pessoa" + pessoaID);
            if (pessoaID != -1)
            {
            System.out.println("id de pessoa recuperado");
            DaoCliente dc;
            dc = new DaoCliente();
            clienteID = dc.getClienteIDByPessoaID(pessoaID);
            System.out.println("ID retornado: " + clienteID);
                if (clienteID == -1) // se não for cliente
                {
                    cadastrosFrame panel = new cadastrosFrame();
                    panel.setLogin(this.login);
                    panel.setVisible(true);

                }
                else
                {
                    compraFrame panel = new compraFrame();
                    panel.setLogin(this.login);
                    panel.setVisible(true);
                }
            }
              else
            {
                System.out.println("Erro, ao recuperar id de pessoa");
            }
        } catch (SQLException ex) {
            Logger.getLogger(comLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(comLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(comLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

    }//GEN-LAST:event_nomeLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JLabel olaLabel;
    // End of variables declaration//GEN-END:variables
}
