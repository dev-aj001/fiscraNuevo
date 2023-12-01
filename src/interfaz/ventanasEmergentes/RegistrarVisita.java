/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz.ventanasEmergentes;
import interfaz.paneles.PanelVisitas;
import java.util.Date;
import javax.swing.JOptionPane;
import jpa.JPAController;
import java.util.List;
import modelos.Familiar;
import modelos.Paciente;
import modelos.Visita;
/**
 *
 * @author Cesar Uriel
 */
public class RegistrarVisita extends javax.swing.JFrame {
    PanelVisitas clase;
    List<Paciente> listPacientes;
    Visita visitaSeleccionada;
    public RegistrarVisita(PanelVisitas clase) {
        initComponents();
        this.clase=clase;
        consultaridPacientes();
        date.setMinSelectableDate(new Date());
    }

     public void consultaridPacientes(){
         
        JPAController jpa = new JPAController();

        listPacientes = jpa.getPacientesActivos();
        
        for (Paciente paciente : listPacientes) {
            String idp = paciente.getNombre()+" "+paciente.getApellidoPa()+" "+paciente.getApellidoMa();
            cmbidpaciente.addItem(idp);
        }
        
        try{
            txtAsunto.setText("Visita para " + cmbidpaciente.getSelectedItem().toString());
        } catch(NullPointerException e){
            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDatos3 = new javax.swing.JPanel();
        pnlPaciente = new javax.swing.JPanel();
        cmbidpaciente = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        pnlVisitante = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtVisitante = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cmbParentesco = new javax.swing.JComboBox<>();
        pnlHora = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cmbhora = new javax.swing.JComboBox<>();
        date = new com.toedter.calendar.JDateChooser();
        pnlPaciente1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtAsunto = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        pnlDatos3.setLayout(new org.jdesktop.swingx.VerticalLayout());

        pnlPaciente.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        cmbidpaciente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbidpacienteFocusLost(evt);
            }
        });
        cmbidpaciente.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                cmbidpacienteComponentShown(evt);
            }
        });
        cmbidpaciente.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbidpacientePropertyChange(evt);
            }
        });

        jLabel7.setText("Nombre del paciente: ");

        jButton3.setText("Buscar a detalle");

        javax.swing.GroupLayout pnlPacienteLayout = new javax.swing.GroupLayout(pnlPaciente);
        pnlPaciente.setLayout(pnlPacienteLayout);
        pnlPacienteLayout.setHorizontalGroup(
            pnlPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlPacienteLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbidpaciente, 0, 328, Short.MAX_VALUE))
                    .addComponent(jButton3))
                .addContainerGap())
        );
        pnlPacienteLayout.setVerticalGroup(
            pnlPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbidpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap())
        );

        pnlDatos3.add(pnlPaciente);

        pnlVisitante.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel9.setText("Nombre del visitante");

        jLabel11.setText("Parentesco");

        cmbParentesco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Sin especificar-", "Padre/Madre", "Esposo/a", "Hermano/a", "Hijo/a", "Nieto/a", "Sobrino/a", "Abuelo/a", "Tio/a", "Primo/a", "Cuñado/a", "Padrino/Madrina", "Amigo/a", "Compañero/a", "Acompañante", " " }));

        javax.swing.GroupLayout pnlVisitanteLayout = new javax.swing.GroupLayout(pnlVisitante);
        pnlVisitante.setLayout(pnlVisitanteLayout);
        pnlVisitanteLayout.setHorizontalGroup(
            pnlVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVisitanteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlVisitanteLayout.createSequentialGroup()
                        .addComponent(txtVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cmbParentesco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlVisitanteLayout.setVerticalGroup(
            pnlVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVisitanteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlVisitanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cmbParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlDatos3.add(pnlVisitante);

        pnlHora.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel10.setText("Fecha y hora de la visita");

        cmbhora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10:00", "11:00", "12:00 ", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00" }));
        cmbhora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbhoraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHoraLayout = new javax.swing.GroupLayout(pnlHora);
        pnlHora.setLayout(pnlHoraLayout);
        pnlHoraLayout.setHorizontalGroup(
            pnlHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbhora, 0, 119, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlHoraLayout.setVerticalGroup(
            pnlHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbhora)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlDatos3.add(pnlHora);

        pnlPaciente1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel8.setText("Asunto");

        javax.swing.GroupLayout pnlPaciente1Layout = new javax.swing.GroupLayout(pnlPaciente1);
        pnlPaciente1.setLayout(pnlPaciente1Layout);
        pnlPaciente1Layout.setHorizontalGroup(
            pnlPaciente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPaciente1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel8)
                .addGap(12, 12, 12)
                .addComponent(txtAsunto, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlPaciente1Layout.setVerticalGroup(
            pnlPaciente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPaciente1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPaciente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlDatos3.add(pnlPaciente1);

        btnCancelar.setText("Cancelar");

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(203, 243, 240));

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agendar nueva visita");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOK))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlDatos3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDatos3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOK)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed

        Visita visita = new Visita(0);
        visita.setFecha(date.getDate());
        visita.setHora(cmbhora.getSelectedItem().toString());
        visita.setEstatus(0);
        visita.setAsunto(txtAsunto.getText());
        visita.setFamiliar(txtVisitante.getText());
        visita.setParentesco(cmbParentesco.getSelectedItem().toString());
        
        visita.setPacienteidPaciente(listPacientes.get(cmbidpaciente.getSelectedIndex()));
        /*
        TODO: validacion de que coloque una fecha 
        */
        JPAController jpa = new JPAController();
        jpa.insertVisita(visita);
        clase.actualizarTabla();
        JOptionPane.showMessageDialog(this, "Se agrego una nueva visita  exitosamente");
        
        this.dispose();
        
    }//GEN-LAST:event_btnOKActionPerformed

    private void cmbidpacientePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbidpacientePropertyChange
        
    }//GEN-LAST:event_cmbidpacientePropertyChange

    private void cmbidpacienteComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_cmbidpacienteComponentShown
        
    }//GEN-LAST:event_cmbidpacienteComponentShown

    private void cmbidpacienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbidpacienteFocusLost
        try{
            txtAsunto.setText("Visita para " + cmbidpaciente.getSelectedItem().toString());
            Familiar f = new JPAController().getExpediente(listPacientes.get(cmbidpaciente.getSelectedIndex()).getIdPaciente()).getFamiliaridFamiliar();
            txtVisitante.setText(f.getNombre()+" "+f.getApellidoPa());
        
            //Mostrar parentesco
            String parentesco = f.getParentesco();

            for (int i = 0; i < cmbParentesco.getItemCount(); i++) {
                Object elemento = cmbParentesco.getItemAt(i);
                if(parentesco.equals(elemento.toString())){
                    cmbParentesco.setSelectedIndex(i);
                    break;
                }
            }
        } catch(NullPointerException e){
            
        }
    }//GEN-LAST:event_cmbidpacienteFocusLost

    private void cmbhoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbhoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbhoraActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnOK;
    private javax.swing.JComboBox<String> cmbParentesco;
    private javax.swing.JComboBox<String> cmbhora;
    private javax.swing.JComboBox<String> cmbidpaciente;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlDatos3;
    private javax.swing.JPanel pnlHora;
    private javax.swing.JPanel pnlPaciente;
    private javax.swing.JPanel pnlPaciente1;
    private javax.swing.JPanel pnlVisitante;
    private javax.swing.JTextField txtAsunto;
    private javax.swing.JTextField txtVisitante;
    // End of variables declaration//GEN-END:variables

//    private Date getHoraSeleccionada() {
//        Date horaSeleccted = new Date();
//        String hora[] = cmbhora.getSelectedItem().toString().split(":");
//        int h = Integer.valueOf(hora[0]);
//        
//        horaSeleccted.setHours(h);
//        horaSeleccted.setMinutes(0);
//        
//        return horaSeleccted;
//    }
}
