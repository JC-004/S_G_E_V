package modelo;

public class Empleado extends Persona{
    
    
    
    int idEmpleado;
    String fecha_nacimiento;
    
    //constructor vacio
    public Empleado(){
        
    }
    //constructor con parametros

    public Empleado(int idEmpleado,int Nacionalidad,
            String dni,String carnetExtranjeria,
            String pasaporte,  String residencia,
            String N_A, int Sexo,
            String fecha_nacimiento, String Telefono,
            String Correo, String Direccion,
            String Distrito) {
        super(Nacionalidad, dni, carnetExtranjeria, pasaporte, residencia, N_A, Sexo, Telefono, Correo, Direccion, Distrito);
        this.idEmpleado = idEmpleado;
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //Getters and setters insertados para empleados
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
    
    
    
    
    
    
    

}