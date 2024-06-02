
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class ListaDepartamento extends javax.swing.JFrame {

    public ListaDepartamento() {
        initComponents();
        try {
            //* 1- conectar com banco de daos   
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conectado = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Gabriel741");
            // 2- buscar todos os usuarios cadastrados na tabela
            PreparedStatement st = conectado.prepareStatement("SELECT * FROM departamento");
            ResultSet Departamento = st.executeQuery(); // Executa o Select 
            DefaultTableModel tblModelo = (DefaultTableModel) tblListaDepartamento.getModel();
            while (Departamento.next()) {
                String linha[] = {
                    Departamento.getString("ID"),
                    Departamento.getString("Nome"),
                    Departamento.getString("Telefone"),
                    Departamento.getString("Cidade"),
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

        jScrollPane2 = new javax.swing.JScrollPane();
        tblListaDepartamento = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem departamento");
        getContentPane().setLayout(null);

        tblListaDepartamento.setBackground(new java.awt.Color(204, 153, 255));
        tblListaDepartamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Telefone", "Cidade"
            }
        ));
        jScrollPane2.setViewportView(tblListaDepartamento);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(0, 0, 390, 150);

        setSize(new java.awt.Dimension(405, 156));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ListaDepartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaDepartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaDepartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaDepartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaDepartamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblListaDepartamento;
    // End of variables declaration//GEN-END:variables
}
