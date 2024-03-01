/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasantia_proyect;

import static Controladores.Proveedor.ProveedoresIndex.IndexProveedor;
import entidades.Proveedor;
import errores.ErrorGeneral;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author A19B59953
 */
public class proveedorfrm extends javax.swing.JFrame {
    
    private static proveedorfrm instanciaPrincipal;
    
    Integer codigoProveedor = 0; 
    String nombreProveedor = null; 
    String telefono = null; 
    Boolean estaActivo = null; 
    BigDecimal limiteDeCredito = null; 
    ArrayList<ErrorGeneral> errores = new ArrayList<>();
  


    /**
     * Creates new form principal
     */
    public proveedorfrm() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrar();
        instanciaPrincipal = this;
        this.setResizable(false);
    }
    
    
      public static proveedorfrm obtenerInstanciaPrincipal() {
        return instanciaPrincipal;
    }
      
     public void actualizarTabla() {
        mostrar();
    }
     

     private DefaultTableModel tableModel;
     
  public void mostrar() {
    List<Proveedor> proveedores = IndexProveedor(codigoProveedor, nombreProveedor, telefono, estaActivo, limiteDeCredito, errores);

    if (tableModel == null) {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Teléfono");
        tableModel.addColumn("Activo");
        tableModel.addColumn("Límite de crédito");
        table.setModel(tableModel);
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
    } else {
        tableModel.setRowCount(0);
    }

    for (Proveedor proveedor : proveedores) {
        Object[] rowData = {
            proveedor.getProveedorId(),
            proveedor.getNombre(),
            proveedor.getTelefono(),
            proveedor.isEstaActivo()? "Sí" : "No",
            proveedor.getLimiteCredito()
        };
        tableModel.addRow(rowData);
    }
}


    
    public int obtenerIdProveedorSeleccionado() {
    int filaSeleccionada = table.getSelectedRow();
    if (filaSeleccionada != -1) {
        return Integer.parseInt(table.getValueAt(filaSeleccionada, 0).toString()); 
    } else {
        return -1; 
    }
}


   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        ver_btn = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_añadir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_act = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table);

        ver_btn.setBackground(new java.awt.Color(51, 102, 0));
        ver_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8-ver-30.png"))); // NOI18N
        ver_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ver_btnActionPerformed(evt);
            }
        });

        btn_editar.setBackground(new java.awt.Color(51, 102, 0));
        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8-editar-30.png"))); // NOI18N
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_añadir.setBackground(new java.awt.Color(51, 102, 0));
        btn_añadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8-añadir-30.png"))); // NOI18N
        btn_añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(51, 102, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PROVEEDOR");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8-empleado-30.png"))); // NOI18N
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)))
                .addGap(32, 32, 32))
        );

        btn_act.setBackground(new java.awt.Color(51, 102, 0));
        btn_act.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-refrescar-20.png"))); // NOI18N
        btn_act.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_act)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ver_btn)
                        .addGap(40, 40, 40)
                        .addComponent(btn_editar)
                        .addGap(40, 40, 40)
                        .addComponent(btn_añadir)))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ver_btn)
                    .addComponent(btn_editar)
                    .addComponent(btn_añadir)
                    .addComponent(btn_act, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ver_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ver_btnActionPerformed
   
    int idProveedorSeleccionado = obtenerIdProveedorSeleccionado();
    if (idProveedorSeleccionado != -1) {
        try {
            new AgregarEditarVerProveedor(AgregarEditarVerProveedor.VER, idProveedorSeleccionado).setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un proveedor antes de ver sus datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }


    }//GEN-LAST:event_ver_btnActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
    
     int idProveedorSeleccionado = obtenerIdProveedorSeleccionado();
    if (idProveedorSeleccionado != -1) {
        try {
          
            new AgregarEditarVerProveedor(AgregarEditarVerProveedor.EDITAR, idProveedorSeleccionado).setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un proveedor antes de editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirActionPerformed
     
      try {
       
        new AgregarEditarVerProveedor(AgregarEditarVerProveedor.AGREGAR, -1).setVisible(true);
    } catch (SQLException e) {
        e.printStackTrace();
    }
      
    }//GEN-LAST:event_btn_añadirActionPerformed

    private void btn_actActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actActionPerformed
 actualizarTabla();     
    }//GEN-LAST:event_btn_actActionPerformed

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
            java.util.logging.Logger.getLogger(proveedorfrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(proveedorfrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(proveedorfrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(proveedorfrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new proveedorfrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_act;
    private javax.swing.JButton btn_añadir;
    private javax.swing.JButton btn_editar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable table;
    private javax.swing.JButton ver_btn;
    // End of variables declaration//GEN-END:variables
}
