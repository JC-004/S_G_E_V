package vista;

import javax.swing.ImageIcon;


public class vistaENTRADA extends javax.swing.JFrame {

    
    public vistaENTRADA() {
        initComponents();
        setLocationRelativeTo(this);
        setIconImage(new ImageIcon("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\src\\main\\java\\imagenes\\entrada.png").getImage());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbxVehiculo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtZona = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        btnREGRESAR = new javax.swing.JButton();
        btnLIMPIAR = new javax.swing.JButton();
        btnREGISTRAR = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbxPiso = new javax.swing.JComboBox<>();
        cbxCLIENTE = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbxEmpleado = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        txtID_ENTRADA = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cbxDOCUMENTO = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar entrada de un Vehiculo");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Registrar Entrada de Vehiculos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel2.setText("ID Vehiculo:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));
        getContentPane().add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, 120, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel3.setText("Tipo de documento:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, -1, -1));

        getContentPane().add(cbxVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 120, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel4.setText("Piso:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel5.setText("Zona:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));
        getContentPane().add(txtZona, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 120, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel6.setText("Fecha de Ingreso:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 120, -1));

        btnREGRESAR.setBackground(new java.awt.Color(0, 204, 0));
        btnREGRESAR.setText("REGRESAR");
        getContentPane().add(btnREGRESAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 530, 120, 50));

        btnLIMPIAR.setBackground(new java.awt.Color(102, 102, 102));
        btnLIMPIAR.setText("LIMPIAR");
        getContentPane().add(btnLIMPIAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, 120, 50));

        btnREGISTRAR.setBackground(new java.awt.Color(204, 0, 204));
        btnREGISTRAR.setText("REGISTRAR");
        getContentPane().add(btnREGISTRAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 530, 120, 50));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel7.setText("<html>Descripcion: (OPCIONAL)</html>");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 90, -1));

        cbxPiso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-3", "-2", "-1", "0", "1", "2", "3" }));
        cbxPiso.setSelectedIndex(-1);
        getContentPane().add(cbxPiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 120, -1));

        getContentPane().add(cbxCLIENTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 120, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel8.setText("ID Registro:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        getContentPane().add(cbxEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 120, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel9.setText("ID Cliente:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, 140));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel10.setText("ID Empleado:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));
        getContentPane().add(txtID_ENTRADA, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 40, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel11.setText("Hora de ingreso:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, -1, -1));

        cbxDOCUMENTO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boleta", "Factura" }));
        cbxDOCUMENTO.setSelectedIndex(-1);
        getContentPane().add(cbxDOCUMENTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 500, 120, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnLIMPIAR;
    public javax.swing.JButton btnREGISTRAR;
    public javax.swing.JButton btnREGRESAR;
    public javax.swing.JComboBox<String> cbxCLIENTE;
    public javax.swing.JComboBox<String> cbxDOCUMENTO;
    public javax.swing.JComboBox<String> cbxEmpleado;
    public javax.swing.JComboBox<String> cbxPiso;
    public javax.swing.JComboBox<String> cbxVehiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea txtDescripcion;
    public javax.swing.JTextField txtFecha;
    public javax.swing.JTextField txtHora;
    public javax.swing.JTextField txtID_ENTRADA;
    public javax.swing.JTextField txtZona;
    // End of variables declaration//GEN-END:variables
}
