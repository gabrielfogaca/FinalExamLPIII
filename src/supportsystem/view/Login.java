/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supportsystem.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import supportsystem.dao.ClienteDAO;
import supportsystem.dao.ClienteDTO;
import supportsystem.dao.ProdutoDAO;
import supportsystem.dao.ProdutoDTO;
import supportsystem.dao.UsuarioDAO;
import supportsystem.dao.VendaDAO;
import supportsystem.dao.VendaDTO;
import supportsystem.logging.LogController;
import supportsystem.models.Cliente;
import supportsystem.models.Usuario;

/**
 *
 * @author Bruno
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public Login() {
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

        jLabel3 = new javax.swing.JLabel();
        cbxUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxSenha = new javax.swing.JTextField();
        btnLogar = new javax.swing.JButton();
        btnCloseLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Support System - Menu Clientes");
        setResizable(false);

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));

        cbxUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxUsuarioActionPerformed(evt);
            }
        });

        jLabel2.setText("Usuario");

        jLabel5.setText("Senha");

        cbxSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSenhaActionPerformed(evt);
            }
        });
        cbxSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cbxSenhaKeyTyped(evt);
            }
        });

        btnLogar.setText("Entrar");
        btnLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogarActionPerformed(evt);
            }
        });

        btnCloseLogin.setText("Sair");
        btnCloseLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseLoginActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("LOGIN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCloseLogin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLogar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cbxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbxSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(jLabel3)))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(160, 160, 160))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogar)
                    .addComponent(btnCloseLogin))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbxUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxUsuarioActionPerformed

    private void cbxSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSenhaActionPerformed

    private void cbxSenhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxSenhaKeyTyped

    }//GEN-LAST:event_cbxSenhaKeyTyped

    private void btnLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogarActionPerformed
        try{
            Usuario usuario = new Usuario();
            UsuarioDAO usuarioDAO = new UsuarioDAO();

            usuario.setLogin(cbxUsuario.getText());
            usuario.setSenha(cbxSenha.getText());
            
            if (usuario.getLogin().isEmpty()) {
                JOptionPane.showMessageDialog(null, "É necessario inserir o login!");
            }else if(usuario.getSenha().isEmpty()){
                JOptionPane.showMessageDialog(null, "É necessario inserir a senha!");
            }else if(usuarioDAO.logar(usuario)) {
                System.out.println(usuario.getId_usuario());
                JOptionPane.showMessageDialog(null, "Login realizado!");
                MenuPrincipal frame = new MenuPrincipal();
                frame.idusuario = usuario.getId_usuario();
                frame.loginusuario = usuario.getLogin();
                LogController.createLog("Login realizado com sucesso", "I");
                frame.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao realizar o login!");
                LogController.createLog("Erro ao realizar login no sistema", "W");
            }
            } catch (SQLException ex) {
        }
    }//GEN-LAST:event_btnLogarActionPerformed

    private void btnCloseLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseLoginActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseLoginActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCloseLogin;
    private javax.swing.JButton btnLogar;
    private javax.swing.JTextField cbxNovoNomeProduto;
    private javax.swing.JTextField cbxNovoNomeProduto1;
    private javax.swing.JTextField cbxSenha;
    private javax.swing.JTextField cbxUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables


}
