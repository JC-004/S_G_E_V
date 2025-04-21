
package vista;

import javax.swing.ImageIcon;


public class vistaSALIDA extends javax.swing.JFrame {

    
    public vistaSALIDA() {
        initComponents();
        setLocationRelativeTo(this);
        setIconImage(new ImageIcon("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\src\\main\\java\\imagenes\\salida.png").getImage());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        btnREGRESAR = new javax.swing.JButton();
        btnLIMPIAR = new javax.swing.JButton();
        btnREGISTRAR = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxEmpleado = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCLIENTE = new javax.swing.JTextField();
        txtVEHICULO = new javax.swing.JTextField();
        cbxENTRADA = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtID_SALIDA = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("registrar salida de un vehiculo");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Registrar Salida de Vehiculos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel2.setText("ID Vehiculo:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));
        getContentPane().add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, 120, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel6.setText("Fecha de Salida:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 120, -1));

        btnREGRESAR.setBackground(new java.awt.Color(0, 204, 0));
        btnREGRESAR.setText("REGRESAR");
        getContentPane().add(btnREGRESAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, 120, 50));

        btnLIMPIAR.setBackground(new java.awt.Color(102, 102, 102));
        btnLIMPIAR.setText("LIMPIAR");
        getContentPane().add(btnLIMPIAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 120, 50));

        btnREGISTRAR.setBackground(new java.awt.Color(204, 0, 204));
        btnREGISTRAR.setText("REGISTRAR");
        getContentPane().add(btnREGISTRAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, 120, 50));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel7.setText("<html>Descripcion: (OPCIONAL)</html>");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 90, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel8.setText("ID Salida:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 70, 30));

        getContentPane().add(cbxEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 120, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel9.setText("ID Cliente:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, 140));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel10.setText("ID Empleado:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel11.setText("Hora de Salida:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        txtCLIENTE.setEditable(false);
        txtCLIENTE.setBackground(new java.awt.Color(255, 255, 0));
        txtCLIENTE.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtCLIENTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 120, -1));

        txtVEHICULO.setEditable(false);
        txtVEHICULO.setBackground(new java.awt.Color(255, 255, 0));
        txtVEHICULO.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtVEHICULO, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 120, -1));

        getContentPane().add(cbxENTRADA, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 120, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel12.setText("ID Entrada:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 100, 40));

        txtID_SALIDA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(txtID_SALIDA, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 30, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnLIMPIAR;
    public javax.swing.JButton btnREGISTRAR;
    public javax.swing.JButton btnREGRESAR;
    public javax.swing.JComboBox<String> cbxENTRADA;
    public javax.swing.JComboBox<String> cbxEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField txtCLIENTE;
    public javax.swing.JTextArea txtDescripcion;
    public javax.swing.JTextField txtFecha;
    public javax.swing.JTextField txtHora;
    public javax.swing.JTextField txtID_SALIDA;
    public javax.swing.JTextField txtVEHICULO;
    // End of variables declaration//GEN-END:variables
}
