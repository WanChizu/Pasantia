/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasantia_proyect;

import entidades.Proveedor;
import java.security.Principal;
import proveedores.Agregar;

/**
 *
 * @author A19B59953
 */
public class AgregarEditarVerProveedor extends javax.swing.JFrame {


    /**
     * Creates new form proveedor_dos
     */
    public AgregarEditarVerProveedor() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /*public AgregarEditarVerProveedor(int opcion) {
        this.opcion = opcion;
        switch (opcion) {
            case VER:
                createParaVer();
                break;
            case AGREGAR:
                createParaAgregar();
                break;
            case EDITAR:
                createParaEditar();
                break;

            default:
                
                break;
        }
        this.rellenarVentana();
        initComponents();
    }
*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_agregar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_nombre = new javax.swing.JLabel();
        lbl_telefono = new javax.swing.JLabel();
        lbl_activo = new javax.swing.JLabel();
        lbl_credito = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txt_telefono = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        combo_ac = new javax.swing.JComboBox<>();
        txt_credito = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        btn_regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_agregar.setBackground(new java.awt.Color(51, 102, 0));
        btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-añadir-40.png"))); // NOI18N
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, -1, -1));

        jPanel2.setBackground(new java.awt.Color(102, 153, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PROVEEDOR");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 32, -1, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 110, 10));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 74));

        lbl_nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_nombre.setText("Nombre");
        jPanel1.add(lbl_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        lbl_telefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_telefono.setText("Telefono");
        jPanel1.add(lbl_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        lbl_activo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_activo.setText("Esta ACTIVO");
        jPanel1.add(lbl_activo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, -1, -1));

        lbl_credito.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_credito.setText("Limite de credito");
        jPanel1.add(lbl_credito, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_nombre.setBorder(null);
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 230, 30));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 230, 10));

        txt_telefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_telefono.setBorder(null);
        jPanel1.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 230, 30));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 230, 10));

        combo_ac.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combo_ac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", " " }));
        jPanel1.add(combo_ac, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, -1, -1));

        txt_credito.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_credito.setBorder(null);
        jPanel1.add(txt_credito, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 230, 30));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 230, 10));

        btn_regresar.setBackground(new java.awt.Color(51, 102, 0));
        btn_regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-regreso-40.png"))); // NOI18N
        btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
        // TODO add your handling code here:
        main p = new main();
        p.setVisible(true);
        this.pack();
        this.dispose();
        
    }//GEN-LAST:event_btn_regresarActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        // TODO add your handling code here:
        Agregar agregarProveedor = new Agregar();

    }//GEN-LAST:event_btn_agregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JComboBox<String> combo_ac;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbl_activo;
    private javax.swing.JLabel lbl_credito;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_telefono;
    private javax.swing.JTextField txt_credito;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables

    private void rellenarVentana() {

    }

    /*public int getOpcion() {
        return opcion;
    }*/

}
