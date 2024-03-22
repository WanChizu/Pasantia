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
    
    private void obtenerFiltros() {
    nombreProveedor = txt_nombre_prov.getText().trim();
    nombreProveedor = txt_telefono.getText().trim();
}
     
     private void limpiarTabla() {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0); 
}
     private void limpiarFiltros() {
        txt_nombre_prov.setText("");
        nombreProveedor = null;
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
        btn_act = new javax.swing.JButton();
        btn_volver = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txt_nombre_prov = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        combo_ac = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txt_limite = new javax.swing.JTextField();
        btn_limpiar = new javax.swing.JButton();
        btn_refrescar = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txt_limite1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 550));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(850, 550));

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

        ver_btn.setBackground(new java.awt.Color(28, 49, 68));
        ver_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8-ver-30.png"))); // NOI18N
        ver_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ver_btnActionPerformed(evt);
            }
        });

        btn_editar.setBackground(new java.awt.Color(28, 49, 68));
        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8-editar-30.png"))); // NOI18N
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_añadir.setBackground(new java.awt.Color(28, 49, 68));
        btn_añadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8-añadir-30.png"))); // NOI18N
        btn_añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(89, 111, 98));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PROVEEDOR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btn_act.setBackground(new java.awt.Color(28, 49, 68));
        btn_act.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main/icons/icons8-refrescar-30 (1).png"))); // NOI18N
        btn_act.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actActionPerformed(evt);
            }
        });

        btn_volver.setBackground(new java.awt.Color(28, 49, 68));
        btn_volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main/icons/icons8-volver-30 (1).png"))); // NOI18N
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Nombre del Proveedor");

        txt_nombre_prov.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_nombre_prov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombre_provActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Teléfono del Proveedor");

        txt_telefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        try {
            txt_telefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_telefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefonoActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Estado");

        combo_ac.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        combo_ac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        combo_ac.setBorder(null);
        combo_ac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_acActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Límite de crédito desde");

        txt_limite.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btn_limpiar.setBackground(new java.awt.Color(28, 49, 68));
        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8-limpiar-20.png"))); // NOI18N
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        btn_refrescar.setBackground(new java.awt.Color(28, 49, 68));
        btn_refrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-refrescar-20.png"))); // NOI18N
        btn_refrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refrescarActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Límite de crédito hasta");

        txt_limite1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_volver)
                        .addGap(18, 18, 18)
                        .addComponent(btn_act)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ver_btn)
                        .addGap(18, 18, 18)
                        .addComponent(btn_editar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_añadir))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(654, 654, 654))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(combo_ac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(532, 532, 532)))
                        .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_refrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nombre_prov, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_telefono, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_limite, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_limite1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel17)
                    .addComponent(jLabel15)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nombre_prov, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_limite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_limite1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_limpiar)
                    .addComponent(btn_refrescar)
                    .addComponent(combo_ac, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ver_btn)
                        .addComponent(btn_editar, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_añadir, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_volver, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(btn_act, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(25, 25, 25))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ver_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ver_btnActionPerformed
   
    int idProveedorSeleccionado = obtenerIdProveedorSeleccionado();
    if (idProveedorSeleccionado != -1) {
        try {
            new AgregarEditarVerProveedor(AgregarEditarVerProveedor.VER, idProveedorSeleccionado).setVisible(true);
        } catch (SQLException e) {
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

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        mainfrm m = new mainfrm();
        m.setVisible(true);
        m.pack();
        this.dispose();        
    }//GEN-LAST:event_btn_volverActionPerformed

    private void txt_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefonoActionPerformed

    }//GEN-LAST:event_txt_telefonoActionPerformed

    private void txt_nombre_provActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombre_provActionPerformed

    }//GEN-LAST:event_txt_nombre_provActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
      limpiarTabla();
        limpiarFiltros();
        mostrar();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_refrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refrescarActionPerformed
     obtenerFiltros();
        mostrar();    
    }//GEN-LAST:event_btn_refrescarActionPerformed

    private void combo_acActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_acActionPerformed
        String estadoSeleccionado = (String) combo_ac.getSelectedItem();
      
        Boolean estado = null;
        if (estadoSeleccionado.equals("Activo")) {
            estado = true;
        } else if (estadoSeleccionado.equals("Inactivo")) {
            estado = false;
        }
        
        estaActivo = estado;
        mostrar();
    }//GEN-LAST:event_combo_acActionPerformed

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
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_refrescar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JComboBox<String> combo_ac;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable table;
    private javax.swing.JTextField txt_limite;
    private javax.swing.JTextField txt_limite1;
    private javax.swing.JTextField txt_nombre_prov;
    private javax.swing.JFormattedTextField txt_telefono;
    private javax.swing.JButton ver_btn;
    // End of variables declaration//GEN-END:variables
}
