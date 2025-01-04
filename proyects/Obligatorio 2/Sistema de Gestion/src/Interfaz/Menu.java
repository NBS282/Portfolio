
package Interfaz;
/**
 * @authors NICOLAS BIDENTI (305108) - MATTEO QUAGLIATA (298144)
 */

import Dominio.*;
import Interfaz.EntrevistaReg;
import Interfaz.EvaluadorReg;
import Interfaz.HistorialPostCons;


public class Menu extends javax.swing.JFrame {
   
    private Sistema modelo;
    
    public Menu() {
        initComponents();
    }
    
     public Menu(Sistema unSistema) {
        initComponents();
        modelo = unSistema;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        itmPuestoCons = new javax.swing.JMenuItem();
        itmTematicaCons = new javax.swing.JMenuItem();
        itmHistPostCons = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        itmTematicaReg = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        itmAltaPost = new javax.swing.JMenuItem();
        itmBajaPost = new javax.swing.JMenuItem();
        itmEvaluador = new javax.swing.JMenuItem();
        itmEntrevista = new javax.swing.JMenuItem();
        itmPuestoReg = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion de Personal");

        fileMenu.setMnemonic('f');
        fileMenu.setText("Consultas ");

        itmPuestoCons.setText("Puesto");
        itmPuestoCons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmPuestoConsActionPerformed(evt);
            }
        });
        fileMenu.add(itmPuestoCons);

        itmTematicaCons.setText("Tematica");
        itmTematicaCons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmTematicaConsActionPerformed(evt);
            }
        });
        fileMenu.add(itmTematicaCons);

        itmHistPostCons.setText("Historia de Postulante");
        itmHistPostCons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmHistPostConsActionPerformed(evt);
            }
        });
        fileMenu.add(itmHistPostCons);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Registros");

        itmTematicaReg.setText("Tematica");
        itmTematicaReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmTematicaRegActionPerformed(evt);
            }
        });
        editMenu.add(itmTematicaReg);

        jMenu1.setText("Postulante");

        itmAltaPost.setText("Alta");
        itmAltaPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmAltaPostActionPerformed(evt);
            }
        });
        jMenu1.add(itmAltaPost);

        itmBajaPost.setText("Baja");
        itmBajaPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmBajaPostActionPerformed(evt);
            }
        });
        jMenu1.add(itmBajaPost);

        editMenu.add(jMenu1);

        itmEvaluador.setText("Evaluador");
        itmEvaluador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmEvaluadorActionPerformed(evt);
            }
        });
        editMenu.add(itmEvaluador);

        itmEntrevista.setText("Entrevista");
        itmEntrevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmEntrevistaActionPerformed(evt);
            }
        });
        editMenu.add(itmEntrevista);

        itmPuestoReg.setText("Puesto");
        itmPuestoReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmPuestoRegActionPerformed(evt);
            }
        });
        editMenu.add(itmPuestoReg);

        menuBar.add(editMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 115, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(424, 146));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void itmTematicaRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmTematicaRegActionPerformed
        // TODO add your handling code here:
        TematicaReg treg = new TematicaReg(modelo);
        treg.setVisible(true);
    }//GEN-LAST:event_itmTematicaRegActionPerformed

    private void itmAltaPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmAltaPostActionPerformed
        // TODO add your handling code here:
        PostulanteAltaReg pareg = new PostulanteAltaReg(modelo);
        pareg.setVisible(true);
    }//GEN-LAST:event_itmAltaPostActionPerformed

    private void itmBajaPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmBajaPostActionPerformed
        // TODO add your handling code here:
        PostulanteBajaReg pbreg = new PostulanteBajaReg(modelo);
        pbreg.setVisible(true);
    }//GEN-LAST:event_itmBajaPostActionPerformed

    private void itmEvaluadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmEvaluadorActionPerformed
        // TODO add your handling code here:
        EvaluadorReg evreg = new EvaluadorReg(modelo);
        evreg.setVisible(true);
    }//GEN-LAST:event_itmEvaluadorActionPerformed

    private void itmEntrevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmEntrevistaActionPerformed
        // TODO add your handling code here:
        EntrevistaReg entreg = new EntrevistaReg(modelo);
        entreg.setVisible(true);
    }//GEN-LAST:event_itmEntrevistaActionPerformed

    private void itmPuestoRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmPuestoRegActionPerformed
        // TODO add your handling code here:
        PuestoReg preg = new PuestoReg(modelo);
        preg.setVisible(true);
    }//GEN-LAST:event_itmPuestoRegActionPerformed

    private void itmPuestoConsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmPuestoConsActionPerformed
        // TODO add your handling code here:
        PuestoCons pcons = new PuestoCons(modelo);
        pcons.setVisible(true);
    }//GEN-LAST:event_itmPuestoConsActionPerformed

    private void itmTematicaConsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmTematicaConsActionPerformed
        // TODO add your handling code here:
        TematicaCons tcons = new TematicaCons(modelo);
        tcons.setVisible(true);
    }//GEN-LAST:event_itmTematicaConsActionPerformed

    private void itmHistPostConsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmHistPostConsActionPerformed
        // TODO add your handling code here:
        HistorialPostCons hpcons = new HistorialPostCons(modelo);
        hpcons.setVisible(true);
    }//GEN-LAST:event_itmHistPostConsActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem itmAltaPost;
    private javax.swing.JMenuItem itmBajaPost;
    private javax.swing.JMenuItem itmEntrevista;
    private javax.swing.JMenuItem itmEvaluador;
    private javax.swing.JMenuItem itmHistPostCons;
    private javax.swing.JMenuItem itmPuestoCons;
    private javax.swing.JMenuItem itmPuestoReg;
    private javax.swing.JMenuItem itmTematicaCons;
    private javax.swing.JMenuItem itmTematicaReg;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
