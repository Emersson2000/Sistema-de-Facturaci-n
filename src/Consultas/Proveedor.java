package Consultas;

import java.util.ArrayList;

public class Proveedor {
    
    private String nombre;
    private String Apellido;
    private String nombreEmpresa;
    private String numCelular;
    private int nunActualCategoria = 0;
    ArrayList<Categoria> listaCategorias;

    public Proveedor(String nombre, String Apellido, String nombreEmpresa, String numCelular) {
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.nombreEmpresa = nombreEmpresa;
        this.numCelular = numCelular;
        listaCategorias = new ArrayList<>();
    }
    
    public void setInsertarCategoria(String categoria) {
        Categoria nuevo = new Categoria(categoria);
        this.listaCategorias.add(nuevo);
        nunActualCategoria++;
    }

    public int getNunActualCategoria() {
        return nunActualCategoria;
    }
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getNumCelular() {
        return numCelular;
    }

    public ArrayList<Categoria> getListaCategorias() {
        return listaCategorias;
    }
    
    public Categoria getMostrarCategoria(int i) {
        return listaCategorias.get(i);
    }
    
    public Categoria getMostrarCategoria(String nombreCategoria) {
        boolean encontrado = false;
        int i = 0;
        Categoria cate = null;
        
        while ((!encontrado) && (i < listaCategorias.size())) {
            if (nombreCategoria.equals(listaCategorias.get(i))) {
                encontrado = true;
                cate = listaCategorias.get(i);
            }
            i++;
        }
        return cate;
    }
    
}
