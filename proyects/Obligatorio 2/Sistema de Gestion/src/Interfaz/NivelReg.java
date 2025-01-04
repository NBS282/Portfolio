
package Interfaz;
/**
 * @authors NICOLAS BIDENTI (305108) - MATTEO QUAGLIATA (298144)
 */
import Dominio.*;
import java.util.*;
import javax.accessibility.AccessibleContext;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class NivelReg extends javax.swing.JFrame implements Observer {

    private Sistema modelo;
    private Postulante postulante;
    private PostulanteAltaReg ant;

    private HashMap<Tema, Integer> temas = new HashMap<>();

    public NivelReg() {
        initComponents();
    }

    public NivelReg(Sistema unSistema) {
        initComponents();
        modelo = unSistema;
        update(null, null);
        modelo.addObserver(this);
    }

    public void update(Observable o, Object arg) {
        LlenarComobo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        CbTemas = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        SpNivel = new javax.swing.JSpinner();
        btnAgregarNivel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnEliminarTema = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaTemas = new javax.swing.JList();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtPost = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel2.setText("Tema:");

        CbTemas.setActionCommand("\n");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel3.setText("Nivel:");

        SpNivel.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        SpNivel.setEditor(new javax.swing.JSpinner.NumberEditor(SpNivel, ""));

        btnAgregarNivel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnAgregarNivel.setText("Agregar");
        btnAgregarNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarNivelActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel4.setText("Experiencia: ");

        btnEliminarTema.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnEliminarTema.setText("Eliminar");
        btnEliminarTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTemaActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(ListaTemas);

        btnCancelar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnRegistrar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel5.setText("Postulante : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CbTemas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(SpNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAgregarNivel))
                                    .addComponent(txtPost))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminarTema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPost))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CbTemas, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(SpNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarNivel))
                .addGap(17, 17, 17)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarTema))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnCancelar))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        setBounds(450, 0, 413, 368);
    }// </editor-fold>//GEN-END:initComponents


    private void btnEliminarTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTemaActionPerformed
        // TODO add your handling code here:

        if (ListaTemas.getSelectedValue() != null) {
            String temaAeliminar = String.valueOf(ListaTemas.getSelectedValue().toString().charAt(0));
            temas = modelo.removeTemaNiv(temaAeliminar, temas);
            LlenarListaTemas(temas);
        } else {
            JOptionPane.showMessageDialog(null, "No se selecciono ningun tema");
        }

    }//GEN-LAST:event_btnEliminarTemaActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        DefaultListModel<String> modeloExperiencia = new DefaultListModel<>();
        ListaTemas.setModel(modeloExperiencia); // seteo la lista en default para poder usar removeAllElements()  
        modeloExperiencia.removeAllElements();

        txtPost.setText("");
        modelo.addPostulante(postulante);
        ant.limpiarCamposTexto();

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnAgregarNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarNivelActionPerformed
        // TODO add your handling code here:

        Tema tema = (Tema) CbTemas.getSelectedItem();
        int nivel = (int) SpNivel.getValue();
        if (tema != null) {
            temas.put(tema, nivel);
            postulante.setExperiencia(temas);
            LlenarListaTemas(temas);
        } else {
            JOptionPane.showMessageDialog(null, "No se selecciono ningun tema");
        }

    }//GEN-LAST:event_btnAgregarNivelActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public void LlenarComobo() {

        ArrayList<Tema> temas = modelo.getTemas();

        if (!temas.isEmpty()) { // para que cuando agregue el primer tema no se elimine del combo
            CbTemas.removeAllItems();
        }

        for (Tema tema : temas) {
            CbTemas.addItem(tema);
        }
    }

    public void LlenarListaTemas(HashMap<Tema, Integer> temas) {
        ListaTemas.setListData(postulante.mostrarExperiencia(temas).toArray());
    }

    public void setPostulante(Postulante unPostulante, PostulanteAltaReg anterior) {
        postulante = unPostulante;
        ant = anterior;
        txtPost.setText("" + unPostulante);

    }

    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NivelReg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CbTemas;
    private javax.swing.JList ListaTemas;
    private javax.swing.JSpinner SpNivel;
    private javax.swing.JButton btnAgregarNivel;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarTema;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel txtPost;
    // End of variables declaration//GEN-END:variables

}
