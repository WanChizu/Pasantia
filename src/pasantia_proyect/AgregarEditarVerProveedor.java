/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasantia_proyect;

import Controladores.Actualizar;
import static Controladores.Actualizar.actProveedor;
import Controladores.Agregar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static Controladores.Agregar.insertarProveedor;
import Controladores.Ver;
import static Controladores.Ver.verProveedor;
import com.sun.glass.events.KeyEvent;
import entidades.Proveedor;
import errores.ErrorGeneral;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import utill.FuncionesGenerales;

/**
 *
 * @author A19B59953
 */
public class AgregarEditarVerProveedor extends javax.swing.JFrame {

    public final static int VER = 1;
    public final static int EDITAR = 2;
    public final static int AGREGAR = 3;
    int opcion;
    private int proveedorId;
    
    
   
    /**
     * Creates new form proveedor_dos
     */
    public AgregarEditarVerProveedor() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public AgregarEditarVerProveedor(int opcion, int proveedorId, ArrayList<ErrorGeneral> errores) throws SQLException {
        this.opcion = opcion;
        this.proveedorId = proveedorId;
        initComponents();
    

        switch (opcion) {
            case VER:
                createParaVer();
                break;
            case EDITAR:
                createParaEditar();
                break;
            case AGREGAR:
                createParaAgregar();
            default:

                break;
                
    
        }
    this.rellenarVentana(proveedorId, errores);
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
        lbl_titulo = new javax.swing.JLabel();
        lbl_nombre = new javax.swing.JLabel();
        lbl_telefono = new javax.swing.JLabel();
        lbl_activo = new javax.swing.JLabel();
        lbl_credito = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        combo_ac = new javax.swing.JComboBox<>();
        jSeparator4 = new javax.swing.JSeparator();
        btnregresar = new javax.swing.JButton();
        tLimiteDeCredito = new javax.swing.JFormattedTextField();
        tTelefono = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnagregar.setBackground(new java.awt.Color(51, 102, 0));
        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconagregar.png"))); // NOI18N
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, -1, -1));

        jPanel2.setBackground(new java.awt.Color(102, 153, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 150, 10));

        lbl_titulo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_titulo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_titulo.setText("Agregar Proveedor");
        lbl_titulo.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                ver(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jPanel2.add(lbl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 74));

        lbl_nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_nombre.setText("Nombre");
        jPanel1.add(lbl_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        lbl_telefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_telefono.setText("Teléfono");
        jPanel1.add(lbl_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        lbl_activo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_activo.setText("Esta ACTIVO");
        jPanel1.add(lbl_activo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, -1, -1));

        lbl_credito.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_credito.setText("Límite de crédito");
        jPanel1.add(lbl_credito, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_nombre.setBorder(null);
        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 230, 30));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 230, 10));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 230, 10));

        combo_ac.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combo_ac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "si", "no", "" }));
        combo_ac.setBorder(null);
        jPanel1.add(combo_ac, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 40, -1));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 230, 10));

        btnregresar.setBackground(new java.awt.Color(51, 102, 0));
        btnregresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconregreso.png"))); // NOI18N
        btnregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, -1, -1));

        tLimiteDeCredito.setBorder(null);
        tLimiteDeCredito.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        tLimiteDeCredito.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tLimiteDeCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tLimiteDeCreditoActionPerformed(evt);
            }
        });
        jPanel1.add(tLimiteDeCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 240, 30));

        tTelefono.setBorder(null);
        try {
            tTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tTelefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tTelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(tTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 230, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
        // TODO add your handling code here:
        consulta p = new consulta();
        p.setVisible(true);
        this.pack();
        this.dispose();

    }//GEN-LAST:event_btnregresarActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed

       
        if (opcion == AGREGAR) {
            agregarProveedor();
        } else if (opcion == EDITAR) {
            editarProveedor();
        }


    }//GEN-LAST:event_btnagregarActionPerformed

    private void ver(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_ver
        // TODO add your handling code here:

    }//GEN-LAST:event_ver

    private void tTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tTelefonoActionPerformed

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped

    }//GEN-LAST:event_txt_nombreKeyTyped

    private void tLimiteDeCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tLimiteDeCreditoActionPerformed
        System.out.println(FuncionesGenerales.getValueOf(tLimiteDeCredito.getValue()));
    }//GEN-LAST:event_tLimiteDeCreditoActionPerformed

    public static void main(String[] args) throws SQLException {
        ArrayList<ErrorGeneral> errores = null;
        new AgregarEditarVerProveedor(AgregarEditarVerProveedor.VER,2,errores).setVisible(true);
       new AgregarEditarVerProveedor(AgregarEditarVerProveedor.EDITAR,2,errores).setVisible(true);
        new AgregarEditarVerProveedor(AgregarEditarVerProveedor.AGREGAR,2,errores).setVisible(true);
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
    private javax.swing.JLabel lbl_activo;
    private javax.swing.JLabel lbl_credito;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_telefono;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JFormattedTextField tLimiteDeCredito;
    private javax.swing.JFormattedTextField tTelefono;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables

    // Proveedor Proveedores = new Proveedor(0, "Proveedor 1", "8094631521", true, 2000.0);
    /*public int getOpcion() {
        return opcion;
    }*/
    private void createParaVer() {
        lbl_titulo.setText("Ver Proveedor");
        btnagregar.setVisible(true);
        btnagregar.setVisible(false);
        tTelefono.setEnabled(false);
        tLimiteDeCredito.setEnabled(false);
        txt_nombre.setEnabled(false);
        combo_ac.setEnabled(false);
                
        try {
            ArrayList<ErrorGeneral> errores = null;
            rellenarVentana(proveedorId, errores);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createParaAgregar() {
        lbl_titulo.setText("Agregar Proveedor");
    }

    private void createParaEditar() {
        lbl_titulo.setText("Editar Proveedor");
         btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconeditar.png")));
        try {
            ArrayList<ErrorGeneral> errores = null;
            rellenarVentana(proveedorId, errores);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void agregarProveedor() {
        Object value = tLimiteDeCredito.getValue();

        if (value != null) {
            Proveedor nuevoProveedor = new Proveedor(0, txt_nombre.getText(), tTelefono.getText(), combo_ac.getSelectedItem().equals("Si"), FuncionesGenerales.getValueOf(tLimiteDeCredito.getValue()));

            try {
                ArrayList<errores.ErrorGeneral> errores = new ArrayList<>();
                int idProveedorInsertado = Agregar.insertarProveedor(nuevoProveedor, errores);

                if (idProveedorInsertado != -1) {
                    JOptionPane.showMessageDialog(this, "Proveedor agregado exitosamente con ID " + idProveedorInsertado, "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Error al agregar proveedor", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al agregar proveedor: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un valor válido para el límite de crédito", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void rellenarVentana(int codigoProveedor, ArrayList<errores.ErrorGeneral> errores) throws SQLException  {
    Proveedor proveedor = verProveedor(proveedorId, errores);
    
    
    if (proveedor != null) {
       
        txt_nombre.setText(proveedor.getNombre());
        tTelefono.setText(proveedor.getTelefono());
        tLimiteDeCredito.setValue(proveedor.getLimiteCredito());
        
  
     
       
    } else {
       
        JOptionPane.showMessageDialog(this, "Error al cargar el proveedor", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    
    }

    private void editarProveedor() {
        Object value = tLimiteDeCredito.getValue();

    if (value != null) {
        Proveedor proveedorAActualizar = new Proveedor(proveedorId, txt_nombre.getText(), tTelefono.getText(), combo_ac.getSelectedItem().equals("Si"), FuncionesGenerales.getValueOf(tLimiteDeCredito.getValue()));

        try {
            ArrayList<errores.ErrorGeneral> errores = new ArrayList<>();
            Actualizar.actProveedor(proveedorAActualizar, errores);

            JOptionPane.showMessageDialog(this, "Proveedor actualizado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al actualizar proveedor: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un valor válido para el límite de crédito", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    }

    

    
  

