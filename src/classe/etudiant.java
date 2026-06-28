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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class etudiant {
    private static Connection c=null;
    private static Statement s=null;
    private static ResultSet r=null;
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
            s.executeUpdate("UPDATE etudiant SET matricule="+matricule+", nom='"+nom+"', prenom= '"+prenom+"' "+" WHERE matricule="+matricule);
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
    
     public static void actualiser(DefaultTableModel tm)
   {
       try {
           c=connexionbd.seconnecter();
           s=c.createStatement();
           r=s.executeQuery("select * from etudiant order by matricule");
           while(r.next()){
               int matricule= r.getInt("matricule");
               String nom = r.getString("nom");
               String prenom = r.getString("prenom");
               tm.addRow(new Object[]{matricule,nom,prenom});
           }
           c.close();s.close();r.close();
       } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(etudiant.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
     public static void recherche(int matricule,DefaultTableModel tm){
        try {
            c=connexionbd.seconnecter();
            s=c.createStatement();
            r=s.executeQuery("SELECT * FROM etudiant WHERE matricule="+matricule+"");
            
             if(r.next()){
            int matricul= r.getInt("matricule");
             String nom = r.getString("nom");
             String prenom = r.getString("prenom");
             
             tm.addRow(new Object[]{matricul,nom,prenom});
             }
             else{
                  JOptionPane.showMessageDialog(null,"Cet étudiant n'exite pas !");
             }
             
            
            
           
            
            c.close();s.close();r.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
   } 
     
}
