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
    public static void supprimer(int matricule) throws ClassNotFoundException{
        try {
            c=connexionbd.seconnecter();
            s=c.createStatement();
            s.executeUpdate("DELETE FROM etudiant WHERE matricule="+matricule+"");
            JOptionPane.showMessageDialog(null,"Suppression effectuée");
            c.close();s.close();r.close();
        } catch (SQLException ex) {
            Logger.getLogger(etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void modifier(int matricule,String nom,String prenom) throws ClassNotFoundException{
        try {
            c=connexionbd.seconnecter();
            s=c.createStatement();
            s.executeUpdate("UPDATE etudiant SET matricule="+matricule+" nom="+nom+" prenom= "+prenom+"  WHERE matricule="+matricule+"");
            JOptionPane.showMessageDialog(null,"Modification effectuée");
            c.close();s.close();r.close();
        } catch (SQLException ex) {
            Logger.getLogger(etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
    
    public static void enregistrer(int matricule,String nom,String prenom){
        try {
            c=connexionbd.seconnecter();
            s=c.createStatement();
               
            s.executeUpdate("INSERT INTO etudiant(nom,prenom,matricule) VALUES('"+nom+"','"+prenom+"',"+matricule+")");
            JOptionPane.showMessageDialog(null,"Enregistrement effectué");
            c.close();s.close();r.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     public static void recuperer(int matricule){
        try {
            c=connexionbd.seconnecter();
            s=c.createStatement();
            s.executeQuery("SELECT * FROM etudiant WHERE matricule="+matricule+"");
            JOptionPane.showMessageDialog(null,"Récupération effectuée avec succès");
            c.close();s.close();r.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
   } 
     public static void recherche(int matricule,String nom,String prenom){
        try {
            c=connexionbd.seconnecter();
            s=c.createStatement();
            s.executeQuery("SELECT * FROM etudiant WHERE matricule="+matricule+"");
            JOptionPane.showMessageDialog(null,"Récupération effectuée avec succès");
            c.close();s.close();r.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
   } 
     
}
