package Consultas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion_BD_Principal {

    protected static Connection con;
    //declaramos los dadtos de conexion
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "0986358542";
    private static final String url = "jdbc:mysql://localhost:3306/jackiss? useUnicode=true&use"
            + " JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public void conectar() {
        //reseteamos null a la conexion de la BD
        con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //conexion a la BD
            con = (Connection) DriverManager.getConnection(url, user, pass);
            //comprobacion
            if (con != null) {
                JOptionPane.showMessageDialog(null, "CONEXION EXITOSA!!");

            }
            //mensaje de error
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e);
        }
    }
}
