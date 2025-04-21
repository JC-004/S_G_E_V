package vista;

import javax.swing.ImageIcon;


public class mostrarCLIENTES extends javax.swing.JFrame {        
    
    public mostrarCLIENTES() {
        initComponents();
        setLocationRelativeTo(this);
        setIconImage(new ImageIcon("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\src\\main\\java\\imagenes\\cliente.png").getImage());
        //cargando el modelo de la tabla        
    }
    
                    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCLIENTES = new javax.swing.JTable();
        btnREGRESAR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mostrando clientes registrados");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Mostrando Clientes existentes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        tablaCLIENTES.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaCLIENTES);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 59, 1200, 317));

        btnREGRESAR.setBackground(new java.awt.Color(0, 153, 0));
        btnREGRESAR.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        btnREGRESAR.setForeground(new java.awt.Color(255, 255, 255));
        btnREGRESAR.setText("regresar");
        getContentPane().add(btnREGRESAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 450, 146, 52));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnREGRESAR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablaCLIENTES;
    // End of variables declaration//GEN-END:variables

    
}
