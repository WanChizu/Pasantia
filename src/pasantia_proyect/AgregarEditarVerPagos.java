/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasantia_proyect;

import Controladores.DatabaseManager;
import Controladores.Pagos.VerPago;
import entidades.Pagos;
import errores.ErrorGeneral;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author A19B59953
 */
public class AgregarEditarVerPagos extends javax.swing.JFrame {
    public final static int AGREGAR = 1;
    public final static int EDITAR = 2;
    public final static int VER = 3;
    int opcion;
    private int pagoId;
    /**
     * Creates new form AgregarEditarVerPagos
     */
    public AgregarEditarVerPagos() {
        initComponents();
        setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    public AgregarEditarVerPagos(int opcion, int pagoId)throws SQLException{
    this.opcion = opcion;
    this.pagoId = pagoId;
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
        lbl_nombre3 = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        lbl_nombre4 = new javax.swing.JLabel();
        lbl_nombre2 = new javax.swing.JLabel();
        combo_f = new javax.swing.JComboBox<>();
        lbl_nombre5 = new javax.swing.JLabel();
        lbl_nombre6 = new javax.swing.JLabel();
        txt_monto = new javax.swing.JTextField();
        lbl_nombre7 = new javax.swing.JLabel();
        lbl_nombre8 = new javax.swing.JLabel();
        combo_pago = new javax.swing.JComboBox<>();
        btnregresar = new javax.swing.JButton();
        btnagregar = new javax.swing.JButton();
        combo_a = new javax.swing.JComboBox<>();
        txt_nombre = new javax.swing.JTextField();
        combo_estado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(89, 111, 98));

        lbl_titulo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_titulo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_titulo.setText("AGREGAR PAGO");
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
                .addGap(229, 229, 229)
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

        lbl_nombre3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_nombre3.setText("Fecha");

        fecha.setDateFormatString("yyyy-MMM-dd");

        lbl_nombre4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_nombre4.setText("Nombre del pago");

        lbl_nombre2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_nombre2.setText("Facturas");

        combo_f.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        lbl_nombre5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_nombre5.setText("Areas");

        lbl_nombre6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_nombre6.setText("Monto");

        txt_monto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbl_nombre7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_nombre7.setText("Forma de pago");

        lbl_nombre8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_nombre8.setText("Estado del pago");

        combo_pago.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        btnregresar.setBackground(new java.awt.Color(28, 49, 68));
        btnregresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8-volver-30.png"))); // NOI18N
        btnregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresarActionPerformed(evt);
            }
        });

        btnagregar.setBackground(new java.awt.Color(28, 49, 68));
        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icons8-añadir-30.png"))); // NOI18N
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        combo_a.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        combo_estado.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        combo_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo", " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnregresar)
                        .addGap(20, 20, 20)
                        .addComponent(btnagregar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_nombre6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_monto, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_nombre2)
                        .addGap(10, 10, 10)
                        .addComponent(combo_f, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lbl_nombre5)
                        .addGap(10, 10, 10)
                        .addComponent(combo_a, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_nombre3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_nombre4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_nombre8)
                        .addGap(10, 10, 10)
                        .addComponent(combo_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_nombre7)
                        .addGap(10, 10, 10)
                        .addComponent(combo_pago, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_nombre3)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nombre4)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nombre2)
                    .addComponent(combo_f, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nombre5)
                    .addComponent(combo_a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nombre8)
                    .addComponent(lbl_nombre7)
                    .addComponent(combo_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_monto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nombre6))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnregresar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnagregar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(30, 30, 30))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_titulover(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_lbl_titulover

    }//GEN-LAST:event_lbl_titulover

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
    
    }//GEN-LAST:event_btnregresarActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
       
        
    }//GEN-LAST:event_btnagregarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      try {
    ArrayList<ErrorGeneral> errores = new ArrayList<>();
//    new AgregarEditarVerPagos(AgregarEditarVerFactura.AGREGAR, 1).setVisible(true);
//    new AgregarEditarVerPagos(AgregarEditarVerFactura.EDITAR, 1).setVisible(true);
  new AgregarEditarVerPagos(AgregarEditarVerFactura.VER, 1).setVisible(true);
    }catch (SQLException e) {
    }
    }
    
    private void createParaAgregar() {
    lbl_titulo.setText("AGREGAR FACTURA");

    try {
        List<Integer> facturas = DatabaseManager.obtenerIdsFactura();
        Map<Integer, String> areas = DatabaseManager.obtenerAreas();

        for (Integer id : facturas) {
            combo_f.addItem(id.toString());
        }

        for (Map.Entry<Integer, String> entry : areas.entrySet()) {
            combo_a.addItem(entry.getValue());
        }
    } catch (SQLException e) {
    }
     ArrayList<ErrorGeneral> errores = new ArrayList<>();
}


    private void createParaEditar() throws SQLException {
    lbl_titulo.setText("EDITAR FACTURA");
    btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img//icons//icons8-editar-30.png")));
   
    
    
    try {
        List<Integer> facturas = DatabaseManager.obtenerIdsFactura();
        Map<Integer, String> areas = DatabaseManager.obtenerAreas();


        for (Integer id : facturas) {
            combo_f.addItem(id.toString());
        }
        
         for (Map.Entry<Integer, String> entry : areas.entrySet()) {
            combo_a.addItem(entry.getValue());
        }
    } catch (SQLException e) {
    }
     ArrayList<ErrorGeneral> errores = new ArrayList<>();
//     rellenarVentana(facturaId, errores);  
    }

    private void createParaVer() throws SQLException {
    lbl_titulo.setText("VER FACTURA");
    fecha.setDateFormatString("dd/MM/yyyy");
    
    try {
        List<Integer> facturas = DatabaseManager.obtenerIdsFactura();
        Map<Integer, String> areas = DatabaseManager.obtenerAreas();

        for (Integer id : facturas) {
            combo_f.addItem(id.toString());
        }

         for (Map.Entry<Integer, String> entry : areas.entrySet()) {
            combo_a.addItem(entry.getValue());
        }

      
        txt_monto.setEditable(false);
      
        txt_nombre.setEditable(false);
       
        combo_a.setEnabled(false);
        combo_f.setEnabled(false);
        combo_estado.setEnabled(false);
        combo_pago.setEnabled(false);
        fecha.setEnabled(false);
        btnagregar.setEnabled(false);
    } catch (SQLException e) {
    }
          
    ArrayList<ErrorGeneral> errores = new ArrayList<>();
    rellenarVentana(pagoId, errores);  
    }
    
    private void rellenarVentana(int pagoId, ArrayList<ErrorGeneral> errores) throws SQLException {
    Pagos pago = VerPago.verPago(pagoId, errores);

    if (pago != null) {
      
        fecha.setDate(java.sql.Date.valueOf(pago.getFecha().plusDays(1))); 
        txt_monto.setText(pago.getMonto().toString());
        txt_nombre.setText(pago.getNombrePago());
        
        List<Integer> idsFactura = DatabaseManager.obtenerIdsFactura();
        
        for (Integer id : idsFactura) {
            combo_f.addItem(id.toString());
        }
        
   
         String areaNombre = DatabaseManager.obtenerAreas().get(pago.getAreaId());
        if (areaNombre != null) {
            combo_a.setSelectedItem(areaNombre);
        }
    } else {
        System.out.println("Factura no encontrada para el ID: " + pagoId);
    }
}
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnregresar;
    private javax.swing.JComboBox<String> combo_a;
    private javax.swing.JComboBox<String> combo_estado;
    private javax.swing.JComboBox<String> combo_f;
    private javax.swing.JComboBox<String> combo_pago;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_nombre2;
    private javax.swing.JLabel lbl_nombre3;
    private javax.swing.JLabel lbl_nombre4;
    private javax.swing.JLabel lbl_nombre5;
    private javax.swing.JLabel lbl_nombre6;
    private javax.swing.JLabel lbl_nombre7;
    private javax.swing.JLabel lbl_nombre8;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JTextField txt_monto;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
