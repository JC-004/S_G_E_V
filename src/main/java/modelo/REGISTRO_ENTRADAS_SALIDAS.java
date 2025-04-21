package modelo;

public class REGISTRO_ENTRADAS_SALIDAS {
    
    
    //cuando ingresa un vehiculo se registra su 'ENTRADA'
    int idEntrada;
    int idEmpleado1;
    int idCliente1;
    int idVehiculo1;            
    int piso;//(Piso -1,-2,0,1,2,3 )
    String zona;
    String fecha_Ingreso;
    String hora_Ingreso;
    String tipo_Documento;
    String descripcion;//DESCRIPICION (OPCIONAL)    
    
    //cuando salida un vehiculo se registra su 'SALIDA'    
    int idSalida;    
    int idEntrada2;//id de entrada
    int idEmpleado2; //id del empleado
    int idCliente2;  //id del cliente
    int idVehiculo2; //id del vehiculo
            
    String fecha_Salida; //fecha de salida
    String hora_Salida;  //hora de salida
    String descripcion2; //DESCRIPCION (OPCIONAL)
    
    
    
    //constructor vacio
    public REGISTRO_ENTRADAS_SALIDAS(){
        
    }
    //constructor lleno --> 'ENTRADA'

    public REGISTRO_ENTRADAS_SALIDAS(int idEntrada, int idEmpleado1, int idCliente1, int idVehiculo1, int piso,
            String zona, String fecha_Ingreso, String hora_Ingreso, String tipo_Documento, String descripcion) {
        this.idEntrada = idEntrada;
        this.idEmpleado1 = idEmpleado1;
        this.idCliente1 = idCliente1;
        
        this.idVehiculo1 = idVehiculo1;
        this.piso = piso;
        this.zona = zona;
        this.fecha_Ingreso = fecha_Ingreso;
        this.hora_Ingreso = hora_Ingreso;
        this.tipo_Documento = tipo_Documento;
        this.descripcion = descripcion;
    }
    //constructor lleno --> 'SALIDA'

    public REGISTRO_ENTRADAS_SALIDAS(int idSalida, int idEntrada2, int idEmpleado2, int idCliente2, int idVehiculo2, String fecha_Salida, String hora_Salida, String descripcion2) {
        this.idSalida = idSalida;
        this.idEntrada2 = idEntrada2;
        this.idEmpleado2 = idEmpleado2;
        this.idCliente2 = idCliente2;
        this.idVehiculo2 = idVehiculo2;
        this.fecha_Salida = fecha_Salida;
        this.hora_Salida = hora_Salida;
        this.descripcion2 = descripcion2;
    }
                
    
    //insertando getter and setters

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public int getIdEmpleado1() {
        return idEmpleado1;
    }

    public void setIdEmpleado1(int idEmpleado1) {
        this.idEmpleado1 = idEmpleado1;
    }

    public int getIdCliente1() {
        return idCliente1;
    }

    public void setIdCliente1(int idCliente1) {
        this.idCliente1 = idCliente1;
    }

    public int getIdVehiculo1() {
        return idVehiculo1;
    }

    public void setIdVehiculo1(int idVehiculo1) {
        this.idVehiculo1 = idVehiculo1;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getFecha_Ingreso() {
        return fecha_Ingreso;
    }

    public void setFecha_Ingreso(String fecha_Ingreso) {
        this.fecha_Ingreso = fecha_Ingreso;
    }

    public String getHora_Ingreso() {
        return hora_Ingreso;
    }

    public void setHora_Ingreso(String hora_Ingreso) {
        this.hora_Ingreso = hora_Ingreso;
    }

    public String getTipo_Documento() {
        return tipo_Documento;
    }

    public void setTipo_Documento(String tipo_Documento) {
        this.tipo_Documento = tipo_Documento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(int idSalida) {
        this.idSalida = idSalida;
    }

    public int getIdEntrada2() {
        return idEntrada2;
    }

    public void setIdEntrada2(int idEntrada2) {
        this.idEntrada2 = idEntrada2;
    }

    public int getIdEmpleado2() {
        return idEmpleado2;
    }

    public void setIdEmpleado2(int idEmpleado2) {
        this.idEmpleado2 = idEmpleado2;
    }

    public int getIdCliente2() {
        return idCliente2;
    }

    public void setIdCliente2(int idCliente2) {
        this.idCliente2 = idCliente2;
    }

    public int getIdVehiculo2() {
        return idVehiculo2;
    }

    public void setIdVehiculo2(int idVehiculo2) {
        this.idVehiculo2 = idVehiculo2;
    }

    public String getFecha_Salida() {
        return fecha_Salida;
    }

    public void setFecha_Salida(String fecha_Salida) {
        this.fecha_Salida = fecha_Salida;
    }

    public String getHora_Salida() {
        return hora_Salida;
    }

    public void setHora_Salida(String hora_Salida) {
        this.hora_Salida = hora_Salida;
    }

    public String getDescripcion2() {
        return descripcion2;
    }

    public void setDescripcion2(String descripcion2) {
        this.descripcion2 = descripcion2;
    }

    
    
    
    
   
   
    
    
    

    
    

}