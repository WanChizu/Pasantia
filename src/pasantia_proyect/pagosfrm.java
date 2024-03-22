/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasantia_proyect;

import Controladores.DatabaseManager;
import static Controladores.Pagos.IndexPagos.IndexPagos;
import entidades.Pagos;
import errores.ErrorGeneral;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
public class pagosfrm extends javax.swing.JFrame {
    
    private static pagosfrm instanciaPrincipal; 
    int idPago = 0;
    String nombrePago = null;
    LocalDate fechaInicio = null;
    LocalDate fechaFin = null;
    int idFactura = 0;
    int idArea = 0;
    int idFormaPago = 0;
    String comentario2 = null;
    BigDecimal monto1 = null;
    BigDecimal monto2 = null; 
    Boolean estadoPago = null; 
    ArrayList<ErrorGeneral> errores = new ArrayList<>();
    
    

    /**
     * Creates new form pagosfrm
     */
    public pagosfrm() {
        initComponents();
        this.setLocationRelativeTo(null);
        instanciaPrincipal = this;
        this.setResizable(false);
        fecha_desde.setDateFormatString("dd/MM/yyyy");
        fecha_hasta.setDateFormatString("dd/MM/yyyy");
        
        try {
            rellenarComboBoxes();
        } catch (SQLException ex) {
        }
        
      
        combo_a.insertItemAt("", 0);
        combo_a.setSelectedIndex(0); 
        combo_f.insertItemAt("", 0);
        combo_f.setSelectedIndex(0); 
        combo_fp.insertItemAt("", 0);
        combo_fp.setSelectedIndex(0);
        combo_estado.insertItemAt("", 0);
        combo_estado.setSelectedIndex(0);

        actualizarTabla(); 
    }
    
    public static pagosfrm obtenerInstanciaPrincipal() {
        return instanciaPrincipal;
    }
    public void actualizarTabla() {
      mostrar();
    }
    
     private DefaultTableModel tableModel;
     
     public void mostrar() {
    List<Pagos> pagos = IndexPagos(idPago, nombrePago, idFactura, idArea, monto1, monto2, fechaInicio, fechaFin, idFormaPago, estadoPago, errores);

    if (tableModel == null) {
     
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Id");
        tableModel.addColumn("Fecha");
        tableModel.addColumn("Nombre del pago");
        tableModel.addColumn("Monto");
        tableModel.addColumn("Área");
        tableModel.addColumn("Factura");
        tableModel.addColumn("Forma de pago");
        tableModel.addColumn("Estado del pago");
        table.setModel(tableModel);
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
    } else {
      
        tableModel.setRowCount(0);
    }
    
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    for (Pagos pago : pagos) {
       
        String estado = pago.isEstadoPago() ? "Activo" : "Inactivo";
        String fechaFormateada = pago.getFecha().format(dateFormatter);
        
        Object[] rowData = {
            pago.getIdPagos(),
            fechaFormateada, 
            pago.getNombrePago(),
            pago.getMonto(),
            pago.getNombreArea(),
            pago.getNombrePago(),
            pago.getNombreFormaPago(),
            estado 
        };

       
        tableModel.addRow(rowData);
    }
}

     
     public int obtenerIdPagoSeleccionado() {
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
        lbl_titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        combo_f = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        combo_a = new javax.swing.JComboBox<>();
        btn_refrescar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        btnagregar = new javax.swing.JButton();
        btnagregar1 = new javax.swing.JButton();
        btnagregar2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        fecha_desde = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fecha_hasta = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        monto_hasta = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        combo_estado = new javax.swing.JComboBox<>();
        combo_fp = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        monto_desde = new javax.swing.JTextField();
        btn_volver = new javax.swing.JButton();
        btn_act = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(89, 111, 98));

        lbl_titulo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_titulo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_titulo.setText("PAGO");
        lbl_titulo.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                lbl_titulover(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lbl_titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(lbl_titulo)
                .addContainerGap())
        );

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

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Area");

        combo_f.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Factura");

        combo_a.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btn_refrescar.setBackground(new java.awt.Color(28, 49, 68));
        btn_refrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-refrescar-20.png"))); // NOI18N
        btn_refrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refrescarActionPerformed(evt);
            }
        });

        btn_limpiar.setBackground(new java.awt.Color(28, 49, 68));
        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8-limpiar-20.png"))); // NOI18N
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        btnagregar.setBackground(new java.awt.Color(28, 49, 68));
        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8-editar-30.png"))); // NOI18N
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        btnagregar1.setBackground(new java.awt.Color(28, 49, 68));
        btnagregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8-añadir-30.png"))); // NOI18N
        btnagregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregar1ActionPerformed(evt);
            }
        });

        btnagregar2.setBackground(new java.awt.Color(28, 49, 68));
        btnagregar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8-ver-30.png"))); // NOI18N
        btnagregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregar2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Fecha desde");

        fecha_desde.setDateFormatString("yyyy-MMM-dd");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Fecha hasta");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Monto hasta");

        fecha_hasta.setDateFormatString("yyyy-MMM-dd");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Monto desde");

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        monto_hasta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Forma de pago");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Estado de pago");

        combo_estado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        combo_fp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        combo_fp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_fpActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Nombre del pago");

        monto_desde.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btn_volver.setBackground(new java.awt.Color(28, 49, 68));
        btn_volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main/icons/icons8-volver-30 (1).png"))); // NOI18N
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });

        btn_act.setBackground(new java.awt.Color(28, 49, 68));
        btn_act.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main/icons/icons8-refrescar-30 (1).png"))); // NOI18N
        btn_act.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(28, 49, 68));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Forma de Pago");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(fecha_desde, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(fecha_hasta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt_nombre)
                                            .addComponent(combo_a, 0, 170, Short.MAX_VALUE))
                                        .addGap(40, 40, 40)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_refrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(combo_f, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(monto_desde, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_fp, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(monto_hasta)
                                .addComponent(combo_estado, 0, 165, Short.MAX_VALUE))
                            .addComponent(jLabel8)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_volver)
                        .addGap(18, 18, 18)
                        .addComponent(btn_act)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnagregar2)
                        .addGap(18, 18, 18)
                        .addComponent(btnagregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnagregar1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fecha_desde, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecha_hasta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(monto_hasta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(monto_desde, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combo_a, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_f, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_fp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_limpiar)
                                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_refrescar))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnagregar1)
                                    .addComponent(btnagregar2)
                                    .addComponent(btn_volver)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnagregar, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addComponent(btn_act))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_titulover(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_lbl_titulover

    }//GEN-LAST:event_lbl_titulover

    private void btn_refrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refrescarActionPerformed
        try {
            obtenerFiltros();
        } catch (SQLException ex) {
            Logger.getLogger(pagosfrm.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualizarTabla();
    }//GEN-LAST:event_btn_refrescarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
    limpiarFiltros();
    actualizarTabla();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
     int idPagoSeleccionado = obtenerIdPagoSeleccionado();
    if (idPagoSeleccionado != -1) {
        try {
          
            new AgregarEditarVerPagos(AgregarEditarVerPagos.EDITAR, idPagoSeleccionado).setVisible(true);
        } catch (SQLException e) {
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un Pago antes de editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }       
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btnagregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregar1ActionPerformed
     try {
        new AgregarEditarVerPagos(AgregarEditarVerPagos.AGREGAR, -1).setVisible(true);
    } catch (SQLException e) {
    }
    }//GEN-LAST:event_btnagregar1ActionPerformed

    private void btnagregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregar2ActionPerformed
    int idPagoSeleccionado = obtenerIdPagoSeleccionado();
    if (idPagoSeleccionado != -1) {
        try {
            new AgregarEditarVerPagos(AgregarEditarVerPagos.VER, idPagoSeleccionado).setVisible(true);
        } catch (SQLException e) {
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un Pago antes de ver sus datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_btnagregar2ActionPerformed

    private void combo_fpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_fpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_fpActionPerformed

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        mainfrm m = new mainfrm();
        m.setVisible(true);
        m.pack();
        this.dispose();
    }//GEN-LAST:event_btn_volverActionPerformed

    private void btn_actActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_btn_actActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      forma_pagofrm p = new forma_pagofrm();
        p.setVisible(true);
        p.pack();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(pagosfrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pagosfrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pagosfrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pagosfrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pagosfrm().setVisible(true);
            }
        });
    }
    
     private void rellenarComboBoxes() throws SQLException {
       
        Map<Integer, String> facturas = DatabaseManager.obtenerIdsYComentariosFactura();
        for (Map.Entry<Integer, String> entry : facturas.entrySet()) {
            combo_f.addItem(entry.getValue());
        }

       
        Map<Integer, String> fp = DatabaseManager.obtenerFormaPagos();
        for (Map.Entry<Integer, String> entry : fp.entrySet()) {
            combo_fp.addItem(entry.getValue());
        }

        
        Map<Integer, String> areas = DatabaseManager.obtenerAreas();
        for (Map.Entry<Integer, String> entry : areas.entrySet()) {
            combo_a.addItem(entry.getValue());
        }
        
       combo_estado.addItem("Activo");
       combo_estado.addItem("Inactivo");
    }
     
     private void obtenerFiltros() throws SQLException {
    fechaInicio = fecha_desde.getDate() != null ? fecha_desde.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
    fechaFin = fecha_hasta.getDate() != null ? fecha_hasta.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
    
    idFactura = obtenerIdSeleccionado(combo_f, DatabaseManager.obtenerCategorias());
    idFormaPago = obtenerIdSeleccionado(combo_fp, DatabaseManager.obtenerProveedores());
    idArea = obtenerIdSeleccionado(combo_a, DatabaseManager.obtenerAreas());

    String montoStr1 = monto_desde.getText().trim();
    String montoStr2 = monto_hasta.getText().trim();

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

    nombrePago = txt_nombre.getText();
    estadoPago = combo_estado.getSelectedIndex() == 0 ? true : false; 
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
     
     private void limpiarFiltros() {
    fecha_desde.setDate(null);
    fecha_hasta.setDate(null);
    combo_f.setSelectedIndex(0);
    combo_fp.setSelectedIndex(0);
    combo_a.setSelectedIndex(0);
    txt_nombre.setText("");
    monto_desde.setText("");
    monto_hasta.setText("");
    combo_estado.setSelectedIndex(0);
    fechaInicio = null;
    fechaFin = null;
    idFactura = 0;
    idFormaPago = 0;
    idArea = 0;
    nombrePago = null;
    monto1 = null;
    monto2 = null;
    estadoPago = null;
}

     
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_act;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_refrescar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnagregar1;
    private javax.swing.JButton btnagregar2;
    private javax.swing.JComboBox<String> combo_a;
    private javax.swing.JComboBox<String> combo_estado;
    private javax.swing.JComboBox<String> combo_f;
    private javax.swing.JComboBox<String> combo_fp;
    private com.toedter.calendar.JDateChooser fecha_desde;
    private com.toedter.calendar.JDateChooser fecha_hasta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JTextField monto_desde;
    private javax.swing.JTextField monto_hasta;
    private javax.swing.JTable table;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
