package Consultas;

import java.util.ArrayList;

public class Producto {
    
    private String nombre;
    private double precio;
    private int cantidad;
    private ArrayList<Producto> listaProductos = new ArrayList<Producto>();

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }
    
    }
    
    
    
    
 
