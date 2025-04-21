package vista;

import imagenes.JPanelImage;
import java.awt.Color;
import javax.swing.ImageIcon;


public class Vista extends javax.swing.JFrame {

    
    public Vista() {
        initComponents();
        setLocationRelativeTo(this);
        
        //cambiar el icono por defecto de NETBEANS        
        setIconImage(new ImageIcon("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\src\\main\\java\\imagenes\\estacionamiento.png").getImage());
        
        
        //jpIMAGEN 
        String absolutePath = "C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\src\\main\\java\\imagenes\\carro.png";
        JPanelImage img = new JPanelImage(jpIMAGEN, absolutePath);
        jpIMAGEN.add(img);
        jpIMAGEN.repaint();
        jpIMAGEN.setOpaque(false);
        jpIMAGEN.setBorder(null);
        jpIMAGEN.setBackground(new Color(0, 0, 0, 0));
    }
    
    
    


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnREGISTRAR_ENTRADA = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jpIMAGEN = new javax.swing.JPanel();
        btnREGISTRAR_SALIDA = new javax.swing.JButton();
        brrMENU = new javax.swing.JMenuBar();
        menuRegistrar = new javax.swing.JMenu();
        Empleado = new javax.swing.JMenuItem();
        Cliente = new javax.swing.JMenuItem();
        Vehiculo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        Salir = new javax.swing.JMenuItem();
        menuMostrar = new javax.swing.JMenu();
        mostrarEMPLEADOS = new javax.swing.JMenuItem();
        mostrarCLIENTES = new javax.swing.JMenuItem();
        mostrarVEHICULOS = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mostrarENTRADAS = new javax.swing.JMenuItem();
        mostrarSALIDAS = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gestión de Estacionamiento de Vehículos");
        setResizable(false);

        btnREGISTRAR_ENTRADA.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        btnREGISTRAR_ENTRADA.setText("<html>Registrar entrada</html>");

        jLabel2.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("<html>SISTEMA DE GESTIÓN DE ESTACIONAMIENTO DE VEHICULOS</html>");

        javax.swing.GroupLayout jpIMAGENLayout = new javax.swing.GroupLayout(jpIMAGEN);
        jpIMAGEN.setLayout(jpIMAGENLayout);
        jpIMAGENLayout.setHorizontalGroup(
            jpIMAGENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
        );
        jpIMAGENLayout.setVerticalGroup(
            jpIMAGENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 189, Short.MAX_VALUE)
        );

        btnREGISTRAR_SALIDA.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        btnREGISTRAR_SALIDA.setText("<html>Registrar salida</html>");

        brrMENU.setBackground(new java.awt.Color(255, 204, 51));
        brrMENU.setForeground(new java.awt.Color(255, 0, 102));

        menuRegistrar.setIcon(new javax.swing.ImageIcon("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\src\\main\\java\\imagenes\\registrar.png"));
        menuRegistrar.setText("Registrar");
        menuRegistrar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        Empleado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Empleado.setIcon(new javax.swing.ImageIcon("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\src\\main\\java\\imagenes\\empleado.png"));
        Empleado.setText("Empleado");
        Empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpleadoActionPerformed(evt);
            }
        });
        menuRegistrar.add(Empleado);

        Cliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Cliente.setIcon(new javax.swing.ImageIcon("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\src\\main\\java\\imagenes\\cliente.png"));
        Cliente.setText("Cliente");
        Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteActionPerformed(evt);
            }
        });
        menuRegistrar.add(Cliente);

        Vehiculo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Vehiculo.setIcon(new javax.swing.ImageIcon("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\src\\main\\java\\imagenes\\vehiculo.png"));
        Vehiculo.setText("Vehiculo");
        Vehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VehiculoActionPerformed(evt);
            }
        });
        menuRegistrar.add(Vehiculo);
        menuRegistrar.add(jSeparator1);

        Salir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Salir.setIcon(new javax.swing.ImageIcon("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\src\\main\\java\\imagenes\\salir.png"));
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        menuRegistrar.add(Salir);

        brrMENU.add(menuRegistrar);

        menuMostrar.setIcon(new javax.swing.ImageIcon("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\src\\main\\java\\imagenes\\tabla.png"));
        menuMostrar.setText("Mostrar");
        menuMostrar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        mostrarEMPLEADOS.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mostrarEMPLEADOS.setIcon(new javax.swing.ImageIcon("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\src\\main\\java\\imagenes\\empleado.png"));
        mostrarEMPLEADOS.setText("Empleados");
        mostrarEMPLEADOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarEMPLEADOSActionPerformed(evt);
            }
        });
        menuMostrar.add(mostrarEMPLEADOS);

        mostrarCLIENTES.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mostrarCLIENTES.setIcon(new javax.swing.ImageIcon("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\src\\main\\java\\imagenes\\cliente.png"));
        mostrarCLIENTES.setText("Clientes");
        mostrarCLIENTES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarCLIENTESActionPerformed(evt);
            }
        });
        menuMostrar.add(mostrarCLIENTES);

        mostrarVEHICULOS.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mostrarVEHICULOS.setIcon(new javax.swing.ImageIcon("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\src\\main\\java\\imagenes\\vehiculo.png"));
        mostrarVEHICULOS.setText("Vehiculos");
        menuMostrar.add(mostrarVEHICULOS);
        menuMostrar.add(jSeparator2);

        mostrarENTRADAS.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mostrarENTRADAS.setIcon(new javax.swing.ImageIcon("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\src\\main\\java\\imagenes\\entrada.png"));
        mostrarENTRADAS.setText("Entradas");
        menuMostrar.add(mostrarENTRADAS);

        mostrarSALIDAS.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mostrarSALIDAS.setIcon(new javax.swing.ImageIcon("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\src\\main\\java\\imagenes\\salida.png"));
        mostrarSALIDAS.setText("Salidas");
        menuMostrar.add(mostrarSALIDAS);

        brrMENU.add(menuMostrar);

        setJMenuBar(brrMENU);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jpIMAGEN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(btnREGISTRAR_ENTRADA, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnREGISTRAR_SALIDA, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jpIMAGEN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnREGISTRAR_ENTRADA, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnREGISTRAR_SALIDA, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_SalirActionPerformed

    private void EmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpleadoActionPerformed
        
    }//GEN-LAST:event_EmpleadoActionPerformed

    private void ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteActionPerformed
        
        
    }//GEN-LAST:event_ClienteActionPerformed

    private void mostrarEMPLEADOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarEMPLEADOSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mostrarEMPLEADOSActionPerformed

    private void mostrarCLIENTESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarCLIENTESActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mostrarCLIENTESActionPerformed

    private void VehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VehiculoActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem Cliente;
    public javax.swing.JMenuItem Empleado;
    public javax.swing.JMenuItem Salir;
    public javax.swing.JMenuItem Vehiculo;
    public javax.swing.JMenuBar brrMENU;
    public javax.swing.JButton btnREGISTRAR_ENTRADA;
    public javax.swing.JButton btnREGISTRAR_SALIDA;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPanel jpIMAGEN;
    public javax.swing.JMenu menuMostrar;
    public javax.swing.JMenu menuRegistrar;
    public javax.swing.JMenuItem mostrarCLIENTES;
    public javax.swing.JMenuItem mostrarEMPLEADOS;
    public javax.swing.JMenuItem mostrarENTRADAS;
    public javax.swing.JMenuItem mostrarSALIDAS;
    public javax.swing.JMenuItem mostrarVEHICULOS;
    // End of variables declaration//GEN-END:variables
}
