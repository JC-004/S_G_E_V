package modelo;

public class Persona {
    
    /*
    0 = no especificado
    1 = peruano,
    2 = extranjero */
    int Nacionalidad;
    
    
    
    // Documentos según nacionalidad
    String dni;               // Para peruanos
    String carnetExtranjeria; // Para extranjeros residentes
    String pasaporte;         // Para turistas u otros extranjeros que vienen de visita a nuestro pais
    
    
    //esto recibira si o no 
    String residencia;

    

    
    
    
    String N_A;
    
    
    int  Sexo; 
    /* 
    0 = masculino
    1 = femenino
    */
    
    String Telefono;
    String Correo;
    String Direccion;
    String Distrito;

    //constructor vacio
    
    public Persona(){
        
    }
    //constructor lleno

    public Persona(int Nacionalidad, String dni, 
            String carnetExtranjeria, String pasaporte,
            String residencia, String N_A, int Sexo,
            String Telefono, String Correo,
            String Direccion, String Distrito) {
        this.Nacionalidad = Nacionalidad;
        this.dni = dni;
        this.carnetExtranjeria = carnetExtranjeria;
        this.pasaporte = pasaporte;
        this.residencia = residencia;
        this.N_A = N_A;
        this.Sexo = Sexo;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Direccion = Direccion;
        this.Distrito = Distrito;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //Insertar getters and setters

    public int getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(int Nacionalidad) {
        this.Nacionalidad = Nacionalidad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCarnetExtranjeria() {
        return carnetExtranjeria;
    }

    public void setCarnetExtranjeria(String carnetExtranjeria) {
        this.carnetExtranjeria = carnetExtranjeria;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }
    
    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public String getN_A() {
        return N_A;
    }

    public void setN_A(String N_A) {
        this.N_A = N_A;
    }

    public int getSexo() {
        return Sexo;
    }

    public void setSexo(int Sexo) {
        this.Sexo = Sexo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getDistrito() {
        return Distrito;
    }

    public void setDistrito(String Distrito) {
        this.Distrito = Distrito;
    }
    
    
    
    
    
    

}