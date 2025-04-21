package modelo;

public class Vehiculo {
    
    
    int idVehiculo;
    String tipo;
    String idMARCA;//0100,0200,0300 etc..
    String modelo;
    String color;
    String nroPLACA;
    String lunasPOLARIZADAS;

    //constructor vacio
    public Vehiculo(){
        
    }
    //constructor lleno

    public Vehiculo(int idVehiculo,String tipo, String idMARCA, String modelo, String color, String nroPLACA, String lunasPOLARIZADAS) {
        this.idVehiculo = idVehiculo;
        this.tipo = tipo;
        this.idMARCA = idMARCA;
        this.modelo = modelo;
        this.color = color;
        this.nroPLACA = nroPLACA;
        this.lunasPOLARIZADAS = lunasPOLARIZADAS;
    }
    
    
    
    
    
    
    //getter and setter

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIdMARCA() {
        return idMARCA;
    }

    public void setIdMARCA(String idMARCA) {
        this.idMARCA = idMARCA;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNroPLACA() {
        return nroPLACA;
    }

    public void setNroPLACA(String nroPLACA) {
        this.nroPLACA = nroPLACA;
    }

    public String getLunasPOLARIZADAS() {
        return lunasPOLARIZADAS;
    }

    public void setLunasPOLARIZADAS(String lunasPOLARIZADAS) {
        this.lunasPOLARIZADAS = lunasPOLARIZADAS;
    }
    
    

  
    
    
    

   
    
    

}