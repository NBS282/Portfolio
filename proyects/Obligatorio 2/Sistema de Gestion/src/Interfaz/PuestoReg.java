package Interfaz;
/**
 * @authors NICOLAS BIDENTI (305108) - MATTEO QUAGLIATA (298144)
 */
import Dominio.*;
import java.util.*;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class PuestoReg extends javax.swing.JFrame implements Observer {

    private Sistema modelo;
    private String nombre;
    private String tipo;
    private ArrayList<Tema> temasRequeridos = new ArrayList<>();

    public PuestoReg() {
        initComponents();
    }

    public PuestoReg(Sistema unSistema) {
        initComponents();
        modelo = unSistema;
        update(null, null);
        modelo.addObserver(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdbotones = new javax.swing.ButtonGroup();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rdbtnRemoto = new javax.swing.JRadioButton();
        rdbtnPresencial = new javax.swing.JRadioButton();
        rdbtnMixto = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnAgregarTema = new javax.swing.JButton();
        btnRegistrarPuesto = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cbTemas = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaTemas = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de Puesto");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel3.setText("Tipo:");

        rdbotones.add(rdbtnRemoto);
        rdbtnRemoto.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        rdbtnRemoto.setSelected(true);
        rdbtnRemoto.setText("Remoto");

        rdbotones.add(rdbtnPresencial);
        rdbtnPresencial.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        rdbtnPresencial.setText("Presecial");

        rdbotones.add(rdbtnMixto);
        rdbtnMixto.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        rdbtnMixto.setText("Mixto");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel4.setText("Tema:");

        btnAgregarTema.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnAgregarTema.setText("Agregar Tema");
        btnAgregarTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTemaActionPerformed(evt);
            }
        });

        btnRegistrarPuesto.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnRegistrarPuesto.setText("Registrar Puesto");
        btnRegistrarPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPuestoActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(ListaTemas);

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel5.setText("Temas agregados:");

        btnEliminar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(cbTemas, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAgregarTema, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(rdbtnRemoto, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdbtnPresencial, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdbtnMixto, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(txtNombre))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrarPuesto)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbtnRemoto, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdbtnMixto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdbtnPresencial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(btnAgregarTema)
                    .addComponent(cbTemas, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(btnRegistrarPuesto))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPuestoActionPerformed
        // TODO add your handling code here:
        nombre = txtNombre.getText();
        if (rdbtnMixto.isSelected()) {
            tipo = "Mixto";
        } else if (rdbtnRemoto.isSelected()) {
            tipo = "Remoto";
        } else {
            tipo = "Presencial";
        }

        if (nombre.isEmpty() || tipo.isEmpty() || temasRequeridos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Completar todos los campos requeridos");
        } else {
            Puesto nuevoPuesto = new Puesto(nombre, tipo, temasRequeridos);
            modelo.addPuesto(nuevoPuesto);
            txtNombre.setText("");
            DefaultListModel<String> modeloLista = new DefaultListModel<>();
            ListaTemas.setModel(modeloLista); // seteo la lista en default para poder usar removeAllElements()  
            modeloLista.removeAllElements();
            temasRequeridos.clear();
        }
    }//GEN-LAST:event_btnRegistrarPuestoActionPerformed

    private void btnAgregarTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTemaActionPerformed
        // TODO add your handling code here:
        Tema tema = (Tema) cbTemas.getSelectedItem();
        Tema temareq = new Tema(tema.getNombre(), tema.getDescripcion()); // creo un nuevo tema para que este no tenga el nivel que agrego el postulante

        if (!temasRequeridos.contains(temareq)) {
            temasRequeridos.add(tema);//para que no agregue dos veces el tema.
            ListaTemas.setListData(temasRequeridos.toArray());
        } else {
            JOptionPane.showMessageDialog(null, "Tema ya agregado previamente");
        }
    }//GEN-LAST:event_btnAgregarTemaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (ListaTemas.getSelectedValue() != null) {
            String temaAeliminar = ListaTemas.getSelectedValue().toString();
            temasRequeridos = modelo.removeTemaPuesto(temaAeliminar, temasRequeridos);
            ListaTemas.removeAll();
            ListaTemas.setListData(temasRequeridos.toArray());
        } else {
            JOptionPane.showMessageDialog(null, "No se selecciono ningun tema");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    public void LlenarTemas() {
        ArrayList<Tema> temas = modelo.getTemas();

        if (!temas.isEmpty()) { // para que cuando agregue el primer tema no se elimine del combo
            cbTemas.removeAllItems();
        }
        for (Tema tema : temas) {
            cbTemas.addItem(tema);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PuestoReg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList ListaTemas;
    private javax.swing.JButton btnAgregarTema;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrarPuesto;
    private javax.swing.JComboBox cbTemas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.ButtonGroup rdbotones;
    private javax.swing.JRadioButton rdbtnMixto;
    private javax.swing.JRadioButton rdbtnPresencial;
    private javax.swing.JRadioButton rdbtnRemoto;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    public void update(Observable o, Object arg) {
        LlenarTemas();
    }
}
