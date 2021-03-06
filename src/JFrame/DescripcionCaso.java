/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import Base.Casos;
import Beans.CasoBean;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author less_
 */
public class DescripcionCaso extends javax.swing.JFrame {
    private int tipo;
    private Color bien = new Color(59,134,139);
    private CasoBean casoB = new CasoBean();
    private Casos casos;
    static int ban = 0;
    private int IdDepto;
    /**
     * Creates new form DescripcionCaso
     */
    public DescripcionCaso() {
        initComponents();
    }

    public  DescripcionCaso(int tipo, String Idcaso, int Idepartamento) throws SQLException{
        ban = 1;
        initComponents();
        casos = new Casos();
        this.setLocationRelativeTo(null);
        this.tipo = tipo;
        this.IdDepto = Idepartamento;
        inicio(Idcaso);       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblIndicacion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripJF = new javax.swing.JTextArea();
        btnEnviar = new javax.swing.JPanel();
        lblBtn = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblIDCaso = new javax.swing.JLabel();
        lblNombreCaso = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripJD = new javax.swing.JTextArea();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );

        jLabel1.setText("jLabel1");

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(59, 134, 139));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Descripción caso");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(164, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(158, 158, 158))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 70));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lblIndicacion.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblIndicacion.setForeground(new java.awt.Color(59, 134, 139));
        lblIndicacion.setText("Ingrese descripción detallada de las actividades a realizar");

        txtDescripJF.setEditable(false);
        txtDescripJF.setColumns(20);
        txtDescripJF.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtDescripJF.setLineWrap(true);
        txtDescripJF.setRows(5);
        txtDescripJF.setAutoscrolls(false);
        txtDescripJF.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(59, 134, 139), 1, true));
        jScrollPane1.setViewportView(txtDescripJF);

        btnEnviar.setBackground(new java.awt.Color(59, 134, 139));
        btnEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnviarMouseClicked(evt);
            }
        });

        lblBtn.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lblBtn.setForeground(new java.awt.Color(255, 255, 255));
        lblBtn.setText("Asignar a grupo de trabajo");

        javax.swing.GroupLayout btnEnviarLayout = new javax.swing.GroupLayout(btnEnviar);
        btnEnviar.setLayout(btnEnviarLayout);
        btnEnviarLayout.setHorizontalGroup(
            btnEnviarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEnviarLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblBtn)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        btnEnviarLayout.setVerticalGroup(
            btnEnviarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEnviarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblBtn)
                .addGap(21, 21, 21))
        );

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(59, 134, 139));
        jLabel3.setText("Código del caso");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(59, 134, 139));
        jLabel6.setText("Nombre");

        lblIDCaso.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblIDCaso.setForeground(new java.awt.Color(0, 51, 102));
        lblIDCaso.setText("Nombre");

        lblNombreCaso.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblNombreCaso.setForeground(new java.awt.Color(0, 51, 102));
        lblNombreCaso.setText("Nombre");

        txtDescripJD.setColumns(20);
        txtDescripJD.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtDescripJD.setRows(5);
        txtDescripJD.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(59, 134, 139), 1, true));
        txtDescripJD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripJDKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtDescripJD);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIDCaso)
                            .addComponent(lblNombreCaso))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 120, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEnviar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(lblIndicacion)
                                .addGap(16, 16, 16))))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblIDCaso))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblNombreCaso))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblIndicacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 520, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviarMouseClicked
        try {
            if (tipo == 0) {
                casoB.setDescripcion_jefedes(txtDescripJD.getText().trim());
                casoB.setId_estado(3);//En desarrollo
                Asignacion asignacionCaso = new Asignacion(casoB, IdDepto);

                asignacionCaso.setVisible(true);

            } else if (tipo == 1){
                casoB.setDescrip_rechazo(txtDescripJD.getText().trim());
                casoB.setId_estado(2);//Rechazada
                casos.rechazarCaso(casoB);
            }            
            formWindowClosing(null);
        } catch (Exception e) {
            System.out.println(""+e);
        }
    }//GEN-LAST:event_btnEnviarMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ban = 0;
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void txtDescripJDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripJDKeyTyped
        if (txtDescripJD.getText().length() > 0)
            valido(0);
        else 
            valido(1);
    }//GEN-LAST:event_txtDescripJDKeyTyped

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
            java.util.logging.Logger.getLogger(DescripcionCaso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DescripcionCaso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DescripcionCaso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DescripcionCaso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DescripcionCaso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBtn;
    private javax.swing.JLabel lblIDCaso;
    private javax.swing.JLabel lblIndicacion;
    private javax.swing.JLabel lblNombreCaso;
    private javax.swing.JTextArea txtDescripJD;
    private javax.swing.JTextArea txtDescripJF;
    // End of variables declaration//GEN-END:variables

    private void inicio(String Idcaso) {
        valido(1);
        casoB = casos.getDatosSolicitudJD(Idcaso);
        lblIDCaso.setText(Idcaso);
        lblNombreCaso.setText(casoB.getNombre_caso());
        txtDescripJF.setText(casoB.getDescrip_req());
        if (tipo == 1) {
            lblIndicacion.setText("Ingrese una descripcion de rechazo");
            lblBtn.setText("Aceptar");
        }
    }

    private void valido(int i) {
        if (i == 1) {
            txtDescripJD.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            lblIndicacion.setForeground(Color.red);
            btnEnviar.setVisible(false);
        } else {
            txtDescripJD.setBorder(BorderFactory.createLineBorder(bien, 1));
            lblIndicacion.setForeground(bien);
            btnEnviar.setVisible(true);
        }
    }
}
