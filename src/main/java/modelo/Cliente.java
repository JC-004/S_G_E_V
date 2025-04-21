package modelo;
//en el modelo esta el modelo pues xd
public class Cliente extends Persona{
    
    
    int idCliente;
    String nro_licencia;
    
    //constructor vacio
    public Cliente(){
        
    }
    //constructor lleno
    
    public Cliente(int idCliente,int Nacionalidad,
            String dni,String carnetExtranjeria,
            String pasaporte,  String residencia,
            String N_A, int Sexo,
            String nro_licencia, String Telefono,
            String Correo, String Direccion,
            String Distrito) {
        super(Nacionalidad, dni, carnetExtranjeria, pasaporte, residencia, N_A, Sexo, Telefono, Correo, Direccion, Distrito);
        this.idCliente = idCliente;
        this.nro_licencia = nro_licencia;
    }
    
    
    
    
    
    //getters and setters insertados para cliente

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNro_licencia() {
        return nro_licencia;
    }

    public void setNro_licencia(String nro_licencia) {
        this.nro_licencia = nro_licencia;
    }
    
    
    
    
    
}