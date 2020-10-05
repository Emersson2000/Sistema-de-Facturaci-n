package Consultas;

import static Consultas.Conexion_BD_Principal.con;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {

    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Proveedor> proveedor = new ArrayList<Proveedor>();
    static ArrayList<Categoria> categoria = new ArrayList<Categoria>();
    static int contador = 0, numeroPro = 0, numeroCat = 0;
    static ArrayList<Float> precio = new ArrayList<Float>();
    public static void main(String[] args) {
        Conexion_BD_Principal llamar = new Conexion_BD_Principal();
        llamar.conectar();
//        insertar(proveedor);
        menu(proveedor);

    }

    public static void insertar(ArrayList<Proveedor> proveedor) {
        proveedor.add(new Proveedor("Jaime", "Velez", "EVON", "0986358542"));
        proveedor.get(contador).setInsertarCategoria("Perfumes");
        proveedor.get(contador).setInsertarCategoria("Labial");
        proveedor.get(contador).getMostrarCategoria(contador).setInsertarProducto(new Producto("Agradable", 3, 4));
        proveedor.get(contador).getMostrarCategoria(contador).setInsertarProducto(new Producto("MMM", 20, 2));
        proveedor.add(new Proveedor("Pedro", "Velez", "EVON", "0986358542"));
        contador++;
        proveedor.get(contador).setInsertarCategoria("Perfumess");
        proveedor.get(contador).setInsertarCategoria("Labial");
        proveedor.get(contador).getMostrarCategoria(contador).setInsertarProducto(new Producto("Labiel Frescura", 3, 4));
        proveedor.get(contador).getMostrarCategoria(contador).setInsertarProducto(new Producto("Labi fresh", 20, 2));

    }

    public static void menu(ArrayList<Proveedor> proveedor) {
        int opcion, categoria;
         
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("\t.:MENU:."
                    + "\n*1. Agregar Proveedor"
                    + "\n*2. Agregar Categoria"
                    + "\n*3. Agregar Producto"
                    + "\n*4. Mostrar Proveedores"
                    + "\n*5. Mostrar Categorias"
                    + "\n*6. Mostrar Productos"
                    + "\n*7. Ver los precios"
                    + "\n*8. Realizar Factura"
                    + "\n*9. Salir"));
            
//            System.out.println("\t.:MENU:.");
//            System.out.println("*1. Agregar Proveedor");
//            System.out.println("*2. Agregar Categoria");
//            System.out.println("*3. Agregar Producto");
//            System.out.println("*4. Mostrar Proveedores");
//            System.out.println("*5. Mostrar Categorias");
//            System.out.println("*6. Mostrar Productos");
//            System.out.println("*7. Salir");
//            System.out.print("Opción: ");
//            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("");
                    insertarProveedor(proveedor);
                    break;
                case 2:
                    System.out.println("");
                    insertarCategoria(proveedor);
                case 3:
                    System.out.println("");
                    datosProducto(proveedor);
                    break;
                case 4:
                    System.out.println("");
                    Proveedores(con);
                    break;
                case 5:
                    System.out.println("");
                    Categoria(con);
                    break;

                case 6:
                    System.out.println("");
                    Producto(con);
                    break;
                case 7:
                    System.out.println("");
                    verPrecios();
                    break;
                case 8:
                    System.out.println("");
                    CategoriaLista(con);
                    System.out.print("Opción: ");
                    categoria = entrada.nextInt();
                    break;
            }
        } while (opcion != 9);

    }

    public static void insertarProveedor(ArrayList<Proveedor> proveedor) {
        String nombre, apellido, empresa, numCelular;
        entrada.nextLine();
        System.out.print("Ingrese el nombre: ");
        nombre = entrada.nextLine();
        System.out.print("Ingrese el Apellido: ");
        apellido = entrada.nextLine();
        System.out.print("Ingrese el nombre de la Empresa: ");
        empresa = entrada.nextLine();
        System.out.print("Ingrese el número de celular: ");
        numCelular = entrada.nextLine();
        Proveedor prove = new Proveedor(nombre, apellido, empresa, numCelular);
        proveedor.add(prove);
        contador++;

    }
    public static void verPrecios() {
        for (int i = 0; i < precio.size(); i++) {
            System.out.println(precio.get(i));
        }
    }

    public static void Producto(Connection con) {
        Connection Connection = null;
        try {
            String SQL = "SELECT * FROM producto";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            System.out.println("--PRODUCTOS--");

            while (rs.next()) {
                precio.add(rs.getFloat("idCategoria"));
                System.out.println(rs.getString("nombre"));
                System.out.println("");
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void CategoriaLista(Connection con) {
        Connection Connection = null;
        int opcion;
        try {
            String SQL = "SELECT * FROM categoria";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            System.out.println("--CATEGORIA--");

            while (rs.next()) {
                
                System.out.println(rs.getString("idCategoria")+"   "+rs.getString("nombre"));
                System.out.println("");
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Proveedores(Connection con) {
        Connection Connection = null;
        try {
            String SQL = "SELECT * FROM proveedor";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            System.out.println("---PROVEEDORES---");
            System.out.println("Nombre---Apellido---Empresa");

            while (rs.next()) {

                System.out.println(rs.getString("nombre") + " " + rs.getString("apellido") + " ---> " + rs.getString("nombre_empresa"));
                System.out.println("");
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Categoria(Connection con) {
        Connection Connection = null;
        try {
            String SQL = "SELECT * FROM categoria";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            System.out.println("---CATEGORIAS---");
            while (rs.next()) {

                System.out.println(rs.getString("nombre"));
                System.out.println("");
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean verificarProveedor(ArrayList<Proveedor> proveedor, String nombrePro) {
        boolean encontrado = false;
        int i = 0;

        while ((!encontrado) && (i < proveedor.size())) {
            if (nombrePro.equals(proveedor.get(i).getNombre())) {
                encontrado = true;
                numeroPro = i;
            }
            i++;
        }
        return encontrado;
    }

    public static boolean verificarCategoria(ArrayList<Proveedor> proveedor, String nombrePro) {
        boolean encontrado = false;
        int i = 0;

        while ((!encontrado) && (i < proveedor.size())) {
            for (int j = 0; j < proveedor.get(i).getNunActualCategoria(); j++) {
                if (nombrePro.equals(proveedor.get(i).getMostrarCategoria(j).getNombreCategoria())) {
                    encontrado = true;
                    numeroCat = i;
                }
            }
            i++;
        }
        return encontrado;
    }

    public static void datosProducto(ArrayList<Proveedor> proveedor) {
        String nombre, categoria;

        entrada.nextLine();
        System.out.print("Ingrese el nombre del Proveedor: ");
        nombre = entrada.nextLine();
        if (verificarProveedor(proveedor, nombre) == false) {
            System.out.println("El proveedor no existe");
        } else {
            System.out.print("Ingrese el nombre del Articulo: ");
            categoria = entrada.nextLine();
            if (verificarCategoria(proveedor, categoria) == false) {
                System.out.println("La categoria no existe");
            } else {
                insertarProducto(proveedor);
                System.out.println("");
            }

        }
    }

    public static void insertarProducto(ArrayList<Proveedor> proveedor) {
        String nombre;
        double precio;
        int cantidad;

        System.out.println("Ingrese el nombre del producto: ");
        nombre = entrada.nextLine();
        System.out.println("Ingrese el precio del producto: ");
        precio = entrada.nextDouble();
        System.out.println("Ingrese la cantidad del producto: ");
        cantidad = entrada.nextInt();
        proveedor.get(numeroPro).getMostrarCategoria(numeroCat).setInsertarProducto(new Producto(nombre, precio, cantidad));
    }

    public static void insertarCategoria(ArrayList<Proveedor> proveedor) {
        Categoria nombre = null;
        Proveedor pro;
        String categoria;
        boolean correct = false;
        int opcion;
        entrada.nextLine();
        System.out.print("Ingrese el nombre de la categoria: ");
        categoria = entrada.nextLine();

        do {
            System.out.println("\n1. Agregar un nuevo Proveedor");
            System.out.println("2. Proveedor existente");
            System.out.print("Opción: ");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    insertarProveedor(proveedor);
                    proveedor.get(contador).setInsertarCategoria(categoria);
                    correct = true;
                    break;
                case 2:
                    System.out.println("\nTiene los siguientes proveedores: \n");
                    for (int i = 0; i < proveedor.size(); i++) {
                        System.out.println((i + 1) + ". " + proveedor.get(i).getNombre());
                    }
                    System.out.print("Que proveedor desea: ");
                    opcion = entrada.nextInt();
                    proveedor.get(opcion - 1).setInsertarCategoria(categoria);

                    correct = true;
                    break;
            }

        } while (!correct);
    }

    public static void mostrarCategorias(ArrayList<Proveedor> proveedor) {
        for (int i = 0; i < proveedor.size(); i++) {
            for (int j = 0; j < proveedor.get(i).getNunActualCategoria(); j++) {
                System.out.println(proveedor.get(i).getMostrarCategoria(j).getNombreCategoria());
            }
        }
    }

    public static void mostrarProductos(ArrayList<Proveedor> proveedor) {
        Producto producto[];
        for (int i = 0; i < proveedor.size(); i++) {
            for (int j = 0; j < proveedor.get(i).getNunActualCategoria(); j++) {
                for (int k = 0; k < proveedor.get(i).getMostrarCategoria(j).getNumActualProducto(); k++) {
                    System.out.println(proveedor.get(i).getMostrarCategoria(j).getMostrarProducto(k).getNombre());
                }

            }
        }
    }
}
