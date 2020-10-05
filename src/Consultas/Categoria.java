package Consultas;

import java.util.ArrayList;

public class Categoria {
    
    private String nombreCategoria;
    private ArrayList<Producto> listaProducto;
    private int numActualProducto = 0;
    
    public Categoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
        listaProducto = new ArrayList<>();
        
        
    }
    
    public String getNombreCategoria() {
        return nombreCategoria;
    }
    
    public void setInsertarProducto(Producto producto) {
        listaProducto.add(producto);
        numActualProducto++;
    }
    
    public int getNumActualProducto() {
        return numActualProducto;
    }
    
    public Producto getMostrarProducto(int i) {
        return listaProducto.get(i);
    }
    
    public Producto getMostrarProducto(String nombreEmpresa) {
        boolean encontrado = false;
        int i = 0;
        Producto prove = null;
        
        while ((!encontrado) && (i < listaProducto.size())) {
            if (nombreEmpresa.equals(listaProducto.get(i))) {
                encontrado = true;
                prove = listaProducto.get(i);
            }
            i++;
        }
        return prove;
    }
}
