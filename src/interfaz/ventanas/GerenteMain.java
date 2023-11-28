/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz.ventanas;

import custom.clases.Iconos;
import custom.clases.userData;
import interfaz.paneles.*;

/**
 *
 * @author jairi
 */
public class GerenteMain extends javax.swing.JFrame {

    /**
     * Creates new form GerenteMain
     */
    public GerenteMain() {
        initComponents();
        initSyles();
        
        imagenPerfil2.setIcon(new javax.swing.ImageIcon(userData.usuario.getImagen()));
        //screenPnl.add(new PanelVisitas());
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
        roundPanel1 = new custom.componentes.RoundPanel();
        lblNombre = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        imagenPerfil2 = new custom.componentes.ImagenPerfil();
        roundPanel2 = new custom.componentes.RoundPanel();
        btnUsuarios = new javax.swing.JButton();
        btnPacientes = new javax.swing.JButton();
        btnActividades = new javax.swing.JButton();
        btnVisitas = new javax.swing.JButton();
        btnCalendario = new javax.swing.JButton();
        btnFinanzas = new javax.swing.JButton();
        reloj1 = new custom.componentes.Reloj();
        roundPanel3 = new custom.componentes.RoundPanel();
        btnSalir = new javax.swing.JButton();
        btnConfigurar = new javax.swing.JButton();
        screenPnl = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        roundPanel1.setBackground(new java.awt.Color(204, 204, 204));

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombre.setText("Armando Jair");

        lblRol.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRol.setText("Gerente");

        imagenPerfil2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/perfille.png"))); // NOI18N

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagenPerfil2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(lblRol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRol))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imagenPerfil2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
        );

        btnUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUsuarios.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnUsuarios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        btnPacientes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPacientes.setText("Pacientes");
        btnPacientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPacientes.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnPacientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacientesActionPerformed(evt);
            }
        });

        btnActividades.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnActividades.setText("Actividades");
        btnActividades.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActividades.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnActividades.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActividadesActionPerformed(evt);
            }
        });

        btnVisitas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVisitas.setText("Visitas");
        btnVisitas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVisitas.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnVisitas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVisitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisitasActionPerformed(evt);
            }
        });

        btnCalendario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCalendario.setText("Calendario");
        btnCalendario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCalendario.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCalendario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalendarioActionPerformed(evt);
            }
        });

        btnFinanzas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnFinanzas.setText("Finanzas");
        btnFinanzas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFinanzas.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnFinanzas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFinanzas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinanzasActionPerformed(evt);
            }
        });

        roundPanel3.setBackground(new java.awt.Color(204, 204, 204));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnConfigurar.setIconTextGap(9);

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSalir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfigurar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnConfigurar, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPacientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActividades, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(btnVisitas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCalendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFinanzas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reloj1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(roundPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPacientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActividades)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVisitas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCalendario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFinanzas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                .addComponent(reloj1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        screenPnl.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(screenPnl, javax.swing.GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(screenPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        screenPnl.removeAll();
        screenPnl.add(PanelUsuarios.getInstance());
        screenPnl.revalidate();
        screenPnl.repaint();
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacientesActionPerformed
        screenPnl.removeAll();
        screenPnl.add(PanelPacientes.getInstance());
        screenPnl.revalidate();
        screenPnl.repaint();
    }//GEN-LAST:event_btnPacientesActionPerformed

    private void btnActividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActividadesActionPerformed
        screenPnl.removeAll();
        screenPnl.add(PanelActividades.getInstance());
        screenPnl.revalidate();
        screenPnl.repaint();
    }//GEN-LAST:event_btnActividadesActionPerformed

    private void btnVisitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisitasActionPerformed
        screenPnl.removeAll();
        screenPnl.add(PanelVisitas.getInstance());
        screenPnl.revalidate();
        screenPnl.repaint();
    }//GEN-LAST:event_btnVisitasActionPerformed

    private void btnCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalendarioActionPerformed
        screenPnl.removeAll();
        //screenPnl.add(Calendario.getInstance());
        screenPnl.revalidate();
        screenPnl.repaint();
    }//GEN-LAST:event_btnCalendarioActionPerformed

    private void btnFinanzasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinanzasActionPerformed
        screenPnl.removeAll();
        screenPnl.add(PanelFinanzas.getInstance());
        screenPnl.revalidate();
        screenPnl.repaint();
    }//GEN-LAST:event_btnFinanzasActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // Salir al login
        this.dispose();
        new LoginFrame().setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(GerenteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenteMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActividades;
    private javax.swing.JButton btnCalendario;
    private javax.swing.JButton btnConfigurar;
    private javax.swing.JButton btnFinanzas;
    private javax.swing.JButton btnPacientes;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JButton btnVisitas;
    private custom.componentes.ImagenPerfil imagenPerfil2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRol;
    private custom.componentes.Reloj reloj1;
    private custom.componentes.RoundPanel roundPanel1;
    private custom.componentes.RoundPanel roundPanel2;
    private custom.componentes.RoundPanel roundPanel3;
    private javax.swing.JPanel screenPnl;
    // End of variables declaration//GEN-END:variables

    private void initSyles() {
        
        this.lblNombre.setText(userData.nombre);
        this.lblRol.setText(userData.rol);
        
        //asignar iconos
        btnSalir.setIcon(Iconos.exit());
        btnConfigurar.setIcon(Iconos.support_agent());
        btnUsuarios.setIcon(Iconos.usuarios());
        btnPacientes.setIcon(Iconos.pacientes());
        btnActividades.setIcon(Iconos.event_note());
        btnVisitas.setIcon(Iconos.event_note());
        btnCalendario.setIcon(Iconos.calendario());
        btnFinanzas.setIcon(Iconos.pagos());
    }
}