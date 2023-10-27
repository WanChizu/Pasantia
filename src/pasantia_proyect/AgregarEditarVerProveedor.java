/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasantia_proyect;

import Controladores.Agregar;
import entidades.Proveedor;
import java.security.Principal;


/**
 *
 * @author A19B59953
 */
public class AgregarEditarVerProveedor extends javax.swing.JFrame {


    private final static int VER = 1 ;
    private final static int EDITAR = 2 ;
    private final static int AGREGAR = 3;
    private  int opcion;
   
   
   
    
    /**
     * Creates new form proveedor_dos
     */
    public AgregarEditarVerProveedor() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    
    
    public AgregarEditarVerProveedor(int opcion, String labelText) {
        this.opcion = opcion;
         initComponents();
        label.setText(labelText);
        
        switch (opcion) {
            case VER:
                createParaVer();
                btnagregar.setVisible(false); 
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
        btnagregar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        label = new javax.swing.JLabel();
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
        btnregresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnagregar.setBackground(new java.awt.Color(51, 102, 0));
        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-añadir-40.png"))); // NOI18N
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, -1, -1));

        jPanel2.setBackground(new java.awt.Color(102, 153, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 150, 10));

        label.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        label.setForeground(new java.awt.Color(255, 255, 255));
        label.setText("Agregar Proveedor");
        label.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                ver(evt);
            }
        });
        jPanel2.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

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

        btnregresar.setBackground(new java.awt.Color(51, 102, 0));
        btnregresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-regreso-40.png"))); // NOI18N
        btnregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
        // TODO add your handling code here:
        main p = new main();
        p.setVisible(true);
        this.pack();
        this.dispose();
        
    }//GEN-LAST:event_btnregresarActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        // TODO add your handling code here:
        Agregar agregarProveedor = new Agregar();

    }//GEN-LAST:event_btnagregarActionPerformed

    private void ver(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_ver
        // TODO add your handling code here:
      
    }//GEN-LAST:event_ver


    
    public static void main(String[] args) {
        new  AgregarEditarVerProveedor(AgregarEditarVerProveedor.VER, "Ver Proveedor").setVisible(true);
        new  AgregarEditarVerProveedor(AgregarEditarVerProveedor.AGREGAR, "Agregar Proveedor").setVisible(true);
        new  AgregarEditarVerProveedor(AgregarEditarVerProveedor.EDITAR, "Editar proveedor").setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnregresar;
    private javax.swing.JComboBox<String> combo_ac;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel label;
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

    private void createParaVer() {
        System.out.println("Ver");
    }

    private void createParaAgregar() {
        System.out.println("agregar");}

    private void createParaEditar() {
        System.out.println("editar");
    
    }

   
}
