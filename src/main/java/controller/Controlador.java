package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import service.Service;
import vista.Vista;
import vista.mostrarCLIENTES;
import vista.mostrarEMPLEADOS;
import vista.mostrarENTRADAS;
import vista.mostrarSALIDAS;
import vista.mostrarVEHICULOS;
import vista.vistaCLIENTE;
import vista.vistaEMPLEADO;
import vista.vistaENTRADA;
import vista.vistaSALIDA;
import vista.vistaVEHICULO;

public class Controlador implements ActionListener{
    //vista principal
    Vista vista = new Vista();    
    vistaEMPLEADO vemp = new vistaEMPLEADO();
    vistaCLIENTE vclt = new vistaCLIENTE();
    vistaVEHICULO vhcl = new vistaVEHICULO();
    vistaSALIDA vsld = new vistaSALIDA();
    //----------------------------------------
    //habilitar la vista a la tabla EMPLEADO
    mostrarEMPLEADOS mEMP = new mostrarEMPLEADOS();
    //habilitar la vista a la tabla CLIENTE
    mostrarCLIENTES mCLT = new mostrarCLIENTES();
    //habilitar la vista a la tabla VEHICULOS
    mostrarVEHICULOS mvhcl = new mostrarVEHICULOS();
    
    
    //habilitar la vista al REGISTRO DE ENTRADA VEHICULO
    vistaENTRADA veta = new vistaENTRADA();
    
    //habilitar la vista a 'mostrarENTRADAS'
    mostrarENTRADAS mETA =new mostrarENTRADAS();
    //habilitar la vista a 'mostrarSALIDAS'
    mostrarSALIDAS msld = new mostrarSALIDAS();
            
    
    Service service = new Service();
    public Controlador(Vista vista,vistaEMPLEADO vemp,vistaCLIENTE vclt,vistaVEHICULO vhcl, vistaENTRADA veta,vistaSALIDA vsld,
            mostrarEMPLEADOS mEMP ,mostrarCLIENTES mCLT, mostrarVEHICULOS mvhcl,
            mostrarENTRADAS mETA,mostrarSALIDAS msld){
        this.vista = vista;
        this.vemp = vemp;
        this.vclt = vclt;
        this.vhcl = vhcl;
        this.veta = veta;
        this.vsld = vsld;
        //instanciamos this para mostrar los empleados
        this.mEMP = mEMP;
        //instancioamos this para mostrar los clientes
        this.mCLT = mCLT;
        //instanciamos this para mostrar los vehiculos
        this.mvhcl = mvhcl;
        //instanciamos this para mostrar las entradas
        this.mETA = mETA;
        //instanciamos this para mostrar las salidas
        this.msld = msld;
        
        
        /*Habilitar las opciones a vista PRINCIPAL
        habilitar el registro de ENTRADA 'VEHICULO' */
        vista.btnREGISTRAR_ENTRADA.addActionListener(this);
        vista.btnREGISTRAR_SALIDA.addActionListener(this);
        
        
        
        
        //habilitar opciones a los menus
        vista.Empleado.addActionListener(this);        
        vista.Cliente.addActionListener(this);      
        vista.Vehiculo.addActionListener(this);
        vista.Salir.addActionListener(this);
        
        //habilitar las opciones a los menus de 'MOSTRAR'
        vista.mostrarEMPLEADOS.addActionListener(this);
        vista.mostrarCLIENTES.addActionListener(this);
        vista.mostrarVEHICULOS.addActionListener(this);
        
        
        //HABILITAR LAS OPCIONES A LA VISTA DE 'MOSTRAR EMPLEADOS'
        
        mEMP.btnREGRESAR.addActionListener(this);
        
        //HABILITAR LAS OPCIONES A LA VISTA DE 'MOSTRAR CLIENTES'
        
        mCLT.btnREGRESAR.addActionListener(this);
        
        //HABILITAR LAS OPCIONES A LA VISTA DE 'MOSTRAR VEHICULOS'
        mvhcl.btnREGRESAR.addActionListener(this);
        
        //HABILITAR LAS OPCIONES A LA VISTA DE 'MOSTRAR ENTRADAS'
        mETA.btnREGRESAR.addActionListener(this);
        //HABILITAR LAS OPCIONES A LA VISTA DE 'MOSTRAR SALIDAS'
        msld.btnREGRESAR.addActionListener(this);
        
        //--------------------------------------------------
        //habilitar las opciones a vistaEMPLEADO
        vemp.btnREGRESAR.addActionListener(this);
        vemp.btnREGISTRAR.addActionListener(this);
        
        vemp.cbxNACIONALIDAD.addActionListener(this);                        
        
        vemp.rbtnSI.addActionListener(this);
        vemp.rbtnNO.addActionListener(this);
        
        vemp.btnLIMPIAR.addActionListener(this);
        
        //---------------------------------------------------
        //habilitar las opciones a vistaCLIENTE
        
        vclt.btnREGRESAR.addActionListener(this);
        vclt.btnREGISTRAR.addActionListener(this);
        
        vclt.cbxNACIONALIDAD.addActionListener(this);
                        
        vclt.rbtnSI.addActionListener(this);
        vclt.rbtnNO.addActionListener(this);
        vclt.btnLIMPIAR.addActionListener(this);
        //---------------------------------------------------
        //habilitar las opciones a vistaVEHICULO
        vhcl.btnREGRESAR.addActionListener(this);
        vhcl.btnREGISTRAR.addActionListener(this);
        vhcl.cbxMARCA.addActionListener(this);
        vhcl.cbxMODELO.addActionListener(this);
        vhcl.btnLIMPIAR.addActionListener(this);
        
        
        //habilitar opciones a la ventana 'vistaENTRADA'
        veta.btnREGRESAR.addActionListener(this);
        veta.btnLIMPIAR.addActionListener(this);
        veta.btnREGISTRAR.addActionListener(this);
        
        
        //HABILITAR LAS OPCIONES A LA VISTA -> 'mostrarENTRADAS'
        vista.mostrarENTRADAS.addActionListener(this);
        
        
        //---------------------------------------------------
        //habilitar opciones a la ventana 'vistaSALIDA'
        vsld.btnREGISTRAR.addActionListener(this);
        vsld.btnLIMPIAR.addActionListener(this);
        vsld.btnREGRESAR.addActionListener(this);
        vsld.cbxENTRADA.addActionListener(this);
        
        //HABILITAR LAS OPCIONES A LA VISTA -> 'mostrarSALIDAS'
        vista.mostrarSALIDAS.addActionListener(this);
        
        
        
    }
    

    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //-----------------VENTANA EMPLEADO-------------------------------------                        
        //"REGISTRAR"->EMPLEADO
        if(ae.getSource() == vista.Empleado){
            vemp.setVisible(true);
            
        }        
        //----------------------------------------------------------------------
        //"cbxNACIONALIDAD" 
        else if(ae.getSource() == vemp.cbxNACIONALIDAD){
            service.verificarEMPLEADOS(vemp);
        }
        //" RADIO BOTONES 'SI' y 'NO' "
        else if(ae.getSource()== vemp.rbtnSI || ae.getSource() == vemp.rbtnNO){
            service.radioBOTONES(vemp);
        }
        
        //"btnREGRESAR"
        else if(ae.getSource() == vemp.btnREGRESAR){
              vemp.dispose();
        }//"btnREGISTRAR"        
        else if(ae.getSource() == vemp.btnREGISTRAR){
            service.verificarCAMPOS(vemp);
        }else if(ae.getSource() == vemp.btnLIMPIAR){
            service.limpiarEMPLEADO(vemp);
        }
        
        
        //-----------------VENTANA CLIENTE--------------------------------------                        
        //"REGISTRAR" ->CLIENTE
        if(ae.getSource() == vista.Cliente){
            vclt.setVisible(true);
        }
        //----------------------------------------------------------------------
        //"cbxNACIONALIDAD" 
        else if(ae.getSource() == vclt.cbxNACIONALIDAD){            
            service.verificarCLIENTES(vclt);
        }
        //" RADIO BOTONES 'SI' y 'NO' "
        else if(ae.getSource()== vclt.rbtnSI || ae.getSource() == vclt.rbtnNO){
            service.radioBOTONES(vclt);
        }
        
        //"btnREGRESAR"
        else if(ae.getSource() == vclt.btnREGRESAR){
              vclt.dispose();
        }//"btnREGISTRAR"
        else if(ae.getSource() == vclt.btnREGISTRAR){
            service.verificarCAMPOS(vclt);
        }else if(ae.getSource() == vclt.btnLIMPIAR){
            service.limpiarCLIENTE(vclt);
        }
                                
        //-----------------VENTANA VECHICULO--------------------------------------                        
        //"REGISTRAR" ->VEHICULO
        if(ae.getSource() == vista.Vehiculo){
            vhcl.setVisible(true);
        }else if(ae.getSource() == vhcl.cbxMARCA){
            service.verificarCBX_MARCA(vhcl.cbxMARCA,vhcl.cbxMODELO);
        }else if(ae.getSource() == vhcl.btnREGISTRAR){
            service.verificarCAMPOS_RVEHICULOS(vhcl);
        }
        
        else if(ae.getSource() == vhcl.btnREGRESAR){
            vhcl.dispose();
        }else if(ae.getSource() == vhcl.btnLIMPIAR){
            service.limpiarVEHICULO(vhcl);
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //-----------------MOSTRAR EMPLEADOS--------------------------------------
        if(ae.getSource() == vista.mostrarEMPLEADOS){
            service.disenoTABLA_EMPLEADOS(mEMP.tablaEMPLEADOS);
            mEMP.setVisible(true);
            
            
        }
        else if(ae.getSource() == mEMP.btnREGRESAR){
            mEMP.dispose();
        }
        
        
        //-----------------MOSTRAR CLIENTES--------------------------------------
        if(ae.getSource() == vista.mostrarCLIENTES){            
            service.disenoTABLA_CLIENTES(mCLT.tablaCLIENTES);
            mCLT.setVisible(true);
        }
        else if(ae.getSource() == mCLT.btnREGRESAR){
            mCLT.dispose();
        }
        
        
        //-----------------MOSTRAR VEHICULOS--------------------------------------
        if(ae.getSource() == vista.mostrarVEHICULOS){
            service.disenoTABLA_VEHICULOS(mvhcl.tablaVEHICULOS);
            mvhcl.setVisible(true);
        }else if(ae.getSource() == mvhcl.btnREGRESAR){
            mvhcl.dispose();
        }
        
        
        //--------------VENTANA DE REGISTRO DE 'ENTRADA'------------------
        if(ae.getSource() == vista.btnREGISTRAR_ENTRADA){
            veta.setVisible(true);
            service.cargarCOMBO_CLIENTE(veta.cbxCLIENTE);
            service.cargarCOMBO_EMPLEADO(veta.cbxEmpleado);
            service.cargarCOMBO_VEHICULO(veta.cbxVehiculo);
                                                
        }else if(ae.getSource() == veta.btnREGRESAR){
            veta.dispose();
        }else if(ae.getSource() == veta.btnLIMPIAR){
            service.limpiar_ENTRADA(veta);
            
        }else if(ae.getSource() == veta.btnREGISTRAR){
            service.verificarCAMPO_ENTRADA(veta);
        }
        
        
        //-------------------mostrarENTRADA------------
        if(ae.getSource() == vista.mostrarENTRADAS){
            service.disenoTABLA_ENTRADAS(mETA.tablaENTRADAS);
            mETA.setVisible(true);
        }else if(ae.getSource() == mETA.btnREGRESAR){
            mETA.dispose();
        }
        
        
        
        
        
        
        
        //--------------VENTANA DE REGISTRO DE 'SALIDA'------------------
        if(ae.getSource() == vista.btnREGISTRAR_SALIDA){
            vsld.setVisible(true);
            
            
            service.cargarCOMBO_EMPLEADO(vsld.cbxEmpleado);
            service.cargarCOMBO_ENTRADA(vsld.cbxENTRADA);
        }else if(ae.getSource() == vsld.cbxENTRADA){
            //aca llamar al service para poner el metodo
            //service.cargartxt_idCLIENTE(vsld.cbxVehiculo, vsld.txtCLIENTE);
            service.cargar_idVehiculo(vsld.cbxENTRADA, vsld.txtVEHICULO);
            service.cargar_idCliente(vsld.cbxENTRADA, vsld.txtCLIENTE);
                                    
        }
        else if(ae.getSource() == vsld.btnREGISTRAR){
            service.verificarCAMPOS_SALIDA(vsld);                        
                                                                        
        }else if(ae.getSource() == vsld.btnLIMPIAR){
            service.limpiarCAMPOS_SALIDA(vsld);
        }
        else if(ae.getSource() == vsld.btnREGRESAR){
            vsld.dispose();
        }
        
        
        
        
        //--------------------------------MOSTRAR SALIDAS-------------------------------
        if(ae.getSource() == vista.mostrarSALIDAS){
            service.disenoTABLA_SALIDAS(msld.tablaSALIDAS);
            msld.setVisible(true);
        }else if(ae.getSource() == msld.btnREGRESAR){
            msld.dispose();
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        

        //si el usuario hace click en el menu "REGISTRAR"->SALIR
        if(ae.getSource() == vista.Salir){
            service.salir();
            
        }
        
        
        
        
        
    }
    
    
    

}