package service;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Empleado;
import modelo.REGISTRO_ENTRADAS_SALIDAS;
import modelo.Vehiculo;
import vista.vistaCLIENTE;
import vista.vistaEMPLEADO;
import vista.vistaENTRADA;
import vista.vistaSALIDA;
import vista.vistaVEHICULO;



public class Service {
    
    File archivo;
                    
    
    
    //---------------------------------------------------EMPLEADOS--------------------------------------------------------------------------------------------------------
    /*Metodo para verificar en registro de
    EMPLEADOS*/
    public void verificarEMPLEADOS(vistaEMPLEADO vemp){
        
        
        
        
        
        if(vemp.cbxNACIONALIDAD.getSelectedIndex()==0){
            vemp.jlDNI.setVisible(false);
            vemp.txtDNI.setVisible(false);
            
            
            vemp.jlRESIDENTE.setVisible(false);
            vemp.rbtnSI.setVisible(false);
            vemp.rbtnNO.setVisible(false);
            
            vemp.jlCARNET.setVisible(false);
            vemp.jlPASAPORTE.setVisible(false);            
            vemp.txtEXTRANJERIA.setVisible(false);
            vemp.txtPASAPORTE.setVisible(false);
            
            vemp.btnGRP_ASOCIACION.clearSelection();
        }
        else if(vemp.cbxNACIONALIDAD.getSelectedIndex()==1){
            vemp.jlDNI.setVisible(true);
            vemp.txtDNI.setVisible(true);
            
            vemp.jlRESIDENTE.setVisible(false);
            vemp.rbtnSI.setVisible(false);
            vemp.rbtnNO.setVisible(false);
            
            vemp.jlCARNET.setVisible(false);
            vemp.jlPASAPORTE.setVisible(false);            
            vemp.txtEXTRANJERIA.setVisible(false);
            vemp.txtPASAPORTE.setVisible(false);
            
            vemp.btnGRP_ASOCIACION.clearSelection();
        }
        else if(vemp.cbxNACIONALIDAD.getSelectedIndex() == 2){//en el caso de que sea extranjero
            
            vemp.btnGRP_ASOCIACION.clearSelection();
            
            
            vemp.jlDNI.setVisible(false);
            vemp.txtDNI.setVisible(false);
            
            
            
            vemp.jlRESIDENTE.setVisible(true);
            vemp.rbtnSI.setVisible(true);
            vemp.rbtnNO.setVisible(true);
            
            
            
            vemp.jlCARNET.setVisible(false);
            vemp.jlPASAPORTE.setVisible(false);            
            vemp.txtEXTRANJERIA.setVisible(false);
            vemp.txtPASAPORTE.setVisible(false);
            
        }
        
    }
    
    //metodo para verificar el estado de los radiobotones 
    public void radioBOTONES(vistaEMPLEADO vemp){
        if(vemp.rbtnSI.isSelected()){//CARNET DE EXTRANJERIA
            
            vemp.jlCARNET.setVisible(true);
            vemp.jlPASAPORTE.setVisible(false);
            
            vemp.txtEXTRANJERIA.setVisible(true);
            vemp.txtPASAPORTE.setVisible(false);
            
            
        }else if(vemp.rbtnNO.isSelected()){//PASAPORTE
            
            vemp.jlPASAPORTE.setVisible(true);
            vemp.jlCARNET.setVisible(false);
            
            
            vemp.txtPASAPORTE.setVisible(true);
            vemp.txtEXTRANJERIA.setVisible(false);
            
            
        }
        
    }
                                                            
    //metodo para verificar que los campos a ingresar no esten vacios
    public void verificarCAMPOS(vistaEMPLEADO vemp){
        
        try {
            //CAMPOS GENERALES QUE NO PUEDEN ESTAR VACIOS
            if(        vemp.txtID_EMPLEADO.getText().isEmpty()
                    || vemp.cbxNACIONALIDAD.getSelectedIndex()==-1
                    || vemp.txtN_A.getText().isEmpty()
                    || vemp.cbxSEXO.getSelectedIndex() ==-1                   
                    || verificarFECHA(vemp.txtFECHA)==false
                    || vemp.txtTELEFONO.getText().isEmpty()
                    || vemp.txtCORREO.getText().isEmpty()
                    || vemp.txtDIRECCION.getText().isEmpty()
                    || vemp.txtDISTRITO.getText().isEmpty()       ){
                    JOptionPane.showMessageDialog(null, "NO DEJE CAMPOS VACIOS");                                                                
            }else{//si los campos generales no estan vacios pasamos a los particulares
                // YA FECHA YA ESTA CORRECTA EN ESTE PUNTO
                
                try {
                    int ID =  Integer.parseInt(vemp.txtID_EMPLEADO.getText());
                    if(ID<0){
                        JOptionPane.showMessageDialog(null, "El ID del empleado debe ser mayor o igual a 0");
                        return;
                    }
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "El id debe ser un numero entero");
                    return;
                }
                //-----------------------------verifamos que el id ingresado no sea duplicado---------------------------
                if (!verificarIdLibre_EMPLEADO(vemp.txtID_EMPLEADO)) {
                    // Si la función devuelve FALSE, significa que el ID YA EXISTE o hubo un error.
                    JOptionPane.showMessageDialog(null,
                            "El ID de empleado '" + vemp.txtID_EMPLEADO.getText() + "' ya existe o no se pudo verificar.\nIngrese un ID diferente.",
                            "ID No Disponible", JOptionPane.WARNING_MESSAGE);
                    return; // Detener el proceso de registro
                }
                
                
                
                
                if(vemp.cbxNACIONALIDAD.getSelectedIndex()==0){//No especifico su nacionalidad
                    guardarDESCONOCIDO(vemp);
                }                                
                else if(vemp.cbxNACIONALIDAD.getSelectedIndex() == 1){//es peruano
                    if(vemp.txtDNI.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "NO DEJE CAMPOS VACIOS");
                    }else{
                        guardarPERUANO(vemp);
                    }
                }
                else if(vemp.cbxNACIONALIDAD.getSelectedIndex() ==2){//es extranjero 
                    
                    if(vemp.rbtnSI.isSelected()==false && vemp.rbtnNO.isSelected()==false ){
                        JOptionPane.showMessageDialog(null, "NO DEJE CAMPOS VACIOS");
                    }
                    else if(vemp.rbtnSI.isSelected()){//si selecciono 'SI' es residente peruano
                        
                        if(vemp.txtEXTRANJERIA.getText().isEmpty()){//verificar que el campo CARNET EXTRANJERIA
                            JOptionPane.showMessageDialog(null, "NO DEJE CAMPOS VACIOS");
                        }else{
                            guardarEXTRANJERO_RESIDENTE(vemp);
                        }
                        
                    }
                    else if(vemp.rbtnNO.isSelected()){ //Si selecciono 'NO' es Turista
                        if(vemp.txtPASAPORTE.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null, "NO DEJE CAMPOS VACIOS");
                        }else{
                            guardarEXTRANJERO_TURISTA(vemp);
                        }
                        
                    }
                    
                }
                
                
                
                
            }
                
                        
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "error en el catch");
        }
        
    }
                            
    // metodo para verificar la fecha en formato dd/mm/aaaa
    public boolean verificarFECHA(JTextField txtFECHA) {
        try {
            // Verificar si el campo está vacío
            if (txtFECHA.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese una fecha");
                return false;
            }

            // Verificar longitud y formato básico (dd/mm/aaaa)
            String fechaTexto = txtFECHA.getText();
            if (fechaTexto.length() != 10) {
                JOptionPane.showMessageDialog(null, "Ingrese una fecha válida: dd/mm/aaaa");
                return false;
            }

            // Verificar que el formato contiene los separadores correctos
            if (!fechaTexto.matches("\\d{2}/\\d{2}/\\d{4}")) {
                JOptionPane.showMessageDialog(null, "Formato incorrecto. Use dd/mm/aaaa");
                return false;
            }

            // Configurar el formato esperado
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false); // No permite fechas inválidas como 31/04/2023

            // Intentar parsear la fecha
            Date fecha = sdf.parse(fechaTexto);

            // Si llega aquí, la fecha es válida
            return true;

        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error en la interfaz gráfica");
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fecha inválida");
            return false;
        }
    }
            
    
    //------GUARDANDO LOS DATOS DE UN EMPLEADO---------
        
    //metodo para guardar la informaicon en un txt
    public void guardarPERUANO(vistaEMPLEADO vemp){
        
        
        
        //GUARDANDO LOS DATOS GENERALES
        int id = Integer.parseInt(vemp.txtID_EMPLEADO.getText());        
        int nacionalidad = vemp.cbxNACIONALIDAD.getSelectedIndex();
        String dni = vemp.txtDNI.getText();
        //carnet -> NULL          (STRING)
        //pasaporte -> NULL       (STRING)
        
        //residencia -> SI        (STRING)        
        String residencia = vemp.rbtnSI.getText();
        String N_A = vemp.txtN_A.getText();
        int sexo = vemp.cbxSEXO.getSelectedIndex();                
        String fecha_nacimiento = vemp.txtFECHA.getText();
        String telefono = vemp.txtTELEFONO.getText();
        String correo = vemp.txtCORREO.getText();
        String direccion  = vemp.txtDIRECCION.getText();
        String distrito = vemp.txtDISTRITO.getText();
        //Instanciamos a la clase EMPLEADO
        Empleado emp = new Empleado(id,nacionalidad,dni,"-","-",residencia,N_A,sexo,fecha_nacimiento,telefono,correo,direccion,distrito);        
        
        anadirEMPLEADO(emp);
    }
        
    //guardar a un extranjero  RESIDENTE      
    public void guardarEXTRANJERO_RESIDENTE(vistaEMPLEADO vemp){
        
        
        
        //GUARDANDO LOS DATOS GENERALES
        int id = Integer.parseInt(vemp.txtID_EMPLEADO.getText());        
        int nacionalidad = vemp.cbxNACIONALIDAD.getSelectedIndex();
        //String dni -> NULL   (STRING)
        
        //carnet ->           (STRING)
        String carnet = vemp.txtEXTRANJERIA.getText();
        
        //pasaporte -> NULL       (STRING)
        
        
        
        //residencia -> SI        (STRING)        
        String residencia = vemp.rbtnSI.getText();
        
        String N_A = vemp.txtN_A.getText();
        int sexo = vemp.cbxSEXO.getSelectedIndex();                
        String fecha_nacimiento = vemp.txtFECHA.getText();
        String telefono = vemp.txtTELEFONO.getText();
        String correo = vemp.txtCORREO.getText();
        String direccion  = vemp.txtDIRECCION.getText();
        String distrito = vemp.txtDISTRITO.getText();
        
        //Instanciamos a la clase EMPLEADO
        Empleado emp = new Empleado(id,nacionalidad,"-",carnet,"-",residencia,N_A,sexo,fecha_nacimiento,telefono,correo,direccion,distrito);        
        
        anadirEMPLEADO(emp);
    }
    
    //guardar a un extranjero  TURISTA
    public void guardarEXTRANJERO_TURISTA(vistaEMPLEADO vemp){
        
        //GUARDANDO LOS DATOS GENERALES
        int id = Integer.parseInt(vemp.txtID_EMPLEADO.getText());        
        int nacionalidad = vemp.cbxNACIONALIDAD.getSelectedIndex();
        //String dni -> NULL (STRING)
        
        //carnet -> NULL          (STRING)        
        
                
        //pasaporte ->        (STRING)
        String pasaporte = vemp.txtPASAPORTE.getText();
        
        
        //residencia -> NO        (STRING)        
        String residencia = vemp.rbtnNO.getText();
        
        String N_A = vemp.txtN_A.getText();
        int sexo = vemp.cbxSEXO.getSelectedIndex();                
        String fecha_nacimiento = vemp.txtFECHA.getText();
        String telefono = vemp.txtTELEFONO.getText();
        String correo = vemp.txtCORREO.getText();
        String direccion  = vemp.txtDIRECCION.getText();
        String distrito = vemp.txtDISTRITO.getText();
        
        //Instanciamos a la clase EMPLEADO
        Empleado emp = new Empleado(id,nacionalidad,"-","-",pasaporte,residencia,N_A,sexo,fecha_nacimiento,telefono,correo,direccion,distrito);        
        
        anadirEMPLEADO(emp);
        
    }
    
    //guardar 'NO SELEECCIONO SU NACIONALIDAD'
    public void guardarDESCONOCIDO(vistaEMPLEADO vemp){
        
        //GUARDANDO LOS DATOS GENERALES
        int id = Integer.parseInt(vemp.txtID_EMPLEADO.getText());      
        
        int nacionalidad = vemp.cbxNACIONALIDAD.getSelectedIndex();
        
        //String dni -> NULL (STRING) 
        //carnet -> NULL          (STRING)                                
        //pasaporte ->   NULL     (STRING)        
        
        
        //residencia -> SI        (STRING)        
        String residencia = vemp.rbtnSI.getText();
        
        String N_A = vemp.txtN_A.getText();
        int sexo = vemp.cbxSEXO.getSelectedIndex();                
        String fecha_nacimiento = vemp.txtFECHA.getText();
        String telefono = vemp.txtTELEFONO.getText();
        String correo = vemp.txtCORREO.getText();
        String direccion  = vemp.txtDIRECCION.getText();
        String distrito = vemp.txtDISTRITO.getText();
        
        //Instanciamos a la clase EMPLEADO
        Empleado emp = new Empleado(id,nacionalidad,"-","-","-",residencia,N_A,sexo,fecha_nacimiento,telefono,correo,direccion,distrito);        
        
        anadirEMPLEADO(emp);
    }
    
    //-------------------------------GUARDANDO LOS DATOS DE UN EMPLEADO-----------------------------------------------------------------
    //la creacion del archivo
    public void crearARCHIVO() {
        archivo = new File("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\EMPLEADO.txt");

        try {

            if (archivo.createNewFile()) {
                System.out.println("Archivo creado 'EMPLEADO.TXT' correctamente");
            }

        } catch (IOException ex) {
            System.out.println("No se pudo crear el archivo");
            JOptionPane.showMessageDialog(null, "No se pudo crear el archivo");
        }
    }

    //guardar los datos de un EMPLEADO
    public void anadirEMPLEADO(Empleado emp) {
        crearARCHIVO();

        try {
            FileWriter escribir = new FileWriter(archivo, true);
            escribir.write(emp.getIdEmpleado() + "," + emp.getNacionalidad() + ","
                    + emp.getDni() + "," + emp.getCarnetExtranjeria() + "," + emp.getPasaporte() + ","
                    + emp.getResidencia() + "," + emp.getN_A() + "," + emp.getSexo() + ","
                    + emp.getFecha_nacimiento() + "," + emp.getTelefono() + ","
                    + emp.getCorreo() + "," + emp.getDireccion() + ","
                    + emp.getDistrito() + "\r\n");
            escribir.close();
            JOptionPane.showMessageDialog(null, "Empleado anadido correctamente");
        } catch (IOException ex) {
            System.out.println("Error, no se puedo registrar");
            JOptionPane.showMessageDialog(null, "No se pudo registrar error en el catch");
        }

    }
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------
    
    
    
    
    //---------------------------------------------------CLIENTES--------------------------------------------------------------------------------------------------------
    
    
    /* Metodo para verificar en registro de
    CLIENTES
    */
    public void verificarCLIENTES(vistaCLIENTE vclt){
        
        if (vclt.cbxNACIONALIDAD.getSelectedIndex() == 0) {
            vclt.jlDNI.setVisible(false);
            vclt.txtDNI.setVisible(false);

            vclt.jlRESIDENTE.setVisible(false);
            vclt.rbtnSI.setVisible(false);
            vclt.rbtnNO.setVisible(false);

            vclt.jlCARNET.setVisible(false);
            vclt.jlPASAPORTE.setVisible(false);
            vclt.txtEXTRANJERIA.setVisible(false);
            vclt.txtPASAPORTE.setVisible(false);

            vclt.btnGRP_ASOCIACION.clearSelection();
        } else if (vclt.cbxNACIONALIDAD.getSelectedIndex() == 1) {
            vclt.jlDNI.setVisible(true);
            vclt.txtDNI.setVisible(true);

            vclt.jlRESIDENTE.setVisible(false);
            vclt.rbtnSI.setVisible(false);
            vclt.rbtnNO.setVisible(false);

            vclt.jlCARNET.setVisible(false);
            vclt.jlPASAPORTE.setVisible(false);
            vclt.txtEXTRANJERIA.setVisible(false);
            vclt.txtPASAPORTE.setVisible(false);

            vclt.btnGRP_ASOCIACION.clearSelection();
        } else if (vclt.cbxNACIONALIDAD.getSelectedIndex() == 2) {//en el caso de que sea extranjero

            vclt.btnGRP_ASOCIACION.clearSelection();

            vclt.jlDNI.setVisible(false);
            vclt.txtDNI.setVisible(false);

            vclt.jlRESIDENTE.setVisible(true);
            vclt.rbtnSI.setVisible(true);
            vclt.rbtnNO.setVisible(true);

            vclt.jlCARNET.setVisible(false);
            vclt.jlPASAPORTE.setVisible(false);
            vclt.txtEXTRANJERIA.setVisible(false);
            vclt.txtPASAPORTE.setVisible(false);

        }
        
    }
    
    
    //metodo para verificar el estado de los radiobotones
    public void radioBOTONES(vistaCLIENTE vclt){
        if (vclt.rbtnSI.isSelected()) {//CARNET DE EXTRANJERIA

            vclt.jlCARNET.setVisible(true);
            vclt.jlPASAPORTE.setVisible(false);

            vclt.txtEXTRANJERIA.setVisible(true);
            vclt.txtPASAPORTE.setVisible(false);

        } else if (vclt.rbtnNO.isSelected()) {//PASAPORTE

            vclt.jlPASAPORTE.setVisible(true);
            vclt.jlCARNET.setVisible(false);

            vclt.txtPASAPORTE.setVisible(true);
            vclt.txtEXTRANJERIA.setVisible(false);

        }
        
    }
    
    
    //metodo para verificar que los campos a ingresar no esten vacios
    public void verificarCAMPOS(vistaCLIENTE vclt){
        

    try {
            //CAMPOS GENERALES QUE NO PUEDEN ESTAR VACIOS
            if(        vclt.txtID_CLIENTE.getText().isEmpty()
                    || vclt.cbxNACIONALIDAD.getSelectedIndex()==-1
                    || vclt.txtN_A.getText().isEmpty()
                    || vclt.cbxSEXO.getSelectedIndex() ==-1                   
                    || vclt.txtLICENCIA.getText().isEmpty()
                    || vclt.txtTELEFONO.getText().isEmpty()
                    || vclt.txtCORREO.getText().isEmpty()
                    || vclt.txtDIRECCION.getText().isEmpty()
                    || vclt.txtDISTRITO.getText().isEmpty()       ){
                    JOptionPane.showMessageDialog(null, "NO DEJE CAMPOS VACIOS");                                                                
            }else{//si los campos generales no estan vacios pasamos a los particulares
                // YA FECHA YA ESTA CORRECTA EN ESTE PUNTO
                
                try {
                    int ID =  Integer.parseInt(vclt.txtID_CLIENTE.getText());
                    if(ID<0){
                        JOptionPane.showMessageDialog(null, "El ID del empleado debe ser mayor o igual a 0");
                        return;
                    }
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "El id debe ser un numero entero");
                    return;
                }
                //-----------------------------verifamos que el id ingresado no sea duplicado---------------------------
                if (!verificarIdLibre_CLIENTE(vclt.txtID_CLIENTE)) {
                    // Si la función devuelve false, el ID YA EXISTE o hubo un error.
                    JOptionPane.showMessageDialog(null,
                            "El ID de cliente '" + vclt.txtID_CLIENTE.getText() + "' ya existe o no se pudo verificar.\nIngrese un ID diferente.",
                            "ID No Disponible", JOptionPane.WARNING_MESSAGE);
                    return; // Detener el proceso de registro
                }
                
                
                
                if(vclt.cbxNACIONALIDAD.getSelectedIndex()==0){//No especifico su nacionalidad
                    guardarDESCONOCIDO(vclt);
                }                                
                else if(vclt.cbxNACIONALIDAD.getSelectedIndex() == 1){//es peruano
                    if(vclt.txtDNI.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "NO DEJE CAMPOS VACIOS");
                    }else{
                        guardarPERUANO(vclt);
                    }
                }
                else if(vclt.cbxNACIONALIDAD.getSelectedIndex() ==2){//es extranjero 
                    
                    if(vclt.rbtnSI.isSelected()==false && vclt.rbtnNO.isSelected()==false ){
                        JOptionPane.showMessageDialog(null, "NO DEJE CAMPOS VACIOS");
                    }
                    else if(vclt.rbtnSI.isSelected()){//si selecciono 'SI' es residente peruano
                        
                        if(vclt.txtEXTRANJERIA.getText().isEmpty()){//verificar que el campo CARNET EXTRANJERIA
                            JOptionPane.showMessageDialog(null, "NO DEJE CAMPOS VACIOS");
                        }else{
                            guardarEXTRANJERO_RESIDENTE(vclt);
                        }
                        
                    }
                    else if(vclt.rbtnNO.isSelected()){ //Si selecciono 'NO' es Turista
                        if(vclt.txtPASAPORTE.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null, "NO DEJE CAMPOS VACIOS");
                        }else{
                            guardarEXTRANJERO_TURISTA(vclt);
                        }
                        
                    }
                    
                }
                
                
                
                
            }
                
                        
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "error en el catch");
        }
        
        
        
    }
    
    //------GUARDANDO LOS DATOS DE UN CLIENTE---------
    
    //metodo para guardar la informaicon en un txt
    
    public void guardarPERUANO(vistaCLIENTE vclt){
        
        
        
        //GUARDANDO LOS DATOS GENERALES
        int id = Integer.parseInt(vclt.txtID_CLIENTE.getText());        
        int nacionalidad = vclt.cbxNACIONALIDAD.getSelectedIndex();
        String dni = vclt.txtDNI.getText();
        //carnet -> NULL          (STRING)
        //pasaporte -> NULL       (STRING)
        
        //residencia -> SI        (STRING)        
        String residencia = vclt.rbtnSI.getText();
        String N_A = vclt.txtN_A.getText();
        int sexo = vclt.cbxSEXO.getSelectedIndex();                
        //String fecha_nacimiento = vclt.txtFECHA.getText();
        String nro_licencia = vclt.txtLICENCIA.getText();
        String telefono = vclt.txtTELEFONO.getText();
        String correo = vclt.txtCORREO.getText();
        String direccion  = vclt.txtDIRECCION.getText();
        String distrito = vclt.txtDISTRITO.getText();
        //Instanciamos a la clase CLIENTE
        //Empleado emp = new Empleado(id,nacionalidad,dni," "," ",residencia,N_A,sexo,fecha_nacimiento,telefono,correo,direccion,distrito);        
        Cliente clt = new Cliente(id,nacionalidad,dni,"-","-",residencia,N_A,sexo,nro_licencia,telefono,correo,direccion,distrito);
        
        anadirCLIENTE(clt);
    }
    
    
    //guardar a un extranjero RESIDENTE
    public void guardarEXTRANJERO_RESIDENTE(vistaCLIENTE vclt){
        

        //GUARDANDO LOS DATOS GENERALES
        int id = Integer.parseInt(vclt.txtID_CLIENTE.getText());        
        int nacionalidad = vclt.cbxNACIONALIDAD.getSelectedIndex();
        //String dni -> NULL   (STRING)
        
        //carnet ->           (STRING)
        String carnet = vclt.txtEXTRANJERIA.getText();
        
        //pasaporte -> NULL       (STRING)
        
        
        
        //residencia -> SI        (STRING)        
        String residencia = vclt.rbtnSI.getText();
        
        String N_A = vclt.txtN_A.getText();
        int sexo = vclt.cbxSEXO.getSelectedIndex();                
        //String fecha_nacimiento = vclt.txtFECHA.getText();
        String nro_licencia  = vclt.txtLICENCIA.getText();
        
        String telefono = vclt.txtTELEFONO.getText();
        String correo = vclt.txtCORREO.getText();
        String direccion  = vclt.txtDIRECCION.getText();
        String distrito = vclt.txtDISTRITO.getText();
        
        //Instanciamos a la clase Cliente
        Cliente clt = new Cliente(id,nacionalidad,"-",carnet,"-",residencia,N_A,sexo,nro_licencia,telefono,correo,direccion,distrito);        
        
        anadirCLIENTE(clt);
    }
    
    
    //guardar extranjero TURISTA
    public void guardarEXTRANJERO_TURISTA(vistaCLIENTE vclt){
        //GUARDANDO LOS DATOS GENERALES
        int id = Integer.parseInt(vclt.txtID_CLIENTE.getText());        
        int nacionalidad = vclt.cbxNACIONALIDAD.getSelectedIndex();
        //String dni -> NULL (STRING)
        
        //carnet -> NULL          (STRING)        
        
                
        //pasaporte ->        (STRING)
        String pasaporte = vclt.txtPASAPORTE.getText();
        
        
        //residencia -> NO        (STRING)        
        String residencia = vclt.rbtnNO.getText();
        
        String N_A = vclt.txtN_A.getText();
        int sexo = vclt.cbxSEXO.getSelectedIndex();                
        //String fecha_nacimiento = vclt.txtFECHA.getText();
        String nro_licencia  = vclt.txtLICENCIA.getText();
        String telefono = vclt.txtTELEFONO.getText();
        String correo = vclt.txtCORREO.getText();
        String direccion  = vclt.txtDIRECCION.getText();
        String distrito = vclt.txtDISTRITO.getText();
        
        //Instanciamos a la clase CLIENTE
        Cliente clt = new Cliente(id,nacionalidad,"-","-",pasaporte,residencia,N_A,sexo,nro_licencia,telefono,correo,direccion,distrito);        
        
        anadirCLIENTE(clt);
        
    }
    
    //guardar 'NO SELEECCIONO SU NACIONALIDAD'
    
    public void guardarDESCONOCIDO(vistaCLIENTE vclt){
        //GUARDANDO LOS DATOS GENERALES
        int id = Integer.parseInt(vclt.txtID_CLIENTE.getText());      
        
        int nacionalidad = vclt.cbxNACIONALIDAD.getSelectedIndex();
        
        //String dni -> NULL (STRING) 
        //carnet -> NULL          (STRING)                                
        //pasaporte ->   NULL     (STRING)        
        
        
        //residencia -> SI        (STRING)        
        String residencia = vclt.rbtnSI.getText();
        
        String N_A = vclt.txtN_A.getText();
        int sexo = vclt.cbxSEXO.getSelectedIndex();                
        //String fecha_nacimiento = vclt.txtFECHA.getText();
        String nro_licencia  = vclt.txtLICENCIA.getText();
        String telefono = vclt.txtTELEFONO.getText();
        String correo = vclt.txtCORREO.getText();
        String direccion  = vclt.txtDIRECCION.getText();
        String distrito = vclt.txtDISTRITO.getText();
        
        //Instanciamos a la clase CLIENTE
        Cliente clt = new Cliente(id,nacionalidad,"-","-","-",residencia,N_A,sexo,nro_licencia,telefono,correo,direccion,distrito);        
        
        
        anadirCLIENTE(clt);
    }
    
    //-------------------------------GUARDANDO LOS DATOS DE UN CLIENTE--------------------------------------------------------------------
    //la creacion del archivo
    public void crearARCHIVO_2() {
        archivo = new File("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\CLIENTE.txt");

        try {

            if (archivo.createNewFile()) {
                System.out.println("Archivo creado 'CLIENTE.TXT' correctamente");
            }

        } catch (IOException ex) {
            System.out.println("No se pudo crear el archivo");
            JOptionPane.showMessageDialog(null, "No se pudo crear el archivo");
        }

    }

    //guardar los datos de un CLIENTE
    public void anadirCLIENTE(Cliente clt) {
        crearARCHIVO_2();
        try {
            FileWriter escribir = new FileWriter(archivo, true);
            escribir.write(clt.getIdCliente() + "," + clt.getNacionalidad() + ","
                    + clt.getDni() + "," + clt.getCarnetExtranjeria() + "," + clt.getPasaporte() + ","
                    + clt.getResidencia() + "," + clt.getN_A() + "," + clt.getSexo() + ","
                    + clt.getNro_licencia() + "," + clt.getTelefono() + ","
                    + clt.getCorreo() + "," + clt.getDireccion() + ","
                    + clt.getDistrito() + "\r\n");
            escribir.close();
            JOptionPane.showMessageDialog(null, "Cliente anadido correctamente");
        } catch (IOException ex) {
            System.out.println("Error, no se puedo registrar");
            JOptionPane.showMessageDialog(null, "No se pudo registrar error en el catch");
        }
    }

    
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------
    
    
    
    
    //----------------------------------------VISTA VEHICULO----------------------------------
    public void verificarCBX_MARCA(JComboBox cbxMARCA, JComboBox cbxMODELO){
        if(cbxMARCA.getSelectedIndex() == 0){
            //rellenamos el combo box            
            cbxMODELO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "YARIS", "COROLLA", "LEXUS" }));
            cbxMODELO.setSelectedIndex(-1);
        }else if(cbxMARCA.getSelectedIndex() == 1){
            //rellenamos el combo box
            cbxMODELO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SENTRA", "SUNNY", "TIDA","VERSA"}));
            cbxMODELO.setSelectedIndex(-1);
        }else if(cbxMARCA.getSelectedIndex() == 2){
            cbxMODELO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CIVIC", "ACCORD", "CR-V"}));
            cbxMODELO.setSelectedIndex(-1);
        }else if(cbxMARCA.getSelectedIndex() == 3){
            cbxMODELO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FIESTA", "FOCUS", "ESCAPE"}));
            cbxMODELO.setSelectedIndex(-1);
        }        
    }
    public void verificarCAMPOS_RVEHICULOS(vistaVEHICULO vhcl){
        
        if(     vhcl.txtID_VEHICULO.getText().isEmpty() ||
                vhcl.cbxTIPO.getSelectedIndex()==-1 ||
                vhcl.cbxMARCA.getSelectedIndex()==-1 ||
                vhcl.cbxMODELO.getSelectedIndex()==-1 ||
                vhcl.cbxCOLOR.getSelectedIndex()==-1 ||
                vhcl.txtPLACA.getText().isEmpty() ||
                (vhcl.rbtnNO.isSelected()==false && vhcl.rbtnSI.isSelected()==false )){
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos");
        }else{
            //aca llamamos al metodo para guardar vehiculo
            try {
                    int ID =  Integer.parseInt(vhcl.txtID_VEHICULO.getText());
                    if(ID<0){
                        JOptionPane.showMessageDialog(null, "El ID del empleado debe ser mayor o igual a 0");
                        return;
                    }
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "El id debe ser un numero entero");
                    return;
             }
            
            //-----------------------------verifamos que el id ingresado no sea duplicado---------------------------
            if (!verificarIdLibre_VEHICULO(vhcl.txtID_VEHICULO)) {
                // Si la función devuelve false, el ID YA EXISTE o hubo un error.
                JOptionPane.showMessageDialog(null,
                        "El ID de vehículo '" + vhcl.txtID_VEHICULO.getText() + "' ya existe o no se pudo verificar.\nIngrese un ID diferente.",
                        "ID No Disponible", JOptionPane.WARNING_MESSAGE);
                return; // Detener el proceso de registro
            }
            
            guardarVEHICULO(vhcl);
        }
            
        
        
    }
    //GUARDANDO LOS DATOS DEL VEHICULO
    public void guardarVEHICULO(vistaVEHICULO vhcl){
        int idVehiculo = Integer.parseInt(vhcl.txtID_VEHICULO.getText());
        String tipo = vhcl.cbxTIPO.getSelectedItem().toString();
        String marca = vhcl.cbxMARCA.getSelectedItem().toString();
        String modelo = vhcl.cbxMODELO.getSelectedItem().toString();
        String color = vhcl.cbxCOLOR.getSelectedItem().toString();
        String nroPLACA = vhcl.txtPLACA.getText();
        String lunasPOLARIZADAS="";
        if(vhcl.rbtnSI.isSelected()){
            lunasPOLARIZADAS = "SI";
        }else if(vhcl.rbtnNO.isSelected()){
            lunasPOLARIZADAS = "NO";
        }
        
        Vehiculo VEHICULO = new Vehiculo(idVehiculo,tipo, marca, modelo, color, nroPLACA, lunasPOLARIZADAS);
        
        anadirVEHICULO(VEHICULO);
        
    }
                
    //-------------------------------GUARDANDO LOS DATOS DE UN VEHICULO--------------------------------------------------------------------
    public void crearARCHIVO_3() {

        archivo = new File("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\VEHICULO.txt");

        try {

            if (archivo.createNewFile()) {
                System.out.println("Archivo creado 'EMPLEADO.TXT' correctamente");
            }

        } catch (IOException ex) {
            System.out.println("No se pudo crear el archivo");
            JOptionPane.showMessageDialog(null, "No se pudo crear el archivo");
        }
    }

    public void anadirVEHICULO(Vehiculo VEHICULO){
        crearARCHIVO_3();
        try {
            FileWriter escribir = new FileWriter(archivo,true);
            
            escribir.write( VEHICULO.getIdVehiculo()+ ","+VEHICULO.getTipo()+","+VEHICULO.getIdMARCA()+","+VEHICULO.getModelo()+","+VEHICULO.getColor()+","+
                    VEHICULO.getNroPLACA()+","+VEHICULO.getLunasPOLARIZADAS()+"\r\n");
            
                                                
            escribir.close();
            JOptionPane.showMessageDialog(null, "Registro de vehiculo completado");
            
        } catch (IOException ex) {
            System.out.println("Error, no se puedo registrar");
            JOptionPane.showMessageDialog(null, "No se pudo registrar error en el catch");
        }
    }
    
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------
    
    
    
    
    //----------------------------------------VISTA ENTRADA----------------------------------------------
    
    public void verificarCAMPO_ENTRADA(vistaENTRADA veta){
        if(     veta.txtID_ENTRADA.getText().isEmpty() ||
                veta.cbxCLIENTE.getSelectedIndex()==-1 ||
                veta.cbxEmpleado.getSelectedIndex()==-1 ||
                veta.cbxVehiculo.getSelectedIndex()==-1 ||
                veta.cbxPiso.getSelectedIndex()==-1 ||
                veta.txtZona.getText().isEmpty() ||
                verificarFECHA(veta.txtFecha)==false ||
                verificarHORA(veta.txtHora)==false ||
                veta.cbxDOCUMENTO.getSelectedIndex()==-1){
            JOptionPane.showMessageDialog(null, "No deje campos vacios");
        }else{
            //aca llamamos al metodo para guardar 'vistaENTRADA'
            try {
                    int ID =  Integer.parseInt(veta.txtID_ENTRADA.getText());
                    if(ID<0){
                        JOptionPane.showMessageDialog(null, "El ID del REGISTRO debe ser mayor o igual a 0");
                        return;
                    }
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "El id debe ser un numero entero");
                    return;
             }
            
            
            //-----------------------------verifamos que el id ingresado no sea duplicado---------------------------
            if (!verificarIdLibre_ENTRADA(veta.txtID_ENTRADA)) {
                // Si la función devuelve false, el ID YA EXISTE o hubo un error.
                JOptionPane.showMessageDialog(null,
                        "El ID de registro de entrada '" + veta.txtID_ENTRADA.getText() + "' ya existe o no se pudo verificar.\nIngrese un ID diferente.",
                        "ID No Disponible", JOptionPane.WARNING_MESSAGE);
                return; // Detener el proceso de registro
            }
            
            
            
            guardarENTRADA(veta);            
            
        }
    }
    
    public boolean verificarHORA(JTextField txtHORA) {
        try {
            // Verificar si el campo está vacío
            if (txtHORA.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese una hora");
                return false;
            }

            // Verificar longitud y formato básico (hh:mm)
            String horaTexto = txtHORA.getText();
            if (horaTexto.length() != 5) {
                JOptionPane.showMessageDialog(null, "Ingrese una hora válida: hh:mm");
                return false;
            }

            // Verificar que el formato contiene el separador correcto
            if (!horaTexto.matches("\\d{2}:\\d{2}")) {
                JOptionPane.showMessageDialog(null, "Formato incorrecto. Use hh:mm");
                return false;
            }

            // Extraer horas y minutos
            String[] partes = horaTexto.split(":");
            int horas = Integer.parseInt(partes[0]);
            int minutos = Integer.parseInt(partes[1]);

            // Validar rangos
            if (horas < 0 || horas > 23) {
                JOptionPane.showMessageDialog(null, "Las horas deben estar entre 00 y 23");
                return false;
            }
            if (minutos < 0 || minutos > 59) {
                JOptionPane.showMessageDialog(null, "Los minutos deben estar entre 00 y 59");
                return false;
            }

            // Si llega aquí, la hora es válida
            return true;

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese solo números en el formato hh:mm");
            return false;
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error en la interfaz gráfica");
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hora inválida");
            return false;
        }
    }
    
    public void cargarCOMBO_CLIENTE(JComboBox cbxCLIENTE){
        cbxCLIENTE.removeAllItems();
    try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\CLIENTE.txt"))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length > 0) {
                    String id = partes[0].trim(); // eliminamos espacios por si acaso
                    cbxCLIENTE.addItem(id);
                }
                
            }
        
        }catch (IOException ex) {
           ex.printStackTrace();
    }
        
    }
    public void cargarCOMBO_EMPLEADO(JComboBox cbxEMPLEADO){
        cbxEMPLEADO.removeAllItems();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\EMPLEADO.txt"))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length > 0) {
                    String id = partes[0].trim(); // eliminamos espacios por si acaso
                    cbxEMPLEADO.addItem(id);
                }
                
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    public void cargarCOMBO_VEHICULO(JComboBox cbxVEHICULO){
        cbxVEHICULO.removeAllItems();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\VEHICULO.txt"))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length > 0) {
                    String id = partes[0].trim(); // eliminamos espacios por si acaso
                    cbxVEHICULO.addItem(id);
                }
                
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
            
    //-------------guardando los datos de 'vistaENTRADA'------------------
    public void guardarENTRADA(vistaENTRADA veta){
        int idEntrada = Integer.parseInt(veta.txtID_ENTRADA.getText());
        int idEmpleado1 = Integer.parseInt(veta.cbxEmpleado.getSelectedItem().toString());
        int idCliente1 = Integer.parseInt(veta.cbxCLIENTE.getSelectedItem().toString());
        int idVehiculo1 = Integer.parseInt(veta.cbxVehiculo.getSelectedItem().toString()) ;
        int piso  = Integer.parseInt(veta.cbxPiso.getSelectedItem().toString());//(Piso -1,-2,0,1,2,3 )
        String zona = veta.txtZona.getText();
        String fecha_Ingreso = veta.txtFecha.getText();
        String hora_Ingreso = veta.txtHora.getText();
        String tipo_Documento = veta.cbxDOCUMENTO.getSelectedItem().toString();
        String descripcion="";
        //si la descripcion a ingresar esta vacia insertamos '-'
        if(veta.txtDescripcion.getText().isEmpty()){
            descripcion = "-";
        }else{
            descripcion = veta.txtDescripcion.getText();
        }
        
        REGISTRO_ENTRADAS_SALIDAS rge = new REGISTRO_ENTRADAS_SALIDAS( idEntrada,  idEmpleado1,  idCliente1,  idVehiculo1,  piso,
             zona,  fecha_Ingreso,  hora_Ingreso,  tipo_Documento,  descripcion);
        anadirENTRADA(rge);
        
    }    
    public void crearARCHIVO_4() {
        archivo = new File("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\ENTRADA.txt");

        try {

            if (archivo.createNewFile()) {
                System.out.println("Archivo creado 'ENTRADA.TXT' correctamente");
            }

        } catch (IOException ex) {
            System.out.println("No se pudo crear el archivo");
            JOptionPane.showMessageDialog(null, "No se pudo crear el archivo");
        }
    }        
    public void anadirENTRADA(REGISTRO_ENTRADAS_SALIDAS rge){
        crearARCHIVO_4();
        try {
            FileWriter escribir = new FileWriter(archivo,true);
            
            escribir.write(rge.getIdEntrada()+","+
                    rge.getIdEmpleado1()+","+
                    rge.getIdCliente1()+","+
                    
                    rge.getIdVehiculo1()+","+
                    rge.getPiso()+","+
                    rge.getZona()+","+
                    rge.getFecha_Ingreso()+","+
                    rge.getHora_Ingreso()+","+
                    rge.getTipo_Documento()+","+
                    rge.getDescripcion()+"\r\n");
            
            escribir.close();
            JOptionPane.showMessageDialog(null, "ENTRADA anadida correctamente");
        } catch (IOException ex) {
            System.out.println("Error, no se puedo registrar");
            JOptionPane.showMessageDialog(null, "No se pudo registrar error en el catch");
        }
        
    }
    
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------
    
    
    
    
    //----------------------------------------VISTA SALIDA----------------------------------------------
    
    public void verificarCAMPOS_SALIDA(vistaSALIDA vsld){
        
        if(     
                vsld.txtID_SALIDA.getText().isEmpty() ||//validacion del txt id
                vsld.cbxENTRADA.getSelectedIndex() == -1 ||//si el index del cbx entrada es -1
                vsld.txtVEHICULO.getText().isEmpty()  || //verificacion del txt vehiculo                               
                vsld.cbxEmpleado.getSelectedIndex()==-1 || //verificacion del cbxEMPLEADO es -1
                vsld.txtCLIENTE.getText().isEmpty() || //verificacion del txtCLIENTE es ""
                verificarFECHA(vsld.txtFecha)==false || //validamos que la fecha ingresada sea valida
                verificarHORA(vsld.txtHora)==false //validamos que la hora ingresada sea valida
                ){            
            
            //la verificacion del campos descripcion es opcional
            JOptionPane.showMessageDialog(null,"No deje campos vacios.");
        }else{
            //en el caso que el id no sea entero
            //aca llamamos al metodo para guardar 'vistaSALIDA'
            try {
                int ID = Integer.parseInt(vsld.txtID_SALIDA.getText());
                if (ID < 0) {
                    JOptionPane.showMessageDialog(null, "El ID del SALIDA debe ser mayor o igual a 0");
                    return;
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "El id debe ser un numero entero");
                return;
            }
            
            //-----------------------------verifamos que el id ingresado no sea duplicado---------------------------
            if (!verificarIdLibre_SALIDA(vsld.txtID_SALIDA)) {
                // Si la función devuelve false, el ID YA EXISTE o hubo un error.
                JOptionPane.showMessageDialog(null,
                        "El ID de salida '" + vsld.txtID_SALIDA.getText() + "' ya existe o no se pudo verificar.\nIngrese un ID diferente.",
                        "ID No Disponible", JOptionPane.WARNING_MESSAGE);
                return; // Detener el proceso de registro
            }
            
            //-----------------------------verifamos que fecha_salida>=fecha_entrada---------------------------
            //-----------------------------si es el mismo dia->>
            //-----------------------------hora_salida>hora_entrada---------------------------                        
            if (!validarFechaHoraSalida(vsld.cbxENTRADA, vsld.txtFecha, vsld.txtHora)) {
                // El mensaje de error específico (fecha o hora) ya se mostró dentro de la función
                return; // Detener si la validación combinada falla
            }
            

            
            
            guardarSALIDA(vsld);
        }
        
    }
                
    //-------------guardando los datos de 'vistaSALIDA'------------------
    public void guardarSALIDA(vistaSALIDA vsld){
          int idSalida = Integer.parseInt(vsld.txtID_SALIDA.getText());
          int idEntrada2  = Integer.parseInt(vsld.cbxENTRADA.getSelectedItem().toString()) ;
          int idEmpleado2  =  Integer.parseInt(vsld.cbxEmpleado.getSelectedItem().toString());
          int idCliente2 =  Integer.parseInt(vsld.txtCLIENTE.getText())  ;
          int idVehiculo2 = Integer.parseInt(vsld.txtVEHICULO.getText()) ;
          
          
          String fecha_Salida = vsld.txtFecha.getText();
          String hora_Salida = vsld.txtHora.getText();
          String descripcion2 = "";
          //si la descripcion esta vacia insertamos
          if(vsld.txtDescripcion.getText().isEmpty()){
              descripcion2 = "-";
          }else{
              descripcion2 = vsld.txtDescripcion.getText();
          }
                  
          REGISTRO_ENTRADAS_SALIDAS rgs = new REGISTRO_ENTRADAS_SALIDAS(idSalida, idEntrada2, 
                  idEmpleado2, idCliente2, 
                  idVehiculo2, fecha_Salida, hora_Salida, descripcion2);
          anadirSALIDA(rgs);
        
    }
    public void crearARCHIVO_5() {
        archivo = new File("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\SALIDA.txt");

        try {

            if (archivo.createNewFile()) {
                System.out.println("Archivo creado 'SALIDA.TXT' correctamente");
            }

        } catch (IOException ex) {
            System.out.println("No se pudo crear el archivo");
            JOptionPane.showMessageDialog(null, "No se pudo crear el archivo");
        }
    }
    public void anadirSALIDA(REGISTRO_ENTRADAS_SALIDAS rgs){
        crearARCHIVO_5();
        try {
            FileWriter escribir = new FileWriter(archivo,true);
            escribir.write(
                    rgs.getIdSalida()+","+
                    rgs.getIdEntrada2()+","+
                    rgs.getIdEmpleado2()+","+
                    rgs.getIdCliente2()+","+
                    rgs.getIdVehiculo2()+","+
                            
                    rgs.getFecha_Salida()+","+
                    rgs.getHora_Salida()+","+
                    rgs.getDescripcion2()+"\r\n");
            
            escribir.close();
            JOptionPane.showMessageDialog(null, "SALIDA anadida correctamente");
        } catch (IOException ex) {
            System.out.println("Error, no se puedo registrar");
            JOptionPane.showMessageDialog(null, "No se pudo registrar error en el catch");
        }
        
    }    
    public void cargarCOMBO_ENTRADA(JComboBox cbxENTRADA){
        
        cbxENTRADA.removeAllItems();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\ENTRADA.txt"))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length > 0) {
                    String id = partes[0].trim(); // eliminamos espacios por si acaso
                    cbxENTRADA.addItem(id);
                }
                
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void cargar_idVehiculo(JComboBox cbxENTRADA, JTextField txtVEHICULO) {
        Object selectedItem = cbxENTRADA.getSelectedItem();
        // Verificar si hay algo seleccionado
        if (selectedItem == null) {
            txtVEHICULO.setText(""); // Limpiar si no hay selección
            //System.err.println("No se ha seleccionado ningún item en cbxENTRADA.");
            return;
        }

        String idEntradaSeleccionado = selectedItem.toString();
        String idVehiculoEncontrado = null;

        // Usamos try-with-resources para asegurar que el BufferedReader se cierre
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\ENTRADA.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                // Verificar si la línea tiene suficientes campos y si el primer campo coincide
                // Indices basados en tu ejemplo: 0=idRegistro, 1=idEmpleado, 2=idCliente, 3=idVehiculo,...
                if (partes.length > 3 && partes[0].trim().equals(idEntradaSeleccionado)) {
                    idVehiculoEncontrado = partes[3].trim(); // El idVehiculo está en la posición 3 (índice 3)
                    break; // Salir del bucle una vez encontrado
                }
            }
        } catch (IOException ex) {
            // Manejar errores de lectura de archivo
            ex.printStackTrace();
            txtVEHICULO.setText("Error al leer"); // Indicar error en el campo
            return; // Salir del método en caso de error
        }

        // Actualizar el JTextField con el valor encontrado o vacío si no se encontró
        if (idVehiculoEncontrado != null) {
            txtVEHICULO.setText(idVehiculoEncontrado);
        } else {
            txtVEHICULO.setText(""); // Limpiar si no se encontró el ID
            System.err.println("No se encontró el idVehiculo para el idRegistro: " + idEntradaSeleccionado);
        }
    }
    
    public void cargar_idCliente(JComboBox cbxENTRADA, JTextField txtCLIENTE) {
        Object selectedItem = cbxENTRADA.getSelectedItem();
        // Verificar si hay algo seleccionado
        if (selectedItem == null) {
            txtCLIENTE.setText(""); // Limpiar si no hay selección
            //System.err.println("No se ha seleccionado ningún item en cbxENTRADA.");
            return;
        }

        String idEntradaSeleccionado = selectedItem.toString();
        String idClienteEncontrado = null;

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\ENTRADA.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                // Verificar si la línea tiene suficientes campos y si el primer campo coincide
                // Indices basados en tu ejemplo: 0=idRegistro, 1=idEmpleado, 2=idCliente, 3=idVehiculo,...
                if (partes.length > 2 && partes[0].trim().equals(idEntradaSeleccionado)) {
                    idClienteEncontrado = partes[2].trim(); // El idCliente está en la posición 2 (índice 2)
                    break; // Salir del bucle una vez encontrado
                }
            }
        } catch (IOException ex) {
            // Manejar errores de lectura de archivo
            ex.printStackTrace();
            txtCLIENTE.setText("Error al leer"); // Indicar error en el campo
            return; // Salir del método en caso de error
        }

        // Actualizar el JTextField con el valor encontrado o vacío si no se encontró
        if (idClienteEncontrado != null) {
            txtCLIENTE.setText(idClienteEncontrado);
        } else {
            txtCLIENTE.setText(""); // Limpiar si no se encontró el ID
            System.err.println("No se encontró el idCliente para el idRegistro: " + idEntradaSeleccionado);
        }
    }
    
    
    
    
    
    //-----------------------------------VENTANAS 'MOSTRAR'---------------------------------------------------
    
    
    
    
    
    
    //-----------------------------------DISEÑO Y ACCESO A LA TABLA 'mostrarEMPLEADOS'------------------------                
    public void disenoTABLA_EMPLEADOS(JTable tablaEMPLEADOS){
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("idEmpleado");
        modeloTabla.addColumn("Nacionalidad");
        modeloTabla.addColumn("DNI");
        modeloTabla.addColumn("carnet extranjeria");
        modeloTabla.addColumn("pasaporte");
        modeloTabla.addColumn("Residencia");
        modeloTabla.addColumn("Nombres y Apell.");
        modeloTabla.addColumn("Sexo");
        modeloTabla.addColumn("fecha de nacimiento");
        modeloTabla.addColumn("Telefono");
        modeloTabla.addColumn("Correo");
        modeloTabla.addColumn("Direccion");
        modeloTabla.addColumn("Distrito");
        
        
        
        leerTEXTO_EMPLEADO(modeloTabla);
        //añadiendo este modelo a la 'TABLA EMPLEADOS'
        tablaEMPLEADOS.setModel(modeloTabla);
    }            
    public void leerTEXTO_EMPLEADO(DefaultTableModel modeloTabla){
        String cadena;
        String fila[];
        try {
            FileReader lector = new FileReader("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\EMPLEADO.txt");
            BufferedReader lectura = new BufferedReader(lector);
            
            cadena = lectura.readLine();
            
            while(cadena!=null){
                fila = cadena.split(",");
                modeloTabla.addRow(fila);
                cadena = lectura.readLine();
            }
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("error no se pudo leer el archivo: "+ex);
        }catch (IOException ex) {
            System.out.println("error no se pudo leer el archivo: "+ex);    
        }
        
    }
    
    
    
    
    
    //-----------------------------------DISEÑO Y ACCESO A LA TABLA 'mostrarCLIENTES'------------------------    
    public void disenoTABLA_CLIENTES(JTable tablaCLIENTES){
        DefaultTableModel modeloTabla_2 = new DefaultTableModel();
        modeloTabla_2.addColumn("idCliente");
        modeloTabla_2.addColumn("Nacionalidad");
        modeloTabla_2.addColumn("DNI");
        modeloTabla_2.addColumn("carnet extranjeria");
        modeloTabla_2.addColumn("pasaporte");
        modeloTabla_2.addColumn("Residencia");
        modeloTabla_2.addColumn("Nombres y Apell.");
        modeloTabla_2.addColumn("Sexo");
        modeloTabla_2.addColumn("Nro. de Licencia");
        modeloTabla_2.addColumn("Telefono");
        modeloTabla_2.addColumn("Correo");
        modeloTabla_2.addColumn("Direccion");
        modeloTabla_2.addColumn("Distrito");
        
        
        leerTEXTO_CLIENTES(modeloTabla_2);
        //añadiendo este modelo a la tabla 'TABLA CLIENTE'
        tablaCLIENTES.setModel(modeloTabla_2);
        
    }            
    public void leerTEXTO_CLIENTES(DefaultTableModel modeloTabla_2){
        String cadena;
        String fila[];
        try {
            FileReader lector = new FileReader("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\CLIENTE.txt");
            BufferedReader lectura = new BufferedReader(lector);

            cadena = lectura.readLine();

            while (cadena != null) {
                fila = cadena.split(",");
                modeloTabla_2.addRow(fila);
                cadena = lectura.readLine();
            }

        } catch (FileNotFoundException ex) {
            System.out.println("error no se pudo leer el archivo: " + ex);
        } catch (IOException ex) {
            System.out.println("error no se pudo leer el archivo: " + ex);
        }
        
    }
    
    
    
    //-----------------------------------DISEÑO Y ACCESO A LA TABLA 'mostrarVEHICULOS'------------------------    
    public void disenoTABLA_VEHICULOS(JTable tablaVEHICULOS){
        DefaultTableModel modeloTabla_3 = new DefaultTableModel();
        modeloTabla_3.addColumn("idVehiculo");
        modeloTabla_3.addColumn("Tipo");
        modeloTabla_3.addColumn("Marca");
        modeloTabla_3.addColumn("Modelo");
        modeloTabla_3.addColumn("Color");
        modeloTabla_3.addColumn("Nro. Placa");
        modeloTabla_3.addColumn("¿Lunas Polarizadas?");
                
        
        leerTEXTO_VEHICULOS(modeloTabla_3);
        //añadiendo este modelo a la tabla 'TABLA CLIENTE'
        tablaVEHICULOS.setModel(modeloTabla_3);
        
    }
    public void leerTEXTO_VEHICULOS(DefaultTableModel modeloTabla_3){
        
        String cadena;
        String fila[];
        try {
            FileReader lector = new FileReader("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\VEHICULO.txt");
            BufferedReader lectura = new BufferedReader(lector);

            cadena = lectura.readLine();

            while (cadena != null) {
                fila = cadena.split(",");
                modeloTabla_3.addRow(fila);
                cadena = lectura.readLine();
            }

        } catch (FileNotFoundException ex) {
            System.out.println("error no se pudo leer el archivo: " + ex);
        } catch (IOException ex) {
            System.out.println("error no se pudo leer el archivo: " + ex);
        }
        
    }
    
    //-----------------------------------DISEÑO Y ACCESO A LA TABLA 'mostrarENTRADAS'------------------------    
    public void disenoTABLA_ENTRADAS(JTable tablaENTRADAS){
        
        DefaultTableModel modeloTabla_4 = new DefaultTableModel();
        modeloTabla_4.addColumn("idEntrada");
        modeloTabla_4.addColumn("idEmpleado");
        modeloTabla_4.addColumn("idCliente");
        modeloTabla_4.addColumn("idVehiculo");
        modeloTabla_4.addColumn("Piso");
        modeloTabla_4.addColumn("Zona");
        modeloTabla_4.addColumn("Fecha de ingreso");
        modeloTabla_4.addColumn("Hora de ingreso");
        modeloTabla_4.addColumn("Tipo de documento");
        modeloTabla_4.addColumn("Descripcion");
        
        
        
        
        leerTEXTO_ENTRADA(modeloTabla_4);
        //añadiendo este modelo a la tabla 'TABLA ENTRADA'        
        tablaENTRADAS.setModel(modeloTabla_4);
        
    }
    public void leerTEXTO_ENTRADA(DefaultTableModel modeloTabla_4) {
        String cadena;
        String fila[];
        try {
            FileReader lector = new FileReader("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\ENTRADA.txt");
            BufferedReader lectura = new BufferedReader(lector);

            cadena = lectura.readLine();

            while (cadena != null) {
                fila = cadena.split(",");
                modeloTabla_4.addRow(fila);
                cadena = lectura.readLine();
            }

        } catch (FileNotFoundException ex) {
            System.out.println("error no se pudo leer el archivo: " + ex);
        } catch (IOException ex) {
            System.out.println("error no se pudo leer el archivo: " + ex);
        }

    }

    //-----------------------------------DISEÑO Y ACCESO A LA TABLA 'mostrarSALIDAS'------------------------    
    public void disenoTABLA_SALIDAS(JTable tablaSALIDAS){
        DefaultTableModel modeloTabla_5 = new DefaultTableModel();
        modeloTabla_5.addColumn("idSalida");
        modeloTabla_5.addColumn("idEntrada");
        modeloTabla_5.addColumn("idEmpleado");
        modeloTabla_5.addColumn("idCliente");
        modeloTabla_5.addColumn("idVehiculo");
                        
        modeloTabla_5.addColumn("Fecha de salida");
        modeloTabla_5.addColumn("Hora de salida");
        modeloTabla_5.addColumn("descripcion");
        
        
        leerTEXTO_SALIDA(modeloTabla_5);
        //añadiendo este modelo a la tabla 'TABLA SALIDAS'
        tablaSALIDAS.setModel(modeloTabla_5);
    }    
    public void leerTEXTO_SALIDA(DefaultTableModel modeloTabla_5) {
        String cadena;
        String fila[];
        try {
            FileReader lector = new FileReader("C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\SALIDA.txt");
            BufferedReader lectura = new BufferedReader(lector);

            cadena = lectura.readLine();

            while (cadena != null) {
                fila = cadena.split(",");
                modeloTabla_5.addRow(fila);
                cadena = lectura.readLine();
            }

        } catch (FileNotFoundException ex) {
            System.out.println("error no se pudo leer el archivo: " + ex);
        } catch (IOException ex) {
            System.out.println("error no se pudo leer el archivo: " + ex);
        }

    }
    
    
    
    
    
    
    
    //-----------------------------------VENTANAS 'LIMPIAR'---------------------------------------------------                                
    
    //---------------------funcion para limpiar las casillas------------------------------------
    public void limpiarEMPLEADO(vistaEMPLEADO vemp){
        
        vemp.txtID_EMPLEADO.setText("");
        vemp.cbxNACIONALIDAD.setSelectedIndex(-1);
        vemp.txtN_A.setText("");
        vemp.cbxSEXO.setSelectedIndex(-1);
        vemp.txtFECHA.setText("");
        vemp.txtTELEFONO.setText("");
        vemp.txtCORREO.setText("");
        vemp.txtDIRECCION.setText("");
        vemp.txtDISTRITO.setText("");
        //------------------------
        vemp.jlDNI.setVisible(false);
        
        vemp.txtDNI.setVisible(false);
        vemp.txtDNI.setText("");
            
            
        vemp.jlRESIDENTE.setVisible(false);
        
        
        vemp.rbtnSI.setVisible(false);
        vemp.rbtnNO.setVisible(false);
        vemp.btnGRP_ASOCIACION.clearSelection();
        
        vemp.jlCARNET.setVisible(false);
        vemp.jlPASAPORTE.setVisible(false);            
        
        vemp.txtEXTRANJERIA.setVisible(false);
        vemp.txtEXTRANJERIA.setText("");
        
        vemp.txtPASAPORTE.setVisible(false);
        vemp.txtPASAPORTE.setText("");
            
        
    }
    public void limpiarCLIENTE(vistaCLIENTE vclt){
        
        vclt.txtID_CLIENTE.setText("");
        vclt.cbxNACIONALIDAD.setSelectedIndex(-1);
        vclt.txtN_A.setText("");
        vclt.cbxSEXO.setSelectedIndex(-1);
        vclt.txtLICENCIA.setText("");
        vclt.txtTELEFONO.setText("");
        vclt.txtCORREO.setText("");
        vclt.txtDIRECCION.setText("");
        vclt.txtDISTRITO.setText("");               
        //------------------------------------------------------
        vclt.jlDNI.setVisible(false);
        
        vclt.txtDNI.setVisible(false);
        vclt.txtDNI.setText("");
        
        
        vclt.jlRESIDENTE.setVisible(false);
        
        
                
        vclt.rbtnSI.setVisible(false);
        vclt.rbtnNO.setVisible(false);
        vclt.btnGRP_ASOCIACION.clearSelection();

        vclt.jlCARNET.setVisible(false);        
        vclt.jlPASAPORTE.setVisible(false);
        
        vclt.txtEXTRANJERIA.setVisible(false);
        vclt.txtEXTRANJERIA.setText("");
        
        vclt.txtPASAPORTE.setVisible(false);
        vclt.txtPASAPORTE.setText("");

        
        
        
    }
    public void limpiarVEHICULO(vistaVEHICULO vhcl){
        vhcl.cbxTIPO.setSelectedIndex(-1);
        vhcl.cbxMARCA.setSelectedIndex(-1);
        vhcl.cbxMODELO.setSelectedIndex(-1);
        vhcl.cbxCOLOR.setSelectedIndex(-1);
        vhcl.txtPLACA.setText("");
        vhcl.btnGRP_ASOCIACION.clearSelection();
        
        
    }
    public void limpiar_ENTRADA(vistaENTRADA veta){
        veta.txtID_ENTRADA.setText("");
        veta.cbxCLIENTE.setSelectedIndex(-1);
        veta.cbxEmpleado.setSelectedIndex(-1);
        veta.cbxVehiculo.setSelectedIndex(-1);
        veta.cbxPiso.setSelectedIndex(-1);
        
        veta.txtZona.setText("");
        veta.txtFecha.setText("");
        veta.txtHora.setText("");
        veta.txtDescripcion.setText("");
        veta.cbxDOCUMENTO.setSelectedIndex(-1);
        
    }
    public void limpiarCAMPOS_SALIDA(vistaSALIDA vsld){
        
                
        vsld.txtID_SALIDA.setText("");
        vsld.cbxENTRADA.setSelectedIndex(-1);
        vsld.txtVEHICULO.setText("");
        vsld.cbxEmpleado.setSelectedIndex(-1);
        vsld.txtCLIENTE.setText("");
        vsld.txtFecha.setText("");
        vsld.txtHora.setText("");
        vsld.txtDescripcion.setText("");
        
    }
    
    
    
    
    //----------------METODOS PARA VERIFICAR QUE NO HAY DUPLICADO DE ID-------------------------------------
    
    public boolean verificarIdLibre_EMPLEADO(JTextField txtID_EMPLEADO) {
        // **NOTA:** La ruta sigue hardcodeada.
        String ruta = "C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\EMPLEADO.txt";
        String idIngresado = txtID_EMPLEADO.getText().trim();

        if (idIngresado.isEmpty()) {
            System.err.println("El ID de empleado ingresado está vacío.");
            // JOptionPane.showMessageDialog(null,"El ID de empleado no puede estar vacío.", "Error", JOptionPane.WARNING_MESSAGE);
            return false; // ID vacío no está libre
        }
        // Validar formato numérico
        try {
            Integer.parseInt(idIngresado);
        } catch (NumberFormatException e) {
            System.err.println("El ID de empleado no es un número válido: " + idIngresado);
            JOptionPane.showMessageDialog(null, "El ID del empleado debe ser un número entero.", "Error de Formato", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        File archivo = new File(ruta);

        // --- VERIFICAR SI EL ARCHIVO EXISTE ---
        if (!archivo.exists()) {
            System.out.println("INFO: Archivo " + archivo.getName() + " no existe. Se permite el primer registro con ID: " + idIngresado);
            return true; // Si no hay archivo, no hay duplicados.
        }
        // --- FIN VERIFICACIÓN DE EXISTENCIA ---

        // --- SI EL ARCHIVO EXISTE, PROCEDER A LEER Y VERIFICAR DUPLICADOS ---
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }
                String[] partes = linea.split(",");
                if (partes.length > 0 && partes[0].trim().equals(idIngresado)) {
                    return false; // Duplicado encontrado
                }
            }
            return true; // No se encontró duplicado

        } catch (FileNotFoundException ex) { // Menos probable ahora, pero por seguridad
            System.err.println("Error FNFE: Archivo " + archivo.getName() + " no encontrado inesperadamente: " + ex.getMessage());
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error inesperado: Archivo " + archivo.getName() + " no encontrado al leer.", "Error de Archivo", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (IOException ex) {
            System.err.println("Error IOE al leer el archivo " + archivo.getName() + ": " + ex.getMessage());
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al verificar ID. No se pudo leer " + archivo.getName(), "Error de Lectura", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (Exception ex) {
            System.err.println("Error inesperado al verificar ID en " + archivo.getName() + ": " + ex.getMessage());
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error inesperado al verificar ID en " + archivo.getName(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }  
    public boolean verificarIdLibre_CLIENTE(JTextField txtID_CLIENTE) {
        // **NOTA:** La ruta sigue hardcodeada.
        String ruta = "C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\CLIENTE.txt";
        String idIngresado = txtID_CLIENTE.getText().trim();

        if (idIngresado.isEmpty()) {
            System.err.println("El ID de cliente ingresado está vacío.");
            return false;
        }
        // Validar formato numérico
        try {
            Integer.parseInt(idIngresado);
        } catch (NumberFormatException e) {
            System.err.println("El ID de cliente no es un número válido: " + idIngresado);
            JOptionPane.showMessageDialog(null, "El ID del cliente debe ser un número entero.", "Error de Formato", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        File archivo = new File(ruta);

        if (!archivo.exists()) {
            System.out.println("INFO: Archivo " + archivo.getName() + " no existe. Se permite el primer registro con ID: " + idIngresado);
            return true;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }
                String[] partes = linea.split(",");
                if (partes.length > 0 && partes[0].trim().equals(idIngresado)) {
                    return false; // Duplicado
                }
            }
            return true; // No duplicado

        } catch (FileNotFoundException ex) {
            System.err.println("Error FNFE: Archivo " + archivo.getName() + " no encontrado inesperadamente: " + ex.getMessage());
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error inesperado: Archivo " + archivo.getName() + " no encontrado al leer.", "Error de Archivo", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (IOException ex) {
            System.err.println("Error IOE al leer el archivo " + archivo.getName() + ": " + ex.getMessage());
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al verificar ID. No se pudo leer " + archivo.getName(), "Error de Lectura", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (Exception ex) {
            System.err.println("Error inesperado al verificar ID en " + archivo.getName() + ": " + ex.getMessage());
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error inesperado al verificar ID en " + archivo.getName(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }    
    public boolean verificarIdLibre_VEHICULO(JTextField txtID_VEHICULO) {
        // **NOTA:** La ruta sigue hardcodeada.
        String ruta = "C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\VEHICULO.txt";
        String idIngresado = txtID_VEHICULO.getText().trim();

        if (idIngresado.isEmpty()) {
            System.err.println("El ID de vehículo ingresado está vacío.");
            return false;
        }
        // Validar formato numérico
        try {
            Integer.parseInt(idIngresado);
        } catch (NumberFormatException e) {
            System.err.println("El ID de vehículo no es un número válido: " + idIngresado);
            JOptionPane.showMessageDialog(null, "El ID del vehículo debe ser un número entero.", "Error de Formato", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        File archivo = new File(ruta);

        if (!archivo.exists()) {
            System.out.println("INFO: Archivo " + archivo.getName() + " no existe. Se permite el primer registro con ID: " + idIngresado);
            return true;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }
                String[] partes = linea.split(",");
                if (partes.length > 0 && partes[0].trim().equals(idIngresado)) {
                    return false; // Duplicado
                }
            }
            return true; // No duplicado

        } catch (FileNotFoundException ex) {
            System.err.println("Error FNFE: Archivo " + archivo.getName() + " no encontrado inesperadamente: " + ex.getMessage());
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error inesperado: Archivo " + archivo.getName() + " no encontrado al leer.", "Error de Archivo", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (IOException ex) {
            System.err.println("Error IOE al leer el archivo " + archivo.getName() + ": " + ex.getMessage());
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al verificar ID. No se pudo leer " + archivo.getName(), "Error de Lectura", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (Exception ex) {
            System.err.println("Error inesperado al verificar ID en " + archivo.getName() + ": " + ex.getMessage());
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error inesperado al verificar ID en " + archivo.getName(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }   
    public boolean verificarIdLibre_ENTRADA(JTextField txtID_ENTRADA) {
        // **NOTA:** La ruta sigue hardcodeada.
        String ruta = "C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\ENTRADA.txt";
        String idIngresado = txtID_ENTRADA.getText().trim();

        if (idIngresado.isEmpty()) {
            System.err.println("El ID de entrada ingresado está vacío.");
            return false;
        }
        // Validar formato numérico
        try {
            Integer.parseInt(idIngresado);
        } catch (NumberFormatException e) {
            System.err.println("El ID de entrada no es un número válido: " + idIngresado);
            JOptionPane.showMessageDialog(null, "El ID de entrada debe ser un número entero.", "Error de Formato", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        File archivo = new File(ruta);

        if (!archivo.exists()) {
            System.out.println("INFO: Archivo " + archivo.getName() + " no existe. Se permite el primer registro con ID: " + idIngresado);
            return true;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }
                String[] partes = linea.split(",");
                if (partes.length > 0 && partes[0].trim().equals(idIngresado)) {
                    return false; // Duplicado
                }
            }
            return true; // No duplicado

        } catch (FileNotFoundException ex) {
            System.err.println("Error FNFE: Archivo " + archivo.getName() + " no encontrado inesperadamente: " + ex.getMessage());
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error inesperado: Archivo " + archivo.getName() + " no encontrado al leer.", "Error de Archivo", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (IOException ex) {
            System.err.println("Error IOE al leer el archivo " + archivo.getName() + ": " + ex.getMessage());
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al verificar ID. No se pudo leer " + archivo.getName(), "Error de Lectura", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (Exception ex) {
            System.err.println("Error inesperado al verificar ID en " + archivo.getName() + ": " + ex.getMessage());
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error inesperado al verificar ID en " + archivo.getName(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }   
    public boolean verificarIdLibre_SALIDA(JTextField txtID_SALIDA) {
        // **NOTA:** La ruta sigue hardcodeada.
        String ruta = "C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\SALIDA.txt";
        String idIngresado = txtID_SALIDA.getText().trim();

        if (idIngresado.isEmpty()) {
            System.err.println("El ID de salida ingresado está vacío.");
            return false;
        }
        // Validar formato numérico
        try {
            Integer.parseInt(idIngresado);
        } catch (NumberFormatException e) {
            System.err.println("El ID de salida no es un número válido: " + idIngresado);
            JOptionPane.showMessageDialog(null, "El ID de salida debe ser un número entero.", "Error de Formato", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        File archivo = new File(ruta);

        if (!archivo.exists()) {
            System.out.println("INFO: Archivo " + archivo.getName() + " no existe. Se permite el primer registro con ID: " + idIngresado);
            return true;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }
                String[] partes = linea.split(",");
                if (partes.length > 0 && partes[0].trim().equals(idIngresado)) {
                    return false; // Duplicado
                }
            }
            return true; // No duplicado

        } catch (FileNotFoundException ex) {
            System.err.println("Error FNFE: Archivo " + archivo.getName() + " no encontrado inesperadamente: " + ex.getMessage());
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error inesperado: Archivo " + archivo.getName() + " no encontrado al leer.", "Error de Archivo", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (IOException ex) {
            System.err.println("Error IOE al leer el archivo " + archivo.getName() + ": " + ex.getMessage());
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al verificar ID. No se pudo leer " + archivo.getName(), "Error de Lectura", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (Exception ex) {
            System.err.println("Error inesperado al verificar ID en " + archivo.getName() + ": " + ex.getMessage());
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error inesperado al verificar ID en " + archivo.getName(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }


    
            
    //----------------METODO PARA VERIFICAR QUE LA FECHA DE SALIDA>=FECHA DE ENTRADA-------------------------------------
    //-------------SI ES EL MISMO DIA, HORA SALIDA>HORA ENTRADA, PUEDE SER LA MISMA HORA PERO LOS MIN SALIDA>MIN ENTRADA----------

    
    public boolean validarFechaHoraSalida(JComboBox cbxENTRADA, JTextField txtFechaSalida, JTextField txtHoraSalida) {

        // --- 1. Obtener ID Entrada y Strings de Salida ---
        Object selectedItem = cbxENTRADA.getSelectedItem();
        if (selectedItem == null) {
            JOptionPane.showMessageDialog(null, "Seleccione una Entrada válida primero.",
                    "Error de Selección", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        String idEntrada = selectedItem.toString();
        String fechaSalidaStr = txtFechaSalida.getText().trim();
        String horaSalidaStr = txtHoraSalida.getText().trim();

        // --- 2. Validar Formatos Básicos ---
        if (!verificarFECHA(txtFechaSalida)) {
            return false;
        }
        if (!verificarHORA(txtHoraSalida)) {
            return false;
        }

        // --- 3. Buscar Fecha y Hora de Entrada en archivo ---
        String ruta = "C:\\Users\\MAFOWS21\\Documents\\PC's RESUELTA seccion X\\RETO DE LAS SEMANA 7 (Presentacion)\\S_G_E_V\\ENTRADA.txt"; // Ruta hardcodeada
        String fechaEntradaStr = null;
        String horaEntradaStr = null;

        // Usar File para chequear existencia (aunque no era el problema aquí, es buena práctica)
        File archivoEntrada = new File(ruta);
        if (!archivoEntrada.exists()) {
            JOptionPane.showMessageDialog(null, "Error: Archivo de entradas no encontrado.", "Error de Archivo", JOptionPane.ERROR_MESSAGE);
            return false; // No se puede verificar si el archivo no existe
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivoEntrada))) { // Usar el objeto File
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }
                String[] partes = linea.split(",");
                if (partes.length > 7 && partes[0].trim().equals(idEntrada)) {
                    fechaEntradaStr = partes[6].trim();
                    horaEntradaStr = partes[7].trim();
                    break;
                }
            }
        } catch (IOException ex) {
            /* ... manejo de error ... */ return false;
        } catch (Exception ex) {
            /* ... manejo de error ... */ return false;
        }

        if (fechaEntradaStr == null || horaEntradaStr == null) {
            JOptionPane.showMessageDialog(null, "No se encontró registro de entrada para el ID: " + idEntrada, "Error de Datos", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // --- 4. Parsear y Comparar Fechas y Horas ---
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

            LocalDate fechaEntrada = LocalDate.parse(fechaEntradaStr, dateFormatter);
            LocalDate fechaSalida = LocalDate.parse(fechaSalidaStr, dateFormatter);
            LocalTime horaEntrada = LocalTime.parse(horaEntradaStr, timeFormatter);
            LocalTime horaSalida = LocalTime.parse(horaSalidaStr, timeFormatter);

            // --- Lógica de Validación Combinada AJUSTADA ---
            // VALIDACIÓN 1: Fecha de Salida NO puede ser ANTERIOR a Fecha de Entrada
            if (fechaSalida.isBefore(fechaEntrada)) {
                JOptionPane.showMessageDialog(null,
                        "La Fecha de Salida (" + fechaSalidaStr + ") no puede ser anterior a la Fecha de Entrada (" + fechaEntradaStr + ").",
                        "Error de Fecha", JOptionPane.WARNING_MESSAGE);
                return false; // Falla validación de fecha
            }

            // VALIDACIÓN 2: Si las Fechas son IGUALES, Hora de Salida DEBE SER ESTRICTAMENTE POSTERIOR a Hora de Entrada
            // La condición de error es: (fechas iguales Y HORA SALIDA NO ES POSTERIOR A HORA ENTRADA)
            if (fechaSalida.isEqual(fechaEntrada) && !horaSalida.isAfter(horaEntrada)) {
                // Esto es verdad si horaSalida es ANTERIOR o IGUAL a horaEntrada
                JOptionPane.showMessageDialog(null,
                        "En la misma fecha (" + fechaSalidaStr + "), la Hora de Salida (" + horaSalidaStr
                        + ") debe ser estrictamente posterior a la Hora de Entrada (" + horaEntradaStr + ").",
                        "Error de Hora", JOptionPane.WARNING_MESSAGE);
                return false; // Falla validación de hora (es igual o anterior en la misma fecha)
            }

            // Si pasó ambas validaciones, es válido
            return true;

        } catch (DateTimeParseException e) {
            /* ... manejo de error ... */ return false;
        } catch (Exception e) {
            /* ... manejo de error ... */ return false;
        }
    } // Fin de validarFechaHoraSalida
    


    
    
    
    
                                                                                     
    //metodo para salir 
    public void salir(){
        System.exit(0);
    }
    
    
    

}