/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supportsystem.view;

import java.io.File;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import supportsystem.createXML.LerValoresXML;
import supportsystem.dao.ProdutoDAO;
import supportsystem.dao.ProdutoDTO;
import supportsystem.logging.LogController;
import supportsystem.models.Produto;

/**
 *
 * @author Bruno
 */
public class DelProduto extends javax.swing.JFrame {

    /**
     * Creates new form CadCliente
     */
    public DelProduto() {
        initComponents();
    }
    
    private Produto produto;
    

    public int idProduto;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        btnGerarXML1 = new javax.swing.JButton();
        cbxNomeprodutoDel = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SupportSystem - Cadastro de Produtos");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Deletar Produto");

        btnGerarXML1.setText("Sim");
        btnGerarXML1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarXML1ActionPerformed(evt);
            }
        });

        cbxNomeprodutoDel.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbxNomeprodutoDelAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        cbxNomeprodutoDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNomeprodutoDelActionPerformed(evt);
            }
        });

        jLabel4.setText("Deseja deletar o(a) Produto:");

        jLabel5.setText("?");

        jButton7.setText("Não");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxNomeprodutoDel)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 102, Short.MAX_VALUE)
                        .addComponent(btnGerarXML1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(cbxNomeprodutoDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(btnGerarXML1))
                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbxNomeprodutoDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNomeprodutoDelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxNomeprodutoDelActionPerformed

    private void cbxNomeprodutoDelAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbxNomeprodutoDelAncestorAdded
       cbxNomeprodutoDel.setEditable(false);
       cbxNomeprodutoDel.removeAll();
       Object selectedItem = idProduto;
       if (selectedItem != null) {
           int produtoid = idProduto;
           
           ProdutoDTO produtodto = new ProdutoDTO();
            
           ProdutoDAO produtodao = new ProdutoDAO();

            try {
               Produto Pproduto = produtodao.buscarProduto(produtoid);
               this.produto = Pproduto;
               PopulateFields(Pproduto);
                
            } catch (SQLException ex) {
                //Logger.getLogger(InserirVenda.class.getName()).log(Level.SEVERE, null, ex);
            };
        }
    }//GEN-LAST:event_cbxNomeprodutoDelAncestorAdded

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
      dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnGerarXML1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarXML1ActionPerformed
       try {
            Produto produto = new Produto();
            ProdutoDAO produtoDAO = new ProdutoDAO();

            produto.setId_item(idProduto);
            
            produtoDAO.deletarProduto(produto);
            JOptionPane.showMessageDialog(null, "Produto deletado com sucesso!");

        } catch (SQLException ex) {
            LogController.createLog("Erro ao deletadar produto", "W");
        }
        LogController.createLog("Produto deletado", "I");                                             
    }//GEN-LAST:event_btnGerarXML1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DelProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DelProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DelProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DelProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DelProduto().setVisible(true);
            }
        });
        
    }

      private void PopulateFields(Produto Pproduto){
        cbxNomeprodutoDel.setText(Pproduto.getNome_item());
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerarXML1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cbxNomeClienteatual;
    private javax.swing.JTextField cbxNomeVendedoratual;
    private javax.swing.JTextField cbxNomeprodutoDel;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
