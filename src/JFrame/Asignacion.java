/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import Base.Empleado_Caso;
import Base.Casos;
import Base.Departamento;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Help.Help;
import Beans.CasoBean;
import Beans.DepartamentoBean;
import com.sun.prism.paint.Color;

/**
 *
 * @author less_
 */
public class Asignacion extends javax.swing.JFrame {

    /**
     * Creates new form Asignacion
     */
    public static String id_p;
    public static String id_tes;
    String caso = "";
    int id_depto;
    Help h = new Help();
    private CasoBean casoFecha;
    private DepartamentoBean deptoB = new DepartamentoBean();
    private Departamento depto = new Departamento();
    Empleado_Caso ec;
    Casos casos;
    private String DescripJD;

    public Asignacion() throws SQLException {
        initComponents();
//        this.setLocationRelativeTo(null);
//        ec = new Empleado_Caso();
//        caso = lblIdcaso.getText();
//        id_depto = Integer.parseInt(lblIdDepto.getText());
//        if (ec.verificarAsignacion(lblIdcaso.getText())) {
//            btnAsignar.setVisible(false);
//            btnModificar.setVisible(true);
//            txtProgramador.setText(ec.nombreEmpleadoP(caso));
//            txtProbador.setText(ec.nombreEmpleadoT(caso));
//            txtFecha.setText(ec.fechaLimite(caso));
//            id_p = Integer.toString(ec.idProgramador(caso));
//            id_tes = Integer.toString(ec.idTester(caso));
//        } else {
//            btnAsignar.setVisible(true);
//            btnModificar.setVisible(false);
//        }
    }

    Asignacion(CasoBean casoB, int idDepartamento) throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        ec = new Empleado_Caso();
        caso = casoB.getId_caso();//lblIdcaso.getText();
        id_depto = idDepartamento;//Integer.parseInt(lblIdDepto.getText());
        lblIdcaso.setText(casoB.getId_caso());
        lblNombreCaso.setText(casoB.getNombre_caso());
        lblIdDepto.setText(String.valueOf(idDepartamento));
        deptoB.setId_depto(id_depto);
        depto.getDatos(deptoB);
        lblNombreDepto.setText(deptoB.getNombre_depto());
        DescripJD = casoB.getDescripcion_jefedes();
        if (ec.verificarAsignacion(lblIdcaso.getText())) {
            btnAsignar.setVisible(false);
            btnModificar.setVisible(true);
            txtProgramador.setText(ec.nombreEmpleadoP(caso));
            txtProbador.setText(ec.nombreEmpleadoT(caso));
            txtFecha.setText(ec.fechaLimite(caso));
            id_p = Integer.toString(ec.idProgramador(caso));
            id_tes = Integer.toString(ec.idTester(caso));
        } else {
            btnAsignar.setVisible(true);
            btnModificar.setVisible(false);
        }
    }

    public void capturarIdProgramador() {
        JOptionPane.showMessageDialog(this, id_p + " " + id_tes);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtProbador = new javax.swing.JTextField();
        txtProgramador = new javax.swing.JTextField();
        btnAsignarProgramador = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnAsignarTester = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblNombreDepto = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblNombreCaso = new javax.swing.JLabel();
        btnAsignar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblIdcaso = new javax.swing.JLabel();
        btnModificar = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        lblError = new javax.swing.JLabel();
        lblIdDepto = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("jLabel1");

        jLabel10.setText("jLabel10");

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(59, 134, 139));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Asignación");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(jLabel5)
                .addContainerGap(285, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(59, 134, 139));
        jLabel3.setText("Nombre del probador ");

        txtProbador.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtProbador.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(59, 134, 139), 1, true));

        txtProgramador.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtProgramador.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(59, 134, 139), 1, true));

        btnAsignarProgramador.setBackground(new java.awt.Color(59, 134, 139));
        btnAsignarProgramador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAsignarProgramadorMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Buscar");

        javax.swing.GroupLayout btnAsignarProgramadorLayout = new javax.swing.GroupLayout(btnAsignarProgramador);
        btnAsignarProgramador.setLayout(btnAsignarProgramadorLayout);
        btnAsignarProgramadorLayout.setHorizontalGroup(
            btnAsignarProgramadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAsignarProgramadorLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnAsignarProgramadorLayout.setVerticalGroup(
            btnAsignarProgramadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnAsignarTester.setBackground(new java.awt.Color(59, 134, 139));
        btnAsignarTester.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAsignarTesterMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar");

        javax.swing.GroupLayout btnAsignarTesterLayout = new javax.swing.GroupLayout(btnAsignarTester);
        btnAsignarTester.setLayout(btnAsignarTesterLayout);
        btnAsignarTesterLayout.setHorizontalGroup(
            btnAsignarTesterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAsignarTesterLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        btnAsignarTesterLayout.setVerticalGroup(
            btnAsignarTesterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(59, 134, 139));
        jLabel4.setText("Nombre del programador");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(59, 134, 139));
        jLabel8.setText("Departamento");

        lblNombreDepto.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblNombreDepto.setForeground(new java.awt.Color(36, 46, 68));
        lblNombreDepto.setText("nombre depto");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(59, 134, 139));
        jLabel9.setText("Caso");

        lblNombreCaso.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblNombreCaso.setForeground(new java.awt.Color(36, 46, 68));
        lblNombreCaso.setText("nombre caso");

        btnAsignar.setBackground(new java.awt.Color(59, 134, 139));
        btnAsignar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAsignarMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Asignar");

        javax.swing.GroupLayout btnAsignarLayout = new javax.swing.GroupLayout(btnAsignar);
        btnAsignar.setLayout(btnAsignarLayout);
        btnAsignarLayout.setHorizontalGroup(
            btnAsignarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAsignarLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel7)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        btnAsignarLayout.setVerticalGroup(
            btnAsignarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAsignarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblIdcaso.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblIdcaso.setForeground(new java.awt.Color(36, 46, 68));
        lblIdcaso.setText("fg444");

        btnModificar.setBackground(new java.awt.Color(59, 134, 139));
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Modificar");

        javax.swing.GroupLayout btnModificarLayout = new javax.swing.GroupLayout(btnModificar);
        btnModificar.setLayout(btnModificarLayout);
        btnModificarLayout.setHorizontalGroup(
            btnModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnModificarLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel11)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        btnModificarLayout.setVerticalGroup(
            btnModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnModificarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(59, 134, 139));
        jLabel12.setText("Fecha limite de entrega");

        txtFecha.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtFecha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(59, 134, 139), 1, true));
        txtFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFechaMouseClicked(evt);
            }
        });
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });
        txtFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaKeyReleased(evt);
            }
        });

        lblError.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblError.setForeground(new java.awt.Color(204, 0, 0));

        lblIdDepto.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblIdDepto.setForeground(new java.awt.Color(36, 46, 68));
        lblIdDepto.setText("1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(lblIdcaso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNombreCaso))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(lblIdDepto)
                                .addGap(18, 18, 18)
                                .addComponent(lblNombreDepto))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(btnAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtProbador, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtProgramador, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnAsignarProgramador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAsignarTester, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreDepto)
                    .addComponent(jLabel8)
                    .addComponent(lblIdDepto))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblNombreCaso)
                    .addComponent(lblIdcaso))
                .addGap(50, 50, 50)
                .addComponent(jLabel4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtProgramador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnAsignarProgramador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(51, 51, 51)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAsignarTester, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtProbador, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(53, 53, 53)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 640, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsignarTesterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAsignarTesterMouseClicked
        try {
            Probadores tester = new Probadores(lblIdDepto.getText(), deptoB.getNombre_depto());
            tester.show();
        } catch (SQLException ex) {
            Logger.getLogger(Asignacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAsignarTesterMouseClicked

    private void btnAsignarProgramadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAsignarProgramadorMouseClicked
        try {
            Programadores progra = new Programadores(lblIdDepto.getText(), deptoB.getNombre_depto());
            progra.show();
        } catch (SQLException ex) {
            Logger.getLogger(Asignacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAsignarProgramadorMouseClicked

    private void btnAsignarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAsignarMouseClicked
        String fecha = txtFecha.getText();
        casoFecha = new CasoBean();
        casoFecha.setFecha_limite(fecha);
        casoFecha.setId_caso(caso);
        casoFecha.setId_estado(3);//Cambiar a CASO en desarrollo
        casoFecha.setDescripcion_jefedes(DescripJD);
        if (h.verificarFecha(fecha) && h.verificarAnio(fecha) && !txtProbador.getText().equals("") && !txtProbador.getText().equals("")) {
            if (!h.dateMaxNow(fecha) || !h.exitsFecha(fecha)) //Verificar si es menor a al fecha actual y si existe
                JOptionPane.showMessageDialog(null, "La fecha ingresada no es valida");
            else {
                try {
                    ec = new Empleado_Caso();
                    casos = new Casos();
                    ec.setId_caso(lblIdcaso.getText());
                    ec.Asignar(Integer.parseInt(id_p), Integer.parseInt(id_tes));
                    casos.UpdateCasoFechaLimite(casoFecha);
                    casos.firstBitacora(casoFecha);
                    casos.UpdateCasoDescrpDes(casoFecha);
                    this.dispose();
                } catch (SQLException ex) {
                    Logger.getLogger(Asignacion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Asignacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Verifique que la información ingresada sea correcta");
        }

    }//GEN-LAST:event_btnAsignarMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        String fecha = txtFecha.getText();
        casoFecha = new CasoBean();
        casoFecha.setFecha_limite(fecha);
        casoFecha.setId_caso(caso);
        casoFecha.setId_estado(3);
        if (h.verificarFecha(fecha) && h.verificarAnio(fecha) && !txtProbador.getText().equals("") && !txtProbador.getText().equals("")) {
            try {
                ec = new Empleado_Caso();
                casos = new Casos();
                ec.setId_caso(lblIdcaso.getText());
                ec.ModificarEmpleados(Integer.parseInt(id_p), Integer.parseInt(id_tes), txtProgramador.getText(), txtProbador.getText(), lblIdcaso.getText());
                casos.UpdateCasoFechaLimite(casoFecha);
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(Asignacion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Asignacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Verifique la información ingresada");
        }

    }//GEN-LAST:event_btnModificarMouseClicked

    private void txtFechaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaKeyReleased
        String fecha = txtFecha.getText();
        if (h.verificarFecha(fecha) && h.verificarAnio(fecha)) {
            lblError.setText("");

        } else {
            lblError.setText("Verifique la fecha");
        }
    }//GEN-LAST:event_txtFechaKeyReleased

    private void txtFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFechaMouseClicked
        if (txtFecha.getText().equals("02-02-2019")) {
            txtFecha.setText("");
        }
    }//GEN-LAST:event_txtFechaMouseClicked

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Asignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Asignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Asignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Asignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Asignacion().setVisible(true);
                } catch (SQLException ex) {
                    System.out.println(""+ex);
                    Logger.getLogger(Asignacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnAsignar;
    private javax.swing.JPanel btnAsignarProgramador;
    private javax.swing.JPanel btnAsignarTester;
    private javax.swing.JPanel btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblError;
    public static javax.swing.JLabel lblIdDepto;
    public static javax.swing.JLabel lblIdcaso;
    public static javax.swing.JLabel lblNombreCaso;
    public static javax.swing.JLabel lblNombreDepto;
    public static javax.swing.JTextField txtFecha;
    public static javax.swing.JTextField txtProbador;
    protected static javax.swing.JTextField txtProgramador;
    // End of variables declaration//GEN-END:variables
}
