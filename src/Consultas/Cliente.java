package Consultas;

public class Cliente {
    
    private String nombreCliente;
    private String apellidoCliente;
    private String direccionCliente;
    private int numCelular;

    public Cliente(String nombreCliente, String apellidoCliente, String direccionCliente, int numCelular) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.direccionCliente = direccionCliente;
        this.numCelular = numCelular;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public int getNumCelular() {
        return numCelular;
    }
    
    
}
