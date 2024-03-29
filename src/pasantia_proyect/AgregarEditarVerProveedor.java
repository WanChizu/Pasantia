/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasantia_proyect;


import Controladores.Proveedor.ActualizarProveedor;
import Controladores.Proveedor.AgregarProveedor;
import Controladores.Proveedor.VerProveedor;
import entidades.Proveedor;
import errores.ErrorGeneral;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
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
       
    }

   public AgregarEditarVerProveedor(int opcion, int proveedorId) throws SQLException {
        this.opcion = opcion;
        this.proveedorId = proveedorId;
        initComponents();
         setLocationRelativeTo(null);
        this.setResizable(false);

        ArrayList<ErrorGeneral> errores = new ArrayList<>();

        switch (opcion) {
            case VER:
                createParaVer();
                break;
            case EDITAR:
                createParaEditar();
                break;
            case AGREGAR:
                createParaAgregar();
                break;
            default:
                break;
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
        lbl_nombre = new javax.swing.JLabel();
        lbl_telefono = new javax.swing.JLabel();
        lbl_activo = new javax.swing.JLabel();
        lbl_credito = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        combo_ac = new javax.swing.JComboBox<>();
        btnregresar = new javax.swing.JButton();
        tLimiteDeCredito = new javax.swing.JFormattedTextField();
        tTelefono = new javax.swing.JFormattedTextField();
        btnagregar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbl_titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));

        lbl_nombre.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_nombre.setText("Nombre");

        lbl_telefono.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_telefono.setText("Teléfono");

        lbl_activo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_activo.setText("Estado activo");

        lbl_credito.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_credito.setText("Límite de crédito");

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });

        combo_ac.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        combo_ac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "si", "no" }));
        combo_ac.setBorder(null);

        btnregresar.setBackground(new java.awt.Color(28, 49, 68));
        btnregresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8-volver-30.png"))); // NOI18N
        btnregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresarActionPerformed(evt);
            }
        });

        tLimiteDeCredito.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        tLimiteDeCredito.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        tLimiteDeCredito.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tLimiteDeCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tLimiteDeCreditoActionPerformed(evt);
            }
        });

        tTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
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

        btnagregar.setBackground(new java.awt.Color(28, 49, 68));
        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8-añadir-30.png"))); // NOI18N
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(89, 111, 98));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_titulo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_titulo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_titulo.setText("AGREGAR PROVEEDOR");
        lbl_titulo.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                lbl_titulover(evt);
            }
        });
        jPanel2.add(lbl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 24, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(combo_ac, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(255, 255, 255)
                        .addComponent(btnregresar)
                        .addGap(17, 17, 17)
                        .addComponent(btnagregar))
                    .addComponent(tLimiteDeCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nombre)
                    .addComponent(lbl_telefono)
                    .addComponent(lbl_activo)
                    .addComponent(lbl_credito)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lbl_nombre)
                .addGap(10, 10, 10)
                .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(lbl_telefono)
                .addGap(10, 10, 10)
                .addComponent(tTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(lbl_credito)
                .addGap(11, 11, 11)
                .addComponent(tLimiteDeCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(lbl_activo)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnregresar)
                            .addComponent(btnagregar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(combo_ac, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed

    this.setVisible(false);
    proveedorfrm p = proveedorfrm.obtenerInstanciaPrincipal();
    p.setVisible(true);
    p.actualizarTabla();
    
    }//GEN-LAST:event_btnregresarActionPerformed

    private void tTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tTelefonoActionPerformed
      
    }//GEN-LAST:event_tTelefonoActionPerformed

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped

    }//GEN-LAST:event_txt_nombreKeyTyped

    private void tLimiteDeCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tLimiteDeCreditoActionPerformed
    }//GEN-LAST:event_tLimiteDeCreditoActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        // TODO add your handling code here:
         if (opcion == AGREGAR) {
            agregarProveedor();
        } else if (opcion == EDITAR) {
            editarProveedor();
        }
    }//GEN-LAST:event_btnagregarActionPerformed

    private void lbl_titulover(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_lbl_titulover

    }//GEN-LAST:event_lbl_titulover

 public static void main(String[] args) {
    try {
        ArrayList<ErrorGeneral> errores = new ArrayList<>();
        new AgregarEditarVerProveedor(AgregarEditarVerProveedor.VER, 1).setVisible(true);
        new AgregarEditarVerProveedor(AgregarEditarVerProveedor.EDITAR, 1).setVisible(true);
        new AgregarEditarVerProveedor(AgregarEditarVerProveedor.AGREGAR, 2).setVisible(true);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnregresar;
    private javax.swing.JComboBox<String> combo_ac;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_activo;
    private javax.swing.JLabel lbl_credito;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_telefono;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JFormattedTextField tLimiteDeCredito;
    private javax.swing.JFormattedTextField tTelefono;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables

   
    
    private void createParaVer() {
        lbl_titulo.setText("VER PROVEEDOR");
        tTelefono.setEditable(false);
        tLimiteDeCredito.setEditable(false);
        txt_nombre.setEditable(false);
        combo_ac.setEnabled(false);
        btnagregar.setEnabled(false);
        
        
        Font fuente = txt_nombre.getFont();
        float tamanoFuente = fuente.getSize() + 2; 
        txt_nombre.setFont(fuente.deriveFont(tamanoFuente));
        tTelefono.setFont(fuente.deriveFont(tamanoFuente));
        tLimiteDeCredito.setFont(fuente.deriveFont(tamanoFuente));
        combo_ac.setFont(fuente.deriveFont(tamanoFuente));
                
        ArrayList<ErrorGeneral> errores = new ArrayList<>();
        rellenarVentana(proveedorId, errores);
    }

    private void createParaAgregar() {
        lbl_titulo.setText("AGREGAR PROVEEDOR");
    }

    private void createParaEditar() {
        lbl_titulo.setText("EDITAR PROVEEDOR");
        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img//icons//icons8-editar-30.png")));
        ArrayList<ErrorGeneral> errores = new ArrayList<>();
        rellenarVentana(proveedorId, errores);
    }

    public void agregarProveedor() {
        Object value = tLimiteDeCredito.getValue();

        if (value != null) {
            Proveedor nuevoProveedor = new Proveedor(0, txt_nombre.getText(), tTelefono.getText(), combo_ac.getSelectedItem().equals("si"), FuncionesGenerales.getValueOf(tLimiteDeCredito.getValue()));
           
            proveedorfrm pantalla = proveedorfrm.obtenerInstanciaPrincipal();
       

            ArrayList<errores.ErrorGeneral> errores = new ArrayList<>();
            int idProveedorInsertado = AgregarProveedor.insertarProveedor(nuevoProveedor, errores);
            if (idProveedorInsertado != -1) {
                JOptionPane.showMessageDialog(this, "Proveedor agregado exitosamente con ID " + idProveedorInsertado, "Éxito", JOptionPane.INFORMATION_MESSAGE);
                
            pantalla.actualizarTabla();
            pantalla.setVisible(true);
            this.dispose();
                
            } else {
                mostrarErrores(errores);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un valor válido para el límite de crédito", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizarComboBoxActivo(boolean estaActivo) {
    DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) combo_ac.getModel();
    
    if (estaActivo) {
        combo_ac.setSelectedItem("si");
    } else {
        combo_ac.setSelectedItem("no");
        
     
    combo_ac.revalidate();
    combo_ac.repaint();
    }
}

    
 private void rellenarVentana(int codigoProveedor, ArrayList<ErrorGeneral> errores) {
     Proveedor proveedor = VerProveedor.verProveedor(proveedorId, errores);
     if (proveedor != null) {
         txt_nombre.setText(proveedor.getNombre());
         tTelefono.setText(proveedor.getTelefono());
         tLimiteDeCredito.setValue(proveedor.getLimiteCredito());
         combo_ac.setSelectedItem(proveedor.isEstaActivo() ? "Si" : "No");
         actualizarComboBoxActivo(proveedor.isEstaActivo());
     } else {
         
     }
}

    private proveedorfrm pantalla;

    private void editarProveedor() {
        Object value = tLimiteDeCredito.getValue();

    if (value != null) {
        String seleccion = (String) combo_ac.getSelectedItem();
        boolean estaActivo = combo_ac.getSelectedItem().equals("si");
        Proveedor proveedorAActualizar = new Proveedor(proveedorId, txt_nombre.getText(), tTelefono.getText(), estaActivo, FuncionesGenerales.getValueOf(tLimiteDeCredito.getValue()));
       
        proveedorfrm pantalla = proveedorfrm.obtenerInstanciaPrincipal();
       
        
        ArrayList<errores.ErrorGeneral> errores = new ArrayList<>();
        ActualizarProveedor.actualizarProveedor(proveedorAActualizar, errores);

        if (errores.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Proveedor actualizado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
            pantalla.actualizarTabla();
            pantalla.setVisible(true);
            this.dispose();
            
        } else {
            mostrarErrores(errores); 
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un valor válido para el límite de crédito", "Error", JOptionPane.ERROR_MESSAGE);
    }
    rellenarVentana(proveedorId, new ArrayList<>());
}
    
 private static void mostrarErrores(ArrayList<ErrorGeneral> errores) {
        if (!errores.isEmpty()) {
            StringBuilder mensaje = new StringBuilder("Se han producido los siguientes errores:\n\n");

            for (ErrorGeneral error : errores) {
                mensaje.append("Error: ").append(error.getMensajeError()).append("\n");
                mensaje.append("Solución: ").append(error.getMensajeSolucion()).append("\n\n");
            }

            JOptionPane.showMessageDialog(null, mensaje.toString(), "Errores", JOptionPane.ERROR_MESSAGE);
        }
    }
}   
     

