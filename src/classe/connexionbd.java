/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe;
import java.sql.*;

/**
 *
 * @author abdel
 */
public class connexionbd {
    private static Connection c=null;
    public static Connection seconnecter() throws ClassNotFoundException, SQLException{
//        charger le pilote
        Class.forName("com.mysql.cj.jdbc.Driver");
//        Etablir la connection
        c=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestetud","root","");
        return c;
    }
    
}
