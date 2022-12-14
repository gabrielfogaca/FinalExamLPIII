/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supportsystem.view;

import java.io.File;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import supportsystem.createXML.LerValoresXML;
import supportsystem.dao.ProdutoDAO;
import supportsystem.dao.UsuarioDAO;
import supportsystem.dao.UsuarioDTO;
import supportsystem.logging.LogController;
import supportsystem.models.Produto;
import supportsystem.models.Usuario;

/**
 *
 * @author Bruno
 */
public class CadProduto extends javax.swing.JFrame {

    private Usuario usuario;

    /**
     * Creates new form CadCliente
     */
    public CadProduto() {
        initComponents();
    }
    
    public int idusuario;
    public String loginusuario;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxNomeProduto = new javax.swing.JTextField();
        btnCadProduto = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbxPrecoProduto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbxQuantidadeProduto = new javax.swing.JTextField();
        btnCadProdutoXML = new javax.swing.JButton();
        jLabelNomeUsuario = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SupportSystem - Cadastro de Produtos");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Cadastrar Produto");

        jLabel2.setText("Nome:");

        btnCadProduto.setText("Cadastrar");
        btnCadProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadProdutoActionPerformed(evt);
            }
        });

        jLabel4.setText("Pre??o:");

        cbxPrecoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cbxPrecoProdutoKeyTyped(evt);
            }
        });

        jLabel5.setText("Quantidade:");

        cbxQuantidadeProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cbxQuantidadeProdutoKeyTyped(evt);
            }
        });

        btnCadProdutoXML.setText("Carregar XML");
        btnCadProdutoXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadProdutoXMLActionPerformed(evt);
            }
        });

        jLabelNomeUsuario.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabelNomeUsuario.setText(" ");
        jLabelNomeUsuario.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabelNomeUsuarioAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel6.setText("Usuario:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel4)
                                .addGap(13, 13, 13))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxQuantidadeProduto)
                            .addComponent(cbxPrecoProduto))))
                .addContainerGap(90, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCadProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadProdutoXML))
                .addGap(141, 141, 141))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxPrecoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxQuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCadProdutoXML)
                .addGap(18, 18, 18)
                .addComponent(btnCadProduto)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadProdutoActionPerformed
        try {
            Produto produto = new Produto();
            ProdutoDAO produtodao = new ProdutoDAO();

            produto.setNome_item(cbxNomeProduto.getText());
            produto.setPreco(Float.parseFloat(cbxPrecoProduto.getText()));
            produto.setQtd(Integer.parseInt(cbxQuantidadeProduto.getText()));
            produto.setId_operador(idusuario);

            produtodao.inserirProduto(produto);
            JOptionPane.showMessageDialog(null, "Produto inserido com sucesso!");

        } catch (SQLException ex) {
            LogController.createLog("Erro ao cadastrar o produto" + ex.getMessage(), "I");
        }
        LogController.createLog("Produto cadastrado", "I");
    }//GEN-LAST:event_btnCadProdutoActionPerformed

    private void cbxPrecoProdutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxPrecoProdutoKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_cbxPrecoProdutoKeyTyped

    private void cbxQuantidadeProdutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxQuantidadeProdutoKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_cbxQuantidadeProdutoKeyTyped

    private void btnCadProdutoXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadProdutoXMLActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Selecione o arquivo XML", "xml");

        fileChooser.setFileFilter(filter);
        fileChooser.showOpenDialog(this);

        File f = fileChooser.getSelectedFile();

        Produto p = new Produto();
        p = LerValoresXML.lerXML(f.getPath());

        cbxNomeProduto.setText(p.getNome_item());
        cbxPrecoProduto.setText(String.valueOf(p.getPreco()));
        cbxQuantidadeProduto.setText(String.valueOf(p.getQtd()));
        
        JOptionPane.showMessageDialog(null, "XML Carregado!");
    }//GEN-LAST:event_btnCadProdutoXMLActionPerformed

    private void jLabelNomeUsuarioAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabelNomeUsuarioAncestorAdded
        jLabelNomeUsuario.removeAll();
        String usuario = loginusuario;
        UsuarioDTO usuariodto = new UsuarioDTO();

        UsuarioDAO usuariodao = new UsuarioDAO();

        try {
            Usuario Uusuario = usuariodao.buscarIDusuario(loginusuario);
            this.usuario = Uusuario;
            idusuario = Uusuario.getId_usuario();
        } catch (SQLException ex) {
            //Logger.getLogger(InserirVenda.class.getName()).log(Level.SEVERE, null, ex);
        };
        try {
            PopulateAuth(usuario);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jLabelNomeUsuarioAncestorAdded

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
            java.util.logging.Logger.getLogger(CadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadProduto().setVisible(true);
            }
        });
    }
    
    private void PopulateAuth(String usuario){
        jLabelNomeUsuario.setText(loginusuario);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadProduto;
    private javax.swing.JButton btnCadProdutoXML;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cbxNomeProduto;
    private javax.swing.JTextField cbxPrecoProduto;
    private javax.swing.JTextField cbxQuantidadeProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelNomeUsuario;
    // End of variables declaration//GEN-END:variables
}
