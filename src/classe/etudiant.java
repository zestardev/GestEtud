/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class etudiant {
    private static Connection c=null;
    private static Statement s=null;
    private static final ResultSet r=null;
    public static void supprimer(int id){
        try {
            c=connexionbd.seconnecter();
            s=c.createStatement();
            s.executeUpdate("DELETE FROM etudiant WHERE id="+id+"");
            JOptionPane.showMessageDialog(null,"Suppression effectuée");
            c.close();s.close();r.close();
        } catch (SQLException ex) {
            Logger.getLogger(etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void modifier(int aid,int nid){
        try {
            c=connexionbd.seconnecter();
            s=c.createStatement();
            s.executeUpdate("UPDATE etudiant SET id="+nid+" WHERE id="+aid+"");
            JOptionPane.showMessageDialog(null,"Modification effectuée");
            c.close();s.close();r.close();
        } catch (SQLException ex) {
            Logger.getLogger(etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
    
    public static void enregistrer(int id){
        try {
            c=connexionbd.seconnecter();
            s=c.createStatement();
//            pour chaine de caractere '"+taux+"'
            s.executeUpdate("INSERT INTO etudiant(id)VALUES("+id+")");
            JOptionPane.showMessageDialog(null,"Enregistrement effectué");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     public static void recuperer(int id){
        try {
            c=connexionbd.seconnecter();
            s=c.createStatement();
            s.executeUpdate("SELECT * FROM etudiant WHERE id="+id+"");
            JOptionPane.showMessageDialog(null,"Récupération effectuée avec succès");
            c.close();s.close();r.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
   } 
}
