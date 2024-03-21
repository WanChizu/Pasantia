/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasantia_proyect;

import Controladores.DatabaseManager;
import static Controladores.Factura.IndexFactura.IndexFactura;
import entidades.Factura;
import errores.ErrorGeneral;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author A19B59953
 */
public class facturafrm extends javax.swing.JFrame {
    
  
    
     private static facturafrm instanciaPrincipal; 
    
         int idFactura = 0;
         LocalDate fechaInicio = null;
         LocalDate fechaFin = null;
         int categoriaId = 0;
         int proveedorId = 0;
         String comentario1 = null;
         String comentario2 = null;
         BigDecimal monto1 = null;
         BigDecimal monto2 = null; 
         int areaId = 0;
        ArrayList<ErrorGeneral> errores = new ArrayList<>();

    /**
     * Creates new form fac
     */
    public facturafrm() {
        initComponents();
        this.setLocationRelativeTo(null);
        instanciaPrincipal = this;
        this.setResizable(false);
        

        
        try {
            rellenarComboBoxes();
        } catch (SQLException ex) {
        }
        
        combo_p.insertItemAt("", 0);
        combo_p.setSelectedIndex(0); 
        combo_c.insertItemAt("", 0);
        combo_c.setSelectedIndex(0); 
        combo_a.insertItemAt("", 0);
        combo_a.setSelectedIndex(0); 

        
       

actualizarTabla(); 
    }
    
      
    
     public static facturafrm obtenerInstanciaPrincipal() {
        return instanciaPrincipal;
    }
      
     public void actualizarTabla() {
      mostrar();
    }
     
     private DefaultTableModel tableModel;

    public void mostrar() {
         List<Factura> facturas = IndexFactura(idFactura, fechaInicio, fechaFin, categoriaId, proveedorId, comentario1, comentario2, monto1, monto2, areaId, errores);

        if (tableModel == null) {
            tableModel = new DefaultTableModel();
            tableModel.addColumn("Id");
            tableModel.addColumn("Fecha");
            tableModel.addColumn("Categoría");
            tableModel.addColumn("Proveedor");
            tableModel.addColumn("Área");
            tableModel.addColumn("Monto");
            tableModel.addColumn("Comentario");
            table.setModel(tableModel);
            table.getColumnModel().getColumn(0).setMinWidth(0);
            table.getColumnModel().getColumn(0).setMaxWidth(0);
        } else {
            tableModel.setRowCount(0);
        }

        for (Factura factura : facturas) {
            Object[] rowData = {
                factura.getIdFactura(),
                factura.getFecha(),
                factura.getNombreCategoria(),
                factura.getNombreProveedor(),
                factura.getNombreArea(),
                factura.getMonto(),
                factura.getComentario()
            };
            tableModel.addRow(rowData);
        }
    }
     
    
    public int obtenerIdFacturaSeleccionada() {
    int filaSeleccionada = table.getSelectedRow();
    if (filaSeleccionada != -1) {
        return Integer.parseInt(table.getValueAt(filaSeleccionada, 0).toString()); 
    } else {
        return -1; 
    }
}



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        fecha1 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        combo_c = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        combo_p = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        combo_a = new javax.swing.JComboBox<>();
        txt_monto1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btn_refrescar = new javax.swing.JButton();
        ver_btn = new javax.swing.JButton();
        btn_añadir = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_monto2 = new javax.swing.JTextField();
        txt_comentario = new javax.swing.JTextField();
        btn_act = new javax.swing.JButton();
        btn_volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 555));

        jPanel2.setBackground(new java.awt.Color(89, 111, 98));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("FACTURA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Fecha desde");

        fecha.setDateFormatString("yyyy-MMM-dd");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Fecha hasta");

        fecha1.setDateFormatString("yyyy-MMM-dd");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Categoría");

        combo_c.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        combo_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_cActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Poveedor");

        combo_p.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Area");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Comentario");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Monto desde");

        combo_a.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txt_monto1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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

        btn_refrescar.setBackground(new java.awt.Color(28, 49, 68));
        btn_refrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-refrescar-20.png"))); // NOI18N
        btn_refrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refrescarActionPerformed(evt);
            }
        });

        ver_btn.setBackground(new java.awt.Color(28, 49, 68));
        ver_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8-ver-30.png"))); // NOI18N
        ver_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ver_btnActionPerformed(evt);
            }
        });

        btn_añadir.setBackground(new java.awt.Color(28, 49, 68));
        btn_añadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8-añadir-30.png"))); // NOI18N
        btn_añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirActionPerformed(evt);
            }
        });

        btn_editar.setBackground(new java.awt.Color(28, 49, 68));
        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8-editar-30.png"))); // NOI18N
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_limpiar.setBackground(new java.awt.Color(28, 49, 68));
        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8-limpiar-20.png"))); // NOI18N
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Monto hasta");

        txt_monto2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_comentario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btn_act.setBackground(new java.awt.Color(28, 49, 68));
        btn_act.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-refrescar-20.png"))); // NOI18N
        btn_act.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actActionPerformed(evt);
            }
        });

        btn_volver.setBackground(new java.awt.Color(28, 49, 68));
        btn_volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-volver-20.png"))); // NOI18N
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(combo_c, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 210, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_refrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(combo_p, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_monto1)
                                            .addComponent(jLabel4)
                                            .addComponent(combo_a, 0, 170, Short.MAX_VALUE)
                                            .addComponent(jLabel9))
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_monto2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5)
                                            .addComponent(txt_comentario, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_volver)
                                .addGap(18, 18, 18)
                                .addComponent(btn_act)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ver_btn)
                                .addGap(40, 40, 40)
                                .addComponent(btn_añadir)
                                .addGap(40, 40, 40)
                                .addComponent(btn_editar)))
                        .addGap(25, 25, 25))))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_monto2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_monto1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_p, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_c, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_a, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_comentario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_refrescar)
                    .addComponent(btn_limpiar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_añadir)
                        .addComponent(btn_editar)
                        .addComponent(ver_btn))
                    .addComponent(btn_volver, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_act, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_refrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refrescarActionPerformed
         try {
             obtenerFiltros();
             actualizarTabla();
         } catch (SQLException ex) {
             Logger.getLogger(facturafrm.class.getName()).log(Level.SEVERE, null, ex);
         }
         
    }//GEN-LAST:event_btn_refrescarActionPerformed

    private void ver_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ver_btnActionPerformed

    int idFacturaSeleccionada = obtenerIdFacturaSeleccionada();
    if (idFacturaSeleccionada != -1) {
        try {
            new AgregarEditarVerFactura(AgregarEditarVerFactura.VER, idFacturaSeleccionada).setVisible(true);
        } catch (SQLException e) {
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione una factura antes de ver sus datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_ver_btnActionPerformed

    private void btn_añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirActionPerformed
       try {
        new AgregarEditarVerFactura(AgregarEditarVerFactura.AGREGAR, -1).setVisible(true);
    } catch (SQLException e) {
    }
    }//GEN-LAST:event_btn_añadirActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
    int idFacturaSeleccionada = obtenerIdFacturaSeleccionada();
    if (idFacturaSeleccionada != -1) {
        try {
          
            new AgregarEditarVerFactura(AgregarEditarVerFactura.EDITAR, idFacturaSeleccionada).setVisible(true);
        } catch (SQLException e) {
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione una factura antes de editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_btn_editarActionPerformed

    private void combo_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_cActionPerformed
   
    }//GEN-LAST:event_combo_cActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
    
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_actActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_btn_actActionPerformed

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        mainfrm m = new mainfrm();
        m.setVisible(true);
        m.pack();
        this.dispose();
    }//GEN-LAST:event_btn_volverActionPerformed

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
            java.util.logging.Logger.getLogger(facturafrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(facturafrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(facturafrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(facturafrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new facturafrm().setVisible(true);
            }
        });
    }
     private void rellenarComboBoxes() throws SQLException {
       
        Map<Integer, String> proveedores = DatabaseManager.obtenerProveedores();
        for (Map.Entry<Integer, String> entry : proveedores.entrySet()) {
            combo_p.addItem(entry.getValue());
        }

       
        Map<Integer, String> categorias = DatabaseManager.obtenerCategorias();
        for (Map.Entry<Integer, String> entry : categorias.entrySet()) {
            combo_c.addItem(entry.getValue());
        }

        
        Map<Integer, String> areas = DatabaseManager.obtenerAreas();
        for (Map.Entry<Integer, String> entry : areas.entrySet()) {
            combo_a.addItem(entry.getValue());
        }
    }
     
    private void obtenerFiltros() throws SQLException {
        
        fechaInicio = fecha.getDate() != null ? fecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
        fechaFin = fecha1.getDate() != null ? fecha1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
        System.out.println(fechaInicio);
        System.out.println(fechaFin);
        categoriaId = obtenerIdSeleccionado(combo_c, DatabaseManager.obtenerCategorias());
        proveedorId = obtenerIdSeleccionado(combo_p, DatabaseManager.obtenerProveedores());
        areaId = obtenerIdSeleccionado(combo_a, DatabaseManager.obtenerAreas());
    
        String montoStr1 = txt_monto1.getText().trim();
        String montoStr2 = txt_monto2.getText().trim(); 

       
        if (!montoStr1.isEmpty()) {
            try {
                monto1 = new BigDecimal(montoStr1);
            } catch (NumberFormatException e) {
           
                monto1 = null; 
            }
        } else {
            monto1 = null;
        }

      
        if (!montoStr2.isEmpty()) {
            try {
                monto2 = new BigDecimal(montoStr2);
            } catch (NumberFormatException e) {
              
                monto2 = null;
            }
        } else {
            monto2 = null;
        }

        comentario1 = txt_comentario.getText();

    }
    
    public static List<LocalDate> filtrarPorRango(List<LocalDate> fechas, LocalDate fechaInicio, LocalDate fechaFin) {
        List<LocalDate> fechasFiltradas = new ArrayList<>();

        for (LocalDate fecha : fechas) {
            if (!fecha.isBefore(fechaInicio) && !fecha.isAfter(fechaFin)) {
                fechasFiltradas.add(fecha);
            }
        }

        return fechasFiltradas;
    }



     
     private int obtenerIdSeleccionado(javax.swing.JComboBox<String> comboBox, Map<Integer, String> mapa) {
    String nombreSeleccionado = (String) comboBox.getSelectedItem();
    for (Map.Entry<Integer, String> entry : mapa.entrySet()) {
        if (entry.getValue().equals(nombreSeleccionado)) {
            return entry.getKey();
        }
    }
    return 0;
}
     
     
     
    

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_act;
    private javax.swing.JButton btn_añadir;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_refrescar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JComboBox<String> combo_a;
    private javax.swing.JComboBox<String> combo_c;
    private javax.swing.JComboBox<String> combo_p;
    private com.toedter.calendar.JDateChooser fecha;
    private com.toedter.calendar.JDateChooser fecha1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txt_comentario;
    private javax.swing.JTextField txt_monto1;
    private javax.swing.JTextField txt_monto2;
    private javax.swing.JButton ver_btn;
    // End of variables declaration//GEN-END:variables
}