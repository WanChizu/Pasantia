/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasantia_proyect;

import Controladores.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author A19B59953
 */
public class principal extends javax.swing.JFrame {
    
    private static principal instanciaPrincipal;

    /**
     * Creates new form principal
     */
    public principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrar("proveedor");
        instanciaPrincipal = this;
    }
    
      public static principal obtenerInstanciaPrincipal() {
        return instanciaPrincipal;
    }
      
     public void actualizarTabla() {
        mostrar("proveedor");
    }
    
    public void mostrar(String tabla){
    String sql = "select * from " + tabla;
    Statement st;
    conexion con = new conexion();
    Connection conexion = con.conectar();
   // System.out.println(sql);
    DefaultTableModel table = new DefaultTableModel();
    table.addColumn("Id");
    table.addColumn("Nombre");
    table.addColumn("Teléfono");
    table.addColumn("Activo");
    table.addColumn("Límite de crédito");
    Jtable.setModel(table);
    Jtable.getColumnModel().getColumn(0).setMinWidth(0);
    Jtable.getColumnModel().getColumn(0).setMaxWidth(0);
    
    String [] datos = new String[5];
    
    try{
    st = conexion.createStatement();
    ResultSet rs = st.executeQuery(sql);
    while(rs.next())
    {
    datos[0]=rs.getString(1);
    datos[1]=rs.getString(2);
    datos[2]=rs.getString(3);
    datos[3] = rs.getInt(4) == 1 ? "si" : "no";
    datos[4]=rs.getString(5);
    table.addRow(datos);
    }
    
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,"Error" + e.toString());
    }
    }
    
    public int obtenerIdProveedorSeleccionado() {
    int filaSeleccionada = Jtable.getSelectedRow();
    if (filaSeleccionada != -1) {
        return Integer.parseInt(Jtable.getValueAt(filaSeleccionada, 0).toString()); 
    } else {
        return -1; 
    }
}


   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Jtable = new javax.swing.JTable();
        ver_btn = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_añadir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_act = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Jtable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 540, 470));

        ver_btn.setBackground(new java.awt.Color(51, 102, 0));
        ver_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-ver-40.png"))); // NOI18N
        ver_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ver_btnActionPerformed(evt);
            }
        });
        jPanel1.add(ver_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 580, -1, -1));

        btn_editar.setBackground(new java.awt.Color(51, 102, 0));
        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconeditar.png"))); // NOI18N
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 580, -1, -1));

        btn_añadir.setBackground(new java.awt.Color(51, 102, 0));
        btn_añadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconagregar.png"))); // NOI18N
        btn_añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirActionPerformed(evt);
            }
        });
        jPanel1.add(btn_añadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 580, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("CENTRO CARDIORENAL DEL CIBAO (CERCANCI)");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo_login.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap())))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 70));

        btn_act.setBackground(new java.awt.Color(51, 102, 0));
        btn_act.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-actualizar-40 (1).png"))); // NOI18N
        btn_act.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actActionPerformed(evt);
            }
        });
        jPanel1.add(btn_act, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 650));

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
     mostrar("proveedor");
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
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable Jtable;
    private javax.swing.JButton btn_act;
    private javax.swing.JButton btn_añadir;
    private javax.swing.JButton btn_editar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton ver_btn;
    // End of variables declaration//GEN-END:variables
}
