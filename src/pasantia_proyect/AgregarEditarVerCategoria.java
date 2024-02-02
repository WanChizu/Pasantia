/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasantia_proyect;

import Controladores.Categoria.ActualizarCategoria;
import Controladores.Categoria.AgregarCategoria;
import Controladores.Categoria.VerCategoria;
import entidades.Categoria;
import errores.ErrorGeneral;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author A19B59953
 */
public class AgregarEditarVerCategoria extends javax.swing.JFrame {
    
    public final static int AGREGAR = 1;
    public final static int EDITAR = 2;
    public final static int VER = 3;
    int opcion;
    private int categoriaId;

    
    /**
     * Creates new form categoria
     */
    public AgregarEditarVerCategoria() {
        initComponents();
        setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    public AgregarEditarVerCategoria(int opcion, int categoriaId)throws SQLException{
    this.opcion = opcion;
    this.categoriaId = categoriaId;
    initComponents();
    
    ArrayList<ErrorGeneral> errores = new ArrayList<>();
    
    switch (opcion){
    case AGREGAR:
    createParaAgregar();
    break;
    case EDITAR:
    createParaEditar();
    break;
    case VER:
    createParaVer();
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
        jPanel2 = new javax.swing.JPanel();
        lbl_titulo = new javax.swing.JLabel();
        lbl_nombre = new javax.swing.JLabel();
        lbl_nombre1 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        combo = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        btnagregar = new javax.swing.JButton();
        btn_regreso = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 0));

        lbl_titulo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_titulo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_titulo.setText("AGREGAR CATEGORIA");
        lbl_titulo.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                lbl_titulover(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(lbl_titulo)
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(lbl_titulo)
                .addGap(34, 34, 34))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 90));

        lbl_nombre.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_nombre.setText("Activo");
        jPanel1.add(lbl_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        lbl_nombre1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_nombre1.setText("Nombre");
        jPanel1.add(lbl_nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_nombre.setBorder(null);
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 220, 30));

        combo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        jPanel1.add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 220, 20));

        btnagregar.setBackground(new java.awt.Color(51, 102, 0));
        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconagregar.png"))); // NOI18N
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, -1, -1));

        btn_regreso.setBackground(new java.awt.Color(51, 102, 0));
        btn_regreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconregreso.png"))); // NOI18N
        btn_regreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_regreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 420, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_titulover(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_lbl_titulover

    }//GEN-LAST:event_lbl_titulover

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
     if (opcion == AGREGAR) {
            agregarCategoria();
        } else if (opcion == EDITAR) {
            editarCategoria();
        }
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btn_regresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresoActionPerformed
    this.setVisible(false);
    categoriafrm c = categoriafrm.obtenerInstanciaPrincipal();
    c.setVisible(true);
    c.actualizarTabla();
    }//GEN-LAST:event_btn_regresoActionPerformed

    public static void main(String [] args) throws SQLException {

    try {
    ArrayList<ErrorGeneral> errores = new ArrayList<>();
//    new AgregarEditarVerCategoria(AgregarEditarVerCategoria.AGREGAR, 1).setVisible(true);
    new AgregarEditarVerCategoria(AgregarEditarVerCategoria.EDITAR, 4).setVisible(true);
//    new AgregarEditarVerCategoria( AgregarEditarVerCategoria.VER, 1).setVisible(true);
    }catch (SQLException e) {
    }
}
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_regreso;
    private javax.swing.JButton btnagregar;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_nombre1;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables

    private void createParaAgregar() {
      lbl_titulo.setText("AGREGAR CATEGORIA");
    }

    private void createParaEditar() {
    
        lbl_titulo.setText("EDITAR CATEGORIA");
        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconeditar.png")));
        ArrayList<ErrorGeneral> errores = new ArrayList<>();
        rellenarVentana(categoriaId, errores);
    }

    private void createParaVer() {
       lbl_titulo.setText("VER CATEGORIA");
       txt_nombre.setEditable(false);
       combo.setEnabled(false);
       
        Font fuente = txt_nombre.getFont();
        float tamanoFuente = fuente.getSize() + 2; 
        txt_nombre.setFont(fuente.deriveFont(tamanoFuente));
        combo.setFont(fuente.deriveFont(tamanoFuente));
        
                
        ArrayList<ErrorGeneral> errores = new ArrayList<>();
        rellenarVentana(categoriaId, errores);
    }
    
     private void rellenarVentana(int codigoCategoria, ArrayList<ErrorGeneral> errores) {
    this.categoria = VerCategoria.verCategorias(codigoCategoria, errores);

    if (this.categoria != null) {
        txt_nombre.setText(this.categoria.getNombreCategoria());
        combo.setSelectedItem(categoria.isEstaActivo() ? "Si" : "No");
        actualizarComboBoxActivo(categoria.isEstaActivo());
    } else {
     
    }
}

    private void agregarCategoria() {
    String nombreCategoria = txt_nombre.getText();
    boolean estaActivo = combo.getSelectedItem().equals("Si");

    Categoria nuevaCategoria = new Categoria(0, nombreCategoria, estaActivo);

    categoriafrm pantalla = categoriafrm.obtenerInstanciaPrincipal();

    ArrayList<errores.ErrorGeneral> errores = new ArrayList<>();
   
    int idCategoriaInsertada = AgregarCategoria.insertarCategoria(nuevaCategoria, errores);

    if (idCategoriaInsertada != -1) {
        JOptionPane.showMessageDialog(this, "Categoría agregada exitosamente con ID " + idCategoriaInsertada, "Éxito", JOptionPane.INFORMATION_MESSAGE);

        pantalla.actualizarTabla();
        pantalla.setVisible(true);
        this.dispose();
    } else {
        mostrarErrores(errores);
    }
}

    
    public void actualizarComboBoxActivo(boolean estaActivo) {
    DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) combo.getModel();

    if (estaActivo) {
        combo.setSelectedItem("si");
    } else {
        combo.setSelectedItem("no");
    }
    combo.revalidate();
    combo.repaint();
}

    private void editarCategoria() {
    String seleccion = (String) combo.getSelectedItem();
    boolean estaActivo = seleccion.equals("Si");
    Categoria categoriaAActualizar = new Categoria(categoriaId, txt_nombre.getText(), estaActivo);

    categoriafrm pantalla = categoriafrm.obtenerInstanciaPrincipal();
    ArrayList<errores.ErrorGeneral> errores = new ArrayList<>();
    
    ActualizarCategoria.actualizarCategoria(categoriaAActualizar, errores);

    if (errores.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Categoría actualizada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        pantalla.actualizarTabla();
        pantalla.setVisible(true);
        this.dispose();
    } else {
        mostrarErrores(errores);
    }

    rellenarVentana(categoriaId, new ArrayList<>());
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
    
    private Categoria categoria;
    
   
}