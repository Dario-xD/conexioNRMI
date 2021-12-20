/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;
import interfaz.InterfaceRmi;
import java.rmi.NotBoundException;
import java.rmi.AccessException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Clientes extends javax.swing.JFrame {
    
    Registry r;
    InterfaceRmi i;

    /**
     * Creates new form Clientes
     */
    public Clientes() {
        try {
            initComponents();
            r = LocateRegistry.getRegistry("192.168.56.1",5000);
            try {
                i = (InterfaceRmi) r.lookup("Calculadora");
            } catch (NotBoundException ex) {
                error();
            } catch (AccessException e) {
            error();
        }
        txtresultado.setEditable(false);
        setLocationRelativeTo(null);
        setResizable(false);
        
    }catch(RemoteException ex){
    error();
}
    }
    private void error(){
        JOptionPane.showMessageDialog(this, "El servidor no esta disponible");
        System.exit(0);
    }
    private void mensaje (String cadena){
        JOptionPane.showMessageDialog(this, cadena);
        
    }
    public boolean regEx(String valor){
       return valor.matches("^\\d*\\.?\\d{1,2}$");
    }
    public boolean validar(){
        boolean bnd = false;
        if("".equals(txtnumero1.getText())){
            mensaje ("Introduzca un numero en el campo 1");
            txtnumero1.requestFocus();
        }else if(!regEx(txtnumero1.getText())){
            mensaje ("el campo numero 1 debe ser numerico has con decimales");
            txtnumero1.requestFocus();
        }else if("".equals(txtnumero2.getText())){
            mensaje ("Introduzca un numero en el campo 2");
            txtnumero2.requestFocus();
        }else if(!regEx(txtnumero2.getText())){
            mensaje ("el campo numero 2 debe ser numerico has con decimales");
            txtnumero2.requestFocus();
    }else bnd = true;
        return bnd;
            
        }
    
    public void ejecutar(String accion){
        if(validar()){
            try {
                double r=0;
                double n1 = Double.parseDouble(txtnumero1.getText());
                double n2 = Double.parseDouble(txtnumero2.getText());
                switch(accion){ //usamos un switc case para llamar por caracteres las referencias que pusimos en la interfcaermi
                    case "sumar":r=i.sumar(n1, n2);
                    break;
                    case "restar":r=i.restar(n1, n2);
                    break;
                    case "multiplicar":r=i.multiplicar(n1, n2);
                    break;
                    case "dividir":r=i.dividir(n1, n2);
                    break;
                }
                DecimalFormat df = new DecimalFormat("#.00");
                txtresultado.setText(df.format(r));
            } catch (Exception ex) {
                Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnumero1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnumero2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtresultado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_mas = new javax.swing.JButton();
        btn_menos = new javax.swing.JButton();
        btn_multi = new javax.swing.JButton();
        btn_divi = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("CALCULADORA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2.setText("Numero 1");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        getContentPane().add(txtnumero1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 70, -1));

        jLabel3.setText("Numero 2");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));
        getContentPane().add(txtnumero2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 70, -1));

        jLabel4.setText("Resultado");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));
        getContentPane().add(txtresultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 70, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel5.setText("OPERACIONES");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 90, -1));

        btn_mas.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        btn_mas.setText("+");
        btn_mas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_masActionPerformed(evt);
            }
        });
        getContentPane().add(btn_mas, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, -1));

        btn_menos.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        btn_menos.setText("-");
        btn_menos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menosActionPerformed(evt);
            }
        });
        getContentPane().add(btn_menos, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 50, -1));

        btn_multi.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        btn_multi.setText("*");
        btn_multi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_multiActionPerformed(evt);
            }
        });
        getContentPane().add(btn_multi, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, -1, -1));

        btn_divi.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        btn_divi.setText("/");
        btn_divi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_diviActionPerformed(evt);
            }
        });
        getContentPane().add(btn_divi, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, -1));

        btn_limpiar.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        btn_limpiar.setText("LIMPIAR");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_masActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_masActionPerformed
        // TODO add your handling code here:
        ejecutar("sumar");
    }//GEN-LAST:event_btn_masActionPerformed

    private void btn_menosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menosActionPerformed
        // TODO add your handling code here:
        ejecutar("restar");
    }//GEN-LAST:event_btn_menosActionPerformed

    private void btn_multiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_multiActionPerformed
        // TODO add your handling code here:
        ejecutar("multiplicar");
    }//GEN-LAST:event_btn_multiActionPerformed

    private void btn_diviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_diviActionPerformed
        // TODO add your handling code here:
        ejecutar("dividir");
    }//GEN-LAST:event_btn_diviActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        // TODO add your handling code here:
        txtnumero1.setText("");
        txtnumero2.setText("");
        txtresultado.setText("");
    }//GEN-LAST:event_btn_limpiarActionPerformed

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
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_divi;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_mas;
    private javax.swing.JButton btn_menos;
    private javax.swing.JButton btn_multi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtnumero1;
    private javax.swing.JTextField txtnumero2;
    private javax.swing.JTextField txtresultado;
    // End of variables declaration//GEN-END:variables
}
