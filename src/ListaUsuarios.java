
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class ListaUsuarios extends javax.swing.JFrame {

    public ListaUsuarios() {
        initComponents();
        try {
            //* 1- conectar com banco de daos   
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conectado = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Gabriel741");
            // 2- buscar todos os usuarios cadastrados na tabela
            PreparedStatement st = conectado.prepareStatement("SELECT * FROM usuarios");
            ResultSet usuarios = st.executeQuery(); // Executa o Select 
            DefaultTableModel tblModelo = (DefaultTableModel) tblListaUsuarios.getModel();
            while (usuarios.next()) {
                String linha[] = {
                    usuarios.getString("usuario"),
                    usuarios.getString("senha"),
                    usuarios.getString("cargo")
                };
                tblModelo.addRow(linha);
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "driver não colocado no library");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no dados do banco de dados" + ex.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaUsuarios = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        cmbCargo3 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de usuários");
        getContentPane().setLayout(null);

        tblListaUsuarios.setBackground(new java.awt.Color(204, 153, 255));
        tblListaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuário", "Senha", "Cargo"
            }
        ));
        tblListaUsuarios.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tblListaUsuarios.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tblListaUsuarios);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 130, 400, 140);

        jLabel7.setFont(new java.awt.Font("Dubai", 2, 18)); // NOI18N
        jLabel7.setText("Cargo:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 30, 110, 80);

        cmbCargo3.setBackground(new java.awt.Color(204, 0, 204));
        cmbCargo3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gerente", "Estagiario", "Vendedor", "Analista" }));
        cmbCargo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCargo3ActionPerformed(evt);
            }
        });
        getContentPane().add(cmbCargo3);
        cmbCargo3.setBounds(110, 60, 85, 30);

        setSize(new java.awt.Dimension(413, 273));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCargo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCargo3ActionPerformed
        // Pegar cargo selecionado nesta caixa 
        String c ;
        c = cmbCargo3.getSelectedItem().toString();
        try {
            //* 1- conectar com banco de daos   
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conectado = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Gabriel741");
            // 2- buscar todos os usuarios cadastrados na tabela
            PreparedStatement st = conectado.prepareStatement("SELECT * FROM usuarios where cargo =?");
            st.setString(1, c);
            ResultSet usuarios = st.executeQuery(); // Executa o Select 
            DefaultTableModel tblModelo = (DefaultTableModel) tblListaUsuarios.getModel();
            tblModelo.setRowCount(0);// Limpar tabela
            while (usuarios.next()) {
                String linha[] = {
                    usuarios.getString("usuario"),
                    usuarios.getString("senha"),
                    usuarios.getString("cargo")
                };
                tblModelo.addRow(linha);
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "driver não colocado no library");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no dados do banco de dados" + ex.getMessage());
        }
        
    }//GEN-LAST:event_cmbCargo3ActionPerformed

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
                java.util.logging.Logger.getLogger(ListaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(ListaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(ListaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(ListaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ListaUsuarios().setVisible(true);
                }
            });
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbCargo3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListaUsuarios;
    // End of variables declaration//GEN-END:variables
}
