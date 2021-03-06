/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import Base.Conexion_c;
import Base.Empleado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author less_
 */
public class Probadores extends javax.swing.JFrame {

    /**
     * Creates new form Probadores
     */
    ResultSet programadores;
    public static String id_programador;
    public static String nombre;
    static int bandera = 0;
    DefaultTableModel modelo1 = null;
    //static int bandera=0;
    ResultSet resultado = null;
    Conexion_c con3 = new Conexion_c();
    int depto;

    public Probadores() throws SQLException {
        initComponents();
//        depto = Integer.parseInt(lblIdDepto.getText());
//        btnRegresar.setVisible(false);
//        iniciarValores();
    }

    Probadores(String id_depto, String nombre_depto)throws SQLException  {
        initComponents();
        lblIdDepto.setText(id_depto);
        lblNombreDepto.setText(nombre_depto);
        depto = Integer.parseInt(lblIdDepto.getText());
        btnRegresar.setVisible(false);
        iniciarValores();
    }

    public void iniciarValores() throws SQLException {

        Object[][] data = null;
        String[] columns = {
            "Codigo", "Nombre", "Cargo", "Departamento"
        };
        modelo1 = new DefaultTableModel(data, columns);
        this.jTableResultado.setModel(modelo1);
        String sql = "SELECT id_empleado,CONCAT(nombre_emp,' ',apellidos) nombre,nombre_cargo,nombre_depto FROM empleados emp INNER JOIN departamentos dep ON dep.id_depto='" + depto + "' and emp.id_depto='" + depto + "'\n"
                + "INNER JOIN  cargo c ON c.id_cargo=4 and emp.id_cargo=4 where id_estado_emp=0";
        con3.setRs(sql);

        generarListado();
    }

    void generarListado() throws SQLException {
        resultado = con3.getRs();
        while (resultado.next()) {
            Object[] newRow = {
                resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getString(4)
            };
            modelo1.addRow(newRow);
        }
        resultado.close();
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
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableResultado = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblIdDepto = new javax.swing.JLabel();
        lblNombreDepto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(59, 134, 139));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Probadores");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(jLabel5)
                .addContainerGap(346, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 80));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
        });

        jTableResultado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(59, 134, 139), 1, true));
        jTableResultado.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTableResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableResultadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableResultado);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(59, 134, 139));
        jLabel4.setText("Nombre del probador");

        txtBusqueda.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtBusqueda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(59, 134, 139), 1, true));

        btnRegresar.setBackground(new java.awt.Color(59, 134, 139));
        btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Regresar");

        javax.swing.GroupLayout btnRegresarLayout = new javax.swing.GroupLayout(btnRegresar);
        btnRegresar.setLayout(btnRegresarLayout);
        btnRegresarLayout.setHorizontalGroup(
            btnRegresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRegresarLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(37, 37, 37))
        );
        btnRegresarLayout.setVerticalGroup(
            btnRegresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRegresarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        lblIdDepto.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblIdDepto.setForeground(new java.awt.Color(59, 134, 139));
        lblIdDepto.setText("1");

        lblNombreDepto.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblNombreDepto.setForeground(new java.awt.Color(59, 134, 139));
        lblNombreDepto.setText("Nombre departamento");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel4)
                                .addGap(27, 27, 27)
                                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(lblIdDepto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNombreDepto)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdDepto)
                    .addComponent(lblNombreDepto))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 780, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents
int  filaSeleccionada=-1;
    private void jTableResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableResultadoMouseClicked
        filaSeleccionada = jTableResultado.getSelectedRow();
       
      
        if (filaSeleccionada != -1) {
            int rec = this.jTableResultado.getSelectedRow();

            id_programador=jTableResultado.getValueAt(rec, 0).toString();
            nombre=jTableResultado.getValueAt(rec, 1).toString();
            btnRegresar.enable(true);
        }
        
            if (jTableResultado.getSelectedRow()>=0){
         JOptionPane.showMessageDialog(this,"Esta seleccionada esta fila","Información",JOptionPane.INFORMATION_MESSAGE);
         btnRegresar.setVisible(true);
         }else{
         JOptionPane.showMessageDialog(this,"No esta selecionada esta fila","Información",JOptionPane.INFORMATION_MESSAGE);

         }
    }//GEN-LAST:event_jTableResultadoMouseClicked

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        Asignacion.txtProbador.setText(nombre);
        Asignacion.id_tes = id_programador;
        // JOptionPane.showMessageDialog(this, programador.id_p);
        Asignacion.getWindows();
        this.dispose();


    }//GEN-LAST:event_btnRegresarMouseClicked

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed
      
        while (modelo1.getRowCount() != 0)
            modelo1.removeRow(0);
        con3.setRs("Select id_empleado,CONCAT(nombre_emp,' ',apellidos) Nombre,nombre_cargo,nombre_depto FROM empleados emp INNER JOIN departamentos dep ON dep.id_depto='"
                + depto + "' and emp.id_depto='"
                + depto + "'\n"
                + "INNER JOIN  cargo c ON c.id_cargo=4 and emp.id_cargo=4 where id_estado_emp=0 and concat (nombre_emp,'',apellidos)"
                + "like '%" + this.txtBusqueda.getText() + "%'");
        try {
            generarListado();
        } catch (SQLException ex) {
            Logger.getLogger(Programadores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jPanel2KeyPressed

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
            java.util.logging.Logger.getLogger(Probadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Probadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Probadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Probadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Probadores().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Probadores.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnRegresar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableResultado;
    private javax.swing.JLabel lblIdDepto;
    private javax.swing.JLabel lblNombreDepto;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
