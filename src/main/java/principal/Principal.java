package principal;

import controller.Controlador;
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

public class Principal {
    
    /*
    Sistema de gestion de estacionamiento
    de vehiculos.
    Desarrollar un Sistema de Gestion de Parqueo/ Estacionamiento de Vehiculos
    El sistema debe permitir la operacion y mantenimiento de los siguientes
    modulos
    °tablas generales
    °vehiculos
    °empleados
    °registros E/S
    °etc...
    
    
    
    
    */
    public static void main(String[] args) {
        Vista vista = new Vista();
        vistaEMPLEADO vemp = new vistaEMPLEADO();
        vistaCLIENTE vclt = new vistaCLIENTE();
        vistaVEHICULO vhcl = new vistaVEHICULO();
        vistaENTRADA veta = new vistaENTRADA();
        vistaSALIDA vsld = new vistaSALIDA();
        //-------------
        mostrarEMPLEADOS mEMP = new mostrarEMPLEADOS();
        mostrarCLIENTES mCLT = new mostrarCLIENTES();
        mostrarVEHICULOS mvhcl = new mostrarVEHICULOS();
        mostrarENTRADAS mETA =new mostrarENTRADAS();
        mostrarSALIDAS msld = new mostrarSALIDAS();
        Controlador ctr = new Controlador(vista,vemp,vclt,vhcl,veta,vsld,mEMP,mCLT,mvhcl,mETA,msld);
        vista.setVisible(true);
    }

}