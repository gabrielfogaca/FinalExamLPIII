/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supportsystem.view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import supportsystem.dao.ClienteDAO;
import supportsystem.dao.ClienteDTO;
import supportsystem.dao.ProdutoDAO;
import supportsystem.dao.UsuarioDAO;
import supportsystem.dao.UsuarioDTO;
import supportsystem.dao.VendedorDAO;
import supportsystem.dao.VendedorDTO;
import supportsystem.logging.LogController;
import supportsystem.models.Cliente;
import supportsystem.models.Produto;
import supportsystem.models.Usuario;
import supportsystem.models.Vendedor;

/**
 *
 * @author Bruno
 */
public class EditVendedor extends javax.swing.JFrame {

    /**
     * Creates new form CadCliente
     */
    private Vendedor vendedor;
    private Usuario usuario;
    
    public EditVendedor() {
        initComponents();
    }

    public int idVendedor;
    
        
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
        cbxNovoNomeVendedor = new javax.swing.JTextField();
        btnEditCliente = new javax.swing.JButton();
        cbxNomeVendedoratual = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbxNovaComissao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelNomeUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Editar Vendedor");

        jLabel2.setText("Novo nome:");

        cbxNovoNomeVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNovoNomeVendedorActionPerformed(evt);
            }
        });

        btnEditCliente.setText("Editar");
        btnEditCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditClienteActionPerformed(evt);
            }
        });

        cbxNomeVendedoratual.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbxNomeVendedoratualAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        cbxNomeVendedoratual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNomeVendedoratualActionPerformed(evt);
            }
        });

        jLabel4.setText("Nome atual:");

        cbxNovaComissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNovaComissaoActionPerformed(evt);
            }
        });
        cbxNovaComissao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cbxNovaComissaoKeyTyped(evt);
            }
        });

        jLabel5.setText("Nova Comissao:");

        jLabel6.setText("Usuario:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbxNovoNomeVendedor)
                                .addComponent(cbxNovaComissao)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(157, 157, 157)
                            .addComponent(btnEditCliente))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addComponent(jLabel1))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addComponent(cbxNomeVendedoratual, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxNomeVendedoratual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxNovoNomeVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxNovaComissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(btnEditCliente)
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditClienteActionPerformed
        try {
            Vendedor vendedor = new Vendedor();
            VendedorDAO vendedorDAO = new VendedorDAO();

            vendedor.setId_vendedor(idVendedor);
            vendedor.setNome_vendedor(cbxNovoNomeVendedor.getText());
            vendedor.setPc_comissao(Integer.parseInt(cbxNovaComissao.getText()));
            vendedor.setId_operador(idusuario);
            
            vendedorDAO.editarVendedor(vendedor);
            JOptionPane.showMessageDialog(null, "Vendedor editado com sucesso!");

        } catch (SQLException ex) {
            LogController.createLog("Erro ao cadastrar vendedor", "W");
        }
        LogController.createLog("Vendedor cadastrado", "I");
    }//GEN-LAST:event_btnEditClienteActionPerformed

    private void cbxNomeVendedoratualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNomeVendedoratualActionPerformed
        
    }//GEN-LAST:event_cbxNomeVendedoratualActionPerformed

    private void cbxNomeVendedoratualAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbxNomeVendedoratualAncestorAdded
        cbxNomeVendedoratual.setEditable(false);
        cbxNomeVendedoratual.removeAll();
        Object selectedItem = idVendedor;
        if (selectedItem != null) {
            int vendedorid = idVendedor;

            VendedorDTO vendedordto = new VendedorDTO();
            
            VendedorDAO vendedordao = new VendedorDAO();

            try {
                Vendedor Vvendedor = vendedordao.buscarVendedor(vendedorid);
                this.vendedor = Vvendedor;
                PopulateFields(Vvendedor);
                //cbxNomeClienteatual.();
                
            } catch (SQLException ex) {
                //Logger.getLogger(InserirVenda.class.getName()).log(Level.SEVERE, null, ex);
            };
        }
        
    }//GEN-LAST:event_cbxNomeVendedoratualAncestorAdded

    private void cbxNovaComissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNovaComissaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxNovaComissaoActionPerformed

    private void cbxNovaComissaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxNovaComissaoKeyTyped
    char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        } 
    }//GEN-LAST:event_cbxNovaComissaoKeyTyped

    private void cbxNovoNomeVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNovoNomeVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxNovoNomeVendedorActionPerformed

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

    private void PopulateFields(Vendedor Vvendedor){
        cbxNomeVendedoratual.setText(Vvendedor.getNome_vendedor());
        
    }
    
    private void PopulateAuth(String usuario){
        jLabelNomeUsuario.setText(loginusuario);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditCliente;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cbxNomeVendedoratual;
    private javax.swing.JTextField cbxNovaComissao;
    private javax.swing.JTextField cbxNovoNomeVendedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelNomeUsuario;
    // End of variables declaration//GEN-END:variables

}
