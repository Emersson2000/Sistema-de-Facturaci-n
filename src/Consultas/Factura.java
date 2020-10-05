package Consultas;

public class Factura extends Cliente {
    
    private String fechaFactura;

    public Factura(String fechaFactura, String nombreCliente, String apellidoCliente, String direccionCliente, int numCelular) {
        super(nombreCliente, apellidoCliente, direccionCliente, numCelular);
        this.fechaFactura = fechaFactura;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }
    
}
